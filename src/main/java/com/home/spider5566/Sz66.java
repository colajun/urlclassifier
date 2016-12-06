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
 * Created by hadoop on 16-11-27.
 */
public class Sz66 {
    String[] h7={"0","www.busen-group.com/","www.yearcon.cn/","www.montagut.com/","www.fumin.com/","www.xiansiniao.com.cn/","www.nanjiren.com.cn/","www.ne.ef360.com/","dress.pclady.com.cn/","www.sh-gujin.com/","www.chinasspp.com/","lady.qq.com/style/dress.shtml","www.sendagroup.com/","www.semir.com/","www.yalu.com/","www.anta.com/","www.yfu.cn/","www.sundance.com.cn/","www.dongyi.com/","www.nanjiren.com.cn/","www.langshaunderwear.com/","www.cnwear.com/","www.cntxw.com/","www.jinhou.com/","www.acshoes.com/","www.trands.com/","www.51kids.com/","www.chinabaina.com/","fashion.ifeng.com/trends/","www.sinoef.com/","www.chinaab.com/","www.embryform.com/","www.humen.com/","www.maniform.cn/","www.chinaab.com/","www.qipai.com/","www.huite.com/","www.hnwbl.com/","www.87ka.com/","www.361sport.com/","www.mailyard.com.cn/","www.ritai.com/","www.xidelang.com.cn/","www.septwolves.com/","www.worldsocks.com/","www.cnhqt.com/","www.threegun.com.cn/","www.61kids.com.cn/","fashion.ce.cn/","www.yaya.com.cn/","www.fordoo.cn/","fashion.rayli.com.cn/","www.efp8.com/","www.cnxz.cn/","www.hongdou.com.cn/","www.kangnai.net/","www.gihooo.com/","www.qqshoes.com/","www.yishion.com/","www.tonlion.com/","www.bosideng.com/","www.yisiaila.in/","www.shoemachinery.net/","www.cnga.org.cn/","www.k-boxing.com/","www.kaiser.com.cn/","www.shanshan.com/","www.inshoes.cn/","www.oleno.com.cn/","www.peaksport.com/","www.sh-oca.com/","www.xiansiniao.com.cn/","www.kinglike.cn/","www.easterncamel.com/","fushi.163.com/","www.ppsj.com.cn/v/index1.html","www.fapai.com/","www.longdafei.com/","www.xtep.com.cn/","www.china-ef.com/","www.shanghai-style.com/","www.chinazzw.com/","www.kangnai.com/","corp.metersbonwe.com/","www.yeliya.cn/","www.stava.cn/","www.redcollar.com.cn/","www.baoxiniao.com.cn/","www.romon.com/","women.sohu.com/fashion.shtml","www.harson.com.cn/","ef.china.alibaba.com/ef.html","www.vifo.com.cn/","www.nyi.com.cn/","www.chinaerdos.com/","www.e-swear.cn/","www.kipone.com.cn/","www.wzxieji.com/","www.pop-fashion.com/","www.shoeschina.net/","www.st-edenw.com/","www.jewelchina.com/","www.cntries.com/","www.sunflora.com.cn/","www.chinajierda.com/","www.belle.com.cn/","www.xietu.com/","www.chinashoes.com/","www.youngor.com/","www.ne365.com/","www.nzw.cn/","www.smartgarments.com/","www.aokang.com/","www.evefashion.com/","www.plandoo.com/","www.ef360.com/","luxury.qq.com/fushi.htm","www.eeff.net/","www.meike-shoes.com/","www.fuguiniao.com/","www.binyinu.com/","www.chinajifa.com/","www.qiaodan.com.cn/","www.wlxyw.com/","www.judger.com.cn/","www.zmnco.com/","www.51fashion.com.cn/","www.jiumuwang.com/","www.51haojob.com/","www.cfw.cn/","www.shoes.net.cn/","www.maniform.cn/","www.fus.com.cn/","www.fuguiniao.com/","www.52moda.com/","www.169zx.com/","yesee.qianlong.com/clothing.htm","www.hengda-group.com/","www.kazhumi.com/","www.neyee.com/","www.shiqi.com.cn/","www.mulinsen.com/","www.cfw.com.cn/","www.chinaqinman.com/","www.yifu.com/","www.efu.com.cn/","www.cloth.hc360.com/","www.bejirog.com/","www.aimer.com.cn/","ebrand.fuzhuang.1688.com/"};
    String t3="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;

