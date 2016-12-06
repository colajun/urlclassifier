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
public class BBS30 {
    String[] b6={"0","bbs.ly.shangdu.com/","bbs.rayli.com.cn/","www.discuz.net/","bbs.ylyl.net/","bbs.jjj8.cn/","www.jmbbs.com/","bbs.lianzhong.com/","bbs.shunderen.com/","bbs.zaoyang.org/","bbs.trends.com.cn/","www.st001.com/","bbs.meishanren.com/","www.xitek.com/","bbs.cntv.cn/","bbs.taian.com/","bbs.yw.zj.cn/","bbs.t56.net/","bbs.bdinfo.net/","bbs.thmz.com/forum.php","bbs.qdit.com/","www.bohaibbs.org/","bbs.tiexue.net/","forum.home.news.cn/","www.nx.cn/forum.php","bbs.352200.com/","bbs.zhong5.cn/","www.linuxforum.net/","hongdou.gxnews.com.cn/","www.kugz.com/","bbs.dospy.com/","lt.imobile.com.cn/","bbs.25dx.com/","bbs.thmz.com/","bbs.dili360.com/","www.jy391.com/","bbs.168hs.com/","www.nd176.com/","bbs.cyol.com/","cd.91town.com/","bbs.ahsz.gov.cn/forum.php","www.aylt.cn/","bbs.17173.com/","bbs.52life.cc/","bbs.wuhu.cc/","bbs.xizi.com/","bbs.house365.com/","www.ifindu.cn/","bbs.qianlong.com/","bbs.66163.com/","bbs.0513.org/","bbs.ybvv.com/","tj.tianya.cn/","www.zzlt.cn/","www.aqtogo.com/","www.ynian.com/","www.528500.com/forum.php","www.chinathink.net/forum/","bbs.metroer.com/","bbs.leshan.cn/","www.dvedit.cn/","bbs.8264.com/","www.cstong.net/","bbs.huainet.com/","www.0574bbs.com/","www.donews.com/","www.0595bbs.cn/","bbs.jztele.com/","bbs.enshi.cn/","bbs.chaoshanren.com/","bbs.gxhc365.com/","www.ttx.cn/","bbs.inhe.net/","www.tianya.cn/","www.belle8.com/","bbs.dbw.cn/","bbs.ngzb.com.cn/","pbbs.lnfisher.com/","bbs.gxbs.net/","bbs.fuling.com/","www.xmpig.com/","bbs.hangzhou.com.cn/","bbs.ruian.com/","bbs.yaanren.net/","www.ytbbs.com/","bbs.rednet.cn/","bbs.hefei.cc/","sh.tianya.cn/","bbs.huanqiu.com/","club.hainan.net/","bbsnew.netbig.com/","bbs.oeeee.com/","bbs.jjxw.cn/","bbs.zzfish.cn/","bbs.shendu.com/","bbs.qdhnews.com.cn/","www.scol.cn/","www.0543bbs.com/forum.php","www.zzbbs.com/","bbs.qz828.com/","www.17lu.cn/","www.yeslele.com/","nanhai.hinews.cn/","bbs.yizheng.gov.cn/","guba.eastmoney.com/","bbs.zunhua.org/","bbs.classic023.com/","bbs.qinzhou360.com/","bbs.gxsky.com/","www.smxs.gov.cn/","bbs.zxip.com/","bbs.cqnews.net/","www.19lou.com/","www.ts.cc/","www.kaixin001.com/","bbs.tongcheng.gov.cn/","www.chinayk.com/","www.zpbbs.cn/","bbs.guilinlife.com/","bbs.zol.com.cn/","www.lcbbs.cc/","bbs.jsr.cc/","bbs.sgnet.cc/","bbs.0663.net/","bbs.guoxue.com/","bbs.zbgl.net/","bbs.jhnews.com.cn/","bbs.yawin.cn/","www.abbs.com.cn/bbs/","www.ngbbs.cn/","www.z4bbs.com/","www.py168.com/","club.qingdaonews.com/","bbs.cnyw.net/","www.gycity.com/","www.bbszjj.com/","club.jjjaaa.com/","bbs.haha168.com/","www.doyouhike.net/forum/","bbs.fqlook.cn/","bbs.voc.com.cn/","bbs.csdn.net/","bbs.xwh.cn/","www.xici.net/","bbs.hnhw.com/","www.szbbs.org/forum.php","www.hbnew.com/forum.php","bbs.hualongxiang.com/","teabbs.zjol.com.cn/","bbs.qiandao.net/","bbs.eastmoney.com/","bbs.gansudaily.com.cn/","bbs.dvbbs.net/","bbs.kaoyan.com/","www.molihua.net/forum.php","bbs.jschina.com.cn/","www.ai0513.com/","bbs.kutj.com/","www.xmfish.com/","club.sohu.com/","bbs.kshot.com/","bbs.gz4u.net/","www.kdnet.net/","www.douban.com/","club.1688.com/","cq.tianya.cn/","bbs.changsha.cn/","bbs.dahe.cn/","www.0452e.com/","www.deyi.com/","www.xuancheng.org/","bbs.hongxiu.com/","www.ifxtx.com/","bbs.211600.com/","bbs.cnhan.com/","bbs.cnwest.com/","www.bbs.zj.com/","bbs.it168.com/","bbs.hifi168.com/","bbs.fobshanghai.com/","www.cqmama.net/","bbs.hftogo.com/","bbs.anhuinews.com/","www.hybbs.com/","bbs.ctw.cn/","bbs.269.net/","pop.pcpop.com/","bbs.chunqiuwang.com/forum.php","bbs.ssfeng.com/bbs/","www.shanghaining.com/","www.bato.cn/","bbs.0372.cn/","www.iyaya.com/talk/","bbs.rednet.cn/","bbs.chengdu.cn/","bbs.ybbbs.com/","bbs.luanren.com/","bbs.212300.com/","hongdou.gxnews.com.cn/","bbs.shangdu.com/","szbbs.sznews.com/","bbs.fjsen.com/","www.gpbbs.cn/","go.cqmmgo.com/","www.fy22.com/","bbs.fznews.com.cn/","bbs.shangyou.cn/","www.hmting.com/","www.jqcom.cn/forum.php","www.521000.com/","www.chinareform.org.cn/","www.0573ren.com/","club.iweihai.cn/","club.bandao.cn/","www.0575bbs.com/","bbs.66163.com/","www.im286.com/","bbs.dzwww.com/","www.dz19.net/","bbs.enorth.com.cn/","bbs.lygbst.cn/","bbs.51cto.com/","bbs.city.tianya.cn/tianyacity/articleslist/0/173.shtml","club.china.com/","www.0597kk.com/","www.gxwmbbs.com/","bbs.703804.com/","bbs.blueidea.com/","bbs1.people.com.cn/","www.newuxi.com/","bbs.inhe.net/","www.hjsq.cn/","www.qfzx.com/forum.php","www.changle.com.cn/","www.suizhoushi.com/","club.dzwww.com/forum-222-1.html","www.jd-bbs.com/","bbs.ncdiy.com/","www.qpstar.com/","www.jsfuning.com/forum.php","www.daqi.com/","www.newsmth.net/","club.yninfo.com/","www.babytree.com/","club.gznet.com/","bbs.sj.net.cn/","www.0830bbs.com/","bbs.gdmm.com/","bbs.xs163.net/","bbs.ifeng.com/","bbs.zjghot.com/","www.pzzc.net/","bbs.taizhou.com/","bbs.076299.com/","bbs.iqilu.com/","www.mala.cn/","bbs.0634.com/","bbs.gusuwang.com/","bbs.0517w.com/","bbs.jxnews.com.cn/","bbs.online.sh.cn/","bbs.tianya.cn/list-203-1.shtml","www.aqlife.com/","bbs.86516.com/","www.xinji.org/","bbs.lnd.com.cn/","bbs.taobao.com/","bbs.qianlong.com/","bbs.cnnb.com.cn/","bbs.cnlz.cc/","www.hybbs.net/","bbs.jysq.net/","www.nmbbs.com/","bbs.xinjs.cn/","bbs.chinaz.com/","www.55188.com/index.php","www.cqfishing.net/","bbs.tianya.cn/list-153-1.shtml","bbs.np163.net/","www.ptfish.com/","bbs.0598yu.com/","bbs.55bbs.com/","bbs.cnhubei.com/","bbs.zjol.com.cn/","bbs.hlgnet.com/","www.czqq.com/","www.xinpg.com/","www.liba.com/","www.hepan.com/","www.donews.com/","bbs.zggs.gov.cn/","www.rongshuxia.com/","www.19lou.com/","bbs.crsky.com/","bbs.haining.com/","www.kdnet.net/","bbs.gg163.net/","bbs.mumayi.net/","bbs.runsky.com/","bbs.zpol.cn/","bbs.changde.gov.cn/","bbs.nen.com.cn/","bbs.66wz.com/","www.qzbbs.com/","www.pengyou.com/","www.ahbb.cc/","bbs.sina.com.cn/","www.ecl.com.cn/","bbs.kooaoo.com/","www.renren.com/","bbs.zhoushan.cn/","bbs.wm090.com/","bbs.163.com/","www.sehand.com/","www.qjren.com/bbs","www.e0575.cn/","www.gogopzh.com/","bbs.tongxiang.net/","www.ph66.com/","www.yizlife.com/","bbs.dg2012.com/","club.xilu.com/","bbs.wangjing.cn/","club.dayoo.com/","www.5iyq.com/","www.tianya.cn/","bbs.nhzj.com/","bbs.e23.cn/","bbs.fzbm.com/","bbs.nantaihu.com/","bbs.zxwindow.com/","bbs.cnool.net/","bbs.hb163.cn/","forum.china.com.cn/forum.php","www.ihome99.com/","www.mop.com/","bbs.qq.com/","bbs.icpcw.com/","bbs.longcity.net/","bbs.ys.gov.cn/","bbs.voc.com.cn/","bbs.sun0769.com/","bbs.hsw.cn/"};
    String u8="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;
    public BBS30(){
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

   public String  q1(int p3){
       String url = "";
        String q4="=''+document.location;";
        String s4="4422.5566";
        String f1=""+"www.5566.net";
        String c4="7799.5566";
        String d7=""+"http://www.5566.net/bbs-3.htm";
        String r8="=''+document.domain;";
        int e6=f1.lastIndexOf('.');
        int q7=0+string2Unicode(String.valueOf(q4.charAt(6)));
        int x4=0+Integer.parseInt(String.valueOf(c4.charAt(3)));
        int s7=0+Integer.parseInt(String.valueOf(f1.charAt(e6-3)));
        int l1=0+Integer.parseInt(String.valueOf(f1.charAt(e6-1)));
        int k1=0+Integer.parseInt(String.valueOf(c4.charAt(0)));
        int j5=0+string2Unicode(String.valueOf(r8.charAt(5)));
        String s0="bbs";
        if(d7.indexOf("5566")>=0&&d7.indexOf("bbs")>=0){
           url = "http://"+b6[(p3-s7-l1-x4-j5-q7-3)/k1];
        }
        return  url;
    }
    public  String j0(int v0){
        String url;
        String l7=""+"www.5566.net";
        String s4="8833.5566";
        String a6=""+"http://www.5566.net/bbs-3.htm";
        String y9="=''+document.URL;";
        String k3="2244.5566";
        String h3="=''+location.hostname;";
        int k0=l7.lastIndexOf('.');
        int i5=0+Integer.parseInt(String.valueOf(l7.charAt(k0-3)));
        int l5=0+Integer.parseInt(String.valueOf(k3.charAt(3)));
        int r2=0+Integer.parseInt(String.valueOf(k3.charAt(0)));
        int y1=0+string2Unicode(String.valueOf(y9.charAt(6)));
        int c9=0+Integer.parseInt(String.valueOf(l7.charAt(k0-1)));
        int e9=0+string2Unicode(String.valueOf(h3.charAt(5)));
        String z6="bbs";
        if(l7!="5566.net"&&l7!="www.5566.net"&&l7!="5566.org"&&l7!="1.5566.org"&&l7!="2.5566.org"&&l7!="3.5566.org"&&l7!="4.5566.org"&&l7!="5.5566.org"&&l7!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+b6[(v0-i5-r2-l5-e9-y1-7)/c9];
        }
        return  url;
    }
   public String  h9(int g5){
       String url = "";
        String h1=""+"http://www.5566.net/bbs-3.htm";
        String b7="3388.5566";
        String p5="=''+location.host;";
        String c0="=''+location.href;";
        String t5=""+"www.5566.net";
        String l2="9977.5566";
        int o7=t5.lastIndexOf('.');
        int g3=0+Integer.parseInt(String.valueOf(b7.charAt(0)));
        int o6=0+Integer.parseInt(String.valueOf(t5.charAt(o7-1)));
        int x7=0+string2Unicode(String.valueOf(p5.charAt(5)));
        int s5=0+string2Unicode(String.valueOf(c0.charAt(6)));
        int z5=0+Integer.parseInt(String.valueOf(t5.charAt(o7-3)));
        int h2=0+Integer.parseInt(String.valueOf(b7.charAt(3)));
        String z2="bbs";
        if(t5=="5566.net"||t5=="www.5566.net"||t5=="5566.org"||t5=="1.5566.org"||t5=="2.5566.org"||t5=="3.5566.org"||t5=="4.5566.org"||t5=="5.5566.org"||t5=="www.5566.org"){
           url = "http://"+b6[(g5-o6-g3-h2-x7-s5-65)/z5];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("q1")) {
                    tmpUrl = q1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("j0")) {
                    tmpUrl = j0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("h9")) {

                    tmpUrl = h9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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


    public  void  getBBSUrls(String url){
        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "娱乐休闲";
        String tag2 ="论坛、社区";
//        System.out.println(p.get(127));
//        //20,37
        int[] numbers = {20,37, 127};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }






    }

    public static void main(String[] args) {

        BBS30 bbs30 = new BBS30();

        bbs30.getBBSUrls("http://www.5566.net/bbs-3.htm");



    }






}
