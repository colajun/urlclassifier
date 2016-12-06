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
public class Eng45 {
    String[] s7={"0","www.godic.net/","www.etyyy.com/","www.englishfree.com.cn/","jp.hjenglish.com/","trans.netat.net/","www.hxen.com/","www.englishcn.com/","dict.youdao.com/","www.en8848.com.cn/","www.iciba.com/","www.china-cet.com/","www.coffeejp.com/","www.koolearn.com/","www.kekenet.com/","www.yingyu.com/","www.bbc.co.uk/china/learningenglish/index.shtml","www.unsv.com/","www.newpower.org.cn/","www.joyen.net/","news.iciba.com/","www.enread.com/","www.kantsuu.com/","www.sparke.cn/","dict.youdao.com/","www.veryabc.cn/movie","www.glvchina.com/","www.wwenglish.com/","www.dedecn.com/","www.neworldjp.com/","www.24en.com/","www.51ielts.com","www.jpwind.com/","edu.qq.com/en/","am774.rbc.cn/","www.lingoes.cn/","www.cnielts.com/","www.ecp.com.cn/","learning.sohu.com/cet.shtml","www.voanews.cn/","www.yamibo.com/","www.dreye.com.cn/","www.cet-46.com/","www.putclub.com/","www.jukuu.com/","www.hjenglish.com/","www.ew.com.cn/","fanyi.youdao.com/","www.ewteacher.com/","www.51voa.com/","www.lyce.cn/","www.eng24.com/","dict.myfrfr.com/","www.fltrp.com/","www.sinoya.com/","www.kekejp.com/","www.xinzhitang.com.cn/","www.bwpx.com/","www.for68.com/","www.shane.com.cn/","www.chinadaily.com.cn/language_tips/index.html","www.longre.com/","en.12999.com/","www.es123.com/","www.neworiental.org/","www.xyybs.com/","www.mydict.com/","www.mintelcn.com/","www.tooe.org/","bab.la/","cet.99sushe.com/","dict.cnki.net/","cn.bing.com/dict/","www.51share.net/","www.bigear.cn/","edu.sina.com.cn/foreign/","www.onlycollege.com.cn/","www.chinadaily.com.cn/","www.leewen.org/","www.dict.cn/","www.tingroom.com/","www.listeningexpress.com/","www.frdic.com/","www.tingclass.net/","www.21stcentury.com.cn/","www.iciba.com/","www.in2english.com.cn/","www.tac-online.org.cn/","learning.sohu.com/waiyutiandi.shtml","www.chinaenglish.com.cn/","www.gedu.org/","en.eol.cn/","www.koreaxin.com/","www.360abc.com","www.beiwaionline.com/","www.nciku.cn/","dict.hjenglish.com/"};
    String x8="http://www.5566.org/indexe.htm";



    JdbcTemplate jdbcTemplate = null;

    public Eng45() {
        try {
            jdbcTemplate = JDBCHelper.createMysqlTemplate("mysql1", "jdbc:mysql://192.168.21.27/urlclassifier?useUnicode=true&characterEncoding=utf8", "root", "root", 5, 30);

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




    public String  l9(int o0){
        String url;
        String z3="4466.5566";
        String e1=""+"http://www.5566.net/eng-3.htm";
        String m8="=''+document.location;";
        String l7=""+"www.5566.net";
        String k8="2211.5566";
        String v2="=''+location.hostname;";
        int q2=l7.lastIndexOf('.');
        int p0=0+Integer.parseInt(String.valueOf(k8.charAt(2)));
        int w6=0+Integer.parseInt(String.valueOf(k8.charAt(1)));
        int s8=0+string2Unicode(String.valueOf(m8.charAt(6)));
        int p9=0+Integer.parseInt(String.valueOf(l7.charAt(q2-3)));
        int f1=0+Integer.parseInt(String.valueOf(l7.charAt(q2-1)));
        int a8=0+string2Unicode(String.valueOf(v2.charAt(5)));
        String r3="eng";
        if(l7!="5566.net"&&l7!="www.5566.net"&&l7!="5566.org"&&l7!="1.5566.org"&&l7!="2.5566.org"&&l7!="3.5566.org"&&l7!="4.5566.org"&&l7!="5.5566.org"&&l7!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+s7[(o0-f1-w6-p0-a8-s8-48)/p9];
        }
        return  url;
    }
    public String  b0(int f0){
        String url;
        String c3="=''+document.domain;";
        String t9=""+"http://www.5566.net/eng-3.htm";
        String l2="8833.5566";
        String k4="=''+location.href;";
        String o1=""+"www.5566.net";
        String d7="1122.5566";
        int s6=o1.lastIndexOf('.');
        int b7=0+string2Unicode(String.valueOf(c3.charAt(5)));
        int r7=0+Integer.parseInt(String.valueOf(l2.charAt(1)));
        int e4=0+Integer.parseInt(String.valueOf(o1.charAt(s6-1)));
        int w3=0+string2Unicode(String.valueOf(k4.charAt(6)));
        int o7=0+Integer.parseInt(String.valueOf(o1.charAt(s6-3)));
        int k0=0+Integer.parseInt(String.valueOf(l2.charAt(2)));
        String f8="eng";
        if(t9.indexOf("5566")==-1||t9.indexOf("eng")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+s7[(f0-o7-r7-k0-b7-w3-71)/e4];
        }
        return  url;
    }
   public String  h8(int h3){
       String url = "";
        String d6="6644.5566";
        String d2=""+"http://www.5566.net/eng-3.htm";
        String m5="=''+document.URL;";
        String d7="3388.5566";
        String f3="=''+location.host;";
        String q4=""+"www.5566.net";
        int k7=q4.lastIndexOf('.');
        int l3=0+Integer.parseInt(String.valueOf(q4.charAt(k7-1)));
        int s0=0+Integer.parseInt(String.valueOf(d6.charAt(0)));
        int a3=0+string2Unicode(String.valueOf(m5.charAt(6)));
        int q8=0+Integer.parseInt(String.valueOf(d6.charAt(3)));
        int u4=0+string2Unicode(String.valueOf(f3.charAt(5)));
        int a4=0+Integer.parseInt(String.valueOf(q4.charAt(k7-3)));
        String e5="eng";
        if(d2.indexOf("5566")>=0&&d2.indexOf("eng")>=0){
           url = "http://"+s7[(h3-a4-l3-q8-u4-a3-48)/s0];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("l9")) {
                    tmpUrl = l9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("b0")) {
                    tmpUrl = b0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("h8")) {

                    tmpUrl = h8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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



    public  void getEngUrls(String url){


        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "教育";
        String tag2 ="英语";
//        System.out.println(p.get(66));
        //16,35,47,58, 66
        int[] numbers = {16,35,47,58, 66};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }






    }
    public static void main(String[] args) {

        Eng45 eng45 = new Eng45();

        eng45.getEngUrls("http://www.5566.net/eng-3.htm");




    }







}
