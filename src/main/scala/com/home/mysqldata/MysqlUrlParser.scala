package com.home.mysqldata


import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by root on 16-4-20.
  */
/**
  * 将url切分来匹配，如
  * http://www.baidu.com/123.com/
http://www.baidu.com/
http://
http:
1
  *
  */

object MysqlUrlParser {
  case class RawDataRecord(category: String, text: String)
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("mysqlurlparser").setMaster("local")
    val sc = new SparkContext(conf)
    val sQLContext = new SQLContext(sc)
    var index=20
    import  sQLContext.implicits._
    //    val jdbcDF = sQLContext.read.format("jdbc").options(Map("url" -> "jdbc:mysql://192.168.20.50:3306/url?user=root&password=root", "dbtable" -> "tb_parser")).load()
    //    jdbcDF.registerTempTable("records")
    //    val zhujun = sQLContext.sql("select text from records" )
    //
    //    var zhujun2 = zhujun.map {
    //      x =>
    //        var data = x.toString().split(",")
    //        RawDataRecord(data(0), data(1))
    //    }
    println("请输入查询的url:")
    var url = Console.readLine()
    val jdbcDF = sQLContext.read.format("jdbc").options(Map("url" -> "jdbc:mysql://192.168.20.50:3306/url?user=root&password=root", "dbtable" -> "tb_6655")).load()
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

      if(sQLContext.sql("select tag2 from records where url like '" + z(k) + "'").count() > 0 && index > k)
      {

        index = k

      }


    }
    z.foreach(println)
    println(index)



    //
    //          try {
    //            val zhujun = sQLContext.sql("select tag2 from records where url like '" + url + "'")
    //           // println(url + "----->" + zhujun.take(1).apply(0))
    //            //println("退出不查询请输入true,继续查询请输入false:")
    //            //exit = Console.readBoolean()
    //            println(zhujun.count())
    //
    //          }
    //          catch {
    //            // http://m.fashion.67.com/
    //            case e: Exception => println("数据库没有匹配的url,使用分类器......")
    //          }






//http://ent.cntv.cn/enttv/zhongguoyinyuedianshi/videopage/

  }

}