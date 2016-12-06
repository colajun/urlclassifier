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
 * Created by hadoop on 16-11-26.
 */
public class Soft60 {


    String[] g3={"0","www.kaspersky.com.cn/","qian.hanzify.org/","software.it168.com/","www.soft6.com/","www.ddvip.com/","www.photoshopcn.com/tutorial/","bbs.yhcgo.com/","www.skycn.com/","www.ibm.com.cn/","www.csdn.net/","www.enet.com.cn/eschool/","tech.sina.com.cn/soft/","www.hanzify.org/","bbs.pcbeta.com/","www.corel.com/cn/","www.it.com.cn/edu/","bbs.kingsoft.com/","cn.trendmicro.com/","www.xtzj.com/index.php","www.crsky.com/","soft.yesky.com/lesson/","www.csia.org.cn/","www.4oa.com/Article/","tech.sina.com.cn/soft/","bbs.mumayi.net/","www.jcwcn.com/","www.kingsoft.com/","www.microsoft.com/china/","www.rising.com.cn/","www.neusoft.com/cn/","tech.china.com/zh_cn/netschool/index.html","www.kingdee.com/","itbbs.pconline.com.cn/soft/","school.it168.com/","soft.newhua.com/","pcedu.pconline.com.cn/videoedu/","dl.pconline.com.cn/","www.xjke.com/","www.symantec.com/zh/cn/index.jsp","software.toptenreviews.com/","www.enet.com.cn/software/","pcedu.pconline.com.cn/","www.21hulian.com/","www.onlinedown.net/index.htm","tech.163.com/school/","www.oracle.com/cn/index.html","www.cstc.org.cn/","www.win7china.com/","bbs.ikaka.com/","pcedu.pconline.com.cn/teach/","www.shanse8.com/","bbs.csdn.net/","chenmy.hanzify.org/","www.adobe.com/cn/","www.enet.com.cn/eschool/zhuanti/shipin/","www.moon-soft.com/book/","www.pediy.com/","www.softreg.com.cn/","bbs.crsky.com/","www.buysoftware.cn/","soft.yesky.com/","www.ufida.com.cn/","www.jiangmin.com/","xiazai.zol.com.cn/","pc.beareyes.com.cn/bbs/2.htm","www.mydrivers.com/"};
    String d4="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public Soft60() {
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




   public String  z9(int o7){
       String url = "";
        String n0=""+"http://www.5566.net/soft1-.htm";
        String c0="2277.5566";
        String y4="=''+location.hostname;";
        String n7="9966.5566";
        String r7=""+"www.5566.net";
        String a7="=''+document.URL;";
        int e8=r7.lastIndexOf('.');
        int v6=0+Integer.parseInt(String.valueOf(c0.charAt(0)));
        int l5=0+Integer.parseInt(String.valueOf(r7.charAt(e8-1)));
        int r3=0+string2Unicode(String.valueOf(y4.charAt(5)));
        int o2=0+Integer.parseInt(String.valueOf(c0.charAt(2)));
        int u8=0+Integer.parseInt(String.valueOf(r7.charAt(e8-3)));
        int k3=0+string2Unicode(String.valueOf(a7.charAt(6)));
        String m1="soft1";
        if(n0.indexOf("5566")>=0&&n0.indexOf("soft1")>=0){
           url = "http://"+g3[(o7-u8-v6-o2-r3-k3-73)/l5];
        }
        return  url;
    }
    public String  o5(int c3){
        String url;
        String t7="6699.5566";
        String t8="=''+document.domain;";
        String b7="5533.5566";
        String k2=""+"www.5566.net";
        String v7="=''+document.location;";
        String r0=""+"c0.charAt(2)";
        int c1=k2.lastIndexOf('.');
        int y1=0+Integer.parseInt(String.valueOf(k2.charAt(c1-1)));
        int e4=0+string2Unicode(String.valueOf(t8.charAt(5)));
        int z6=0+Integer.parseInt(String.valueOf(t7.charAt(2)));
        int v4=0+Integer.parseInt(String.valueOf(k2.charAt(c1-3)));
        int o0=0+string2Unicode(String.valueOf(v7.charAt(6)));
        int u6=0+Integer.parseInt(String.valueOf(t7.charAt(0)));
        String  c4="soft1";
        if(k2!="5566.net"&&k2!="www.5566.net"&&k2!="5566.org"&&k2!="1.5566.org"&&k2!="2.5566.org"&&k2!="3.5566.org"&&k2!="4.5566.org"&&k2!="5.5566.org"&&k2!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+g3[(c3-y1-u6-z6-e4-o0-74)/v4];
        }
        return  url;
    }
   public String  b2(int o8){
       String url ;
        String e3=""+"www.5566.net";
        String k7="=''+location.href;";
        String a8="=''+location.host;";
        String c2="3355.5566";
        String j8=""+"http://www.5566.net/soft1-.htm";
        String n7="7722.5566";
        int j7=e3.lastIndexOf('.');
        int a6=0+Integer.parseInt(String.valueOf(e3.charAt(j7-3)));
        int g4=0+string2Unicode(String.valueOf(k7.charAt(6)));
        int q4=0+string2Unicode(String.valueOf(a8.charAt(5)));
        int f5=0+Integer.parseInt(String.valueOf(e3.charAt(j7-1)));
        int f0=0+Integer.parseInt(String.valueOf(c2.charAt(0)));
        int q1=0+Integer.parseInt(String.valueOf(c2.charAt(2)));
        String k8="soft1";
        if(j8.indexOf("5566")==-1||j8.indexOf("soft1")==-1){
          url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+g3[(o8-a6-f5-q1-q4-g4-95)/f0];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("z9")) {
                    tmpUrl = z9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("o5")) {
                    tmpUrl = o5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("b2")) {

                    tmpUrl = b2(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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


        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "电脑网络";
        String tag2 = " 软件";
//        System.out.println(p.get(79));
        //17,31,46,56, 67, 79
        int[] numbers = {17,31,46,56, 67, 79};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);
        }




    }

    public static void main(String[] args) {

        Soft60 soft60 = new Soft60();
        soft60.getUrls("http://www.5566.net/soft1-.htm");

    }









}
