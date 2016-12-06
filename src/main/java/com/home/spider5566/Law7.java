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
 * Created by hadoop on 16-11-21.
 */
public class Law7 {

    String[]  i5={"0","www.dffyw.com/sifakaoshi/","bbs.chinacourt.org/","law.chinalawinfo.com/","www.mps.gov.cn/","www.chinaeclaw.com/","www.cnlaw.net/","www.110.com/","www.gov.cn/flfg/index.htm","www.lawbridge.org/","learning.sohu.com/sikao/","www.chinalaw.org.cn/","bbs.tianya.cn/list-law-1.shtml","bbs.xuefa.com/","www.weiquan365.com/","www.chinalawedu.com/","www.dffyw.com/","sbj.saic.gov.cn/","www.xinhuanet.com/legal/","journal.chinalawinfo.com/","www.lawyee.net/","www.edu1488.com/","www.chinalawedu.com/web/dxpl/","www.iolaw.org.cn/","sf.kaoyee.com/","vip.chinalawinfo.com/","www.acla.org.cn/","www.bjlegalaid.gov.cn/","www.eol.cn/si_fa_4016/index.shtml","www.sh-notary.gov.cn/","www.chinacourt.org/","www.law-lib.com/","www.spp.gov.cn/","www.233.com/sf/","www.chinalawinfo.com/","www.findlaw.cn/","www.law110.com/","www.chinacourt.org/html/sfks/","www.on118.com/","law1.law-star.com","www.exam8.com/zige/sifa/","www.lawspirit.com/","www.law110.com/lawcase/lawcase.htm","www.9ask.cn/","www.yfw.com.cn/","www.fafawang.com/","www.legaldaily.com.cn/","www.lawyee.net/Act/Act.asp","www.jcrb.com/","edu.qq.com/kszx/sf/","www.1488.com/","cctv.cntv.cn/lm/jinrishuofa/index.shtml","law.eastday.com/","www.cnsikao.com/","www.law.pku.edu.cn/","www.66law.cn/","edu.sina.com.cn/exam/lawyer/index.shtml","www.sipo.gov.cn/","www.law-star.com/","www.civillaw.com.cn","www.law-lib.com/sk/","www.lawyers.org.cn/","www.law.com.cn/","www.moj.gov.cn/sfkss/node_226.htm","www.cpd.com.cn/","www.legalinfo.gov.cn","rmfyb.chinacourt.org/","www.lawtime.cn/","www.sifa600.com.cn/","www.mzyfz.com/","www.chinacourt.org/html/ajk/","www.chinalawbook.com/","www.sifa365.com/","www.civillaw.com.cn/","www.hicourt.gov.cn/law/default.asp","www.ceilaw.com.cn/","www.legalinfo.gov.cn/sfks/node_101.htm","www.chinalaw.gov.cn/","www.moj.gov.cn/","www.court.gov.cn/","www.hicourt.gov.cn/","www.china-arbitration.com/","www.fashuounion.com/","www.legalinfo.gov.cn/"};
    String i8="http://www.5566.org/indexe.htm";
    JdbcTemplate jdbcTemplate = null;
    public Law7(){
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






    public String  v2(int x0){
        String url = "";
        String g3="=''+location.host;";
        String u7="=''+location.href;";
        String i7=""+"http://www.5566.net/law-1.htm";
        String  g7="2244.5566";
        String p5=""+"www.5566.net";
        String k0="3311.5566";
        int y0=p5.lastIndexOf('.');
        int z1=0+string2Unicode(String.valueOf(g3.charAt(5)));
        int d4=0+string2Unicode(String.valueOf(u7.charAt(6)));
        int x5=0+Integer.parseInt(String.valueOf(g7.charAt(0)));
        int k4=0+Integer.parseInt(String.valueOf(p5.charAt(y0-1)));
        int u8=0+Integer.parseInt(String.valueOf(p5.charAt(y0-3)));
        int v9=0+Integer.parseInt(String.valueOf(g7.charAt(3)));
        String q0="law";
        if(p5=="5566.net"||p5=="www.5566.net"||p5=="5566.org"||p5=="1.5566.org"||p5=="2.5566.org"||p5=="3.5566.org"||p5=="4.5566.org"||p5=="5.5566.org"||p5=="www.5566.org"){
            url = "http://"+i5[(x0-u8-x5-v9-z1-d4-61)/k4];
        }
        return  url;
    }
    public String  i9(int z0){
        String url;
        String n4="7755.5566";
        String k5=""+"http://www.5566.net/law-1.htm";
        String w9=""+"www.5566.net";
        String b8="1133.5566";
        String y4="=''+document.location;";
        String u5="=''+document.domain;";
        int h4=w9.lastIndexOf('.');
        int j7=0+Integer.parseInt(String.valueOf(b8.charAt(3)));
        int q5=0+Integer.parseInt(String.valueOf(b8.charAt(0)));
        int z6=0+Integer.parseInt(String.valueOf(w9.charAt(h4-3)));
        int q8=0+Integer.parseInt(String.valueOf(w9.charAt(h4-1)));
        int c0=0+string2Unicode(String.valueOf(y4.charAt(6)));
        int e1=0+string2Unicode(String.valueOf(u5.charAt(5)));
        String b7="law";
        if(k5.indexOf("5566")==-1||k5.indexOf("law")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+i5[(z0-q8-q5-j7-e1-c0-73)/z6];
        }
    return  url;
    }

    public String  k8(int s0){
        String url = "";
        String k0="4422.5566";
        String r4="=''+document.URL;";
        String n3="5577.5566";
        String x6=""+"www.5566.net";
        String h1="=''+location.hostname;";
        String b5=""+"http://www.5566.net/law-1.htm";
        int x8=x6.lastIndexOf('.');
        int e2=0+Integer.parseInt(String.valueOf(n3.charAt(2)));
        int z7=0+string2Unicode(String.valueOf(r4.charAt(6)));
        int k7=0+Integer.parseInt(String.valueOf(x6.charAt(x8-1)));
        int o0=0+Integer.parseInt(String.valueOf(x6.charAt(x8-3)));
//        int m1=0+Integer.parseInt(String.valueOf(h1.charAt(5)));
        int m1 = 0 + string2Unicode(String.valueOf(h1.charAt(5)));
        int o7=0+Integer.parseInt(String.valueOf(n3.charAt(0)));
        String d2="law";
        if(b5.indexOf("5566")>=0&&b5.indexOf("law")>=0){
            url = "http://"+i5[(s0-o0-k7-e2-m1-z7-86)/o7];
        }
        return  url;
    }


    public  void getUrlAndText(Elements urls, String tag1, String tag2){

        String tmpUrl="";
        String tmpName="";
        String onclick = "";

        for(Element href: urls){
            try {
                onclick = href.attr("onclick");
                tmpName = href.text();
                if (onclick.substring(0, 2).equalsIgnoreCase("v2")){
                tmpUrl = v2(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
            }
            if  (onclick.substring(0, 2).equalsIgnoreCase("i9")){
                tmpUrl = i9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
            }
            if(onclick.substring(0, 2).equalsIgnoreCase("k8")){

                tmpUrl = k8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

            }
            } catch (Exception e) {
                tmpUrl = href.attr("href");
                tmpName = href.text();
            }

//            System.out.println(tmpUrl +"---------"+tmpName);

            inserTable(tag1, tag2, tmpUrl, tmpName);

        }



    }



    public  void  getLaws(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "政法军事";
        String tag2 ="政府";
        //17, 18,25, 47,55
        int[] numbers = {17, 18, 25, 47, 55};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }









    }



    public static void main(String[] args) {

        Law7 law7 = new Law7();
      law7.getLaws("http://www.5566.net/law-1.htm");



    }









}
