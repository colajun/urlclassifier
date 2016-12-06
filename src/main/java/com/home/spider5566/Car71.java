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
 * Created by hadoop on 16-11-27.
 */
public class Car71 {

    String[] i6={"0","www.ferrari.cn/","car.autohome.com.cn/","www.faw-hongqi.com.cn/","www.feelcars.com/","www.273.cn/","www.gocar.cn/","www.csvw.com/","www.autohome.com.cn/bestauto/","www.nissan.com.cn/","car.bitauto.com/top_pingce/","goche.auto.sohu.com/cartest/","www.gac-toyota.com.cn/","www.52che.com/","club.autohome.com.cn/","www.bbac.com.cn/","www.shjtaq.com/gabl/jifen.asp","www.saicmotor.com/","www.king-long.com.cn/","labs.xgo.com.cn/","www.honda.com.cn/","baa.bitauto.com/","www.bydauto.com.cn/","price.pcauto.com.cn/","www.gaig.com.cn/","www.0755car.com/","www.infiniti.com.cn/","bbs.tianya.cn/list-cars-1.shtml","www.315che.com/","www.zuche.com/","www.hyundai.com/cn/zh/Main/index.html","www.cheshi.com/","www.audi.cn/","www.ftms.com.cn/","www.jxw.com.cn/","www.changheauto.com/","www.landrover.com.cn/","www.jeep.com.cn/","www.dyk.com.cn/","www.51auto.com/","www.autobaojun.com/","www.jxhld.gov.cn/biaozhi/biaozhi_11/","www.tjfaw.com/","www.carcav.com/","www.changan.com.cn/","www.peugeot.com.cn/","www.dongfeng-nissan.com.cn/","www.anav.com/","www.faw-benteng.com/","www.jac.com.cn/","www.renault.cn/","reviews.xgo.com.cn/","www.autohome.com.cn/","www.webcars.com.cn/","www.autoinfo.org.cn/","www.pcauto.com.cn/","www.skoda.com.cn/","www.brilliance-auto.com/","www.automarket.net.cn/","www.auto.hc360.com/","www.lexus.com.cn/","www.autohome.com.cn/suv/","www.51qc.com/","www.naveco.com.cn/","www.dpca.com.cn/","bbs.pcauto.com.cn/","www.autoweekly.com.cn/","www.zg2sc.cn/","www.dfmc.com.cn/","www.ijia360.com/","www.bitauto.com/","www.mercedes-benz.com.cn/","www.yemaauto.cn/","www.autohome.com.cn/d/","www.hbshauto.com/","www.gmchina.com/","www.pcauto.com.cn/pingce/","www.geely.com/","www.caam.org.cn/","www.autohome.com.cn/a0/","auto.qq.com/","www.volvocars.com/zh-CN/","www.mycar168.com/","www.mitsubishi-motors.com.cn/","www.heibao.com/","www.autofan.com.cn/","www.dongfeng-citroen.com.cn/","www.hawtaimotor.com/","www.faw.com.cn/","www.xici.net/Auto/","auto.21cn.com/","www.autohome.com.cn/s/","www.hafeiauto.com.cn/","www.subaru-china.com.cn/","www.zxauto.com.cn/","auto.people.com.cn/","car.bitauto.com/qichedaikuanjisuanqi/","www.gwm.com.cn/","www.jsyks.com/","www.taoche.com/","www.ford.com.cn/","www.autohome.com.cn/a00/","www.che168.com/","www.faw-vw.com/","www.sgmw.com.cn/","www.vw.com.cn/","www.beijing-hyundai.com.cn/","www.cadillac.com.cn/","auto.ifeng.com/","www.cnautonews.com/","www.baw.com.cn/","www.buick.com.cn/","auto.sina.com.cn/using/skill/index.shtml","www.qqycar.com/","www.fxauto.com.cn/","product.cheshi.com/price.html","www.chevrolet.com.cn/","www.chinacars.com/","auto.sina.com.cn/forum/index.shtml","www.haima.com/","www.dfpv.com.cn/","www.gocar.cn/price/","www.autobild.com.cn/","auto.sohu.com/","www.jmc.com.cn/","www.12365auto.com/","www.cn2che.com/","www.xgo.com.cn/","www.zotye.com/","www.bmw.com.cn/","www.porsche.com/china/","www.hx2car.com/","www.motortrend.com.cn/","www.autohome.com.cn/mpv/","auto.enet.com.cn/","auto.163.com/","www.xinhuanet.com/auto/","www.gaibar.com/","www.foton.com.cn/","www.autohome.com.cn/c/","dealer.auto.sina.com.cn/price/","www.gacfiatauto.com/","www.zznissan.com.cn/","www.sqgf.com.cn/","www.fblife.com/","price.xgo.com.cn/","www.autohome.com.cn/b/","www.ghac.cn/","www.changansuzuki.com/","www.careland.com.cn/","www.faw-mazda.com/","db.auto.sohu.com/price/","www.dongfeng-honda.com/","mobile.mapbar.com/","www.autohome.com.cn/a/","price.bitauto.com/","www.52car.net/","www.pcauto.com.cn/playcar/jsjq/10305/14910.html","www.shanghaigm.com/","www.chana-mazda.com.cn/","www.iautos.cn/","www.yescar.cn/","www.jinbei-auto.com/","www.xincheping.com/","www.toyota.com.cn/","www.1hai.cn/","www.jxedt.com/","www.chery.cn/","www.soueast-motor.com/"};
    String v0="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;
    public Car71(){
        try {
            jdbcTemplate = JDBCHelper.createMysqlTemplate("mysql1", "jdbc:mysql://192.168.21.60/urlclassifier?useUnicode=true&characterEncoding=utf8", "root", "root", 5, 30);

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


    public String  c7(int q4){
        String url = "";
        String f0="2266.5566";
        String i1=""+"www.5566.net";
        String u9="1144.5566";
        String o1=""+"http://www.5566.net/car-4.htm";
        String j9="=''+location.href;";
        String q6="=''+location.host;";
        int i8=i1.lastIndexOf('.');
        int z2=0+Integer.parseInt(String.valueOf(u9.charAt(2)));
        int j0=0+Integer.parseInt(String.valueOf(i1.charAt(i8-3)));
        int w7=0+Integer.parseInt(String.valueOf(i1.charAt(i8-1)));
        int g8=0+Integer.parseInt(String.valueOf(u9.charAt(0)));
        int e3=0+string2Unicode(String.valueOf(j9.charAt(6)));
        int y0=0+string2Unicode(String.valueOf(q6.charAt(5)));
        String f7="car";
        if(i1=="5566.net"||i1=="www.5566.net"||i1=="5566.org"||i1=="1.5566.org"||i1=="2.5566.org"||i1=="3.5566.org"||i1=="4.5566.org"||i1=="5.5566.org"||i1=="www.5566.org"){
           url = "http://"+i6[(q4-j0-g8-z2-y0-e3-32)/w7];
        }
        return  url;
    }
    public String y9(int y5){
        String url;
        String k3=""+"www.5566.net";
        String h2="8833.5566";
        String f0="4411.5566";
        String p2=""+"http://www.5566.net/car-4.htm";
        String h7="=''+document.location;";
        String b6="=''+document.domain;";
        int s7=k3.lastIndexOf('.');
        int q3=0+Integer.parseInt(String.valueOf(k3.charAt(s7-3)));
        int s0=0+Integer.parseInt(String.valueOf(k3.charAt(s7-1)));
        int n3=0+Integer.parseInt(String.valueOf(h2.charAt(2)));
        int i4=0+Integer.parseInt(String.valueOf(h2.charAt(1)));
        int m4=0+string2Unicode(String.valueOf(h7.charAt(6)));
        int b1=0+string2Unicode(String.valueOf(b6.charAt(5)));
        String y4="car";
        if(p2.indexOf("5566")==-1||p2.indexOf("car")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+i6[(y5-q3-s0-n3-b1-m4-51)/i4];
        }
        return  url;
    }
    public String  t5(int t1){
        String url;
        String f3="6622.5566";
        String l2="=''+document.URL;";
        String s8="=''+location.hostname;";
        String e9="3388.5566";
        String a5=""+"www.5566.net";
        String s5=""+"http://www.5566.net/car-4.htm";
        int y6=a5.lastIndexOf('.');
        int l0=0+Integer.parseInt(String.valueOf(a5.charAt(y6-1)));
        int e7=0+string2Unicode(String.valueOf(l2.charAt(6)));
        int t4=0+string2Unicode(String.valueOf(s8.charAt(5)));
        int  w4=0+Integer.parseInt(String.valueOf(f3.charAt(2)));
        int k8=0+Integer.parseInt(String.valueOf(a5.charAt(y6-3)));
        int r9=0+Integer.parseInt(String.valueOf(f3.charAt(0)));
        String k2="car";
        if(a5!="5566.net"&&a5!="www.5566.net"&&a5!="5566.org"&&a5!="1.5566.org"&&a5!="2.5566.org"&&a5!="3.5566.org"&&a5!="4.5566.org"&&a5!="5.5566.org"&&a5!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+i6[(t1-l0-r9-w4-t4-e7-10)/k8];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("c7")) {
                    tmpUrl = c7(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("y9")) {
                    tmpUrl = y9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("t5")) {

                    tmpUrl = t5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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



    public  void  getUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "生活";
        String tag2 = "汽车";
//        System.out.println(p.get(109));
//        //17,29, 45, 58, 71, 89, 100, 109
        int[] numbers = {17,29, 45, 58, 71, 89, 100, 109};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }





    }

    public static void main(String[] args) {

        Car71 car71 = new Car71();
        car71.getUrls("http://www.5566.net/car-4.htm");



    }







}
