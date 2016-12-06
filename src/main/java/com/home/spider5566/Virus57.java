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
public class Virus57 {

    String[] g8={"0","www.av-comparatives.org/","www.virustotal.com/zh-cn/","personal-firewall-software-review.toptenreviews.com/","www.processlibrary.com/","www.jiangmin.com/","www.kaspersky.com.cn/","www.ijinshan.com/jjx/","cn.trendmicro.com/","bbs.360safe.com/forum.php","www.anva.org.cn/","www.ludashi.com/","www.pcmag.com/article2/0,2817,2135053,00.asp","www.avira.com/zh-cn/","www.bit361.com/","www.ahn.com.cn/","tool.ikaka.com/","forum.jiangmin.com/","www.pandasecurity.com/china/","www.cverc.org.cn/","www.rising.com.cn/","www.cloudantivirus.com/zh/","www.comodo.com/home/internet-security/firewall.php","www.eset.com.cn/","bbs.ikaka.com/","bbs.kaspersky.com.cn/","sd.360.cn/","www.avast.com/","online.jiangmin.com/","www.ijinshan.com/","www.avast.com/zh-cn/index","pcedu.pconline.com.cn/soft/virus/","cn.norton.com/","www.comodo.cn/","www.kill.com.cn/","www.micropoint.com.cn/","anti-virus-software-review.toptenreviews.com/","bbs.duba.net/","www.ijinshan.com/ws/","www.virscan.org/","www.avg.com/cn-zh/china-avg-antivirus-free","www.mcafee.com/cn/","www.360.cn/weishi/","www.cnvd.org.cn/","soft.yesky.com/security/","bbs.kafan.cn/","www.360.cn/jijiuxiang/","www.avg.com/","www.matousec.com/projects/proactive-security-challenge/results.php","guanjia.qq.com/","www.avira.com/zh-cn/"};
    String p4="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;

    public Virus57() {
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

   public String  v0(int p1){
       String url = "";
        String e1="=''+document.URL;";
        String q8=""+"www.5566.net";
        String m9="9922.5566";
        String u8="1177.5566";
        String n5=""+"http://www.5566.net/virus-.htm";
        String r1="=''+location.hostname;";
        int m5=q8.lastIndexOf('.');
        int f9=0+string2Unicode(String.valueOf(e1.charAt(6)));
        int t2=0+Integer.parseInt(String.valueOf(q8.charAt(m5-3)));
        int q3=0+Integer.parseInt(String.valueOf(q8.charAt(m5-1)));
        int r9=0+Integer.parseInt(String.valueOf(m9.charAt(3)));
        int t7=0+Integer.parseInt(String.valueOf(m9.charAt(0)));
        int o3=0+string2Unicode(String.valueOf(r1.charAt(5)));
        String t0="virus";
        if(q8=="5566.net"||q8=="www.5566.net"||q8=="5566.org"||q8=="1.5566.org"||q8=="2.5566.org"||q8=="3.5566.org"||q8=="4.5566.org"||q8=="5.5566.org"||q8=="www.5566.org"){
            url = "http://"+g8[(p1-t2-q3-r9-o3-f9-81)/t7];
        }
        return  url;
    }
    public String  j5(int n4){
        String url ;
        String w1="=''+document.location;";
        String b2=""+"http://www.5566.net/virus-.htm";
        String l6="6644.5566";
        String l5=""+"www.5566.net";
        String w7="=''+location.host;";
        String r5="2299.5566";
        int i0=l5.lastIndexOf('.');
        int u9=0+string2Unicode(String.valueOf(w1.charAt(6)));
        int i4=0+Integer.parseInt(String.valueOf(l6.charAt(1)));
        int m4=0+Integer.parseInt(String.valueOf(l5.charAt(i0-1)));
        int p2=0+Integer.parseInt(String.valueOf(l5.charAt(i0-3)));
        int d2=0+string2Unicode(String.valueOf(w7.charAt(5)));
        int o4=0+Integer.parseInt(String.valueOf(l6.charAt(3)));
        String k7="virus";
        if(b2.indexOf("5566")==-1||b2.indexOf("virus")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+g8[(n4-m4-i4-o4-d2-u9-22)/p2];
        }
        return  url;
    }
   public String  x2(int n8){
       String url = "";
        String u8="4466.5566";
        String r4=""+"http://www.5566.net/virus-.htm";
        String o9="7711.5566";
        String f0="=''+location.href;";
        String g5=""+"www.5566.net";
        String c7="=''+document.domain;";
        int r3=g5.lastIndexOf('.');
        int w9=0+Integer.parseInt(String.valueOf(o9.charAt(3)));
        int a3=0+Integer.parseInt(String.valueOf(o9.charAt(o9.charAt(1))));
        int c6=0+Integer.parseInt(String.valueOf(g5.charAt(r3-1)));
        int d0=0+string2Unicode(String.valueOf(f0.charAt(6)));
        int x5=0+Integer.parseInt(String.valueOf(g5.charAt(r3-3)));
        int a2=0+string2Unicode(String.valueOf(c7.charAt(5)));
        String v8="virus";
        if(r4.indexOf("5566")>=0&&r4.indexOf("virus")>=0){
            url = "http://"+g8[(n8-x5-a3-w9-a2-d0-88)/c6];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("v0")) {
                    tmpUrl = v0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("j5")) {
                    tmpUrl = j5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("x2")) {

                    tmpUrl = x2(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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


        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "电脑网络";
        String tag2 ="病毒/杀毒";
//        System.out.println(p.get(16));
        //16, 27, 38, 51
        int[] numbers = {16};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }
    }




    public static void main(String[] args) {

        Virus57 virus57 = new Virus57();
        virus57.getUrls("http://www.5566.net/virus-.htm");



    }




}
