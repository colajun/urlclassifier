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
public class TU32 {
    String[] o1={"0","photo.163.com/","photo.qq.com/","www.ivsky.com/","www.tibetpic.com/tppd/","tu.poco.cn/","ent.qq.com/picture.shtml","www.dabaoku.com/sucai/","pp.sohu.com/","www.bababian.com/","www.pclady.com.cn/photo/","image.haosou.com/","ent.ifeng.com/photo/yulexianchang/list_0/0.shtml","www.ccnpic.com/","www.ooopic.com/","www.gettyimages.cn/index/index","et.21cn.com/picture/","hi.mop.com/","www.viewstock.com/","www.tineye.com/","www.3lian.com/","photo.67.com/","www.fotoe.com/","www.aiimg.com/","www.cntuw.com/","pic.sogou.com/","www.sucaitianxia.com/","www.dfic.cn/","www.tucoo.com/","ent.163.com/photo/","www.nipic.com/","yule.sohu.com/hotpics/","photo.hexun.com/","www.wmpic.me/","tuku.ent.china.com/fun/index.html","www.yupoo.com/"};
    String a3="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public TU32(){
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


    public String c9(int i8){
        String url = "";
        String z6=""+"http://www.5566.net/tu-4.htm";
        String y0="9944.5566";
        String f2="=''+location.href;";
        String c2="=''+location.hostname;";
        String v0=""+"www.5566.net";
        String s8="2211.5566";
        int d1=v0.lastIndexOf('.');
        int h3=0+Integer.parseInt(String.valueOf(s8.charAt(1)));
        int h4=0+Integer.parseInt(String.valueOf(s8.charAt(2)));
        int x2=0+string2Unicode(String.valueOf(f2.charAt(6)));
        int y6=0+string2Unicode(String.valueOf(c2.charAt(5)));
        int g6=0+Integer.parseInt(String.valueOf(v0.charAt(d1-3)));
        int n0=0+Integer.parseInt(String.valueOf(v0.charAt(d1-1)));
        String e6="tu";
        if(v0=="5566.net"||v0=="www.5566.net"||v0=="5566.org"||v0=="1.5566.org"||v0=="2.5566.org"||v0=="3.5566.org"||v0=="4.5566.org"||v0=="5.5566.org"||v0=="www.5566.org"){
           url = "http://"+o1[(i8-n0-h3-h4-y6-x2-61)/g6];
        }
        return  url;
    }
    public String  q8(int s0){
        String url ;
        String e1="=''+document.URL;";
        String f9=""+"http://www.5566.net/tu-4.htm";
        String c8="3377.5566";
        String s7="=''+document.domain;";
        String  y5="4499.5566";
        String m8=""+"www.5566.net";
        int o2=m8.lastIndexOf('.');
        int m1=0+string2Unicode(String.valueOf(e1.charAt(6)));
        int n9=0+Integer.parseInt(String.valueOf(y5.charAt(0)));
        int g2=0+Integer.parseInt(String.valueOf(y5.charAt(2)));
        int j1=0+string2Unicode(String.valueOf(s7.charAt(5)));
        int v7=0+Integer.parseInt(String.valueOf(m8.charAt(o2-1)));
        int g9=0+Integer.parseInt(String.valueOf(m8.charAt(o2-3)));
        String m5="tu";
        if(m8!="5566.net"&&m8!="www.5566.net"&&m8!="5566.org"&&m8!="1.5566.org"&&m8!="2.5566.org"&&m8!="3.5566.org"&&m8!="4.5566.org"&&m8!="5.5566.org"&&m8!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+o1[(s0-g9-v7-g2-j1-m1-68)/n9];
        }
    return  url;
    }

    public  String x8(int z3){
        String url;
        String u2="=''+location.host;";
        String m9="7733.5566";
        String g3="=''+document.location;";
        String c8="1122.5566";
        String i4=""+"www.5566.net";
        String o3=""+"http://www.5566.net/tu-4.htm";
        int a5=i4.lastIndexOf('.');
        int h0=0+string2Unicode(String.valueOf(u2.charAt(5)));
        int f5=0+Integer.parseInt(String.valueOf(i4.charAt(a5-1)));
        int q1=0+string2Unicode(String.valueOf(g3.charAt(6)));
        int t8=0+Integer.parseInt(String.valueOf(m9.charAt(2)));
        int z7=0+Integer.parseInt(String.valueOf(i4.charAt(a5-3)));
        int q4=0+Integer.parseInt(String.valueOf(m9.charAt(0)));
        String o5="tu";
        if(o3.indexOf("5566")==-1||o3.indexOf("tu")==-1){

           url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+o1[(z3-z7-q4-t8-h0-q1-49)/f5];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("c9")) {
                    tmpUrl = c9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("q8")) {
                    tmpUrl = q8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("x8")) {

                    tmpUrl = x8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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


public  void getTuUrls(String url){


    Document doc=null;
    try {
        doc = Jsoup.connect(url).get();
    } catch (IOException e) {
        e.printStackTrace();
    }

    Elements p = doc.getElementsByTag("tr");
    String tag1 = "娱乐";
    String tag2 ="图片";
//        System.out.println(p.get(42));
//        //20,32,
    int[] numbers = {20,32, 42};
    for(int i =0;i < numbers.length;i++){

        Elements urls = p.get(numbers[i]).getElementsByTag("a");
        getUrlAndText(urls, tag1, tag2);

    }




}



    public static void main(String[] args) {

        TU32 tu32 = new TU32();

        tu32.getTuUrls("http://www.5566.net/tu-4.htm");

    }



}
