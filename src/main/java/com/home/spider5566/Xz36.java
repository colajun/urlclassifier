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
public class Xz36 {
   String[]  d4={"0","astro.sina.com.cn/test/","www.cqchen.com/","www.d1xz.net/","www.51jiemeng.com/","www.64gua.com/","happy.online.sh.cn/happy/gb/special/node_3169.htm","www.99166.com/","www.sheup.com/","www.8s8s.com/","www.uqude.com/","astro.lady.qq.com/augury/augu_test.shtml","astro.httpcn.com/","astro.pclady.com.cn/","www.chinesezhouyi.com/","www.1518.com/","www.go108.com.cn/","www.cn-yijing.com/","club.astro.sina.com.cn/forum-2-1.html","51.aqioo.com/","bbs.tianya.cn/list-84-1.shtml","life.21cn.com/horoscope/","astro.women.sohu.com/ceshi.shtml","astro.rayli.com.cn/","www.zdic.net/appendix/f27.htm","www.philosophys.net/","www.enet.com.cn/elady/star/","lady.163.com/astro/","www.buyiju.com/","www.nongli.com/","life.httpcn.com/sm.asp","astro.sina.com.cn/","www.longyin.net/","www.meimingteng.com/","www.chinazwds.org/","life.httpcn.com/sm/","www.8s8s.net/","www.threetong.com/","www.chinammw.com/","www.8s8s.com/12test.htm","astro.lady.qq.com/tarot/","astro.fashion.qq.com/","www.psy-test.net/","live.cinews.net/","www.xingming.net/","www.xingzuo123.com/","bbs.china95.net/","www.k366.com/","www.laohuangli.net/","www.xingzuowu.com/","astro.women.sohu.com/","club.astro.sohu.com/"};
    String s9="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;

    public Xz36() {
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



   public String c0(int k6){
        String url = "";
        String t0="6633.5566";
        String g5="8844.5566";
        String q9=""+"www.5566.net";
        String z3="=''+location.href;";
        String o6=""+"http://www.5566.net/xz-4.htm";
        String t3="=''+location.host;";
        int n9=q9.lastIndexOf('.');
        int y8=0+Integer.parseInt(String.valueOf(q9.charAt(n9-1)));
        int k9=0+Integer.parseInt(String.valueOf(t0.charAt(3)));
        int r8=0+Integer.parseInt(String.valueOf(q9.charAt(n9-3)));
        int s2=0+string2Unicode(String.valueOf(z3.charAt(6)));
        int m9=0+Integer.parseInt(String.valueOf(t0.charAt(1)));
        int v3=0+string2Unicode(String.valueOf(t3.charAt(5)));
        String r2="xz";
        if(o6.indexOf("5566")>=0&&o6.indexOf("xz")>=0){
           url = "http://"+d4[(k6-r8-m9-k9-v3-s2-77)/y8];
        }
        return  url;
    }
   public String  y5(int i1){
       String url;
        String u4=""+"http://www.5566.net/xz-4.htm";
        String t7="=''+document.domain;";
        String w6="7799.5566";
        String k1="=''+document.URL;";
        String g5="3366.5566";
        String q8=""+"www.5566.net";
        int d3=q8.lastIndexOf('.');
        int b3=0+Integer.parseInt(String.valueOf(w6.charAt(1)));
        int p8=0+string2Unicode(String.valueOf(t7.charAt(5)));
        int h8=0+Integer.parseInt(String.valueOf(q8.charAt(d3-1)));
        int n4=0+string2Unicode(String.valueOf(k1.charAt(6)));
        int a3=0+Integer.parseInt(String.valueOf(w6.charAt(3)));
        int c1=0+Integer.parseInt(String.valueOf(q8.charAt(d3-3)));
        String a1="xz";
        if(u4.indexOf("5566")==-1||u4.indexOf("xz")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+d4[(i1-c1-h8-a3-p8-n4-97)/b3];
        }
        return  url;
    }
    public String  j4(int m4){
        String url = "";
        String j0="4488.5566";
        String w5="=''+document.location;";
        String m2="=''+location.hostname;";
        String c8=""+"http://www.5566.net/xz-4.htm";
        String m7=""+"www.5566.net";
        String w0="9977.5566";
        int w7=m7.lastIndexOf('.');
        int n1=0+Integer.parseInt(String.valueOf(m7.charAt(w7-1)));
        int l0=0+string2Unicode(String.valueOf(w5.charAt(6)));
        int c6=0+string2Unicode(String.valueOf(m2.charAt(5)));
        int h3=0+Integer.parseInt(String.valueOf(j0.charAt(1)));
        int i3=0+Integer.parseInt(String.valueOf(m7.charAt(w7-3)));
        int o0=0+Integer.parseInt(String.valueOf(j0.charAt(3)));
        String d8="xz";
        if(m7=="5566.net"||m7=="www.5566.net"||m7=="5566.org"||m7=="1.5566.org"||m7=="2.5566.org"||m7=="3.5566.org"||m7=="4.5566.org"||m7=="5.5566.org"||m7=="www.5566.org"){
            url = "http://"+d4[(m4-n1-h3-o0-c6-l0-27)/i3];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("y5")) {
                    tmpUrl = y5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("j4")) {
                    tmpUrl = j4(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("c0")) {

                    tmpUrl = c0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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




    public  void getXzUrls(String url){


        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "娱乐休闲";
        String tag2 ="星座";
//        System.out.println(p.get(35));
//        //16,35
        int[] numbers = {16,35};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }






    }



    public static void main(String[] args) {



        Xz36 xz36 = new Xz36();
        xz36.getXzUrls("http://www.5566.net/xz-4.htm");




    }











}
