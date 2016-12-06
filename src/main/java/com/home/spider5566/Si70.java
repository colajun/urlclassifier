package com.home.spider5566;

import com.home.spring.JDBCHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;

/**
 * Created by hadoop on 16-11-27.
 */
public class Si70 {
    String[] t6={"0","www.chinasspp.com/","www.vsuch.com/","www.yoka.com/","fashion.efu.com.cn/","www.fandongxi.com/","www.haibao.com/","www.nanrenzhuang.net/","www.haxiu.com/","fashion.163.com/","www.pclady.com.cn/","gb.cri.cn/fashion/","www.pcpp.com.cn/","www.trends.com.cn/","www.chinese-luxury.com/","fashion.sohu.com/","fashion.msn.com.cn/","www.vogue.com.cn/","fashion.cnool.net/","www.ellechina.com/","www.mrmodern.com/","www.6m.com/","bbs.trends.com.cn/","lux.hexun.com/","www.moochic.com/","fashion.ifeng.com/","fashion.cnool.net/","fashion.qq.com/","www.mplife.com/","www.mcchina.com/","www.mina.com.cn/","fashion.sina.com.cn/","www.news.cn/fashion/","fashion.ef360.com/"};
    String k1="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public Si70(){
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


   public String  f6(int t1){
       String url ;
        String r6="6699.5566";
        String s8="=''+document.URL;";
        String r1=""+"http://www.5566.net/si-6.htm";
        String h3=""+"www.5566.net";
        String r3="3322.5566";
        String n2="=''+location.hostname;";
        int d8=h3.lastIndexOf('.');
        int j1=0+Integer.parseInt(String.valueOf(h3.charAt(d8-1)));
        int s2=0+string2Unicode( String.valueOf(s8.charAt(6)));
        int v1=0+Integer.parseInt(String.valueOf(r6.charAt(1)));
        int q9=0+Integer.parseInt(String.valueOf(h3.charAt(d8-3)));
        int j7=0+Integer.parseInt(String.valueOf(r6.charAt(3)));
        int c1=0+string2Unicode(String.valueOf(n2.charAt(5)));
        String v5="si";
        if(h3!="5566.net"&&h3!="www.5566.net"&&h3!="5566.org"&&h3!="1.5566.org"&&h3!="2.5566.org"&&h3!="3.5566.org"&&h3!="4.5566.org"&&h3!="5.5566.org"&&h3!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+t6[(t1-q9-j1-j7-c1-s2-64)/v1];
        }
        return  url;
    }
    public String  q4(int b3){
        String url="";
        String u7="=''+document.location;";
        String l1="9966.5566";
        String t5=""+"www.5566.net";
        String n6=""+"http://www.5566.net/si-6.htm";
        String d5="4411.5566";
        String s0="=''+document.domain;";
        int l0=t5.lastIndexOf('.');
        int f3=0+string2Unicode( String.valueOf(u7.charAt(6)));
        int c2=0+Integer.parseInt(String.valueOf(d5.charAt(3)));
        int h4=0+Integer.parseInt(String.valueOf(t5.charAt(l0-3)));
       int o8=0+Integer.parseInt(String.valueOf(d5.charAt(0)));
        int s9=0+Integer.parseInt(String.valueOf(t5.charAt(l0-1)));
        int w7=0+string2Unicode(String.valueOf(s0.charAt(5)));
        String o3="si";
        if(t5=="5566.net"||t5=="www.5566.net"||t5=="5566.org"||t5=="1.5566.org"||t5=="2.5566.org"||t5=="3.5566.org"||t5=="4.5566.org"||t5=="5.5566.org"||t5=="www.5566.org"){
           url = "http://"+t6[(b3-s9-o8-c2-w7-f3-50)/h4];
        }
        return  url;
    }
   public String  e9(int l2){
       String url = "";
        String f8="=''+location.host;";
        String m1=""+"www.5566.net";
        String d0="=''+location.href;";
        String r3="1144.5566";
        String l8="2233.5566";
        String u6=""+"http://www.5566.net/si-6.htm";
        int m3=m1.lastIndexOf('.');
        int z4=0+string2Unicode(String.valueOf(f8.charAt(5)));
        int w2=0+Integer.parseInt(String.valueOf(m1.charAt(m3-3)));
        int i6=0+string2Unicode(String.valueOf(d0.charAt(6)));
       int  u9=0+Integer.parseInt(String.valueOf(l8.charAt(2)));
        int p0=0+Integer.parseInt(String.valueOf(m1.charAt(m3-1)));
        int e5=0+Integer.parseInt(String.valueOf(l8.charAt(1)));
       String x0="si";
        if(u6.indexOf("5566")>=0&&u6.indexOf("si")>=0){
           url = "http://"+t6[(l2-w2-e5-u9-z4-i6-25)/p0];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("f6")) {
                    tmpUrl = f6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("q4")) {
                    tmpUrl = q4(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("e9")) {

                    tmpUrl = e9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
        String tag2 = "时尚";
//        System.out.println(p.get(16));
//        //20,37
        int[] numbers = {16};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }

    }
    public static void main(String[] args) {

        Si70 si70 =new Si70();

        si70.getUrls("http://www.5566.net/si-6.htm");


    }



}
