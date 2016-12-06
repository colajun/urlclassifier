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
 * Created by hadoop on 16-11-13.
 */
public class Zhonghe2 {

    String[] n3={"0","www.tfol.com/","www.cyol.com/","www.163.com/","www.gznet.com/","www.hinews.cn/","www.enorth.com.cn/","www.dbw.cn/","www.wuhan.net.cn/","www.cnbb.com.cn/","www.xaonline.com/","www.hsw.cn/","www.rednet.cn/","www.shenchuang.com/","www.dzwww.com/","www.dahe.cn/","www.southcn.com/","www.runsky.com/","hunan.voc.com.cn/","www.zj.com/","www.yunnan.cn/","www.66163.com/","www.ifeng.com/","www.lnd.com.cn/","www.cnhubei.com/","www.mop.com/","www.ycwb.com/","www.jschina.com.cn/","www.shangdu.com/","www.yinsha.com/","www.sina.com.cn/","www.people.com.cn/","www.online.sh.cn/","www.xinhuanet.com/","www.cqnews.net/","www.dayoo.com/","www.tom.com/","www.oeeee.com/","www.eastday.com/","www.scol.com.cn/","www.zjol.com.cn/","www.cntv.cn/","www.voc.com.cn/","www.ynet.com/","www.hangzhou.com.cn/","www.china.com/","www.inhe.net/","www.cnool.net/","www.sohu.com/","www.qq.com/","www.21cn.com/","www.qianlong.com/","www.zaobao.com/","cn.msn.com/","www.chinaren.com/","www.jxnews.com.cn/"};
    String x4="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;
    public Zhonghe2(){
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

    public  int  string2Unicode(String string) {

        StringBuffer unicode = new StringBuffer();

        for (int i = 0; i < string.length(); i++) {

            // 取出每一个字符
            char c = string.charAt(i);

            // 转换为unicode
            unicode.append(Integer.toUnsignedLong(c));
        }

        return Integer.parseInt(unicode.toString()) ;
    }
    public  String g3( int g7){
        String m9=""+"www.5566.net";
        String j9="4499.5566";
        String e8="6688.5566";
        String s0="=''+location.host;";
        String l9=""+"http://www.5566.net/zhong.htm";
        String y7="=''+document.URL;";
        int s5=m9.lastIndexOf('.');
        int o9 = 0 +Integer.parseInt(String.valueOf(m9.charAt(s5-3)));
        int h3 = Integer.parseInt(String.valueOf(m9.charAt(s5-1)))+0;
        int e9 = Integer.parseInt(String.valueOf(j9.charAt(2)))+0;
        int s6=0+string2Unicode(String.valueOf(s0.charAt(5)));
        int j5 = Integer.parseInt(String.valueOf(j9.charAt(1)))+0;

        int u8=0+string2Unicode(String.valueOf(y7.charAt(6)));
        String s3="zhong";
        String url ="";
        if(l9.indexOf("5566")>=0&&l9.indexOf("zhong")>=0){
            url= "http://"+n3[(g7-o9-j5-e9-s6-u8-6)/h3];
        }
        return  url;
    }



    public String d4(int o1){
      String i1=""+"http://www.5566.net/zhong.htm";
      String e8="9944.5566";
      String i5=""+"www.5566.net";
      String n0="1155.5566";
      String d5="=''+document.domain;";
        String v0="=''+location.href;";
        int s7=i5.lastIndexOf('.');
        int m8 = 0 + Integer.parseInt(String.valueOf(n0.charAt(0)));
      int r6=0+Integer.parseInt(String.valueOf(n0.charAt(3)));
      int m4=0+Integer.parseInt(String.valueOf(i5.charAt(s7-3)));
      int j3=0+Integer.parseInt(String.valueOf(i5.charAt(s7-1)));
      int m1=0+string2Unicode(String.valueOf(d5.charAt(5)));
      int k4=0+string2Unicode(String.valueOf(v0.charAt(6)));
      String o3="zhong";
      String url="";
      if(i5 != "5566.net" && i5 != "www.5566.net" && i5 != "5566.org" && i5!= "1.5566.org" && i5!="2.5566.org" && i5 != "3.5566.org" && i5 != "4.5566.org" && i5 != "5.5566.org" && i5 != "www.5566.org"){
          url="http://www.5566.org/indexe.htm";
      }
      else{
          url = "http://"+n3[(o1-m4-j3-r6-m1-k4-53)/m8];
      }
      return  url;
  }







    public String g5(int r8){

        String f4="8866.5566";
        String x6="=''+document.location;";
        String z9=""+"www.5566.net";
        String n2=""+"http://www.5566.net/zhong.htm";
        String t9="=''+location.hostname;";
        String t6="5511.5566";
        int a7 = z9.lastIndexOf(".");
        int o6 = 0+Integer.parseInt(String.valueOf(z9.charAt(a7-1)));
        int t7 = 0+string2Unicode(String.valueOf(x6.charAt(6)));
        int n6=0+Integer.parseInt(String.valueOf(z9.charAt(a7-3)));
        int b7=0+Integer.parseInt(String.valueOf(f4.charAt(1)));
        int e6=0+string2Unicode(String.valueOf(t9.charAt(5)));
        int w0=0+Integer.parseInt(String.valueOf(f4.charAt(2)));
        String p7="zhong";
        String url ="";
        if(z9=="5566.net"||z9=="www.5566.net"||z9=="5566.org"||z9=="1.5566.org"||z9=="2.5566.org"||z9=="3.5566.org"||z9=="4.5566.org"||z9=="5.5566.org"||z9=="www.5566.org"){
         url= "http://"+n3[(r8-o6-b7-w0-e6-t7-61)/n6];
        }
        return  url;
    }

    public  void getzhong(String url ){
        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "综合门户";
        String tag2 ="";
        String tmpUrl="";
        String tmpName="";
        String onclick = "";
        Elements urls = p.get(16).getElementsByTag("a");
        for(Element href: urls){
            onclick = href.attr("onclick");
            tmpName = href.text();
            if (onclick.substring(0, 2).equalsIgnoreCase("g3")){
                tmpUrl = g3(Integer.parseInt(String.valueOf(onclick.substring(3, 6))));
            }
            if  (onclick.substring(0, 2).equalsIgnoreCase("g5")){
                tmpUrl = g5(Integer.parseInt(String.valueOf(onclick.substring(3, 6))));
            }
            if(onclick.substring(0, 2).equals("d4")){

                tmpUrl = d4(Integer.parseInt(String.valueOf(onclick.substring(3, 6))));

            }
            inserTable(tag1, tag2, tmpUrl, tmpName);

        }
    }




    public static void main(String[] args) {
        Zhonghe2 ze = new Zhonghe2();
       ze.getzhong("http://www.5566.net/zhong.htm");


    }
    }
