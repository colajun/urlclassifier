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
 * Created by hadoop on 16-11-26.
 */
public class Hard62 {

    String[] r0={"0","www.apple.com.cn/","www.hasee.com/","www.alienware.com/","www.51nb.com/","www.enet.com.cn/notebook/","www.tongfangpc.com/","notebook.yesky.com/","benyouhui.it168.com/","notebook.pconline.com.cn/","notebook.it168.com/","www.thinkworld.com.cn/","www.fujitsu.com/cn/services/hardware/pc/","nb.pcpop.com/","www.asus.com.cn/","www.terransforce.com/","nb.zol.com.cn/","cn.razerzone.com/","bbs.pcpop.com/005500045-1_right.html","www.benber.com/","www.it.com.cn/notebook/","bbs.benber.com/","nb.thethirdmedia.com/","product.pconline.com.cn/notebook/","www.malata.com/","pc.beareyes.com.cn/bbs/pc004.htm","nbbbs.zol.com.cn/","www.acer.com.cn/","www.hedy.com.cn/","notebook.pchome.net/","itbbs.pconline.com.cn/notebook/","tech.sina.com.cn/notebook/","www.haier.com/cn/consumer/computers/","cn.msi.com/","www.lenovo.com.cn/","digi.163.com/nb/"};
    String m0="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;

    public Hard62() {
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



   public String  v6(int q3){
        String url = "";
        String x6="6611.5566";
        String  t2="=''+location.host;";
        String c5="9977.5566";
        String l9=""+"http://www.5566.net/hard3.htm";
        String d8=""+"www.5566.net";
        String m9="=''+document.location;";
        int x3=d8.lastIndexOf('.');
        int t6=0+Integer.parseInt(String.valueOf(d8.charAt(x3-1)));
        int y5=0+string2Unicode(String.valueOf(t2.charAt(5)));
        int l8=0+Integer.parseInt(String.valueOf(x6.charAt(2)));
        int o7=0+Integer.parseInt(String.valueOf(x6.charAt(1)));
        int f4=0+Integer.parseInt(String.valueOf(d8.charAt(x3-3)));
        int e7=0+string2Unicode(String.valueOf(m9.charAt(6)));
        String j9="hard3";
        if(d8=="5566.net"||d8=="www.5566.net"||d8=="5566.org"||d8=="1.5566.org"||d8=="2.5566.org"||d8=="3.5566.org"||d8=="4.5566.org"||d8=="5.5566.org"||d8=="www.5566.org"){
          url = "http://"+r0[(q3-f4-t6-l8-y5-e7-13)/o7];
        }
        return  url;
    }
   public String  u1(int b9){
       String url;
        String g3="=''+document.URL;";
        String a9="2288.5566";
        String i2="=''+location.hostname;";
        String l5="1166.5566";
        String g5=""+"www.5566.net";
        String x1=""+"http://www.5566.net/hard3.htm";
        int o2=g5.lastIndexOf('.');
        int g9=0+string2Unicode(String.valueOf(g3.charAt(6)));
        int x4=0+Integer.parseInt(String.valueOf(g5.charAt(o2-1)));
        int x2=0+string2Unicode(String.valueOf(i2.charAt(5)));
        int k9=0+Integer.parseInt(String.valueOf(a9.charAt(2)));
        int x8=0+Integer.parseInt(String.valueOf(g5.charAt(o2-3)));
        int f2=0+Integer.parseInt(String.valueOf(a9.charAt(0)));
        String u4="hard3";
        if(x1.indexOf("5566")==-1||x1.indexOf("hard3")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+r0[(b9-x4-f2-k9-x2-g9-88)/x8];
        }
        return  url;
    }
   public String  z1(int h0){
       String url;
        String x9=""+"http://www.5566.net/hard3.htm";
        String c0="=''+location.href;";
        String l1=""+"www.5566.net";
        String x7="=''+document.domain;";
        String r6="7799.5566";
        String c5="8822.5566";
        int b4=l1.lastIndexOf('.');
        int d9=0+Integer.parseInt(String.valueOf(r6.charAt(1)));
        int h8=0+string2Unicode(String.valueOf(c0.charAt(6)));
        int t9=0+Integer.parseInt(String.valueOf(l1.charAt(b4-3)));
        int g1=0+string2Unicode(String.valueOf(x7.charAt(5)));
        int p8=0+Integer.parseInt(String.valueOf(l1.charAt(b4-1)));
        int u7=0+Integer.parseInt(String.valueOf(r6.charAt(3)));
        String e5="hard3";
       if(l1!="5566.net"&&l1!="www.5566.net"&&l1!="5566.org"&&l1!="1.5566.org"&&l1!="2.5566.org"&&l1!="3.5566.org"&&l1!="4.5566.org"&&l1!="5.5566.org"&&l1!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
          url = "http://"+r0[(h0-t9-d9-u7-g1-h8-37)/p8];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("u9")) {
                    tmpUrl = v6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("c1")) {
                    tmpUrl = z1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("i5")) {

                    tmpUrl = u1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
        String tag1 = "电脑网络";
        String tag2 = "硬件 -> 笔记本";
//        System.out.println(p.get(29));
        //16,29
        int[] numbers = {16,29};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);
        }





    }


    public static void main(String[] args) {

        Hard62 hard62 = new Hard62();

        hard62.getUrls("http://www.5566.net/hard3.htm");


    }







}
