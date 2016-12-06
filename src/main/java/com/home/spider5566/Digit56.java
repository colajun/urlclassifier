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
public class Digit56 {
    String[] k2={"0","dc.pcpop.com/","www.fengniao.com/","detail.zol.com.cn/digital_camcorder_index/subcate81_list_1.html","www.padcn.com/","tech.sina.com.cn/digi/dc/","digital.yesky.com/","detail.zol.com.cn/mp4_player_index/subcate272_list_1.html","product.pconline.com.cn/dc/","detail.zol.com.cn/mp3_player_index/subcate19_list_1.html","mp4.pcpop.com/","www2.beareyes.com.cn/bbs/pc014.htm","dv.yesky.com/","padbbs.cnmo.com/","pad.pconline.com.cn/","www.enet.com.cn/edigi/","www.cnmo.com/pad/","digital.pconline.com.cn/","digi.it.sohu.com/","dc.pchome.net/","product.pchome.net/digital_dc/list__103.html","www.xitek.com/","tech.sina.com.cn/pad/","bbs.zol.com.cn/padbbs/","dc.it168.com/","pad.pcpop.com/","product.pchome.net/digital_dv/list__104.html","product.it168.com/list/b/1416_1.shtml","mp4.zol.com.cn/","www.it.com.cn/audio/","product.it168.com/list/b/0306_1.shtml","www.imp3.net/","pad.zol.com.cn/","detail.zol.com.cn/digital_camera_index/subcate15_list_1.html","pad.pchome.net/","www.thethirdmedia.com/hotnews/MP3/","bbs.1pad.cn/","www2.beareyes.com.cn/bbs/pc017.htm","dv.pconline.com.cn/","mp3.pcpop.com/","dv.pchome.net/","digi.sina.com.cn/","audio.pconline.com.cn/","digi.pchome.net/","mp3.zol.com.cn/","www.it.com.cn/audio/mp4/","digital.it168.com/","www.1pad.cn/","www.soomal.com/","product.it168.com/list/b/0305_1.shtml","www.dpnet.com.cn","dcdv.zol.com.cn/","digi.163.com/","dcdv.zol.com.cn/","dc.yesky.com/","www.enet.com.cn/pad/","digi.tech.qq.com/","bbs.mydigit.cn/","digi.pcpop.com/","bbs.dpnet.com.cn/bbs/home.htm","product.it168.com/list/b/0310_1.shtml","www.enet.com.cn/mp3/","digi.beareyes.com.cn/","www.imp3.net/","dc.pconline.com.cn/"};
    String p2="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;

    public Digit56() {
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


   public String  t8(int t1){
       String url = "";
        String r8=""+"http://www.5566.net/digit-.htm";
        String k5="=''+document.domain;";
        String s9="=''+location.href;";
        String c2="4411.5566";
        String t7=""+"www.5566.net";
        String l9="7799.5566";
        int z4=t7.lastIndexOf('.');
        int l6=0+Integer.parseInt(String.valueOf(c2.charAt(1)));
        int b0=0+string2Unicode(String.valueOf(k5.charAt(5)));
        int m3=0+string2Unicode(String.valueOf(s9.charAt(6)));
        int u6=0+Integer.parseInt(String.valueOf(t7.charAt(z4-1)));
        int z6=0+Integer.parseInt(String.valueOf(t7.charAt(z4-3)));
        int m7=0+Integer.parseInt(String.valueOf(c2.charAt(2)));
        String h4="digit";
        if(r8.indexOf("5566")>=0&&r8.indexOf("digit")>=0){
           url = "http://"+k2[(t1-z6-l6-m7-b0-m3-37)/u6];
        }
        return  url;
    }
   public String  w6(int a4){
       String url = "";
        String h0="=''+location.hostname;";
        String l9="1144.5566";
        String g5="6622.5566";
        String o7=""+"http://www.5566.net/digit-.htm";
        String v0=""+"www.5566.net";
        String v5="=''+document.location;";
        int u0=v0.lastIndexOf('.');
        int g9=0+string2Unicode(String.valueOf(h0.charAt(5)));
        int l5=0+Integer.parseInt(String.valueOf(g5.charAt(2)));
        int t4=0+Integer.parseInt(String.valueOf(v0.charAt(u0-1)));
        int j3=0+Integer.parseInt(String.valueOf(g5.charAt(1)));
        int u2=0+Integer.parseInt(String.valueOf(v0.charAt(u0-3)));
        int e3=0+string2Unicode(String.valueOf(v5.charAt(6)));
        String p0="digit";
        if(v0=="5566.net"||v0=="www.5566.net"||v0=="5566.org"||v0=="1.5566.org"||v0=="2.5566.org"||v0=="3.5566.org"||v0=="4.5566.org"||v0=="5.5566.org"||v0=="www.5566.org"){
            url = "http://"+k2[(a4-u2-t4-l5-g9-e3-76)/j3];
        }
        return  url;
    }
    public String  a7(int r3){
        String url;
        String f2=""+"www.566.net";
        String w0=""+"http://www.5566.net/digit-.htm";
        String k4="=''+location.host;";
        String q4="2266.5566";
        String e9="9977.5566";
        String c3="=''+document.URL;";
        int f9=f2.lastIndexOf('.');
        int x7=0+Integer.parseInt(String.valueOf(f2.charAt(f9-3)));
        int z1=0+Integer.parseInt(String.valueOf(e9.charAt(0)));
        int t5=0+string2Unicode(String.valueOf(k4.charAt(5)));
        int h1=0+Integer.parseInt(String.valueOf(e9.charAt(2)));
        int l3=0+Integer.parseInt(String.valueOf(f2.charAt(f9-1)));
        int y3=0+string2Unicode(String.valueOf(c3.charAt(6)));
        String d5="digit";
        if(w0.indexOf("5566")==-1||w0.indexOf("digit")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+k2[(r3-l3-z1-h1-t5-y3-46)/x7];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("t8")) {
                    tmpUrl = t8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("w6")) {
                    tmpUrl = w6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("a7")) {

                    tmpUrl = a7(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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


    public  void getUrls(String url){



        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "电脑网络";
        String tag2 ="数码";
//        System.out.println(p.get(51));
        //16, 27, 38, 51
        int[] numbers = {16, 27, 38, 51};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }
    }

    public static void main(String[] args) {

        Digit56 digit56 = new Digit56();
        digit56.getUrls("http://www.5566.net/digit-.htm");
    }




}
