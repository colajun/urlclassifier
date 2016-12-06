package com.home.urlclassifiertrue

import com.home.mysqldata.{Analyzer1, Transfer}
import com.home.spring.JDBCHelper
import org.apache.spark.ml.feature.{HashingTF, IDF, Tokenizer}
import org.apache.spark.mllib.classification.NaiveBayesModel
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Row, SQLContext}

/**
  * Created by hadoop on 16-11-2.
  */
class UrlClassifier extends Serializable{
  case class RawDataRecord(category: String, text: String)
//  val template= JDBCHelper.createMysqlTemplate("mysqlclassifier", "jdbc:mysql://192.168.20.50/url?useUnicode=true&characterEncoding=utf8", "root", "root", 5, 30)


//  def getOne(id: Int): String ={
//    //    val template = JDBCHelper.createMysqlTemplate("mysql1", "jdbc:mysql://192.168.20.50/url?useUnicode=true&characterEncoding=utf8", "root", "root", 5, 30);
//    ////    val resultSet = template.execute("select category, url from tb_parser2 where url like "+url)
//
//    val resultSet = template.queryForList("select text from tb_parser2 where id = "+id)
//    val it = resultSet.iterator()
//    val text=it.next().get("text").toString
//    text
//  }
//
  def get(analyserwords: String, sQLContext: SQLContext, id: Int): RDD[LabeledPoint] ={
  val sqlContext = sQLContext
  import  sQLContext.implicits._

  val jdbcDF = sqlContext.read.format("jdbc").options(Map("url" -> "jdbc:mysql://192.168.20.50:3306/url?user=root&password=root", "dbtable" -> "tb_parser2")).load()
  jdbcDF.registerTempTable("records")
  val text = sqlContext.sql("select text from records where id>="+id+" and id <="+(id+2)).distinct()


  val srcRDD = text.map {
    x =>
      var data = x.toString().split(",")
      RawDataRecord(data(0).replace("[", ""), data(1).replace("]", ""))
  }.toDF()

    var analyzer11 = analyserwords.split(",")(0)
    var analyzer22 = analyserwords.split(",")(1)
    var srcRDD2 = sQLContext.createDataFrame(Seq((analyzer11, analyzer22))).toDF("category", "text").unionAll(srcRDD)

    var tokenizer = new Tokenizer().setInputCol("text").setOutputCol("words")
    var wordsData2 = tokenizer.transform(srcRDD2)
    var hashingTF = new HashingTF().setNumFeatures(50000).setInputCol("words").setOutputCol("rawFeatures")
    var featurizedData2 = hashingTF.transform(wordsData2)
    var idf = new IDF().setInputCol("rawFeatures").setOutputCol("features")
    var idfModel = idf.fit(featurizedData2)
    var rescalData2 = idfModel.transform(featurizedData2)

    val  trainData2 = rescalData2.select($"category",$"features").map {
      case Row(label: String, features: Vector) =>
        LabeledPoint(label.toDouble, Vectors.dense(features.toArray))
    }



    trainData2

  }




//  def getFormatData(sQLContext: SQLContext, id: Int): RDD[LabeledPoint] ={
//    val sqlContext = sQLContext
//    import  sQLContext.implicits._
//
//    val jdbcDF = sqlContext.read.format("jdbc").options(Map("url" -> "jdbc:mysql://192.168.20.50:3306/url?user=root&password=root", "dbtable" -> "tb_parser2")).load()
//    jdbcDF.registerTempTable("records")
//    val text = sqlContext.sql("select text from records where id>="+id+" and id <="+(id+2)).distinct()
//
//
//    val srcRDD = text.map {
//      x =>
//        var data = x.toString().split(",")
//        RawDataRecord(data(0).replace("[", ""), data(1).replace("]", ""))
//    }.toDF()
//
//    var tokenizer = new Tokenizer().setInputCol("text").setOutputCol("words")
//    var wordsData = tokenizer.transform(srcRDD)
//    var hashingTF = new HashingTF().setNumFeatures(50000).setInputCol("words").setOutputCol("rawFeatures")
//    var featurizedData = hashingTF.transform(wordsData)
//    var idf = new IDF().setInputCol("rawFeatures").setOutputCol("features")
//    var idfModel = idf.fit(featurizedData)
//    var rescaledData = idfModel.transform(featurizedData)
//    var trainDataRdd = rescaledData.select($"category", $"features").map {
//      case Row(label: String, features: Vector) =>
//        LabeledPoint(label.toDouble, Vectors.dense(features.toArray))
//    }
//    trainDataRdd
//  }




