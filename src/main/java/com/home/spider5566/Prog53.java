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
 * Created by hadoop on 16-11-24.
 */
public class Prog53 {
    String[] e0={"0","www.programfan.com","dev.21tx.com/language/vc/","www.jcwcn.com/article/programming/delphi/","www.pconline.com.cn/pcedu/empolder/gj/vc/0607/820674.html","www.iteye.com/","www.moon-soft.com/doc/2_1.htm","bbs.bccn.net/","www.comprg.com.cn/","www.chinacs.net/","tech.163.com/special/00091T71/javashipin.html","www.knowsky.com/","www.pfan.cn/Article/list/class/3.html","www.kingofcoders.com/","www.moon-soft.com/download/sort/1_1.htm","www.xker.com/edu/dev/","www.cppfans.com","www.mndsoft.com/","www.delphifans.com/","www.pconline.com.cn/pcedu/empolder/gj/java/index.html","bbs.pfan.cn/forum/5.html","www.moon-soft.com/doc/1_1.htm","www.java-cn.com/","www.microsoft.com/china/msdn/","www.pfan.cn/Article/list/class/4.html","www.pconline.com.cn/pcedu/empolder/gj/vc/index.html","www.pconline.com.cn/pcedu/empolder/gj/delphi/","bbs.csdn.net/forums/VC/","dev.yesky.com/msdn/msdnvcnet/","www.pconline.com.cn/pcedu/empolder/","bbs.pfan.cn/","www.blogjava.net/","www.hur.cn/","java.sun.com/","www.pudn.com/","www.bccn.net/","www.bc-cn.net/Article/kfyy/java/","www.mscto.com/","developer.51cto.com/","www.vckbase.com/","www.pudn.com/","www.mycodes.net","www.stubc.com/","www.moon-soft.com/","www.xuedelphi.cn/","www.freebasic.net/","www.enet.com.cn/eschool/cxkf.shtml","www.ibm.com/developerworks/cn/java/","www.enet.com.cn/eschool/zhuanti/vc++/","bbs.csdn.net/forums/VB","www.bc-cn.net/Article/kfyy/vb/","www.dayi.net","java.csdn.net/","www.java.com/zh_CN/","www.enet.com.cn/eschool/video/vb/","www.ddvip.com/program/","dev.yesky.com/","bbs.csdn.net/forums/Delphi","www.moon-soft.com/doc/3_1.htm","www.bccn.net/Article/kfyy/delphi/","www.jcwcn.com/article/programming/c_cpp/","www.chinavb.net/","www.microsoft.com/china/msdn/vstudio/","tech.sina.com.cn/soft/dev/index.html","www.pconline.com.cn/pcedu/empolder/gj/vb/","www.newasp.net/code/Delphi/list_177_1.html","www.ccrun.com","www.educity.cn/help/c160.html","www.pconline.com.cn/pcedu/empolder/gj/cb/index.html","www.moon-soft.com/download/sort/2_1.htm","www.cjsdn.net/","programmer.csdn.net/","dev.yesky.com/devjava/","www.csdn.net/","dev.21tx.com/language/delphi/","dev.yesky.com/ysdevdelphi/","tech.163.com/special/0009159F/vc.html","bbs.csdn.net/forums/Java","www.52delphi.com/","www.bianceng.cn/VBjc/Vb.HTM","www.enet.com.cn/eschool/zhuanti/java/","www.iteye.com/","www.cnblogs.com/","download.csdn.net/"};
    String j8="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;

    public Prog53() {
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


    public String  m1(int k9){
        String url= "";
        String e4=""+"http://www.5566.net/prog-3.htm";
        String w5="1144.5566";
        String r9="=''+document.domain;";
        String h0="=''+document.location;";
        String v9=""+"www.5566.net";
        String n5="7722.5566";
        int q4=v9.lastIndexOf('.');
        int p2=0+Integer.parseInt(String.valueOf(w5.charAt(0)));
        int a1=0+Integer.parseInt(String.valueOf(v9.charAt(q4-1)));
        int k1=0+string2Unicode(String.valueOf(r9.charAt(5)));
        int m0=0+string2Unicode(String.valueOf(h0.charAt(6)));
        int x5=0+Integer.parseInt(String.valueOf(v9.charAt(q4-3)));
        int v8=0+Integer.parseInt(String.valueOf(w5.charAt(2)));
        String w1="prog";
        if(v9=="5566.net"||v9=="www.5566.net"||v9=="5566.org"||v9=="1.5566.org"||v9=="2.5566.org"||v9=="3.5566.org"||v9=="4.5566.org"||v9=="5.5566.org"||v9=="www.5566.org"){
           url = "http://"+e0[(k9-x5-a1-v8-k1-m0-59)/p2];
        }
        return  url;
    }
   public String  g8(int c0){
       String url = "";
        String h9="=''+document.URL;";
        String t9="=''+location.host;";
        String l0=""+"www.5566.net";
        String n5="9988.5566";
        String t8="2277.5566";
        String l5=""+"http://www.5566.net/prog-3.htm";
        int h2=l0.lastIndexOf('.');
        int q6=0+string2Unicode(String.valueOf(h9.charAt(6)));
        int p5=0+string2Unicode(String.valueOf(t9.charAt(5)));
        int o3=0+Integer.parseInt(String.valueOf(l0.charAt(h2-3)));
        int l4=0+Integer.parseInt(String.valueOf(t8.charAt(3)));
        int y1=0+Integer.parseInt(String.valueOf(l0.charAt(h2-1)));
        int b0=0+Integer.parseInt(String.valueOf(t8.charAt(0)));
        String a6="prog";
        if(l5.indexOf("5566")>=0&&l5.indexOf("prog")>=0){
           url = "http://"+e0[(c0-o3-b0-l4-p5-q6-69)/y1];
        }
        return  url;
    }
   public String  k6(int o7){
       String url ;
        String q2="=''+location.hostname;";
        String z0="4411.5566";
        String q0=""+"www.5566.net";
        String z3="8899.5566";
        String w6="=''+location.href;";
        String k0=""+"http://www.5566.net/prog-3.htm";
        int i5=q0.lastIndexOf('.');
        int n0=0+string2Unicode(String.valueOf(q2.charAt(5)));
        int j6=0+Integer.parseInt(String.valueOf(z3.charAt(3)));
        int z7=0+Integer.parseInt(String.valueOf(q0.charAt(i5-3)));
        int e7=0+Integer.parseInt(String.valueOf(q0.charAt(i5-1)));
        int t4=0+string2Unicode(String.valueOf(w6.charAt(6)));
        int n1=0+Integer.parseInt(String.valueOf(z3.charAt(0)));
        String a4="prog";
        if(k0.indexOf("5566")==-1||k0.indexOf("prog")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+e0[(o7-e7-n1-j6-n0-t4-70)/z7];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("m1")) {
                    tmpUrl = m1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("q4")) {
                    tmpUrl = g8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("k6")) {

                    tmpUrl = k6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

                }
            } catch (Exception e) {
                tmpUrl = href.attr("href");
                tmpName = href.text();
            }
            if (tmpUrl.length() >11) {

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
        String tag2 ="程序设计";
//        System.out.println(p.get(64));
        //16, 31, 41,52, 64
        int[] numbers = {16, 31, 41,52, 64};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }




    }

    public static void main(String[] args) {

        Prog53 prog53 = new Prog53();
        prog53.getUrls("http://www.5566.net/prog-3.htm");



    }






}
