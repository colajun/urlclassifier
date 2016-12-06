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
public class Paper12 {

    String[] z9={"0","yzdsb.hebnews.cn/","www.legaldaily.com.cn/","www.qhnews.com/","www.ccw.com.cn/","www.chinatibetnews.com/","szsb.sznews.com/","www.chinajilin.com.cn/jlrb/","www.sg.com.cn/","www.cnhubei.com/","www.81.cn/","www.stdaily.com/","www.woman.org.cn/","www.sanqin.com/","www.yndaily.com/","newspaper.jfdaily.com/xwcb/","www.ynet.com/","www.hinews.cn/","www.bjd.com.cn/","www.icpcw.com/","www.familydoctor.com.cn/","e.chengdu.cn/","www.gansudaily.com.cn/","www.koucai.com.cn/","www.eeo.com.cn/","www.fznews.com.cn/","www.rayli.com.cn/","www.baoye.net/","www.southcn.com/","www.gog.cn/gzrb/","hunan.voc.com.cn/","www.qlwb.com.cn/","www.sxrb.com/","www.wccdaily.com.cn/","www.yangtse.com/","www.nfcmag.com/","www.banyuetan.org/","www.titan24.com/","www.cankaoxiaoxi.com/","www.hebnews.cn/","www.qikan.com.cn/","xmzk.xinminweekly.com.cn/","sztqb.sznews.com/","www.ycwb.com/ePaper/ycwb","www.infzm.com/","www.cb.com.cn/","www.dayoo.com/","www.cdns.com.tw/","www.dili360.com/","www.hsm.com.cn/","www.qjwb.com.cn/","www.ycwb.com/","www.nxnet.cn/","www.qikan.com.cn/","ehsb.hsw.cn/","paper.ce.cn/","www.qikan.com.cn/","www.singtao.ca/","whb.news365.com.cn/","www.tianjinwe.com/","zqrb.ccstock.cn/","www.morningpost.com.cn/","www.dbw.cn/","www.cnki.net/","www.baoye.net/","www.cqnews.net/","www.sznews.com/","www.iebook.cn/","bjwb.bjd.com.cn/","www.huanqiu.com/","www.storychina.cn/","www.dahe.cn/","www.cnstock.com/","www.wenweipo.com/","www.qnwz.cn/","www.sino-manager.com/","z.poco.cn/","www.cnhan.com/","www.people.com.cn/","www.stcn.com/","ctdsb.cnhubei.com/","www.cnki.net/","www.caijing.com.cn/","www.fjsen.com/","epaper.dahe.cn/dhb/","www.zubunet.com/","www.hljnews.cn/","www.sxdaily.com.cn/","www.ny1988.com/","www.gmw.cn/","www.zaobao.com/","www.oeeee.com/","www.jingji.com.cn/","www.xinmin.cn/","www.cqvip.com/","www.neweekly.com.cn/","paper.people.com.cn/","www.macaodaily.com/","www.chinadaily.com.cn/","www.xhby.net/","www.trends.com.cn/","www.pcworld.com.cn/","zqb.cyol.com/node/zqbpic.htm","www.jwb.com.cn/","qnck.cyol.com/","www.xj.chinanews.com.cn/","www.ynet.com/","www.cs.com.cn/","www.lifeweek.com.cn/","www.jingji.com.cn/","www.libertytimes.com.tw/","www.jxnews.com.cn/","www.wanfangdata.com.cn/","gzdaily.dayoo.com/","www.inewsweek.cn/","www.hxnews.com/","www.ciw.com.cn/","www.dzwww.com/","www.zhiyin.com.cn/","www.lnd.com.cn/","www.scol.com.cn/","www.zjol.com.cn/","www.ahrb.com.cn/","www.takungpao.com/","www.21jingji.com/","www.nfmedia.com/","www.gxnews.com.cn/","www.bjnews.com.cn/","www.jfdaily.com/","www.zjdaily.com.cn/","www.cyol.net/"};
    String  g7="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public Paper12(){
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

