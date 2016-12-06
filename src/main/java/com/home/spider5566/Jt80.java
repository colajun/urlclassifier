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
 * Created by hadoop on 16-11-27.
 */
public class Jt80 {
    String[] h5={"0","www.ceair.com/","www.jt.sh.cn/","www.chinawestair.com/","www.railcn.net/","www.ahjt.gov.cn/","www.zjt.gov.cn/","www.jntlj.com/","www.bjjtgl.gov.cn/","www.ch.com/","www.zzhcz.com/","www.zgjtb.com/","www.xjjt.gov.cn/","www.bjjtw.gov.cn/","www.tytlj.com/","www.gdcd.gov.cn/","wz.gocar.cn/changtu/","www.joy-air.com/","www.hnjt.gov.cn/","www.o.cn/","www.hainanjt.gov.cn/","map.soso.com/","www.carnoc.com/","www.flycua.com/","www.sdjt.gov.cn/","www.chineseshipping.com.cn/","www.jljt.gov.cn/","www.cqjt.gov.cn/","www.lncom.gov.cn/","www.jxjt.gov.cn/","bus.mapbar.com/","www.snet.com.cn/","www.51ditu.com/","www.chinahighway.gov.cn/","www.shanghai-air.com/","www.jscd.gov.cn/","www.whrailway.cn/","www.go2map.com/","www.bjsubway.com/","auto.sohu.com/s2004/weizhangchaxun.shtml","www.city8.com/","www.tielu.org/","www.mapbar.com/","www.12306.cn/","www.csair.com/","www.nmjt.gov.cn/","www.hljjt.gov.cn/","www.365ditu.com/","bbs.carnoc.com/","www.hbsjtt.gov.cn/","www.chinautc.com/","www.xiamenair.com/","www.gzmtr.com/","www.tianjin-air.com/","www.tjjt.gov.cn/","www.huochepiao.com/Search/","map.sina.com.cn/","www.keyunzhan.com/","www.gxdot.gov.cn/","www.moc.gov.cn/","www.capitalairlines.com.cn/","www.scjt.gov.cn/","www.xzjtt.gov.cn/","www.shenzhenair.com/","www.juneyaoair.com/","www.hncd.gov.cn/","flights.ctrip.com/","www.airchina.com.cn/","map.sogou.com/","www.amap.com/","flights.ctrip.com/international/","www.carnoc.com/","www.sxjt.gov.cn/","www.scal.com.cn/","www.qhjt.gov.cn/","www.hbjt.gov.cn/","www.trip8080.com/","www.shmetro.com/","www.tianditu.cn/","www.hasea.com/","www.edushi.com/","www.gsjt.gov.cn/","www.ynjtt.com/","www.chinahighway.com/","www.8684.cn/","www.huoche.com.cn/","www.52maps.com/googlemaps.asp","www.fjjt.gov.cn/","www.shandongair.com.cn/","www.qjt.gov.cn/","www.tjits.cn/index.asp","www.airasia.com/cn/zh/home.html","ditu.mapabc.com/","www.shjtaq.com/","www.hnair.com/","www.nxcd.gov.cn/","www.sxsjtt.gov.cn/","www.shrail.com/"};
    String k6="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public Jt80(){
        try {
            jdbcTemplate = JDBCHelper.createMysqlTemplate("mysql1", "jdbc:mysql://192.168.21.60/urlclassifier?useUnicode=true&characterEncoding=utf8", "root", "root", 5, 30);

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


    public String  d6(int y1){
        String url="";
        String u5="=''+document.URL;";
        String u2="=''+location.hostname;";
        String b1="5544.5566";
        String x4=""+"http://www.5566.net/jt-.htm";
        String r4=""+"www.5566.net";
        String o2="3399.5566";
        int f1=r4.lastIndexOf('.');
        int z7=0+string2Unicode(String.valueOf(u5.charAt(6)));
        int e7=0+string2Unicode(String.valueOf(u2.charAt(5)));
        int x2=0+Integer.parseInt(String.valueOf(r4.charAt(f1-1)));
        int u1=0+Integer.parseInt(String.valueOf(b1.charAt(1)));
        int n7=0+Integer.parseInt(String.valueOf(r4.charAt(f1-3)));
        int b3=0+Integer.parseInt(String.valueOf(b1.charAt(2)));
        String d3="jt";
        if(x4.indexOf("5566")>=0&&x4.indexOf("jt")>=0){
            url = "http://"+h5[(y1-n7-x2-b3-e7-z7-33)/u1];
        }
        return  url;
    }
    public String  b0(int z3){
        String url = "";
        String p9="=''+location.host;";
        String a8="=''+location.href;";
        String o2="8811.5566";
        String n8=""+"http://www.5566.net/jt-.htm";
        String t4="9933.5566";
        String j5=""+"www.5566.net";
        int n1=j5.lastIndexOf('.');
        int j0=0+string2Unicode(String.valueOf(p9.charAt(5)));
        int i1=0+string2Unicode(String.valueOf(a8.charAt(6)));
        int l0=0+Integer.parseInt(String.valueOf(t4.charAt(3)));
        int n3=0+Integer.parseInt(String.valueOf(t4.charAt(0)));
        int i7=0+Integer.parseInt(String.valueOf(j5.charAt(n1-1)));
        int n0=0+Integer.parseInt(String.valueOf(j5.charAt(n1-3)));
        String x5="jt";
        if(j5!="5566.net"&&j5!="www.5566.net"&&j5!="5566.org"&&j5!="1.5566.org"&&j5!="2.5566.org"&&j5!="3.5566.org"&&j5!="4.5566.org"&&j5!="5.5566.org"&&j5!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+h5[(z3-n0-n3-l0-j0-i1-87)/i7];
        }
        return  url;

    }
    public String  l3(int j1){
        String url;
        String x8=""+"www.5566.net";
        String l2="=''+document.location;";
        String b8="=''+document.domain;";
        String b7="4455.5566";
        String p1=""+"http://www.5566.net/jt-.htm";
        String m1="1188.5566";
        int c9=x8.lastIndexOf('.');
        int d5=0+Integer.parseInt(String.valueOf(x8.charAt(c9-3)));
        int y3=0+string2Unicode(String.valueOf(l2.charAt(6)));
        int p3=0+string2Unicode(String.valueOf(b8.charAt(5)));
        int o7=0+Integer.parseInt(String.valueOf(m1.charAt(2)));
        int w4=0+Integer.parseInt(String.valueOf(m1.charAt(1)));
        int a2=0+Integer.parseInt(String.valueOf(x8.charAt(c9-1)));
        String r2="jt";
        if(p1.indexOf("5566")==-1||p1.indexOf("jt")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+h5[(j1-a2-w4-o7-p3-y3-17)/d5];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("d6")) {
                    tmpUrl = d6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("b0")) {
                    tmpUrl = b0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("l3")) {

                    tmpUrl = l3(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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


    public  void  getUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "生活";
        String tag2 = "交通地图";
//        System.out.println(p.get(58));
        //24,36,46,58
        int[] numbers = {24,36,46,58};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }



    }

    public static void main(String[] args) {
        Jt80 jt80 = new Jt80();
        jt80.getUrls("http://www.5566.net/jt-.htm");



    }





}
