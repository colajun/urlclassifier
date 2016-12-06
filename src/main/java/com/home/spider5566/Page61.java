package com.home.spider5566;

import com.home.spring.JDBCHelper;
import org.apache.lucene.analysis.payloads.IntegerEncoder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;

/**
 * Created by hadoop on 16-11-26.
 */
public class Page61 {

    String[] t9={"0","union.heima8.com/","www.dedecms.com/","www.blueidea.com/","www.codesky.net/article/doc/201109/2011092943391610.htm","www.sucaiw.com/","www.codesky.net/","www.phpwind.net/","www.wzsky.net/html/Website/","www.net.cn","www.mycodes.net/","www.3lian.com/gif/","tech.qq.com/web/","mytool.chinaz.com/baidusort.aspx","www.knowsky.com/web.asp","www.sccnn.com/","www.webmasterhome.cn/","www.iwebchoice.com/","www.phpcms.cn/","pr.chinaz.com/","union.sogou.com/","www.xinnet.com/","www.chinaz.com/","www.phome.net/","www.webshu.net/","www.dns.com.cn/","www.aizhan.com/","www.g168.net/","www.w3school.com.cn/","www.webjx.com/","www.enet.com.cn/enews/internet.shtml","www.admin5.com/","hsk.oray.com/","sucai.heima.com/","www.bitbug.net/","www.yiqifa.com/","www.jscode.cn/","www.alexa.com/topsites","www.lergao.com/","www.sssccc.net/","seo.chinaz.com/","www.cnzz.com/","www.webkaka.com/WebCheck.aspx","www.powereasy.net/","www.zzy.cn/","www.admin5.com/browse/186/index.shtml","www.foosun.net/","www.bizcn.com/","tech.china.com/zh_cn/home4u/sucai/","www.wangyeba.com/","www.sj63.com/","www.68design.net/","whois.webmasterhome.cn/","down.chinaz.com/","www.alexa.com/","tool.chinaz.com/","www.51.la/","www.newasp.net/","www.miitbeian.gov.cn/","www.alimama.com/member/login.htm","www.lanrentuku.com/","tech.sina.com.cn/internet/","www.ads8.com/","www.35.com/","www.tool.la/","www.wangyeba.com/Soft/Index.html","www.discuz.net/","www.coolsc.net/","www.dabaoku.com/sucai/","www.dnsstuff.com/","www.ename.cn/","www.im286.com/","union.ijinshan.com/","www.dabaoku.com/","www.now.cn/","www.iresearch.cn/","www.nipic.com/","www.bestmoban.com/","www.dvbbs.net/","homepage.yesky.com/","www.helpor.net/"};
    String a5="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;
    public Page61() {
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


    public String  s2(int f0){
        String url;
        String l2="3377.5566";
        String k4="9988.5566";
        String w8="=''+document.URL;";
        String d7=""+"www.5566.net";
        String f5=""+"http://www.5566.net/page-4.htm";
        String f9="=''+location.hostname;";
        int h9=d7.lastIndexOf('.');
        int o4=0+Integer.parseInt(String.valueOf(k4.charAt(3)));
        int h4=0+Integer.parseInt(String.valueOf(d7.charAt(h9-1)));
        int p2=0+string2Unicode(String.valueOf(w8.charAt(6)));
        int y9=0+Integer.parseInt(String.valueOf(d7.charAt(h9-3)));
        int h3=0+Integer.parseInt(String.valueOf(k4.charAt(1)));
        int z4=0+string2Unicode(String.valueOf(f9.charAt(5)));
        String h7="page";
        if(d7!="5566.net"&&d7!="www.5566.net"&&d7!="5566.org"&&d7!="1.5566.org"&&d7!="2.5566.org"&&d7!="3.5566.org"&&d7!="4.5566.org"&&d7!="5.5566.org"&&d7!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+t9[(f0-y9-h4-o4-z4-p2-76)/h3];
        }
        return  url;
    }
   public String  y5(int k9){
       String url = "";
        String x2="8899.5566";
        String x6=""+"http://www.5566.net/page-4.htm";
        String b2="4422.5566";
        String c1="=''+document.location;";
        String r8=""+"www.5566.net";
        String w7="=''+location.host;";
        int m1=r8.lastIndexOf('.');
        int u9=0+Integer.parseInt(String.valueOf(b2.charAt(3)));
        int k8=0+Integer.parseInt(String.valueOf(b2.charAt(1)));
        int g6=0+ Integer.parseInt(String.valueOf(r8.charAt(m1-1)));
        int e5=0+string2Unicode(String.valueOf(c1.charAt(6)));
        int y0=0+Integer.parseInt(String.valueOf(r8.charAt(m1-3)));
        int f1=0+string2Unicode(String.valueOf(w7.charAt(5)));
        String v6="page";
        if(x6.indexOf("5566")>=0&&x6.indexOf("page")>=0){
          url = "http://"+t9[(k9-g6-k8-u9-f1-e5-78)/y0];
        }
        return  url;
    }
   public String  o8(int u0){
        String url= "";
        String l2="2244.5566";
        String t6="7733.5566";
        String w5=""+"http://www.5566.net/page-4.htm";
        String v9="=''+location.href;";
        String m4="=''+document.domain;";
        String q6=""+"www.5566.net";
        int h8=q6.lastIndexOf('.');
        int a8=0+Integer.parseInt(String.valueOf(t6.charAt(3)));
        int n5=0+Integer.parseInt(String.valueOf(q6.charAt(h8-1)));
        int c2=0+Integer.parseInt(String.valueOf(t6.charAt(1)));
        int w2=0+string2Unicode(String.valueOf(v9.charAt(6)));
        int e2=0+string2Unicode(String.valueOf(m4.charAt(5)));
        int  o1=0+Integer.parseInt(String.valueOf(q6.charAt(h8-3)));
        String b9="page";
        if(q6=="5566.net"||q6=="www.5566.net"||q6=="5566.org"||q6=="1.5566.org"||q6=="2.5566.org"||q6=="3.5566.org"||q6=="4.5566.org"||q6=="5.5566.org"||q6=="www.5566.org"){
            url = "http://"+t9[(u0-o1-c2-a8-e2-w2-49)/n5];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("s2")) {
                    tmpUrl = s2(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("y5")) {
                    tmpUrl = y5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("o8")) {

                    tmpUrl = o8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
        String tag1 = "电脑网络";
        String tag2 = "站长导航";
//        System.out.println(p.get(128));
        //17, 32, 46, 56, 75, 92, 104, 128
        int[] numbers = {17, 32, 46, 56, 75, 92, 104, 128};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);
        }




    }

    public static void main(String[] args) {

        Page61 page61 = new Page61();

        page61.getUrls("http://www.5566.net/page-4.htm");

    }





}
