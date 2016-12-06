import java.util.Properties

import com.home.mysqldata.{Analyzer1, Transfer}

import org.apache.spark.ml.feature.{HashingTF, IDF, Tokenizer}
import org.apache.spark.mllib.classification.NaiveBayes
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{DataFrame, Row, SQLContext}

import scala.util.Properties

/**
  * Created by root on 16-4-17.
  */
/**
  * 真正测试的代码
  */
object MysqlDataTest {
  case class RawDataRecord(category: String, text: String)
  def main(args: Array[String]) {


    val config = new SparkConf().setAppName("mysql").setMaster("local")
    val sc = new SparkContext(config)
    val sqlContetx = new SQLContext(sc)
    import sqlContetx.implicits._


    //    var srcRDD = sc.textFile("/home/zhujun/下载/fenci/").map {
    //      x =>
    //        var data = x.split(","
    //        RawDataRecord(data(0), data(1))
    //    }
    val jdbcDF = sqlContetx.read.format("jdbc").options(Map("url" -> "jdbc:mysql://192.168.20.50:3306/url?user=root&password=root", "dbtable" -> "tb_parser")).load()
    jdbcDF.registerTempTable("records")
    val zhujun = sqlContetx.sql("select text from records where id < 1761" )

    var srcRDD = zhujun.map {
      x =>
        var data = x.toString().split(",")
        RawDataRecord(data(0).replace("[", ""), data(1).replace("]", ""))
    }
    val splits = srcRDD.randomSplit(Array(0.7, 0.3))
    var trainingDF = splits(0).toDF()
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
    var exit = false
    while (!exit) {


      var indexurl = 20

      print("请输入要查询的url:")
      var url = Console.readLine()

      val jdbcDF = sqlContetx.read.format("jdbc").options(Map("url" -> "jdbc:mysql://192.168.20.50:3306/url?user=root&password=root", "dbtable" -> "tb_6655")).load()
      jdbcDF.registerTempTable("records")
      val urlArray = url.split("/")
      val count = urlArray.length
      var z:Array[String] = new Array[String](count)
      z(0) = url

      for(j <- 1 to count-1 )
      {

        //z(j) = url.replace("/"+urlArray(count-1), "")
        z(j) = z(j-1).replace("/"+urlArray(count-j), "")

      }

      for(k <- 0 to z.length-2)
      {

        if(sqlContetx.sql("select tag2 from records where url like '" + z(k) + "%'").count() > 0 && indexurl > k)
        {

          indexurl = k

        }


      }

      //      val jdbcDF = sqlContetx.read.format("jdbc").options(Map("url" -> "jdbc:mysql://192.168.20.50:3306/url?user=root&password=root", "dbtable" -> "tb_6655")).load()
      //      jdbcDF.registerTempTable("records")
      //      try {
      //        val zhujun = sqlContetx.sql("select tag2 from records where url like '" + url + "'").take(1).apply(0)
      //        println(url + "----->" + zhujun)
      //        println("退出不查询请输入true,继续查询请输入false:")
      //        exit = Console.readBoolean()
      //
      //      }
      //      catch {
      //        // http://m.fashion.67.com/
      //        case e: Exception => println("数据库没有匹配的url,使用分类器......")
      //      }
      if(indexurl != 20)
      {
        println("在数据库里面:"+url+"---------->"+sqlContetx.sql("select tag2 from records where url like '" + z(indexurl) + "%'").take(1).apply(0))


      }
      else{


        var transfer = new Transfer(url)
        var body = transfer.getBody()
        var  analyzer1 = new Analyzer1(body)
        var analyserwords = analyzer1.endAnalyzer()
        var analyzer11 = analyserwords.split(",")(0)
        var analyzer22 = analyserwords.split(",")(1)
        var srcRDD2 = sqlContetx.createDataFrame(Seq((analyzer11, analyzer22))).toDF("category", "text")

        var wordsData2 = tokenizer.transform(srcRDD2)
        var featureData2 = hashingTF.transform(wordsData2)
        var rescalData2 = idfModel.transform(featureData2)
        var trainData2 = rescalData2.select($"category",$"features").map {
          case Row(label: String, features: Vector) =>
            LabeledPoint(label.toDouble, Vectors.dense(features.toArray))
        }

        var map1 = scala.collection.mutable.Map(("1.0", 0), ("2.0", 0), ("3.0", 0), ("4.0", 0), ("5.0", 0), ("6.0", 0), ("7.0", 0), ("8.0", 0), ("9.0", 0), ("10.0", 0), ("11.0", 0))
        var map2 = scala.collection.immutable.Map(("1.0", "音乐"), ("2.0", "游戏"), ("3.0", "明星"), ("4.0", "交友"), ("5.0","笑话"), ("6.0", "动漫"), ("7.0", "星座"), ("8.0", "小说"), ("9.0", "体育"), ("10.0", "NBA"),("11.0", "足球"))

        for(i <- 1 to 10)
        {
          var predictLabel = trainData2.map(p =>(model.predict(p.features)))
          var classes = predictLabel.collect().take(1).apply(0)
          map1(classes.toString)=map1(classes.toString)+1
        }

        var index="9.0"
        var tmp =0
        for((k, v) <- map1)
        {

          if(v > tmp)
          {
            tmp = v
            index = k


          }
        }
        println("使用分类器:")
        println(url+"----->"+map2(index))
      }

      print("退出不查询请输入true,继续查询请输入false:")
      exit = Console.readBoolean()

      //}

    }


  }
}