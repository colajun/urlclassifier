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
public class Child65 {
    String[] p5={"0","www.ccppg.com.cn/baokan/zhongxuesheng/","www.szsems.com/","www.huangzhe.net/","kid.baby.sina.com.cn/","www.wawayaya.net/","bjsn.ynet.com/","www.childlib.org/","www.flash61.com/","www.xxssj.com","www.61flash.com/","mole.61.com/","www.hezi.com/","www.chinakids.com.cn/","www.hongdaishu.com/ddx/Index.aspx","www.ccppg.com.cn/a/zxs/index.htm","www.tom61.com/","www.art-child.com/","www.hnetyy.net/","www.xmst.org/","www.handsbrain.com/","www.ccppg.com.cn/baokan/ertongwenxue/","www.szclib.org.cn/","www.baobao88.com/","www.61w.cn/","www.jinmiao.cn/","kid.qq.com/","www.kumi.cn/","www.whst.org/","shaoer.cntv.cn/","aobi.100bt.com/","songshuhui.net/","www.hongdaishu.com/","www.ccppg.com.cn/","seer.61.com/","www.greengarden.org.cn/","www.ccppg.com.cn/baokan/qikan/","www.sst.org.cn/","www.xobobo.com/","www.chcmu.com/","www.fzetyy.com/","www.61ertong.com/","www.k618.cn/","www.060s.com/","www.ccppg.com.cn/baokan/womenaikexue/","www.tongnian.com/","bbs.etjy.com/","www.hongdaishu.com/","www.qbaobei.com/","17roco.qq.com/","www.gzst.org.cn/","www.scmc.com.cn/","www.581788.com/","shaoer.cntv.cn/dongman/","www.xinzhitang.com.cn/","www.beva.com/","www.kidsdown.com/","www.060s.com/childrens/","www.ccppg.com.cn/baokan/yingyubao/","www.hnst.org/","www.xiaoyaya.com/","www.ccppg.com.cn/baokan/zhixinjiejie/","www.ccc.org.cn","www.ccppg.com.cn/baokan/zhongguoshaonianertong/","www.0-3-6.com/","www.hongdaishu.com/yehb/Index.aspx","www.njch.com.cn/","www.bch.com.cn/","www.etyyy.com/","www.ccppg.com.cn/baokan/zhongguoshaonianwenzhai/","www.ccppg.com.cn/baokan/zhongguokatong/","www.61baobao.com/","61.gqt.org.cn/","www.sh-baby365.com/","talk.iyaya.com/2/0-0.html"};
    String c6="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;

    public Child65() {
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

    public String  c3(int m5){
        String url = "";
        String e7="3311.5566";
        String a2=""+"http://www.5566.net/child-4.htm";
        String e0=""+"www.5566.net";
        String f9="5577.5566";
        String n1="=''+document.domain;";
        String p8="=''+document.location;";
        int w0=a2.lastIndexOf('.');
        int q1=0+Integer.parseInt(String.valueOf(f9.charAt(3)));
        int w2=0+Integer.parseInt(String.valueOf(a2.charAt(w0-3)));
        int g2=0+Integer.parseInt(String.valueOf(f9.charAt(1)));
        int d0=0+Integer.parseInt(String.valueOf(a2.charAt(w0-1)));
        int s5=0+string2Unicode(String.valueOf(n1.charAt(5)));
        int j7=0+string2Unicode(String.valueOf(p8.charAt(6)));
        String m8="child";
        if(e0.indexOf("5566")>=0&&e0.indexOf("child")>=0){
            url = "http://"+p5[(m5-w2-d0-q1-s5-j7-74)/g2];
        }
        return  url;
    }
    public String  z8(int o1){
        String url;
        String j9="=''+location.hostname;";
        String b1=""+"http://www.5566.net/child-4.htm";
        String e9=""+"www.5566.net";
        String p9="=''+location.href;";
        String g8="7755.5566";
        String u0="2266.5566";
        int l1=e9.lastIndexOf('.');
        int q5=0+string2Unicode(String.valueOf(j9.charAt(5)));
        int l3=0+Integer.parseInt(String.valueOf(u0.charAt(1)));
        int j8=0+Integer.parseInt(String.valueOf(e9.charAt(l1-3)));
        int p2=0+string2Unicode(String.valueOf(p9.charAt(6)));
        int r9=0+Integer.parseInt(String.valueOf(u0.charAt(2)));
        int h0=0+Integer.parseInt(String.valueOf(e9.charAt(l1-1)));
        String z3="child";
        if(e9!="5566.net"&&e9!="www.5566.net"&&e9!="5566.org"&&e9!="1.5566.org"&&e9!="2.5566.org"&&e9!="3.5566.org"&&e9!="4.5566.org"&&e9!="5.5566.org"&&e9!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+p5[(o1-h0-l3-r9-q5-p2-25)/j8];
        }
        return  url;
    }
   public  String f8(int c7){
       String url = "";
        String a9="1133.5566";
        String b4="=''+document.URL;";
        String e7="6622.5566";
        String m1=""+"www.5566.net";
        String l8="=''+location.host;";
        String p3=""+"http://www.5566.net/child-4.htm";
        int a7=m1.lastIndexOf('.');
        int p1=0+Integer.parseInt(String.valueOf(m1.charAt(a7-1)));
        int l6=0+string2Unicode(String.valueOf(b4.charAt(6)));
        int n2=0+Integer.parseInt(String.valueOf(a9.charAt(2)));
        int f6=0+Integer.parseInt(String.valueOf(m1.charAt(a7-3)));
        int n9=0+string2Unicode(String.valueOf(l8.charAt(5)));
        int s1=0+Integer.parseInt(String.valueOf(a9.charAt(1)));
        String f2="child";
        if(m1=="5566.net"||m1=="www.5566.net"||m1=="5566.org"||m1=="1.5566.org"||m1=="2.5566.org"||m1=="3.5566.org"||m1=="4.5566.org"||m1=="5.5566.org"||m1=="www.5566.org"){
           url = "http://"+p5[(c7-f6-s1-n2-n9-l6-97)/p1];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("c3")) {
                    tmpUrl = c3(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("f8")) {
                    tmpUrl = f8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("z8")) {

                    tmpUrl = z8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
        String tag1 = "生活";
        String tag2 = "少年_儿童";
//        System.out.println(p.get(62));
        //16,28,, 40,, 49,62
        int[] numbers = {16,28,40, 49,62};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);
        }




    }

    public static void main(String[] args) {

        Child65 child65 = new Child65();
        child65.getUrls("http://www.5566.net/child-4.htm");



    }




}
