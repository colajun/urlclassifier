package com.home.spider5566;

import com.home.spring.JDBCHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoop on 16-12-4.
 */
public class GetBody {


    JdbcTemplate jdbcTemplate = null;
    public GetBody(){
        try {
            jdbcTemplate = JDBCHelper.createMysqlTemplate("mysql1", "jdbc:mysql://192.168.21.60/urlclassifier?useUnicode=true&characterEncoding=utf8", "root", "root", 5, 30);

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


    public  void inserTable(int id, String title, String text){

        try {
            int counter=jdbcTemplate.update("update tb_5566new set title=? ,  text = ? WHERE  id = ?", new Object[]{title, text, id});

            if(counter >0){
                System.out.println("数据更新成功!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public  String[] getTitleAndText(String url)  {

        Document doc;
        String title;
        String text;
        try {
            doc = Jsoup.connect(url).get();
             title = doc.title();
             text = doc.text();
        } catch (Exception e) {
            System.out.println("请求失败!");
            title = "";
            text = "";
        }

        return new String[]{title, text};


    }

    public static void main(String[] args)  {

        GetBody getBody = new GetBody();
        List rows = getBody.jdbcTemplate.queryForList("select id, url FROM  tb_5566new");
        Iterator it = rows.iterator();
        while (it.hasNext()){

            Map map = (Map)it.next();
            int id = (Integer) map.get("id");
            String url = (String)map.get("url");
            String[] titleAndText = getBody.getTitleAndText(url);

            if(titleAndText[0] != ""){
                getBody.inserTable(id, titleAndText[0], titleAndText[1]);

            }
        }





    }


}
