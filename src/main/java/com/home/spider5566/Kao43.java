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
 * Created by hadoop on 16-11-23.
 */
public class Kao43 {
   String[] r4={"0","www.qhpta.com/","www.eeagd.edu.cn/","www.whptc.org/","www.scpta.gov.cn/","www.csks.gov.cn/","www.hbguideexam.gov.cn/","www.nbks.net/","www.hrexam.com/","www.lzk.hl.cn/","www.cqksy.cn/","zsb.jledu.gov.cn/","www.cpta.com.cn/","www.xapta.com.cn/","www.syec.net.cn/","www.kszx.net.cn/","www.ahzsks.cn/","www.hljgwy.net/","www.hnrsks.com/","www.hebpta.com.cn/","kszx.cqhrss.gov.cn/","www.whzkb.com/","www.bjrbj.gov.cn/bjpta/","www.sceea.cn/","www.czks.cn/","www.gzpta.gov.cn/","www.gszs.edu.cn/","www.hbea.edu.cn/","www.ynzk.cn/","www.zzrsks.com.cn/","www.njrsks.com/","www.sxpta.com/","www.5184.com/","www.sxrsks.cn/","www.hneao.edu.cn/","www.fjpta.com/","www.lnzsks.com/","www.jxpta.com/","www.examw.com/","learning.sohu.com/","www.hunanpta.com/","www.xjrsks.com.cn/","rsks.jshrss.gov.cn/","www.sxkszx.cn/","www.hbee.edu.cn/","www.jlzkb.com/","www.gxeea.cn/","www.hbsrsksy.cn/","www.xzzsks.com.cn/","www.gzszk.com/","edu.sina.com.cn/","www.gsee.edu.cn/","www.yuloo.com/","www.kaoyan.com/","www.zjzs.net/","www.gxpta.com.cn/","www.jxeea.cn/","www.sneac.edu.cn/","www.hneeb.cn/","kszx.yt12333.com/","www.gzzk.cn/","www.zsksb.com/","www.ahzk.net/","www.lnrsks.com/","www.xinhuanet.com/edu/kszq.htm","www.jxedt.com/","www.nnzsks.gov.cn/","ea.hainan.gov.cn/","www.eeafj.cn/","bm.scs.gov.cn/","www.sneac.com/","www.kaoyee.com/","www.eastedu.com.cn/","www.impta.com/","www.233.com/","www.spta.gov.cn/","www.zhaokao.net/","www.nnrkz.com/","www.bjeea.cn/","www.wfrsks.com/","www.heao.com.cn/","www.gdkszx.com.cn/","www.zk789.net/","www.hebeea.edu.cn/","www.neea.edu.cn/","www.chinaielts.org/","www.sdzs.gov.cn/","www.100ksw.com/","www.testcenter.gov.cn/","www.jseea.cn/","61.133.219.10/","www.eeafj.cn/zxks/","www.syzsks.com/","www.cqleaders.com/","www.cqzsw.com.cn/","www.hfrc.net/","www.apta.gov.cn/","www.jlgwy.net/","www.51test.net/","www.hljrsks.org.cn/","chaxun.neea.edu.cn/","www.rsks.sdrs.gov.cn/","www.fjkl.gov.cn/","zsxx.e21.edu.cn/","www.heao.gov.cn/","www.ntpta.gov.cn/","www.zikao365.com/","www.jlste.com.cn/","www.shmeea.com.cn/","www.ynrsksw.cn/","www.catti.net.cn/","www.onekao.com/","www.qhzk.com/","www.zjks.com/","www.humanassess.com.cn/","www.nm.zsks.cn/","www.nxpta.gov.cn/","www.tjkpzx.com/"};
    String n1="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;

