package com.home.spider5566;

import com.home.spring.JDBCHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.CachedIntrospectionResults;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;

/**
 * Created by hadoop on 16-11-21.
 */
public class Cai17 {
    String[] k0={"0","www.zhihuangjin.com/","www.sino-manager.com/","www.stockstar.com/","www.forex.com.cn/","www.17ok.com/","www.capitalweek.com.cn/","cn.wsj.com/","www.ceh.com.cn/","www.eastmoney.com/","www.eeo.com.cn/","www.huagu.com/","www.10jqka.com.cn/","www.nbd.com.cn/","paper.ce.cn/","www.ceconline.com/","cn.reuters.com/","www.24k99.com/","cfi.net.cn/","finance.qq.com/","money.163.com/","www.cet.com.cn/","jjckb.xinhuanet.com/","www.cnstock.com/","finance.people.com.cn/","www.p5w.net/","www.yicai.com/","www.fortunechina.com/","finance.sina.com.cn/","www.financialnews.com.cn/","www.fx678.com/","www.ibtimes.com.cn/","www.yinhang.com/","finance.ifeng.com/","www.fx168.com/","www.ccstock.cn/","www.caijing.com.cn/","business.sohu.com/","www.cnstock.com/","www.chinanews.com/finance/","www.stcn.com/","www.cs.com.cn/","www.ftchinese.com/","www.xinhuanet.com/fortune/","www.cb.com.cn/","www.caixin.com/","www.cngold.org/","www.hexun.com/","zqdb.hinews.cn/","www.forexstar.com.cn/","jingji.cntv.cn/","www.gemag.com.cn/","www.jrj.com.cn/","www.yicai.com/","epaper.21so.com/","www.caijing.com.cn/","www.aastocks.com/","www.ce.cn/","news.hexun.com/","www.591hx.com/","fund.eastmoney.com/","paper.people.com.cn/gjjrb/paperindex.htm","finance.21cn.com/","www.cnfol.com/","www.nbd.com.cn/newspapers/today"};
    String z7="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;
    public Cai17(){
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

    public String  k4(int g3){
       String url = "";
        String a3="=''+document.URL;";
        String p7=""+"www.5566.net";
        String n6="9944.5566";
        String q9="2233.5566";
        String m0=""+"http://www.5566.net/cai-4.htm";
        String c4="=''+location.host;";
        int n7=p7.lastIndexOf('.');
        int s3=0+string2Unicode(String.valueOf(a3.charAt(6)));
        int u0=0+Integer.parseInt(String.valueOf(p7.charAt(n7-3)));
        int n8=0+Integer.parseInt(String.valueOf(q9.charAt(2)));
        int n4=0+Integer.parseInt(String.valueOf(p7.charAt(n7-1)));
        int x5=0+Integer.parseInt(String.valueOf(q9.charAt(0)));
        int z2=0+string2Unicode(String.valueOf(c4.charAt(5)));
        String o2="cai";
        if(m0.indexOf("5566")>=0&&m0.indexOf("cai")>=0){
            url = "http://"+k0[(g3-u0-x5-n8-z2-s3-35)/n4];
        }
        return  url;
    }
   public String  r1(int v7){
       String url ="";
        String q6=""+"www.5566.net";
        String f4="6688.5566";
        String h7=""+"http://www.5566.net/cai-4.htm";
        String q0="=''+location.href;";
        String n6="3322.5566";
        String t0="=''+location.hostname;";
        int l9=q6.lastIndexOf('.');
        int v6=0+Integer.parseInt(String.valueOf(q6.charAt(l9-3)));
        int s1=0+Integer.parseInt(String.valueOf(q6.charAt(l9-1)));
        int s9=0+Integer.parseInt(String.valueOf(f4.charAt(0)));
        int k5=0+string2Unicode(String.valueOf(q0.charAt(6)));
        int e3=0+Integer.parseInt(String.valueOf(f4.charAt(3)));
        int i8=0+string2Unicode(String.valueOf(t0.charAt(5)));
        String o6="cai";
        if(q6=="5566.net"||q6=="www.5566.net"||q6=="566.org"||q6=="1.5566.org"||q6=="2.5566.org"||q6=="3.5566.org"||q6=="4.5566.org"||q6=="5.5566.org"||q6=="www.5566.org"){
           url = "http://"+k0[(v7-v6-s1-e3-i8-k5-4)/s9];
        }
        return  url;
    }
   public String  g7(int c6){
       String url;
        String e1=""+"http://www.5566.net/cai-4.htm";
        String f7="=''+document.location;";
        String a7=""+"www.5566.net";
        String l7="=''+document.domain;";
        String m1="8866.5566";
        String g4="4499.5566";
        int q7=a7.lastIndexOf('.');
        int f1=0+Integer.parseInt(String.valueOf(g4.charAt(1)));
        int j0=0+string2Unicode(String.valueOf(f7.charAt(6)));
        int p2=0+Integer.parseInt(String.valueOf(a7.charAt(q7-3)));
        int l0=0+string2Unicode( String.valueOf(l7.charAt(5)));
        int n3=0+Integer.parseInt(String.valueOf(g4.charAt(3)));
        int t3=0+Integer.parseInt(String.valueOf(a7.charAt(q7-1)));
        String d4="cai";
        if(a7!="5566.net"&&a7!="www.5566.net"&&a7!="5566.org"&&a7!="1.5566.org"&&a7!="2.5566.org"&&a7!="3.5566.org"&&a7!="4.5566.org"&&a7!="5.5566.org"&&a7!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+k0[(c6-t3-f1-n3-l0-j0-3)/p2];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("k4")) {
                    tmpUrl = k4(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("r1")) {
                    tmpUrl = r1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("g7")) {

                    tmpUrl = g7(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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


public  void getCaiUrls(String url){
    Document doc=null;
    try {
        doc = Jsoup.connect(url).get();
    } catch (IOException e) {
        e.printStackTrace();
    }

    Elements p = doc.getElementsByTag("tr");
    String tag1 = "财经";
    String tag2 ="";
//        System.out.println(p.get(39));
    //20,39
    int[] numbers = {20, 39};
    for(int i =0;i < numbers.length;i++){

        Elements urls = p.get(numbers[i]).getElementsByTag("a");
        getUrlAndText(urls, tag1, tag2);

    }



}


    public static void main(String[] args) {
    Cai17 cai17 = new Cai17();
        cai17.getCaiUrls("http://www.5566.net/cai-4.htm");



    }






}
