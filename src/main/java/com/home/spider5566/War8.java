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
 * Created by hadoop on 16-11-21.
 */
public class War8 {

    String[] r9={"0","mil.jschina.com.cn/","www.afwing.com/","lt.cjdby.net/","www.miercn.com/","forum.home.news.cn/list/92-0-0-1.html","bbs.8181.cn/","military.china.com/","www.7476.com/","v.ifeng.com/mil/","bbs.tiexue.net/gbbs_6.html","mil.21cn.com/","www.laobing.com/","mil.news.sina.com.cn/","mil.qianlong.com/","www.mod.gov.cn/","news.ifeng.com/mil/","www.biku.net","tv.people.com.cn/GB/67816/","military.china.com.cn/","www.china918.net/","www.defence.org.cn/","mil.huanqiu.com/","www.81.cn/","bbs.ziling.com/forum-74-1.html","mil.eastday.com/","www.plapic.com.cn/","www.fyjs.cn/forum.php","club.xilu.com/emas/","www.meyet.com/","bbs.qianlong.com/forum-172-1.html","www.tiexue.net/","bbs.5281.net/","www.chinaiiss.com/","military.cntv.cn/","club.china.com/data/threads/12171906/","mil.sohu.com/","military.people.com.cn/","js.voc.com.cn/","junshi.xilu.com/","blog.sina.com.cn/lm/mil/index.html","www.qianyan001.com/","mil.qq.com/","war.163.com/","mil.cnr.cn/","www.chn2007.com/","www.warchina.com/","www.xinhuanet.com/mil/","www.cfdd.org.cn/bbs/","mil.news.sina.com.cn/video/index.shtml"};
    String e7="http://www.5566.org/indexe.htm";
    JdbcTemplate jdbcTemplate = null;
    public War8(){
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


    public String  k5(int p3){
        String url = "";
        String z4="=''+document.URL;";
        String j7="3377.5566";
        String e2=""+"www.5566.net";
        String a3=""+"http://www.5566.net/war-6.htm";
        String g6="=''+location.hostname;";
        String m4="4488.5566";
        int f2=e2.lastIndexOf('.');
        int w9=0+string2Unicode(String.valueOf(z4.charAt(6)));
        int m6=0+Integer.parseInt(String.valueOf(m4.charAt(2)));
        int s5=0+Integer.parseInt(String.valueOf(e2.charAt(f2 - 3)));
        int w2=0+Integer.parseInt(String.valueOf(m4.charAt(1)));
        int q3=0+string2Unicode(String.valueOf(g6.charAt(5)));
        int f3=0+Integer.parseInt(String.valueOf(e2.charAt(f2-1)));
        String h0="war";
        if(a3.indexOf("5566")>=0&&a3.indexOf("war")>=0){
           url = "http://"+r9[(p3-s5-w2-m6-q3-w9-31)/f3];
        }
        return  url;
    }
    public String  e9(int q7){
        String url ;
        String u1="=''+location.href;";
        String y6=""+"www.5566.net";
        String a2=""+"http://www.5566.net/war-6.htm";
        String p6="=''+location.host;";
        String j7="8844.5566";
        String q1="2266.5566";
        int y3=y6.lastIndexOf('.');
        int v9=0+string2Unicode(String.valueOf(u1.charAt(6)));
        int x7=0+Integer.parseInt(String.valueOf(y6.charAt(y3-3)));
        int u0=0+Integer.parseInt(String.valueOf(q1.charAt(1)));
        int j8=0+string2Unicode(String.valueOf(p6.charAt(5)));
        int c4=0+Integer.parseInt(String.valueOf(q1.charAt(2)));
        int d7=0+Integer.parseInt(String.valueOf(y6.charAt(y3-1)));
        String o5="war";
        if(y6!="5566.net"&&y6!="www.5566.net"&&y6!="5566.org"&&y6!="1.5566.org"&&y6!="2.5566.org"&&y6!="3.5566.org"&&y6!="4.5566.org"&&y6!="5.5566.org"&&y6!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+r9[(q7-x7-d7-c4-j8-v9-48)/u0];
        }
        return  url;
    }
    public String  y4(int g3){
        String url = "";
        String d6="6622.5566";
        String g8=""+"www.5566.net";
        String r5=""+"http://www.5566.net/war-6.htm";
        String j5="=''+document.domain;";
        String u5="=''+document.location;";
        String j1="7733.5566";
        int o3=g8.lastIndexOf('.');
        int y7=0+Integer.parseInt(String.valueOf(j1.charAt(2)));
        int t0=0+Integer.parseInt(String.valueOf(g8.charAt(o3-3)));
        int d8=0+Integer.parseInt(String.valueOf(j1.charAt(0)));
        int d9=0+string2Unicode(String.valueOf(j5.charAt(5)));
        int m9=0+string2Unicode(String.valueOf(u5.charAt(6)));
        int s2=0+Integer.parseInt(String.valueOf(g8.charAt(o3-1)));
        String c5="war";
        if(g8=="5566.net"||g8=="www.5566.net"||g8=="5566.org"||g8=="1.5566.org"||g8=="2.5566.org"||g8=="3.5566.org"||g8=="4.5566.org"||g8=="5.5566.org"||g8=="www.5566.org"){
          url = "http://"+r9[(g3-s2-d8-y7-d9-m9-42)/t0];
        }
        return  url;
    }


    public  void getUrlAndText(Elements urls, String tag1, String tag2){

        String tmpUrl="";
        String tmpName="";
        String onclick = "";

        for(Element href: urls){
            try {
                onclick = href.attr("onclick");
                tmpName = href.text();
                if (onclick.substring(0, 2).equalsIgnoreCase("k5")){
                    tmpUrl = k5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if  (onclick.substring(0, 2).equalsIgnoreCase("e9")){
                    tmpUrl = e9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if(onclick.substring(0, 2).equalsIgnoreCase("y4")){

                    tmpUrl = y4(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

                }
            } catch (Exception e) {
                tmpUrl = href.attr("href");
                tmpName = href.text();
            }

//            System.out.println(tmpUrl +"---------"+tmpName);

            inserTable(tag1, tag2, tmpUrl, tmpName);

        }



    }



    public void getWars(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "政法军事";
        String tag2 ="军事";
//        System.out.println(p.get(41));
        //17,18, 19, 20, 21, 22, 29, 41
        int[] numbers = {17,18, 19, 20, 21, 22, 29, 41};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }








    }

    public static void main(String[] args) {


        War8 war8 = new War8();
        war8.getWars("http://www.5566.net/war-6.htm");


    }









}
