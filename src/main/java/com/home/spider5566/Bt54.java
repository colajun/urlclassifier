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
 * Created by hadoop on 16-11-25.
 */
public class Bt54 {

    String[] o5={"0","bbs.uubird.com/","www.btbbt.cc/","www.bttt8.com/","www.dygod.net/","www.btdao.org/","www.verycd.com/","bbs.btmyth.com/","www.bitcomet.com/index-zh.htm","www.yyets.com/","bbs.btwuji.com/","www.btba.com.cn/","www.mp4ba.com/","www.btshoufa.com/","www.piaohua.com/","www.kugoo.com/","www.bttiantang.com/","www.y4dg.com/","www.bthand.com/","www.emule-project.net/","www.emule.org.cn/","emulefans.com/","www.bitfish8.net/","dl.xunlei.com/","www.fun.tv/download","henbt.com/","www.bitspirit.cc/","shooter.cn/","btkitty.co/","www.okbt.com/","www.mmybt.com/"};
    String f2="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;

    public Bt54() {
        try {
            jdbcTemplate = JDBCHelper.createMysqlTemplate("mysql1", "jdbc:mysql://192.168.21.60/urlclassifier?useUnicode=true&characterEncoding=utf8", "root", "root", 5, 30);

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

   public String  u1(int p6){
       String url;
        String j0=""+"http://www.5566.net/bt.htm";
        String r4="3355.5566";
        String i4="=''+document.URL;";
        String g7="=''+location.hostname;";
        String c9="4477.5566";
        String i1=""+"www.5566.net";
        int x6=i1.lastIndexOf('.');
        int s2=0+Integer.parseInt(String.valueOf(r4.charAt(0)));
        int u6=0+Integer.parseInt(String.valueOf(i1.charAt(x6-1)));
        int s5=0+string2Unicode(String.valueOf(i4.charAt(6)));
        int v0=0+string2Unicode(String.valueOf(g7.charAt(5)));
        int o3=0+Integer.parseInt(String.valueOf(r4.charAt(2)));
        int q3=0+Integer.parseInt(String.valueOf(i1.charAt(x6-3)));
        String d8="bt";
        if(j0.indexOf("5566")==-1||j0.indexOf("bt")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+o5[(p6-q3-u6-o3-v0-s5-65)/s2];
        }
        return  url;
    }
   public String  h4(int p7){
       String url;
        String j5="=''+location.href;";
        String w7=""+"www.5566.net";
        String a8="7744.5566";
        String c9="8822.5566";
        String w8=""+"http://www.5566.net/bt.htm";
        String a6="=''+document.domain;";
        int w4=w7.lastIndexOf('.');
        int t1=0+string2Unicode(String.valueOf(j5.charAt(6)));
        int c8=0+Integer.parseInt(String.valueOf(w7.charAt(w4-3)));
        int m3=0+Integer.parseInt(String.valueOf(w7.charAt(w4-1)));
        int c4=0+Integer.parseInt(String.valueOf(a8.charAt(3)));
        int l3=0+Integer.parseInt(String.valueOf(a8.charAt(0)));
        int m5=0+string2Unicode(String.valueOf(a6.charAt(5)));
        String w1="bt";
        if(w7!="5566.net"&&w7!="www.5566.net"&&w7!="5566.org"&&w7!="1.5566.org"&&w7!="2.5566.org"&&w7!="3.5566.org"&&w7!="4.5566.org"&&w7!="5.5566.org"&&w7!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+o5[(p7-c8-l3-c4-m5-t1-77)/m3];
        }
        return  url;
    }
   public String  c5(int l4){
       String url = "";
        String v4="2288.5566";
        String o4="5533.5566";
        String x1="=''+document.location;";
        String e3=""+"http://www.5566.net/bt.htm";
        String a3=""+"www.5566.net";
        String n7="=''+location.host;";
        int p3=a3.lastIndexOf('.');
        int v5=0+Integer.parseInt(String.valueOf(a3.charAt(p3-1)));
        int l2=0+Integer.parseInt(String.valueOf(v4.charAt(2)));
        int q7=0+string2Unicode(String.valueOf(x1.charAt(6)));
        int m9=0+Integer.parseInt(String.valueOf(v4.charAt(0)));
        int t7=0+Integer.parseInt(String.valueOf(a3.charAt(p3-3)));
        int u5=0+string2Unicode(String.valueOf(n7.charAt(5)));
        String y6="bt";
        if(e3.indexOf("5566")>=0&&e3.indexOf("bt")>=0){
           url = "http://"+o5[(l4-v5-m9-l2-u5-q7-32)/t7];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("u1")) {
                    tmpUrl = u1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("c5")) {
                    tmpUrl = c5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("h4")) {

                    tmpUrl = h4(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

                }
            } catch (Exception e) {
                tmpUrl = href.attr("href");
                tmpName = href.text();
            }
            if (tmpUrl.length() >11) {

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
        String tag1 = "电脑网络";
        String tag2 ="下载 -> BT下载";
//        System.out.println(p.get(29));
        //16, 29
        int[] numbers = {16,29};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }







    }


    public static void main(String[] args) {

        Bt54 bt54 = new Bt54();
        bt54.getUrls("http://www.5566.net/bt.htm");




    }





}
