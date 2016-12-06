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
public class Zx81 {
    String[] f8={"0","www.zjzs.com.cn/","www.rayli.com.cn/region/C0007004.html","home.focus.cn/group/group_forum.php","www.houseabc.com/zhuangxiu/","www.77883.com/","home.focus.cn/gz/","www.szzxw.com/","www.ateno.com/","www.sxzs.com.cn/","www.jiatx.com/","home.xmhouse.com/","home.soufun.com/bbs/","bbs.525j.com.cn/","www.e-jjj.com/","www.51hejia.com/","www.szzxw.com/","home.soufun.com/","deco.rayli.com.cn/","www.525j.com.cn/","www.pchouse.com.cn/","www.cool-de.com/","bbs.cool-de.com/","www.china-designer.com/","family.szhome.com/","www.sxzsw.net/","www.gzzhuangxiu.cn/","bbs.fdc.com.cn/","www.5i5home.com/","www.fjzx.org/","www.roomage.com/","www.joyju.com/","bbs.roomage.com/","www.jiajuol.com/","home.0731fdc.com/","www.zshl.com/","www.80018.cn/","jiaju.sina.com.cn/","www.liba.com/index/","www.eju.cn/","www.tumanduo.com/","dec.fdc.com.cn/","www.88zx.cn/","www.xiuhome.com/","www.ciid.com.cn/","www.21cos.com/zhuangxiu/","www.fjzs.com/","www.ccd.com.cn/","www.dgzs.cn/","home.sohu.com/","www.to8to.com/"};
    String b6="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public Zx81(){
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


   public String  o5(int y8){
       String url = "";
        String b2="6622.5566";
        String i7="1188.5566";
        String m5="=''+location.href;";
        String c0=""+"http://www.5566.net/zx-.htm";
        String y0=""+"www.5566.net";
        String s1="=''+location.hostname;";
        int r1=y0.lastIndexOf('.');
        int r8=0+Integer.parseInt(String.valueOf(y0.charAt(r1-1)));
        int i2=0+Integer.parseInt(String.valueOf(b2.charAt(2)));
        int n8=0+string2Unicode(String.valueOf(m5.charAt(6)));
        int z3=0+Integer.parseInt(String.valueOf(b2.charAt(1)));
        int m1=0+Integer.parseInt(String.valueOf(y0.charAt(r1-3)));
        int y9=0+string2Unicode(String.valueOf(s1.charAt(5)));
        String s3="zx";
        if(c0.indexOf("5566")>=0&&c0.indexOf("zx")>=0){
            url = "http://"+f8[(y8-m1-z3-i2-y9-n8-27)/r8];
        }
        return  url;
    }
    public String  f3(int g1){
        String url;
        String c9=""+"www.55666.net";
        String d2="=''+location.host;";
        String r2="8811.5566";
        String e3="5533.5566";
        String t7=""+"http://www.5566.net/zx-.htm";
        String b5="=''+document.URL;";
        int m0=c9.lastIndexOf('.');
        int y2=0+Integer.parseInt(String.valueOf(c9.charAt(m0-3)));
        int u0=0+string2Unicode(String.valueOf(d2.charAt(5)));
        int n4=0+Integer.parseInt(String.valueOf(c9.charAt(m0-1)));
        int u9=0+Integer.parseInt(String.valueOf(r2.charAt(2)));
        int r3=0+Integer.parseInt(String.valueOf(r2.charAt(0)));
        int p1=0+string2Unicode(String.valueOf(b5.charAt(6)));
       String  w0="zx";
        if(t7.indexOf("5566")==-1||t7.indexOf("zx")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
          url = "http://"+f8[(g1-n4-r3-u9-u0-p1-26)/y2];
        }
        return  url;
    }
    public String  o0(int c7){
        String url="";
        String s2="3355.5566";
        String e1=""+"http://www.5566.net/zx-.htm";
        String q8="=''+document.location;";
        String l2=""+"www.5566.net";
        String i7="2266.5566";
       String  n1="=''+document.domain;";
        int n3=l2.lastIndexOf('.');
        int z9=0+Integer.parseInt(String.valueOf(l2.charAt(n3-1)));
        int g9=0+Integer.parseInt(String.valueOf(s2.charAt(0)));
        int g7=0+string2Unicode(String.valueOf(q8.charAt(6)));
        int k7=0+Integer.parseInt(String.valueOf(l2.charAt(n3-3)));
        int j6=0+Integer.parseInt(String.valueOf(s2.charAt(3)));
        int p9=0+string2Unicode(String.valueOf(n1.charAt(5)));
        String o7="zx";
        if(l2=="5566.net"||l2=="www.5566.net"||l2=="5566.org"||l2=="1.5566.org"||l2=="2.5566.org"||l2=="3.5566.org"||l2=="4.5566.org"||l2=="5.5566.org"||l2=="www.5566.org"){
           url = "http://"+f8[(c7-k7-z9-j6-p9-g7-56)/g9];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("o5")) {
                    tmpUrl = o5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("f3")) {
                    tmpUrl = f3(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("o0")) {

                    tmpUrl = o0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
        String tag2 = "装修_装饰_家居";
//        System.out.println(p.get(34));
        //16,34
        int[] numbers = {16, 34};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }



    }
    public static void main(String[] args) {

        Zx81 zx81 = new Zx81();
        zx81.getUrls("http://www.5566.net/zx-.htm");


    }





}
