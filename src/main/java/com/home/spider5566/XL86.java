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
 * Created by hadoop on 16-11-28.
 */
public class XL86 {
    String[] q1={"0","www.orthochina.com/","www.maydeal.com.cn/","www.cams.ac.cn/","www.cmda.net/","www.bmi.ac.cn/","www.kq36.cn/","www.med126.com/","www.yxxgx.com/","www.zhong-yao.net/","www.cma-cmc.com.cn/","www.aids.org.cn/","www.cmt.com.cn/","www.cogonline.com/","www.99aids.com/","www.shsma.org.cn/","www.carm.org.cn/","book.chaoxing.com/","www.labweb.cn/","www.labmed.cn/","www.zhongyiyao.net/","www.meddir.cn/","new.chain.net.cn/","www.dxy.cn/","www.chinaradiology.org/","www.iiyi.com/","www.oculist.net/","www.eye999.com/","www.cnophol.com/","www.cndent.com/","www.med66.com/","www.csnm.com.cn/","www.xietong.com/","www.daifumd.com","www.ncstdc.org/","www.cndent.com/","www.9med.net/","www.chinaonco.net/","www.cma.org.cn/","www.eyenet.com.cn/","www.cqvip.com/","www.365heart.com/","www.yixuezp.com/","www.cmechina.net/","www.miaopu520.cn/","www.ksbao.com/","www.clinet.com.cn/","www.cma.org.cn/","bbs.hx317.com/","www.wanfangdata.com.cn/","www.365guke.com/","www.library.imicams.ac.cn/","www.999pifu.com/","www.nmec.org.cn/","www.icu.cn/","www.fyxh.org/","www.shouer.com.cn/","www.fx120.net/","www.zhzyw.org/","www.gxmi.net/","www.fmed.net/","www.medkaoyan.net/","www.wmp169.com/","www.zgmryx.com/","www.csn.org.cn/","www.cpma.org.cn/","www.dlmed.com/","www.china-obgyn.net/","www.transplantation.org.cn/","www.cmao.org.cn/","www.fjma.org.cn/","www.kq88.com/","www.haoyisheng.com","www.cn939.com/","www.cnhuxi.com/","www.cnki.net/","www.pmed.cn/"};
    String t9="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;
    public XL86(){
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

   public String  f8(int m8){
       String url ="";
        String c5="7755.5566";
        String z1=""+"www.5566.net";
        String g1=""+"http://www.5566.net/yx.htm";
        String i8="=''+document.URL;";
        String b8="9922.5566";
        String h1="=''+document.domain;";
        int q7=z1.lastIndexOf('.');
        int z2=0+Integer.parseInt(String.valueOf(b8.charAt(3)));
        int x0=0+Integer.parseInt(String.valueOf(z1.charAt(q7-3)));
        int z9=0+Integer.parseInt(String.valueOf(b8.charAt(0)));
        int w0=0+string2Unicode(String.valueOf(i8.charAt(6)));
        int t7=0+Integer.parseInt(String.valueOf(z1.charAt(q7-1)));
        int o8=0+string2Unicode(String.valueOf(h1.charAt(5)));
        String u0="yx";
        if(g1.indexOf("5566")>=0&&g1.indexOf("yx")>=0){
           url = "http://"+q1[(m8-x0-t7-z2-o8-w0-69)/z9];
        }

        return  url;
    }
    public  String w2(int i1){
        String url;
        String n1=""+"http://www.5566.net/yx.htm";
        String s3="=''+location.href;";
        String x6=""+"www.5566.net";
        String j4="=''+location.host;";
        String o0="1133.5566";
        String d3="2299.5566";
        int x4=x6.lastIndexOf('.');
        int s6=0+Integer.parseInt(String.valueOf(o0.charAt(0)));
        int y6=0+string2Unicode(String.valueOf(s3.charAt(6)));
        int r8=0+Integer.parseInt(String.valueOf(x6.charAt(x4-3)));
        int y1=0+string2Unicode(String.valueOf(j4.charAt(5)));
        int z7=0+Integer.parseInt(String.valueOf(x6.charAt(x4-1)));
        int i3=0+Integer.parseInt(String.valueOf(o0.charAt(3)));
        String g0="yx";
        if(x6!="5566.net"&&x6!="www.5566.net"&&x6!="5566.org"&&x6!="1.5566.org"&&x6!="2.5566.org"&&x6!="3.5566.org"&&x6!="4.5566.org"&&x6!="5.5566.org"&&x6!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }else{
            url ="http://"+q1[(i1-z7-s6-i3-y1-y6-67)/r8];
        }
        return  url;
    }
    public String  h9(int g2){
        String url;
        String c3=""+"www.55566.net";
        String y4=""+"http://www.5566.net/yx.htm";
        String p2="5577.5566";
        String w7="=''+document.location;";
        String x7="=''+location.hostname;";
        String c5="3311.5566";
        int y7=c3.lastIndexOf('.');
        int k2=0+Integer.parseInt(String.valueOf(c3.charAt(y7-3)));
        int u5=0+Integer.parseInt(String.valueOf(p2.charAt(0)));
        int a2=0+Integer.parseInt(String.valueOf(c3.charAt(y7-1)));
        int k0=0+string2Unicode(String.valueOf(w7.charAt(6)));
        int d0=0+string2Unicode(String.valueOf(x7.charAt(5)));
        int n4=0+Integer.parseInt(String.valueOf(p2.charAt(3)));
        String e0="yx";
        if(y4.indexOf("5566")==-1||y4.indexOf("yx")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+q1[(g2-k2-u5-n4-d0-k0-34)/a2];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("f8")) {
                    tmpUrl = f8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("h9")) {
                    tmpUrl = h9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("w2")) {

                    tmpUrl = w2(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
        String tag1 = "健康医疗";
        String tag2 = "医学";
//        System.out.println(p.get(16));
        //
        int[] numbers = {16};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }



    }



    public static void main(String[] args) {

        XL86 xl86 = new XL86();
        xl86.getUrls("http://www.5566.net/yx.htm");


    }



}
