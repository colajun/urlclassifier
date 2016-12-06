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
public class Blog27 {
    String[] x5={"0","blog.sohu.com/","blog.sina.com.cn/m/lixiang","blog.people.com.cn/","blog.sina.com.cn/m/huangzheng","blog.sina.com.cn/u/1263762522","blog.sina.com.cn/m/miaopu","blog.sina.com.cn/u/1192515960","blog.sina.com.cn/liushouwei","blog.sina.com.cn/m/guojingming","blog.sina.com.cn/m/huge","blog.sina.com.cn/yinengjing","blog.tianya.cn/","fanfou.com/","blog.rayli.com.cn/","t.people.com.cn/","fxd.bokee.com/","www.bokee.com/","blog.sina.com.cn/m/zhangyadong","blog.sina.com.cn/liyong","blog.sina.com.cn/m/xiena","blog.sina.com.cn/lixiaolu","blog.sina.com.cn/m/kongqd","qzone.qq.com/","www.yupoo.com/","blog.sina.com.cn/m/chenzihan","muzimeiriji.blog.sohu.com/","blog.sina.com.cn/m/eryueyatou","www.u148.net/","spaces.live.com/","my.poco.cn/","blog.sina.com.cn/m/hntvwanghan","www.caogen.com/","blog.sina.com.cn/lm/search/class/index.html","www.baike.com/","blog.sina.com.cn/lm/rank/index.html","blog.sina.com.cn/","blog.sina.com.cn/m/sunfeifei","blog.sina.com.cn/m/lixiaoran","blog.sina.com.cn/m/wuqixian","blog.sina.com.cn/m/wenghong","pic.tianya.cn/","blog.sina.com.cn/m/quying","t.qq.com/","blog.sina.com.cn/m/hu_ge","www.cnblogs.com/","blog.sina.com.cn/xiaoyaxuan","blog.sina.com.cn/m/tangjiali","blog.sina.com.cn/huangjianxiang","blog.sina.com.cn/m/fanbingbing","blog.cntv.cn/","blog.sina.com.cn/m/wuxiaoli","blog.sina.com.cn/m/dushifangniu","www.bababian.com/","blog.sina.com.cn/m/xingjiajiao","blog.sina.com.cn/m/qinhailu","blog.sina.com.cn/m/lijing","blog.sina.com.cn/m/zhyj","blog.sina.com.cn/m/zhenzidan","blog.sina.com.cn/acosta","blog.sina.com.cn/yeyiqian","blog.home.news.cn/","www.bokerb.com/","blog.sina.com.cn/m/JackieChan","blog.sina.com.cn/yuanli","blog.sina.com.cn/m/panshiyi","blog.sina.com.cn/m/honghuang","blog.sina.com.cn/m/jiminjia","blog.sina.com.cn/m/feidao","blog.sina.com.cn/lm/top/rank/","blog.sina.com.cn/hejie","www.dapenti.com/","charles.blog.sohu.com/","www.bokee.net/","t.sohu.com/","blog.sina.com.cn/m/meiting","blog.fang.com/","blog.sina.com.cn/m/shuimu","blog.sina.com.cn/m/liyapeng","blog.sina.com.cn/m/lovervip","blog.sina.com.cn/m/housheboy","blog.hexun.com/","blog.sina.com.cn/m/liyuchun","blog.sina.com.cn/liuxinlong","www.360doc.com/","blog.163.com/","blog.sina.com.cn/m/chjguancha","blog.sina.com.cn/m/zhaolin","blog.sina.com.cn/m/babe","blog.cnstock.com/","blog.sina.com.cn/m/jinqiaoqiao","blog.sina.com.cn/haidi","blog.ifeng.com/","blog.sina.com.cn/lihuizhen","blog.sina.com.cn/m/yuhua","blog.sina.com.cn/m/jinyuxi","www.blogchina.com/","blog.sina.com.cn/m/guodegang","blog.sina.com.cn/m/shuchang","www.blogbus.com/","blog.sina.com.cn/m/linxilei","www.blog.edu.cn/","www.docin.com/","blog.sina.com.cn/m/liuwei","blog.sina.com.cn/m/wzg","blog.sina.com.cn/m/twocold","blog.sina.com.cn/m/xujinglei","blog.eastmoney.com/","www.blogcn.com/","blog.sina.com.cn/m/lihao","weibo.10086.cn/","blog.sina.com.cn/m/chenzihan","pp.sohu.com/","blog.sina.com.cn/m/donglu","www.digu.com/","blog.sina.com.cn/qinlan","www.douban.com/","www.renren.com/","blog.sina.com.cn/m/wangzheng","blog.sina.com.cn/m/linxinru","huhaiquan.blog.sohu.com/","blog.sina.com.cn/m/xuxiaoping","www.qian8ao.com/","blog.sina.com.cn/m/chenhao","blog.qq.com/","blog.sina.com.cn/m/mayanli","www.poco.cn/","blog.sina.com.cn/m/yanglan","blog.sina.com.cn/m/linyilun","photo.qq.com/","blog.sina.com.cn/m/smnh","photo.163.com/","blog.cnfol.com/","blog.sina.com.cn/m/yanggongru","blog.china.com/","blog.sina.com.cn/m/suyoupeng","photo.hexun.com/","zh.wikipedia.org/","blog.sina.com.cn/m/zhangliangying"};
    String n8="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public Blog27(){
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



