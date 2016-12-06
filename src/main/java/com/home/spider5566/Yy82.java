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
public class Yy82 {

   String[]  s6={"0","www.shanling.com/","www.51erji.com/","www.qisheng.com.cn/","www.kef.com/html/cn/index.html","www.hyhifi.com/","www.denon.com.cn/","www.shengya-audio.com/","www.hosaudio.com/","www.choseal.cn/","www.mshi-fi.cn/","www.hifi-china.com/","www.erji.net/","www.avmagazine.com/","www.erji.net/","www.audio160.com/","www.hifi168.com/","www.caiacn.com/","www.shinco.com/","www.focal.com/cn/","www.avance.com.cn/","www.facs.com.cn/","www.fidek.com.cn/","bbs.gzhifi.com/","www.jxmst.com/","www.hi-fi.com.cn/","www.jvc.com.cn/","www.gdbbk.com/","bbs.whaudio.com/","www.audionet.com.tw/","www.hifi10000.com/","smart.zol.com.cn/","panasonic.cn/","www.tcl.com/","www.blaudio.com.cn/","www.tonewinner.com/","www.badahi-fi.com/","www.sthifi.com/","www.dussun.com/","www.av-2000.com/","www.changye.com.cn/bbs/","www.avfline.com/","www.pioneerchina.com/","www.szaudio.com/","www.elac-china.com/","www.cn-cav.com/","www.grandhigh.cn/","www.china-hushan.com/","www.jd-bbs.com/forum-26-1.html","www.bose.cn/","www.hifidiy.net/","www.avworld.cn/","www.lovehifi.com/","www.malata.com/","www.jd-bbs.com/forum-27-1.html","www.sharp.cn/","pc.beareyes.com.cn/bbs/a.htm","www.21hifi.com/","www.av220.com/","www.ca001.com/forum.php","www.edifier.com/","www.audioprc.com/","bbs.hifidiy.net/","www.microlab.com.cn/","www.aiyinpin.com/","www.av169.com/","bbs.hifi168.com/","www.yamaha.com.cn/","www.audio01.com/","www.haihuang-audio.com/","www.hdlt.com/","www.tubebbs.com/","www.sony.com.cn/","www.chpo.cn/","www.audionet.com.tw/","www.lanlian-sherwood.com/","cn.creative.com/","www.hifi-elite.com/","www.ykaudio.com.hk/","www.tannoy.com/","www.klipsch.com/","www.changye.com.cn/","www.dali-speaker.cn/","www.xindak.com/","www.sparkaudio.com/","www.jamo.com/","bbs.dalaba.me/","www.sendsound.cn/","audioart.audionet.com.tw/","www.bowers-wilkins.cn/","www.dynaudio.com.cn/","www.dugood.com/","www.hivi.com/","www.carwto.com/","www.operaudio.com.cn/","www.whaudio.com/","hifi.gxcnc.net/","www.audio-audio.com/","www.mission.co.uk/","www.sansui.com.cn/","www.xycad.com/","www.boleyx.com/","www.pjtime.com/audio/","www.av.hc360.com/","www.av199.net/","www.marantz.com.cn/","www.new-audiophile.com/","www.mei-xing.com/","www.cn.onkyo.com/","www.audiotechnique.com/","www.lite8.com/","www.hifime.net/","www.ca001.com/","www.av199.com/","www.sastav.com/","www.av001.com/","www.accuphase.com/","www.audio-lee.com/","cn.jbl.com/","www.hdavchina.com/","www.yindi.com/","www.headphoneclub.com/","www.avlight.com/"};
    String o2="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public Yy82(){
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


    public String  p1(int b8){
        String url;
        String l5=""+"www.5566.net";
       String  a5="=''+location.hostname;";
        String n0="5588.5566";
        String p8=""+"http://www.5566.net/yy-3.htm";
        String m5="1199.5566";
        String c1="=''+document.URL;";
        int l2=l5.lastIndexOf('.');
        int e0=0+Integer.parseInt(String.valueOf(l5.charAt(l2-3)));
        int n6=0+string2Unicode(String.valueOf(a5.charAt(5)));
        int l4=0+Integer.parseInt(String.valueOf(m5.charAt(3)));
        int m1=0+Integer.parseInt(String.valueOf(m5.charAt(0)));
        int w2=0+Integer.parseInt(String.valueOf(l5.charAt(l2-1)));
        int c2=0+string2Unicode(String.valueOf(c1.charAt(6)));
        String u4="yy";
        if(p8.indexOf("5566")==-1||p8.indexOf("yy")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+s6[(b8-w2-m1-l4-n6-c2-59)/e0];
        }
        return  url;
    }
    public String  k1(int s7){
        String url;
        String k3="=''+document.domain;";
        String k6="=''+location.href;";
        String g3="3377.5566";
        String h2=""+"http://www.5566.net/yy-3.htm";
        String x4=""+"www.5566.net";
        String i5="9911.5566";
        int d2=x4.lastIndexOf('.');
        int m9=0+string2Unicode(String.valueOf(k3.charAt(5)));
        int r1=0+string2Unicode(String.valueOf(k6.charAt(6)));
        int y4=0+Integer.parseInt(String.valueOf(x4.charAt(d2-1)));
        int h8=0+Integer.parseInt(String.valueOf(g3.charAt(1)));
        int k2=0+Integer.parseInt(String.valueOf(x4.charAt(d2-3)));
        int h4=0+Integer.parseInt(String.valueOf(g3.charAt(3)));
        String a0="yy";
        if(x4!="5566.net"&&x4!="www.5566.net"&&x4!="5566.org"&&x4!="1.5566.org"&&x4!="2.5566.org"&&x4!="3.5566.org"&&x4!="4.5566.org"&&x4!="5.5566.org"&x4!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+s6[(s7-k2-h8-h4-m9-r1-43)/y4];
        }
        return  url;
    }
    public String  z9(int v8){
        String url = "";
        String g0="=''+document.location;";
        String w3="8855.5566";
        String q6=""+"www.5566.net";
        String r6=""+"http://www.5566.net/yy-3.htm";
        String i5="7733.5566";
        String i2="=''+location.host;";
        int o1=q6.lastIndexOf('.');
        int x2=0+string2Unicode(String.valueOf(g0.charAt(6)));
       int v7=0+Integer.parseInt(String.valueOf(q6.charAt(o1-1)));
        int w9=0+Integer.parseInt(String.valueOf(q6.charAt(o1-3)));
        int c6=0+Integer.parseInt(String.valueOf(w3.charAt(0)));
        int i1=0+Integer.parseInt(String.valueOf(w3.charAt(3)));
        int s1=0+string2Unicode(String.valueOf(i2.charAt(5)));
        String d8="yy";
        if(q6=="5566.net"||q6=="www.5566.net"||q6=="5566.org"||q6=="1.5566.org"||q6=="2.5566.org"||q6=="3.5566.org"||q6=="4.5566.org"||q6=="5.5566.org"||q6=="www.5566.org"){
           url = "http://"+s6[(v8-w9-v7-i1-s1-x2-18)/c6];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("p1")) {
                    tmpUrl = p1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("k1")) {
                    tmpUrl = k1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("z9")) {

                    tmpUrl = z9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
        String tag2 = "家电 -> 影音/音响";
//        System.out.println(p.get(77));
        //17,38, 57,77
        int[] numbers = {17,38, 57,77};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }



    }

    public static void main(String[] args) {
        Yy82 yy82 = new Yy82();
        yy82.getUrls("http://www.5566.net/yy-3.htm");



    }




}
