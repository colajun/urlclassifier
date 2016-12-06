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
public class JiaDIan78 {

    String[] n7={"0","www.saec.com.cn/","www.midea.com.cn/","washer.hea.cn/","www.jiadian.com.cn/","www.whirlpool.com.cn/","homea.people.com.cn/GB/index.html","www.ahjdq.com/","jd.zol.com.cn/","www.changling.com.cn/","digi.tech.qq.com/hea/","tech.ifeng.com/elec/","www.otlan.com.cn/","www.sundan.com/","tv.hea.cn/","ac.hea.cn/","www.samsung.com.cn/","www.ea3w.com/","www.panda.cn/","www.pjtime.com/","ac.ea3w.com/","elec.it168.com/","www.chinamacro.cn/","www.lg.com.cn/","www.eaonline.com.cn/","www.malata.com/","bbs.zol.com.cn/jdbbs/","elec.it168.com/","www.jdunion.com/forum-43-1.html","www.auxgroup.com/","www.jdgod.com/","ac.cheaa.com/","www.china-chigo.com/","www.xiaoya.com.cn/","www.bosch-home.cn/","www.bjjdwx.com/","www.jdunion.com/","www.eapad.cn/","www.gdbbk.com/","www.twindeer.net/","www.hea.cn/","www.heacn.net/","www.philips.com.cn/","www.electrolux.com.cn/","digi.it.sohu.com/digital-home/","jd.zol.com.cn/","www.changhong.com.cn/","tech.sina.com.cn/elec/aircon/index.shtml","www.ariston.com.cn/","homea.people.com.cn/GB/41408/index.html","bbs.jdwx.cn/forum.php","www.jinling.com/","www.casarte.com/","www.xiaoya.com.cn/","www.jdsc.com.cn/","www.diqua.com/","www.db3c.cn/","www.mhi.com.cn/","ice.hea.cn/","www.haier.cn/","www.gree.com.cn/","www.xdjd.cn/","www.xundaco.com/","www.homa.cn/","www.kelon.com/","www.163dz.com/","www.baixingjd.com/","www.noritz.com.cn/","www.hisense.com/","www.siemens-home.cn/","www.vatti.com.cn/","www.aucma.com.cn/","zdc.zol.com.cn/jd.shtml","www.homea.hc360.com/","www.easiu.com/","www.china-188.net/","tech.sina.com.cn/elec/washer/index.shtml","panasonic.cn/","www.daikin-china.com.cn/","www.tcl.com/","www.littleswan.com/","www.qhea.com/","www.amoi.com.cn/","www.toshiba.com.cn/","www.china-yuli.com/","www.ce.cn/cysc/jiadian/","hea.163.com/","www.shinco.com/","icebox.ea3w.com/","www.skyworth.com/","tv.pconline.com.cn/","www.sharp.cn/","tech.sina.com.cn/elec/","www.sakura.com.cn/","dh.yesky.com/","www.rsdcw.com/","www.xinfei.com/","www.pioneerchina.com/","www.5star.cn/","www.meiling.com/","www.jdwx.cn/","www.canca.com/","tv.ea3w.com/","www.aosmith.com.cn/","tv.pcpop.com/","www.fotile.com/","www.galanz.com.cn/","www.supor.com.cn/","www.hitachi.com.cn/","www.jd-bbs.com/","family.pconline.com.cn/","www.sony.com.cn/","www.cheaa.com/","tech.sina.com.cn/elec/fridge/index.shtml","www.sakura.com.cn/","www.xiaoyaworld.com/","www.sastav.com/","www.jiuzhou.com.cn/","www.konka.com/","www.tecsun.com.cn/","www.chunlan.com/","www.ferroli.com.cn/","digitalhome.cheaa.com/","www.cheaa.org/","www.xinle.com/","www.xjd.hc360.com/","www.jd-bbs.com/","washer.ea3w.com/","www.ronshen.com.cn/","www.lemall.com/tv.html","www.coocaa.com/","icebox.cheaa.com/","www.bingshan.com/","www.gzwanbao.com/","www.ou-yi.com/","www.robam.com/","www.xoceco.com.cn/","www.sacon.cn/","www.jdwx.cn/","www.chinadee.com/","www.chinavanward.com/","ehome.pchome.net/","www.joyoung.com.cn/"};
    String e9="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public JiaDIan78(){
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



