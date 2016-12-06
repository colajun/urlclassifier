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
 * Created by hadoop on 16-11-22.
 */
public class Weibo26 {
    String[] n8={"0","weibo.com/shenguojun","weibo.com/1413971423","t.sohu.com/","weibo.com/1237973207/","weibo.com/luyi/","weibo.com/yugayujia","weibo.com/yingcaier","weibo.com/chenkun/","weibo.com/dasdasdas/","t.hexun.com/","weibo.com/hejiong","weibo.com/reneliu2010","weibo.com/sohozhangxin","weibo.com/huosiyan","weibo.com/1662055430/","weibo.com/suqun","weibo.com/lome","weibo.com/imzhuwei","weibo.com/zhaoxiaolovegod","weibo.com/bufeiyan","weibo.com/duchunblog","weibo.com/dees","weibo.com/liuxuan/","weibo.com/guodegang","weibo.com/adore","weibo.com/1838388131","weibo.com/zhouyijun","weibo.com/hangeng","weibo.com/1010956892","weibo.com/xiena","weibo.com/iamamycheung","t.qq.com/liuxiang","weibo.com/renzhiqiang","weibo.com/chaoyong","weibo.com/1197191492/","weibo.com/yinengjing/","t.qq.com/","benshan.t.sohu.com/","www.digu.com/","weibo.com/chenzhiwu","weibo.com/wangxiaoshan","weibo.com/michelereis","weibo.com/zhanghanyun","weibo.com/randbibi/","weibo.com/choicharlene/","bang.weibo.com/","weibo.com/xuruoxuan/","weibo.com/linariel","weibo.com/tangyan","weibo.com/hu_ge/","weibo.com/zhanghan1006","weibo.com/duhaitao","weibo.com/1629810574","weibo.com/yijianlianblog","weibo.com/iamgillianchung/","weibo.com/kaifulee","weibo.com/nba","t.qq.com/waenan","weibo.com/1221987632","weibo.com/donglu","weibo.com/linxinru","weibo.com/linzhilingblog/","weibo.com/suxing/","weibo.com/1813482925","weibo.com/leehom","weibo.com/hewei","weibo.com/1291843462","weibo.com/yuminhong","weibo.com/huangjianxiang","weibo.com/panshiyi","weibo.com/lixiaolu","weibo.com/yaochen","weibo.com/hanqiaosheng","weibo.com/aigofengjun","weibo.com/zhyj","weibo.com/caikangyong/","weibo.com/hanzhijun","weibo.com/jjlin/","weibo.com/shiyuzhu","weibo.com/yanxuqingpi","weibo.com/xuxiaoping","weibo.com/shishi310","t.qq.com/juntang","weibo.com/mayili","weibo.com/1742727537","bang.weibo.com/","weibo.com/wangliqin/","club.weibo.com/","weibo.com/zhaowei/","weibo.com/1291592332","t.people.com.cn/","weibo.com/guojingming/","bang.weibo.com/","weibo.com/misselvahsiao/","weibo.com/zhoulibo","weibo.com/wuxin","fanfou.com/","weibo.com/shenhongfei","weibo.com/langxianpinghk","weibo.com/zhanjun","weibo.com/baochunlai","weibo.com/zhudan","weibo.com/herundong/","weibo.com/xiaoshenyang2008","weibo.com/fengxiaogang","weibo.com/chenmingzhen0108/","weibo.com/simanan","weibo.com/shenhuazhujun","weibo.com/cangyue","weibo.com/libingbing","weibo.com/anyixuan","weibo.com/wangshi","weibo.com/1831216671/","weibo.com/1193476843","t.home.news.cn/","weibo.com/hemin","weibo.10086.cn/","weibo.com/huangxiaoming","weibo.com/hujing/","weibo.com/tianliang1979/","bang.weibo.com/","weibo.com/fengshaofeng","qweibo.sina.com.cn/","weibo.com/cuiyongyuan","weibo.com/1640016932/","weibo.com/chenhao/","weibo.com/yangmiblog","weibo.com/jasonzhangjie","weibo.com/liyinhe"};
    String j2="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public Weibo26(){
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

