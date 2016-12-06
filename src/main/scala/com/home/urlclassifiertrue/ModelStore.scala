package com.home.urlclassifiertrue

import com.lxw1234.textclassification.TestNativeBayes.RawDataRecord
import org.apache.spark.ml.feature.{HashingTF, IDF, Tokenizer}
import org.apache.spark.mllib.classification.{NaiveBayes, NaiveBayesModel}
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by hadoop on 16-10-30.
  */
object ModelStore {
  case class RawDataRecord(category: String, text: String)
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("modelstore").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import  sqlContext.implicits._

    val jdbcDF = sqlContext.read.format("jdbc").options(Map("url" -> "jdbc:mysql://192.168.20.50:3306/url?user=root&password=root", "dbtable" -> "tb_parser2")).load()
    jdbcDF.registerTempTable("records")
    val text = sqlContext.sql("select text from records" ).distinct()


    var srcRDD = text.map {
      x =>
        var data = x.toString().split(",")
        RawDataRecord(data(0).replace("[", ""), data(1).replace("]", ""))
    }

    var trainingDF = srcRDD.toDF()
    var tokenizer = new Tokenizer().setInputCol("text").setOutputCol("words")
    var wordsData = tokenizer.transform(trainingDF)
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

   model.save(sc, "/home/hadoop/modelsave/model1")












  }

}
