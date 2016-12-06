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
public class Ren42 {
    String[] q9={"0","www.job5156.com/","www.01hr.com/","www.carjob.com.cn/","www.buildhr.com/","www.goodjob.cn/","www.ncss.org.cn/","www.1010jz.com/","www.528.com.cn/","www.jobeast.com/","www.tjrc.com.cn/","job.aweb.com.cn/","www.hgjob.com/","www.fesco.com.cn/","www.cphr.com.cn/","www.hr.com.cn/","www.doctorjob.com.cn/","www.lqjob88.com/","www.36.cn/","www.jobcn.com/","www.qzrc.com/","hr.heiguang.com/","www.nchr.com.cn/","www.jobhb.com/","www.nmgrc.com/","www.hbsc.cn/","www.baicai.com/","www.dajie.com/","www.myjob.com/","www.zjrc.com/","www.tianjihr.com/","www.jxrcw.com/","www.hnrcsc.com/","www.91student.com/","bbs.hrsalon.org/","www.triphr.com/","www.xmrc.com.cn/","www.rencaijob.com/","www.healthr.com/","www.job168.com/","www.siphrd.com/","www.wzrc.net/","www.hiall.com.cn/","www.yjbys.com/","www.pcbjob.com/","www.jobui.com/","www.djob.com/","www.xajob.com/","www.baidajob.com/","www.epjob88.com/","www.jiaoshi.com.cn/","it.800hr.com/","www.goodjobs.cn/","www.lqjob88.com/","www.yingjiesheng.com/","www.gxrc.com/","www.hrm.cn/","www.sjrc.com.cn/","www.kshr.com.cn/","www.healthr.com/","www.hxrc.com/","www.hzrc.com/","www.800hr.com/","www.chinahrd.net/","www.chinahr.com/","hr.bjx.com.cn/","www.buildjob.net/","www.chinajob.gov.cn/","jobs.12333sh.gov.cn/","www.21wecan.com/","www.gdrc.com/","www.cfw.cn/","www.szhr.com.cn/","www.tianjihr.com/","www.labournet.com.cn/","www.cjol.com/","www.51job.com/","job.zhulong.com/","www.tourjob.net/","www.01job.cn/","www.nbrc.com.cn/","www.veryeast.cn/","www.zhaojiao.net/","www.qlrc.com/","www.138job.com/","www.bosshr.com/","www.huibo.com/","www.njrsrc.com/","www.gaoxiaojob.com/","www.bankhr.com/","www.51rencai.com/","www.hr33.com/","www.hxrc.com/","www.goodjob.cn/"};
    String f7="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;

    public Ren42() {
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

  public String  o5(int t5){
      String url;
        String z7="=''+document.location;";
        String y5="7755.5566";
        String i8=""+"www.5566.net";
        String j7="=''+document.domain;";
        String o9="8822.5566";
        String u4=""+"http://www.5566.net/ren1-4.htm";
        int f0=i8.lastIndexOf('.');
        int i1=0+string2Unicode(String.valueOf(z7.charAt(6)));
        int w1=0+Integer.parseInt(String.valueOf(o9.charAt(3)));
        int q7=0+Integer.parseInt(String.valueOf(i8.charAt(f0-3)));
        int t2=0+string2Unicode(String.valueOf(j7.charAt(5)));
        int p8=0+Integer.parseInt(String.valueOf(i8.charAt(f0-1)));
        int a2=0+Integer.parseInt(String.valueOf(o9.charAt(1)));
        String y9="ren1";
        if(u4.indexOf("5566")==-1||u4.indexOf("ren1")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+q9[(t5-q7-a2-w1-t2-i1-87)/p8];
        }
        return  url;
    }
   public String  t3(int y6){
       String url = "";
        String g2="=''+location.href;";
        String e8="=''+location.hostname;";
        String j5=""+"www.5566.net";
        String p6=""+"http://www.5566.net/ren1-4.htm";
        String i7="9966.5566";
        String y5="2288.5566";
        int e0=j5.lastIndexOf('.');
        int y0=0+string2Unicode(String.valueOf(g2.charAt(6)));
        int f5=0+string2Unicode(String.valueOf(e8.charAt(5)));
        int d9=0+Integer.parseInt(String.valueOf(j5.charAt(e0-3)));
        int h6=0+Integer.parseInt(String.valueOf(i7.charAt(1)));
        int m3=0+Integer.parseInt(String.valueOf(j5.charAt(e0-1)));
        int e3=0+Integer.parseInt(String.valueOf(i7.charAt(3)));
        String a8="ren1";
        if(p6.indexOf("5566")>=0&&p6.indexOf("ren1")>=0){
           url = "http://"+q9[(y6-d9-m3-e3-f5-y0-64)/h6];
        }
        return  url;
    }


    public String  n5(int w6){
        String url = "";
        String h4="=''+document.URL;";
        String c4="=''+location.host;";
        String q6="5577.5566";
        String h9=""+"www.5566.net";
        String j1="6699.5566";
        String t6=""+"http://www.5566.net/ren1-4.htm";
        int u5=h9.lastIndexOf('.');
        int q1=0+string2Unicode(String.valueOf(h4.charAt(6)));
        int i2=0+string2Unicode(String.valueOf(c4.charAt(5)));
        int c5=0+Integer.parseInt(String.valueOf(h9.charAt(u5-1)));
        int b4=0+Integer.parseInt(String.valueOf(h9.charAt(u5-3)));
        int d7=0+Integer.parseInt(String.valueOf(q6.charAt(3)));
        int n2=0+Integer.parseInt(String.valueOf(q6.charAt(0)));
        String l8="ren1";
        if(h9=="5566.net"||h9=="www.5566.net"||h9=="5566.org"||h9=="1.5566.org"||h9=="2.5566.org"||h9=="3.5566.org"||h9=="4.5566.org"||h9=="5.5566.org"||h9=="www.5566.org"){
           url = "http://"+q9[(w6-c5-n2-d7-i2-q1-72)/b4];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("o5")) {
                    tmpUrl = o5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("t3")) {
                    tmpUrl = t3(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("n5")) {

                    tmpUrl = n5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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


    public  void  getRenUels(String url){


        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "教育";
        String tag2 ="人才/求职/招聘";
//        System.out.println(p.get(52));
        //20,37, 52
        int[] numbers = {20,37, 52};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }




    }

    public static void main(String[] args) {

        Ren42 ren42 = new Ren42();

        ren42.getRenUels("http://www.5566.net/ren1-4.htm");




    }








}
