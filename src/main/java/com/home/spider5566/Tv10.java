package com.home.spider5566;

import com.home.spring.JDBCHelper;
import org.apache.spark.mllib.clustering.PowerIterationClustering;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;

/**
 * Created by hadoop on 16-11-21.
 */
public class Tv10 {
    String[] b6={"0","www.bluehn.com/","www.sybtv.com.cn/","www.szmg.com.cn/","www.sxrtv.com/","www.fetv.cn/","www.0515yc.cn/","www.sxrtv.com/","www.aktv.com.cn/","www.hljtv.com/","www.zxtv.com.cn/","www.sun0769.com/tv/","www.cntv.cn/","www.kftv.net.cn/","www.jmtv.com.cn/","www.xjtvs.com.cn/","www.hgitv.com/","www.cditv.cn/","www.gntv.tv/","www.yananbtv.com/","www.aqbtv.cn/","www.fjtv.net/","v.ahtv.cn/live/","www.hntv.tv/","www.hbtv.com.cn/","www.setv.sh.cn/","www.jetv.net/","www.yzntv.com/","www.xttv.com.cn/","zhibo.ijntv.cn/","www.kmtv.com.cn/","www.xmg.com.cn/","www.hebtv.com/wlzb/","www.ahbbtv.com/","www.nmtv.cn/","top.iqiyi.com/dianshiju.html","www.iqiyi.com/dianshiju/","www.ptbtv.com/","live.wasu.cn/","v.sogou.com/top/teleplay/index.html","www.czbtv.com/","www.qtv.com.cn/","www.zetv.com.cn/","www.nbs.cn/","www.hkatv.com/","www.zohi.tv/","ent.qq.com/tv/","www.cntv.cn/","www.hfcatv.com.cn/","zz.cutv.com/live/","www.jxntv.cn/","www.hebtv.com/","www.qhdgd.gov.cn/","www.hebitv.com/","www.centv.cn/","v.xiancity.cn/","nc.cutv.com/","www.lntv.com.cn/","www.nntv.cn/live/nntv_xw/","www.sdtv.com.cn/","www.hbtv.com.cn/","www.gzstv.com/","www.jxntv.cn/","www.sctv.com/","www.matv.com.hk/","www.lytv.com.cn/","www.hydst.com/","www.cntv.cn/","www.lztv.tv/","www.sdtv.com.cn/","www.ftv.com.tw/","movie.kankan.com/top/teleplay.html","www.bctv.com.cn/","www.tvcn.com.cn/","www.gltvs.com/","www.gdmztv.com/","www.jiaodong.net/av/","www.0745tv.com/","www.sdetv.com.cn/","www.gxtv.com.cn/","www.wxtv.cn/","www.hzcatv.com.cn/","www.xctv.cn/","www.i-cable.com/","tv.sohu.com/hotteleplay/","www.aniworld.tv/","www.zztv.tv/","www.qhstv.com/","www.nmtv.cn/vod/index.shtml","www.hljtv.com/","www.yntv.cn/","v.yntv.cn/live_yntv1_2013.shtml","www.juchang.com/tv/","www.tv373.com/","www.brtn.cn/","www.macaucabletv.com/","live.tv.sohu.com/","www.sqtv.net/","www.lzgd.com.cn/","dianshiju.cntv.cn/","www.fjtv.net/folder496/folder351/","www.qtv.com.cn/","www.sctv.cn/live/SCTV1/","www.hrbtv.net/","www.yxtv.cn/","tv.56.com/","v.iqilu.com/","www.tvsou.com/","zixun.hunantv.com/","www.qztv.cn/","tv.cztv.com/","nb.cutv.com/","www.videoland.com.tw/","www.liaozhai.tv/","www.tstv.cn/","ent.163.com/tv/","www.xltv.com.cn/","www.zsgd.com/","www.ywgd.com/","www.goldia.cn/","www.sctv.com/","www.dltv.cn/","www.hcrt.cn/","www.hoolo.tv/live/","www.nytv.com.cn/","live.pptv.com/list/tv_list","www.ctv.com.tw/","www.cts.com.tw/","www.jinjiang.tv/","www.xingkong.com.cn/","www.luzhoutv.com/","www.jiyuan.tv/","www.tjtv.com.cn/","www.lstv.net.cn/","zixun.hunantv.com/","tv.kankan.com/","www.cztv.cc/","www.cetv.com/","www.fstv.com.cn/","ent.sina.com.cn/tv/","video.sina.com.cn/movie/category/teleplay/index.html","ty.cutv.com/live/","live.snrtv.com/","www.fengyunzhibo.com/","www.dzxw.net/dztv/","www.brtn.cn/","www.whtv.com.cn/","www.hntv.tv/","www.yichuntv.com/","tv.cntv.cn/live","yule.sohu.com/tv.shtml","www.hbsztv.com/","www.2300sjz.com/live/","www.setv.com.cn/","tv.pptv.com/","www.hoolo.tv/","www.21cs.cn/","www.ahtv.cn/","v.qq.com/tv/","bzgd.bzgd.com/","www.jxgztv.com/","www.jxntv.cn/live/index.shtml","www.tvbpayvision.com/","www.lntv.cn/","www.ahbztv.com/","v.ifeng.com/live/","www.hljtv.com/live/","v.sogou.com/vc/live","www.jnetv.cn/","www.syiptv.com/","www.gstv.com.cn/folder3/","www.gztv.com/","www.pts.org.tw/","www.jcbctv.com/","gd.dhtv.cn/","www.scnj.tv/","www.yhtv.com.cn/","tv.jznews.com.cn/","www.hbtv.com.cn/zb/201504/t20150410_1241175.html","www.gatv.com.cn/","www.strtv.cn/","www.bhtv.cc/","www.zsbtv.com.cn/","www.tctc.com.cn/","www.jilintv.cn/","www.tjtv.com.cn/","www.gystv.com/","tv.cutv.com/","www.yntv.cn/","www.jlntv.cn/folder430/","www.gzstv.com/","www.cbg.cn/","www.mmstw.com/","www.bjsytv.com/","www.tytv.com.cn/","www.0471tv.com/","www.hntv.tv/live.shtml","live.jstv.com/","www.mptv.com.cn/","www.ytgdw.com/yttv/","www.lhetv.com/","www.njcatv.net/","www.jmtv.cn/","v.xiancity.cn/","tv.sohu.com/drama/","www.asiatvro.com/","tv.cntv.cn/epg","www.wetv.com.cn/","www.gztv.com/live/gz/index.htm","www.jxetv.com/","www.fjtv.net/","www.gdcatv.com.cn/","www.cbg.cn/live/","www.cprt.com.cn/","www.liuyangtv.com.cn/","www.gdtv.cn/","v.qq.com/live/","www.nmtv.cn/","www.smg.cn/","tv.tudou.com/","www.ifeng.com/","www.jstv.com/","www.xytv.cn/","tv.cnxiantao.com/","www.chinactv.com/","v.xyrtv.com/","www.jilintv.com.cn/","star.gdtv.cn/","www.sxtv.com.cn/","www.aqcatv.com.cn/","www.nxtv.cn/","top.letv.com/tvhp.html","www.tvb.com/","www.hztvs.cn/","www.ybtv.cc/","www.bntv.cn/","www.qz123.com/","xzgd.huaihai.tv/","www.ptbctv.com/","www.cditv.cn/html/cdrtv/#live","www.gdtv.cn/","www.jxjatv.com/","www.gdhytv.com/","www.zztv.fj.cn/","www.nxtv.cn/","www.lntv.com.cn/","www.cztv.tv/","www.lijiangtv.com/","zixun.hunantv.com/","www.sxtvs.com/","www.zttv.cn/","www.tdm.com.mo/","www.ijntv.cn/","www.weihai.tv/","www.ttv.com.tw/","www.cztv.com/","www.2300sjz.com/","www.sxtvs.com/","live.imgo.tv/","metv.mdjedu.net/","www.gxtv.com.cn/","www.gdvnet.com/","www.ahtv.cn/","gdj.wuhai.gov.cn/","www.ifeng.com/","www.tvscn.com/","www.smgbb.cn/tv/","www.hncstv.com/","www.haikoutv.com/","tv.letv.com/","www.cetv.com/","www.zjjs.net/","www.hunantv.com/","www.hfbtv.com/","cn.iybtv.com/","e.cztv.com/","www.cbg.cn/","www.lxgbtv.com/","www.yltvb.com/","www.gntv.tv/","www.hebtv.com/","www.sgbtv.gov.cn/","www.dragontv.cn/","www.bluehn.com/","www.jj-tv.com/","www.jmtv.cn/","www.jletv.cn/","www.prtv.tv/","www.s1979.com/tv/sztv.shtml","www.xntv.tv/","www.womantv.tv/","www.tvmao.com/","www.xjtvs.com.cn/","www.zhtv.com/","www.csytv.com/","www.ifeng.com/","www.lstv.com.cn/","ettv.ebc.net.tw/","www.nbs.cn/live/","www.ifeng.com/","tv.gxtv.cn/","www.smg.cn/","www.tudou.com/top/r30c.html","www.cztv.com/live","www.tielingtv.com/","www.zjstv.com/","www.smg.cn/","tv.hshan.com/","www.cztv.com/","www.centv.cn/","www.jstv.com/","www.nntv.cn/"};
    String u3="http://www.5566.org/indexe.htm";
    JdbcTemplate jdbcTemplate = null;
    public Tv10(){
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




   public String  s7(int v5){
       String url = "";
        String k4="=''+location.href;";
        String g1="2233.5566";
        String u4="4477.5566";
        String i2=""+"www.5566.net";
        String u0="=''+location.hostname;";
        String y5=""+"http://www.5566.net/tv-1.htm";
        int t3=i2.lastIndexOf('.');
        int h5=0+string2Unicode(String.valueOf(k4.charAt(6)));
        int f9=0+Integer.parseInt(String.valueOf(i2.charAt(t3-1)));
        int x2=0+Integer.parseInt(String.valueOf(g1.charAt(2)));
        int i6=0+Integer.parseInt(String.valueOf(i2.charAt(t3-3)));
        int t5=0+string2Unicode(String.valueOf(u0.charAt(5)));
        int v3=0+Integer.parseInt(String.valueOf(g1.charAt(0)));
        String r9="tv";
        if(i2=="5566.net"||i2=="www.5566.net"||i2=="5566.org"||i2=="1.5566.org"||i2=="2.5566.org"||i2=="3.5566.org"||i2=="4.5566.org"||i2=="5.5566.org"||i2=="www.5566.org"){
            url = "http://"+b6[(v5-i6-v3-x2-t5-h5-87)/f9];
        }
         return  url;
    }
  public String  y1(int w7){
      String url ;
        String m9=""+"http://www.5566.net/tv-1.htm";
        String y2=""+"www.5566.net";
        String t6="1155.5566";
        String w4="=''+document.location;";
        String e6="=''+document.domain;";
        String t1="7744.5566";
        int i9=y2.lastIndexOf('.');
        int q2=0+Integer.parseInt(String.valueOf(t1.charAt(0)));
        int y9=0+Integer.parseInt(String.valueOf(y2.charAt(i9-3)));
        int w9=0+Integer.parseInt(String.valueOf(t1.charAt(2)));
        int i5=0+string2Unicode(String.valueOf(w4.charAt(6)));
        int a0=0+string2Unicode(String.valueOf(e6.charAt(5)));
        int w1=0+Integer.parseInt(String.valueOf(y2.charAt(i9-1)));
        String t4="tv";
        if(m9.indexOf("5566")==-1||m9.indexOf("tv")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+b6[(w7-w1-q2-w9-a0-i5-53)/y9];
        }
        return  url;
    }
   public String  k1(int j0){
       String url;
        String j2=""+"http://www.5566.net/tv-1.htm";
        String q4=""+"www.5566.net";
        String h4="=''+document.URL;";
        String z9="5511.5566";
        String h3="=''+location.host;";
        String u4="3322.5566";
        int v2=q4.lastIndexOf('.');
        int p8=0+Integer.parseInt(String.valueOf(z9.charAt(0)));
        int q8=0+Integer.parseInt(String.valueOf(q4.charAt(v2-3)));
        int n0=0+string2Unicode(String.valueOf(h4.charAt(6)));
        int p6=0+Integer.parseInt(String.valueOf(q4.charAt(v2-1)));
        int d1=0+string2Unicode(String.valueOf(h3.charAt(5)));
        int j4=0+Integer.parseInt(String.valueOf(z9.charAt(2)));
        String l0="tv";
        if(q4!="5566.net"&&q4!="www.5566.net"&&q4!="5566.org"&&q4!="1.5566.org"&&q4!="2.5566.org"&&q4!="3.5566.org"&&q4!="4.5566.org"&&q4!="5.5566.org"&&q4!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
          url = "http://"+b6[(j0-q8-p6-j4-d1-n0-47)/p8];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("k1")) {
                    tmpUrl = k1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("y1")) {
                    tmpUrl = y1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("s7")) {

                    tmpUrl = s7(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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

    public  void getTvUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "新闻媒体";
        String tag2 ="电视/电视台";
//        System.out.println(p.get(22));
        //22, 23,24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 42, 55, 65,81,99
        int[] numbers = {22, 23,24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 42, 55, 65,81,99};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }





    }


    public static void main(String[] args) {

        Tv10 tv10 = new Tv10();
        tv10.getTvUrls("http://www.5566.net/tv-1.htm");





    }







}
