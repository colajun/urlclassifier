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
 * Created by hadoop on 16-11-21.
 */
public class Radio11 {
    String[] h2={"0","tv.cztv.com/broadcast","www.nydt.cn/","www.haikoutv.com/","www.jnnc.com/jnbc/","www.bbrtv.com/","radio.weibo.com/","www.jmradio.com/","fm894.sctv.com/","www.qhdgd.gov.cn/","www.tdm.com.mo/","fm1017.sctv.com/","www.radioluoyang.com/","www.jlradio.com.cn/","www.fj961.com/","www.radiohz.com/","www.huaihai.tv/","www.zohi.tv/","www.ccradio.cn/","www.lntv.com.cn/","www.fm955.com.cn/","www.zbradio.com/","www.sxrtv.com/","www.smg.cn/","minzu.cnr.cn/","www.nd1017.com/","www.fm1052.com.cn/","zuji.51.net/bcl/","www.fm987.com.cn/","www.zsbtv.com.cn/","www.ynradio.com/","www.sun0769.com/broadcast/","www.2cr.com.au/","www.qd897.com/","www.jzdt.com.cn/","www.hbtv.com.cn/","www.qhbtv.com/","www.am828.com.cn/","am603.rbc.cn/","www.yn-kmtv.com/","www.sqradio.com/","www.gzstv.com/","www.fm1036.com/","www.gntv.tv/","fm876.rbc.cn/","sports.rbc.cn/","www.vos.com.cn/","www.ncpbs.com/","www.qzgb.com/","www.yldt.com/","www.hfbtv.com/","www.suzhouradio.cn/","www.goofm.com/","www.fm971.net/","china.cnr.cn/","www.wxradio.cn/","www.fjzzfm.com/","www.hljradio.com/","www.hmdt.cn/","www.un.org/chinese/radio/","www.zzradio.cn/","finance.cnr.cn/","www.tytv.com.cn/","fm107.net/","www.nnradio.cn/","www.hdbs.cn/","www.fm95.com.cn/","www.tssv.cn/","www.syradio.cn/","www.fm1054.com/","www.syradio.cn/","www.hrbtv.net/","www.radiotj.com/","www.liangyou.net/","www.2300sjz.com/","v.iqilu.com/","www.nxtv.cn/","www.fm93.cn/","www.onlinexijiang.com/","www.bcc.com.tw/","1011.vojs.cn/","www.voh.com.tw/","hxradio.cnr.cn/","www.946.com.cn/","www.fm938.com.cn/","www.rbc.cn/","www.nihaotw.com/","www.bluehn.com/","www.gystv.com/","www.zhtv.com/","www.lyradio.com/","www.cztv.com/","fm900.sctv.com/","fm974.rbc.cn/","www.music887.com/","www.rthk.org.hk/","www.ahrtv.cn/","www.hnr.cn/","www.dltv.cn/","www.fm1012.com.cn/","www.cbg.cn/gbpl/","www.fm1039.com/","www.cdbs.com.cn/","www.fm914.com/","www.jxsrgb.com/","www.hugd.com/","www.njgb.com/","www.voanews.com/","www.fjgb.com/","www.czgd.tv/","www.fm918.net/","www.am1098.com/","www.fm936.com/","www.51tgb.com/","musicradio.cnr.cn/","newsradio.cri.cn/","www.sxtv.com.cn/","www.lzgd.com.cn/dt/","english.cri.cn/ce_easyfm/","www.ting9968.com/","www.jxgzdt.cn/","www.am810.net/","fm1026.sctv.com/","www.fm1047.cn/","www.sctv.com/","www.czbtv.com/","www.gxhzradio.com/","www.vojs.cn/","www.sxtvs.com/","www.xjbs.com.cn/guangbo/mw738/index.htm","www.bbc.co.uk/","www.strtv.cn/","fm955.sctv.com/","www.881903.com/","www.cri.cn/","www.e974.com/","www.rgd.com.cn/","www.whbc.com.cn/","www.nihaotw.com/","www.fsgd.com.cn/","www.tibetradio.cn/","radio.fjtv.net/fm1007/","sztv.cutv.com/radio/","www.btgdt.com/","wyzs.cnr.cn/","www.sebc.com.cn/","www.nmrb.cn/","www.tv935.com/client/html/11393/11393.html","www.fm918.cn/","fm1018.cnr.cn/","www.jxradio.cn/","www.nbtv.cn/","www.hebradio.com/","www.lzr.com.cn/","www.xjbs.com.cn/","www.tecsun.com.cn/","fm981.sctv.com/","www.am1116.com/","radio.jiaodong.net/","www.cprt.com.cn/","www.fm993.com.cn/","www.dhtv.cn/","www.hnradio.com/","www.chbcnet.com/","www.kiss.com.tw/","xmg.xmtv.cn/","www.ptbctv.com/","www.xxgbw.com/","am774.rbc.cn/","www.fyradio.com.cn/","www.cnr.cn/"};
    String o8="http://www.5566.org/indexe.htm";
    JdbcTemplate jdbcTemplate = null;
    public Radio11(){
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



    public String x6(int h8){
        String url ="";
        String c9=""+"www.5566.net";
        String z1="=''+location.host;";
        String i8="1133.5566";
        String e5=""+"http://www.5566.net/radio-1.htm";
        String g0="6677.5566";
        String x2="=''+document.location;";
        int x4=c9.lastIndexOf('.');
        int b0=0+Integer.parseInt(String.valueOf(c9.charAt(x4-3)));
        int e1=0+string2Unicode(String.valueOf(z1.charAt(5)));
        int d5=0+Integer.parseInt(String.valueOf(c9.charAt(x4-1)));
        int a3=0+Integer.parseInt(String.valueOf(i8.charAt(1)));
        int y6=0+Integer.parseInt(String.valueOf(i8.charAt(3)));
        int n7=0+string2Unicode(String.valueOf(x2.charAt(6)));
        String p1="radio";
        if(e5.indexOf("5566")>=0&&e5.indexOf("radio")>=0){
            url = "http://"+h2[(h8-d5-a3-y6-e1-n7-7)/b0];
        }
        return  url;
    }
   public String  l7(int t0){
       String url;
        String w6="9944.5566";
        String v6=""+"www.5566.net";
        String i9="=''+location.href;";
        String c4="=''+location.hostname;";
        String a6="7766.5566";
        String n5=""+"http://www.5566.net/radio-1.htm";
        int s7=v6.lastIndexOf('.');
        int k3=0+Integer.parseInt(String.valueOf(a6.charAt(3)));
        int m6=0+Integer.parseInt(String.valueOf(v6.charAt(s7-3)));
        int h4=0+string2Unicode(String.valueOf(i9.charAt(6)));
        int a7=0+string2Unicode(String.valueOf(c4.charAt(5)));
        int w8=0+Integer.parseInt(String.valueOf(v6.charAt(s7-1)));
        int j6=0+Integer.parseInt(String.valueOf(a6.charAt(1)));
        String j7="radio";
        if(n5.indexOf("5566")==-1||n5.indexOf("radio")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+h2[(t0-m6-w8-k3-a7-h4-30)/j6];
        }
        return  url;
    }
    public  String q3(int p6){
        String url ;
        String y2="4499.5566";
        String b1="=''+document.URL;";
        String e8="=''+document.domain;";
        String w6="3311.5566";
        String p7=""+"www.5566.net";
        String o1=""+"http://www.5566.net/radio-1.htm";
        int h7=p7.lastIndexOf('.');
        int x3=0+Integer.parseInt(String.valueOf(p7.charAt(h7-1)));
        int g2=0+string2Unicode(String.valueOf(b1.charAt(6)));
        int q5=0+string2Unicode(String.valueOf(e8.charAt(5)));
        int u0=0+Integer.parseInt(String.valueOf(y2.charAt(2)));
        int c5=0+Integer.parseInt(String.valueOf(p7.charAt(h7-3)));
        int y9=0+Integer.parseInt(String.valueOf(y2.charAt(1)));
        String w0="radio";
        if(p7!="5566.net"&&p7!="www.5566.net"&&p7!="5566.org"&&p7!="1.5566.org"&&p7!="2.5566.org"&&p7!="3.5566.org"&&p7!="4.5566.org"&&p7!="5.5566.org"&&p7!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+h2[(p6-c5-y9-u0-q5-g2-73)/x3];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("q3")) {
                    tmpUrl = q3(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("l7")) {
                    tmpUrl = l7(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("x6")) {

                    tmpUrl = x6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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


    public  void getRadioUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "新闻媒体";
        String tag2 =" 广播电台";
//        System.out.println(p.get(20));
        //22, 23,24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 42, 55, 65,81,99
        int[] numbers = {20};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }


    }


    public static void main(String[] args) {

        Radio11 radio11 = new Radio11();

        radio11.getRadioUrls("http://www.5566.net/radio-1.htm");

    }







}
