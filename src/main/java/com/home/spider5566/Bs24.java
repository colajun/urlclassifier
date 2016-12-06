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
public class Bs24 {
    String[] s1={"0","www.circ.gov.cn/tabid/5254/Default.aspx","www.picchealth.com/","finance.sina.com.cn/money/insurance/index.html","www.bxlcw.com/","www.hexiehealth.com/","caixian.cntaiping.com/","www.chinalife.com.cn/","www.minanins.com/","www.cpic.com.cn/health/","www.cntaiping.com/","www.generali-china.cn/","life.ehuatai.com/","insurance.hexun.com/","www.sinosafe.com.cn/","www.icbc-axa.com/","www.axatp.com/","www.picc.com.cn/","www.cpic.com.cn/","www.epicc.com.cn/","www.e-chinalife.com/","insurance.eastmoney.com/","chexian.sinosig.com/","www.ccic-net.com.cn/","www.xintai.com/","www.manulife-sinochem.com/","www.boc.cn/bocins/","www.95549.cn/","www.cic.cn/","www.pingan.com/","www.hk.cntaiping.com/chi/","www.pkufi.com/","www.tianan-life.com/","www.allianz.com.cn/","www.aia.com.cn/","www.minshenglife.com/","www.dbic.com.cn/","www.circ.gov.cn","www.cpic.com.cn/rsbx/","life.sinosig.com/","www.ab-insurance.com/","www.cathaylife.cn/","www.ccib.com.cn/","ybj.sh.gov.cn/","www.sunlife-everbright.com/","www.cpic.com.cn/","www.mohrss.gov.cn/index.html","life.pingan.com/","www.sinosig.com/","www.unibao.com/","property.pingan.com/","www.sinoins.com/","www.zdlife.com/","tppension.cntaiping.com/","www.cpcr.com.cn/","www.china-insurance.com/","www.yxybb.com/","www.sinosure.com.cn/","insurance.jrj.com.cn/","www.sinosig.com/","www.greatlife.cn/","life.cntaiping.com/","www.cpic.com.cn/cx/","www.aegon-cnooc.com/","www.abchinalife.cn/","www.95505.com.cn/","www.ydthlife.com/","www.nissay-greatwall.com.cn/","www.ccb-life.com.cn/","www.iaf.org.cn/","www.gxbx.com.cn/","www.bxxy.com/","www.qzr.cn/","www.anbanggroup.com/","www.anbanggroup.com/","www.chinare.com.cn/","www.lifeisgreat.com.cn/","www.axa-ins.com.cn/cn","www.ehuatai.com/","www.taikang.com/","www.unionlife.com.cn/","www.cic.cn/","www.sino-life.com/","www.hxlife.com/","www.baoxian.com/","www.hzins.com/","www.iachina.cn/","www.ehuatai.com/","www.chinare.com.cn/","www.iic.org.cn/","www.ssac.com.cn/","www.hengansl.com/","www.xiangrikui.com/","annuity.pingan.com/","www.picc.com.cn/","www.xinhuanet.com/fortune/bx.htm","www.biabii.org.cn/","pc.ehuatai.com/","www.metlife.com.cn/","money.sohu.com/baoxian/","www.anbangannuity.com/","www.anbang-life.com/","www.chinalifere.cn/","www.alltrust.com.cn/","www.szii.org.cn/","www.funde-ins.com/","www.rmic.cn/","www.newchinalife.com/","www.sfli.com.cn/","www.yaic.com.cn/","www.bocommlife.com/","finance.ce.cn/insurance/","www.pingan.com/","www.szia.org.cn/","www.huatai-serv.com/","www.kunlunhealth.com/","www.cignacmb.com/","www.zjbaoxian.com/","www.examda.com/bx/","www.clpc.com.cn/","www.skandia-bsam.cn/","www.aviva-cofco.com.cn/","www.generalichina.com/","www.chinalife.com.cn/","www.picclife.com/","health.pingan.com/","www.chinalife-p.com.cn/","www.cntaiping.com/","www.citic-prudential.com.cn/","www.bpic.com.cn/","www.bob-cardif.com/"};
    String g7="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;
    public Bs24(){
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



   public String  t3(int c8){
       String url ="";
        String x4=""+"http://www.5566.net/bs-2.htm";
        String e0="=''+document.URL;";
        String h6="=''+location.hostname;";
        String d5="7711.5566";
        String z6="6688.5566";
        String t8=""+"www.5566.net";
        int d2=t8.lastIndexOf('.');
        int r0=0+Integer.parseInt(String.valueOf(d5.charAt(0)));
        int x7=0+string2Unicode(String.valueOf(e0.charAt(6)));
        int h2=0+string2Unicode(String.valueOf(h6.charAt(5)));
        int t4=0+Integer.parseInt(String.valueOf(t8.charAt(d2-1)));
        int q2=0+Integer.parseInt(String.valueOf(d5.charAt(3)));
        int s0=0+Integer.parseInt(String.valueOf(t8.charAt(d2-3)));
        String z7="bs";
        if(x4.indexOf("5566")>=0&&x4.indexOf("bs")>=0){
            url = "http://"+s1[(c8-t4-r0-q2-h2-x7-51)/s0];
        }
        return  url;
    }
   public String  s3(int g2){
       String url = "";
        String o2="=''+location.host;";
        String s7="4455.5566";
        String z3=""+"www.5566.net";
        String u3="8866.5566";
        String c7="=''+location.href;";
        String f9=""+"http://www.5566.net/bs-2.htm";
        int v9=z3.lastIndexOf('.');
        int m7=0+string2Unicode(String.valueOf(o2.charAt(5)));
        int o6=0+Integer.parseInt(String.valueOf(u3.charAt(3)));
        int a2=0+Integer.parseInt(String.valueOf(z3.charAt(v9-3)));
        int z9=0+Integer.parseInt(String.valueOf(z3.charAt(v9-1)));
        int u6=0+string2Unicode(String.valueOf(c7.charAt(6)));
        int e2=0+Integer.parseInt(String.valueOf(u3.charAt(1)));
        String g5="bs";
        if(z3=="5566.net"||z3=="www.5566.net"||z3=="5566.org"||z3=="1.5566.org"||z3=="2.5566.org"||z3=="3.5566.org"||z3=="4.5566.org"||z3=="5.5566.org"||z3=="www.5566.org"){
           url = "http://"+s1[(g2-a2-z9-o6-m7-u6-96)/e2];
        }
        return  url;
    }
    public String  s6(int o8){
        String url ;
        String f4="=''+document.location;";
        String e4=""+"www.5566.net";
        String m8="=''+document.domain;";
        String s7="1177.5566";
        String k4="5544.5566";
        String z5=""+"http://www.5566.net/bs-2.htm";
        int r9=e4.lastIndexOf('.');
        int d9=0+string2Unicode(String.valueOf(f4.charAt(6)));
        int t1=0+Integer.parseInt(String.valueOf(e4.charAt(r9-3)));
        int x1=0+string2Unicode(String.valueOf(m8.charAt(8)));
        int m6=0+Integer.parseInt(String.valueOf(k4.charAt(3)));
        int p5=0+Integer.parseInt(String.valueOf(e4.charAt(r9-1)));
        int v0=0+Integer.parseInt(String.valueOf(k4.charAt(0)));
        String w6="bs";
        if(e4!="5566.net"&&e4!="www.5566.net"&&e4!="5566.org"&&e4!="1.5566.org"&&e4!="2.5566.org"&&e4!="3.5566.org"&&e4!="4.5566.org"&&e4!="5.5566.org"&&e4!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+s1[(o8-t1-v0-m6-x1-d9-23)/p5];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("t3")) {
                    tmpUrl = t3(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("s3")) {
                    tmpUrl = s3(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("s6")) {

                    tmpUrl = s6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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



    public  void getBsUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "财经";
        String tag2 ="保险";
//        System.out.println(p.get(69));
        //16,29,39,69
        int[] numbers = {16,29,39,69};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }






    }



    public static void main(String[] args) {

        Bs24 bs24 = new Bs24();
        bs24.getBsUrls("http://www.5566.net/bs-2.htm");



    }




}
