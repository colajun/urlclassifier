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
 * Created by hadoop on 16-11-23.
 */
public class Edu41 {
    String[] q1={"0","www.chinaedu.com/","www.etiantian.com/","www.nbedu.gov.cn/","www.eol.cn/","www.hbjy.net/","www.hkjy.cn/","www.fzedu.gov.cn/","www.ncedu.net.cn/","www.ts-edu.gov.cn/","www.tyjyj.cn/","www.nmgov.edu.cn/","jm.edugd.cn/","www.chinaedu.edu.cn/","www.wuzhouedu.com.cn/","zsxx.e21.edu.cn/","www.xaedu.sn.cn/","www.chinateacher.com.cn/","www.haedu.cn/","www.zzedu.gov.cn/","www.ordosjy.gov.cn/","www.jyjy.gov.cn/","www.ruiwen.com/","www.hjenglish.com/","www.chinaacc.com","www.5156edu.com/","jy.nanning.gov.cn/","www.12999.com/","www.wfjyxxg.com/","www.hnedu.cn/","www.yaedu.net/","www.ytedu.cn/","www.tze.cn/","www.21shte.net/","www.moe.edu.cn/","www.hfjy.net.cn/","www.jse.edu.cn/","www.ncedu.gov.cn/","jyj.huaian.gov.cn/","www.jnzk.net/","www.lnzsks.com/","www.jiajiao400.com/","www.najyw.net/","www.gdyjedu.net/","www.114study.com/","www.zuowen.com/","www.asedu.gov.cn/","www.sxyedu.com/","www.sxedu.gov.cn/","www.sdedu.gov.cn/","www.zxls.com/","www.fjzzjy.gov.cn/","www.dledu.com/","www.teacher.com.cn/","www.qhdedu.cn/","www.dtsedu.cn/","www.czwlzx.com/","www.shmeea.com.cn/","www.hneeb.cn/","www.eeafj.cn/","www.hnhbedu.net/","www.gsedu.cn/","www.sdzkw.com/","www.zsksb.com/","www.dyjy.gov.cn/","www.zhixue.com/","www.hpe.sh.cn/","www.cxzw.com/","www.hyedu.gov.cn/","www.hzedu.net/","www.hbszzk.com/","www.nyedu.cn/","www.cqjw.gov.cn/","www.edu-edu.com.cn/","www.cmechina.net/","www.henanedu.com/","edu.qingdaonews.com/","www.hledu.net/","www.jxedu.gov.cn/","www.teachercn.com/","www.xxedu.cn/","www.wxjy.com.cn/","www.gxeea.cn/","www.xajy.cn/","www.dqedu.gov.cn/","www.my-edu.net/","bbs.pep.com.cn/","edu.qq.com/","www.bdjy.cn/","www.netbig.com/","jyj.yangzhou.gov.cn/","www.bjedu.gov.cn/","www.jje.cn/","www.tcedu.com.cn/","www.zjzs.net/","www.gzszk.com/","www.zww.cn/","www.jnjyw.edu.cn/","www.eeagd.edu.cn/","124.117.250.21/","www.hongen.com/","www.koolearn.com/","www.ycy.com.cn/","www.npjy.gov.cn/","www.sx-mzy.com/","www.zbedu.gov.cn/","www.tigu.cn/","www.fsjyw.com.cn/","www.bbioo.com/","www.fsjy.net/","www.yc.e21.cn/","www.yczk.org/","edu.sina.com.cn/","www.haixia.edu.cn/","www.gxhcedu.com/","www.7cxk.net/","www.teacherclub.com.cn/","www.cqzsw.com.cn/","www.jaedu.com/","www.snedu.gov.cn/","www.cn910.net/","www.nhedu.net/","www.czsx.com.cn/","www.ndedu.gov.cn/","www.czjy.cn/","www.gledu.cn/","www.huedu.net/","www.doule.net/","www.xze.cn/","www.bbjy.com/","edu.enorth.com.cn/","www.jyb.cn/","www.qzedu.net/","www.gxbsedu.com/","www.tajyw.net/","www.hgedu.gov.cn/","www.ktnw.cn/","www.eduzhai.net/","www.qqhredu.net/","www.aqedu.cn/","www.qsiedu.com/","www.jhedu.org/","www.qdedu.gov.cn/","www.sneac.com/","edu.offcn.com","www.sdzs.gov.cn/","edu.ifeng.com/","www.lbx777.com/","www.studyget.com/","www.jswjedu.gov.cn/","www.ahzsks.cn/","www.yqjyj.gov.cn/","edu.hainan.gov.cn/","www.jxedu.com.cn/","www.csedu.gov.cn/","www.smxjy.cn/","www.lzk.hl.cn/","www.jnedu.gov.cn/","www.nm.zsks.cn/","www.hlbrjy.cn/","www.gzsedu.cn/","www.zjzs.net/","learning.sohu.com/","www.snsedu.gov.cn/","www.dledu.com/","www.cersp.com/","jzb.com/","www.zsedu.net/","www.xze.cn/","www.fxedu.com.cn/","www.zje.net.cn/","www.wzer.net/","www.12edu.com/","www.cdedu.gov.cn/","edu.zbinfo.net/","www.cqksy.cn/","www.3edu.net/","www.rzjy.gov.cn/","www.chsi.com.cn/","www.xiaoxue123.com/","www.nxedu.gov.cn/","www.xsbnedu.cn/","www.sysjyw.com/","www.whedu21.com/","www.sxsedu.net/","www.qlteacher.com/","www.aoshu.com/","www.bhedu.com.cn/","www.hbte.com.cn/","www.hee.gov.cn/","yunfu.edugd.cn/","www.cdedu.com.cn/","www.yuloo.com/","www.sooxue.com/","www.szjy.gov.cn/","www.cfedu.net/","www.zxxk.com/","www.lyedu.gov.cn/","eea.jxedu.gov.cn/","www.gdczedu.net/","www.hebxtedu.cn/","www.snedu.com/","www.jiaoshizhaopin.net/","www.rajyj.com/","www.hsjyj.gov.cn/","www.kinhawk.com/","www.szedu.com/","www.cyedu.cn/","www.smjy.com.cn/","www.hdavec.org/","www.yledu.net.cn/","www.ahedu.cn/","www.btjy.net/","www.qthedu.com/","www.zzedu.net.cn/","www.pzhedu.cn/","www.shsjyw.com/","www.jsve.edu.cn/","www.hlje.net/","www.e21.cn/","www.fjedu.gov.cn/","www.mmjynet.com/","www.whedu.net/","www.masedu.cn/","cy.5156edu.com/","www.mdjedu.net/","www.jledu.gov.cn/","www.hzjy.com.cn/","www.zqedu.net.cn/","www.qhzk.com/","www.yledu.gov.cn/","edu.online.sh.cn/","edu.people.com.cn/GB/index.html","www.ywec.net/","www.lajy.net/","www.kmedu.net/","www.gzedu.gov.cn/","www.qzedu.cn/","www.zybang.com/question/pcsearch","www.szeb.edu.cn/","www.qzedu.gov.cn/","www.stedu.net/","www.china-b.com/","bbs.xxyw.com/","edu.cyol.com/","hyjyw.com/","www.whjy.net/","jypgy.ccit.js.cn/","www.zsjy.gov.cn/","www.cdcedu.com.cn/","www.bzedu.com.cn/","www.lhjy.net/","www.bhedu.cn/","www.365zhaosheng.com/","www.xcedu.net/","www.ynjy.cn/","www.99edu.net/","www.hhyedu.com.cn/","www.edu.cn/","www.yce.cn/","www.xuelecn.com/","www.nxycedu.com/","www.188h.com/","www.shmec.gov.cn/","www.jxedu.net.cn/","www.ykcen.cn/","www.sxkszx.cn/","www.sdedu.net/","www.czjy.gov.cn/","www.dy-edu.cn/","www.xjedu.gov.cn/","www.hbe.gov.cn/","www.edunews.net.cn/","www.haedu.gov.cn/","www.hldedu.com/","www.sxbjedu.com/","jyj.hanzhong.gov.cn/","www.essedu.cn/","www.bxjyw.com/","www.nxjyks.cn/","www.wsjy.gov.cn/","www.lysjyj.gov.cn/","www.k12.com.cn/","www.eact.com.cn/","www.lwjy.net/","www.mzedu.com/","www.czedu.gov.cn/","ea.hainan.gov.cn/","www.zhaokao.net/","edu.zhulong.com/","www.akjy.net/","edu.163.com/","www.dzei.net/","www.hssedu.cn/","www.zjedu.org/","www.ybedu.gov.cn/","www.cbe21.com/","www.xzedu.com.cn/","www.51ben.cn/","www.syn.cn/","www.tzedu.net.cn/","www.neea.edu.cn/","www.sdbzedu.gov.cn/","www.xmedu.gov.cn/","www.hsedu.cn/","www.lfjjw.gov.cn/","www.hg.e21.cn/","www.lyge.cn/","www.lzedu.net/","www.njenet.net.cn/","www.zjlsedu.org/","www.hebjy.com/","www.tledu.cn/","www.chazidian.com/","www.hhedu.net/","www.zk789.net/","www.chinaedunet.com/","www.zhjy.net/","www.jm.e21.cn/","www.huaue.com/","www.ahhnedu.cn/","www.sclzjy.com/","www.open.edu.cn/","www.ynzk.cn/","education.news.cn/","www.ec.js.edu.cn/","www.med66.com/","www.lnen.cn/","www.cixiedu.net/","www.gxedu.gov.cn/","www.gdhed.edu.cn/","www.abedu.net/","www.jmsedu.net/","www.ahedu.gov.cn/","www.heao.gov.cn/","www.wlmqedu.gov.cn/","www.lcedu.cn/","www.bjeea.cn/","www.juren.com/","www.ntjy.net/","www.sznews.com/education/index.htm","www.pep.com.cn/","www.jseea.cn/","www.xjedunet.com/","www.jzedu.net/","www.fyedu.gov.cn/","jyj.suqian.gov.cn/","www.51edu.com/","www.dgjy.net/","www.yuxiedu.com/","www.21cnjy.com/","www.gsedu.com.cn/","www.hebeea.edu.cn/","www.scedu.net/","www.ptjy.com/","www.xkb1.com/"};
    String f0="http://www.5566.org/indexe.htm";





