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
public class Cw74 {

    String[] s2={"0","www.chinapet.net/bbs/","www.tianya.cn/techforum/articleslist/0/75.shtml","www.mypethome.com/bbs/","www.shdog.net/","bbs.sgou.com/","bbs.myarowanas.com/","bbs.99pet.com/","www.mypethome.com/","www.chinaxinge.com/","www.hashiqi.com.cn/","www.tahua.net/","www.cngui.com/","bbs.cnfish.com/","www.chinapet.net/","www.reptilesworld.com/","www.aigou.com/","bbs.csvclub.org/","www.chinapet.com/","longyu.cc/","www.rpw.com.cn/","www.crpa.net.cn/","bbs.pxtx.com/","www.goumin.com/","www.aiao.cn/","www.52cangshu.com/","www.99pet.com/","bbs.myluohan.com/","bbs.chinapet.com/","bbs.goumin.com/","www.zeixihuan.com/","bbs.movshow.com/","bbs.aigou.com/","www.cndog.net/","www.zhxg.com/","www.petking.cn/","www.ttpet.com/","www.dog126.com/","www.shcwhj.com/","www.cnfish.cn/","www.lanshou.net/","pet.pclady.com.cn/","www.bandog.cn/"};
    String u9="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public Cw74(){
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


   public String  h2(int r5){
       String url ;
        String c6=""+"http://www.5566.net/cw-5.htm";
        String a5="9966.5566";
        String b1=""+"www.5566.net";
        String z2="=''+location.href;";
        String v7="1188.5566";
        String b5="=''+document.domain;";
        int v0=b1.lastIndexOf('.');
        int d5=0+Integer.parseInt(String.valueOf(a5.charAt(0)));
        int d2=0+Integer.parseInt(String.valueOf(b1.charAt(v0-1)));
        int p1=0+Integer.parseInt(String.valueOf(b1.charAt(v0-3)));
        int g9=0+string2Unicode(String.valueOf(z2.charAt(6)));
        int i8=0+Integer.parseInt(String.valueOf(a5.charAt(3)));
        int a9=0+string2Unicode(String.valueOf(b5.charAt(5)));
        String c5="cw";
        if(c6.indexOf("5566")==-1||c6.indexOf("cw")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+s2[(r5-p1-d5-i8-a9-g9-67)/d2];
        }
        return  url;
    }
    public String  y6(int i0){
        String url = "";
        String s8=""+"http://www.5566.net/cw-5.htm";
        String t4=""+"www.5566.net";
        String s5="5533.5566";
        String o9="8811.5566";
        String h6="=''+document.location;";
        String p6="=''+location.host;";
        int f7=t4.lastIndexOf('.');
        int u2=0+Integer.parseInt(String.valueOf(o9.charAt(1)));
        int u3=0+Integer.parseInt(String.valueOf(t4.charAt(f7-3)));
        int f1=0+Integer.parseInt(String.valueOf(o9.charAt(3)));
        int t3=0+Integer.parseInt(String.valueOf(t4.charAt(f7-1)));
        int a4=0+string2Unicode(String.valueOf(h6.charAt(6)));
        int c4=0+string2Unicode(String.valueOf(p6.charAt(5)));
        String x5="cw";
        if(t4=="5566.net"||t4=="www.5566.net"||t4=="5566.org"||t4=="1.5566.org"||t4=="2.5566.org"||t4=="3.5566.org"||t4=="4.5566.org"||t4=="5.5566.org"||t4=="www.5566.org"){
           url = "http://"+s2[(i0-t3-u2-f1-c4-a4-98)/u3];
        }

        return  url;
    }
   public String  b9(int v9){
       String url = "";
        String v7="6699.5566";
        String h9="3355.5566";
        String m7=""+"www.5566.net";
        String c3="=''+document.URL;";
        String j6=""+"http://www.5566.net/cw-5.htm";
        String e3="=''+location.hostname;";
        int g8=m7.lastIndexOf('.');
        int r0=0+Integer.parseInt(String.valueOf(h9.charAt(2)));
        int a7=0+Integer.parseInt(String.valueOf(m7.charAt(g8-1)));
        int j4=0+Integer.parseInt(String.valueOf(m7.charAt(g8-3)));
        int w1=0+string2Unicode(String.valueOf(c3.charAt(6)));
        int h4=0+Integer.parseInt(String.valueOf(h9.charAt(0)));
       int n9=0+string2Unicode(String.valueOf(e3.charAt(5)));
        String d8="cw";
        if(j6.indexOf("5566")>=0&&j6.indexOf("cw")>=0){
            url = "http://"+s2[(v9-j4-a7-r0-n9-w1-4)/h4];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("h2")) {
                    tmpUrl = h2(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("y6")) {
                    tmpUrl = y6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("b9")) {

                    tmpUrl = b9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
        String tag2 = "宠物";
//        System.out.println(p.get(54));
//        //16, 26, 36,45, 54
        int[] numbers = {16, 26, 36,45, 54};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }


    }


    public static void main(String[] args) {

        Cw74 cw74 = new Cw74();
        cw74.getUrls("http://www.5566.net/cw-5.htm");


    }



}
