package com.home.spider5566;

import com.home.spring.JDBCHelper;
import org.apache.hadoop.mapreduce.v2.proto.MRProtos;
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
public class ChaXun4 {

    String[] z4 = {"0", "www.tielu.org/", "www.zhcw.com/", "health.sohu.com/6/0504/21/blank220082154.shtml", "www.haodf.com/yiyuan/beijing/list.htm", "www.stats.gov.cn/tjsj/pcsj/", "www.boc.cn/sourcedb/whpj/", "www.iciba.com/", "www.huoche.com.cn/", "www.pcauto.com.cn/qcbj/qcbj_if_gngw.html", "finance.sina.com.cn/calc/tax_pers_income.html", "sbj.saic.gov.cn/sbcx/", "www.xzqh.org/", "www.ip138.com/ems/", "www.huochepiao.com/Search5/", "www.t7online.com/", "guishu.showji.com/", "www.mtime.com/showtime/", "www.zdic.net/", "flights.ctrip.com/international/SearchFlights.aspx", "www.ip138.com/carlist.htm", "www.ems.com.cn/", "www.chazidian.com/baijiaxing/", "www.chsi.com.cn/xlcx/", "port.sol.com.cn/", "www.cngaosu.com/", "health.sohu.com/health/drugsearch.htm", "www.hicourt.gov.cn/law/default.asp", "www.zdic.net/appendix/f27.htm", "www.ip138.com/", "www.nongli.com/item4/", "www.linkwan.com/gb/broadmeter/SpeedAuto/", "quote.eastmoney.com/quote1_1.html", "shoushen.yoka.com/FoodSearch.aspx", "www.bankrate.com.cn/financial-products/", "zscx.nvq.net.cn/", "www.sge.sh/publish/sge/xqzx/index.htm", "www.xingming.net/", "www.yp.net.cn/schinese/search/GlobalAreaCode.asp", "kaoshi.jxedt.com/", "www.ccb.com/cn/personal/interest/rmbdeposit.html", "www.jxhld.gov.cn/biaozhi/biaozhi_11/", "wz.gocar.cn/changtu/", "hanyu.iciba.com/", "www.51240.com/yingyang/", "bus.mapbar.com/", "www.lssdjt.com/", "www.todayonhistory.com/jieri/", "www.time001.com/", "qq.ip138.com/hl.asp", "www.shoushen.com/standard.htm", "health.sohu.com/eden/anquanqi/jump.html", "fund.eastmoney.com/fund.html"};
    String y8 = "http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;
    String[] c6 = {"0", "www.cqnews.net/", "www.taihainet.com/", "www.dahe.cn/", "www.yninfo.com/", "www.269.net/", "www.eastday.com/", "www.hainan.net/", "www.ycwb.com/", "www.ccoo.cn/", "www.bdchina.com/", "www.hinews.cn/", "www.dayoo.com/", "www.qzwb.com/", "www.sxrb.com/", "www.gz163.cn/", "hunan.voc.com.cn/", "www.scol.com.cn/", "www.cqzaixian.com/", "www.cnool.net/", "www.jschina.com.cn/", "www.bjd.com.cn/", "www.qianlong.com/", "www.wuhan.net.cn/", "www.dzwww.com/", "www.nen.com.cn/", "www.changsha.cn/", "www.jxnews.com.cn/", "www.tfol.com/", "www.enorth.com.cn/", "www.online.sh.cn/", "www.newssc.org/", "www.northtimes.com/", "www.lywww.com/", "www.cnbb.com.cn/", "www.gznet.com/", "www.zj.com/", "www.szonline.net/", "www.xmnn.cn/", "www.sdinfo.net/", "www.longhoo.net/", "www.fjii.com/", "www.westcn.com/", "www.gxsky.com/", "www.vnet.cn/", "www.qingdaonews.com/", "www.zjol.com.cn/", "www.chinajilin.com.cn/", "www.yunnan.cn/", "www.fjsen.com/", "www.dbw.cn/", "www.2500sz.com/", "www.sznews.com/", "www.gxnews.com.cn/", "www.ynet.com/", "www.tibet.cn/", "www.oeeee.com/", "www.xj163.cn/", "www.nmgnews.com.cn/", "www.nx.cninfo.net/", "www.21cn.com/", "www.hsw.cn/", "www.cnhubei.com/", "www.shangdu.com/", "www.bbn.com.cn/", "www.online.tj.cn/", "www.rednet.cn/", "www.jlonline.com/", "www.jsinfo.net/", "www.66163.com/", "www.hebnews.cn/", "www.southcn.com/", "www.anhuinews.com/", "www.shenchuang.com/", "www.yinsha.com/", "www.inhe.net/", "www.86516.com/"};
    String r2 = "http://www.5566.org/indexe.htm";

