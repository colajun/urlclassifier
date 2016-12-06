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
public class Game38 {

   String[]  h0={"0","gf.61.com/","hero.61.com/","www.7k7k.com/","wanwan.sina.com.cn/xyx/","www.3536.com/","1314.qq.com/","www.caihongtang.com/","jl.61.com/","www.3839.com/","aobi.100bt.com/","www.yx8.cn/","xyx.2144.cn/","www.4399.com/","pk.4399.com/","seer.61.com/","www.6949.com/","www.456.net/","aoya.100bt.com/","mole.61.com/","haqi.61.com/","ct.61.com/","game.61.com/","17roco.qq.com/","flash.17173.com/","seer2.61.com/","www.100bt.com/game/","aola.100bt.com/","www.3199.cn/","hua.61.com/","www.abab.com/","www.2125.com/","lds.100bt.com/","as.61.com/","www.3366.com/","aoqi.100bt.com/","games.qq.com/mini/mini.shtml"};
    String j4="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;

    public Game38() {
        try {
            jdbcTemplate = JDBCHelper.createMysqlTemplate("mysql1", "jdbc:mysql://192.168.21.27/urlclassifier?useUnicode=true&characterEncoding=utf8", "root", "root", 5, 30);

            jdbcTemplate.execute("create table if not EXISTS  tb_5566new("
                    + "id int(11) not null auto_increment PRIMARY KEY ,"
                    + "tag1 varchar(20)," +
                    "tag2 varchar(20) default null," +
                    "url varchar(255)," +
                    "name varchar(50)," +
                    "title LONGTEXT," +
                    "text LONGTEXT," +
                    " UNIQUE INDEX `url` (`url`)" +
                    ") ENGINE=MyISAM DEFAULT  CHARSET=utf8;");
            System.out.println("成功创建数据表tb_parser2");

        } catch (Exception e) {
            jdbcTemplate = null;
            System.out.println("mysql未开启或JDBCHelper.createMysqlTemplate中的参数不正确!");
            e.printStackTrace();
        }


    }


    public void inserTable(String tag1, String tag2, String url, String name) {
        try {
            if (jdbcTemplate != null) {
                int updates = jdbcTemplate.update("INSERT  INTO  tb_5566new" +
                                "(tag1, tag2, url, name) VALUE (?, ?,?, ?)",
                        tag1, tag2, url, name
                );

                if (updates == 1) {
                    System.out.println("mysql插入成功");
                }

            }
        } catch (DuplicateKeyException e) {
            System.out.println("该url:" + url + "已经存在数据库里面");
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


    public String  s0(int q8){
        String url;
        String o7="=''+document.location;";
        String b1="2266.5566";
       String  e5="5577.5566";
        String u3=""+"http://www.5566.net/game2.htm";
        String y7=""+"www.5566.net";
        String s6="=''+location.hostname;";
        int g4=y7.lastIndexOf('.');
        int v2=0+string2Unicode(String.valueOf(o7.charAt(6)));
        int i0=0+Integer.parseInt(String.valueOf(y7.charAt(g4-1)));
        int z0=0+Integer.parseInt(String.valueOf(b1.charAt(3)));
        int n9=0+Integer.parseInt(String.valueOf(b1.charAt(1)));
        int q9=0+Integer.parseInt(String.valueOf(y7.charAt(g4-3)));
        int e9=0+string2Unicode(String.valueOf(s6.charAt(5)));
        String r3="game2";
        if(u3.indexOf("5566")==-1||u3.indexOf("game2")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
          url = "http://"+h0[(q8-i0-n9-z0-e9-v2-72)/q9];
        }
        return  url;
    }
   public String  x1(int e2){
       String url = "";
        String m9="7755.5566";
        String x4="=''+location.host;";
        String n5=""+"www.5566.net";
        String p6="=''+location.href;";
        String v5="4433.5566";
        String w8=""+"http://www.5566.net/game2.htm";
        int y6=n5.lastIndexOf('.');
        int e1=0+Integer.parseInt(String.valueOf(n5.charAt(y6-1)));
        int p5=0+string2Unicode(String.valueOf(x4.charAt(5)));
        int h4=0+Integer.parseInt(String.valueOf(n5.charAt(y6-3)));
        int n7=0+string2Unicode(String.valueOf(p6.charAt(6)));
        int c0=0+Integer.parseInt(String.valueOf(m9.charAt(2)));
        int d3=0+Integer.parseInt(String.valueOf(m9.charAt(0)));
        String u0="game2";
        if(n5=="5566.net"||n5=="www.5566.net"||n5=="5566.org"||n5=="1.5566.org"||n5=="2.5566.org"||n5=="3.5566.org"||n5=="4.5566.org"||n5=="5.5566.org"||n5=="www.5566.org"){
           url = "http://"+h0[(e2-h4-e1-c0-p5-n7-74)/d3];
        }
        return  url;
    }
   public String  b7(int y2){
       String url;
        String r6="=''+document.URL;";
        String y5="=''+document.domain;";
        String e6=""+"http://www.5566.net/game2.htm";
        String r0="3344.5566";
        String v5="6622.5566";
        String b9=""+"www.5566.net";
        int o6=b9.lastIndexOf('.');
        int r4=0+string2Unicode(String.valueOf(r6.charAt(6)));
        int d6=0+string2Unicode(String.valueOf(y5.charAt(5)));
        int d8=0+Integer.parseInt(String.valueOf(r0.charAt(0)));
        int f8=0+Integer.parseInt(String.valueOf(b9.charAt(o6-1)));
        int c8=0+Integer.parseInt(String.valueOf(r0.charAt(2)));
        int l9=0+Integer.parseInt(String.valueOf(b9.charAt(o6-3)));
        String y3="game2";
        if(b9!="5566.net"&&b9!="www.5566.net"&&b9!="5566.org"&&b9!="1.5566.org"&&b9!="2.5566.org"&&b9!="3.5566.org"&&b9!="4.5566.org"&&b9!="5.5566.org"&&b9!="www.5566.org"){

           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+h0[(y2-l9-d8-c8-d6-r4-22)/f8];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("s0")) {
                    tmpUrl = s0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("x1")) {
                    tmpUrl = x1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("b7")) {

                    tmpUrl = b7(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

                }
            } catch (Exception e) {
                tmpUrl = href.attr("href");
                tmpName = href.text();
            }
            if (tmpUrl.length() > 7) {

//                System.out.println(tmpUrl + "---------" + tmpName);

                inserTable(tag1, tag2, tmpUrl, tmpName);

            }
        }

    }






    public  void  getGameUrls(String url){



        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "娱乐";
        String tag2 ="游戏->小游戏";
//        System.out.println(p.get(27));
//        //16,27
        int[] numbers = {16,27};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }







    }
    public static void main(String[] args) {




        Game38 game38 = new Game38();
        game38.getGameUrls("http://www.5566.net/game2.htm");



    }





}
