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
public class Fund22 {
    String[] m5={"0","www.huatai-pb.com/","fund.cnfol.com/","www.dfham.com/","www.icbccs.com.cn/","www.ccbfund.cn/","www.fsfund.com/","www.dcfund.com.cn/","www.bnyfund.com/","www.51fund.com/","fund.eastmoney.com/fundguzhi.html","www.donghaifunds.com/","www.fadfunds.com/","www.jxfund.cn/","www.ubssdic.com/","www.postfund.com.cn/","finance.sina.com.cn/fund/","www.acfund.com.cn/","www.scfund.com.cn/","www.bocim.com/","www.orient-fund.com/","www.hsbcjt.cn/","www.boscam.com.cn/","www.xyfunds.com.cn/","www.lionfund.com.cn/","www.nffund.com/","www.bnyfund.com/","fund.cfi.cn/","www.igwfmc.com/","www.epf.com.cn/","fund.eastmoney.com/allfund.html","www.bocim.com/","www.zsfund.com/index.htm","ewealth.abchina.com/fund/","www.gffunds.com.cn/","www.psbc.com/portal/zh_CN/Fund/index.html","fund.ccb.com/fund/index.html","www.zrfunds.com.cn/","www.cfund108.com/","www.cs.com.cn/tzjj/","www.qhkyfund.com/","www.ccfund.com.cn/","www.gefund.com.cn/","fund.cnstock.com/","www.chinanature.com.cn/","www.gtsfund.com.cn/","www.cmfchina.com/","fund.stockstar.com/","www.gtja-allianz.com/","funds.hexun.com/","money.163.com/special/2014jjpm/","www.chinaamc.com/","www.hsfund.com/","www.jtamc.com/","www.gfund.com/","fund.eastmoney.com/gonggao/","www.bxrfund.com/","finance.qq.com/fund/","quote.eastmoney.com/center/list.html#285002_4","money.163.com/fund/","fund.eastmoney.com/data/fundranking.html","www.swsmu.com/","fund.eastmoney.com/jjjz.html","www.galaxyasset.com/","www.byfunds.com/","www.huaan.com.cn/","www.cxfund.com.cn/","fund.jnlc.com/zhuanti/2015/jnj/","www.cs.com.cn/hyzb/jnjj2016/","fund.eastmoney.com/company/default.html","www.hftfund.com/","www.cryuantafund.com/","www.kjj.com/","www.bosera.com/","cn.morningstar.com/quickrank/default.aspx","www.hongdefund.com/","www.bosera.com/","www.csfunds.com.cn/","www.cmfchina.com/main/tjlc/fjjjzl/fjjjkt/index.shtml","www.py-axa.com/","guba.eastmoney.com/list,jjdt.html","www.ftfund.com/","data.eastmoney.com/money/calc/CalcFundSGRG.html","www.gtfund.com/","fund.jrj.com.cn/","www.icbc.com.cn/icbc/网上基金","www.ncfund.com.cn/","www.hcmiraefund.com/","www.gsfunds.com.cn/","finance.sina.com.cn/money/fund/jiminxy/","money.business.sohu.com/fund/","www.msjyfund.com.cn/","www.bobbns.com/","fund.pingan.com/","www.rtfund.com/","www.jyvpfund.com/","fund.eastmoney.com/data/fundrating.html","www.dbfund.com.cn/","www.fscinda.com/","www.xyamc.com/","fund.eastmoney.com/data/xinsale.html","www.efunds.com.cn/","www.zhfund.com/","fund.eastmoney.com/manager/","www.phfund.com.cn/","www.chinafund.cn/","www.fsfund.com/","www.nffund.com/","www.abc-ca.com/","www.cdbsfund.com/","www.cjhxfund.com.cn/","www.chinaamc.com/","fund.hrsec.com.cn/","www.changanfunds.com/","www.p5w.net/fund/index.htm","www.ttyfund.com/","www.ciccfund.com/","www.howbuy.com/","www.haoamc.com/","www.mfcteda.com/","finance.ifeng.com/fund/","fund.eastmoney.com/Fund_sgzt_bzdm.html","fund.eastmoney.com/data/dxgjj_xgccjjyl.html","www.ctfund.com/","cn.morningstar.com/","www.jsfund.cn/","www.99fund.com/","www.htcxfund.com/","fund.eastmoney.com/HBJJ_dwsy.html","www.cib-fund.com.cn/","www.ftsfund.com/","www.maxwealthfund.com/","www.htamc.com.cn/","www.ccbfund.cn/","www.efunds.com.cn/","www.thfund.com.cn/","www.citicprufunds.com.cn/","www.essencefund.com/","www.gffunds.com.cn/","www.ymfund.com/","www.99fund.com/","fund2.eastmoney.com/","www.hffunds.cn/","www.hffund.com/","www.fullgoal.com.cn/","www.lordabbettchina.com/","www.fullgoal.com.cn/","www.icbccs.com.cn/","www.wjasset.com/","www.yhfund.com.cn/","www.fund123.cn","www.jyfund.com/","www.msfunds.com.cn/","www.zofund.com/","www.cmfchina.com/","www.ydamc.com/","www.jsfund.cn/","fund.eastmoney.com/","www.fundxy.com/","www.founderff.com/","www.cnfund.cn/"};
    String x2="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;
    public Fund22(){
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


    public String  t5(int m8){
        String url;
        String q0="=''+document.location;";
        String h1="8811.5566";
        String h3=""+"http://www.5566.net/fund.htm";
        String u8="=''+location.hostname;";
        String u1="5577.5566";
        String y7=""+"www.5566.net";
        int a2=y7.lastIndexOf('.');
        int v6=0+string2Unicode(String.valueOf(q0.charAt(6)));
        int n5=0+Integer.parseInt(String.valueOf(u1.charAt(3)));
        int m9=0+Integer.parseInt(String.valueOf(u1.charAt(1)));
        int r2=0+string2Unicode(String.valueOf(u8.charAt(5)));
        int y1=0+Integer.parseInt(String.valueOf(y7.charAt(a2-1)));
        int e3=0+Integer.parseInt(String.valueOf(y7.charAt(a2-3)));
        String v7="fund";
        if(h3.indexOf("5566")==-1||h3.indexOf("fund")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+m5[(m8-y1-m9-n5-r2-v6-40)/e3];
        }
        return  url ;
    }
    public String  l9(int l2){
        String url = "";
        String k0=""+"www.5566.net";
        String k8="=''+location.href;";
        String n8=""+"http://www.5566.net/fund.htm";
        String z1="7755.5566";
        String r4="=''+document.domain;";
        String  w0="3366.5566";
        int k2=k0.lastIndexOf('.');
        int n9=0+Integer.parseInt(String.valueOf(k0.charAt(k2-3)));
        int n3=0+string2Unicode(String.valueOf(k8.charAt(6)));
        int a5=0+Integer.parseInt(String.valueOf(w0.charAt(0)));
        int k1=0+Integer.parseInt(String.valueOf(w0.charAt(2)));
        int h7=0+string2Unicode(String.valueOf(r4.charAt(5)));
        int d0=0+Integer.parseInt(String.valueOf(k0.charAt(k2-1)));
        String a1="fund";
        if(k0=="5566.net"||k0=="www.5566.net"||k0=="5566.org"||k0=="1.5566.org"||k0=="2.5566.org"||k0=="3.5566.org"||k0=="4.5566.org"||k0=="5.5566.org"||k0=="www.5566.org"){
           url = "http://"+m5[(l2-n9-a5-k1-h7-n3-56)/d0];
        }
        return  url;
    }
  public String  p1(int a8){
      String url = "";
        String g2="=''+document.URL;";
        String i9="1188.5566";
        String r9=""+"http://www.5566.net/fund.htm";
        String d1=""+"www.5566.net";
        String c9="=''+location.host;";
        String z1="6633.5566";
        int w7=d1.lastIndexOf('.');
        int n2=0+string2Unicode(String.valueOf(g2.charAt(6)));
        int q1=0+Integer.parseInt(String.valueOf(d1.charAt(w7-1)));
        int f5=0+Integer.parseInt(String.valueOf(i9.charAt(0)));
        int h8=0+Integer.parseInt(String.valueOf(d1.charAt(w7-3)));
        int h6=0+string2Unicode(String.valueOf(c9.charAt(5)));
        int q7=0+Integer.parseInt(String.valueOf(i9.charAt(2)));
        String n7="fund";
        if(r9.indexOf("5566")>=0&&r9.indexOf("fund")>=0){
           url = "http://"+m5[(a8-h8-q1-q7-h6-n2-46)/f5];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("t5")) {
                    tmpUrl = t5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("l9")) {
                    tmpUrl = l9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("p1")) {

                    tmpUrl = p1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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


    public  void getFunUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "财经";
        String tag2 ="基金";
//        System.out.println(p.get(58));
        //17,37, 58
        int[] numbers = {17,37, 58};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }




    }



    public static void main(String[] args) {


        Fund22 fund22 = new Fund22();

        fund22.getFunUrls("http://www.5566.net/fund.htm");


    }







}
