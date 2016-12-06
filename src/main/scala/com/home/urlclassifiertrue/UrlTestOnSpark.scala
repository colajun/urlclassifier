package com.home.urlclassifiertrue


import com.home.spring.JDBCHelper

import org.apache.spark.sql.{ SQLContext}

/**
  * Created by hadoop on 16-10-27.
  */
class UrlTestOnSpark extends Serializable{
  val template= JDBCHelper.createMysqlTemplate("mysql1", "jdbc:mysql://192.168.20.50/url?useUnicode=true&characterEncoding=utf8", "root", "root", 5, 30);

  def getUrl(urlchaxun:String): String ={

    val resultSet = template.queryForList("select url from tb_6655 where url like "+"'"+urlchaxun+"%'")
    val it = resultSet.iterator()
    var url ="qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"
    while (it.hasNext){
      var tmp = it.next().get("url").toString
      if(tmp.length < url.length){
        url = tmp
      }

    }
   url
  }
  def getCategory(urltrue:String): String ={

    val result2 = template.queryForList("select tag2 from tb_6655 where url ="+"'"+urltrue+"'")
    result2.get(0).get("tag2").toString
  }



  def findUrlinMysql(sqlContetx: SQLContext,url: String): String ={


    var urlclassifier="没有在数据库里面"
//    var indexurl = 20
    val jdbcDF = sqlContetx.read.format("jdbc").options(Map("url" -> "jdbc:mysql://192.168.20.50:3306/url?user=root&password=root", "dbtable" -> "tb_6655")).load()
    jdbcDF.registerTempTable("record1")



    val urlArray = url.split("/")
    val count = urlArray.length
    var z:Array[String] = new Array[String](count)
    z(0) = url
    for(j <- 1 to count-1 )
    {
      //z(j) = url.replace("/"+urlArray(count-1), "")
      z(j) = z(j-1).replace("/"+urlArray(count-j), "")
    }

    for(k <- 0 to z.length-3)
    {

      if(!getUrl(z(k)+"/").contains("qqqqqqqqqqqqqqq"))
      {


        return  getCategory(getUrl(z(k)+"/"))
      }

      if(!getUrl(z(k)).contains("qqqqqqqqqqqqqqqqqqqqqq"))

      {

       return  getCategory(getUrl(z(k)))
      }

//      if(sqlContetx.sql("select tag2 from record1 where url  = '" + z(k) + "/'").count() > 0 && indexurl > k)
//      {
//
//        indexurl = k
//        urlclassifier = sqlContetx.sql("select tag2 from record1 where url = '" + z(indexurl) + "/'").take(1).apply(0).toString()
//
//        return  urlclassifier
//      }
//
//      if(sqlContetx.sql("select tag2 from record1 where url  = '" + z(k) + "'").count() > 0 && indexurl > k)
//
//      {
//
//        indexurl = k
//        urlclassifier = sqlContetx.sql("select tag2 from record1 where url ='" + z(indexurl) + "'").take(1).apply(0).toString()
//
//        return  urlclassifier
//      }

    }
    urlclassifier
  }

}
