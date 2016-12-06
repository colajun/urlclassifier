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
public class Sport14 {
    String[] x2={"0","www.gooooal.com/","www.jianyefc.com/","www.jczqw.com/","www.lifanfc.com/","sports.sina.com.cn/china/","bbs.qieerxi.com/","www.manutdcn.com/","www.fa.org.cn/","soccer.hupu.com/","forum.sports.sina.com.cn/forum-58-1.html","inter.titan24.com/","sports.sina.com.cn/csl/","bbs.sports.163.com/list/chaguan.html","sports.sina.com.cn/global/","acmilan.titan24.com/","www.manutd.com.cn/","sports.163.com/world/","www.7m.cn/","sports.163.com/china/","bbs.arsenal.com.cn/","www.manunited.com.cn/","sports.video.sina.com.cn/","sports.nubb.com/","www.miqiu.com/","sports.enorth.com.cn/teda/","www.zqnow.com/","sports.ku6.com/jingbaozuqiu/","www.shenhuafc.com.cn/","www.arsenal.com.cn/","fcguoan.sina.com.cn/","www.goalchina.net/","www.wanguoqunxing.com/","cnsoccer.titan24.com/","www.rmfans.cn/","sports.cntv.cn/football/index.shtml","bbs.gerfans.cn/","www.go01.com/","sports.qq.com/csocce/","www.fifa.com/","www.hbfootball.com/","www.tianya.cn/publicforum/articleslist/0/fans.shtml","www.barca.cn/","cn.liverpoolfc.com/","bbs.sports.163.com/list/shalong.html","www.inter1908.net/","www.inter.net.cn/","www.jssaintyfc.com/","www.lnts.com.cn/index.php","sports.sohu.com/1/1102/12/subject204181285.shtml","bbs.winning11cn.com/","sports.21cn.com/national/","sports.qq.com/isocce/","sports.21cn.com/international/","club.sports.sohu.com/soccer/threads/","www.uefa.com/","sports.sohu.com/1/1102/44/subject204184448.shtml","www.greentownfc.com/","www.zhibo8.com/","acmilan.titan24.com/","forum.sports.sina.com.cn/forum-71-1.html","bbs.rmfans.cn/"};
    String y3="http://www.5566.org/indexe.htm";
    JdbcTemplate jdbcTemplate = null;
    public Sport14(){
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

    public  String v7(int g7){
        String url ="";
        String w3="=''+location.href;";
        String k7=""+"http://www.5566.net/sport3-5.htm";
        String l7="7722.5566";
        String v9="8833.5566";
        String g6="=''+location.hostname;";
        String o8=""+"www.5566.net";
        int n7=o8.lastIndexOf('.');
        int v8=0+string2Unicode(String.valueOf(w3.charAt(6)));
        int e3=0+Integer.parseInt(String.valueOf(l7.charAt(1)));
        int e2=0+Integer.parseInt(String.valueOf(o8.charAt(n7-1)));
        int m4=0+Integer.parseInt(String.valueOf(l7.charAt(2)));
        int h2=0+string2Unicode(String.valueOf(g6.charAt(5)));
        int d0=0+Integer.parseInt(String.valueOf(o8.charAt(n7-3)));
        String t1="sport3";
        if(o8=="5566.net"||o8=="www.5566.net"||o8=="5566.org"||o8=="1.5566.org"||o8=="2.5566.org"||o8=="3.5566.org"||o8=="4.5566.org"||o8=="5.5566.org"||o8=="www.5566.org"){

           url = "http://"+x2[(g7-e2-e3-m4-h2-v8-85)/d0];
        }
        return  url;
}

    public String s7(int q9){
        String url;
        String d4=""+"www.5566.net";
        String c8=""+"http://www.5566.net/sport3-5.htm";
        String e5="2277.5566";
        String t6="4466.5566";
        String i1="=''+location.host;";
        String c2="=''+document.URL;";
        int w7=d4.lastIndexOf('.');
        int o9=0+Integer.parseInt(String.valueOf(d4.charAt(w7-3)));
        int r7=0+Integer.parseInt(String.valueOf(t6.charAt(0)));
        int s2=0+Integer.parseInt(String.valueOf(t6.charAt(2)));
        int d5=0+Integer.parseInt(String.valueOf(d4.charAt(w7-1)));
        int l9=0+string2Unicode(String.valueOf(i1.charAt(5)));
        int f7=0+string2Unicode(String.valueOf(c2.charAt(6)));
        String j9="sport3";
        if(d4!="5566.net"&&d4!="www.5566.net"&&d4!="5566.org"&&d4!="1.5566.org"&&d4!="2.5566.org"&&d4!="3.5566.org"&&d4!="4.5566.org"&&d4!="5.5566.org"&&d4!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+x2[(q9-o9-r7-s2-l9-f7-25)/d5];
        }
        return  url;
    }
    public  String k8(int j7){
        String url;
        String g3=""+"http://www.5566.net/sport3-5.htm";
        String m9="=''+document.location;";
        String y1=""+"www.5566.net";
        String c1="=''+document.domain;";
        String e5="6644.5566";
        String j5="3388.5566";
        int w2=y1.lastIndexOf('.');
        int j1=0+Integer.parseInt(String.valueOf(j5.charAt(0)));
        int i5=0+string2Unicode(String.valueOf(m9.charAt(6)));
        int q4=0+Integer.parseInt(String.valueOf(y1.charAt(w2-3)));
        int w6=0+string2Unicode(String.valueOf(c1.charAt(5)));
        int y6=0+Integer.parseInt(String.valueOf(j5.charAt(3)));
        int u2=0+Integer.parseInt(String.valueOf(y1.charAt(w2-1)));
        String d9="sport3";
        if(g3.indexOf("5566")==-1||g3.indexOf("sport3")==-1){
           url ="http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+x2[(j7-q4-u2-y6-w6-i5-87)/j1];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("v7")) {
                    tmpUrl = v7(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("s7")) {
                    tmpUrl = s7(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("k8")) {

                    tmpUrl = k8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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



    public void getSportsUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "体育运动";
        String tag2 ="足球";
//        System.out.println(p.get(41));
        //17,32,41
        int[] numbers = {17,32,41};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }






    }


    public static void main(String[] args) {

        Sport14 sport14 = new Sport14();
        sport14.getSportsUrls("http://www.5566.net/sport3-5.htm");




    }








}
