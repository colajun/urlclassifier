package com.home.spider5566;

import com.home.spring.JDBCHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import spire.math.SafeLongIsRing;

import java.io.IOException;

/**
 * Created by hadoop on 16-11-22.
 */
public class Stock21 {

    String[] r2={"0","www.gjzq.com.cn/","www.hongtastock.com/","www.tpyzq.com/","stock.sohu.com/blog/","www.stockstar.com/","www.tfzq.com/","www.gfhfzq.com.cn/","www.e5618.com/","www.westsecu.com/","guba.eastmoney.com/","www.gf.com.cn","finance.sina.com.cn/money/globalindex/","finance.sina.com.cn/stock/","www.glsc.com.cn/","blog.sina.com.cn/jsmedia","www.cnlist.com/","epaper.stcn.com/","www.jyzq.cn/","paper.cnstock.com/","www.962518.com/","www.wanhesec.com/whzq/","www.cnht.com.cn/","www.ytzq.com/","www.china-invs.cn/","www.xzsec.com/","www.wkzq.com.cn/","www.csco.com.cn/","www.s10000.com/","www.hkex.com.hk/index_c.htm","www.538538.com/","stock.jrj.com.cn/ipo/","www.essence.com.cn/","www.tyzq.com.cn/","fund.eastmoney.com/fundguzhi.html","www.zdzq.com.cn/","www.cfzq.com/","www.wlzq.cn/","blog.sina.com.cn/yehong","www.foundersc.com/","www.grzq.com/","www.ebscn.com/","www.hx168.com.cn/","www.95579.com/","www.hczq.com/","blog.sina.com.cn/lm/finance/index.html","www.sac.net.cn/xxgs/zqgs/","www.cczq.com/","www.ydsc.com.cn/","www.qlzq.com.cn/","stock.cnfol.com/","www.stockren.com/","www.csindex.com.cn/","www.ghsl.cn/","www.zczq.com/","www.p5w.net/stock/","www.lxzq.com.cn/","www.hexun.com/","www.xcsc.com/","www.cfsc.com.cn/","www.huayingsc.com/","www.i618.com.cn","www.sse.com.cn/","stock.sohu.com/","blog.jrj.com.cn/","fund.eastmoney.com/","www.capitalweek.com.cn/","www.huajinsc.cn/","quote.eastmoney.com/sh510050.html","stock.hexun.com/","bbs.jrj.com.cn/","www.newone.com.cn/","blog.sina.com.cn/fengqiderizi","www.55188.com/forum-8-1.html","www.ajzq.com/","www.cicc.com.cn/","bbs.laoqianzhuang.com/","epaper.cs.com.cn/","www.cs.com.cn/","www.hx818.com/","www.ctsec.com/","www.chinalions.com/","fund.eastmoney.com/bzdm.html","www.sw2000.com.cn/","shihb.blog.sohu.com/","www.dxzq.net/","www.jrj.com.cn/","www.bocichina.com/","bbs.hexun.com/stock/board_5_all_1_d.html","www.cnfund.cn/","bbs.macd.cn/","www.hazq.com/","www.hrsec.com.cn/","www.mszq.com/","stock.pingan.com/","blog.eastmoney.com/","blog.sina.com.cn/xuxiaoming8","www.cs.ecitic.com/","www.cnpsec.com.cn/","www.shhxzq.com/","bbs.eastmoney.com/","www.cnhbstock.com/","www.zxwt.com.cn/","wangguoqiang.blog.cnstock.com/","quote.eastmoney.com/zs399001.html","money.163.com/stock/","www.cnstock.com/","www.hongzhoukan.com/","www.scstock.com/","www.cindasc.com/","www.csc108.com/","www.cgws.com/","www.shenguang.com","stock.qq.com/","quote.eastmoney.com/sz159915.html","zqrb.ccstock.cn/","www.eastmoney.com/","www.wlstock.com/","www.dwjq.com.cn/","www.fcsc.cn/","quote.eastmoney.com/flash/zs000001.html","www.xsdzq.cn/","www.jhzq.com.cn/","www.ghzq.com.cn/","www.chinastock.com.cn/","www.gsstock.com/","www.ubs.com/cn/sc/ubs-securities.html","stock.cfi.cn/","www.guosen.com.cn/","stock.eastmoney.com/","www.xyzq.com.cn/","www.kysec.cn/","www.xmzq.cn/","www.sac.net.cn/","www.58188.com/stock.htm","www.dtsbc.com.cn/","quote.eastmoney.com/center/list.html#2850020_8","www.ewww.com.cn/","www.ccstock.cn/","www.yicai.com/","www.htsec.com/","www.szse.cn/","f.blog.hexun.com/","www.zszq.com/","quote.eastmoney.com/sz159902.html","www.htsc.com.cn/","blog.cnfol.com/","www.gkzq.com.cn/","blog.cnstock.com/","www.gzs.com.cn/","quote.stockstar.com/stock/","zqdb.hinews.cn/","www.gyzq.com.cn/","www.estock.com.cn/","www.sge.sh/","www.csrc.gov.cn/","www.swsc.com.cn/","www.ccnew.com/","quote.eastmoney.com/zs399006.html","www.dfzq.com.cn/","www.hlzqgs.com/","www.nesc.cn/","www.longone.com.cn/","www.djtz.net/","www.guodu.com/","finance.ifeng.com/stock/","www.cninfo.com.cn/","www.infomorning.com/","finance.sina.com.cn/stock/usstock/","www.tebon.com.cn/","www.chinaclear.cn/","www.stcn.com/","www.njzq.com.cn/","stock.eastmoney.com/xgss/newstock.html","www.sczq.com.cn/","www.dgzq.com.cn/","stock.eastmoney.com/bidu.html","www.wxzq.com/","www.stocke.com.cn/","hk.eastmoney.com/","www.gtja.com/","www.10jqka.com.cn/"};
    String h2="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;
    public Stock21(){
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

    public String  s9(int s8){
        String url;
        String k6="=''+document.location;";
        String i1="=''+document.domain;";
        String k2=""+"www.5566.net";
        String s1=""+"http://www.5566.net/stock1a.htm";
        String m4="1199.5566";
        String d2="5566.5566";
        int h7=k2.lastIndexOf('.');
        int s3=0+string2Unicode(String.valueOf(k6.charAt(6)));
        int n7=0+string2Unicode(String.valueOf(i1.charAt(5)));
        int q5=0+Integer.parseInt(String.valueOf(k2.charAt(h7-3)));
        int x9=0+Integer.parseInt(String.valueOf(m4.charAt(1)));
        int l6=0+Integer.parseInt(String.valueOf(k2.charAt(h7-1)));
        int y8=0+Integer.parseInt(String.valueOf(m4.charAt(3)));
        String q4="stock1a";
        if(s1.indexOf("5566")==-1||s1.indexOf("stock1a")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+r2[(s8-q5-l6-y8-n7-s3-20)/x9];
        }
        return  url;
    }
    public String  b7(int r6){
        String url="";
        String c8="6655.5566";
        String e3="=''+location.hostname;";
        String e2=""+"http://www.5566.net/stock1a.htm";
        String v6="=''+document.URL;";
        String r1=""+"www.5566.net";
        String d2="7788.5566";
        int d7=r1.lastIndexOf('.');
        int f3=0+Integer.parseInt(String.valueOf(r1.charAt(d7-1)));
        int q9=0+string2Unicode(String.valueOf(e3.charAt(5)));
        int s4=0+Integer.parseInt(String.valueOf(c8.charAt(0)));
        int q6=0+string2Unicode(String.valueOf(v6.charAt(6)));
        int h0=0+Integer.parseInt(String.valueOf(r1.charAt(d7-3)));
        int j5=0+Integer.parseInt(String.valueOf(c8.charAt(3)));
        String t8="stock1a";
        if(e2.indexOf("5566")>=0&&e2.indexOf("stock1a")>=0){
           url = "http://"+r2[(r6-h0-s4-j5-q9-q6-7)/f3];
        }
        return  url;
    }
    public String  t1(int c7){
        String url ="";
        String f4="9911.5566";
        String w1="=''+location.host;";
        String s2="8877.5566";
        String d3=""+"www.5566.net";
        String n3="=''+location.href;";
        String l0=""+"http://www.5566.net/stock1a.htm";
        int h4=d3.lastIndexOf('.');
        int l1=0+Integer.parseInt(String.valueOf(s2.charAt(3)));
        int g6=0+string2Unicode(String.valueOf(w1.charAt(5)));
        int j3=0+Integer.parseInt(String.valueOf(d3.charAt(h4-1)));
        int n1=0+Integer.parseInt(String.valueOf(d3.charAt(h4-3)));
        int d9=0+string2Unicode(String.valueOf(n3.charAt(6)));
        int c3=0+Integer.parseInt(String.valueOf(s2.charAt(1)));
        String b3="stock1a";
        if(d3=="5566.net"||d3=="www.5566.net"||d3=="5566.org"||d3=="1.5566.org"||d3=="2.5566.org"||d3=="3.5566.org"||d3=="4.5566.org"||d3=="5.5566.org"||d3=="www.5566.org"){
           url = "http://"+r2[(c7-j3-c3-l1-g6-d9-27)/n1];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("s9")) {
                    tmpUrl = s9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("b7")) {
                    tmpUrl = b7(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("t1")) {

                    tmpUrl = t1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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




    public  void getStockUrls(String url){


        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "财经";
        String tag2 ="证券";
//        System.out.println(p.get(124));
        //17,32,42,51,63,79,98,114,124
        int[] numbers = {17,32,42,51,63,79,98,114,124};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }






    }

    public static void main(String[] args) {

        Stock21 stock21 = new Stock21();
        stock21.getStockUrls("http://www.5566.net/stock1a.htm");



    }







}
