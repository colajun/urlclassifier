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
public class Love76 {
    String[] k5={"0","www.supei.com/","www.5460.net/","www.jiaoyou8.com/","www.zhinei.com/","www.renren.com/","www.loveinhere.com/","www.tonglou.com.cn/","www.renhe.cn/","yuehui.163.com/","www.tianji.com/","www.zhenai.com/","bai.sohu.com/","www.pengyou.com/","www.fj987.com/","www.loveroot.com/","www.baihe.com/","www.ipart.cn/","www.lovingnet.com","q.hunantv.com/","love.ganji.com/","www.gycity.com/","www.02929.net/","www.zhiji.com/","class.chinaren.com/","www.kaixin001.com/","www.wealink.com/","fcwr.jstv.com/","www.niwota.com/","www.vsharing.com/"};
    String t6="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public Love76(){
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

   public String  l5(int l6){
       String url = "";
        String z3="3311.5566";
        String v1=""+"www.5566.net";
        String c2="=''+document.URL;";
        String k1="9988.5566";
        String k0="=''+document.domain;";
        String e9=""+"http://www.5566.net/love-4.htm";
        int b1=v1.lastIndexOf('.');
        int x8=0+Integer.parseInt(String.valueOf(v1.charAt(b1-1)));
        int m9=0+Integer.parseInt(String.valueOf(v1.charAt(b1-3)));
        int j0=0+string2Unicode(String.valueOf(c2.charAt(6)));
        int w0=0+Integer.parseInt(String.valueOf(z3.charAt(2)));
        int c3=0+string2Unicode(String.valueOf(k0.charAt(5)));
        int o2=0+Integer.parseInt(String.valueOf(z3.charAt(1)));
        String g4="love";
        if(v1=="5566.net"||v1=="www.5566.net"||v1=="5566.org"||v1=="1.5566.org"||v1=="2.5566.org"||v1=="3.5566.org"||v1=="4.5566.org"||v1=="5.5566.org"||v1=="www.5566.org"){
            url = "http://"+k5[(l6-x8-o2-w0-c3-j0-42)/m9];
        }
        return  url;
    }
    public  String  t1(int x4){
        String url ;
        String f5=""+"www.5566.net";
        String p7="=''+location.hostname;";
        String a5="1133.5566";
        String d3="=''+location.href;";
        String c0=""+"http://www.5566.net/love-4.htm";
        String w3="5566.5566";
        int r1=f5.lastIndexOf('.');
        int y5=0+Integer.parseInt(String.valueOf(f5.charAt(r1-3)));
        int r9=0+string2Unicode(String.valueOf(p7.charAt(5)));
        int c8=0+Integer.parseInt(String.valueOf(w3.charAt(3)));
        int y6=0+string2Unicode(String.valueOf(d3.charAt(6)));
        int y1=0+Integer.parseInt(String.valueOf(w3.charAt(0)));
        int u0=0+Integer.parseInt(String.valueOf(f5.charAt(r1-1)));
        String w7="love";
        if(f5!="5566.net"&&f5!="www.5566.net"&&f5!="5566.org"&&f5!="1.5566.org"&&f5!="2.5566.org"&&f5!="3.5566.org"&&f5!="4.5566.org"&&f5!="5.5566.org"&&f5!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+k5[(x4-y5-y1-c8-r9-y6-18)/u0];
        }
        return  url;
    }
    public String  h8(int n6){
        String url;
        String e0="=''+location.host;";
        String a5="6655.5566";
        String z6="=''+document.location;";
        String s9=""+"www.5566.net";
        String d2=""+"http://www.5566.net/love-4.htm";
        String o3="8899.5566";
        int i0=s9.lastIndexOf('.');
        int u6=0+string2Unicode(String.valueOf(e0.charAt(5)));
        int d4=0+Integer.parseInt(String.valueOf(o3.charAt(2)));
        int t2=0+string2Unicode(String.valueOf(z6.charAt(6)));
        int f3=0+Integer.parseInt(String.valueOf(s9.charAt(i0-3)));
        int d9=0+Integer.parseInt(String.valueOf(o3.charAt(0)));
        int i3=0+Integer.parseInt(String.valueOf(s9.charAt(i0-1)));
        String a1="love";
        if(d2.indexOf("5566")==-1||d2.indexOf("love")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
          url = "http://"+k5[(n6-f3-i3-d4-u6-t2-41)/d9];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("h0")) {
                    tmpUrl = l5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("r0")) {
                    tmpUrl = t1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("d5")) {

                    tmpUrl = h8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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

    public void getUrls(String url){
        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "生活";
        String tag2 = "交友、婚恋";
//        System.out.println(p.get(192));
//        //20,32,41,54,65,77,93,110,121,135,149, 162, 179,192
        int[] numbers = {16};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }







    }

    public static void main(String[] args) {
        Love76 love76 = new Love76();
        love76.getUrls("http://www.5566.net/love-4.htm");



    }











}
