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
public class Computer51 {

    String[] j5={"0","www.it-times.com.cn/","www.hedy.com.cn/","www.oracle.com/cn/","www.ccidnet.com/internet/","www.sony.com.cn/","www.rising.com.cn/","www.motorola.com.cn/","www.sundns.com/","www.cnvd.org.cn/","www.cbinews.com/","www.pcworld.com/","www.cert.org.cn/","www.techtarget.com.cn/","www.kingdee.com/","www.chip.cn","www.jiasule.com/","www.kingsoft.com/","www.alidns.com/","www.pcmag.com/","www.idc.hk/","net.chinabyte.com/","www.beian.gov.cn/","www.hisense.com.cn/","www.5qiong.cn/","www.founder.com.cn/","www.ciw.com.cn/","tech.qq.com/","www.alexa.com/","www.csdn.net/","www.pcworld.com.cn/","www.canidc.com/","www.nihao.net/","www.ip138.com/","www.internic.net","tech.china.com/zh_cn/","www.yesky.com/","www.icpcw.com/","www.itnxs.com/","www.symantec.com/zh/cn/index.jsp","www.linkwan.com/","www.skycn.com/","www.zzy.cn/","www.philips.com.cn/","www.4.cn/","www.acer.com.cn/","www.cnw.com.cn/","www.benq.com.cn/","www.chinarank.org.cn/","www.mydrivers.com/","www.ibm.com.cn/","www.idcquan.com/","www.comprg.com.cn/","www.cnkuai.cn/","www.zte.com.cn/","www.sootoo.com/","cn.nec.com/","www.amd.com/","www.miitbeian.gov.cn/","www.foundertech.com/","www.51dns.com/","www.iresearch.cn/","www.icpcw.com/","www.ithome.com/","www.west263.com/","it.sohu.com/","www.hw99.com/","www.ccidnet.com/","www.22.cn/","www.bizcn.com/","www.1stchina.com/","www.webkaka.com/WebCheck.aspx","www.10.cn/","www.net.cn","www.itpub.net/","www.onlinedown.net/","www.adobe.com/cn/","www.aliyun.com/","it.sohu.com/internet_2014.shtml","www.greatwall.cn/","www.chinanetcenter.com/","www.mcplive.cn/","www.sharp.cn/","www.apnic.net/","www.cnetnews.com.cn/news/net","www.ctocio.com.cn/","www.boe.com.cn/","www.samsung.com.cn/","www.it168.com/","www.ceocio.com.cn/","it.people.com.cn/","www.chinabird.com/","www.cnii.com.cn/internet/","www.ahcit.com","www.it.com.cn/","www.lenovo.com.cn/","www.itbulo.com/","www.zol.com.cn/","www.ename.cn/","www.lanmang.cn/","www.dns.com.cn/","www.neusoft.com/","www.css.com.cn/","www.edong.com/","www.pchome.net/","www.net-infinity.net/","tech.sina.com.cn/","www.chinanetcenter.com/home/SpeedTest","www.corel.com.cn/","www.cfan.com.cn/","www.fujitsu.com/cn/","www.eepw.com.cn/","www.7x24.cn/","www.miit.gov.cn/","www.beareyes.com.cn/","www.ccw.com.cn/","www.networksolutions.com/","www.intel.cn/","www.asus.com.cn/","www.xinnet.com/","www.yixieshi.com/","www.yovole.com/","www.cnnic.cn/","www.chinabyte.com/","www.dnion.com/","www.hasee.com/","www.canon.com.cn/","www.hp.com.cn/","www.digitalchina.com/","www.pconline.com.cn/","www.mcplive.cn/","www.pcworld.com.cn/","www.kulianw.com/","cn.msi.com/","www.huawei.com.cn/","www.news.cn/tech/","smjpsj.dooland.com/","www.eNet.com.cn/","www.cpcfan.com/","www.yonyou.com/","www.anquanbao.com/","www.chinacache.com/","www.techxue.com/","www.pcdigest.com/","www.ciweek.com/","www.epson.com.cn/","www.programmer.com.cn/","www.iwebchoice.com/","www.techweb.com.cn/","www.17ce.com/","www.cnnic.cn/","www.cnw.com.cn/","www.cisco.com/cn/","www.china-channel.com/","www.logitech.com.cn/","www.donews.com/net/","www.kaspersky.com.cn/","www.ccw.com.cn/","www.toshiba.com.cn/","www.inspur.com/","tech.sina.com.cn/internet/","www.eweek.com/","www.infomall.cn/","www.it.hc360.com/","www.chinaitlab.com/","www.analysys.com.cn/","www.donews.com/","www.chinagov.cn/","www.tongfangpc.com/","idc.btte.net/","www.lexmark.com.cn/","www.sootoo.com/","www.net-research.cn/","www.isc.org.cn/","www.joca.cn/","www.haier.com/","www.51cto.com/","www.unis.cn/","www.21vianet.com/","think.lenovo.com.cn/","www.inspur.com/","www.fastweb.com.cn/","ce.cloud.360.cn/","www.lg.com.cn/","tech.163.com/internet/","wangzhan.360.cn/","www.onlinenic.com","www.gigabyte.cn/","www.netcraft.com/","www.ibm.com.cn/","www.speedtest.net/","www.ericsson.com/cn/","www.epc.com.cn/","www.microsoft.com/china/","www.pcpop.com/","cn.trendmicro.com/","news.pconline.com.cn/","www.dnsstuff.com/","www.cndns.com/","www.t086.com/","www.qcloud.com/","www.aigo.com/","www.jiangmin.com/","www.iresearch.com.cn/","www.ciweek.com/","tech.163.com/","www.35.com/","www.now.cn/","www.dell.com.cn/","www.ittime.com.cn/","www.apple.com.cn/","www.netnic.com.cn/","www.ecs.com.cn/"};
    String t3="http://www.5566.org/indexe.htm";



