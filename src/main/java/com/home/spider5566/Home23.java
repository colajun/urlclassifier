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
public class Home23 {
    String[] p2={"0","house.hangzhou.com.cn/index.htm","www.jl.jl.cn/house/","qhd.focus.cn/","www.95191.com/","www.yyfdcw.com/","www.wwxxg.com/house/","www.syfff.com/","fdc.86516.com/","www.tyfdc.gov.cn/","sx.house.sina.com.cn/","bj.house.163.com/","suzhou.fang.com/","www.hzfc.gov.cn/","bb.ahhouse.com/","www.ptfc123.com/","www.0566fc.com/","dg.fang.com/","www.whhouse.com.cn/","www.wzfc.net/","www.577house.com/","www.xffcol.com/","www.szhome.com/","www.xgfdc.com.cn/","www.bjgjj.gov.cn/","www.nyloushi.com/","hn.efw.cn/","www.zgfcn.com/","www.0579fw.com/","www.u88soufang.cn/","www.tiaofang.com/","nt.fang.com/","suzhou.fang.com/","ts.fang.com/","www.xgfdc.com.cn/","house.163.com/","house.lsol.com.cn/","tj.house.sina.com.cn/","www.bankrate.com.cn/tools/second-hand-housing-tax.html","home.66wz.com/","www.bnhouse.org/","www.hyfdcw.com/","fz.fang.com/","www.jjhouse.cn/","www.0738fdc.com/","www.yafc.gov.cn/","cd.house.sina.com.cn/","ls.fang.com/","hrb.focus.cn/","www.dafun.com.cn/","sy.house.sina.com.cn/","www.gyfc.net.cn/","www.dllp.cn/","www.shfg.gov.cn/","gz.house.163.com/","www.jnfg.gov.cn/","sz.house.sina.com.cn/","www.wnhouse.com/","www.zgsof.com/","www.0594.com/","www.shgjj.com","zhangjiajie.fang.com/","www.hrbfdc.gov.cn/","www.cnnbfdc.com/","www.0724fc.com/","www.sdfdc.com/","www.0743fdc.com/","house.hainan.net/","house.bandao.cn/","www.51rencai.com/","zhenjiang.fang.com/","zz.fang.com/","wuhan.fang.com/","wuxi.fang.com/","www.jzfc.gov.cn/","www.suinf.cn/","www.hyfdc.com/","lyg.fang.com/","sz.focus.cn/","meishan.focus.cn/","www.xzl571.com/","www.1fangchan.com/","www.hfgjj.com/","xian.fang.com/","www.hfhouse.com/","house.yninfo.com/","henan.e086.cn/","www.szfd.gov.cn/","zs.fang.com/","www.rzfdc.com/","qd.fang.com/","www.51fdc.com/","www.hkrealestate.gov.cn/","www.rem.net.cn/","www.fangz.cn/","www.sqhouse.cn/","www.taofw.cn/","cq.house.sina.com.cn/","gy.fang.com/","nn.fang.com/","www.jsfcw.com/","jn.fang.com/","www.jzfcw.com/","www.sjzfgj.gov.cn/","www.zh51home.com/","www.0559fc.com/","www.rexian.net.cn/","cd.eeju.com/","www.hkrealestate.gov.cn/","www.zshouse.com/","mianyang.fang.com/","www.tl8.com.cn/","yn.house.sina.com.cn/","www.syfdc.gov.cn/","www.szhome.com/","www.chineseoffice.com.cn/","www.home77.com/","house.hinews.cn/","qd.house.sina.com.cn/","www.housebd.com/","xm.fang.com/","www.0551zf.net/","house.cnhubei.com/","jn.focus.cn/","yunnan.e086.cn/","www.0539fc.com/","www.0570fc.com/index.htm","www.xyfcj.com/","www.fsestate.com.cn/","www.xafc.com/","www.gsjzw.cn/","bj.house.sina.com.cn/","mas.ahhouse.com/","xz.fang.com/","suzhou.focus.cn/","www.century21cn.com","fs.house.sina.com.cn/","www.fx8888.com/","www.hngjj.net/","h.house.sina.com.cn/","www.jnhouse.com/","www.czfcw.com/","nj.house.sina.com.cn/","www.mayi.com/","www.ezrea.com/","www.czfdc.com.cn/","wx.allfang.com/","www.efw.cn/","cq.house.qq.com/","www.0352home.com/","www.btfcw.net/","www.cityhouse.cn/","www.hhfcw.com/","www.0713hb.com/house/","www.anjuke.com/","www.jnhouse.com/","home.dg163.cn/","taian.loupan.com/","cs.house.sina.com.cn/","www.pyfc.cn/","www.tengfun.com/","www.hljfdc.com/","www.wf777.com/","www.ahfdc.com.cn/","www.lygfc.com/","www.house-jn.com/","www.tlfc.com.cn/","wh.house.sina.com.cn/","lz.fang.com/","nj.focus.cn/","www.0598777.net/","www.dyfcw.com/","www.ljhouse.org/","zzhz.zjol.com.cn/","www.fdc.gov.cn/","www.qdfdc.com/","www.0565fc.com/","www.ykfc.net/","www.ntfc.gov.cn/","nb.focus.cn/","guilin.fang.com/","www.zzfdc.gov.cn/","cc.house.sina.com.cn/","leshan.fang.com/","house.focus.cn/","www.xxfdc.gov.cn/","house.online.sh.cn/","www.laho.gov.cn/","www.fc0531.com/","www.ayfdc.com/","www.ddfc.com.cn/","www.ylfdc.com/","www.zbfdc.com/","nb.fang.com/","weihai.house.sina.com.cn/","sjz.fang.com/","www.zyfdc.com.cn/","www.kfw001.com/","www.fjsfx.org/","qinghai.e086.cn/","km.fang.com/","www.lyfff.com/","www.fangdi.com.cn/","www.365hf.com/","zh.fang.com/","www.nmgfc.cn/","www.lhfdc.gov.cn/","www.fang.com/","www.btfdc.com/","www.nthouse.com.cn/","www.qzls.net/","www.ythouse.com/","www.9ihome.com/","house.cnhan.com/","www.gdfdc.com/","fs.fang.com/","www.0561house.com/","ningxia.e086.cn/","www.fjnpfdc.com/","www.ncfdc.com.cn/","www.kaifc.cn/","schouse.newssc.org/","shxi.e086.cn/","www.028f.com/","bd.fang.com/","dy.fang.com/","www.pdsloushi.com/","www.yunfufgj.gov.cn/","www.china-crb.cn/","www.0359fdc.com/","nc.fang.com/","www.kmhouse.org/","www.binfang.com/","house.dahe.cn/","0518.1f.cn/","www.fzhouse.com.cn/","www.gg998.com/","www.gogohome.com/","sh.fang.com/","www.xinhuanet.com/house/","house.hdzc.net/","house.dbw.cn/","cz.fang.com/","www.gjj.gov.cn/","fg.xz.gov.cn/","www.qzfdc.com/","bd.zhijia.com/","fangke.cn/","www.whhouse.com.cn/","www.asfcw.com/","www.xtfdc.org/","www.beihaire.gov.cn/","shanxi.e086.cn/","cs.fang.com/","bj.fang.com/","www.ddfcw.com/","www.gzre.com/","www.letfind.com.cn/","www.czfdc.gov.cn/","www.fc311.com/","www.lafc.cn/","www.fjlyfdc.com.cn/","house.jmnews.com.cn/","www.fcfcg.com/","www.house.sh.cn/","www.sinzhu.com/","www.9ihome.com/","www.realestate.cei.gov.cn/","www.smxloushi.com/","rz.fang.com/","house.scol.com.cn/","sh.house.163.com/","cq.fang.com/","zj.fang.com/","hz.fang.com/","www.ljfw.com.cn/","www.0736fdc.com/","www.aqhouse.com/","sjz.focus.cn/","www.ok0911.com/","fdc.rednet.cn/","www.lianjia.com/","www.foundhouse.cn/","wf.fang.com/","www.smfdc.com.cn/","nm.fang.com/","www.npfcw.com/","www.pdsfdc.gov.cn/","ks.fang.com/","dl.focus.cn/","www.zfgjj.cn/","www.taofang.com.cn/","changshu.fang.com/","sh.house.sina.com.cn/","www.0595qz.com/","house.0575360.com/","www.ganji.com/","www.ybfc.cn/","nj.house365.com/index.html","house.people.com.cn/","hf.haoju.cn/","house.cnool.net/","dl.fang.com/","www.jgsdaily.com/fc/","house.online.sh.cn/","www.cdfgj.gov.cn/","www.hfhome.cn/","www.h0476.com/","www.scfdc.cn/","www.yzfdc.net/","www.0731.cn/","huizhou.fang.com/","hn.fang.com/","fang.taobao.com/","house.enorth.com.cn/","www.gxfdc.cn/","www.028028.net/","www.0597ok.com/","www.0701fc.com/","suining.fang.com/","house.changsha.cn/","sx.fang.com/","sz.allfang.com/","www.hsgjjw.com/","www.zjgzf.cn/","house.tzinfo.net/","house.ly169.cn/","www.ntfdc.net/","www.ejiacn.com/","hangzhou.fangtoo.com/","www.mytophome.com/","www.hgfdc.com/","www.jc86.cn/","www.cczfgjj.gov.cn/","house.anhuinews.com/","www.bhhouse.cn/","www.800j.com.cn/","www.allfang.com/","cq.house.163.com/","yc.fang.com/","www.fangjia.com/","guangdong.e086.cn/","hd.fang.com/","www.lianjia.com/","www.dgrea.com/","www.fc571.com/","www.hkproperty.com/","www.tzfdc.com.cn/","www.10fang.com/","www.0757fdc.com.cn/","fj.house.sina.com.cn/","www.0759h.com/","www.lffdc.gov.cn/","www.ndfdc.com/","www.jn678.com/","www.mohurd.gov.cn/","www.essfdc.gov.cn/","www.0473fdc.com/","house.gansudaily.com.cn/","www.zbhouse.com/","www.xnzufang.cn/","www.qionghaifc.com/","jx.fang.com/","www.njhouse.com.cn/","house.21cn.com/","yz.fang.com/","house.hinews.cn/","www.ggfdc.com/","www.373f.com/","www.ycfcw.cn/","xa.focus.cn/","www.iefang.com/","www.house12315.com/","www.jxfcrx.com/","www.fangdi.com.cn/","www.lousw.com/","www.sxhouse.com.cn/","www.tjfdc.com.cn/","www.fygjj.com/","www.jzsfc.gov.cn/","www.0577home.net/","gz.fang.com/","hunan.e086.cn/","house.gxnews.com.cn/","hrb.fang.com/","www.bjfang.com/","sy.fang.com/","taizhou.fang.com/","weihai.focus.cn/","hf.fang.com/","www.0734fdc.cn/","www.okfang.com/","hn.house.163.com/","www.ythouse.com/","www.jxjst.gov.cn/","esfc.daqing.net/","house.dzwww.com/","www.5i5j.com/","www.shenyang1.com/","tj.fang.com/","house.inhe.net/","zhejiang.e086.cn/","bj.allfang.com/","jl.fang.com/","cs.focus.cn/","www.ycfdcxxw.gov.cn/","www.srfdc.com/","dg.focus.cn/","ly.fang.com/","www.ccfdw.gov.cn/","www.xcfdc.cn/","www.xgfw.cn/","www.haofz.com/","www.house365.com/","www.zzjjw.cn/","weihai.fang.com/","www.wxhouse.com/","www.zjfgj.cn/","www.bxfcj.cn/","www.sqfcw.com.cn/","house.sina.com.cn/","www.taofang.com/","www.0772fang.com/","www.cityhouse.cn/","www.ychqfc.com/","www.0732fc.com/","www.jzhome.cn/","fc.zj.com/","wh.allfang.com/","www.fjlyfdc.com.cn/","www.lwhouse.com/","www.jshouse.com.cn/","sz.fang.com/","www.funxun.com/","www.qthfc.com/","www.wf777.com/","www.8000j.com/","www.lfang.cn/","www.xinhs.com/house/","www.51room.net/","hz.focus.cn/","house.ks.js.cn/","www.nyfdc.gov.cn/","www.gshouse.com.cn/","house.runsky.com/","wz.fang.com/","www.eeju.com/","jiangsu.e086.cn/","wh.eeju.com/","changchun.fang.com/","www.fdc0760.com/","www.dyfc.net/","www.housoo.com/","www.fdc0737.com/","www.xyfcw.com/","sichuan.e086.cn/","gz.house.sina.com.cn/","www.jxdcw.com/","www.0817.net/","www.ffw.com.cn/","www.hdfangxun.cn/","jh.fang.com/","www.fc3.cn/","www.sy13.com/","www.0817f.com/","house.cnnb.com.cn/","www.ehomeday.com/","neimenggu.e086.cn/","www.stfcj.gov.cn/","www.lthouse.com.cn/","www.veryhome.com/","www.villa.com.cn/","www.cdfcw.com/","www.dyfc.net/","yt.fang.com/","house.hexun.com/","cq.focus.cn/","www.fdc.com.cn/","nanjing.fang.com/","xm.focus.cn/","fgj.fuzhou.gov.cn/","www.hgfdc.com/hgfdc/","zfgjj.bb.ah.cn/","gx.house.sina.com.cn/","xn.fang.com/","tj.focus.cn/","www.qzfcw.com/","www.jy510.com/","wh.focus.cn/","www.ihk.cn/","www.qzfdc.gov.cn/","www.focus.cn/","www.tlfdc.cn/","www.tzfdc.com/","www.xfzc.com/","www.ahhouse.com/","jx.fang.com/","www.house371.com/","www.rzzz.com.cn/","sd.house.sina.com.cn/","www.lzgjj.com/","sh.focus.cn/","www.yjwn.cn/","house.hebei.com.cn/","dl.house.sina.com.cn/","www.lcfcw.com/","www.masgjj.gov.cn/","www.zyloushi.com/","www.tsefang.com/","cd.focus.cn/","www.syinfo.com.cn/","fgj.fuzhou.gov.cn/","xt.fangyuan365.com/","wh.house365.com/","www.jianfc.com/","www.bjjs.gov.cn/","www.szjsj.gov.cn/","www.hfhome.cn/","www.ynhouse.com/","www.cxhouse.org/","www.qh.xinhuanet.com/xnfdc/","www.xmhouse.com/","www.yxfdc.com/","dg.house.sina.com.cn/","www.0731fdc.com/","www.myfdc.com.cn/","taiyuan.fang.com/","house.21cn.com/","tj.allfang.com/","gz.focus.cn/","www.0356f.com/","hn.focus.cn/","bt.fang.com/","www.eju.com/","www.syfx.cn/","cd.fang.com/","www.gzwsfdc.com/","nj.allfang.com/","house.qq.com/","www.stre.net/","house.shangdu.com/","www.0830e.com/","www.mzhw.com/","www.xafgj.gov.cn/","www.hzfjw.com/","www.ehomeday.com/","hn.house.sina.com.cn/","www.nxfang.com/","www.ndjsj.gov.cn/","jilin.e086.cn/","www.smfdc.com.cn/","www.jlsfdc.com/","house.zbinfo.net/","www.hldhouse.com/","www.zmdfdc.com/","dgfc.dg.gov.cn/","www.housoo.com/","han.house.sina.com.cn/","lc.sdfdc.com/","www.0898hn.net/","www.qjhouse.org/","shanghai.anjuke.com/","fangchan.hdol.cn/","zhuzhou.fang.com/","www.xmfc.com/","house.jiaodong.net/","www.mdjfdc.gov.cn/","www.yxfcw.cn/","www.fyhouse.net/","xj.fang.com/","www.zsfc.gov.cn/","sy.focus.cn/","house.ifeng.com/","www.lsfc.com.cn/","www.srea.org.cn/","fc.seezy.com/","www.hsfdc.com/","www.0597house.com/","www.ezfcw.cn/","www.masff.com/","tz.fang.com/","www.yzkdfcw.com/","www.fdc.com.cn/","www.cqfdcw.cn/","www.ejiacn.com/"};
    String z0="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;
    public Home23(){
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


    public String  s7(int r2){
        String url = "";
        String q9="=''+document.URL;";
        String a5="7733.5566";
        String m0=""+"www.5566.net";
        String v1="8899.5566";
        String q2=""+"http://www.5566.net/home-1.htm";
        String y9="=''+location.hostname;";
        int e9=m0.lastIndexOf('.');
        int n5=0+string2Unicode(String.valueOf(q9.charAt(6)));
        int t3=0+Integer.parseInt(String.valueOf(v1.charAt(2)));
        int c3=0+Integer.parseInt(String.valueOf(m0.charAt(e9-3)));
        int d6=0+Integer.parseInt(String.valueOf(m0.charAt(e9-1)));
        int y8=0+Integer.parseInt(String.valueOf(v1.charAt(0)));
        int x3=0+string2Unicode(String.valueOf(y9.charAt(5)));
        String h7="home";
        if(q2.indexOf("5566")>=0&&q2.indexOf("home")>=0){
           url = "http://"+p2[(r2-c3-d6-t3-x3-n5-65)/y8];
        }
        return  url;
    }
   public String  e3(int h8){
       String url = "";
        String m6=""+"www.5566.net";
        String n4="3377.5566";
        String z4="=''+document.domain;";
        String o9=""+"http://www.5566.net/home-1.htm";
        String x2="=''+location.href;";
        String a5="2211.5566";
        int x5=m6.lastIndexOf('.');
        int s1=0+Integer.parseInt(String.valueOf(m6.charAt(x5-3)));
        int n9=0+Integer.parseInt(String.valueOf(m6.charAt(x5-1)));
        int v8=0+string2Unicode(String.valueOf(z4.charAt(5)));
        int d4=0+Integer.parseInt(String.valueOf(n4.charAt(1)));
        int z6=0+string2Unicode(String.valueOf(x2.charAt(6)));
        int s6=0+Integer.parseInt(String.valueOf(n4.charAt(2)));
        String w7="home";
        if(m6=="5566.net"||m6=="www.5566.net"||m6=="5566.org"||m6=="1.5566.org"||m6=="2.5566.org"||m6=="3.5566.org"||m6=="4.5566.org"||m6=="5.5566.org"||m6=="www.5566.org"){
            url = "http://"+p2[(h8-s1-d4-s6-v8-z6-90)/n9];
        }
        return  url;
    }
    public String n0(int n6){
        String url ;
        String s2="=''+location.host;";
        String m9="=''+document.location;";
        String t0=""+"www.5566.net";
        String w2=""+"http://www.5566.net/home-1.htm";
        String t6="1122.5566";
        String i6="9988.5566";
        int u2=t0.lastIndexOf('.');
        int q5=0+string2Unicode(String.valueOf(s2.charAt(5)));
        int q4=0+string2Unicode(String.valueOf(m9.charAt(6)));
        int l3=0+Integer.parseInt(String.valueOf(t0.charAt(u2-3)));
        int m2=0+Integer.parseInt(String.valueOf(t6.charAt(1)));
        int b3=0+Integer.parseInt(String.valueOf(t0.charAt(u2-1)));
        int x1=0+Integer.parseInt(String.valueOf(t6.charAt(2)));
        String v0="home";
        if(t0!="5566.net"&t0!="www.5566.net"&&t0!="5566.org"&&t0!="1.5566.org"&&t0!="2.5566.org"&&t0!="3.5566.org"&&t0!="4.5566.org"&&t0!="5.5566.org"&&t0!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+p2[(n6-b3-m2-x1-q5-q4-42)/l3];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("s7")) {
                    tmpUrl = s7(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("e3")) {
                    tmpUrl = e3(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("n0")) {

                    tmpUrl = n0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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

    public  void getHomeUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "财经";
        String tag2 ="房地产";
//        System.out.println(p.get(38));
        //20,38
        int[] numbers = {20,38};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }




    }


    public static void main(String[] args) {

        Home23 home23 = new Home23();

        home23.getHomeUrls("http://www.5566.net/home-1.htm");


    }








}
