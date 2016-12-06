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
public class Shou75 {

    String[] a4={"0","mobile.qq.com/","www.lg.com/cn/mobile-phones/all-lg-phones/all-lg-phones.jsp","www.htc.com/cn/","mobile.zol.com.cn/","3g.msn.cn/","www.uc.cn/","bbs.dospy.com/","www.apple.com/cn/iphone/","www.10010.com/","www.lenovo.com.cn/","www.139shop.com/","detail.zol.com.cn/cell_phone_index/subcate57_list_1.html","bbs.gfan.com/","www.sonymobile.com/cn/","www.opera.com/","www.meizu.com/","www.netqin.com/","digi.tech.qq.com/mobile/","www.ttpod.com/","www.newegg.cn/shouji.htm","www.cnwav.com/","sony.it168.com/","www.feifantxt.com/","product.it168.com/list/b/0302_1.shtml","www.asus.com.cn/Phones/","www.moxiu.com/","www.mumayi.com/","www.hiapk.com/","www.91.com/","product.pconline.com.cn/mobile/","weibo.10086.cn/","www.cnmo.com/","www.htc.com/cn/","weixin.qq.com/","www.samsung.com/cn/consumer/mobile-phones/smart-phone/filter/","iphone.91.com/","www.motorola.com.cn/","www.shouji.com.cn/","bbs.zhiyoo.com/","www.tigerknows.com/","msoft.taobao.com/","www.samsungapps.com/","phone.qunar.com/","www.52samsung.com/","www.mi.com/","www.meizumi.com/","samsungbbs.cnmo.com/","www.oppo.com/","feixin.10086.cn/","pim.10086.cn/","www.d.cn/","www.k-touch.cn/","www.shouji.com.cn/","iphone.tgbus.com/","www.byread.com/","apk.hiapk.com/","mobile.pcpop.com/","book.sooyuu.com/","www.155.cn/","www.apple.com/cn/iphone/","www.qisuu.com/","www.imobile.com.cn/","www.shouyou.com/","www.3533.com/","www.kldjy.com/","www.iapps.im/","www.gpsuu.com/","www.nduoa.com/","bbs.meizu.cn/","mobile.sina.com.cn/","www.97973.com/","mobile.iciba.com/powerword/download.html","www.vivo.com.cn/","motobbs.cnmo.com/","nokia.zol.com.cn/","www.autonavi.com/","www.10086.cn/","digi.it.sohu.com/mobile.shtml","mobile.it168.com/","mobile.tudou.com/","www.navidog.cn/","consumer.huawei.com/cn/mobile-phones/index.htm","product.pcpop.com/Mobile/00000_1.html","android.tgbus.com/","www.mojichina.com/","www.microsoft.com/zh-cn/mobile/","www.sonymobile.com/cn/","bbs.fengbao.com/","www.meizu.com/","www.coolpad.cn/","www.189.cn/","mobile.pconline.com.cn/","www.app111.com/","www.lenovo.com.cn/","mqqgame.qq.com/appstore/appstore_1_3.shtml","sony.it168.com/","www.ownskin.com/","www.samsung.com/cn/consumer/mobile-phones/smart-phone/filter/","www.oppo.com/","mobile.163.com/","news.sina.com.cn/wap/wbclient.html","www.dixintong.com/","www.feng.com/","www.appchina.com/","www.52blackberry.com/","www.nubia.cn/","www.apple.com/cn/itunes/","shouji.sogou.com/","mobile.yesky.com/","www.mi.com/"};
    String o2="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public Shou75(){
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


   public String  h0(int p4){
       String url;
        String v8="=''+location.host;";
        String s0=""+"http://www.5566.net/shou1-7.htm";
        String y2="=''+location.href;";
        String w1="7788.5566";
        String a6=""+"www.5566.net";
        String k4="1133.5566";
        int x9=a6.lastIndexOf('.');
        int i8=0+string2Unicode(String.valueOf(v8.charAt(5)));
        int z3=0+Integer.parseInt(String.valueOf(k4.charAt(1)));
        int f3=0+string2Unicode(String.valueOf(y2.charAt(6)));
        int h1=0+Integer.parseInt(String.valueOf(k4.charAt(3)));
        int r4=0+Integer.parseInt(String.valueOf(a6.charAt(x9-3)));
        int q6=0+Integer.parseInt(String.valueOf(a6.charAt(x9-1)));
        String y1="shou1";
        if(s0.indexOf("5566")==-1||s0.indexOf("shou1")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
          url = "http://"+a4[(p4-q6-z3-h1-i8-f3-42)/r4];
        }
        return  url;
    }
    public String  r0(int q1){
        String url = "";
        String o0=""+"www.5566.net";
        String w8=""+"http://www.5566.net/shou1-7.htm";
        String c7="=''+location.hostname;";
        String v5="5599.5566";
        String f8="8877.5566";
        String s2="=''+document.URL;";
        int w7=o0.lastIndexOf('.');
        int t5=0+Integer.parseInt(String.valueOf(o0.charAt(w7-3)));
        int m3=0+Integer.parseInt(String.valueOf(f8.charAt(0)));
        int p0=0+string2Unicode(String.valueOf(c7.charAt(5)));
        int b6=0+Integer.parseInt(String.valueOf(f8.charAt(2)));
        int e8=0+Integer.parseInt(String.valueOf(o0.charAt(w7-1)));
        int v9=0+string2Unicode(String.valueOf(s2.charAt(6)));
        String t0="shou1";
        if(o0=="5566.net"||o0=="www.5566.net"||o0=="5566.org"||o0=="1.5566.org"||o0=="2.5566.org"||o0=="3.5566.org"||o0=="4.5566.org"||o0=="5.5566.org"||o0=="www.5566.org"){
            url = "http://"+a4[(q1-t5-e8-b6-p0-v9-74)/m3];
        }
        return  url;
    }
    public String  d5(int i9){
        String url;
        String u4="=''+document.location;";
        String x8=""+"http://www.5566.net/shou1-7.htm";
        String i1=""+"www.5566.net";
        String j1="=''+document.domain;";
        String x1="9955.5566";
        String v5="3311.5566";
        int n3=i1.lastIndexOf('.');
        int s1=0+string2Unicode(String.valueOf(u4.charAt(6)));
        int e3=0+Integer.parseInt(String.valueOf(x1.charAt(0)));
        int d6=0+Integer.parseInt(String.valueOf(i1.charAt(n3-3)));
        int l2=0+string2Unicode(String.valueOf(j1.charAt(5)));
        int f1=0+Integer.parseInt(String.valueOf(i1.charAt(n3-1)));
        int u1=0+Integer.parseInt(String.valueOf(x1.charAt(3)));
        String j5="shou1";
        if(i1!="5566.net"&&i1!="www.5566.net"&&i1!="5566.org"&&i1!="1.5566.org"&&i1!="2.5566.org"&&i1!="3.5566.org"&&i1!="4.5566.org"&&i1!="5.5566.org"&&i1!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+a4[(i9-d6-e3-u1-l2-s1-77)/f1];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("h0")) {
                    tmpUrl = h0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("r0")) {
                    tmpUrl = r0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("d5")) {

                    tmpUrl = d5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
        String tag2 = "手机通信";
//        System.out.println(p.get(192));
//        //20,32,41,54,65,77,93,110,121,135,149, 162, 179,192
        int[] numbers = {20,32,41,54,65,77,93,110,121,135,149, 162, 179,192};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }




    }

    public static void main(String[] args) {
        Shou75 shou75 = new Shou75();
        shou75.getUrls("http://www.5566.net/shou1-7.htm");


    }


}
