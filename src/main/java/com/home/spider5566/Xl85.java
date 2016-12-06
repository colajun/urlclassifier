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
public class Xl85 {
    String[] t0={"0","psy.fh21.com.cn/","astro.lady.qq.com/augury/augu_test.shtml","www.apa.org/","www.yoka.com/psycho/","www.camh.org.cn/","www.xlxcn.net/","www.xinli110.com/","www.njxljy.com/","www.psyc.com.cn/","www.ayao.net/","www.kangning120.com/","xinli.59120.com/","www.xlzx.cn/","www.511511.com/jkpd/xlhh/","health.people.com.cn/GB/14743/index.html","www.psychcn.com/","astro.sina.com.cn/test/","www.xl120.com/","www.cpsbeijing.org/","www.psypx.com/","www.psych.ac.cn/","www.psychspace.com/","www.xlzx.com/","xinli.panjk.com/","www.psybook.com/"};
    String j7="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;
    public Xl85(){
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



   public String  i0(int n5){
       String url ="";
        String m0=""+"http://www.5566.net/xl-4.htm";
        String x3=""+"www.5566.net";
        String p8="=''+location.hostname;";
        String o5="8855.5566";
        String h1="6622.5566";
        String b7="=''+location.href;";
        int a5=x3.lastIndexOf('.');
        int p9=0+Integer.parseInt(String.valueOf(o5.charAt(0)));
        int i7=0+Integer.parseInt(String.valueOf(x3.charAt(a5-3)));
        int i8=0+string2Unicode(String.valueOf(p8.charAt(5)));
        int y2=0+Integer.parseInt(String.valueOf(x3.charAt(a5-1)));
        int d0=0+Integer.parseInt(String.valueOf(o5.charAt(3)));
        int p0=0+string2Unicode(String.valueOf(b7.charAt(6)));
        String f6="xl";
        if(m0.indexOf("5566")>=0&&m0.indexOf("xl")>=0){
           url = "http://"+t0[(n5-i7-p9-d0-i8-p0-84)/y2];
        }
        return  url;
    }
    public String  c8(int s1){
        String url;
        String h1="5588.5566";
        String j0="3377.5566";
        String d4="=''+document.domain;";
        String k3="=''+document.URL;";
        String f9=""+"www.5566.net";
        String v0=""+"http://www.5566.net/xl-4.htm";
        int u3=f9.lastIndexOf('.');
        int u1=0+Integer.parseInt(String.valueOf(j0.charAt(2)));
        int t4=0+Integer.parseInt(String.valueOf(f9.charAt(u3-1)));
        int u9=0+string2Unicode(String.valueOf(d4.charAt(5)));
        int x2=0+string2Unicode(String.valueOf(k3.charAt(6)));
        int n2=0+Integer.parseInt(String.valueOf(f9.charAt(u3-3)));
        int a6=0+Integer.parseInt(String.valueOf(j0.charAt(0)));
        String g1="xl";
        if(f9!="5566.net"&&f9!="www.5566.net"&&f9!="5566.org"&&f9!="1.5566.org"&&f9!="2.5566.org"&&f9!="3.5566.org"&&f9!="4.5566.org"&&f9!="5.5566.org"&&f9!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+t0[(s1-n2-t4-u1-u9-x2-81)/a6];
        }
        return  url;
    }
    public String  w0(int z4){
        String url;
        String t9="2266.5566";
        String u2="7733.5566";
        String w5="=''+location.host;";
        String t5=""+"www.5566.net";
        String i6="=''+document.location;";
        String d7=""+"http://www.5566.net/xl-4.htm";
        int w1=t5.lastIndexOf('.');
        int l9=0+Integer.parseInt(String.valueOf(t5.charAt(w1-1)));
        int t2=0+Integer.parseInt(String.valueOf(t9.charAt(2)));
        int r5=0+string2Unicode(String.valueOf(w5.charAt(5)));
        int o4=0+Integer.parseInt(String.valueOf(t5.charAt(w1-3)));
        int l1=0+string2Unicode(String.valueOf(i6.charAt(6)));
        int v4=0+Integer.parseInt(String.valueOf(t9.charAt(1)));
        String v8="xl";
        if(d7.indexOf("5566")==-1||d7.indexOf("xl")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+t0[(z4-l9-v4-t2-r5-l1-92)/o4];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("i0")) {
                    tmpUrl = i0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("c8")) {
                    tmpUrl = c8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("w0")) {

                    tmpUrl = w0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
        String tag1 = "健康医疗";
        String tag2 = "心理健康";
//        System.out.println(p.get(16));
        //
        int[] numbers = {16};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }



    }

    public static void main(String[] args) {

        Xl85 xl85 = new Xl85();
        xl85.getUrls("http://www.5566.net/xl-4.htm");



    }

}
