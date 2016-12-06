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
public class Star28 {
    String[] y6={"0","www.zhanghanyun.name/","www.zhoujie.com/","www.wangluodan.net/","www.adachoi.com/","sports.tom.com/huangjianxiang/","www.yurongguang.com/","ent.ifeng.com/listpage/3/1/list.shtml","www.raymondforest.com/","www.ameicn.com/","www.wakin.com/","ent.people.com.cn/GB/1082/index.html","www.liuxiaolingtong.com/","www.jeffcn.net/","yule.sohu.com/","www.jetli.com/","www.yoka.com/star/","www.mingxingku.com/","blog.sina.com.cn/xujinglei","www.zhaoweinetfamily.com/","www.jackybbs.com/","www.leonfansclub.com/","www.lixiaolu.org/","www.moontalk.com.tw/","www.xujinglei.org/","www.wangluodan.net/","ent.sina.com.cn/ziyi/","www.richiefamily.com/","www.haibing.com/","www.janezhang.com/","www.avrilchina.cn/","www.yangmi.org/","www.zbs.cn/","www.sunyanzicc.net/","www.iloveangelababy.com/","et.21cn.com/star/","ent.sina.com.cn/zhangjingchu","www.gongbeibi.com/","www.superdeng.com/","www.ameifans.com/","ent.qq.com/star/","www.zhangjingchu.cn/","www.awc618.com/","www.leslieclub.com/","www.joesfamily.com.tw/","www.fannaticfannclub.com/","www.kellychen.hk/","www.linzhiling.com/","ent.sina.com.cn/star/","data.ent.sina.com.cn/star/","www.jaycn.com/","www.cuijian.com/","www.yuquan.com/","www.wubai.com/","ent.news.cn/mx.htm","www.wang-yan.com/","www.wangleehom.com/","www.67.com/","ent.163.com/star/","gb.cri.cn/ent/star.htm","www.zhaobenshan.org","www.shixiaolong.com/","ent.hunantv.com/v/mxgw/liyuchun/","www.avex.com.tw/danson/","www.lovebeyond.com/","www.linyichen.com/","www.aaronhot.com/","blog.sina.com.cn/lm/search/ent/index.html","www.pengpeng.com/","www.liyapeng.com","bbs.huangxiaoming.com.cn/","yaoming.sports.sohu.com/","www.hejiong.com/","www.hearfish.com/","www.jackycheung.hk/","www.mjjasia.com/","www.sunliclub.com/","www.jackiechan.com/","rain.qq.com/","www.mingxing.com/","star.haibao.com/","ent.news.cn/mx.htm","www.hearfish.net/","www.ifensi.com/","ent.hunantv.com/v/mxgw/hnzc/xnzy/index_3244.html","www.kootinlok.com/","www.huangyiclub.com/"};
    String w6="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public Star28(){
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


   public String  f6(int d5){
       String url = "";
        String k4="3399.5566";
        String k1="=''+location.host;";
       String c9=""+"www.5566.net";
        String w2=""+"http://www.5566.net/star1-7.htm";
        String d6="6644.5566";
        String v8="=''+document.URL;";
        int q1=c9.lastIndexOf('.');
        int z5=0+Integer.parseInt(String.valueOf(d6.charAt(3)));
        int s1=0+string2Unicode(String.valueOf(k1.charAt(5)));
        int s2=0+Integer.parseInt(String.valueOf(c9.charAt(q1-3)));
        int e5=0+Integer.parseInt(String.valueOf(d6.charAt(0)));
        int g4=0+Integer.parseInt(String.valueOf(c9.charAt(q1-1)));
        int y2=0+string2Unicode(String.valueOf(v8.charAt(6)));
        String x3="star1";
        if(c9=="5566.net"||c9=="www.5566.net"||c9=="5566.org"||c9=="1.5566.org"||c9=="2.5566.org"||c9=="3.5566.org"||c9=="4.5566.org"||c9=="5.5566.org"||c9=="www.5566.org"){
            url = "http://"+y6[(d5-s2-e5-z5-s1-y2-74)/g4];
        }
        return  url;
    }
    public String  d3(int t8){
        String url ;
        String q6=""+"http://www.5566.net/star1-7.htm";
        String k4="4466.5566";
        String t6="2211.5566";
        String p2="=''+location.href;";
        String h6="=''+location.hostname;";
        String r3=""+"www.5566.net";
        int c8=r3.lastIndexOf('.');
        int a0=0+Integer.parseInt(String.valueOf(t6.charAt(1)));
        int y7=0+Integer.parseInt(String.valueOf(t6.charAt(3)));
        int v0=0+Integer.parseInt(String.valueOf(r3.charAt(c8-1)));
        int n3=0+string2Unicode(String.valueOf(p2.charAt(6)));
        int k8=0+string2Unicode(String.valueOf(h6.charAt(5)));
        int n5=0+Integer.parseInt(String.valueOf(r3.charAt(c8-3)));
        String e1="star1";
        if(q6.indexOf("5566")==-1||q6.indexOf("star1")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+y6[(t8-n5-v0-y7-k8-n3-80)/a0];
        }
        return  url;
    }
    public String  s6(int y9){
        String url;
        String d0="=''+document.location;";
        String h7="1122.5566";
        String z4="=''+document.domain;";
        String h3=""+"http://www.5566.net/star1-7.htm";
        String x7="9933.5566";
        String b0=""+"www.5566.net";
        int b3=b0.lastIndexOf('.');
        int t4=0+string2Unicode(String.valueOf(d0.charAt(6)));
        int c5=0+Integer.parseInt(String.valueOf(x7.charAt(3)));
        int a2=0+string2Unicode(String.valueOf(z4.charAt(5)));
        int p0=0+Integer.parseInt(String.valueOf(x7.charAt(0)));
        int s8=0+Integer.parseInt(String.valueOf(b0.charAt(b3-1)));
        int p1=0+Integer.parseInt(String.valueOf(b0.charAt(b3-3)));
        String w1="star1";
        if(b0!="5566.net"&&b0!="www.5566.net"&&b0!="5566.org"&&b0!="1.5566.org"&&b0!="2.5566.org"&&b0!="3.5566.org"&&b0!="4.5566.org"&&b0!="5.5566.org"&&b0!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
          url = "http://"+y6[(y9-s8-p0-c5-a2-t4-20)/p1];
        }
        return  url ;
    }




    public  void getUrlAndText(Elements urls, String tag1, String tag2) {

        String tmpUrl = "";
        String tmpName = "";
        String onclick = "";

        for (Element href : urls) {
            try {
                onclick = href.attr("onclick");
                tmpName = href.text();
                if (onclick.substring(0, 2).equalsIgnoreCase("f6")) {
                    tmpUrl = f6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("d3")) {
                    tmpUrl = d3(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("s6")) {

                    tmpUrl = s6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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





    public  void  getStartUrls(String url){


        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "娱乐";
        String tag2 ="明星";
//        System.out.println(p.get(43));
//        //16,28,43
        int[] numbers = {16,28,43};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }






    }


    public static void main(String[] args) {

        Star28 star28  = new Star28();
        star28.getStartUrls("http://www.5566.net/star1-7.htm");



    }




}
