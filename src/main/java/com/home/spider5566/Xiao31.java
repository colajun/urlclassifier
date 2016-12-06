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
 * Created by hadoop on 16-11-22.
 */
public class Xiao31 {
    String[] p4={"0","www.biedoul.com/","www.gaoxiaola.com/","www.juyouqu.com/","www.xiaohuayoumo.com/","www.xuexila.com/jzw/","www.xxhh.com/videos","www.9yaocn.com/","www.zbjuran.com/","www.kaixinyizhan.com/","xiaohua.zol.com.cn/","www.jiefu.tv/","www.pengfu.com/","paper.people.com.cn/fcyym/","www.joke01.com/","fun.iqiyi.com/","www.jijidi.com/","lengxiaohua.com/","www.gbfzh.com/","x.heshuicun.com/","fun.tudou.com/","www.joke66.com/","www.cmiyu.com/miyujingxuan/6582.html","www.2njjzw.com/","list.letv.com/listn/c30_t592011_md_o1_d2_p.html","www.3jy.com/","www.poptool.net/chinese/naojin/zhuan_1.html","www.mahua.com/","bbs.tiexue.net/bbs80-0-1.html","www.laifudao.com/","www.gaoxiaovod.com/","www.xiaohua.com/","joke.ku6.com/","bbs.tianya.cn/list-14-1.shtml","www.xxhh.com/","www.baomihua.com/funny","xiaohua.jb51.net/","www.haha365.com/jzw/","www.jokeji.cn/","www.gxdxw.cn/"};
    String j3="http://www.5566.org/indexe.htm";
    JdbcTemplate jdbcTemplate = null;
    public Xiao31(){
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


   public String  b1(int a8){
       String url;
        String c8="=''+document.domain;";
        String f5="=''+document.location;";
        String f2=""+"www.5566.net";
        String x2="2255.5566";
        String n1="8811.5566";
        String j5=""+"http://www.5566.net/xiao-6.htm";
        int e4=f2.lastIndexOf('.');
        int y3=0+string2Unicode(String.valueOf(c8.charAt(5)));
        int s5=0+string2Unicode(String.valueOf(f5.charAt(6)));
        int h1=0+Integer.parseInt(String.valueOf(f2.charAt(e4-3)));
        int i3=0+Integer.parseInt(String.valueOf(f2.charAt(e4-1)));
       int n2=0+Integer.parseInt(String.valueOf(x2.charAt(2)));
        int h3=0+Integer.parseInt(String.valueOf(x2.charAt(0)));
        String u9="xiao";
        if(f2!="5566.net"&&f2!="www.5566.net"&&f2!="5566.org"&&f2!="1.5566.org"&&f2!="2.5566.org"&&f2!="3.5566.org"&&f2!="4.5566.org"&&f2!="5.5566.org"&&f2!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+p4[(a8-h1-i3-n2-y3-s5-94)/h3];
        }
        return  url;
    }
    public String  j2(int b6){
        String url;
        String w2="1188.5566";
        String n1="4433.5566";
        String k2=""+"www.5566.net";
        String d5=""+"http://www.5566.net/xiao-6.htm";
        String f3="=''+location.hostname;";
        String s3="=''+location.href;";
        int d8=k2.lastIndexOf('.');
        int n5=0+Integer.parseInt(String.valueOf(k2.charAt(d8-1)));
        int a2=0+Integer.parseInt(String.valueOf(w2.charAt(3)));
        int w3=0+Integer.parseInt(String.valueOf(k2.charAt(d8-3)));
        int v7=0+Integer.parseInt(String.valueOf(w2.charAt(0)));
        int s4=0+string2Unicode(String.valueOf(f3.charAt(5)));
        int d3=0+string2Unicode(String.valueOf(s3.charAt(6)));
        String y0="xiao";
        if(d5.indexOf("5566")==-1||d5.indexOf("xiao")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+p4[(b6-w3-v7-a2-s4-d3-75)/n5];
        }
        return  url;
    }
    public String  e1(int p5){
        String url = "";
        String h9="5522.5566";
        String n4="3344.5566";
        String p1="=''+document.URL;";
        String y5=""+"http://www.5566.net/xiao-6.htm";
        String q0="=''+location.host;";
        String a3=""+"www.5566.net";
        int i9=a3.lastIndexOf('.');
        int f7=0+Integer.parseInt(String.valueOf(n4.charAt(3)));
        int z9=0+Integer.parseInt(String.valueOf(a3.charAt(i9-1)));
        int u2=0+string2Unicode(String.valueOf(p1.charAt(6)));
        int j8=0+Integer.parseInt(String.valueOf(n4.charAt(1)));
        int b9=0+string2Unicode(String.valueOf(q0.charAt(5)));
        int o5=0+Integer.parseInt(String.valueOf(a3.charAt(i9-3)));
        String w6="xiao";
        if(a3=="5566.net"||a3=="www.5566.net"||a3=="5566.org"||a3=="1.5566.org"||a3=="2.5566.org"||a3=="3.5566.org"||a3=="4.5566.org"||a3=="5.5566.org"||a3=="www.5566.org"){
           url = "http://"+p4[(p5-z9-j8-f7-b9-u2-8)/o5];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("b1")) {
                    tmpUrl = b1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("j2")) {
                    tmpUrl = j2(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("e1")) {

                    tmpUrl = e1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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




    public  void getXiaoUrls(String url){


        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "娱乐休闲";
        String tag2 ="笑话幽默";
//        System.out.println(p.get(48));
//        //16,30,39,48
        int[] numbers = {16,30,39,48};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }





    }



    public static void main(String[] args) {
        Xiao31 xiao31 = new Xiao31();

        xiao31.getXiaoUrls("http://www.5566.net/xiao-6.htm");


    }







}
