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
public class Kd69 {

    String[] z8={"0","www.rufengda.com/","www.jd-ex.com/","www.sf-express.com/","www.tnt.com.cn/","www.qfkd.com.cn/","www.airfex.net/","www.shenghui56.com/","www.kjkd.com/","www.ems.com.cn/","www.sto.cn/","www.cnpl.com.cn/","www.zjs.com.cn/","www.nd56.com/","www.yundaex.com/","www.jiayi56.com/","www.sure56.com/","www.gto365.com/","www.lbex.net/","www.deppon.com/","www.hoau.net/","www.95572.com/","express.4px.com/","www.xbwl.cn/","www.fedex.com/cn/","www.at-express.com/","www.lhtex.com.cn/","wuliu.suning.com/","www.cn.dhl.com/","www.apex100.com/","www.ttkdex.com/","www.zto.com/","www.ups.com/cn","www.800bestex.com/","www.uce.cn/","www.yto.net.cn/","www.jiaji.com/"};
    String o9="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;
    public Kd69(){
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





   public String  z0(int q6){
       String url;
        String i4="2277.5566";
        String q2=""+"http://www.5566.net/kd.htm";
        String q9="=''+location.hostname;";
        String a0="3355.5566";
        String k6=""+"www.5566.net";
        String t3="=''+location.href;";
        int m4=k6.lastIndexOf('.');
        int s6=0+Integer.parseInt(String.valueOf(k6.charAt(m4-1)));
        int z2=0+Integer.parseInt(String.valueOf(i4.charAt(1)));
        int a3=0+string2Unicode(String.valueOf(q9.charAt(5)));
        int l7=0+Integer.parseInt(String.valueOf(i4.charAt(3)));
        int f3=0+Integer.parseInt(String.valueOf(k6.charAt(m4-3)));
        int s9=0+string2Unicode(String.valueOf(t3.charAt(6)));
        String s0="kd";
        if(k6!="5566.net"&&k6!="www.5566.net"&&k6!="5566.org"&&k6!="1.5566.org"&&k6!="2.5566.org"&&k6!="3.5566.org"&&k6!="4.5566.org"&&k6!="5.5566.org"&&k6!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+z8[(q6-s6-z2-l7-a3-s9-97)/f3];
        }
        return  url;
    }
   public String s7(int b0){
       String url ="";
       String  b9="7722.5566";
        String w2=""+"http://www.5566.net/kd.htm";
        String m8=""+"www.5566.net";
        String l8="=''+location.host;";
        String w3="8866.5566";
        String f4="=''+document.location;";
        int n4=m8.lastIndexOf('.');
       int r8=0+Integer.parseInt(String.valueOf(w3.charAt(2)));
        int z4=0+Integer.parseInt(String.valueOf(w3.charAt(0)));
        int o3=0+Integer.parseInt(String.valueOf(m8.charAt(n4-3)));
        int b7=0+string2Unicode(String.valueOf(l8.charAt(5)));
        int y5=0+Integer.parseInt(String.valueOf(m8.charAt(n4-1)));
        int e9=0+string2Unicode(String.valueOf(f4.charAt(6)));
        String x9="kd";
        if(m8=="5566.net"||m8=="www.5566.net"||m8=="5566.org"||m8=="1.5566.org"||m8=="2.5566.org"||m8=="3.5566.org"||m8=="4.5566.org"||m8=="5.5566.org"||m8=="www.5566.org"){
            url = "http://"+z8[(b0-o3-z4-r8-b7-e9-21)/y5];
        }
        return  url;
    }
    public String  u6(int h6){
        String url ="";
        String b9="6688.5566";
        String k2="5533.5566";
        String c7=""+"www.5566.net";
        String u0="=''+document.domain;";
        String y9="=''+document.URL;";
        String j2=""+"http://www.5566.net/kd.htm";
        int s2=c7.lastIndexOf('.');
        int o6=0+Integer.parseInt(String.valueOf(k2.charAt(2)));
        int d0=0+Integer.parseInt(String.valueOf(c7.charAt(s2-1)));
        int h0=0+Integer.parseInt(String.valueOf(c7.charAt(s2-3)));
        int l3=0+string2Unicode( String.valueOf(u0.charAt(5)));
        int z1=0+string2Unicode(String.valueOf(y9.charAt(6)));
        int m2=0+Integer.parseInt(String.valueOf(k2.charAt(1)));
        String o1="kd";
        if(j2.indexOf("5566")==-1||j2.indexOf("kd")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+z8[(h6-h0-d0-o6-l3-z1-96)/m2];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("z0")) {
                    tmpUrl = z0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("s7")) {
                    tmpUrl = s7(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("u6")) {

                    tmpUrl = u6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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

    public  void  getUrls(String  url){


        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "生活";
        String tag2 = "快递公司";
//        System.out.println(p.get(16));
//        //20,37
        int[] numbers = {16};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }




    }

    public static void main(String[] args) {
        Kd69 kd69 = new Kd69();
        kd69.getUrls("http://www.5566.net/kd.htm");




    }




}
