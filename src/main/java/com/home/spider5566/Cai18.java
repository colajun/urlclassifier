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
public class Cai18 {

    String[] i2={"0","www.jlfc.com.cn/","bbs.zgzcw.com/","www.50018.com/","sports.sohu.com/caipiao.shtml","www.lottery.gov.cn/lottery/sfc/Default.aspx","www.jslottery.com/","www.gzfucai.cn/","www.gdfc.org.cn/","www.ynticai.cn/","www.lottery.gx.cn/","www.hbtcw.com/","www.zhcw.com/","www.cqlottery.gov.cn/","www.nmtc.com.cn/","www.tjflcpw.com/","www.cpdyj.com/","www.sporttery.cn/","www.hnlottery.com.cn/","www.lottery.gov.cn/","www.nmlottery.com.cn/","www.okooo.com/","www.gdlottery.cn/","www.ahfc.gov.cn/","www.bwlc.net/","www.tianjinlottery.com/","www.dyjw.com/","www.zgzcw.com/","www.swlc.gov.cn/","www.zucai310.com/","fc.zjol.com.cn/","www.wztc.cn/","www.hainancp.com/","sports.sohu.com/zuqiucaipiao.shtml","lottery.sina.com.cn/","www.caiyou.cn","www.go01.com/","www.jxlottery.cn/","www.js-lottery.com/","hbfc.cnhubei.com/","lottery.titan24.com/","www.sdticai.com/","www.henanfucai.com/","caipiao.taobao.com/","jl.lottery.gov.cn/","www.lntycp.com/","www.bjlot.com/","www.jxfczx.cn/","www.gsflcp.com/","www.hbtycp.com/","www.xinancaipiao.com/","www.gxcaipiao.com.cn/","www.gztcw.com.cn/","www.qhfc.gov.cn/","www.sxtc.com.cn/","www.nbtc.com.cn/","www.fjcp.cn/","www.zzc.cn/","www.hljtcp.com/","www.xjflcp.com/","www.fjtc.com.cn/","www.sxlottery.net/","sports.sohu.com/zuqiucaipiao.shtml","88.hinews.cn/","www.zgzcw.com/","www.tc.hainan.net/","www.shlottery.gov.cn/","www.zjlottery.com/","www.gstc.org.cn/","www.swlc.sh.cn/","www.8791.com/","www.sxfc.gov.cn/","www.lottost.cn/","www.sdcp.cn/","lottery.sina.com.cn/","www.xjlottery.gov.cn/","www.sjfc.org.cn/","www.scflcp.com/","www.nxflcp.com/","www.1soccer.com/","www.hzlottery.com/","www.lnlotto.com/","www.ahtc.gov.cn/","sports.sohu.com/cp/","www.hnflcp.com/","www.qhtycp.com/","www.sclottery.gov.cn/","www.yzfcw.com/","www.nxtcw.com.cn/","www.hnticai.com/","www.cqcp.net/"};
    String j8="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public Cai18(){
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


    public String  t0(int o4){
        String url ="";
        String m1="=''+document.URL;";
        String i9=""+"http://www.5566.net/cp1-.htm";
        String w9="4433.5566";
        String c4=""+"www.5566.net";
        String j9="9988.5566";
        String x2="=''+location.host;";
        int x5=c4.lastIndexOf('.');
        int l9=0+string2Unicode(String.valueOf(m1.charAt(6)));
        int f5=0+Integer.parseInt(String.valueOf(w9.charAt(1)));
        int w6=0+Integer.parseInt(String.valueOf(c4.charAt(x5-1)));
        int o6=0+Integer.parseInt(String.valueOf(c4.charAt(x5-3)));
        int a9=0+Integer.parseInt(String.valueOf(w9.charAt(3)));
        int g4=0+string2Unicode(String.valueOf(x2.charAt(5)));
        String a4="cp1";
        if(i9.indexOf("5566")>=0&&i9.indexOf("cp1")>=0){
           url = "http://"+i2[(o4-o6-w6-a9-g4-l9-98)/f5];
        }
        return  url ;
    }
   public  String q2(int t8){
       String url = "";
        String r4="8899.5566";
        String e6="=''+location.hostname;";
        String j9="7722.5566";
        String b3="=''+document.location;";
        String b9=""+"http://www.5566.net/cp1-.htm";
        String s8=""+"www.5566.net";
        int n1=s8.lastIndexOf('.');
        int m8=0+Integer.parseInt(String.valueOf(s8.charAt(n1-1)));
        int e1=0+string2Unicode(String.valueOf(e6.charAt(5)));
        int g0=0+Integer.parseInt(String.valueOf(r4.charAt(3)));
        int h5=0+string2Unicode(String.valueOf(b3.charAt(6)));
        int a6=0+Integer.parseInt(String.valueOf(r4.charAt(0)));
        int v2=0+Integer.parseInt(String.valueOf(s8.charAt(n1-3)));
        String q3="cp1";
        if(s8=="5566.net"||s8=="www.5566.net"||s8=="5566.org"||s8=="1.5566.org"||s8=="2.5566.org"||s8=="3.5566.org"||s8=="4.5566.org"||s8=="5.5566.org"||s8=="www.5566.org"){
            url = "http://"+i2[(t8-v2-a6-g0-e1-h5-95)/m8];
        }
        return  url;
    }
  public String  v1(int t9){
      String url;
        String i0="3344.5566";
        String g6="2277.5566";
        String s2="=''+location.href;";
        String h3="=''+document.domain;";
        String v9=""+"http://www.5566.net/cp1-.htm";
        String y5=""+"www.5566.net";
        int d7=y5.lastIndexOf('.');
        int b8=0+Integer.parseInt(String.valueOf(g6.charAt(2)));
        int q5=0+Integer.parseInt(String.valueOf(y5.charAt(d7-1)));
        int j3=0+string2Unicode( String.valueOf(s2.charAt(6)));
        int b5=0+string2Unicode(String.valueOf(h3.charAt(5)));
        int j4=0+Integer.parseInt(String.valueOf(g6.charAt(1)));
        int h8=0+Integer.parseInt(String.valueOf(y5.charAt(d7-3)));
        String d2="cp1";
        if(y5!="5566.net"&&y5!="www.5566.net"&&y5!="5566.org"&&y5!="1.5566.org"&&y5!="2.5566.org"&&y5!="3.5566.org"&&y5!="4.5566.org"&&y5!="5.5566.org"&&y5!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+i2[(t9-q5-j4-b8-b5-j3-73)/h8];
        }
        return  url ;
    }

    public  void getUrlAndText(Elements urls, String tag1, String tag2) {

        String tmpUrl = "";
        String tmpName = "";
        String onclick = "";

        for (Element href : urls) {
            try {
                onclick = href.attr("onclick");
                tmpName = href.text();
                if (onclick.substring(0, 2).equalsIgnoreCase("t0")) {
                    tmpUrl = t0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("q2")) {
                    tmpUrl = q2(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("v1")) {

                    tmpUrl = v1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
        String tag2 ="彩票";
//        System.out.println(p.get(71));
        //20,32, 71
        int[] numbers = {20,32, 71};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }






    }

    public static void main(String[] args) {

        Cai18 cai18 = new Cai18() ;

        cai18.getCaiUrls("http://www.5566.net/cp1-.htm");


    }




}
