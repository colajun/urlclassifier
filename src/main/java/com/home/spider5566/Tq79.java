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
 * Created by hadoop on 16-11-27.
 */
public class Tq79 {
    String[] z5={"0","www.st12121.net/","www.smb.gov.cn/","www.gxqxj.com/","www.jlqx.gov.cn/","www.henanqx.gov.cn/","www.cwb.gov.tw/","www.gzqx.gov.cn/","www.weather.gov.hk/contentc.htm","weather.china.com.cn/","weather.news.sina.com.cn/","www.sz121.com/","www.ceic.ac.cn/","www.jmqx.gov.cn/","www.sdqx.gov.cn/","mb.hainan.gov.cn/","www.hbqx.gov.cn/","www.ynmb.cn/","www.wf121.com/","www.sxqx.gov.cn/","www.szmb.gov.cn/","www.hnqx.gov.cn/","weather.news.sohu.com/","www.weather.com.cn/static/html/legend.shtml","www.typhoon.gov.cn/","www.lnmb.gov.cn/","www.xjqx.cn/","www.zhmb.gov.cn/","www.grmc.gov.cn/","www.cz121.com/","www.weathertv.cn/","www.weather.he.cninfo.net/","www.gsma.gov.cn/","www.sxsqxj.gov.cn/","www.tqyb.com.cn/","www.hzqx.com/gzhfw/index.asp","www.weather.com.cn/","www.pm25.com/","typhoon.weather.com.cn/index.shtml","www.cma.gov.cn/","www.weather.org.cn/","www.qx121.com.cn/","www.tz121.com/","www.bzqx.net/","www.cms1924.org/","www.cqmb.gov.cn/","www.csndmc.ac.cn/","www.ttqx.com.cn/","www.ahqx.gov.cn/","www.qqq121.com.cn/","www.xmeteo.xm.fj.cn/","www.scqx.gov.cn/","www.wmo.ch/","www.qx121.com/","www.zsqx.com/","www.jsmb.gov.cn/","www.bjmb.gov.cn/","www.t7online.com/","www.gx121.com/","www.imwb.gov.cn/","www.cea.gov.cn/","113.108.142.147:20035/emcpublish/","www.nmc.cn/","www.qhqxj.gov.cn/","www.hfqx.com.cn/","www.npqx.com/","www.zjmb.gov.cn/","www.hljmb.gov.cn/","weather.news.qq.com/","www.weather.com/","www.tjqx.gov.cn/","www.worldweather.cn/","www.weather.com.hk/","www.wz121.com/","www.soweather.com/","www.fjqx.gov.cn/","www.fs121.com/","www.sxmb.gov.cn/","www.tqyb.cc/","www.smg.gov.mo/"};
    String n3="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public Tq79(){
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

    public int string2Unicode(String string) {

        StringBuffer unicode = new StringBuffer();

        for (int i = 0; i < string.length(); i++) {

            // 取出每一个字符
            char c = string.charAt(i);

            // 转换为unicode
            unicode.append(Integer.toUnsignedLong(c));
        }

        return Integer.parseInt(unicode.toString());
    }

   public String  h5(int p8){
       String url = "";
        String z0="5533.5566";
        String z3=""+"www.5566.net";
        String r8="=''+location.host;";
        String o8="9966.5566";
        String a6="=''+document.location;";
        String l7=""+"http://www.5566.net/tq-.htm";
        int z6=z3.lastIndexOf('.');
        int i6=0+Integer.parseInt(String.valueOf(o8.charAt(2)));
        int a4=0+Integer.parseInt(String.valueOf(z3.charAt(z6-3)));
        int o2=0+string2Unicode(String.valueOf(r8.charAt(5)));
        int e6=0+Integer.parseInt(String.valueOf(z3.charAt(z6-1)));
        int l3=0+string2Unicode(String.valueOf(a6.charAt(6)));
        int q0=0+Integer.parseInt(String.valueOf(o8.charAt(1)));
        String e0="tq";
        if(l7.indexOf("5566")>=0&&l7.indexOf("tq")>=0){
           url = "http://"+z5[(p8-a4-e6-i6-o2-l3-70)/q0];
        }
        return  url;
    }
   public String  h0(int z7){
       String url;
        String u3="=''+document.URL;";
        String c4=""+"http://www.5566.net/tq-.htm";
        String y7="7711.5566";
        String u8="6699.5566";
        String t4=""+"www.5566.net";
        String w1="=''+document.domain;";
        int h7=t4.lastIndexOf('.');
        int c9=0+string2Unicode(String.valueOf(u3.charAt(6)));
        int r2=0+Integer.parseInt(String.valueOf(y7.charAt(0)));
        int q8=0+Integer.parseInt(String.valueOf(t4.charAt(h7-1)));
        int b3=0+Integer.parseInt(String.valueOf(y7.charAt(2)));
        int w2=0+Integer.parseInt(String.valueOf(t4.charAt(h7-3)));
        int c6=0+string2Unicode(String.valueOf(w1.charAt(5)));
        String g0="tq";
        if(c4.indexOf("5566")==-1||c4.indexOf("tq")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
          url = "http://"+z5[(z7-q8-r2-b3-c6-c9-42)/w2];
        }
        return  url;
    }
   public String  w0(int y0){
       String url;
        String h4=""+"www.5566.net";
        String n7="3355.5566";
        String f4=""+"http://www.5566.net/tq-.htm";
        String z0="1177.5566";
        String u4="=''+location.hostname;";
        String w3="=''+location.href;";
        int v1=h4.lastIndexOf('.');
        int d0=0+Integer.parseInt(String.valueOf(h4.charAt(v1-3)));
        int w4=0+Integer.parseInt(String.valueOf(h4.charAt(v1-1)));
        int m0=0+Integer.parseInt(String.valueOf(n7.charAt(1)));
        int g3=0+Integer.parseInt(String.valueOf(n7.charAt(3)));
        int v4=0+string2Unicode(String.valueOf(u4.charAt(5)));
        int z9=0+string2Unicode(String.valueOf(w3.charAt(6)));
        String t6="tq";
        if(h4!="5566.net"&&h4!="www.5566.net"&&h4!="5566.org"&&h4!="1.5566.org"&&h4!="2.5566.org"&&h4!="3.5566.org"&&h4!="4.5566.org"&&h4!="5.5566.org"&&h4!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
          url = "http://"+z5[(y0-d0-m0-g3-v4-z9-80)/w4];
        }

        return  url;



    }

    public  void getUrlAndText(Elements urls, String tag1, String tag2) {

        String tmpUrl = "";
        String tmpName = "";
        String onclick = "";

        for (Element href : urls) {
            try {
                onclick = href.attr("onclick");
                tmpName = href.text();
                if (onclick.substring(0, 2).equalsIgnoreCase("h0")) {
                    tmpUrl = h0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("h5")) {
                    tmpUrl = h5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("w0")) {

                    tmpUrl = w0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

                }
            } catch (Exception e) {
                tmpUrl = href.attr("href");
                tmpName = href.text();
            }
            if (tmpUrl != "") {

//                System.out.println(tmpUrl + "---------" + tmpName);

                inserTable(tag1, tag2, tmpUrl, tmpName);

            }
        }

    }


    public  void  getUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "生活";
        String tag2 = "天气";
//        System.out.println(p.get(33));
//        //20,33,
        int[] numbers = {20,33};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }



    }
    public static void main(String[] args) {

        Tq79 tq79 = new Tq79();

        tq79.getUrls("http://www.5566.net/tq-.htm");

    }



}
