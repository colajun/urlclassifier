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
 * Created by hadoop on 16-11-25.
 */
public class Download59 {
    String[] u4={"0","www.kaspersky.com.cn/","www.kugou.com/","www.onlinedown.net/","www.tucows.com/","dl.xunlei.com/","www.ludashi.com/","www.avira.cn/zh-cn/","www.neoimaging.cn/","skype.gmw.cn/","www.microsoft.com/zh-cn/windows/windows-10-upgrade","im.qq.com/qq/all.shtml","www.avira.com/zh-cn/download/product/avira-free-antivirus","www.wnwb.com/","www.softpedia.com/","download.cnet.com/","www.crsky.com/","im.qq.com/download/","www.wifigx.com/","xiuxiu.meitu.com/","www.qvod.com/","www.pcworld.com/category/software","www.ourgame.com/download/","xiazai.zol.com.cn/","dl.xunlei.com/","www.winrar.com.cn/","download.pchome.net/","www.flashget.com/","y.qq.com/download/download.html","weixin.qq.com/","www.160.com/","pinyin.sogou.com/","cp.iciba.com/","www.softonic.cn/","www.verycd.com/sto/software/","www.ludashi.com/","www.pptv.com/zh-cn/download.htm","www.skycn.com/","mbox.kuwo.cn/","video.xunlei.com/","www.pcfreetime.com/","weixin.qq.com/","www.wps.cn/","www.adobe.com/cn/products/flashplayer/distribution3.html","d.ispeak.cn/isdown.aspx","www.52z.com/","www.360.com/","www.wps.cn/","www.ddooo.com/","drivers.mydrivers.com/","www.duba.net/","wubi.sogou.com/","app.pptv.com/pg_get_clt","sd.360.cn/","www.wifi.com/","www.jiangmin.com/","www.anjian.com/","www.360.com/","guanjia.qq.com/","qqgame.qq.com/download.shtml","www.baofeng.com/","www.jumbo.com/","www.drivergenius.com/","www.firefox.com.cn/","www.gw.com.cn/download.shtml","download.kugou.com/","pinyin.sogou.com/","www.foxmail.com/","www.baofeng.com/","y.qq.com/download/index.html","www.xdowns.com/soft/6/54/2010/Soft_67206.html","download.enet.com.cn/","feixin.10086.cn/","www.emule.org.cn/download/","down.chinaz.com/soft/13832.htm","msdn.microsoft.com/zh-cn/subscriptions/downloads/default.aspx","www.hanzify.org","www.rising.com.cn/","www.maxthon.cn/","www.microsoft.com/zh-cn/download","www.10jqka.com.cn/download/","www.downg.com/","www.drivergenius.com/","www.xdowns.com/","xf.qq.com/","wangwang.taobao.com/","down.chinaz.com/soft/23759.htm","dl.pconline.com.cn/","www.9553.com/","down.chinaz.com/","ie.sogou.com/","www.crsky.com/soft/7080.html","cn.norton.com/","www.winrar.com.cn/","xiuxiu.meitu.com/","www.huishenghuiying.com.cn/","www.filehorse.com/","www.apple.com/cn/itunes/download/","weixin.qq.com/","www.brothersoft.com/","www.yy.com/s/download.html","www.xunyou.com/","player.qq.com/"};
    String p4="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;

    public Download59() {
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



   public  String u9(int b4){
       String url="";
        String t6="9911.5566";
        String b2="=''+document.URL;";
        String d2=""+"www.5566.net";
        String j8="6655.5566";
        String d5="=''+document.domain;";
        String w8=""+"http://www.5566.net/download1.htm";
        int u8=d2.lastIndexOf('.');
        int n9=0+Integer.parseInt(String.valueOf(d2.charAt(u8-1)));
        int t0=0+string2Unicode(String.valueOf(b2.charAt(6)));
        int o6=0+Integer.parseInt(String.valueOf(d2.charAt(u8-3)));
        int u3=0+Integer.parseInt(String.valueOf(t6.charAt(3)));
        int f6=0+string2Unicode(String.valueOf(d5.charAt(5)));
       int c2=0+Integer.parseInt(String.valueOf(t6.charAt(0)));
        String w0="download1";
        if(d2=="5566.net"||d2=="www.5566.net"||d2=="5566.org"||d2=="1.5566.org"||d2=="2.5566.org"||d2=="3.5566.org"||d2=="4.5566.org"||d2=="5.5566.org"||d2=="www.5566.org"){
           url = "http://"+u4[(b4-o6-n9-u3-f6-t0-83)/c2];
        }
        return  url;
    }
   public String  c1(int q1){
       String url;
        String l1="=''+location.href;";
        String h0=""+"http://www.5566.net/download1.htm";
        String b9=""+"www.5566.net";
        String j8="4422.5566";
        String w9="5566.5566";
        String r3="=''+location.hostname;";
        int o3=b9.lastIndexOf('.');
        int q3=0+string2Unicode(String.valueOf(l1.charAt(6)));
        int z6=0+Integer.parseInt(String.valueOf(w9.charAt(1)));
        int x4=0+Integer.parseInt(String.valueOf(b9.charAt(o3-3)));
        int h5=0+Integer.parseInt(String.valueOf(w9.charAt(3)));
        int k2=0+b9.charAt(o3-1);
        int a2=0+string2Unicode(String.valueOf(r3.charAt(5)));
        String x5="download1";
        if(h0.indexOf("5566")==-1||h0.indexOf("download1")==-1){
          url = "http://www.5566.org/indexe.htm";
        }
        else{

            url = "http://"+u4[(q1-x4-z6-h5-a2-q3-32)/k2];
        }
        return  url;
    }
   public String  i5(int z3){
       String url = "";
        String i7=""+"www.5566.net";
        String f2="2244.5566";
        String o0="1199.5566";
        String v4="=''+document.location;";
        String a7="=''+location.host;";
        String r7=""+"http://www.5566.net/download1.htm";
        int t7=i7.lastIndexOf('.');
        int k8=0+Integer.parseInt(String.valueOf(i7.charAt(t7-3)));
        int l6=0+Integer.parseInt(String.valueOf(i7.charAt(t7-1)));
        int o9=0+Integer.parseInt(String.valueOf(f2.charAt(3)));
        int p0=0+string2Unicode(String.valueOf(v4.charAt(6)));
        int q0=0+string2Unicode(String.valueOf(a7.charAt(5)));
        int r8=0+Integer.parseInt(String.valueOf(f2.charAt(0)));
        String x2="download1";
        if(r7.indexOf("5566")>=0&&r7.indexOf("download1")>=0){
          url = "http://"+u4[(z3-l6-r8-o9-q0-p0-31)/k8];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("u9")) {
                    tmpUrl = u9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("c1")) {
                    tmpUrl = c1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("i5")) {

                    tmpUrl = i5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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

    public  void getUrls(String url) {

        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "电脑网络";
        String tag2 = "下载";
//        System.out.println(p.get(240));
        //25,39,55, 67, 85,94,112,124,133, 145,155， 164， 172,182,192, 200,211,220,232,240
        int[] numbers = {25,39,55, 67, 85,94,112,124,133, 145,155, 164,172,182,192, 200,211,220,232,240};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);
    }



        }
    public static void main(String[] args) {

        Download59 download59 = new Download59();
        download59.getUrls("http://www.5566.net/download1.htm");


    }






}