    public String  k9(int l4){
        String url;
        String v0="7711.5566";
        String v5=""+"http://www.5566.net/weibo.htm";
        String z9="=''+location.host;";
        String e3=""+"www.5566.net";
        String x4="3344.5566";
        String r9="=''+location.href;";
        int w1=e3.lastIndexOf('.');
        int u6=0+Integer.parseInt(String.valueOf(e3.charAt(w1-1)));
        int g6=0+Integer.parseInt(String.valueOf(v0.charAt(1)));
        int z6=0+string2Unicode(String.valueOf(z9.charAt(5)));
        int r3=0+Integer.parseInt(String.valueOf(e3.charAt(w1-3)));
        int j3=0+Integer.parseInt(String.valueOf(v0.charAt(2)));
        int o2=0+string2Unicode(String.valueOf(r9.charAt(6)));
        String j7="weibo";
        if(e3!="5566.net'"&e3!="www.5566.net"&&e3!="5566.org"&&e3!="1.5566.org"&&e3!="2.5566.org"&&e3!="3.5566.org"&&e3!="4.5566.org"&&e3!="5.5566.org"&&e3!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+n8[(l4-r3-u6-j3-z6-o2-53)/g6];
        }
        return  url;
    }
    public String  l0(int i7){
        String url = "";
        String r7="6688.5566";
        String p9=""+"www.556.net";
        String y0="=''+location.hostname;";
        String n6="=''+document.URL;";
        String a6=""+"http://www.5566.net/weibo.htm";
        String z5="1177.5566";
        int c6=p9.lastIndexOf('.');
        int p7=0+Integer.parseInt(String.valueOf(p9.charAt(c6-1)));
        int q9=0+Integer.parseInt(String.valueOf(p9.charAt(c6-3)));
        int b9=0+string2Unicode(String.valueOf(y0.charAt(5)));
        int y6=0+string2Unicode(String.valueOf(n6.charAt(6)));
        int c5=0+Integer.parseInt(String.valueOf(r7.charAt(1)));
        int a7=0+Integer.parseInt(String.valueOf(r7.charAt(2)));
        String q3="weibo";
        if(p9=="5566.net"||p9=="www.5566.net"||p9=="5566.org"||p9=="1.5566.org"||p9=="2.5566.org"||p9=="3.5566.org"||p9=="4.5566.org"||p9=="5.5566.org"||p9=="www.5566.org"){
           url = "http://"+n8[(i7-p7-c5-a7-b9-y6-55)/q9];
        }
        return  url;
    }
    public String  n1(int a1){
        String url = "";
        String i6="=''+document.location;";
        String x4="8866.5566";
        String s3="4433.5566";
        String o7=""+"http://www.5566.net/weibo.htm";
        String i2="=''+document.domain;";
        String q2=""+"www.5566.net";
        int n5=q2.lastIndexOf('.');
        int q4=0+string2Unicode(String.valueOf(i6.charAt(6)));
        int b5=0+Integer.parseInt(String.valueOf(s3.charAt(3)));
        int b0=0+Integer.parseInt(String.valueOf(q2.charAt(n5-1)));
        int c2=0+Integer.parseInt(String.valueOf(s3.charAt(0)));
        int x6=0+string2Unicode(String.valueOf(i2.charAt(5)));
        int n2=0+Integer.parseInt(String.valueOf(q2.charAt(n5-3)));
        String u2="weibo";
        if(o7.indexOf("5566")>=0&&o7.indexOf("weibo")>=0){
           url = "http://"+n8[(a1-n2-c2-b5-x6-q4-1)/b0];
        }
        return url;
    }

    public  void getUrlAndText(Elements urls, String tag1, String tag2) {

        String tmpUrl = "";
        String tmpName = "";
        String onclick = "";

        for (Element href : urls) {
            try {
                onclick = href.attr("onclick");
                tmpName = href.text();
                if (onclick.substring(0, 2).equalsIgnoreCase("k9")) {
                    tmpUrl = k9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("l0")) {
                    tmpUrl = l0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("n1")) {

                    tmpUrl = n1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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





    public  void getWeiboUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "娱乐体闲";
        String tag2 ="微博";
//        System.out.println(p.get(27));
//        //16,26
        int[] numbers = {16,26,41,54};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }






    }

    public static void main(String[] args) {

        Weibo26 weibo26 = new Weibo26();
        weibo26.getWeiboUrls("http://www.5566.net/weibo.htm");


    }






}