    public ChaXun4() {
        try {
            jdbcTemplate = JDBCHelper.createMysqlTemplate("mysql1", "jdbc:mysql://192.168.21.27/urlclassifier?useUnicode=true&characterEncoding=utf8", "root", "root", 5, 30);

            jdbcTemplate.execute("create table if not EXISTS  tb_5566new("
                    + "id int(11) not null auto_increment PRIMARY KEY ,"
                    + "tag1 varchar(20)," +
                    "tag2 varchar(20) default null," +
                    "url varchar(255)," +
                    "name varchar(50)," +
                    "title LONGTEXT," +
                    "text LONGTEXT," +
                    " UNIQUE INDEX `url` (`url`)" +
                    ") ENGINE=MyISAM DEFAULT  CHARSET=utf8;");
            System.out.println("成功创建数据表tb_parser2");

        } catch (Exception e) {
            jdbcTemplate = null;
            System.out.println("mysql未开启或JDBCHelper.createMysqlTemplate中的参数不正确!");
            e.printStackTrace();
        }


    }


    public void inserTable(String tag1, String tag2, String url, String name) {
        try {
            if (jdbcTemplate != null) {
                int updates = jdbcTemplate.update("INSERT  INTO  tb_5566new" +
                                "(tag1, tag2, url, name) VALUE (?, ?,?, ?)",
                        tag1, tag2, url, name
                );

                if (updates == 1) {
                    System.out.println("mysql插入成功");
                }

            }
        } catch (DuplicateKeyException e) {
            System.out.println("该url:" + url + "已经存在数据库里面");
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


    public String t5(int k1) {
        String url = "";
        String a4 = "" + "http://www.5566.net/find-.htm";
        String y6 = "=''+location.href;";
        String n6 = "5533.5566";
        String q2 = "" + "www.5566.net";
        String g5 = "=''+location.host;";
        String u7 = "1144.5566";
        int j9 = q2.lastIndexOf('.');
        int b4 = 0 + Integer.parseInt(String.valueOf(u7.charAt(1)));
        int u5 = 0 + string2Unicode(String.valueOf(y6.charAt(6)));
        int r9 = 0 + Integer.parseInt(String.valueOf(u7.charAt(3)));
        int m0 = 0 + Integer.parseInt(String.valueOf(q2.charAt(j9 - 3)));
        int t8 = 0 + string2Unicode(String.valueOf(g5.charAt(5)));
        int h3 = 0 + Integer.parseInt(String.valueOf(q2.charAt(j9 - 1)));
        String t9 = "find";
        if (q2 == "5566.net" || q2 == "www.5566.net" || q2 == "5566.org" || q2 == "1.5566.org" || q2 == "2.5566.org" || q2 == "3.5566.org" || q2 == "4.5566.org" || q2 == "5.5566.org" || q2 == "www.5566.org") {
            url = "http://" + z4[(k1 - m0 - h3 - r9 - t8 - u5 - 50) / b4];
        }
        return url;
    }

    public String e6(int y1) {
        String url = "";
        String m3 = "=''+location.hostname;";
        String g7 = "=''+document.URL;";
        String n6 = "6622.5566";
        String l7 = "3355.5566";
        String f6 = "" + "www.5566.net";
        String o1 = "" + "http://www.5566.net/find-.htm";
        int o4 = f6.lastIndexOf('.');
        int t0 = 0 + string2Unicode(String.valueOf(m3.charAt(5)));
        int l8 = 0 + string2Unicode(String.valueOf(g7.charAt(6)));
        int m1 = 0 + Integer.parseInt(String.valueOf(l7.charAt(3)));
        int h2 = 0 + Integer.parseInt(String.valueOf(f6.charAt(o4 - 1)));
        int y5 = 0 + Integer.parseInt(String.valueOf(f6.charAt(o4 - 3)));
        int i0 = 0 + Integer.parseInt(String.valueOf(l7.charAt(0)));
        String j6 = "find";
        if (o1.indexOf("5566") >= 0 && o1.indexOf("find") >= 0) {
            url = "http://" + z4[(y1 - y5 - i0 - m1 - t0 - l8 - 84) / h2];
        }
        return  url;
    }

    public String b6(int c4) {
        String url;
        String p7 = "2266.5566";
        String s2 = "=''+document.domain;";
        String n5 = "" + "www.5566.net";
        String e3 = "" + "http://www.5566.net/find-.htm";
        String n1 = "=''+document.location;";
        String d7 = "4411.5566";
        int j4 = n5.lastIndexOf('.');
        int c5 = 0 + Integer.parseInt(String.valueOf(n5.charAt(j4 - 1)));
        int n4 = 0 + string2Unicode(String.valueOf(s2.charAt(5)));
        int f3 = 0 + Integer.parseInt(String.valueOf(n5.charAt(j4 - 3)));
        int d4 = 0 + Integer.parseInt(String.valueOf(p7.charAt(1)));
        int x9 = 0 + string2Unicode(String.valueOf(n1.charAt(6)));
        int y0 = 0 + Integer.parseInt(String.valueOf(p7.charAt(3)));
        String g3 = "find";
        if (n5 != "5566.net" && n5 != "www.5566.net" && n5 != "5566.org" && n5 != "1.5566.org" && n5 != "2.5566.org" && n5 != "3.5566.org" && n5 != "4.5566.org" && n5 != "5.5566.org" && n5 != "www.5566.org") {
            url = "http://www.5566.org/indexe.htm";
        } else {
            url = "http://" + z4[(c4 - c5 - d4 - y0 - n4 - x9 - 83) / f3];
        }
        return url;
    }


    public  void getChaXun(String url){


        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        int[] numbers = {17, 38, 59, 75, 85, 96, 111, 121};
        for (int i =0;i < numbers.length;i++){
            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            if(i ==0){
                getUrlAndText(urls, "实用查询", "");
            }
            if(i ==1){
                getUrlAndText(urls, "实用查询", "");
            }
            if (i == 2){
                getUrlAndText(urls, "实用查询", "");

            }
            if (i == 3){
                getUrlAndText(urls, "实用查询", "");

            }
            if(i == 4){
                getUrlAndText(urls, "实用查询", "");

            }
            if (i == 5){

                getUrlAndText(urls, "实用查询", "");

            }
            if (i == 6){
                getUrlAndText(urls, "实用查询", "");

            }
            if(i ==7){
                getUrlAndText(urls, "实用查询", "");

            }


        }



    }
    public  void getUrlAndText(Elements urls, String tag1, String tag2){

        String tmpUrl="";
        String tmpName="";
        String onclick = "";

        for(Element href: urls){
            try {
                onclick = href.attr("onclick");
                tmpName = href.text();
                if (onclick.substring(0, 2).equalsIgnoreCase("t5")){
                    tmpUrl = t5(Integer.parseInt(String.valueOf(onclick.substring(3, 6))));
                }
                if  (onclick.substring(0, 2).equalsIgnoreCase("e6")){
                    tmpUrl = e6(Integer.parseInt(String.valueOf(onclick.substring(3, 6))));
                }
                if(onclick.substring(0, 2).equals("b6")){

                    tmpUrl = b6(Integer.parseInt(String.valueOf(onclick.substring(3, 6))));

                }
            } catch (Exception e) {
               tmpUrl = href.attr("href");
                tmpName = href.text();
            }

//            System.out.println(tmpUrl +"---------"+tmpName);

            inserTable(tag1, tag2, tmpUrl, tmpName);

        }



    }


    public static void main(String[] args) {


        ChaXun4 chaXun4 = new ChaXun4();
        chaXun4.getChaXun("http://www.5566.net/find-.htm");




    }






}