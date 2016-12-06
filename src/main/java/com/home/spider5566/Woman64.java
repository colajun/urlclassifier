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
public class Woman64 {
    String[] l3={"0","fitness.pclady.com.cn/","yesee.qianlong.com/fitness.htm","www.lady8844.com/","www.onlylady.com/","www.zdface.com/","www.lady8844.com/","lady.qq.com/beauty/beauty.shtml","www.yxlady.com/","www.ny1988.com/","women.sohu.com/","lady.163.com/beauty/","www.yoka.com/beauty/","eladies.sina.com.cn/fat/index.html","bbs.tianya.cn/list-female-1.shtml","www.luce.com.cn/","www.newoo.com/","www.55bbs.com/","club.women.sohu.com/","www.pclady.com.cn/","www.haibao.com/","www.meili.cn/beauty/","women.sohu.com/meitishusheng.shtml","she.21cn.com/","www.pinshan.com/","www.rayli.com.cn/","www.piaoliang.com/","www.meinv.com/","women.sohu.com/liangrongmeifa.shtml","bbs.tianya.cn/list-43-1.shtml","lady.163.com/fit","www.xfwed.com/","beauty.rayli.com.cn/","www.vsuch.com/","www.mcchina.com/","www.enet.com.cn/elady/","www.rayli.com.cn/fitness/","fashion.sina.com.cn/beauty/","www.ssnn.net/","www.aili.com/","yesee.qianlong.com/beauty.htm","yesee.qianlong.com/","club.eladies.sina.com.cn/forum-7-1.html","www.trends.com.cn/beauty/","www.trends.com.cn/","club.eladies.sina.com.cn/","www.luce.com.cn/","lady.163.com/","lady.qq.com/","fashion.ifeng.com/","www.yoka.com/","www.izhufu.net/","www.i2ya.com/","www.kimiss.com/","www.nvsheng.com/","www.hualady.com/","beauty.zdface.com/","eladies.sina.com.cn/","lady.qq.com/diet/diet.htm","www.familydoctor.com.cn/Beauty/","beauty.pclady.com.cn/","bbs.rayli.com.cn/","www.ellechina.com/","www.self.com.cn/","nrsfh.com/","www.boohee.com/","www.lady8844.com/shoushen/","www.jrlady.com/","www.shoushen.com/","www.soosou.com/","www.kongjie.com/"};
    String p9="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;

    public Woman64() {
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


   public String  i3(int q3){
       String url ="";
        String h1="4422.5566";
        String d5="1199.5566";
        String q2="=''+location.href;";
        String y7=""+"www.5566.net";
        String j0="=''+location.host;";
        String u6=""+"http://www.5566.net/woman-6.htm";
        int a7=y7.lastIndexOf('.');
        int f6=0+Integer.parseInt(String.valueOf(d5.charAt(2)));
        int g7=0+Integer.parseInt(String.valueOf(y7.charAt(a7-1)));
        int j4=0+string2Unicode(String.valueOf(q2.charAt(6)));
        int y1=0+Integer.parseInt(String.valueOf(y7.charAt(a7-3)));
        int  b6=0+string2Unicode(String.valueOf(j0.charAt(5)));
        int t5=0+Integer.parseInt(String.valueOf(d5.charAt(0)));
        String r9="woman";
        if(y7=="5566.net"||y7=="www.5566.net"||y7=="5566.org"||y7=="1.5566.org"||y7=="2.5566.org"||y7=="3.5566.org"||y7=="4.5566.org"||y7=="5.5566.org"||y7=="www.5566.org"){
           url = "http://"+l3[(q3-y1-g7-f6-b6-j4-25)/t5];
        }
        return  url;
    }
   public String  l5(int o8){
       String url;
        String b4="9911.5566";
        String p1="8866.5566";
        String l6="=''+location.hostname;";
        String e4=""+"www.5566.net";
        String z7=""+"http://www.5566.net/woman-6.htm";
        String z8="=''+document.location;";
        int x3=e4.lastIndexOf('.');
        int z3=0+Integer.parseInt(String.valueOf(p1.charAt(3)));
        int t9=0+Integer.parseInt(String.valueOf(e4.charAt(x3-1)));
        int x5=0+string2Unicode(String.valueOf(l6.charAt(5)));
        int f1=0+Integer.parseInt(String.valueOf(e4.charAt(x3-3)));
        int p2=0+Integer.parseInt(String.valueOf(p1.charAt(1)));
        int s5=0+string2Unicode(String.valueOf(z8.charAt(6)));
        String i0="woman";
        if(e4!="5566.net"&&e4!="www.5566.net"&&e4!="5566.org"&&e4!="1.5566.org"&&e4!="2.5566.org"&&e4!="3.5566.org"&&e4!="4.5566.org"&&e4!="5.5566.org"&&e4!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+l3[(o8-t9-p2-z3-x5-s5-5)/f1];
        }
        return  url;

    }
   public String  s9(int c0){
       String url = "";
        String q9="=''+document.URL;";
        String f3="=''+document.domain;";
        String i9=""+"http://www.5566.net/woman-6.htm";
        String m6=""+"www.5566.net";
        String h1="6688.5566";
        String c2="2244.5566";
        int i8=m6.lastIndexOf('.');
       int  x1=0+string2Unicode(String.valueOf(q9.charAt(6)));
        int n2=0+string2Unicode(String.valueOf(f3.charAt(5)));
        int w2=0+Integer.parseInt(String.valueOf(c2.charAt(1)));
       int o1=0+Integer.parseInt(String.valueOf(m6.charAt(i8-3)));
        int y8=0+Integer.parseInt(String.valueOf(c2.charAt(2)));
        int w3=0+Integer.parseInt(String.valueOf(m6.charAt(i8-1)));
        String g8="woman";
        if(i9.indexOf("5566")>=0&&i9.indexOf("woman")>=0){
           url = "http://"+l3[(c0-o1-w2-y8-n2-x1-12)/w3];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("i3")) {
                    tmpUrl = i3(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("l5")) {
                    tmpUrl = l5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("s9")) {

                    tmpUrl = s9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
        String tag2 = "女性";
//        System.out.println(p.get(47));
        //16,35,47
        int[] numbers = {16,35,47};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);
        }



    }

    public static void main(String[] args) {
        Woman64 woman64 = new Woman64();
        woman64.getUrls("http://www.5566.net/woman-6.htm");



    }





}
