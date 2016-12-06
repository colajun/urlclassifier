package com.home.spider5566;

import com.home.spring.JDBCHelper;
import org.apache.hadoop.mapreduce.v2.proto.MRProtos;
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
public class Lq77 {
    String[] l2={"0","blog.qq.com/feeling/","emo.tianya.cn/","lady.qq.com/emo/emotio.shtml","emotion.pclady.com.cn/","lady.163.com/sense/","www.brides.com.cn/","bbs.tianya.cn/list-feeling-1.shtml","eladies.sina.com.cn/feel/index.shtml","emotion.rayli.com.cn/","www.zhiyin.cn/","fashion.ifeng.com/emotion/","www.xfwed.com/","www.zhongxinta.com/","www.99wed.com/","www.xici.net/Feeling/","astro.fashion.qq.com/psy/lovepsy_index.shtml"};
    String k4="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public Lq77(){
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

   public String  t9(int a2){
       String url;
       String  l5="5533.5566";
        String p9=""+"http://www.5566.net/iq-7.htm";
        String o5="=''+document.domain;";
        String y7="7788.5566";
        String v3=""+"www.5566.net";
        String m6="=''+location.href;";
        int i9=v3.lastIndexOf('.');
        int p0=0+Integer.parseInt(String.valueOf(y7.charAt(2)));
        int r6=0+Integer.parseInt(String.valueOf(y7.charAt(0)));
        int z5=0+string2Unicode(String.valueOf(o5.charAt(5)));
        int l3=0+Integer.parseInt(String.valueOf(v3.charAt(i9-1)));
        int a9=0+Integer.parseInt(String.valueOf(v3.charAt(i9-3)));
        int l9=0+string2Unicode(String.valueOf(m6.charAt(6)));
        String e7="iq";
        if(p9.indexOf("5566")==-1||p9.indexOf("iq")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+l2[(a2-a9-l3-p0-z5-l9-6)/r6];
        }
        return  url;
    }
    public String  u6(int q3){
        String url= "";
        String c7=""+"http://www.5566.net/iq-7.htm";
        String b3="=''+location.host;";
        String h2="3355.5566";
        String r3=""+"www.5566.net";
        String d8="=''+document.URL;";
        String l5="6622.5566";
        int n0=r3.lastIndexOf('.');
        int x4=0+Integer.parseInt(String.valueOf(h2.charAt(1)));
        int i4=0+string2Unicode(String.valueOf(b3.charAt(5)));
        int a8=0+Integer.parseInt(String.valueOf(r3.charAt(n0-1)));
        int x1=0+Integer.parseInt(String.valueOf(r3.charAt(n0-3)));
        int m3=0+string2Unicode(String.valueOf(d8.charAt(6)));
        int h1=0+Integer.parseInt(String.valueOf(h2.charAt(3)));
        String t6="iq";
        if(c7.indexOf("5566")>=0&&c7.indexOf("iq")>=0){
           url = "http://"+l2[(q3-x1-x4-h1-i4-m3-58)/a8];
        }
        return  url;
    }
   public String  p1(int u3){
       String url ;
       String  y3="2266.5566";
        String s7="=''+location.hostname;";
        String o4=""+"http://www.5566.net/iq-7.htm";
        String t8="8877.5566";
        String z7="=''+document.location;";
        String b8=""+"www.5566.net";
        int q2=b8.lastIndexOf('.');
        int f8=0+Integer.parseInt(String.valueOf(b8.charAt(q2-1)));
        int k9=0+string2Unicode(String.valueOf(s7.charAt(5)));
        int m0=0+Integer.parseInt(String.valueOf(y3.charAt(0)));
        int l8=0+Integer.parseInt(String.valueOf(y3.charAt(3)));
        int n8=0+string2Unicode(String.valueOf(z7.charAt(6)));
        int r5=0+Integer.parseInt(String.valueOf(b8.charAt(q2-3)));
        String u0="iq";
        if(b8!="5566.net"&&b8!="www.5566.net"&&b8!="5566.org"&&b8!="1.5566.org"&&b8!="2.5566.org"&&b8!="3.5566.org"&&b8!="4.5566.org"&&b8!="5.5566.org"&&b8!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+l2[(u3-f8-m0-l8-k9-n8-87)/r5];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("t9")) {
                    tmpUrl = t9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("u6")) {
                    tmpUrl = u6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("p1")) {

                    tmpUrl = p1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
        String tag2 = "情感_爱情";
//        System.out.println(p.get(16));
//        //16,27
        int[] numbers = {16, 27};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }



    }

    public static void main(String[] args) {

        Lq77 lq77 = new Lq77();
        lq77.getUrls("http://www.5566.net/iq-7.htm");

    }






}
