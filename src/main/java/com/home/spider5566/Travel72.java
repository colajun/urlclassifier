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
public class Travel72 {

   String[]  h8={"0","www.easytour.cn/","www.toxihu.com/","www.taiyangdao.com.cn/","www.yooso.net/","www.shanghai-air.com/","www.dpm.org.cn/","www.aoyou.com/","club.travel.sohu.com/","www.nettvl.com/","www.8264.com/","www.shaolin.org.cn/","www.csair.com/","www.tripadvisor.cn/","www.ems517.com/","travel.mipang.com/","www.mafengwo.cn/","www.17u.net/","www.huashanly.com/","www.shenzhenair.com/","www.wuzhenyou.com/","www.cthy.com/","www.sunnychina.com/","www.hkcts.com/","www.traveler.com.cn/","www.quanjingke.com/","www.mangocity.com/","www.iqiyi.com/lvyou/","www.cnta.com/","travel.sohu.com/","www.8264.com/","www.satrip.com/","www.sanyatour.com/","www.qyer.com/","www.51yala.com/","www.wuyitravel.com/","www.sozhen.com/","www.gzl.com.cn/","www.huochepiao.com/","bbs.fblife.com/","www.xiamenair.com/","www.dili360.com/","www.yuanmingyuanpark.cn/","tour.19lou.com/","travel.163.com/","tuan.qunar.com/","www.lvye.cn/","www.hgscn.com/","www.jiuzhai.com/","www.scal.com.cn/","www.chinawts.com/","www.huway.com/","www.tuniu.com/","www.travelsky.com/","www.utourworld.com/","tttrip.online.sh.cn/","www.yocity.cn/","www.tiantanpark.com/","travel.go.qq.com/","www.e-beihai.net/","www.airchina.com.cn/","www.yododo.com/","bbs.carnoc.com/","www.ceair.com/","travel.news.cn/","www.goldenholiday.com/","www.ch.com/","www.flycua.com/","www.u365.com","www.xici.net/Travel/","www.izy.cn/","www.tourmart.cn/","bbs.lotour.com/","www.glhdq.com/","www.51766.com/","www.traveldaily.cn/","www.cits.cn/","www.5106.com/","www.jdair.net/","www.joy-air.com/","www.kuxun.com/","www.mount-tai.com.cn/","www.toptour.cn/","www.mingtombs.com/","www.hostelcn.com/","www.uzai.com/","www.travelsky.com/","www.tvtour.com.cn/","www.12306.cn/","www.5zls.org/","www.easytour.cn/","www.lvmama.com/","travel.sina.com.cn/bbs/","travel.sina.com.cn/","travel.qianlong.com/","www.snj.gov.cn/","www.travelzoo.com/cn/","bbs.8264.com/","www.ljgc.gov.cn/","www.cnair.com/","www.sh-holiday.com/","www.mipang.com","travel.china.com.cn/","www.xout.cn/","travel.xitek.com/","www.lvping.com/","travel.people.com.cn/GB/index.html","www.9tour.cn/","www.summerpalace-china.com/","www.xiangshanpark.com.cn/","www.cncn.com/","www.doyouhike.net/","www.7daysinn.cn/","www.topyoyo.com/","www.ctsho.com/","www.yododo.com/","www.lvping.com/","www.bjlyw.com/","www.ch.com/","www.bmy.com.cn/","www.jgstour.com/","www.xsbnly.com/","www.cnto.com/","www.juneyaoair.com/","www.qianshan.ln.cn/","www.chinalushan.com/","www.hwtao.com/","www.hnair.com/","www.lotour.com/","travel.tianya.cn/","www.guilin.com.cn/","www.17u.com/","www.shandongair.com.cn/","www.iuchina.cn/","www.1000islandlake.com/","bbs.dy7cd.com/","www.zjjok.com/","www.tianjin-air.com/","www.ems517.com/","www.carnoc.com/","www.airasia.com/cn/"};
    String q1="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;
    public Travel72(){
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

   public String  y6(int g5){
       String url ;
        String g1="=''+location.hostname;";
        String m9="=''+document.location;";
        String r3="9911.5566";
        String f3=""+"http://www.5566.net/travel1-.htm";
        String l5="7788.5566";
        String d5=""+"www.5566.net";
        int a5=d5.lastIndexOf('.');
        int m0=0+string2Unicode(String.valueOf(g1.charAt(5)));
        int x9=0+string2Unicode(String.valueOf(m9.charAt(6)));
        int x5=0+Integer.parseInt(String.valueOf(l5.charAt(2)));
        int y4=0+Integer.parseInt(String.valueOf(l5.charAt(1)));
        int g0=0+Integer.parseInt(String.valueOf(d5.charAt(a5-1)));
        int z4=0+Integer.parseInt(String.valueOf(d5.charAt(a5-3)));
        String  t0="travel1";

        if(d5!="5566.net"&&d5!="www.5566.net"&&d5!="5566.org"&&d5!="1.5566.org"&&d5!="2.5566.org"&&d5!="3.5566.org"&&d5!="4.5566.org"&&d5!="5.5566.org"&&d5!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+h8[(g5-z4-y4-x5-m0-x9-96)/g0];
        }
        return  url;
    }
   public String  d1(int z9){
       String url;
        String  c6="=''+location.host;";
        String o4="1199.5566";
        String f8=""+"http://www.5566.net/travel1-.htm";
        String f9="2244.5566";
        String s0="=''+document.URL;";
        String i0=""+"www.5566.net";
        int a6=i0.lastIndexOf('.');
        int h9=0+string2Unicode(String.valueOf(c6.charAt(5)));
        int u0=0+Integer.parseInt(String.valueOf(i0.charAt(a6-1)));
        int k6=0+Integer.parseInt(String.valueOf(o4.charAt(1)));
        int c9=0+Integer.parseInt(String.valueOf(o4.charAt(2)));
        int g2=0+string2Unicode(String.valueOf(s0.charAt(6)));
        int q6=0+Integer.parseInt(String.valueOf(i0.charAt(a6-3)));
        String i3="travel1";
        if(f8.indexOf("5566")==-1||f8.indexOf("travel1")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+h8[(z9-u0-k6-c9-h9-g2-87)/q6];
        }
        return  url;
    }
   public String  f0(int r5){
       String url = "";
        String w2=""+"www.5566.net";
        String r3="8877.5566";
        String d0="4422.5566";
        String z2="=''+location.href;";
       String  p9=""+"www.5566.net";
        String s5="=''+document.domain;";
        int u2=p9.lastIndexOf('.');
        int z6=0+Integer.parseInt(String.valueOf(d0.charAt(1)));
        int x6=0+Integer.parseInt(String.valueOf(d0.charAt(3)));
        int y3=0+Integer.parseInt(String.valueOf(p9.charAt(u2-1)));
        int v6=0+string2Unicode(String.valueOf(z2.charAt(6)));
        int r1=0+Integer.parseInt(String.valueOf(p9.charAt(u2-3)));
        int y5=0+string2Unicode(String.valueOf(s5.charAt(5)));
        String m3="travel1";
        if(w2.indexOf("5566")>=0&&w2.indexOf("travel1")>=0){
           url = "http://"+h8[(r5-r1-y3-x6-y5-v6-5)/z6];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("y6")) {
                    tmpUrl = y6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("d1")) {
                    tmpUrl = d1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("f0")) {

                    tmpUrl = f0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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


    public  void getUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "生活";
        String tag2 = "旅游";
//        System.out.println(p.get(93));
//        //20,32,51,61,73,83, 93
        int[] numbers = {20,32,51,61,73,83, 93};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }

    }
    public static void main(String[] args) {
        Travel72 travel72 = new Travel72();
        travel72.getUrls("http://www.5566.net/travel1-.htm");



    }











}
