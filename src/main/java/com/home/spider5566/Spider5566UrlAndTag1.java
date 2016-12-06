package com.home.spider5566;

import com.home.spring.JDBCHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;

/**
 * Created by hadoop on 16-11-13.
 */
public class Spider5566UrlAndTag1 {

    JdbcTemplate jdbcTemplate = null;
    public Spider5566UrlAndTag1(){
        try {
            jdbcTemplate = JDBCHelper.createMysqlTemplate("mysql1", "jdbc:mysql://192.168.21.27/urlclassifier?useUnicode=true&characterEncoding=utf8", "root", "root", 5, 30);

            jdbcTemplate.execute("create table if not EXISTS  tb_5566new("
                    +"id int(11) not null auto_increment PRIMARY KEY ,"
                    +"tag1 varchar(20),"+
                    "tag2 varchar(20) default null,"+
                    "url varchar(255),"+
                    "name varchar(50),"+
                    "title LONGTEXT,"+
                    "text LONGTEXT,"+
                    " UNIQUE INDEX `url` (`url`)"+
                    ") ENGINE=MyISAM DEFAULT  CHARSET=utf8;");
            System.out.println("成功创建数据表tb_parser2");

        } catch (Exception e) {
            jdbcTemplate = null;
            System.out.println("mysql未开启或JDBCHelper.createMysqlTemplate中的参数不正确!");
            e.printStackTrace();
        }




    }


    public  void inserTable(String tag1, String tag2, String url, String name){
        try {
            if(jdbcTemplate != null){
                int updates = jdbcTemplate.update("INSERT  INTO  tb_5566new"+
                                "(tag1, tag2, url, name) VALUE (?, ?,?, ?)",
                        tag1,tag2, url, name
                );

                if(updates == 1){
                    System.out.println("mysql插入成功");
                }

            }
        } catch (DuplicateKeyException e) {
            System.out.println("该url已经存在"+"========="+url);
        }


    }
    public String[] getUrlArray(){
        Document doc=null;
        String url;
        String[] urlArray = new String[86];
        int counter=0;

        try {
            doc = Jsoup.connect("http://www.5566.net/head.htm").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("a");

        for(Element tmpp :p ){

            if(!tmpp.attr("href").contains("main.htm")){
                url = "http://www.5566.net/"+tmpp.attr("href");
                urlArray[counter] = url;
               counter++;
            }


        }
        return  urlArray;

    }

    public void  getCool(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
//        System.out.println(p.get(11));
//        String title = doc.title();
        String tag1 = "著名网站";
        String tag2 ="";
        String tmpUrl="";
        String tmpName="";
        Elements urls = p.get(16).getElementsByTag("a");
        for(Element href: urls){
            tmpUrl = href.attr("href");
            tmpName = href.text();
            inserTable(tag1, tag2, tmpUrl, tmpName);

        }
//        System.out.println(urls);



    }













    public static void main(String[] args) {

        Spider5566UrlAndTag1 spider = new Spider5566UrlAndTag1();
        spider.getCool("http://www.5566.net/cool.htm");



    }

}
