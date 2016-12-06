package com.home.spider5566;

import com.home.spring.JDBCHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import spire.math.SafeLongIsRing;

import java.io.IOException;

/**
 * Created by hadoop on 16-11-22.
 */
public class Le25 {
    String[] y3={"0","ent.tudou.com/","yule.sohu.com/","ent.sina.com.cn/","ent.163.com/","ent.enorth.com.cn/","v.163.com/yule/","enjoy.eastday.com/","www.67.com/","ent.wasu.cn/","www.fun.tv/ent/","ent.qianlong.com/","tv.sohu.com/yule/","ent.sina.com.cn/korea/","blog.qq.com/ent/","ent.ku6.com/","www.joy.cn/entertainment/all","ent.cnool.net/","ent.ifeng.com/","ent.zjol.com.cn/","bbs.tianya.cn/list-funinfo-1.shtml","ent.news.cn/","korea.sohu.com/","yule.iqiyi.com/","yule.kankan.com/","korea.pptv.com/","www.56.com/ent","ent.china.com/","joy.online.sh.cn/","tv.sohu.com/yule/","blog.sina.com.cn/lm/ent/","ent.ynet.com/","news.dayoo.com/ent/","ent.qq.com/","www.chinanews.com/entertainment/index.shtml","ent.people.com.cn/","www.pengpeng.com/","www.yule.com.cn/","v.qq.com/ent/","www.ifensi.com/","ent.letv.com/","video.sina.com.cn/ent/","fun.hsw.cn/","gb.cri.cn/ent/","v.ifeng.com/ent/","www.hunantv.com/","ent.uusee.com/","et.21cn.com/"};
    String m1="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;
    public Le25(){
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


  public String  r2(int y5){
      String url;
        String n3="=''+location.host;";
        String s0="2277.5566";
        String b1=""+"www.5566.net";
        String s4="=''+document.location;";
        String k8="3355.5566";
        String y0=""+"http://www.5566.net/le-3.htm";
        int l8=b1.lastIndexOf('.');
        int j8=0+string2Unicode(String.valueOf(n3.charAt(5)));
        int x6=0+Integer.parseInt(String.valueOf(b1.charAt(l8-1)));
        int y1=0+Integer.parseInt(String.valueOf(b1.charAt(l8-3)));
        int h6=0+string2Unicode(String.valueOf(s4.charAt(6)));
        int n7=0+Integer.parseInt(String.valueOf(s0.charAt(2)));
        int p4=0+Integer.parseInt(String.valueOf(s0.charAt(1)));
        String p0="le";
        if(b1!="5566.net"&&b1!="www.5566.net"&&b1!="5566.org"&&b1!="1.5566.org"&&b1!="2.5566.org"&&b1!="3.5566.org"&&b1!="4.5566.org"&&b1!="5.5566.org"&&b1!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+y3[(y5-y1-p4-n7-j8-h6-37)/x6];
        }
        return  url;
    }
   public String  o8(int n6){
       String url;
        String k8="7722.5566";
        String s2="8899.5566";
        String n1="=''+document.domain;";
        String  x9=""+"http://www.5566.net/le-3.htm";
        String v0="=''+location.href;";
        String g0=""+"www.5566.net";
        int z1=g0.lastIndexOf('.');
        int a3=0+Integer.parseInt(String.valueOf(s2.charAt(3)));
       int  e3=0+Integer.parseInt(String.valueOf(g0.charAt(z1-1)));
        int y4=0+string2Unicode(String.valueOf(n1.charAt(5)));
        int m4=0+Integer.parseInt(String.valueOf(s2.charAt(1)));
        int h2=0+string2Unicode(String.valueOf(v0.charAt(6)));
        int o9=0+Integer.parseInt(String.valueOf(g0.charAt(z1-3)));
        String n0="le";
        if(x9.indexOf("5566")==-1||x9.indexOf("le")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
          url  ="http://"+y3[(n6-o9-e3-a3-y4-h2-39)/m4];
        }
        return  url;
    }
    public String  t8(int j6){
        String url = "";
        String s5="=''+location.hostname;";
        String k3=""+"http://www.5566.net/le-3.htm";
        String s6="9988.5566";
        String d2="5533.5566";
        String m7=""+"www.5566.net";
        String u8="=''+document.URL;";
        int t6=m7.lastIndexOf('.');
        int b5=0+string2Unicode(String.valueOf(s5.charAt(5)));
        int k6=0+Integer.parseInt(String.valueOf(d2.charAt(0)));
        int g3=0+Integer.parseInt(String.valueOf(d2.charAt(2)));
        int g9=0+Integer.parseInt(String.valueOf(m7.charAt(t6-1)));
        int x0=0+Integer.parseInt(String.valueOf(m7.charAt(t6-3)));
        int t3=0+string2Unicode(String.valueOf(u8.charAt(6)));
        String b8="le";
        if(m7=="5566.net"||m7=="www.5566.net"||m7=="5566.org"||m7=="1.5566.org"||m7=="2.5566.org"||m7=="3.5566.org"||m7=="4.5566.org"||m7=="5.5566.org"||m7=="www.5566.org"){
           url = "http://"+y3[(j6-g9-k6-g3-b5-t3-24)/x0];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("r2")) {
                    tmpUrl = r2(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("o8")) {
                    tmpUrl = o8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("t8")) {

                    tmpUrl = t8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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



    public  void getLeUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "娱乐体闲";
        String tag2 ="";
//        System.out.println(p.get(32));
        //17,32
        int[] numbers = {17,32};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }

    }



    public static void main(String[] args) {

        Le25 le25 = new Le25();

        le25.getLeUrls("http://www.5566.net/le-3.htm");


    }





}
