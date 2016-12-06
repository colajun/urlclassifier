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
public class News9 {

    String[] c4={"0","www.chinajilin.com.cn/","news.qq.com/topic/feature.htm","www.zgqxn.com/","www.heb.chinanews.com.cn/","sh.eastday.com/","www.takungpao.com/","www.taizhou.com.cn/","news.cyol.com/node_10019.htm","photo.ifeng.com/","www.sxycrb.com/","www.jmnews.com.cn/","www.weblz.com.cn/","www.dalidaily.com/","www.bj.xinhuanet.com/","cpc.people.com.cn/","www.sznews.com/","www.jzrb.com/","www.dahuawang.com/","www.chinanews.com/photo/","www.fj.chinanews.com/","www.wuhubtv.com/","tibet.news.cn/","www.nmg.xinhuanet.com/","www.qhnews.com/","www.libertytimes.com.tw/","www.gxnews.com.cn/","www.qdhnews.com.cn/","www.gyxww.cn/","sznews.oeeee.com/","tech.sina.com.cn/","www.enorth.com.cn/","www.zgnt.net/","www.yn.xinhuanet.com/","news.sina.com.cn/area/sc.shtml","pic.sohu.com/","www.tj.xinhuanet.com/","www.ynet.com/","www.xnnews.com.cn/","www.chinatimes.cc/","www.wuhunews.cn/","www.ch365.com.cn/","www.qzwb.com/","www.qz828.com/","news.online.sh.cn/","www.gz.xinhuanet.com/","www.fynews.net/","www.shm.com.cn/","www.yunnan.cn/","photo.china.com.cn/","www.changsha.cn/","qiqihar.dbw.cn/","www.lunannews.com/","www.tynews.com.cn/","photo.sina.com.cn/","www.dfdaily.com/","www.hf365.com/","www.dezhoudaily.com/","www.0745news.cn/","www.xiancn.com/","www.laiwunews.cn/","www.plxww.com/","www.cq.chinanews.com.cn/","hunan.voc.com.cn/","www.cyol.net/","www.people.com.cn/","www.infzm.com/","www.xinhuanet.com/zgjx/","www.jjxw.cn/","hunan.voc.com.cn/","www.cq.xinhuanet.com/","www.leshan.cn/","club.news.sohu.com/","view.163.com/","www.xj.chinanews.com/","www.gscn.com.cn/","news.china.com/zh_cn/focus/index.html","www.ywnews.cn/","www.qingdaonews.com/","news.dayoo.com/","www.macaodaily.com/","www.sd.chinanews.com.cn/","www.lanzhou.cn/","www.xinhuanet.com/comments/","www.xj.xinhuanet.com/","www.sxdaily.com.cn/","www.cb.com.cn/","gd.news.sina.com.cn/","www.nxnet.cn/","news.cpd.com.cn/","www.yellowriver.gov.cn/","news.yninfo.com/","www.baoye.net/","www.nx.xinhuanet.com/","www.cet.com.cn/","www.gx.chinanews.com/","www.cnwest.com/","www.ybxww.com/","www.dtnews.cn/","www.chinaqw.com/","www.lnd.com.cn/","www.ybnews.cn/","www.sc.chinanews.com/","www.hn.chinanews.com/","news.sina.com.cn/focus/index.shtml","news.ycwb.com/","www.aqzyzx.com/","www.yn.chinanews.com/","www.rznews.cn/","news.21cn.com/","www.bbnews.cn/","gb.cri.cn/","www.zgfznews.com/","www.ha.chinanews.com/","www.news365.com.cn/","www.hbnews.net/","cn.wsj.com/","www.chinatibetnews.com/","www.sznews.com/","jiangxi.jxnews.com.cn/","www.jhnews.com.cn/","www.zjol.com.cn/","www.lznews.cn/","www.czxww.cn/","cn.chinadaily.com.cn/","www.js.xinhuanet.com/","www.xjbs.com.cn/","www.sjzdaily.com.cn/","www.chinajilin.com.cn/jlnews/node_114.htm","chaoyang.nen.com.cn/","www.xtnews.gov.cn/","www.cdns.com.tw/","www.01ny.cn/","www.zhuzhouwang.com/","www.gmw.cn/","www.handannews.com.cn/","www.hq.xinhuanet.com/","news.cyol.com/node_10009.htm","www.js.chinanews.com/","www.syd.com.cn/","www.hynews.net/","news.sina.com.cn/zt/","www.sh.xinhuanet.com/","www.iqilu.com/","news.hsw.cn/","www.taiwan.cn/","news.tom.com/","star.news.sohu.com/","www.huaxia.com/","news.eastday.com/","www.he.xinhuanet.com/","www.sxjzxww.com/","www.jx.xinhuanet.com/","www.ln.chinanews.com/","www.inewsweek.cn/","www.singtao.ca/","www.xhby.net/","www.fjsen.com/","gb.cri.cn/photo/","www.njnews.cn/","www.sd.xinhuanet.com/news/","www.dzwww.com/","www.bjnews.com.cn/","photo.huanqiu.com/","www.lyg1.com/","news.zj.com/","news.163.com/photo/","www.zjol.com.cn/","www.dahe.cn/","www.ycwb.com/","www.gansudaily.com.cn/","news.sina.com.cn/opinion/index.shtml","www.gx.xinhuanet.com/","www.infzm.com/","www.anhuinews.com/","www.ynet.com/","www.ycen.com.cn/","www.xinhuanet.com/","www.scol.com.cn/","www.yangtse.com/","www.rednet.cn/","www.fj.xinhuanet.com/","www.ah.chinanews.com.cn/","www.gs.xinhuanet.com/","www.ylxw.com.cn/","www.mxrb.cn/","www.yongzhou.gov.cn/","www.my399.com/","www.tianya.cn/Publicforum/ArticlesList/0/worldlook.shtml","www.cnhubei.com/","www.xsnet.cn/","www.hsw.cn/","www.scio.gov.cn/","www.jl.chinanews.com/","www.ncnews.com.cn/","cn.reuters.com/","www.heze.cn/","www.newshs.com/","www.crntt.com/","www.gog.cn/","news.ifeng.com/","www.chinanews.com/","news.sogou.com/","hn.rednet.cn/","www.hinews.cn/news/hainan/index.shtml","www.northnews.cn/","www.ptxw.com/","news.sina.com.cn/","www.jxnews.com.cn/","www.nownews.com/","www.66wz.com/","news.sohu.com/","www.huanqiu.com/","news.dayoo.com/","www.whnews.cn/","www.zynews.com/","www.xdkb.net/","photo.qianlong.com/","www.yqnews.com.cn/","www.sdnews.com.cn/","www.jinghua.cn/","www.baojinews.com/","news.online.sh.cn/","www.e0734.com/","www.thepaper.cn/","www.zjjnews.cn/","www.ldnews.cn/","www.nmgnews.com.cn/","www.stardaily.com.cn/","www.fznews.com.cn/","pic.people.com.cn/","www.hn.xinhuanet.com/","www.hangzhou.com.cn/","news.21cn.com/guangdong/","cq.cqnews.net/","news.ifeng.com/special/","media.people.com.cn/","www.chinatimes.com/","www.xinmin.cn/","www.jiaodong.net/","news.lnd.com.cn/","www.lyd.com.cn/","news.thmz.com/","www.yznews.com.cn/","www.lfnews.cn/","news.hainan.net/","www.66163.com/","www.jsinfo.net/","www.szsnews.com/","sichuan.scol.com.cn/","www.fjsen.com/","www.gxnews.com.cn/","www.sxrb.com/","www.cnnb.com.cn/","www.xinhuanet.com/newmedia/","epaper.southcn.com/","www.tianjinwe.com/","www.yuxinews.com/","www.ln.xinhuanet.com/","www.cnr.cn/","www.wfnews.com.cn/","www.ycnews.cn/","www.southcn.com/","news.online.tj.cn/","www.gznet.com/news/","www.hb.xinhuanet.com/","heilongjiang.dbw.cn/","www.newssc.org/","www.ccn.com.cn/","www.cankaoxiaoxi.com/","www.jznews.com.cn/","www.news365.com.cn/","www.gs.chinanews.com/","news.sdinfo.net/","www.sh.chinanews.com/","www.zjknews.com/","www.greatwuyi.com/","www.tznews.cn/","pinglun.eastday.com/","www.nxnews.net/","www.my399.com/","www.hxnews.com/","www.lcxw.cn/","news.qq.com/photo.shtml","www.hebei.com.cn/","news.163.com/","www.rednet.cn/","www.jmnews.cn/","www.lzbs.com.cn/","www.tlnews.cn/","www.nen.com.cn/","www.edunews.net.cn/","www.sanqin.com/","www.yndaily.com/","www.ts.cn/","pic.cnr.cn/","www.legaldaily.com.cn/","www.zaobao.com/","www.runsky.com/","www.takungpao.com/","www.hynews.org/","www.ha.xinhuanet.com/","www.0730news.com/","www.hi.chinanews.com/","www.sn.xinhuanet.com/","www.xmnn.cn/","www.bj.chinanews.com/","www.jfdaily.com/","bbs.people.com.cn/","news.cntv.cn/","www.zbnews.net/","forum.home.news.cn/listthread/84/1.html","www.gd.chinanews.com/","www.qh.xinhuanet.com/","www.sx.chinanews.com/","www.eznews.cn/","www.bndaily.com/","beijing.qianlong.com/","www.zj.xinhuanet.com/","www.gd.xinhuanet.com/","www.kf.cn/","www.luaninfo.com/","www.sx.xinhuanet.com/","www.hljnews.cn/","www.zznews.cn/","www.jl.xinhuanet.com/","www.hxnews.com/","whb.news365.com.cn/","www.sc.xinhuanet.com/","www.china.com.cn/","view.news.qq.com/","news.qq.com/","www.longhoo.net/","www.dlxww.com/","zjnews.zjol.com.cn/","www.stdaily.com/","www.xinjiangnet.com.cn/","yunnan.yunnan.cn/","www.ls666.com/","www.fxrbs.cn/","www.81.cn/","www.sxgov.cn/","www.hsdcw.com/","www.scol.com.cn/","www.allnet.cn/","www.nfcmag.com/","www.qianlong.com/","www.hinews.cn/","www.luohe.com.cn/","www.stnn.cc/","www.cnsphoto.com/","www.chiznews.com/","www.aqnews.com.cn/","www.snxw.com/","www.sxxw.net/","www.enshi.cn/","www.cqnews.net/","news.china.com/","www.xtol.cn/","www.wenweipo.com/","www.ndnews.cn/","www.southcn.com/","www.dqdaily.com/","www.hb.chinanews.com/","sx.people.com.cn/","www.zgjtb.com/","www.wnnews.cn/","www.hlj.xinhuanet.com/","www.news.cn/photo/","www.taihainet.com/","ah.anhuinews.com/","www.bandao.cn/","www.hebnews.cn/","www.ce.cn/","www.pdsxww.com/","www.jxcn.cn/","www.wenweipo.com/","www.cn3x.com.cn/","www.bjd.com.cn/","www.lyg01.net/","cctv.cntv.cn/lm/xinwenlianbo/index.shtml","www.e23.cn/","www.lznews.gov.cn/","www.shx.chinanews.com/","www.cjn.cn/","www.newssc.org/","www.oeeee.com/","www.dbw.cn/"};
    String p3="http://www.5566.org/indexe.htm";
    JdbcTemplate jdbcTemplate = null;
    public News9(){
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

   public String  z4(int t4){
       String url;
        String i1=""+"www.5566.net";
        String k9="9966.5566";
        String h8="7744.5566";
        String i2="=''+location.href;";
        String x8=""+"http://www.5566.net/news.htm";
        String h6="=''+location.host;";
        int o6=i1.lastIndexOf('.');
        int d8=0+Integer.parseInt(String.valueOf(i1.charAt(o6-3)));
        int n0=0+Integer.parseInt(String.valueOf(h8.charAt(2)));
        int l3=0+Integer.parseInt(String.valueOf(i1.charAt(o6-1)));
        int d4=0+string2Unicode(String.valueOf(i2.charAt(6)));
        int t0=0+Integer.parseInt(String.valueOf(h8.charAt(1)));
        int w9=0+string2Unicode(String.valueOf(h6.charAt(5)));
        String c5="news";
        if(x8.indexOf("5566")==-1||x8.indexOf("news")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+c4[(t4-d8-l3-n0-w9-d4-22)/t0];
        }
        return  url;
    }
    public String  s0(int r5){
        String url = "";
        String g5=""+"http://www.5566.net/news.htm";
        String u6="=''+document.URL;";
        String x7="4477.5566";
        String u9="5533.5566";
        String  q5=""+"www.5566.net";
        String e0="=''+location.hostname;";
        int v6=q5.lastIndexOf('.');
        int q9=0+Integer.parseInt(String.valueOf(u9.charAt(0)));
        int a5=0+string2Unicode(String.valueOf(u6.charAt(6)));
        int h5=0+Integer.parseInt(String.valueOf(u9.charAt(2)));
        int m2=0+Integer.parseInt(String.valueOf(q5.charAt(v6-1)));
        int e8=0+Integer.parseInt(String.valueOf(q5.charAt(v6-3)));
        int s7=0+string2Unicode(String.valueOf(e0.charAt(5)));
        String f3="news";
        if(g5.indexOf("5566")>=0&&g5.indexOf("news")>=0){
            url = "http://"+c4[(r5-m2-q9-h5-s7-a5-96)/e8];
        }
        return  url;
    }
    public String  g0(int q6){
        String url ;
        String e4="=''+document.domain;";
        String s2=""+"http://www.5566.net/news.htm";
        String z0=""+"www.5566.net";
        String y4="=''+document.location;";
        String k9="3355.5566";
        String  z2="6699.5566";
        int f4=z0.lastIndexOf('.');
        int w6=0+string2Unicode(String.valueOf(e4.charAt(5)));
        int w7=0+Integer.parseInt(String.valueOf(z2.charAt(0)));
        int h2=0+Integer.parseInt(String.valueOf(z0.charAt(f4-3)));
        int h0=0+string2Unicode(String.valueOf(y4.charAt(6)));
        int w1=0+Integer.parseInt(String.valueOf(z2.charAt(2)));
        int b2=0+Integer.parseInt(String.valueOf(z0.charAt(f4-1)));
        String o7="news";
        if(z0!="5566.net"&&z0!="www.5566.net"&&z0!="5566.org"&&z0!="1.5566.org"&&z0!="2.5566.org"&&z0!="3.5566.org"&&z0!="4.5566.org"&&z0!="5.5566.org'&&z0!='www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+c4[(q6-h2-w7-w1-w6-h0-45)/b2];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("z4")){
                    tmpUrl = z4(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if  (onclick.substring(0, 2).equalsIgnoreCase("s0")){
                    tmpUrl = s0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if(onclick.substring(0, 2).equalsIgnoreCase("g0")){

                    tmpUrl = g0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

                }
            } catch (Exception e) {
                tmpUrl = href.attr("href");
                tmpName = href.text();
            }
            if(tmpUrl != ""){

//                System.out.println(tmpUrl +"---------"+tmpName);

            inserTable(tag1, tag2, tmpUrl, tmpName);

            }
//            System.out.println(tmpUrl +"---------"+tmpName);

//            inserTable(tag1, tag2, tmpUrl, tmpName);

        }



    }
    public  void get(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "新闻媒体";
        String tag2 ="";
//        System.out.println(p.get(48));
        //20,48, 139,148, 156
        int[] numbers = {20,48, 139,148, 156};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }


    }

    public static void main(String[] args) {

        News9 news9 = new News9();

        news9.get("http://www.5566.net/news.htm");



    }











}