    public Kao43() {
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


    public String  h6(int k8){
        String url = "";
        String t6="9911.5566";
        String i6=""+"http://www.5566.net/kao-3.htm";
        String f7="=''+document.URL;";
        String i8=""+"www.5566.net";
        String w7="=''+document.domain;";
        String z9="3366.5566";
        int v0=i8.lastIndexOf('.');
        int j0=0+Integer.parseInt(String.valueOf(z9.charAt(2)));
        int d6=0+Integer.parseInt(String.valueOf(z9.charAt(0)));
        int y6=0+string2Unicode(String.valueOf(f7.charAt(6)));
        int p7=0+Integer.parseInt(String.valueOf(i8.charAt(v0-3)));
        int s6=0+string2Unicode(String.valueOf(w7.charAt(5)));
        int o3=0+Integer.parseInt(String.valueOf(i8.charAt(v0-1)));
        String e9="kao";
        if(i6.indexOf("5566")>=0&&i6.indexOf("kao")>=0){
            url = "http://"+r4[(k8-o3-d6-j0-s6-y6-53)/p7];
        }
        return  url;
    }
    public String  p2(int v8){
        String url = "";
        String z5="8844.5566";
        String q2="=''+location.host;";
        String k4="1199.5566";
        String c4=""+"www.5566.net";
        String g8=""+"http://www.5566.net/kao-3.htm";
        String u6="=''+document.location;";
        int n2=c4.lastIndexOf('.');
        int t3=0+Integer.parseInt(String.valueOf(k4.charAt(3)));
        int f8=0+string2Unicode(String.valueOf(q2.charAt(5)));
        int a4=0+Integer.parseInt(String.valueOf(c4.charAt(n2-1)));
        int n7=0+Integer.parseInt(String.valueOf(c4.charAt(n2-3)));
        int y2=0+Integer.parseInt(String.valueOf(k4.charAt(1)));
        int a7=0+string2Unicode(String.valueOf(6));
        String m4="kao";
        if(c4=="5566.net"||c4=="www.5566.net"||c4=="5566.org"||c4=="1.5566.org"||c4=="2.5566.org"||c4=="3.5566.org"||c4=="4.5566.org"||c4=="5.5566.org"||c4=="www.5566.org"){
           url = "http://"+r4[(v8-n7-a4-t3-f8-a7-17)/y2];
        }
        return  url;
    }
    public String  i7(int m2){
        String url;
        String i9="4488.5566";
        String k1="=''+location.href;";
        String a9=""+"www.5566.net";
        String l2=""+"http://www.5566.net/kao-3.htm";
        String z5="6633.5566";
        String f3="=''+location.hostname;";
        int q1=a9.lastIndexOf('.');
        int o2=0+Integer.parseInt(String.valueOf(a9.charAt(q1-1)));
        int y1=0+string2Unicode(String.valueOf(k1.charAt(6)));
        int b4=0+Integer.parseInt(String.valueOf(a9.charAt(q1-3)));
        int o1=0+Integer.parseInt(String.valueOf(i9.charAt(0)));
        int z2=0+Integer.parseInt(String.valueOf(i9.charAt(3)));
        int y4=0+Integer.parseInt(String.valueOf(f3.charAt(5)));
        String l5="kao";
        if(a9!="5566.net"&&a9!="www.5566.net"&&a9!="5566.org"&&a9!="1.5566.org"&&a9!="2.5566.org"&&a9!="3.5566.org"&&a9!="4.5566.org"&&a9!="5.5566.org"&&a9!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+r4[(m2-b4-o1-z2-y4-y1-6)/o2];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("h6")) {
                    tmpUrl = h6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("p2")) {
                    tmpUrl = p2(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("i7")) {

                    tmpUrl = i7(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

                }
            } catch (Exception e) {
                tmpUrl = href.attr("href");
                tmpName = href.text();
            }
            if (tmpUrl.length() > 2) {

//                System.out.println(tmpUrl + "---------" + tmpName);

                inserTable(tag1, tag2, tmpUrl, tmpName);

            }
        }

    }






    public  void  getKaoUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "教育";
        String tag2 ="考试";
//        System.out.println(p.get(33));
        //20, 33
        int[] numbers = {20,33};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }



    }
    public static void main(String[] args) {


        Kao43 kao43 = new Kao43();
        kao43.getKaoUrls("http://www.5566.net/kao-3.htm");



    }









}