    public String  o5(int w0){
        String url="";
        String d9="5588.5566";
        String b3="=''+location.hostname;";
        String v2="9933.5566";
        String p2="=''+location.href;";
        String g9=""+"www.5566.net";
        String i0=""+"http://www.5566.net/blog.htm";
        int f7=g9.lastIndexOf('.');
        int t3=0+Integer.parseInt(String.valueOf(g9.charAt(f7-1)));
        int p0=0+string2Unicode(String.valueOf(b3.charAt(5)));
        int m9=0+Integer.parseInt(String.valueOf(d9.charAt(3)));
        int o0=0+string2Unicode(String.valueOf(p2.charAt(6)));
        int i6=0+Integer.parseInt(String.valueOf(g9.charAt(f7-3)));
        int x4=0+Integer.parseInt(String.valueOf(d9.charAt(0)));
        String w5="blog";
        if(g9=="5566.net"||g9=="www.5566.net"||g9=="5566.org"||g9=="1.5566.org"||g9=="2.5566.org"||g9=="3.5566.org"||g9=="4.5566.org"||g9=="5.5566.org"||g9=="www.5566.org"){
           url = "http://"+x5[(w0-t3-x4-m9-p0-o0-55)/i6];
        }
        return  url;
    }
   public String v8(int o4){
       String url = "";
        String f4=""+"http://www.5566.net/blog.htm";
        String q6="7744.5566";
        String i9=""+"www.5566.net";
        String y1="8855.5566";
        String h2="=''+document.location;";
        String y3="=''+location.host;";
        int w9=i9.lastIndexOf('.');
        int p9=0+Integer.parseInt(String.valueOf(q6.charAt(0)));
        int k5=0+Integer.parseInt(String.valueOf(i9.charAt(w9-1)));
        int o8=0+Integer.parseInt(String.valueOf(i9.charAt(w9-3)));
        int m8=0+Integer.parseInt(String.valueOf(q6.charAt(2)));
        int c9=0+string2Unicode(String.valueOf(h2.charAt(6)));
        int o1=0+string2Unicode(String.valueOf(y3.charAt(5)));
        String y5="blog";
        if(f4.indexOf("5566")>=0&&f4.indexOf("blog")>=0){
            url = "http://"+x5[(o4-o8-p9-m8-o1-c9-91)/k5];
        }
        return  url;
    }
   public String  x8(int h4){
       String url ;
        String d6="3399.5566";
        String b2="=''+document.URL;";
        String r4=""+"http://www.5566.net/blog.htm";
        String y1="4477.5566";
        String j0=""+"www.556.net";
        String h0="=''+document.domain;";
        int c8=j0.lastIndexOf('.');
        int t7=0+Integer.parseInt(String.valueOf(j0.charAt(c8-1)));
        int r8=0+string2Unicode(String.valueOf(b2.charAt(6)));
        int s7=0+Integer.parseInt(String.valueOf(d6.charAt(0)));
        int q5=0+Integer.parseInt(String.valueOf(d6.charAt(2)));
        int h7=0+Integer.parseInt(String.valueOf(j0.charAt(c8-3)));
        int v4=0+string2Unicode(String.valueOf(h0.charAt(5)));
        String i7="blog";
        if(j0!="5566.net"&&j0!="www.5566.net"&&j0!="5566.org"&&j0!="1.5566.org"&&j0!="2.5566.org"&&j0!="3.5566.org"&&j0!="4.5566.org"&&j0!="5.5566.org"&&j0!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
          url = "http://"+x5[(h4-h7-t7-q5-v4-r8-5)/s7];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("v8")) {
                    tmpUrl = v8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("x8")) {

                    tmpUrl = x8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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



    public  void getBlogUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "娱乐体闲";
        String tag2 ="博客";
//        System.out.println(p.get(59));
        //17,33, 50,59
        int[] numbers = {17,33, 50,59};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }



    }

    public static void main(String[] args) {
        Blog27 blog27 = new Blog27();
        blog27.getBlogUrls("http://www.5566.net/blog.htm");




    }




}
