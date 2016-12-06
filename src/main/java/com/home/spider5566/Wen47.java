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
 * Created by hadoop on 16-11-24.
 */
public class Wen47 {

    String[] l0={"0","www.xxsy.net/","book.douban.com/","hjsm.tom.com/","www.junshishu.com/","book.qq.com/","www.rongshuxia.com/","www.poemlife.com/","bbs.jooyoo.net/","www.shigeku.org/","club.history.sina.com.cn/forum-14-1.html","sq.qidian.com/Club/ClubIndex.aspx","www.feiku.com/","www.docin.com/","bbs.tianya.cn/list-culture-1.shtml","www.aitxt.com/","www.kanshu.com/","bbs.tianya.cn/list-no124-1.shtml","www.zhulang.com/","www.hongxiu.com/","www.feifantxt.com/","www.huanxia.com/","www.yzs.com/","www.6mj.com","bbs.hongxiu.com/","www.17k.com/","wind.yinsha.com/","www.bookgew.com/","www.fmx.cn/","www.du8.com/","www.lightnovel.cn/","www.qnwz.cn/","www.zongheng.com/","www.guoxue.com/","www.lcread.com/","book.sohu.com/","www.readnovel.com/","txt.nokiacn.net/","book.ifeng.com/","www.chinawriter.com.cn/","www.xs8.cn/","www.storychina.cn/","www.tingbook.com/","bbs.chinapoet.net/","www.rain8.com/","www.writermagazine.cn/","www.rongshuxia.com/","www.hongxiu.com/view/s/4__1.html","www.zuojia.net.cn/","www.qidian.com/","www.txtbbs.com/","chuangshi.qq.com/","www.xdyqw.com/","www.poetry-cn.com/","book.sina.com.cn/","bbs.txtnovel.com/","www.jjwxc.net/","www.fbook.net/","www.yuncheng.com/","www.qdmm.com/","www.xiaoxiaoshuo.com/","www.2200book.com/","www.motie.com/","www.hongshu.com/","www.shigebao.com/"};
    String v3="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;

    public Wen47() {
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


public String   v7(int u8){
    String url;
        String a5="2299.5566";
        String l8="3311.5566";
        String w9=""+"www.5566.net";
        String s4="=''+location.hostname;";
        String c4="=''+document.URL;";
        String c6=""+"http://www.5566.net/wen-6.htm";
        int l3=w9.lastIndexOf('.');
        int z9=0+Integer.parseInt(String.valueOf(w9.charAt(l3-1)));
        int w5=0+Integer.parseInt(String.valueOf(a5.charAt(2)));
        int m3=0+Integer.parseInt(String.valueOf(w9.charAt(l3-3)));
        int a8=0+string2Unicode(String.valueOf(s4.charAt(5)));
        int z6=0+string2Unicode(String.valueOf(c4.charAt(6)));
        int o3=0+Integer.parseInt(String.valueOf(a5.charAt(1)));
        String u3="wen";
        if(c6.indexOf("5566")==-1||c6.indexOf("wen")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+l0[(u8-m3-o3-w5-a8-z6-14)/z9];
        }
        return  url;
    }
   public String  w2(int a4){
       String url;
        String p8=""+"www.5566.net";
        String h6="=''+location.href;";
        String e0="=''+location.host;";
        String t6=""+"http://www.5566.net/wen-6.htm";
        String l8="9922.5566";
        String g1="5544.5566";
        int y7=p8.lastIndexOf('.');
        int s8=0+Integer.parseInt(String.valueOf(p8.charAt(y7-3)));
        int d1=0+string2Unicode(String.valueOf(h6.charAt(6)));
        int h1=0+string2Unicode(String.valueOf(e0.charAt(5)));
        int e9=0+Integer.parseInt(String.valueOf(g1.charAt(0)));
        int t8=0+Integer.parseInt(String.valueOf(g1.charAt(3)));
        int h7=0+Integer.parseInt(String.valueOf(p8.charAt(y7-1)));
        String f1="wen";
        if(p8!="5566.net"&&p8!="www.5566.net"&&p8!="5566.org"&&p8!="1.5566.org"&&p8!="2.5566.org"&&p8!="3.5566.org"&&p8!="4.5566.org"&&p8!="5.5566.org"&&p8!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+l0[(a4-s8-h7-t8-h1-d1-96)/e9];
        }
        return  url;
    }
   public String  l5(int f6){
       String url = "";
        String y0=""+"http://www.5566.net/wen-6.htm";
        String n0="=''+document.domain;";
        String g0="1133.5566";
        String r5=""+"www.5566.net";
        String q9="4455.5566";
        String u5="=''+document.location;";
        int r3=r5.lastIndexOf('.');
        int a7=0+Integer.parseInt(String.valueOf(g0.charAt(1)));
        int t3=0+string2Unicode(String.valueOf(n0.charAt(5)));
        int d8=0+Integer.parseInt(String.valueOf(r5.charAt(r3-1)));
        int w8=0+Integer.parseInt(String.valueOf(r5.charAt(r3-3)));
        int t2=0+Integer.parseInt(String.valueOf(g0.charAt(2)));
        int s1=0+string2Unicode(String.valueOf(u5.charAt(6)));
        String f9="wen";
        if(r5=="5566.net"||r5=="www.5566.net"||r5=="5566.org"||r5=="1.5566.org"||r5=="2.5566.org"||r5=="3.5566.org"||r5=="4.5566.org"||r5=="5.5566.org"||r5=="www.5566.org"){
           url = "http://"+l0[(f6-d8-a7-t2-t3-s1-46)/w8];
        }
        return   url;
    }

    public  void getUrlAndText(Elements urls, String tag1, String tag2) {

        String tmpUrl = "";
        String tmpName = "";
        String onclick = "";

        for (Element href : urls) {
            try {
                onclick = href.attr("onclick");
                tmpName = href.text();
                if (onclick.substring(0, 2).equalsIgnoreCase("v7")) {
                    tmpUrl = v7(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("w2")) {
                    tmpUrl = w2(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("l5")) {

                    tmpUrl = l5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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

    public  void getWenUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "文化艺术";
        String tag2 ="文学小说";
//        System.out.println(p.get(53));
        //16,34,43,53
        int[] numbers = {16,34,43,53};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }





    }

    public static void main(String[] args) {


        Wen47 wen47 = new Wen47();
        wen47.getWenUrls("http://www.5566.net/wen-6.htm");



    }












}
