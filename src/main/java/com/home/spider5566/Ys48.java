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
 * Created by hadoop on 16-11-24.
 */
public class Ys48 {
    String[] a1={"0","www.artx.cn/","www.newart21cn.com/","bbs.21nowart.com/","www.gdwyw.cn/","www.artsbuy.com/","www.zhuokearts.com/","www.gg-art.com/index_g.php","www.jingp.com/","www.arting365.com/","abbs.com.cn/abbs/","www.dpm.org.cn/","www.chinadance.cn/","www.artron.net/","www.gjart.cn/","www.zh5000.com/","www.chinaartsweb.com/","www.chinavisual.com/","www.99ys.com/","www.artnews.cn/","art.china.cn/","www.artspy.cn/","www.dangdaiyishu.com/","www.cgan.net/","114.255.205.160/","forum.book.sina.com.cn/forum-32-1.html","art.china.cn/","www.yahqq.com/","www.21nowart.com/","www.artchn.com/","www.xdsf.com/","www.artso.net/","www.yishujie.com/","www.artsweb.cn/","www.cl2000.com/","www.cnarts.net/cweb/","www.cqart.com/","www.artxun.com/"};
    String f3="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;

    public Ys48() {
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

   public String  x3(int g5){
       String url;
        String d4="=''+location.hostname;";
        String l8="5511.5566";
        String x8="6633.5566";
        String z4=""+"http://www.5566.net/ys-4.htm";
        String z0=""+"www.5566.net";
        String y4="=''+location.href;";
        int t5=z0.lastIndexOf('.');
        int q6=0+string2Unicode(String.valueOf(d4.charAt(5)));
        int z8=0+Integer.parseInt(String.valueOf(x8.charAt(2)));
        int c8=0+Integer.parseInt(String.valueOf(z0.charAt(t5-1)));
        int y5=0+Integer.parseInt(String.valueOf(x8.charAt(1)));
        int e5=0+Integer.parseInt(String.valueOf(z0.charAt(t5-3)));
        int m3=0+string2Unicode(String.valueOf(y4.charAt(6)));
        String x9="ys";
        if(z0!="5566.net"&&z0!="www.5566.net"&&z0!="5566.org"&&z0!="1.5566.org"&&z0!="2.5566.org"&&z0!="3.5566.org"&&z0!="4.5566.org"&&z0!="5.5566.org"&&z0!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+a1[(g5-e5-c8-z8-q6-m3-75)/y5];
        }
        return  url;
    }
    public String  q1(int c7){
        String url= "";
        String i7=""+"www.5566.net";
        String d6=""+"http://www.5566.net/ys-4.htm";
        String l2="=''+document.location;";
        String u6="=''+document.domain;";
        String z2="3366.5566";
        String u4="7744.5566";
        int j9=i7.lastIndexOf('.');
        int h4=0+Integer.parseInt(String.valueOf(i7.charAt(j9-3)));
        int u1=0+Integer.parseInt(String.valueOf(u4.charAt(0)));
        int w8=0+string2Unicode(String.valueOf(l2.charAt(6)));
        int h7=0+string2Unicode(String.valueOf(u6.charAt(5)));
        int v8=0+Integer.parseInt(String.valueOf(u4.charAt(2)));
        int r9=0+Integer.parseInt(String.valueOf(i7.charAt(j9-1)));
        String o4="ys";
        if(d6.indexOf("5566")>=0&&d6.indexOf("ys")>=0){
           url = "http://"+a1[(c7-r9-u1-v8-h7-w8-53)/h4];
        }
        return  url;
    }
    public String  s8(int s4){
        String url = "";
        String h6=""+"http://www.5566.net/ys-4.htm";
        String y9="1155.5566";
        String l8="4477.5566";
        String z9="=''+location.host;";
        String q4=""+"www.5566.net";
        String d0="=''+document.URL;";
        int k4=q4.lastIndexOf('.');
        int c5=0+Integer.parseInt(String.valueOf(y9.charAt(1)));
        int x5=0+Integer.parseInt(String.valueOf(q4.charAt(k4-1)));
        int t6=0+Integer.parseInt(String.valueOf(y9.charAt(2)));
        int f0=0+string2Unicode(String.valueOf(z9.charAt(5)));
        int h2=0+Integer.parseInt(String.valueOf(q4.charAt(k4-3)));
        int g3=0+string2Unicode(String.valueOf(d0.charAt(6)));
        String n2="ys";
        if(q4=="5566.net"||q4=="www.5566.net"||q4=="5566.org"||q4=="1.5566.org"||q4=="2.5566.org"||q4=="3.5566.org"||q4=="4.5566.org"||q4=="5.5566.org"||q4=="www.5566.org"){
          url = "http://"+a1[(s4-h2-c5-t6-f0-g3-42)/x5];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("x3")) {
                    tmpUrl = x3(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("q1")) {
                    tmpUrl = q1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("s8")) {

                    tmpUrl = s8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

                }
            } catch (Exception e) {
                tmpUrl = href.attr("href");
                tmpName = href.text();
            }
            if (tmpUrl.length() > 2) {

//                System.out.println(tmpUrl + "---------" + tmpName);

                inserTable(tag1, tag2, tmpUrl, tmpName);

            }
        }

    }



    public  void  getYsUrls(String url){


        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "文化艺术";
        String tag2 ="艺术";
//        System.out.println(p.get(16));
        //16,34,43,53
        int[] numbers = {16};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }








    }
    public static void main(String[] args) {


        Ys48 ys48 = new Ys48();
        ys48.getYsUrls("http://www.5566.net/ys-4.htm");


    }









}
