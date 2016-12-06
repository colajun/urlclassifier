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
 * Created by hadoop on 16-11-21.
 */
public class Sport15 {
    String[] r5={"0","sports.qq.com/nba/","sports.sohu.com/cba.shtml","sports.163.com/nba/","nba.hupu.com/","kobe.sina.com.cn/","sports.sina.com.cn/nba/","www.bbboo.com/","sports.sina.com.cn/basketball/","cbachina.163.com/","yijianlian.sina.com.cn/","basketball.titan24.com/cba/","sports.sohu.com/lanqiu.shtml","yaoming.sports.sohu.com/","sports.ku6.com/huorelanqiu/","www.xinhuanet.com/sports/nba.htm","cbachina.163.com/","www.cba.gov.cn/","sports.qq.com/cba/","www.tbba.com.cn/","basketball.sportscn.com/","china.nba.com/","sports.21cn.com/basketball/","nba.sports.sina.com.cn/match_result.php","sports.sina.com.cn/nba/video/","nba.sports.sina.com.cn/showtv.php","sports.qq.com/basket/","sports.sohu.com/nba/","bbs.tianya.cn/list-basketball-1.shtml","basketball.titan24.com/","basketball.titan24.com/nba/","sports.sina.com.cn/cba/","basketball.sportscn.com/"};
    String u9="http://www.5566.org/indexe.htm";
    JdbcTemplate jdbcTemplate = null;
    public Sport15(){
        try {
            jdbcTemplate = JDBCHelper.createMysqlTemplate("mysql1", "jdbc:mysql://192.168.21.27/urlclassifier?useUnicode=true&characterEncoding=utf8", "root", "root", 5, 30);

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

    public String  a1(int v3){
        String url;
        String s6="4433.5566";
        String z9=""+"http://www.5566.net/sport4-5.htm";
        String d8="=''+location.hostname;";
        String g5="=''+document.location;";
        String y8=""+"www.5566.net";
        String h2="8855.5566";
        int a6=y8.lastIndexOf('.');
        int i3=0+Integer.parseInt(String.valueOf(h2.charAt(2)));
        int k5=0+Integer.parseInt(String.valueOf(h2.charAt(1)));
        int h7=0+string2Unicode(String.valueOf(d8.charAt(5)));
        int u6=0+string2Unicode(String.valueOf(g5.charAt(6)));
        int v0=0+Integer.parseInt(String.valueOf(y8.charAt(a6-3)));
        int t2=0+Integer.parseInt(String.valueOf(y8.charAt(a6-1)));
        String r3="sport4";
        if(z9.indexOf("5566")==-1||z9.indexOf("sport4")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+r5[(v3-v0-k5-i3-h7-u6-66)/t2];
        }
        return  url;
    }
   public String  b3(int k1){
       String url = "";
        String u0="3344.5566";
        String t4="=''+location.href;";
        String q1=""+"www.5566.net";
        String g8=""+"http://www.5566.net/sport4-5.htm";
        String m8="=''+document.domain;";
        String k2="7711.5566";
        int m5=q1.lastIndexOf('.');
        int z5=0+Integer.parseInt(String.valueOf(q1.charAt(m5-1)));
        int s9=0+string2Unicode(String.valueOf(t4.charAt(6)));
        int n2=0+Integer.parseInt(String.valueOf(q1.charAt(m5-3)));
        int s7=0+Integer.parseInt(String.valueOf(u0.charAt(0)));
        int h0=0+string2Unicode(String.valueOf(m8.charAt(5)));
        int m9=0+Integer.parseInt(String.valueOf(u0.charAt(2)));
        String v4="sport4";
        if(q1=="5566.net"||q1=="www.5566.net"||q1=="5566.org"||q1=="1.5566.org"||q1=="2.5566.org"||q1=="3.5566.org"||q1=="4.5566.org"||q1=="5.5566.org"||q1=="www.5566.org"){
           url = "http://"+r5[(k1-z5-s7-m9-h0-s9-78)/n2];
        }
        return  url;
    }
   public String  i2(int z2){
       String url = "";
        String y2="=''+location.host;";
        String c4="1177.5566";
        String r9=""+"www.5566.net";
        String u7=""+"http://www.5566.net/sport4-5.htm";
        String u5="=''+document.URL;";
        String s6="5588.5566";
        int s5=r9.lastIndexOf('.');
        int  d7=0+string2Unicode(String.valueOf(y2.charAt(5)));
        int m3=0+Integer.parseInt(String.valueOf(r9.charAt(s5-1)));
        int j0=0+Integer.parseInt(String.valueOf(r9.charAt(s5-3)));
        int w4=0+Integer.parseInt(String.valueOf(c4.charAt(0)));
        int u8=0+string2Unicode(String.valueOf(u5.charAt(6)));
        int r2=0+Integer.parseInt(String.valueOf(c4.charAt(2)));
        String f1="sport4";
        if(u7.indexOf("5566")>=0&&u7.indexOf("sport4")>=0){
           url = "http://"+r5[(z2-j0-m3-r2-d7-u8-86)/w4];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("i2")) {
                    tmpUrl = i2(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("b3")) {
                    tmpUrl = b3(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("a1")) {

                    tmpUrl = a1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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


    public  void getSportsUrls(String url){


        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "体育运动";
        String tag2 ="篮球";
//        System.out.println(p.get(36));
        //17,27,36
        int[] numbers = {17,27,36};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }



    }



    public static void main(String[] args) {

        Sport15 sport15 = new Sport15();


        sport15.getSportsUrls("http://www.5566.net/sport4-5.htm");

    }







}
