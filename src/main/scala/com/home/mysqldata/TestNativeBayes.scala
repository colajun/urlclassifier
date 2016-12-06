package com.lxw1234.textclassification

/**
  * Created by root on 16-4-7.
  */


import java.util

import com.home.mysqldata.MysqlUrlParser.RawDataRecord
import com.home.urlclassifiertrue.ModelStore.RawDataRecord

import scala.reflect.runtime.universe
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.ml.feature.{HashingTF, IDF, StringIndexer, Tokenizer}
import org.apache.spark.mllib.classification.{NaiveBayes, NaiveBayesModel}
import org.apache.spark.mllib.linalg.Vector
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.sql.Row


/**
  * 朴素贝贝叶斯分类算法测试
  */
//output5：
//0.7853011228308948

object TestNativeBayes {

  case class RawDataRecord(category: String, text: String)

  def main(args : Array[String]) {

    val conf = new SparkConf().setAppName("zhujun1").setMaster("local")
    val sc = new SparkContext(conf)

    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    import sqlContext.implicits._

    //    var srcRDD = sc.textFile("/home/zhujun/下载/fenci2/").map {
    //      x =>
    //        var data = x.split(",")
    //        RawDataRecord(data(0),data(1))
    //    }

    val jdbcDF = sqlContext.read.format("jdbc").options(Map("url" -> "jdbc:mysql://192.168.20.50:3306/url?user=root&password=root", "dbtable" -> "tb_parser2")).load()
    jdbcDF.registerTempTable("records")
    val text = sqlContext.sql("select text from records" ).distinct()


    var srcRDD = text.map {
      x =>
        var data = x.toString().split(",")
        RawDataRecord(data(0).replace("[", ""), data(1).replace("]", ""))
    }.toDF()
    val split = srcRDD.randomSplit(Array(0.7, 0.3))
  val trainSet = split(0).toDF()
    val testDF = split(1).toDF()

    var tokenizer = new Tokenizer().setInputCol("text").setOutputCol("words")
    var wordsData = tokenizer.transform(trainSet)
    var hashingTF = new HashingTF().setNumFeatures(50000).setInputCol("words").setOutputCol("rawFeatures")
    var featurizedData = hashingTF.transform(wordsData)
    var idf = new IDF().setInputCol("rawFeatures").setOutputCol("features")
    var idfModel = idf.fit(featurizedData)
    var rescaledData = idfModel.transform(featurizedData)
    var trainDataRdd = rescaledData.select($"category", $"features").map {
      case Row(label: String, features: Vector) =>
        LabeledPoint(label.toDouble, Vectors.dense(features.toArray))
    }
    val model = NaiveBayes.train(trainDataRdd, lambda = 1.0, modelType = "multinomial")


    //测试数据集，做同样的特征表示及格式转换
    var testwordsData = tokenizer.transform(testDF)
    var testfeaturizedData = hashingTF.transform(testwordsData)
    var testrescaledData = idfModel.transform(testfeaturizedData)
    var testDataRdd = testrescaledData.select($"category",$"features").map {
      case Row(label: String, features: Vector) =>
        LabeledPoint(label.toDouble, Vectors.dense(features.toArray))
    }

    //对测试数据集使用训练模型进行分类预测
    val testpredictionAndLabel = testDataRdd.map(p => (model.predict(p.features), p.label,p))
    //  val classes = predictLabel.collect().take(1).apply(0)
    //   if(classes == 1.0)
    //     {
    //
    //
    //       println("金融")
    //
    //     }

    //统计分类准确率
    var testaccuracy = 1.0 * testpredictionAndLabel.filter(x => x._1 == x._2).count() / testDataRdd.count()
    println("output5：")
    println(testaccuracy)
//    0.7359659364054667
  }
}