  def getFormat(url: String, sQLContext: SQLContext, model: NaiveBayesModel):  String= {


    val map1 = scala.collection.mutable.Map(("1.0", 0), ("2.0", 0), ("3.0", 0), ("4.0", 0), ("5.0", 0), ("6.0", 0), ("7.0", 0), ("8.0", 0), ("9.0", 0), ("10.0", 0), ("11.0", 0), ("12.0", 0),
      ("13.0", 0), ("14.0", 0), ("15.0", 0), ("16.0", 0), ("17.0", 0),("18.0", 0), ("19.0", 0),("20.0", 0),
      ("21.0", 0), ("22.0", 0), ("23.0", 0), ("24.0", 0), ("25.0", 0),("26.0", 0),("27.0", 0), ("28.0", 0), ("29.0", 0),
      ("30.0", 0), ("31.0", 0),("32.0", 0),("33.0", 0),("34.0", 0), ("35.0", 0), ("36.0", 0), ("37.0", 0), ("38.0", 0),("39.0", 0),
      ("40.0", 0), ("41.0", 0), ("42.0", 0), ("43.0", 0), ("44.0", 0), ("45.0", 0), ("46.0", 0), ("47.0", 0), ("48.0", 0),
      ("49.0", 0), ("50.0", 0), ("51.0", 0), ("52.0", 0), ("53.0", 0), ("54.0", 0), ("55.0", 0), ("56.0", 0), ("57.0", 0), ("58.0", 0),
      ("59.0", 0), ("60.0", 0), ("61.0", 0), ("62.0", 0), ("63.0", 0), ("64.0", 0), ("65.0", 0), ("66.0", 0),("67.0", 0), ("68.0", 0),
      ("69.0", 0), ("70.0", 0),("71.0", 0),("72.0", 0), ("73.0", 0), ("74.0", 0), ("75.0", 0), ("76.0", 0),
      ("77.0", 0), ("78.0", 0)

    )
    val  map2 = scala.collection.immutable.Map(("1.0", "音乐"), ("2.0", "聊天"),("3.0", "游戏"), ("4.0", "明星"), ("5.0", "交友"), ("6.0","笑话"), ("7.0", "动漫"), ("8.0", "星座"), ("9.0", "小说"), ("10.0", "体育"), ("11.0", "NBA"),("12.0", "足球"),
      ("13.0", "网友"), ("14.0", "图片"), ("15.0", "影视"), ("16.0", "视频"), ("17.0", "小游戏"),("18.0", "美女"), ("19.0", "汽车"),("20.0", "手机"),
      ("21.0", "亲子"), ("22.0", "健康"), ("23.0", "女性"), ("24.0", "酷站"), ("25.0", "宠物"),("26.0", "购物"),("27.0", "时尚"), ("28.0", "美食"), ("29.0", "旅游"),
      ("30.0", "天气"), ("31.0", "股票"),("32.0", "基金"),("33.0", "银行"),("34.0", "彩票"), ("35.0", "招聘"), ("36.0", "房产"), ("37.0", "团购"), ("38.0", "电影"),("39.0", "新闻"),
      ("40.0", "军事"), ("41.0", "美图"), ("42.0", "社区"), ("43.0", "网游"), ("44.0", "微博"), ("45.0", "两性"), ("46.0", "地图"), ("47.0", "生活"), ("48.0", "电视"),
      ("49.0", "保险"), ("50.0", "儿童"), ("51.0", "大学"), ("52.0", "英语"), ("53.0", "男人"), ("54.0", "母婴"), ("55.0", "家具"), ("56.0", "邮箱"), ("57.0", "博客"), ("58.0", "电脑"),
      ("59.0", "硬件"), ("60.0", "桌面"), ("61.0", "曲艺"), ("62.0", "摄影"), ("63.0", "数码"), ("64.0", "考试"), ("65.0", "教育"), ("66.0", "政府"),("67.0", "法律"), ("68.0", "IT"),
      ("69.0", "爱好"), ("70.0", "杀毒"),("71.0", "行业"), ("72.0", "国外"), ("73.0", "公益"), ("74.0", "科技"), ("75.0", "文库"), ("76.0", "留学"),
      ("77.0", "宗教"), ("78.0", "北京")
    )


    //        val transfer = new Transfer(url)
    //
    //        var body = transfer.getBody()
    //        if(body=="发生异常!"){
    //          "发生异常!"
    //        }
    //        else {
    //          val   analyzer1 = new Analyzer1(body).endAnalyzer()
    //          val one = get(analyzer1, sQLContext)
    //
    //          val two = get(getOne(1), sQLContext)
    //          val three = get(getOne(100), sQLContext)
    //          val four = get(getOne(200), sQLContext)
    //          val five = get(getOne(300), sQLContext)
    //          val six = get(getOne(400), sQLContext)
    //          val seven = get(getOne(500), sQLContext)
    //          val eight = get(getOne(600), sQLContext)
    //          val night = get(getOne(700), sQLContext)
    //          val ten = get(getOne(800), sQLContext)
    //          val eleven = get(getOne(900), sQLContext)
    //          val trainData2 = one.union(two).union(three).union(four).union(five).union(six).union(seven).union(eight).union(night).union(ten).union(eleven)



    val transfer = new Transfer(url)

    var body = transfer.getBody()
    if (body == "没有取得文本") {
       "没有取得文本"
    }
    else {
      val text = new Analyzer1(body).endAnalyzer()
      if(text == "没有取得文本"){
        return "没有取得文本"
      }
      val analyzer1 = get(text,sQLContext,10)
      //val trainData2 = analyzer1++(getFormatData(sQLContext, 10))
//    val analyzer1 = getFormatData(sQLContext,Integer.parseInt(url))
//      val trainData2 = analyzer1++(getFormatData(sQLContext, 10))

      val predictLabel = analyzer1.map(p => (model.predict(p.features), p.label))
      var classes = predictLabel.first()._1
      map1(classes.toString) = map1(classes.toString) + 1


      var index = "1.0"
      var tmp = 0
      for ((k, v) <- map1) {

        if (v > tmp) {
          tmp = v
          index = k


        }
      }
      predictLabel.foreach(println)
      map2(index)

      //        }

    }


  }

}
