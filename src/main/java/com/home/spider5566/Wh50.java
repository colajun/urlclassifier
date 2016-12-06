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
public class Wh50 {
    String[] p7={"0","www.sach.gov.cn/","www.chnmuseum.cn/","history.sina.com.cn/","www.sznews.com/culture/index.htm","www.epicbook.com/history/index.htm","www.ccm.gov.cn/","culture.china.com/","culture.cnhubei.com/","www.tibetculture.net/","www.hxlsw.com/","culture.china.com/zh_cn/history/","www.zjcnt.com/","news.ifeng.com/history/","cul.jschina.com.cn/","culture.gmw.cn/","news.163.com/history/","www.china.com.cn/culture/node_5001718.htm","www.mcprc.gov.cn/","www.tqxz.com/","www.dpm.org.cn/","culture.ifeng.com/","www.wenbao.net/","culture.people.com.cn/","www.gdwh.com.cn/","cul.jschina.com.cn/","cul.sohu.com/","www.culturalink.gov.cn/","www.bjwh.gov.cn/","www.zjwh.gov.cn/","www.todayonhistory.com/","www.lishi5.com/","www.lsfyw.net/","www.ccdy.cn/","www.chinanews.com/cul/","www.chengduwenhua.gov.cn/","history.people.com.cn/","www.njmuseum.com/","www.lszj.com/","www.ce.cn/culture/","www.china1840-1949.net.cn/","www.ahage.net/","cul.history.sina.com.cn/","www.zh5000.com/","www.ccrnews.com.cn/","www.wenbao.net/","news.china.com/zh_cn/history/index.html","www.teaw.com/","beijingww.qianlong.com/","www.gdwht.gov.cn/","cul.sohu.com/shuoshi/","www.historykingdom.com/","www.tibetcul.com/","www.qmhistory.cn/","www.zgctwh.com.cn/","www.ccnt.com.cn"};
    String a8="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;

    public Wh50() {
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



   public String  b3(int v5){
       String url;
        String d6="1133.5566";
        String v0="4499.5566";
        String h6="=''+location.hostname;";
        String e5="=''+document.location;";
        String f2=""+"http://www.5566.net/wh-2.htm";
        String o3=""+"www.5566.net";
        int k1=o3.lastIndexOf('.');
        int v2=0+Integer.parseInt(String.valueOf(v0.charAt(3)));
        int z9=0+Integer.parseInt(String.valueOf(o3.charAt(k1-1)));
        int  y6=0+string2Unicode(String.valueOf(h6.charAt(5)));
        int q4=0+string2Unicode(String.valueOf(e5.charAt(6)));
        int m1=0+Integer.parseInt(String.valueOf(v0.charAt(0)));
        int v6=0+Integer.parseInt(String.valueOf(o3.charAt(k1-2)));
        String c2="wh";
        if(o3!="5566.net"&&o3!="www.5566.net"&&o3!="5566.org"&&o3!="1.5566.org"&&o3!="2.5566.org"&&o3!="3.5566.org"&&o3!="4.5566.org"&&o3!="5.5566.org"&&o3!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{url = "http://"+p7[(v5-v6-m1-v2-y6-q4-77)/z9];
        }
        return  url;
    }
    public String  y1(int v1){
        String url="";
        String y9="=''+document.domain;";
        String f9="3311.5566";
        String a6=""+"www.5566.net";
        String a4="7766.5566";
        String k8=""+"http://www.5566.net/wh-2.htm";
        String b4="=''+location.href;";
        int p5=a6.lastIndexOf('.');
        int c1=0+string2Unicode(String.valueOf(y9.charAt(5)));
        int r8=0+Integer.parseInt(String.valueOf(a6.charAt(p5-1)));
        int u6=0+Integer.parseInt(String.valueOf(a6.charAt(p5-3)));
        int d4=0+Integer.parseInt(String.valueOf(f9.charAt(3)));
        int s2=0+Integer.parseInt(String.valueOf(f9.charAt(1)));
        int t8=0+string2Unicode(String.valueOf(b4.charAt(6)));
        String z1="wh";
        if(k8.indexOf("5566")>=0&&k8.indexOf("wh")>=0){
           url = "http://"+p7[(v1-r8-s2-d4-c1-t8-18)/u6];
        }
        return  url;
    }
   public String  v9(int n2){
       String url;
        String y0="6677.5566";
        String d6="9944.5566";
        String q9="=''+document.URL;";
        String v4=""+"www.5566.net";
        String u8=""+"http://www.5566.net/wh-2.htm";
        String s4="=''+location.host;";
        int a2=v4.lastIndexOf('.');
        int x5=0+Integer.parseInt(String.valueOf(v4.charAt(a2-1)));
        int a1=0+Integer.parseInt(String.valueOf(y0.charAt(2)));
        int s3=0+string2Unicode(String.valueOf(q9.charAt(6)));
        int h8=0+Integer.parseInt(String.valueOf(v4.charAt(a2-3)));
        int v3=0+Integer.parseInt(String.valueOf(y0.charAt(1)));
        int r3=0+string2Unicode(String.valueOf(s4.charAt(5)));
        String d3="wh";
        if(u8.indexOf("5566")==-1||u8.indexOf("wh")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+p7[(n2-h8-x5-a1-r3-s3-86)/v3];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("b3")) {
                    tmpUrl = b3(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("v9")) {
                    tmpUrl = v9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("y1")) {

                    tmpUrl = y1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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


    public  void getUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "文化艺术";
        String tag2 ="文化历史";
//        System.out.println(p.get(32));
        //16,32
        int[] numbers = {16,32};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }







    }

    public static void main(String[] args) {


        Wh50 wh50 = new Wh50();
        wh50.getUrls("http://www.5566.net/wh-2.htm");


    }








}
