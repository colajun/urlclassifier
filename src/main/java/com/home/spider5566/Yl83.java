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
public class Yl83 {

    String[] j7={"0","www.mingyi.cn/","www.fm120.com/","www.91985.com/","www.51daifu.com/","www.healthoo.com/","www.nhfpc.gov.cn/","club.health.sohu.com/","www.120ask.com/","bbs.tnbz.com/","health.sohu.com/","www.jianshen114.com/","www.91.cn/","www.chc.org.cn/","www.9939.com/","www.haodf.com/","www.maydeal.com.cn/","www.szhe.com/","bbs.tianya.cn/list-100-1.shtml","www.sda.gov.cn/WS01/CL0441/","www.yz-bbs.com/","www.familydoctor.com.cn/","www.qeqeqe.com/","bbs.59120.com/","www.cnys.com/","www.ewsos.com/","www.99.com.cn/","www.120so.com/","fashion.ifeng.com/health/","www.100md.com/","www.jkb.com.cn/","jk.scol.com.cn/","health.sina.com.cn/","health.people.com.cn/","www.51daifu.com/","www.xinhuanet.com/health/","www.mz16.cn/","www.yynet.cn/","www.5ijk.net/","www.fh21.com.cn/","www.haoyisheng.com","www.fx120.net/","www.guahao.com/","www.yataohome.com/","www.59120.com/","health.china.com/","www.daifumd.com","www.kanguv.com/","www.511511.com/","www.xywy.com/","www.cma.org.cn/"};
    String m6="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public Yl83(){
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


    public String  y6(int e5){
        String url;
        String t4="=''+location.host;";
        String t9=""+"http://www.5566.net/yi1-4.htm";
        String z5=""+"www.5566.net";
        String f6="=''+document.location;";
        String g1="9922.5566";
        String p3="5588.5566";
        int l9=z5.lastIndexOf('.');
        int p5=0+string2Unicode(String.valueOf(t4.charAt(5)));
        int y2=0+Integer.parseInt(String.valueOf(g1.charAt(0)));
        int u5=0+Integer.parseInt(String.valueOf(z5.charAt(l9-3)));
        int p6=0+string2Unicode(String.valueOf(f6.charAt(6)));
        int r2=0+Integer.parseInt(String.valueOf(z5.charAt(l9-1)));
        int s6=0+Integer.parseInt(String.valueOf(g1.charAt(2)));
        String d0="yi1";
        if(t9.indexOf("5566")==-1||t9.indexOf("yi1")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+j7[(e5-u5-r2-s6-p5-p6-25)/y2];
        }
        return  url;
    }
    public String  t3(int r8){
        String url;
        String l5="=''+document.domain;";
        String o5="=''+location.href;";
        String w5="2299.5566";
        String s4="1166.5566";
        String o8=""+"www.5566.net";
        String e1=""+"http://www.5566.net/yi1-4.htm";
        int u1=o8.lastIndexOf('.');
        int u6=0+string2Unicode(String.valueOf(l5.charAt(5)));
        int y0=0+string2Unicode(String.valueOf(o5.charAt(6)));
        int j3=0+Integer.parseInt(String.valueOf(s4.charAt(2)));
        int a3=0+Integer.parseInt(String.valueOf(o8.charAt(u1-1)));
        int d7=0+Integer.parseInt(String.valueOf(o8.charAt(u1-3)));
        int n8=0+Integer.parseInt(String.valueOf(s4.charAt(0)));
        String f2="yi1";
        if(o8!="5566.net"&&o8!="www.5566.net"&&o8!="5566.org"&&o8!="1.5566.org"&&o8!="2.5566.org"&&o8!="3.5566.org"&&o8!="4.5566.org"&&o8!="5.5566.org"&&o8!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+j7[(r8-a3-n8-j3-u6-y0-22)/d7];
        }
        return  url;
    }
   public String  h0(int r0){
       String url= "";
        String n9=""+"http://www.5566.net/yi1-4.htm";
        String r1="=''+document.URL;";
        String p3="6611.5566";
        String i6=""+"www.5566.net";
        String v5="8855.5566";
        String z8="=''+location.hostname;";
        int k0=i6.lastIndexOf('.');
        int b6=0+Integer.parseInt(String.valueOf(v5.charAt(1)));
        int r4=0+string2Unicode(String.valueOf(r1.charAt(6)));
        int n3=0+Integer.parseInt(String.valueOf(v5.charAt(2)));
        int c4=0+Integer.parseInt(String.valueOf(i6.charAt(k0-3)));
        int a2=0+Integer.parseInt(String.valueOf(i6.charAt(k0-1)));
        int s0=0+string2Unicode(String.valueOf(z8.charAt(5)));
        String l1="yi1";
        if(i6=="5566.net"||i6=="www.5566.net"||i6=="5566.org"||i6=="1.5566.org"||i6=="2.5566.org"||i6=="3.5566.org"||i6=="4.5566.org"||i6=="5.5566.org"||i6=="www.5566.org"){
           url = "http://"+j7[(r0-c4-b6-n3-s0-r4-46)/a2];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("y6")) {
                    tmpUrl = y6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("t3")) {
                    tmpUrl = t3(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("h0")) {

                    tmpUrl = h0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
        String tag1 = "健康医疗";
        String tag2 = "";
//        System.out.println(p.get(35));
        //16,35
        int[] numbers = {16,35};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }



    }

    public static void main(String[] args) {

        Yl83 yl83 = new Yl83();
        yl83.getUrls("http://www.5566.net/yi1-4.htm");


    }










}
