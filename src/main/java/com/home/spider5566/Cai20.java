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
 * Created by hadoop on 16-11-22.
 */
public class Cai20 {
    String[] v1={"0","www.cngrain.com/futures/","www.cjfco.com.cn/","www.gtjaqh.com/","www.alu.cn/","www.copperhome.net/","www.sywgqh.com.cn/","www.itf.com.cn/","www.zdqh.com/","www.sinopecnews.com.cn/","www.zlqh.com/","www.ometal.com/","futures.jrj.com.cn/","www.xiaomai.cn/","www.starfutures.com.cn/","finance.qq.com/money/futures/index.htm","www.zgfcc.com/","www.cngold.org/","www.qhrb.com.cn/","www.dyhjw.com/","www.jyfco.com/","www.shcifco.com/","www.metalnews.cn/","www.gold.org.cn/","www.99qh.com/","www.mfc.com.cn/","www.ccmn.cn/","www.lgmi.com/","www.czce.com.cn/","www.cngrain.com/","www.founderfu.com/","www.dtqh.com.cn/","www.tqfutures.com/","xinhu.cn/","www.htgwf.com/","futures.cnfol.com/","www.lzqh.net.cn/","www.cottonchina.org/","www.dyqh.info/","www.steelhome.cn/","www.ydqh.com.cn/","www.hxqh168.com/","www.kitco.cn/","www.mysteel.com/","finance.sina.com.cn/futuremarket/","www.bfqh.com/","www.cnffi.com/","www.hwqh.com.cn/","www.cffex.com.cn/","futures.hexun.com/","www.cs.com.cn/qhsc/","www.zjncf.com.cn/","www.dhfutures.com/","www.nanhua.net/","www.yhqh.com.cn/","www.shqhgs.com/","www.ynsugar.com/","www.cyqh.com.cn/","www.cfc108.com/","www.jtqh.cn/","www.scqh.com.cn/","www.cfachina.org/","www.zgqh.com.cn/","www.ftol.com.cn/","www.founderfu.com/","www.zhijinwang.com/","www.nzfco.cn/","www.dayouf.com/","www.metalsinfo.com/","www.dyqh.com.cn/","www.cifco.net/","www.ddqh.com/","www.gold-futures.cn/","www.jrqh.com.cn/","www.gldhqh.com.cn/","www.smm.cn/","www.czce.com.cn/portal/jysj/mrhq/A091101index_1.htm","www.shqhgs.com/","www.gffcc.com/","www.jxrich.com/","www.dzqh.com.cn/","www.gtfutures.com.cn/","www.shmet.com/","www.hsqh.net/","money.sohu.com/qihuo/","www.cnstock.com/future/","www.cfmmc.com/","www.zzfco.com/","www.jifco.com.cn/","future.cfi.cn/","www.neweraqh.com.cn/","futures.eastmoney.com/","www.sdfutures.com.cn/","www.shfe.com.cn/","www.lyqh.cn/","www.cnal.com/","www.zhqh.com.cn/","www.gfqh.com.cn/","www.gqsoso.com/","futures.stockstar.com/futures/","www.dlqh.com/","www.jin24k.com/","www.ahcoffco.com/","www.ccf.com.cn/","www.wfqh.com/","www.futuresonline.com.cn/","www.cnmn.com.cn/","www.ebfcn.com/","www.oilprice.cn/","www.shfe.com.cn/statements/","www.btqh.com/","www.7hcn.com/","www.cindaqh.com/","www.oilchina.com/","www.dadou.cn/","www.ccbfutures.com/","www.csrc.gov.cn/","www.gjqh.com.cn/","www.txjhqh.com/","www.dce.com.cn/","www.cofeed.com/","www.cncotton.com/","www.ctia.com.cn/","www.citicsf.com/","www.bhfcc.com/","www.funuo.com/","www.lme.com/","www.swfutures.com/","www.cifco.com.cn/","www.cnzsqh.com/","www.yafco.com/","www.htfutures.com/","www.cafco.com.cn/"};
    String p0="ttp://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;
    public Cai20(){
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



   public String  u8(int m4){
        String url;
        String t5="1166.5566";
        String n0=""+"www.5566.net";
        String h4="=''+document.location;";
        String l6="8844.5566";
        String p1=""+"http://www.5566.net/qh-.htm";
        String z9="=''+location.hostname;";
        int x3=n0.lastIndexOf('.');
        int c2=0+Integer.parseInt(String.valueOf(n0.charAt(x3-1)));
        int c1=0+Integer.parseInt(String.valueOf(n0.charAt(x3-3)));
        int g8=0+string2Unicode(String.valueOf(h4.charAt(6)));
        int j7=0+Integer.parseInt(String.valueOf(t5.charAt(2)));
        int k8=0+Integer.parseInt(String.valueOf(t5.charAt(0)));
        int f6=0+string2Unicode(String.valueOf(z9.charAt(5)));
        String y7="qh";
        if(n0!="5566.net"&&n0!="www.5566.net"&&n0!="5566.org"&&n0!="1.5566.org"&&n0!="2.5566.org"&&n0!="3.5566.org"&&n0!="4.5566.org"&&n0!="5.5566.org"&&n0!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+v1[(m4-c2-k8-j7-f6-g8-17)/c1];
        }
        return  url;
    }
    public String  g7(int d5){
        String url ="";
        String t2="3355.5566";
        String t1=""+"http://www.5566.net/qh-.htm";
        String v6="=''+document.domain;";
        String d6="=''+document.URL;";
        String s0="6611.5566";
        String c5=""+"www.5566.net";
        int y5=c5.lastIndexOf('.');
        int g5=0+Integer.parseInt(String.valueOf(c5.charAt(y5-1)));
        int q7=0+Integer.parseInt(String.valueOf(t2.charAt(0)));
        int k7=0+string2Unicode(String.valueOf(v6.charAt(5)));
        int v7=0+string2Unicode(String.valueOf(d6.charAt(6)));
        int f0=0+Integer.parseInt(String.valueOf(t2.charAt(2)));
        int b2=0+Integer.parseInt(String.valueOf(c5.charAt(y5-3)));
        String y1="qh";
        if(t1.indexOf("5566")>=0&&t1.indexOf("qh")>=0){
           url = "http://"+v1[(d5-b2-q7-f0-k7-v7-62)/g5];
        }
        return  url;
    }
    public String  o0(int z3){
        String url ="";
        String t4="=''+location.href;";
        String y8=""+"http://www.5566.net/qh-.htm";
        String f1="4488.5566";
        String s1="=''+location.host;";
        String s0="5533.5566";
        String c9=""+"www.5566.net";
        int m8=c9.lastIndexOf('.');
        int u7=0+string2Unicode(String.valueOf(t4.charAt(6)));
        int q5=0+Integer.parseInt(String.valueOf(f1.charAt(0)));
        int b8=0+Integer.parseInt(String.valueOf(c9.charAt(m8-1)));
        int s7=0+string2Unicode(String.valueOf(s1.charAt(5)));
        int l8=0+Integer.parseInt(String.valueOf(f1.charAt(3)));
        int d7=0+Integer.parseInt(String.valueOf(c9.charAt(m8-3)));
        String h8="qh";
        if(c9=="5566.net"||c9=="www.5566.net"||c9=="5566.org"||c9=="1.5566.org"||c9=="2.5566.org"||c9=="3.5566.org"||c9=="4.5566.org"||c9=="5.5566.org"||c9=="www.5566.org"){
            url = "http://"+v1[(z3-d7-b8-l8-s7-u7-38)/q5];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("u8")) {
                    tmpUrl = u8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("g7")) {
                    tmpUrl = g7(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("o0")) {

                    tmpUrl = o0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
        String tag2 ="期货";
//        System.out.println(p.get(53));
        //16,26,38,53
        int[] numbers = {16,26,38,53};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }







}



    public static void main(String[] args) {
        Cai20 cai20 = new Cai20();

        cai20.getCaiUrls("http://www.5566.net/qh-.htm");



    }










}
