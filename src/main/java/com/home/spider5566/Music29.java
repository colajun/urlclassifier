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
 * Created by hadoop on 16-11-22.
 */
public class Music29 {
    JdbcTemplate jdbcTemplate = null;
    public Music29(){
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
        }
        catch (DuplicateKeyException e){
            System.out.println("该url:"+url+"已经存在数据库里面");
        }
    }


    public  void getUrlAndText(Elements urls, String tag1, String tag2) {

        String tmpUrl = "";
        String tmpName = "";
        String onclick = "";

        for (Element href : urls) {


                tmpUrl = href.attr("href");
                tmpName = href.text();
            if (tmpUrl != "") {

//                System.out.println(tmpUrl + "---------" + tmpName);

                inserTable(tag1, tag2, tmpUrl, tmpName);

            }
            }

        }



    public void  getMusicUrls(String url){
        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "娱乐";
        String tag2 ="音乐";
//        System.out.println(p.get(95));
//        //21,36,50,62,73,85,95
        int[] numbers = {21,36,50,62,73,85,95};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }






    }


    public static void main(String[] args) {

        Music29 music29 = new Music29();

        music29.getMusicUrls("http://www.5566.net/music1.htm");


    }




}
