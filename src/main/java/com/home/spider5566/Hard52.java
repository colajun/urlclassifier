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
public class Hard52 {
    String[] h8={"0","lab.yesky.com/","pc.beareyes.com.cn/bbs/","www.beareyes.com.cn/","www.mydigi.net/","group.zol.com.cn/","hardware.pchome.net/","www.spn.com.cn/","product.ccidnet.com/","www.3conline.net/","driver.zol.com.cn/","product.it168.com/","www.pcpop.com/","www.8080.net/","bbs.it168.com/","labs.zol.com.cn/","dl.pconline.com.cn/class/2.html","www.hasee.com/","drivers.enet.com.cn/","www.qdit.com/","www.thethirdmedia.com/","bbs.inknet.cn/","tech.china.com/zh_cn/hardware/index.html","mydown.yesky.com/driver/","zdc.zol.com.cn/","www.hn-pc.com/","www.zzit.com.cn/","www.itheat.com/","www.hwit.net/","detail.zol.com.cn/","digi.it.sohu.com/diy.shtml","www.jlit365.com/","www.hi-pda.com/forum/","drivers.qudong.com/","diy.yesky.com/","www.gpsuu.com/","www.icpcw.com/","top.zol.com.cn/","bbs.imp3.net/","www.epson.com.cn/","www.sosol.com.cn/","www.canon.com.cn/","www.oahelp.net/","www.zol.com.cn/","www.ksou.com.cn/","www.951it.com/","www.tomshardware.com/cn/","www.ncdiy.com/","www.szit.com.cn/","www.sony.com.cn/","www.lenovo.com.cn/","www.fydnc.com/","bbs.mydrivers.com/","www.enet.com.cn/lab/","www.msi-china.com.cn/","bbs.zol.com.cn/","tianjin.zol.com.cn/","product.pcpop.com/","product.pconline.com.cn/","www.sanhaostreet.com/","bbs.52hardware.com/","www.isso.com.cn/","www.3eit.com.cn/","www.henanbear.com/","itbbs.pconline.com.cn/","www.pconline.com.cn/tpylab/","www.itheat.com/","www.zhujiangroad.com/","xiamenit.com/","bbs.enet.com.cn/","www.91xiu.com/","www.beareyes.com.cn/2/data/bear/test/index.php","www.dnwx.com/","www.sxdn.com.cn/","www.it7t.com/","www.zhujiangroad.com/","www.roodoo.net/","www.chinafix.com/","www.e-wva.cn/","labs.pcpop.com/","www.samsung.com.cn/","www.fix.com.cn/","www.myprice.com.cn/","labs.it168.com/","www.bios.net.cn/","bbs.pcpop.com/","digi.163.com/","www.acer.com.cn/","www.zsdnw.com/","www.itsogo.net/","driver.it168.com/","www.dostor.com/","tech.sina.com.cn/hardware/","www.foundertech.com/","www.hkepc.com/","www.ithlj.com/","www.sdbear.com/","www.gigabyte.cn/","hardware.cfan.com.cn/","www.hp.com.cn/","www.it168.com/","www.dell.com.cn/","www.asus.com.cn/","www.pconline.com.cn/","www.sanhaojie.com/","www.veryol.com/","www.mydrivers.com/","www.hrbit.com/","www.fjzol.com/","www.sanhaostreet.com/","www.zenha.net/","drivers.mydrivers.com/","www.ibm.com.cn/","www.160.com/","www.myit365.com/","www.365it.com.cn/","bbs.cfanclub.net/"};
    String d6="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;

