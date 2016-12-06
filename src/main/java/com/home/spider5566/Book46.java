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
 * Created by hadoop on 16-11-24.
 */
public class Book46 {

    String[] m0={"0","lib.jmu.edu.cn","lib.ncut.edu.cn/","www.whlib.org.cn/","www.hflib.gov.cn/","lib.hhit.edu.cn","www.docin.com/","www.mzdlib.com/","www.clcn.net.cn/","library.lnu.edu.cn/","www.bookschina.com/","www.lib.cau.edu.cn","www.lib.fzu.edu.cn/","www.fslib.com.cn/","lib.nju.edu.cn/","www.library.gov.mo","lib.sx.cn","www.jnlib.net.cn/","www.stlib.cn/","lib.scu.edu.cn/","www.lib.whu.edu.cn/","www.szlib.com","202.113.68.3","lib.sdutcm.edu.cn/","www.chaoxing.com/","www.lib.tsinghua.edu.cn/","lib.lzu.edu.cn/","library.xaut.edu.cn/","www.lib.cc.jl.cn/","www.lib.szu.edu.cn/","www.lib.shufe.edu.cn","www.ahlib.com/","lib.gznu.edu.cn/","www.wanfangdata.com.cn/","www.lib.nxu.edu.cn","www.libnet.sh.cn/","lib.nuaa.edu.cn","www.law-lib.com/","lib.nwsuaf.edu.cn","www.wxlib.cn/","www.henanlib.gov.cn","gdy.gdmc.edu.cn/library","www.lib.tju.edu.cn","www.jllib.cn/","lib.suibe.edu.cn/","www.xmst.org/","www.hkpl.gov.hk/","lib.zjgsu.edu.cn/","lib.gdufe.edu.cn/","www.shelib.edu.cn/","lib.htu.cn/","www.lib.ecnu.edu.cn","lib.hebust.edu.cn/","www.cqlib.cn/","lib.glut.edu.cn/","lib.njtu.edu.cn/","www.helib.net/","www.lib.ynu.edu.cn/","lib.nwu.edu.cn/","libserver.swjtu.edu.cn/","www.sylib.net/","www.gxlib.org.cn","www.lib.sxu.edu.cn","www.bjdclib.com","www.elib.sdnu.edu.cn","www.jlplib.com.cn/","www.lnlib.com","www.hzlib.net/","lib.imu.edu.cn/","www.lib.sicnu.edu.cn/","202.195.119.250","www.ynlib.cn/","zh.wikipedia.org/","lib.zjnu.net.cn","lib.cqut.edu.cn/","www.99read.com/","www.nlc.gov.cn/","www.library.shmtu.edu.cn/","www.jxlib.gov.cn","lib.hbu.edu.cn","lib.xjufe.edu.cn/","lib.hfuu.edu.cn","lib.scnu.edu.cn","library.xmu.edu.cn/","www.lib.xidian.edu.cn/","buaalib.com/","202.204.214.131/","www.library.fudan.edu.cn/medical/index.htm","www.qzlib.com.cn/","lib.hubu.edu.cn/","202.194.143.1/","www.lib.pku.edu.cn/","www.lib.seu.edu.cn","www.pcbookcn.com/","www.library.hn.cn/","www.baike.com/","www.tjl.tj.cn/","www.lib.stu.edu.cn","www.lib.ruc.edu.cn","www.szlib.org.cn/","www.balib.cn/","www.czlib.net/","www.lib.neu.edu.cn/","lib.njue.edu.cn","www.cnki.net/","www.cdclib.org/","www.lib.zjut.edu.cn/","www.lib.ahu.edu.cn","lbr.neau.edu.cn","www.library.nenu.edu.cn","www.zzlib.org.cn/","lib2.swu.edu.cn/","lib.hnu.cn/","www.lib.scut.edu.cn/","lib.sdfi.edu.cn/","www.dglib.cn/","www.jslib.org.cn/","www.hrblib.net.cn/","www.sclib.org/","202.192.129.6/","lib.yzu.edu.cn/","210.37.79.3","library.ouc.edu.cn/","www.gxstlib.org.cn","202.116.174.99","www.lib.hit.edu.cn/","www.wl.cn/","202.119.210.4/","lib.hzau.edu.cn/","www.chaoxing.com/","www.gslib.com.cn/","www.gll-gx.org.cn/","lib.haut.edu.cn/","lib.jlu.edu.cn/","library.bua.edu.cn/","lib.blcu.edu.cn","www.lib.xjtu.edu.cn/","tsg.imau.edu.cn:9080/","www.lib.sjtu.edu.cn/","lib.hnust.cn/","www.lib.hust.edu.cn","lib.zzu.edu.cn/","210.45.242.3/","www.sdlib.com","www.qikan.com.cn/","lib.whut.edu.cn/","libgp.jnu.edu.cn","lib.fosu.edu.cn/","www.cqvip.com/","www.gzlib.gov.cn/","202.195.177.6/","www.lib.hutc.zj.cn/","210.37.32.30","lib.njtech.edu.cn/","lib.bjfu.edu.cn/","www.library.fudan.edu.cn/","lib.ccnu.edu.cn","www.lib.dlut.edu.cn","www.sxlib.org.cn","lib.csu.edu.cn/","lib.cqu.edu.cn/","www.sznslib.com.cn/","lib.henu.edu.cn/","www.stlib.net/","lib.sdut.edu.cn","www.lib.shu.edu.cn/","www.lib.bnu.edu.cn/","www.library.hb.cn/","www.chinabaike.com/","www.zslib.com.cn/","www.ytlib.sd.cn/","www.zjlib.cn/","www.fjlib.net/","www.lib.sdu.edu.cn","library.gdrtvu.edu.cn/","202.206.100.3/xi/tsg/","lib.bucm.edu.cn:8090/","lib.cumt.edu.cn","lib.hyit.edu.cn/","lib.bit.edu.cn","www.buptlib.com/","www.lib.dufe.edu.cn/","library.ncepu.edu.cn/","www.lib.scuec.edu.cn/","www.lib.szu.edu.cn/","www.lib.swufe.edu.cn/","www.las.ac.cn/","www.library.gxnu.edu.cn","www.lib.tongji.edu.cn","lib.ustc.edu.cn/","www.gmachineinfo.com/","www.hflib.gov.cn/","www.shhpl.com/","www.lib.gxu.edu.cn","www.library.sh.cn/","baike.sogou.com/","www.lib.cug.edu.cn/","202.120.121.193","lib.gzhu.edu.cn/","www.xmlib.net/","lib.cpu.edu.cn/","210.46.82.198/","libwww.njau.edu.cn","lib.shsmu.edu.cn/","lib.shutcm.edu.cn/","libweb.zju.edu.cn/","lib.ncwu.edu.cn/"};
    String u7="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;