    JdbcTemplate jdbcTemplate = null;

    public Edu41() {
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


    public String  p8(int u0){
        String url ;
        String y0="8899.5566";
        String c3=""+"http://www.5566.net/edu-3.htm";
        String o3="1122.5566";
        String  q2="=''+document.URL;";
        String v5=""+"www.5566.net";
        String u2="=''+location.host;";
        int j3=v5.lastIndexOf('.');
        int b1=0+Integer.parseInt(String.valueOf(v5.charAt(j3-1)));
        int l7=0+Integer.parseInt(String.valueOf(y0.charAt(0)));
        int t5=0+Integer.parseInt(String.valueOf(y0.charAt(2)));
        int c4=0+string2Unicode(String.valueOf(q2.charAt(6)));
        int f8=0+Integer.parseInt(String.valueOf(v5.charAt(j3-3)));
        int r4=0+string2Unicode(String.valueOf(u2.charAt(5)));
        String n9="edu";
        if(v5!="5566.net"&&v5!="www.5566.net"&&v5!="5566.org"&&v5!="1.5566.org"&&v5!="2.5566.org"&&v5!="3.5566.org"&&v5!="4.5566.org"&&v5!="5.5566.org"&&v5!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+q1[(u0-f8-l7-t5-r4-c4-79)/b1];
        }
        return  url;
    }
    public String  b5(int n7){
        String url = "";
        String g3="=''+document.location;";
        String l5="3377.5566";
        String i5=""+"www.5566.net";
        String l9="2211.5566";
        String v2="=''+document.domain;";
        String g5=""+"http://www.5566.net/edu-3.htm";
        int u4=i5.lastIndexOf('.');
        int n3=0+string2Unicode(String.valueOf(g3.charAt(6)));
        int e5=0+Integer.parseInt(String.valueOf(l9.charAt(3)));
        int l2=0+Integer.parseInt(String.valueOf(u4-3));
        int s8=0+Integer.parseInt(String.valueOf(i5.charAt(u4-1)));
        int z5=0+string2Unicode(String.valueOf(v2.charAt(5)));
        int d4=0+Integer.parseInt(String.valueOf(l9.charAt(0)));
        String f6="edu";
        if(i5=="5566.net"||i5=="www.5566.net"||i5=="5566.org"||i5=="1.5566.org"||i5=="2.5566.org"||i5=="3.5566.org"||i5=="4.5566.org"||i5=="5.5566.org"||i5=="www.5566.org"){
           url = "http://"+q1[(n7-s8-d4-e5-z5-n3-81)/l2];
        }
        return  url;
    }
   public String  l3(int o0){
       String url  = "";
        String t9=""+"http://www.5566.net/edu-3.htm";
        String t3=""+"http://www.5566.net/edu-3.htm";
        String o3="9988.5566";
        String w7="=''+location.href;";
        String z0="7733.5566";
        String x7="=''+location.hostname;";
        int y9=t3.lastIndexOf('.');
        int s6=0+Integer.parseInt(String.valueOf(z0.charAt(0)));
        int s1=0+Integer.parseInt(String.valueOf(t3.charAt(y9-3)));
        int n8=0+Integer.parseInt(String.valueOf(z0.charAt(3)));
        int y3=0+string2Unicode(String.valueOf(w7.charAt(6)));
        int p3=0+Integer.parseInt(String.valueOf(t3.charAt(y9-1)));
        int o9=0+string2Unicode(String.valueOf(x7.charAt(5)));
        String  l8="edu";
        if(t9.indexOf("5566")>=0&&t9.indexOf("edu")>=0){
           url = "http://"+q1[(o0-s1-p3-n8-o9-y3-96)/s6];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("p8")) {
                    tmpUrl = p8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("l3")) {
                    tmpUrl = l3(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("b5")) {

                    tmpUrl = b5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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

   public  void  getEduUrls(String url){

       Document doc=null;
       try {
           doc = Jsoup.connect(url).get();
       } catch (IOException e) {
           e.printStackTrace();
       }

       Elements p = doc.getElementsByTag("tr");
       String tag1 = "教育";
       String tag2 ="";
//        System.out.println(p.get(64));
       //20,30, 51,64
       int[] numbers = {20,30, 51,64};
       for(int i =0;i < numbers.length;i++){

           Elements urls = p.get(numbers[i]).getElementsByTag("a");
           getUrlAndText(urls, tag1, tag2);

       }




   }

    public static void main(String[] args) {


        Edu41 edu41 = new Edu41();
        edu41.getEduUrls("http://www.5566.net/edu-3.htm");




    }







}