    JdbcTemplate jdbcTemplate = null;

    public Computer51() {
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


   public String  b4(int h5){
       String url;
        String r0="4488.5566";
        String e4="9977.5566";
        String a2=""+"http://www.5566.net/computer-6.htm";
        String v3="=''+location.href;";
        String s0=""+"www.5566.net";
        String a6="=''+location.hostname;";
        int z0=s0.lastIndexOf('.');
        int p1=0+Integer.parseInt(String.valueOf(s0.charAt(z0-1)));
        int j8=0+Integer.parseInt(String.valueOf(r0.charAt(2)));
        int c8=0+Integer.parseInt(String.valueOf(r0.charAt(2)));
        int b6=0+string2Unicode(String.valueOf(v3.charAt(6)));
        int r5=0+Integer.parseInt(String.valueOf(s0.charAt(z0-3)));
        int s7=0+string2Unicode(String.valueOf(a6.charAt(5)));
        String v6="computer";
        if(s0!="5566.net"&&s0!="www.5566.net"&&s0!="5566.org"&&s0!="1.5566.org"&&s0!="2.5566.org"&&s0!="3.5566.org"&&s0!="4.5566.org"&&s0!="5.5566.org"&&s0!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+j5[(h5-p1-c8-j8-s7-b6-63)/r5];
        }
        return  url;
    }
   public String  c5(int t0){
       String url;
        String o3="8844.5566";
        String o1=""+"www.5566.net";
        String b8="3355.5566";
        String d7=""+"http://www.5566.net/computer-6.htm";
        String c1="=''+document.URL;";
        String j9="=''+document.domain;";
        int j3=o1.lastIndexOf('.');
        int w7=0+Integer.parseInt(String.valueOf(b8.charAt(2)));
        int i8=0+Integer.parseInt(String.valueOf(o1.charAt(j3-3)));
        int o4=0+Integer.parseInt(String.valueOf(o1.charAt(j3-1)));
        int f0=0+Integer.parseInt(String.valueOf(b8.charAt(1)));
        int i0=0+string2Unicode(String.valueOf(c1.charAt(6)));
        int d5=0+string2Unicode(String.valueOf(j9.charAt(5)));
        String  d1="computer";
        if(d7.indexOf("5566")==-1||d7.indexOf("computer")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+j5[(t0-i8-f0-w7-d5-i0-58)/o4];
        }
        return  url;
    }
    public String  h9(int x6){
        String url = "";
        String h2="=''+location.host;";
        String o3="5533.5566";
        String r9="=''+document.location;";
        String l9="7799.5566";
        String y7=""+"www.5566.net";
        String g2=""+"http://www.5566.net/computer-6.htm";
        int g7=y7.lastIndexOf('.');
        int c0=0+string2Unicode(String.valueOf(h2.charAt(5)));
        int q6=0+Integer.parseInt(String.valueOf(l9.charAt(2)));
        int v2=0+string2Unicode(String.valueOf(r9.charAt(6)));
        int i5=0+Integer.parseInt(String.valueOf(y7.charAt(g7-1)));
        int w2=0+Integer.parseInt(String.valueOf(y7.charAt(g7-3)));
        int z6=0+Integer.parseInt(String.valueOf(l9.charAt(0)));
        String p3="computer";
        if(y7=="5566.net"||y7=="www.5566.net"||y7=="5566.org"||y7=="1.5566.org"||y7=="2.5566.org"||y7=="3.5566.org"||y7=="4.5566.org"||y7=="5.5566.org"||y7=="www.5566.org"){
           url = "http://"+j5[(x6-w2-i5-q6-c0-v2-86)/z6];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("b4")) {
                    tmpUrl = b4(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("c5")) {
                    tmpUrl = c5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("h9")) {

                    tmpUrl = h9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

                }
            } catch (Exception e) {
                tmpUrl = href.attr("href");
                tmpName = href.text();
            }
            if (tmpUrl.length() > 2) {

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
        String tag2 ="";
//        System.out.println(p.get(112));
        //18,48,62,80, 98,112
        int[] numbers = {18,48,62,80, 98,112};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }




    }

    public static void main(String[] args) {

        Computer51 computer51 = new Computer51();
        computer51.getUrls("http://www.5566.net/computer-6.htm");



    }




}
