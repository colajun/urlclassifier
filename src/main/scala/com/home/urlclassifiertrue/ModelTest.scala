package com.home.urlclassifiertrue

import com.lxw1234.textclassification.TestNativeBayes.RawDataRecord
import org.apache.spark.ml.feature.{HashingTF, IDF, Tokenizer}
import org.apache.spark.mllib.classification.{LogisticRegressionWithLBFGS, NaiveBayes, NaiveBayesModel}
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.mllib.regression.{GeneralizedLinearModel, LabeledPoint}
import org.apache.spark.mllib.tree.DecisionTree
import org.apache.spark.mllib.tree.model.DecisionTreeModel
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Row, SQLContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by hadoop on 16-11-1.
  */
object ModelTest {
  def practiceAndGetModel(sQLContext: SQLContext,id: Int): NaiveBayesModel ={

    val sqlContext = sQLContext
    import  sQLContext.implicits._

    val jdbcDF = sqlContext.read.format("jdbc").options(Map("url" -> "jdbc:mysql://192.168.20.50:3306/url?user=root&password=root", "dbtable" -> "tb_parser2")).load()
    jdbcDF.registerTempTable("records")
    val text = sqlContext.sql("select text from records where id<"+id ).distinct()


    var srcRDD = text.map {
      x =>
        var data = x.toString().split(",")
        RawDataRecord(data(0).replace("[", ""), data(1).replace("]", ""))
    }.toDF()

    var tokenizer = new Tokenizer().setInputCol("text").setOutputCol("words")
    var wordsData = tokenizer.transform(srcRDD)
    var hashingTF = new HashingTF().setNumFeatures(50000).setInputCol("words").setOutputCol("rawFeatures")
    var featurizedData = hashingTF.transform(wordsData)
    var idf = new IDF().setInputCol("rawFeatures").setOutputCol("features")
    var idfModel = idf.fit(featurizedData)
    var rescaledData = idfModel.transform(featurizedData)
    var trainDataRdd = rescaledData.select($"category", $"features").map {
      case Row(label: String, features: Vector) =>
        LabeledPoint(label.toDouble-1.0, Vectors.dense(features.toArray))
    }
    val model = NaiveBayes.train(trainDataRdd, lambda = 1.0, modelType = "multinomial")

//    val model = new LogisticRegressionWithLBFGS()
//      .setNumClasses(10)
//      .run(trainDataRdd)
//    val numClasses = 10
//    val categoricalFeaturesInfo = Map[Int, Int]()
//    val impurity = "gini"
//    val maxDepth = 5
//    val maxBins = 32
//    val model = DecisionTree.trainClassifier(trainDataRdd, numClasses, categoricalFeaturesInfo, impurity, maxDepth, maxBins)
//
    model
  }

  def getFormatData(sQLContext: SQLContext, id: Int): RDD[LabeledPoint] ={
    val sqlContext = sQLContext
    import  sQLContext.implicits._



    val jdbcDF = sqlContext.read.format("jdbc").options(Map("url" -> "jdbc:mysql://192.168.20.50:3306/url?user=root&password=root", "dbtable" -> "tb_parser2")).load()
    jdbcDF.registerTempTable("records")
    val text = sqlContext.sql("select text from records where id>="+id+" and id <="+(id+1)).distinct()


    var srcRDD = text.map {
      x =>
        var data = x.toString().split(",")
        RawDataRecord(data(0).replace("[", ""), data(1).replace("]", ""))
    }.toDF()

    var tokenizer = new Tokenizer().setInputCol("text").setOutputCol("words")
    var wordsData = tokenizer.transform(srcRDD)
    var hashingTF = new HashingTF().setNumFeatures(50000).setInputCol("words").setOutputCol("rawFeatures")
    var featurizedData = hashingTF.transform(wordsData)
    var idf = new IDF().setInputCol("rawFeatures").setOutputCol("features")
    var idfModel = idf.fit(featurizedData)
    var rescaledData = idfModel.transform(featurizedData)
    var trainDataRdd = rescaledData.select($"category", $"features").map {
      case Row(label: String, features: Vector) =>
        LabeledPoint(label.toDouble, Vectors.dense(features.toArray))
    }
    trainDataRdd
  }



  def main(args: Array[String]): Unit = {


   val conf = new SparkConf().setAppName("modeltest").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)

////    println("请输入模型训练的数据id:")
////    val id1 = Console.readInt()
//    val model = ModelTest.practiceAndGetModel(sqlContext, id1)
    val model = NaiveBayesModel.load(sc, "/home/hadoop/modelsave/model1")
    var id2 = 100
    var exit = false
    while (!exit){
      println("请输入查询的id号:")
      id2 = Console.readInt()

      val testDataRdd = ModelTest.getFormatData(sqlContext, id2)
      val testpredictionAndLabel = testDataRdd.map(p => (model.predict(p.features), p.label))
//     testpredictionAndLabel.foreach(println)
      val label = testpredictionAndLabel.first()._1
      println("预测为:"+label)
      println("继续输入false，其他输入退出")
      exit = Console.readBoolean()
    }

//    val testDataRdd = ModelTest.getFormatData(sqlContext, id2)
//    val testpredictionAndLabel = testDataRdd.map(p => (model.predict(p.features), p.label))
//
//    var testaccuracy = 1.0 * testpredictionAndLabel.filter(x => x._1 == x._2).count() / testDataRdd.count()
//    println("output5：")
//    println(testaccuracy)
//
//    testpredictionAndLabel.take(20).foreach(println)

  }

}
