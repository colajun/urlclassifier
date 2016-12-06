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
 * Created by hadoop on 16-11-23.
 */
public class Sp33 {

    String[] n8={"0","movie.tudou.com/","www.iqiyi.com/dongman/","www.news.cn/video/","www.v1.cn/","cartoon.tudou.com/","dianshiju.cntv.cn/","www.flvcd.com/","www.51live.com/","www.youmi.cn/","www.pipi.cn/","www.joy.cn/","v.ifeng.com/","anime.kankan.com/","zy.kankan.com/","v.sogou.com/top/tvshow/index.html","movie.kankan.com/","www.tudou.com/","www.juchang.com/tv/","www.guagua.cn/","tv.sohu.com/comic/","www.smgbb.cn/","www.ku6.com/","video.sina.com.cn/movie/category/teleplay/index.html","www.pptv.com/","tv.cntv.cn/jiemu","ent.sina.com.cn/zongyi/","player.qq.com/","www.56.com/show","www.56.com/tv","www.iqiyi.com/dianshiju/","v.qq.com/","tv.pptv.com/","v.sogou.com/","zongyi.ku6.com/","tv.letv.com/","www.fun.tv/variety/","www.juchang.com/movie/","www.iqiyi.com/","www.letv.com/","tv.cntv.cn/","www.pps.tv/","v.61.com/","v.163.com/","www.hunantv.com/","v.qq.com/tv/index.html","tv.people.com.cn/","www.iqiyi.com/dianying/","tv.cntv.cn/live","tv.sohu.com/show/","tv.kankan.com/","zy.tudou.com/","tv.sohu.com/movie/","www.kankan.com/app/xmp.html","www.fun.tv/","www.wasu.cn/","tv.sohu.com/","www.kmplayer.com/","www.splayer.org/","tv.tudou.com/","www.iqiyi.com/zongyi/","v.qq.com/movie/index.html","www.cutv.com/","www.kankan.com/","video.sina.com.cn/","tv.sohu.com/teleplay/","www.uusee.com/","zongyi.letv.com/","open.163.com/","www.baofeng.com/","www.boosj.com/","www.ouou.com/","v.qq.com/variety/","www.1905.com/vod/","video.sina.com.cn/movie/","www.56.com/","www.realplayer.cn/","dianying.cntv.cn/"};
    String e9="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;
    public Sp33(){
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




   public String  c6(int j2){
       String url;
        String r2="=''+document.domain;";
        String u3="3355.5566";
        String d6="=''+location.href;";
        String j5=""+"www.5566.net";
        String h9="7722.5566";
        String u1=""+"http://www.5566.net/sp.htm";
        int t1=j5.lastIndexOf('.');
        int a9=0+string2Unicode(String.valueOf(r2.charAt(5)));
        int b1=0+Integer.parseInt(String.valueOf(j5.charAt(t1-1)));
        int t4=0+string2Unicode(String.valueOf(d6.charAt(6)));
        int n0=0+Integer.parseInt(String.valueOf(j5.charAt(t1-3)));
        int b0=0+Integer.parseInt(String.valueOf(u3.charAt(2)));
        int a8=0+Integer.parseInt(String.valueOf(u3.charAt(0)));
        String w1="sp";
        if(j5!="5566.net"&&j5!="www.5566.net"&&j5!="5566.org"&&j5!="1.5566.org"&&j5!="2.5566.org"&&j5!="3.5566.org"&&j5!="4.5566.org"&&j5!="5.5566.org"&&j5!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{url = "http://"+n8[(j2-n0-b1-b0-a9-t4-45)/a8];
        }
        return  url;
    }
   public String  k5(int i6){
       String url = "";
        String p3="2277.5566";
        String h9="8811.5566";
        String v5=""+"http://www.5566.net/sp.htm";
        String a6="=''+document.location;";
        String m0="=''+location.host;";
        String m6=""+"www.5566.net";
        int j1=m6.lastIndexOf('.');
        int q8=0+Integer.parseInt(String.valueOf(m6.charAt(j1-1)));
        int j8=0+Integer.parseInt(String.valueOf(p3.charAt(3)));
        int l7=0+Integer.parseInt(String.valueOf(p3.charAt(1)));
        int a3=0+string2Unicode(String.valueOf(a6.charAt(6)));
        int i4=0+string2Unicode(String.valueOf(m0.charAt(5)));
        int l4=0+Integer.parseInt(String.valueOf(m6.charAt(j1-3)));
        String k4="sp";
        if(m6=="5566.net"||m6=="www.5566.net"||m6=="5566.org"||m6=="1.5566.org"||m6=="2.5566.org"||m6=="3.5566.org"||m6=="4.5566.org"||m6=="5.5566.org"||m6=="www.5566.org"){
           url = "http://"+n8[(i6-l4-l7-j8-i4-a3-33)/q8];
        }
        return  url;
    }
   public String  w4(int j6){
       String url = "";
        String y3="1188.5566";
        String s3="5533.5566";
        String z8=""+"www.5566.net";
        String q5="=''+location.hostname;";
        String m1=""+"http://www.5566.net/sp.htm";
        String l8="=''+document.URL;";
        int x7=z8.lastIndexOf('.');
        int w9=0+Integer.parseInt(String.valueOf(z8.charAt(x7-1)));
        int l1=0+Integer.parseInt(String.valueOf(y3.charAt(3)));
        int z2=0+Integer.parseInt(String.valueOf(z8.charAt(x7-3)));
        int g6=0+string2Unicode(String.valueOf(q5.charAt(5)));
        int s9=0+Integer.parseInt(String.valueOf(y3.charAt(1)));
        int v0=0+string2Unicode(String.valueOf(l8.charAt(6)));
        String k1="sp";
        if(m1.indexOf("5566")>=0&&m1.indexOf("sp")>=0){
           url = "http://"+n8[(j6-w9-s9-l1-g6-v0-24)/z2];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("c6")) {
                    tmpUrl = c6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("k5")) {
                    tmpUrl = k5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("w4")) {

                    tmpUrl = w4(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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

    public  void  getSpUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "娱乐";
        String tag2 ="视频";
//        System.out.println(p.get(78));
//        //20,37,46,57,67, 78
        int[] numbers = {20,37,46,57,67, 78};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }
//






    }

    public static void main(String[] args) {
        Sp33 sp33 = new Sp33();

        sp33.getSpUrls("http://www.5566.net/sp.htm");

    }



}