    public Hard52() {
        try {
            jdbcTemplate = JDBCHelper.createMysqlTemplate("mysql1", "jdbc:mysql://192.168.21.60/urlclassifier?useUnicode=true&characterEncoding=utf8", "root", "root", 5, 30);

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

   public String  c0(int f8){
       String url;
        String a1=""+"www.5566.net";
        String f7="=''+document.location;";
        String z1="1144.5566";
        String s7=""+"http://www.5566.net/hard1-6.htm";
        String s2="=''+location.hostname;";
        String p5="7799.5566";
        int l5=a1.lastIndexOf('.');
        int i5=0+Integer.parseInt(String.valueOf(a1.charAt(l5-3)));
        int c6=0+string2Unicode(String.valueOf(f7.charAt(6)));
        int l1=0+Integer.parseInt(String.valueOf(p5.charAt(2)));
        int b9=0+Integer.parseInt(String.valueOf(p5.charAt(1)));
        int c3=0+string2Unicode(String.valueOf(s2.charAt(5)));
        int x9=0+Integer.parseInt(String.valueOf(a1.charAt(l5-1)));
        String t2="hard1";
        if(a1!="5566.net"&&a1!="www.5566.net"&&a1!="5566.org"&&a1!="1.5566.org"&&a1!="2.5566.org"&&a1!="3.5566.org"&&a1!="4.5566.org"&&a1!="5.5566.org"&&a1!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+h8[(f8-x9-b9-l1-c3-c6-60)/i5];
        }
        return  url;
    }
    public String  q4(int r1){
        String url;
        String u1=""+"http://www.5566.net/hard1-6.htm";
        String h9=""+"www.5566.net";
        String z3="6655.5566";
        String o9="=''+location.host;";
        String o4="=''+location.href;";
        String b5="9977.5566";
        int a3=h9.lastIndexOf('.');
        int z6=0+Integer.parseInt(String.valueOf(z3.charAt(1)));
        int x6=0+Integer.parseInt(String.valueOf(h9.charAt(a3-3)));
        int o1=0+Integer.parseInt(String.valueOf(h9.charAt(a3-1)));
        int x3=0+string2Unicode(String.valueOf(o9.charAt(5)));
        int x7=0+string2Unicode(String.valueOf(o4.charAt(6)));
        int z4=0+Integer.parseInt(String.valueOf(z3.charAt(3)));
        String v7="hard1";
        if(u1.indexOf("5566")==-1||u1.indexOf("hard1")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+h8[(r1-x6-z6-z4-x3-x7-47)/o1];
        }
        return  url;
    }
    public String  z9(int e9){
        String url = "";
        String d0=""+"www.5566.net";
        String b5="5566.5566";
        String t9="=''+document.URL;";
        String t3="4411.5566";
        String g0=""+"http://www.5566.net/hard1-6.htm";
        String g8="=''+document.domain;";
        int b3=d0.lastIndexOf('.');
        int q3=0+Integer.parseInt(String.valueOf(d0.charAt(b3-3)));
        int g6=0+Integer.parseInt(String.valueOf(t3.charAt(3)));
        int m6=0+string2Unicode(String.valueOf(t9.charAt(6)));
        int g5=0+Integer.parseInt(String.valueOf(d0.charAt(b3-1)));
        int p9=0+Integer.parseInt(String.valueOf(t3.charAt(1)));
        int p7=0+string2Unicode(String.valueOf(g8.charAt(5)));
        String j1="hard1";
        if(g0.indexOf("5566")>=0&&g0.indexOf("hard1")>=0){
            url = "http://"+h8[(e9-q3-g5-g6-p7-m6-9)/p9];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("c0")) {
                    tmpUrl = c0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("q4")) {
                    tmpUrl = q4(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("z9")) {

                    tmpUrl = z9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

                }
            } catch (Exception e) {
                tmpUrl = href.attr("href");
                tmpName = href.text();
            }
            if (tmpUrl.length() >11) {

//                System.out.println(tmpUrl + "---------" + tmpName);

                inserTable(tag1, tag2, tmpUrl, tmpName);

            }
        }

    }



    public  void  getUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "电脑网络";
        String tag2 ="硬件";
//        System.out.println(p.get(107));
        //21,36,48,61,77,88,97,107
        int[] numbers = {21,36,48,61,77,88,97,107};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }




}


    public static void main(String[] args) {

        Hard52 hard52 = new Hard52();
      hard52.getUrls("http://www.5566.net/hard1-6.htm");



    }





}
