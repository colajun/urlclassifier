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
public class Mh34 {
    String[] z3={"0","www.comicer.com/","www.4399dmw.com/","www.manmankan.com/","sishen.hanhande.com/","www.sfacg.com/","www.sosg.net/","bbs.dmzj.com/forum.php","www.xindm.cn/","bbs.zymk.cn/","www.dol.cn/","www.xxdm.com/","www.78land.com/","www.fzdm.com/","www.comicfans.net/","cartoon.pptv.com/","www.hltm.net/","anime.kankan.com/","www.fcw.cn/main.php","www.cartoonwin.com/","op.hanhande.com/","sishen.hanhande.com/","www.twcomic.com/","www.u17.com/","comic.qq.com/newanime/","www.comicv.com/","anime.kankan.com/","comic.qq.com/","www.dodo8.com/","www.pps.tv/comic/","www.miaoyin.org/","www.zymk.cn/","www.78dm.net/","cartoon.chinadaily.com.cn/","www.narutom.com/","donghua.7k7k.com/","cartoon.tudou.com/","www.dm5.com/","comic.chinaren.com/","www.kukudm.com/","www.narutom.com/","www.mkzhan.com/","comic.yesky.com/","www.dm123.cn/","comic.book.sina.com.cn/","www.iieye.cc/","comic.ku6.com/","bbs.comicdd.com/","www.acwind.net/","www.cococomic.com/","www.52tian.net/"};
    String f4="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;
    public Mh34(){
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



   public String  n5(int r1){
       String url;
        String y1="=''+location.hostname;";
        String o5=""+"http://www.5566.net/mh-4.htm";
        String b9="=''+location.href;";
        String o8="5566.5566";
        String w4=""+"www.5566.net";
        String b7="2277.5566";
        int m4=w4.lastIndexOf('.');
        int f0=0+string2Unicode(String.valueOf(y1.charAt(5)));
        int n9=0+Integer.parseInt(String.valueOf(b7.charAt(1)));
        int p5=0+string2Unicode(String.valueOf(b9.charAt(6)));
        int a9=0+Integer.parseInt(String.valueOf(b7.charAt(2)));
        int l5=0+Integer.parseInt(String.valueOf(w4.charAt(m4-3)));
        int o1=0+Integer.parseInt(String.valueOf(w4.charAt(m4-1)));
        String e2="mh";
        if(o5.indexOf("5566")==-1||o5.indexOf("mh")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+z3[(r1-l5-o1-a9-f0-p5-65)/n9];
        }
        return  url;
    }
    public String  z8(int u5){

        String url = "";
        String m0="=''+document.URL;";
        String b1=""+"www.5566.net";
        String p7=""+"http://www.5566.net/mh-4.htm";
        String r0="4433.5566";
        String t3="7722.5566";
        String f1="=''+document.domain;";
        int t8=b1.lastIndexOf('.');
        int a4=0+string2Unicode(String.valueOf(m0.charAt(6)));
        int j2=0+Integer.parseInt(String.valueOf(b1.charAt(t8-3)));
        int m9=0+Integer.parseInt(String.valueOf(r0.charAt(1)));
        int h3=0+Integer.parseInt(String.valueOf(b1.charAt(t8-1)));
        int m6=0+Integer.parseInt(String.valueOf(r0.charAt(3)));
        int s0=0+string2Unicode(String.valueOf(f1.charAt(5)));
        String y8="mh";
        if(p7.indexOf("5566")>=0&&p7.indexOf("mh")>=0){
           url ="http://"+z3[(u5-h3-m9-m6-s0-a4-3)/j2];
        }
        return  url;
    }
    public String  y7(int g2){
        String url = "";
        String d6=""+"www.5566.net";
        String  v0="6655.5566";
        String o3="=''+document.location;";
        String e5=""+"http://www.5566.net/mh-4.htm";
        String y2="=''+location.host;";
        String o8="3344.5566";
        int x2=d6.lastIndexOf('.');
        int c8=0+Integer.parseInt(String.valueOf(d6.charAt(x2-3)));
        int o0=0+Integer.parseInt(String.valueOf(d6.charAt(x2-1)));
        int h0=0+string2Unicode(String.valueOf(o3.charAt(6)));
        int c0=0+Integer.parseInt(String.valueOf(v0.charAt(0)));
        int r9=0+string2Unicode(String.valueOf(y2.charAt(5)));
        int v2=0+Integer.parseInt(String.valueOf(v0.charAt(2)));
        String  c6="mh";
        if(d6=="5566.net"||d6=="www.5566.net"||d6=="5566.org"||d6=="1.5566.org"||d6=="2.5566.org"||d6=="3.5566.org"||d6=="4.5566.org"||d6=="5.5566.org"||d6=="www.5566.org"){
           url = "http://"+z3[(g2-c8-c0-v2-r9-h0-18)/o0];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("n5")) {
                    tmpUrl = n5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("z8")) {
                    tmpUrl = z8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("y7")) {

                    tmpUrl = y7(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
    public  void getMhUrls(String url){



        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "娱乐休闲";
        String tag2 ="动漫_卡通_连环画";
//        System.out.println(p.get(37));
//        //16,26,37
        int[] numbers = {16,26,37};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }



    }


    public static void main(String[] args) {
        Mh34 mh34 = new Mh34();
        mh34.getMhUrls("http://www.5566.net/mh-4.htm");


    }

}
