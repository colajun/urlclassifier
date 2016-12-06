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
public class QQ35 {

    String[] w2 = {"0", "www.tq.cn/", "web.qq.com/", "mobile.qq.com/", "im.qq.com/", "www.qqtn.com/", "www.qqbiaoqing.com/", "www.skype.com/", "gamesafe.qq.com/", "www.icq.com/", "www.qqhot.com/", "www.qqjia.com/", "kf.qq.com/", "www.qq.com/", "uc.sina.com.cn/", "im.qq.com/qq/all.shtml", "www.windowslive.cn/", "www.qzone.cc/", "popo.163.com/", "elive.vnet.cn/", "qun.qq.com/", "www.enet.com.cn/eschool/includes/zhuanti/qq/", "www.qqttxx.com/", "feixin.10086.cn/", "mail.qq.com/", "www.taobao.com/wangwang/", "www.qqbbx.com/", "qqgame.qq.com/", "vip.qq.com/", "www.yy.com/", "im.renren.com/", "www.kanqq.com/", "www.onlinedown.net/sort/156_1.htm", "www.tqqa.com/", "im.qq.com/tm/", "photo.qq.com/", "qq.yesky.com/", "aq.qq.com/", "qzone.qq.com/", "pcedu.pconline.com.cn/qq/", "www.pengyou.com/", "zc.qq.com/", "show.qq.com/", "www.popoho.com/"};
    String b4 = "http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;

    public QQ35() {
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

public  String  q9(int g4){
    String url= "";
        String m8=""+"http://www.5566.net/oicq.htm";
        String v9="=''+location.href;";
        String c2="4411.5566";
        String m6="=''+location.hostname;";
        String a3=""+"www.5566.net";
        String p9="2266.5566";
        int m7=a3.lastIndexOf('.');
        int p8=0+Integer.parseInt(String.valueOf(c2.charAt(0)));
        int i7=0+string2Unicode(String.valueOf(v9.charAt(6)));
        int j7=0+Integer.parseInt(String.valueOf(a3.charAt(m7-1)));
        int t9=0+string2Unicode(String.valueOf(m6.charAt(5)));
        int k6=0+Integer.parseInt(String.valueOf(a3.charAt(m7-3)));
        int j0=0+Integer.parseInt(String.valueOf(c2.charAt(3)));
        String f6="oicq";
        if(m8.indexOf("5566")>=0&&m8.indexOf("oicq")>=0){
           url = "http://"+w2[(g4-k6-p8-j0-t9-i7-69)/j7];
        }
        return  url;
    }
    public String s9(int l3){
        String url = "";
        String m9="=''+document.URL;";
        String k4=""+"www.5566.net";
        String s1="3355.5566";
        String a2="=''+location.host;";
        String f7=""+"http://www.5566.net/oicq.htm";
        String l1="6622.5566";
        int l9=k4.lastIndexOf('.');
        int x6=0+string2Unicode(String.valueOf(m9.charAt(6)));
        int i0=0+Integer.parseInt(String.valueOf(k4.charAt(l9-3)));
        int q3=0+Integer.parseInt(String.valueOf(l1.charAt(3)));
        int r0=0+string2Unicode(String.valueOf(a2.charAt(5)));
        int s7=0+Integer.parseInt(String.valueOf(l1.charAt(0)));
        int z9=0+Integer.parseInt(String.valueOf(k4.charAt(l9-1)));
        String k7="oicq";
        if(k4=="5566.net"||k4=="www.5566.net"||k4=="5566.org"||k4=="1.5566.org"||k4=="2.5566.org"||k4=="3.5566.org"||k4=="4.5566.org"||k4=="5.5566.org"||k4=="www.5566.org"){
           url = "http://"+w2[(l3-z9-s7-q3-r0-x6-56)/i0];
        }
        return  url;
    }
  public String  q7(int f8){
      String url ;
        String d2="=''+document.domain;";
        String i8=""+"www.5566.net";
        String s4=""+"http://www.5566.net/oicq.htm";
        String p9="1144.5566";
        String i6="5533.5566";
        String y8="=''+document.location;";
        int j3=i8.lastIndexOf('.');
        int w9=0+string2Unicode(String.valueOf(d2.charAt(5)));
        int k1=0+Integer.parseInt(String.valueOf(i8.charAt(j3-3)));
        int z1=0+Integer.parseInt(String.valueOf(i6.charAt(0)));
        int b8=0+Integer.parseInt(String.valueOf(i6.charAt(2)));
        int h1=0+Integer.parseInt(String.valueOf(i8.charAt(j3-1)));
        int c1=0+string2Unicode(String.valueOf(y8.charAt(6)));
        String r2="oicq";
        if(s4.indexOf("5566")==-1||s4.indexOf("oicq")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
          url = "http://"+w2[(f8-k1-h1-b8-w9-c1-68)/z1];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("q7")) {
                    tmpUrl = q7(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("q9")) {
                    tmpUrl = q9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("s9")) {

                    tmpUrl = s9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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


    public  void  getQQurls(String url){


        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "娱乐休闲";
        String tag2 ="即时通讯/QQ";
//        System.out.println(p.get(39));
//        //16,28,39
        int[] numbers = {16,28,39};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }



    }


    public static void main(String[] args) {

        QQ35 qq35 = new QQ35();
        qq35.getQQurls("http://www.5566.net/oicq.htm");



    }






}