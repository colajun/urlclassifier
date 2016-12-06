package com.home.urlclassifiertrue

import java.sql.PreparedStatement

import com.home.spring.JDBCHelper
import org.apache.spark.mllib.classification.NaiveBayesModel
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.springframework.jdbc.core.{JdbcTemplate, PreparedStatementSetter}

/**
  * Created by hadoop on 16-10-27.
  */
object UrlTest {
  val template = JDBCHelper.createMysqlTemplate("mysqlzhangtefei", "jdbc:mysql://192.168.21.46/company_data?useUnicode=true&characterEncoding=utf8", "root", "rootztf", 5, 30);


  def inserTable(tag: String,id: Int):Unit={
    if(template != null){
      val updates = template.update("update   out_side_user"+
        " set tag=? where id=?",
        new PreparedStatementSetter {
          override def setValues(ps: PreparedStatement): Unit = {
            ps.setString(1, tag)
            ps.setInt(2, id)
          }
        }
      )


      if(updates == 1){
        System.out.println("mysql插入成功");
      }

    }

  }

  def getUrl(id:Int): String ={

    val resultSet = template.queryForList("select url from  out_side_user where id= "+id)
    resultSet.get(0).get("url").toString

  }
  def main(args: Array[String]): Unit = {



    val conf = new SparkConf().setAppName("url").setMaster("local")
    val sc = new SparkContext(conf)
    val sqlContext1 = new SQLContext(sc)
    val sqlContext2 = new SQLContext(sc)
    val sqlContext3 = new SQLContext(sc)
    val urlTest = new UrlTestOnSpark()
    val urlClassifier = new UrlClassifier()

    //val model = urlTest.getModel(sqlContext1)
    val model = NaiveBayesModel.load(sc, "/home/hadoop/modelsave/model1")
    var exit = false
    var id =1
    while (!exit && id <2666) {

//      print("请输入要查询的url:")
//      var url = Console.readLine()
      var url = getUrl(id)
      var inornot = urlTest.findUrlinMysql(sqlContext2, url)
      if(inornot != "没有在数据库里面"){

//        println("在数据库里面:"+url+"---------->"+inornot)
        inserTable(inornot,id)

      }
      else {

        var category = urlClassifier.getFormat(url, sqlContext3, model)

//        println("没有在数据库里面:"+url+"---------->"+category)

        inserTable(category,id)
      }

//      print("退出不查询请输入true,继续查询请输入" + "false:")
//      exit = Console.readBoolean()
      exit = false
      id += 1

    }

  }




}
