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
public class Sport13 {
    String[] b4={"0","www.olympic.cn/","equestrian.sport.org.cn/","dragonboat.sport.org.cn/","www.win007.com/","www.xinhuanet.com/sports/","www.taekwondo.org.cn/","forum.home.news.cn/list/93-0-0-1.html","www.sport.org.cn/","www.tennis.org.cn/","tv.sohu.com/sports/","skating.sport.org.cn/","nba.hupu.com/","sports.online.sh.cn/","fencing.sport.org.cn/","www.xici.net/Sport/","www.cba.org.cn/","www.crpa.cn/","yaoming.sports.sohu.com/","www.wushu.com.cn/","sports.qq.com/","dragonlion.sport.org.cn/","china.nba.com/","www.zhibo8.com/","sports.cntv.cn/live/cctv5/","www.7m.cn/","sports.video.sina.com.cn/","baseball.sport.org.cn/","www.cbsa.org.cn/","motocycle.sport.org.cn/","bbs.cntv.cn/group-30346.html","www.sport.gov.cn/","e.titan24.com/","sports.pptv.com/","sports.163.com/","www.autosports.org.cn/","cga.sport.org.cn/","bridge.sport.org.cn/","softball.sport.org.cn/","handball.sport.org.cn/","www.b3.org.cn/","club.sports.sohu.com/","swimming.sport.org.cn/","www.dancesport.org.cn/","chess.sport.org.cn/","forum.sports.sina.com.cn/","csol.sports.cn/","sports.ku6.com/","www.athletics.org.cn/","www.sportscn.com/","www.titan24.com/","jianqiu.sport.org.cn/","www.rowing.org.cn/","sports.ifeng.com/","tabletennis.sport.org.cn/","boules.sport.org.cn/","sports.china.com/","www.cwa.org.cn/","www.caa.net.cn/","www.lottery.gov.cn/","www.chinanews.com/sports/","sports.iqiyi.com/","www.golf.org.cn/","www.fa.org.cn/","sports.sohu.com/blog/","sports.ynet.com/","sports.china.com.cn/","blog.qq.com/sports/","weiqi.sport.org.cn/","sports.cri.cn/","www.volleyball.org.cn/","icehockey.sport.org.cn/","sports.sina.com.cn/","sports.cntv.cn/","www.sport1.cn/","www.basketball.org.cn/","triathlon.sport.org.cn/","www.olympic.org/","diving.sport.org.cn/","sports.21cn.com/","www.xiangqi.org.cn/","modernpentathlon.sport.org.cn/","www.sport.org.cn/","boxing.sport.org.cn/","www.fun.tv/greatsports/","sports.nubb.com/","www.sports.cn/","archery.sport.org.cn/","oacn.sport.org.cn/","sports.tudou.com/","sailboarding.sport.org.cn/","sports.qianlong.com/","www.waterski.cn/","bbs.tianya.cn/list-sport-1.shtml","sports.cntv.cn/dianbo/","cmasports.sport.org.cn/","hockey.sport.org.cn/","rollersports.sport.org.cn/","softtennis.sport.org.cn/","www.gateball.cn/","cycling.sport.org.cn/","www.lesports.com/","sports.people.com.cn/","canoe.sport.org.cn/","www.skiing.org.cn/","wrestling.sport.org.cn/","sport.56.com/","bbs.sports.163.com/","www.tugofwar.org.cn/","blog.sina.com.cn/lm/sports/","shooting.sport.org.cn/","sports.sohu.com/","bowling.sport.org.cn/","motoboat.sport.org.cn/","judo.sport.org.cn/"};
    String q5="http://www.5566.org/indexe.htm";
    JdbcTemplate jdbcTemplate = null;
    public Sport13(){
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



    public String  w5(int l3){
        String url;
        String l5="1166.5566";
        String o7=""+"www.5566.net";
        String e8="4422.5566";
        String s9="=''+document.location;";
        String d9="=''+document.domain;";
        String m1=""+"http://www.5566.net/sport1-5.htm";
        int a1=o7.lastIndexOf('.');
        int w4=0+Integer.parseInt(String.valueOf(o7.charAt(a1-1)));
        int q9=0+Integer.parseInt(String.valueOf(o7.charAt(a1-3)));
        int v2=0+Integer.parseInt(String.valueOf(l5.charAt(2)));
        int t6=0+string2Unicode(String.valueOf(s9.charAt(6)));
        int y4=0+string2Unicode(String.valueOf(d9.charAt(5)));
        int p8=0+Integer.parseInt(String.valueOf(l5.charAt(0)));
        String w2="sport1";
        if(m1.indexOf("5566")==-1||m1.indexOf("sport1")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+b4[(l3-q9-w4-v2-y4-t6-29)/p8];
        }
        return  url;
    }
   public String  r1(int o1){
       String url;
        String j8=""+"http://www.5566.net/sport1-5.htm";
        String r3=""+"www.5566.net";
        String l9="=''+location.host;";
        String t2="2244.5566";
        String e8="9933.5566";
        String h3="=''+document.URL;";
        int u4=r3.lastIndexOf('.');
        int n4=0+Integer.parseInt(String.valueOf(t2.charAt(0)));
        int p6=0+Integer.parseInt(String.valueOf(r3.charAt(u4-3)));
        int a9=0+string2Unicode(String.valueOf(l9.charAt(5)));
        int k8=0+Integer.parseInt(String.valueOf(r3.charAt(u4-1)));
        int c7=0+Integer.parseInt(String.valueOf(t2.charAt(3)));
        int t9=0+string2Unicode(String.valueOf(h3.charAt(6)));
        String c9="sport1";
        if(r3!="5566.net"&&r3!="www.5566.net"&&r3!="5566.org"&&r3!="1.5566.org"&&r3!="2.5566.org"&&r3!="3.5566.org"&&r3!="4.5566.org"&&r3!="5.5566.org"&&r3!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
          url = "http://"+b4[(o1-p6-n4-c7-a9-t9-90)/k8];
        }
        return  url;
    }
   public String  t1(int  o8){
       String url ="";
        String u5="3399.5566";
        String m6=""+"http://www.5566.net/sport1-5.htm";
        String j2="=''+location.href;";
        String n0="6611.5566";
        String e6=""+"www.5566.net";
        String g0="=''+location.hostname;";
        int r6=e6.lastIndexOf('.');
        int b5=0+Integer.parseInt(String.valueOf(e6.charAt(r6-1)));
        int d1=0+Integer.parseInt(String.valueOf(u5.charAt(1)));
        int m9=0+string2Unicode(String.valueOf(j2.charAt(6)));
        int y7=0+Integer.parseInt(String.valueOf(u5.charAt(3)));
        int s3=0+Integer.parseInt(String.valueOf(e6.charAt(r6-3)));
        int i3=0+string2Unicode(String.valueOf(g0.charAt(5)));
        String z7="sport1";
        if(m6.indexOf("5566")>=0&&m6.indexOf("sport1")>=0){
           url = "http://"+b4[(o8-b5-d1-y7-i3-m9-13)/s3];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("t1")) {
                    tmpUrl = t1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("r1")) {
                    tmpUrl = r1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("w5")) {

                    tmpUrl = w5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
        String tag2 ="";
//        System.out.println(p.get(63));
        //18,33,44,54,63
        int[] numbers = {18,33,44,54,63};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }





    }


    public static void main(String[] args) {

        Sport13 sport13 = new Sport13();

        sport13.getSportsUrls("http://www.5566.net/sport1-5.htm");


    }









}