    public String  e1(int w8){
        String url;
       String  e7=""+"http://www.5566.net/jiadian-2.htm";
        String s0=""+"www.5566.net";
        String n8="3366.5566";
        String b2="=''+location.hostname;";
        String q3="9988.5566";
        String h1="=''+document.URL;";
        int j7=s0.lastIndexOf('.');
        int h2=0+Integer.parseInt(String.valueOf(n8.charAt(0)));
        int p6=0+Integer.parseInt(String.valueOf(s0.charAt(j7-3)));
        int d9=0+Integer.parseInt(String.valueOf(s0.charAt(j7-1)));
        int h6=0+string2Unicode(String.valueOf(b2.charAt(5)));
        int f2=0+Integer.parseInt(String.valueOf(n8.charAt(3)));
        int l9=0+string2Unicode(String.valueOf(h1.charAt(6)));
        String y6="jiadian";
        if(e7.indexOf("5566")==-1||e7.indexOf("jiadian")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
          url = "http://"+n7[(w8-d9-h2-f2-h6-l9-77)/p6];
        }
        return   url;
    }
    public String  j6(int i7){
        String url ;
        String h7="4477.5566";
       String  n9="=''+document.domain;";
        String u2=""+"www.5566.net";
        String e5="8899.5566";
        String a2=""+"http://www.5566.net/jiadian-2.htm";
        String m6="=''+location.href;";
        int r2=u2.lastIndexOf('.');
        int k1=0+Integer.parseInt(String.valueOf(e5.charAt(3)));
        int j3=0+string2Unicode(String.valueOf(n9.charAt(5)));
        int e0=0+Integer.parseInt(String.valueOf(u2.charAt(r2-3)));
        int n0=0+Integer.parseInt(String.valueOf(u2.charAt(r2-1)));
        int b6=0+Integer.parseInt(String.valueOf(e5.charAt(0)));
        int z1=0+string2Unicode(String.valueOf(m6.charAt(6)));
        String f3="jiadian";
        if(u2!="5566.net"&&u2!="www.5566.net"&&u2!="5566.org"&&u2!="1.5566.org"&&u2!="2.5566.org"&&u2!="3.5566.org"&&u2!="4.5566.org"&&u2!="5.5566.org"&&u2!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+n7[(i7-e0-n0-k1-j3-z1-3)/b6];
        }
        return  url;
    }
    public String  g5(int z0){
        String url = "";
        String m0="=''+location.host;";
        String h7="6633.5566";
        String l1=""+"http://www.5566.net/jiadian-2.htm";
        String y2="7744.5566";
        String d1="=''+document.location;";
        String z5=""+"www.5566.net";
        int n5=z5.lastIndexOf('.');
        int i9=0+string2Unicode(String.valueOf(m0.charAt(5)));
        int y8=0+Integer.parseInt(String.valueOf(y2.charAt(3)));
        int s8=0+Integer.parseInt(String.valueOf(y2.charAt(0)));
        int y9=0+Integer.parseInt(String.valueOf(z5.charAt(n5-1)));
        int p2=0+string2Unicode(String.valueOf(d1.charAt(6)));
        int g2=0+Integer.parseInt(String.valueOf(z5.charAt(n5-3)));
        String h8="jiadian";
        if(z5=="5566.net"||z5=="www.5566.net"||z5=="5566.org"||z5=="1.5566.org"||z5=="2.5566.org"||z5=="3.5566.org"||z5=="4.5566.org"||z5=="5.5566.org"||z5=="www.5566.org"){
            url = "http://"+n7[(z0-g2-s8-y8-i9-p2-45)/y9];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("e1")) {
                    tmpUrl = e1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("j6")) {
                    tmpUrl = j6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("g5")) {

                    tmpUrl = g5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
        String tag2 = "家电";
//        System.out.println(p.get(138));
//        //17,27,53, 66, 83,93,102,112,121,129,138,
        int[] numbers = {17,27,53, 66, 83,93,102,112,121,129,138};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }



    }

    public static void main(String[] args) {
        JiaDIan78 jiaDIan78 = new JiaDIan78();
        jiaDIan78.getUrls("http://www.5566.net/jiadian-2.htm");



    }







}
