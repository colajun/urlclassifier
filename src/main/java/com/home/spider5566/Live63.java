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
public class Live63 {
    String[] q0={"0","www.ganji.com/","www.fzbm.com/","www.kuxun.cn/","www.mosh.cn/","www.55bbs.com/","life.cyol.com/","www.abang.com/","www.koubei.com/","fashion.ifeng.com/life/","www.jinti.com/","www.xinhuanet.com/life/","www.liba.com/","life.qianlong.com/","www.dianping.com/","life.ku6.com/","life.21cn.com/","women.sohu.com/lohas/","www.aibang.com/","www.edeng.cn/","www.baixing.com/","life.ynet.com/","www.sg.com.cn/","www.mplife.com/","www.yoka.com/life/","www.metroer.com/","www.shzhidao.cn/"};
    String a5="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;

    public Live63() {
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

   public  String q3(int n0){
       String url;
        String h5="6644.5566";
        String q9=""+"www.5566.net";
        String q4="=''+location.hostname;";
        String h7="5511.5566";
        String e9="=''+location.href;";
        String h3=""+"http://www.5566.net/live-4.htm";
        int y2=q9.lastIndexOf('.');
        int k8=0+Integer.parseInt(String.valueOf(h5.charAt(3)));
        int y5=0+Integer.parseInt(String.valueOf(q9.charAt(y2-3)));
        int s6=0+string2Unicode(String.valueOf(q4.charAt(5)));
        int c6=0+Integer.parseInt(String.valueOf(q9.charAt(y2-1)));
        int z9=0+string2Unicode(String.valueOf(e9.charAt(6)));
        int f8=0+Integer.parseInt(String.valueOf(h7.charAt(1)));
        String y0="live";
        if(q9!="5566.net"&&q9!="www.5566.net"&&q9!="5566.org"&&q9!="1.5566.org"&&q9!="2.5566.org"&&q9!="3.5566.org"&&q9!="4.5566.org"&&q9!="5.5566.org"&&q9!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+q0[(n0-y5-c6-k8-s6-z9-46)/f8];
        }
        return  url;
    }
    public String  l8(int g9){
        String url= "";
        String z5="=''+document.location;";
        String w3=""+"http://www.5566.net/live-4.htm";
        String a2="=''+location.host;";
        String c0=""+"www.5566.net";
        String a9="1155.5566";
        String w6="3377.5566";
        int i9=c0.lastIndexOf('.');
        int y1=0+Integer.parseInt(String.valueOf(z5.charAt(6)));
        int z6=0+Integer.parseInt(String.valueOf(w6.charAt(0)));
        int r0=0+string2Unicode(String.valueOf(a2.charAt(5)));
        int l9=0+Integer.parseInt(String.valueOf(c0.charAt(i9-3)));
        int n4=0+Integer.parseInt(String.valueOf(w6.charAt(3)));
        int u0=0+Integer.parseInt(String.valueOf(c0.charAt(i9-1)));
        String  v9="live";
        if(c0=="5566.net"||c0=="www.5566.net"||c0=="5566.org"||c0=="1.5566.org"||c0=="2.5566.org"||c0=="3.5566.org"||c0=="4.5566.org"||c0=="5.5566.org"||c0=="ww.5566.org"){
            url = "http://"+q0[(g9-u0-z6-n4-r0-y1-46)/l9];
        }
        return  url;
    }
   public String  a6(int b4){
       String url;
        String k4=""+"www.5566.net";
        String z7="=''+document.URL;";
        String r3="=''+document.domain;";
        String f1="4466.5566";
        String s8=""+"http://www.5566.net/live-4.htm";
        String h5="7733.5566";
        int r6=k4.lastIndexOf('.');
        int i5=0+Integer.parseInt(String.valueOf(k4.charAt(r6-3)));
        int o8=0+string2Unicode(String.valueOf(z7.charAt(6)));
        int s5=0+string2Unicode(String.valueOf(r3.charAt(5)));
        int s4=0+Integer.parseInt(String.valueOf(k4.charAt(r6-1)));
        int j9=0+Integer.parseInt(String.valueOf(f1.charAt(1)));
        int h0=0+Integer.parseInt(String.valueOf(f1.charAt(3)));
        String g6="live";
        if(s8.indexOf("5566")==-1||s8.indexOf("live")==-1){
           url = "http://www.5566.org/indexe.htm";
        }else{
           url = "http://"+q0[(b4-i5-j9-h0-s5-o8-49)/s4];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("q3")) {
                    tmpUrl = q3(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("l8")) {
                    tmpUrl = l8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("a6")) {

                    tmpUrl = a6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

                }
            } catch (Exception e) {
                tmpUrl = href.attr("href");
                tmpName = href.text();
            }
            if (tmpUrl.length() >12) {

//                System.out.println(tmpUrl + "---------" + tmpName);

                inserTable(tag1, tag2, tmpUrl, tmpName);

            }
        }

    }



    public  void  getUrls(String url){

        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "生活";
        String tag2 = "";
//        System.out.println(p.get(17));
        //17
        int[] numbers = {17};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);
        }





    }



    public static void main(String[] args) {

        Live63 live63 = new Live63();
        live63.getUrls("http://www.5566.net/live-4.htm");




    }




}