   public String v7(int o2){
       String url;
        String w2="=''+document.domain;";
        String o0="=''+document.location;";
        String f8=""+"http://www.5566.net/paper1-1.htm";
        String r2=""+"www.5566.net";
        String c4="1155.5566";
        String o5="6677.5566";
        int k7=r2.lastIndexOf('.');
        int b4=0+string2Unicode(String.valueOf(w2.charAt(5)));
        int b1=0+string2Unicode(String.valueOf(o0.charAt(6)));
        int w9=0+Integer.parseInt(String.valueOf(o5.charAt(0)));
        int g6=0+Integer.parseInt(String.valueOf(r2.charAt(k7-3)));
        int m2=0+Integer.parseInt(String.valueOf(o5.charAt(2)));
        int w6=0+Integer.parseInt(String.valueOf(r2.charAt(k7-1)));
        String o8="paper1";
        if(f8.indexOf("5566")==-1||f8.indexOf("paper1")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+z9[(o2-g6-w6-m2-b4-b1-84)/w9];
        }
        return  url;
    }
    public String w8(int m5){
        String url;
        String e0="=''+location.host;";
        String j2="9944.5566";
        String c1=""+"www.5566.net";
        String a4=""+"http://www.5566.net/paper1-1.htm";
        String g0="=''+location.href;";
        String h6="7766.5566";
        int f0=c1.lastIndexOf('.');
        int d3=0+string2Unicode(String.valueOf(e0.charAt(5)));
        int i6=0+Integer.parseInt(String.valueOf(c1.charAt(f0-1)));
        int v9=0+Integer.parseInt(String.valueOf(c1.charAt(f0-3)));
        int e8=0+Integer.parseInt(String.valueOf(j2.charAt(1)));
        int h4=0+string2Unicode(String.valueOf(g0.charAt(6)));
        int d5=0+Integer.parseInt(String.valueOf(j2.charAt(3)));
        String x0="paper1";
        if(c1!="5566.net"&&c1!="www.5566.net"&&c1!="5566.org"&&c1!="1.5566.org"&&c1!="2.5566.org"&&c1!="3.5566.org"&&c1!="4.5566.org"&&c1!="5.5566.org"&&c1!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+z9[(m5-i6-e8-d5-d3-h4-93)/v9];
        }
        return  url;
    }
   public String  z7(int c9){
       String url ="";
        String e5="5511.5566";
        String x3="=''+document.URL;";
        String c4="4499.5566";
        String k1=""+"www.5566.net";
        String f4=""+"http://www.5566.net/paper1-1.htm";
        String c3="=''+location.hostname;";
        int q7=k1.lastIndexOf('.');
        int a9=0+Integer.parseInt(String.valueOf(k1.charAt(q7-1)));
        int w3=0+string2Unicode(String.valueOf(x3.charAt(6)));
        int r7=0+Integer.parseInt(String.valueOf(e5.charAt(2)));
        int g5=0+Integer.parseInt(String.valueOf(k1.charAt(q7-3)));
        int f3=0+Integer.parseInt(String.valueOf(e5.charAt(0)));
        int y9=0+string2Unicode(String.valueOf(c3.charAt(5)));
        String i3="paper1";
        if(k1=="5566.net"||k1=="www.5566.net"||k1=="5566.org"||k1=="1.5566.org"||k1=="2.5566.org"||k1=="3.5566.org"||k1=="4.5566.org"||k1=="5.5566.org"||k1=="www.5566.org"){
            url = "http://"+z9[(c9-g5-f3-r7-y9-w3-11)/a9];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("z7")) {
                    tmpUrl = z7(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("w8")) {
                    tmpUrl = w8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("v7")) {

                    tmpUrl = v7(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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


    public  void getPaperUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "新闻媒体";
        String tag2 ="报刊";
//        System.out.println(p.get(94));
        //21,53,87, 94
        int[] numbers = {21,53,87, 94};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }



    }




    public static void main(String[] args) {


        Paper12 paper12 = new Paper12();

            paper12.getPaperUrls("http://www.5566.net/paper1-1.htm");



    }








}