    public Sz66() {
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




   public String  t9(int n4){
       String url = "";
        String j7="=''+location.hostname;";
        String z4=""+"http://www.5566.net/sz-3.htm";
        String x9="=''+document.URL;";
        String i9="5599.5566";
        String n6=""+"www.5566.net";
        String w4="8866.5566";
        int b0=n6.lastIndexOf('.');
        int a8=0+string2Unicode(String.valueOf(j7.charAt(5)));
        int i3=0+Integer.parseInt(String.valueOf(w4.charAt(1)));
        int g8=0+string2Unicode(String.valueOf(x9.charAt(6)));
        int s8=0+Integer.parseInt(String.valueOf(w4.charAt(2)));
        int y4=0+Integer.parseInt(String.valueOf(n6.charAt(b0-3)));
        int j8=0+Integer.parseInt(String.valueOf(n6.charAt(b0-1)));
        String k3="sz";
        if(n6=="5566.net"||n6=="www.5566.net"||n6=="5566.org"||n6=="1.5566.org"||n6=="2.5566.org"||n6=="3.5566.org"||n6=="4.5566.org"||n6=="5.5566.org"||n6=="www.5566.org"){
            url = "http://"+h7[(n4-y4-j8-s8-a8-g8-15)/i3];
        }
        return  url;
    }
   public String  j4(int a2){
       String url ;
        String u4="=''+document.location;";
        String u0="1144.5566";
        String c1="6688.5566";
        String x0=""+"http://www.5566.net/sz-3.htm";
        String w0=""+"www.5566.net";
        String q0="=''+document.domain;";
        int r9=w0.lastIndexOf('.');
        int g9=0+string2Unicode(String.valueOf(u4.charAt(6)));
        int j9=0+Integer.parseInt(String.valueOf(w0.charAt(r9-1)));
        int d6=0+Integer.parseInt(String.valueOf(u0.charAt(3)));
        int r5=0+Integer.parseInt(String.valueOf(u0.charAt(0)));
        int o2=0+Integer.parseInt(String.valueOf(w0.charAt(r9-3)));
        int f3=0+string2Unicode(String.valueOf(q0.charAt(5)));
        String b5="sz";
        if(x0.indexOf("5566")==-1||x0.indexOf("sz")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+h7[(a2-j9-r5-d6-f3-g9-56)/o2];
        }
        return  url;
    }
   public String  s2(int c8){
       String url;
        String p1="9955.5566";
        String i9="4411.5566";
        String u3=""+"http://www.5566.net/sz-3.htm";
        String c5="=''+location.href;";
        String b9=""+"www.5566.net";
        String k7="=''+location.host;";
        int c4=b9.lastIndexOf('.');
        int l7=0+Integer.parseInt(String.valueOf(b9.charAt(c4-1)));
        int s9=0+Integer.parseInt(String.valueOf(p1.charAt(2)));
        int g1=0+Integer.parseInt(String.valueOf(p1.charAt(0)));
        int i7=0+string2Unicode(String.valueOf(c5.charAt(6)));
        int p5=0+Integer.parseInt(String.valueOf(b9.charAt(c4-3)));
        int x6=0+string2Unicode(String.valueOf(k7.charAt(5)));
        String i0="sz";
        if(b9!="5566.net"&&b9!="www.5566.net"&&b9!="5566.org"&&b9!="1.5566.org"&&b9!="2.5566.org"&&b9!="3.5566.org"&&b9!="4.5566.org"&&b9!="5.5566.org"&&b9!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+h7[(c8-p5-g1-s9-x6-i7-3)/l7];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("t9")) {
                    tmpUrl = t9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("j4")) {
                    tmpUrl = j4(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("s2")) {

                    tmpUrl = s2(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

                }
            } catch (Exception e) {
                tmpUrl = href.attr("href");
                tmpName = href.text();
            }
            if (tmpUrl.length() >12) {

//                System.out.println(tmpUrl + "---------" + tmpName);

                inserTable(tag1, tag2, tmpUrl, tmpName);

            }
        }

    }

    public  void  getUrls(String url){

        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "生活";
        String tag2 = "服装_服饰";
//        System.out.println(p.get(66));
        //16, 33,54, 66
        int[] numbers = {6, 33,54, 66};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);
        }




    }


    public static void main(String[] args) {

        Sz66 sz66 = new Sz66();
        sz66.getUrls("http://www.5566.net/sz-3.htm");





    }







}
