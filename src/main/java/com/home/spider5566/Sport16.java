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
public class Sport16 {
    String[] r7={"0","forum.sports.sina.com.cn/forum-39-1.html","www.chende.net/","sports.sina.com.cn/chess/weiqi/index.shtml","www.szbrg.com/bbs/","sports.titan24.com/qipai/","sports.qq.com/chess/weiq/wq.htm","www.zdwq.com/","chess.sport.org.cn/","www.zgxqds.com/","www.weiqi.cc/","www.stqiyuan.com/","qqgame.qq.com/","www.19361.com/","www.cchess.com/","www.yhgame.cn/","bridge.ourgame.com/","www.sdqipai.com/","www.gochess.cn/","www.gameabc.com/","weiqi.sports.tom.com/","www.icanju.cn/","www.zswq.cn/","www.szbrg.com/","sports.sina.com.cn/chess/","sports.sohu.com/1/0504/46/subject220114618.shtml","www.cyxqw.com/","www.siyuetian.net/","www.ourgame.com/","www.chessinchina.net/","bridge.sport.org.cn/","www.flygo.net/","www.kele8.com/","chess.ourgame.com/","www.gdchess.com/bbs/","weiqi.sport.org.cn/","www.nwpgo.com/","ccl.sports.cn/","www.ccba.org.cn/","www.eweiqi.com/","www.bridgeface.com/","www.xmbridge.org/","www.wpcx.com.cn/","www.xiangqi.org.cn/","sports.sohu.com/1/0803/16/subject211831626.shtml","www.jj.cn/","sports.163.com/qp","hychess.com/bbs/","sports.qq.com/chess/index.htm","www.64ge.net/","forum.sports.sina.com.cn/forum-40-1.html","www.weiqibar.com/","www.weiqi.cn/","www.gametea.com/","www.chinagames.net/","www.nwpwq.com/","sports.sohu.com/qipai/","www.gdchess.com/","www.qisedu.com/","www.movesky.net/","bridge.ustc.edu.cn/","forum.sports.sina.com.cn/forum-38-1.html"};
    String u7="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;
    public Sport16(){
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


   public  String t9(int p3){
       String url ="";
        String k5=""+"http://www.5566.net/sport7-5.htm";
        String d5="7766.5566";
        String z4="4422.5566";
        String t7="=''+location.host;";
        String t4="=''+document.location;";
        String c7=""+"www.5566.net";
        int z0=c7.lastIndexOf('.');
        int k0=0+Integer.parseInt(String.valueOf(z4.charAt(0)));
        int b1=0+Integer.parseInt(String.valueOf(z4.charAt(3)));
        int w4=0+Integer.parseInt(String.valueOf(c7.charAt(z0-1)));
        int b3=0+string2Unicode(String.valueOf(t7.charAt(5)));
        int n9=0+string2Unicode(String.valueOf(t4.charAt(6)));
        int u8=0+Integer.parseInt(String.valueOf(c7.charAt(z0-3)));
        String n7="sport7";
        if(k5.indexOf("5566")>=0&&k5.indexOf("sport7")>=0){
           url = "http://"+r7[(p3-w4-k0-b1-b3-n9-50)/u8];
        }
        return  url;
    }
   public String r0(int m8){
       String url;
        String y6="=''+document.domain;";
        String s0="1155.5566";
        String g4=""+"www.5566.net";
        String z8=""+"http://www.5566.net/sport7-5.htm";
        String r4="=''+document.URL;";
        String i1="2244.5566";
        int x9=g4.lastIndexOf('.');
        int c1=0+string2Unicode(String.valueOf(y6.charAt(5)));
        int g7=0+Integer.parseInt(String.valueOf(g4.charAt(x9-1)));
        int b0=0+Integer.parseInt(String.valueOf(g4.charAt(x9-3)));
        int k1=0+Integer.parseInt(String.valueOf(s0.charAt(0)));
        int z5=0+string2Unicode(String.valueOf(r4.charAt(6)));
        int a9=0+Integer.parseInt(String.valueOf(s0.charAt(2)));
        String c5="sport7";
        if(z8.indexOf("5566")==-1||z8.indexOf("sport7")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+r7[(m8-b0-k1-a9-c1-z5-65)/g7];
        }
        return  url;
    }
    public String  w8(int k6){
        String url;
        String a8=""+"http://www.5566.net/sport7-5.htm";
        String i1="5511.5566";
        String o6="=''+location.hostname;";
        String l4=""+"www.5566.net";
        String w9="=''+location.href;";
        String j5="6677.5566";
        int m7=l4.lastIndexOf('.');
        int c3=0+Integer.parseInt(String.valueOf(j5.charAt(0)));
        int q6=0+Integer.parseInt(String.valueOf(j5.charAt(3)));
        int v6=0+string2Unicode(String.valueOf(o6.charAt(5)));
        int t3=0+Integer.parseInt(String.valueOf(l4.charAt(m7-3)));
        int b6=0+string2Unicode(String.valueOf(w9.charAt(6)));
        int s6=0+Integer.parseInt(String.valueOf(l4.charAt(m7-1)));
        String n5="sport7";
        if(l4!="5566.net"&&l4!="www.5566.net"&&l4!="5566.org"&&l4!="1.5566.org"&&l4!="2.5566.org"&&l4!="3.5566.org"&&l4!="4.5566.org"&&l4!="5.5566.org"&&l4!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+r7[(k6-t3-s6-q6-v6-b6-48)/c3];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("t9")) {
                    tmpUrl = t9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("r0")) {
                    tmpUrl = r0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("w8")) {

                    tmpUrl = w8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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



    public  void getSportUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "体育运动";
        String tag2 ="棋牌";
//        System.out.println(p.get(26));
        //17,26
        int[] numbers = {17,26};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }



    }



    public static void main(String[] args) {

        Sport16 sport16 = new Sport16();

        sport16.getSportUrls("http://www.5566.net/sport7-5.htm");


    }




}