    public Book46() {
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

   public String  n0(int b7){
       String url ;
        String x0=""+"http://www.5566.net/book.htm";
        String g5="2244.5566";
        String r0="=''+location.host;";
        String f5="=''+document.location;";
        String e4=""+"www.5566.net";
        String z7="9933.5566";
        int o0=e4.lastIndexOf('.');
        int y7=0+Integer.parseInt(String.valueOf(z7.charAt(1)));
        int i6=0+Integer.parseInt(String.valueOf(z7.charAt(2)));
        int k9=0+string2Unicode(String.valueOf(r0.charAt(5)));
        int a8=0+string2Unicode(String.valueOf(f5.charAt(6)));
        int h5=0+Integer.parseInt(String.valueOf(e4.charAt(o0-3)));
        int d0=0+Integer.parseInt(String.valueOf(e4.charAt(o0-1)));
        String k4="book";
        if(e4!="5566.net"&&e4!="www.5566.net"&&e4!="5566.org"&&e4!="1.5566.org"&&e4!="2.5566.org"&&e4!="3.5566.org"&&e4!="4.5566.org"&&e4!="5.5566.org"&&e4!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+m0[(b7-d0-y7-i6-k9-a8-15)/h5];
        }
        return   url;
    }

    public String  e8(int l1){
        String url;
        String k8=""+"http://www.5566.net/book.htm";
        String j3="1166.5566";
        String p7="=''+location.href;";
        String i2=""+"www.5566.net";
        String m1="=''+location.hostname;";
        String h2="3399.5566";
        int h9=i2.lastIndexOf('.');
        int z4=0+Integer.parseInt(String.valueOf(j3.charAt(0)));
        int o8=0+Integer.parseInt(String.valueOf(i2.charAt(h9-1)));
        int d2=0+string2Unicode(String.valueOf(p7.charAt(6)));
        int e3=0+Integer.parseInt(String.valueOf(i2.charAt(h9-3)));
        int a1=0+string2Unicode(String.valueOf(m1.charAt(5)));
        int e7=0+Integer.parseInt(String.valueOf(j3.charAt(3)));
        String h4="book";
        if(k8.indexOf("5566")==-1||k8.indexOf("book")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+m0[(l1-e3-z4-e7-a1-d2-95)/o8];
        }
        return  url;
    }
    public String  l0(int z5){
        String url ="";
        String y3=""+"www.5566.net";
        String n3="=''+document.URL;";
        String n1=""+"http://www.5566.net/book.htm";
        String x4="=''+document.domain;";
        String h2="6611.5566";
        String i4="4422.5566";
        int y1=y3.lastIndexOf('.');
        int  v1=0+Integer.parseInt(String.valueOf(y3.charAt(y1-3)));
        int m9=0+string2Unicode(String.valueOf(n3.charAt(6)));
        int x2=0+Integer.parseInt(String.valueOf(i4.charAt(1)));
        int v7=0+string2Unicode(String.valueOf(x4.charAt(5)));
        int i8=0+Integer.parseInt(String.valueOf(i4.charAt(2)));
        int m2=0+Integer.parseInt(String.valueOf(y3.charAt(y1-1)));
        String m8="book";
        if(n1.indexOf("5566")>=0&&n1.indexOf("book")>=0){
           url = "http://"+m0[(z5-v1-m2-i8-v7-m9-65)/x2];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("n0")) {
                    tmpUrl = n0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("e8")) {
                    tmpUrl = e8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("l0")) {

                    tmpUrl = l0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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




    public  void getBookUrls9(String url){


        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "教育";
        String tag2 ="图书_图书馆";
//        System.out.println(p.get(67));
        //16,26,35,44,67
        int[] numbers = {16,26,35,44,67};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }





    }

    public static void main(String[] args) {

        Book46 book46 = new Book46();
        book46.getBookUrls9("http://www.5566.net/book.htm");



    }




}
