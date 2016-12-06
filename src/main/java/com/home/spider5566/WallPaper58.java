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
public class WallPaper58 {
    String[] e8={"0","www.6188.com/","www.jj20.com/","bizhi.manmankan.com/","www.kkdesk.com/","desk.zol.com.cn/","www.zhuoku.com/","bizhi.360.cn/","www.netbian.com/","wallpaper.pconline.com.cn/","www.wallcoo.com/","www.33.la/","www.winddesktop.com/","www.bizhi360.com/","bz.haozhuodao.com/","www.deskcar.com/","download.pchome.net/wallpaper/","gb.wallpapersking.com/","www.ppdesk.com/","www.4j4j.cn/","www.desktx.com/","bizhi.sogou.com/"};
    String x1="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;

    public WallPaper58() {
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



   public String  c0(int t6){
       String url = "";
        String q6=""+"http://www.5566.net/wallpaper-7.htm";
        String y8="=''+document.URL;";
        String d9="9988.5566";
        String v7=""+"www.5566.net";
       String b5="1133.5566";
        String a3="=''+document.domain;";
        int m3=v7.lastIndexOf('.');
        int o6=0+Integer.parseInt(String.valueOf(b5.charAt(1)));
        int s0=0+string2Unicode(String.valueOf(y8.charAt(6)));
        int e7=0+Integer.parseInt(String.valueOf(b5.charAt(2)));
        int m8=0+Integer.parseInt(String.valueOf(v7.charAt(m3-3)));
        int u3=0+Integer.parseInt(String.valueOf(v7.charAt(m3-1)));
        int s9=0+string2Unicode(String.valueOf(a3.charAt(5)));
        String g5="wallpaper";
        if(q6.indexOf("5566")>=0&&q6.indexOf("wallpaper")>=0){
           url = "http://"+e8[(t6-m8-o6-e7-s9-s0-28)/u3];
        }
        return  url;
    }
   public String  d8(int u4){
       String url;
        String g2=""+"http://www.5566.net/wallpaper-7.htm";
        String t5="6644.5566";
        String b6=""+"www.5566.net";
        String c5="=''+location.href;";
        String q2="8899.5566";
        String l4="=''+location.host;";
        int o7=b6.lastIndexOf('.');
        int o5=0+Integer.parseInt(String.valueOf(q2.charAt(0)));
        int j9=0+Integer.parseInt(String.valueOf(q2.charAt(3)));
        int s5=0+Integer.parseInt(String.valueOf(b6.charAt(o7-3)));
        int b4=0+string2Unicode(String.valueOf(c5.charAt(6)));
        int n9=0+Integer.parseInt(String.valueOf(b6.charAt(o7-1)));
        int m9=0+string2Unicode(String.valueOf(l4.charAt(5)));
        String l9="wallpaper";
        if(g2.indexOf("5566")==-1||g2.indexOf("wallpaper")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+e8[(u4-n9-o5-j9-m9-b4-11)/s5];
        }
        return  url;
    }
   public String  v6(int h6){
       String url;
        String d9="3311.5566";
        String t3="=''+document.location;";
        String q5="=''+location.hostname;";
        String f5=""+"www.5566.net";
        String w2="4466.5566";
        String d4=""+"http://www.5566.net/wallpaper-7.htm";
        int o0=f5.lastIndexOf('.');
        int c8=0+Integer.parseInt(String.valueOf(w2.charAt(2)));
        int x2=0+string2Unicode(String.valueOf(t3.charAt(6)));
        int k9=0+string2Unicode(String.valueOf(q5.charAt(5)));
        int a7=0+Integer.parseInt(String.valueOf(f5.charAt(o0-3)));
        int g1=0+Integer.parseInt(String.valueOf(f5.charAt(o0-1)));
        int z1=0+Integer.parseInt(String.valueOf(w2.charAt(1)));
        String r3="wallpaper";
        if(f5!="5566.net"&&f5!="www.5566.net"&&f5!="5566.org"&&f5!="1.5566.org"&&f5!="2.5566.org"&&f5!="3.5566.org"&&f5!="4.5566.org"&&f5!="5.5566.org"&&f5!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+e8[(h6-a7-g1-c8-k9-x2-74)/z1];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("c0")) {
                    tmpUrl = c0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("d8")) {
                    tmpUrl = d8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("v6")) {

                    tmpUrl = v6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
        String tag2 ="壁纸";
//        System.out.println(p.get(28));
        //16,28
        int[] numbers = {16, 28};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }
    }




    public static void main(String[] args) {

        WallPaper58 wallPaper58 = new WallPaper58();
        wallPaper58.getUrls("http://www.5566.net/wallpaper-7.htm");


    }






}
