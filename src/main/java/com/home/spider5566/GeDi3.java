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
 * Created by hadoop on 16-11-15.
 */
public class GeDi3 {
    JdbcTemplate jdbcTemplate = null;
    String[] c6={"0","www.cqnews.net/","www.taihainet.com/","www.dahe.cn/","www.yninfo.com/","www.269.net/","www.eastday.com/","www.hainan.net/","www.ycwb.com/","www.ccoo.cn/","www.bdchina.com/","www.hinews.cn/","www.dayoo.com/","www.qzwb.com/","www.sxrb.com/","www.gz163.cn/","hunan.voc.com.cn/","www.scol.com.cn/","www.cqzaixian.com/","www.cnool.net/","www.jschina.com.cn/","www.bjd.com.cn/","www.qianlong.com/","www.wuhan.net.cn/","www.dzwww.com/","www.nen.com.cn/","www.changsha.cn/","www.jxnews.com.cn/","www.tfol.com/","www.enorth.com.cn/","www.online.sh.cn/","www.newssc.org/","www.northtimes.com/","www.lywww.com/","www.cnbb.com.cn/","www.gznet.com/","www.zj.com/","www.szonline.net/","www.xmnn.cn/","www.sdinfo.net/","www.longhoo.net/","www.fjii.com/","www.westcn.com/","www.gxsky.com/","www.vnet.cn/","www.qingdaonews.com/","www.zjol.com.cn/","www.chinajilin.com.cn/","www.yunnan.cn/","www.fjsen.com/","www.dbw.cn/","www.2500sz.com/","www.sznews.com/","www.gxnews.com.cn/","www.ynet.com/","www.tibet.cn/","www.oeeee.com/","www.xj163.cn/","www.nmgnews.com.cn/","www.nx.cninfo.net/","www.21cn.com/","www.hsw.cn/","www.cnhubei.com/","www.shangdu.com/","www.bbn.com.cn/","www.online.tj.cn/","www.rednet.cn/","www.jlonline.com/","www.jsinfo.net/","www.66163.com/","www.hebnews.cn/","www.southcn.com/","www.anhuinews.com/","www.shenchuang.com/","www.yinsha.com/","www.inhe.net/","www.86516.com/"};
    String r2="http://www.5566.org/indexe.htm";
    public GeDi3(){
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

    public  int  string2Unicode(String string) {

        StringBuffer unicode = new StringBuffer();

        for (int i = 0; i < string.length(); i++) {

            // 取出每一个字符
            char c = string.charAt(i);

            // 转换为unicode
            unicode.append(Integer.toUnsignedLong(c));
        }

        return Integer.parseInt(unicode.toString()) ;
    }


    public String j6(int i5){
        String url ;
        String d4="7788.5566";
        String z4="=''+document.location;";
        String a6="1166.5566";
        String s7=""+"www.5566.net";
        String j3="=''+document.domain;";
        String r5=""+"http://www.5566.net/169.htm";
        int x4=s7.lastIndexOf('.');
        int y6=0+Integer.parseInt(String.valueOf(s7.charAt(x4-1)));
        int y7=0+string2Unicode(String.valueOf(z4.charAt(6)));
        int o8=0+Integer.parseInt(String.valueOf(d4.charAt(3)));
        int l8=0+Integer.parseInt(String.valueOf(s7.charAt(x4-3)));
        int f3=0+string2Unicode(String.valueOf(j3.charAt(5)));
        int y9=0+Integer.parseInt(String.valueOf(d4.charAt(1)));
        String j2="169";
        if(r5.indexOf("5566")==-1||r5.indexOf("169")==-1){
            url="http://www.5566.org/indexe.htm";
        }
        else{
           url ="http://"+c6[(i5-l8-y6-o8-f3-y7-9)/y9];
        }
        return  url;
    }
    public String k2(int c0){
        String url="";
        String d5=""+"http://www.5566.net/169.htm";
        String h3=""+"www.5566.net";
        String k0="8877.5566";
        String s5="=''+document.URL;";
        String a3="5533.5566";
        String b3="=''+location.hostname;";
        int l7=h3.lastIndexOf('.');
        int c8=0+Integer.parseInt(String.valueOf(a3.charAt(0)));
        int f9=0+Integer.parseInt(String.valueOf(h3.charAt(l7-3)));
        int r1=0+Integer.parseInt(String.valueOf(a3.charAt(2)));
        int o4=0+string2Unicode(String.valueOf(s5.charAt(6)));
        int z9=0+Integer.parseInt(String.valueOf(h3.charAt(l7-1)));
        int a5=0+string2Unicode(String.valueOf(b3.charAt(5)));
        String g0="169";
        if(d5.indexOf("5566")>=0&&d5.indexOf("169")>=0){
           url = "http://"+c6[(c0-z9-c8-r1-a5-o4-9)/f9];
        }
        return  url;
    }
    public String j5(int x6){
        String url;
        String w6="=''+location.href;";
        String v2=""+"www.5566.net";
        String a6="3355.5566";
        String g7="=''+location.host;";
        String r9="6611.5566";
        String j0=""+"http://www.5566.net/169.htm";
        int l2=v2.lastIndexOf('.');
        int h4=0+string2Unicode(String.valueOf(w6.charAt(6)));
        int t6=0+Integer.parseInt(String.valueOf(v2.charAt(l2-3)));
        int c4=0+Integer.parseInt(String.valueOf(r9.charAt(3)));
        int w8=0+string2Unicode(String.valueOf(g7.charAt(5)));
        int n9=0+Integer.parseInt(String.valueOf(v2.charAt(l2-1)));
        int i7=0+Integer.parseInt(String.valueOf(r9.charAt(0)));
        String d7="169";
        if(v2!="5566.net"&&v2!="www.5566.net"&&v2!="5566.org"&&v2!="1.5566.org"&&v2!="2.5566.org"&&v2!="3.5566.org"&&v2!="4.5566.org"&&v2!="5.5566.org"&&v2!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+c6[(x6-t6-i7-c4-w8-h4-5)/n9];
        }
        return  url;
    }


    public  void getGeDi(String url){
        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "祖国各地";
        String tag2 ="";
        String tmpUrl="";
        String tmpName="";
        String onclick = "";
        Elements urls = p.get(20).getElementsByTag("a");
        for(Element href: urls) {
            onclick = href.attr("onclick");
            tmpName = href.text();
            if (onclick.substring(0, 2).equalsIgnoreCase("j5")) {
                tmpUrl = j5(Integer.parseInt(String.valueOf(onclick.substring(3, 6))));
            }
            if (onclick.substring(0, 2).equalsIgnoreCase("j6")) {
                tmpUrl = j6(Integer.parseInt(String.valueOf(onclick.substring(3, 6))));
            }
            if (onclick.substring(0, 2).equals("k2")) {

                tmpUrl = k2(Integer.parseInt(String.valueOf(onclick.substring(3, 6))));

            }
            inserTable(tag1, tag2, tmpUrl, tmpName);



        }



    }



    public static void main(String[] args) {


        GeDi3 geDi3 = new GeDi3();

        geDi3.getGeDi("http://www.5566.net/169.htm");


    }







}
