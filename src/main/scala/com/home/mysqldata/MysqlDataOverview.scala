package com.home.mysqldata

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by root on 16-5-3.
  */
/**
  * 对数据库里面的类别数据进行统计
  */
object MysqlDataOverview {
  def main(args: Array[String]) {

    val conf = new SparkConf().setMaster("local").setAppName("zhujun1")
    val sc = new SparkContext(conf)

    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    import sqlContext.implicits._

    val jdbcDF = sqlContext.read.format("jdbc").options(Map("url" -> "jdbc:mysql://192.168.20.50:3306/url?user=root&password=root", "dbtable" -> "tb_parser2")).load()
    jdbcDF.registerTempTable("records")

//    val tag = sqlContext.sql("select text from records")
//
//    val tagArray = tag.map(tag=> (tag.apply(0).toString.split(",")(0),1)).reduceByKey((a,b)=> a+b)
//    tagArray.foreach(println)
//    println(tagArray.count())
//    println(tag.count())

   val test = sqlContext.sql("select url from records where url like 'http://www.baidu.com%'")
    test.foreach(println)


  }

}