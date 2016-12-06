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
public class Game37 {

    String[] t1={"0","mf.818long.com/","lieren.dawawa.com/","www.hearthstone.com.cn/","games.qq.com/esports/qqbattle/","x5.qq.com/","huoying.qq.com/","fmz.game080.com/","bns.qq.com/","xunxian.qq.com/","mir2.sdo.com/","xx.ztgame.com/","www.hearthstone.com.cn/","sq.yy.com/","www.online-game.com.cn/","zzbq.wanmei.com/","xzt.ztgame.com/","sx.12ha.com/","gui.sdo.com/","www.iyoyo.com.cn/","www.1732.com/","bw.zqgame.com/","age.qq.com/","aion.sdo.com/","www.dahanghaiol.com/","fo.qq.com/","mx.jzyx.com/","aola.100bt.com/","www.yyrpg.com/","9yang.woniu.com/","dnf.qq.com/","ff.sdo.com/","nba2k.qq.com/","au.9you.com/","st.mayiyou.com/","www.6711.com/","zg.zqgame.com/","zf.99.com/","www.ourgame.com/","www.07073.com/","tz.woniu.com/","wh2.163.com/","www.yhgame.cn/","fy.sdo.com/","wowp.kongzhong.com/","game.163.com/","wd.gyyx.cn/","moon.xoyo.com/","dx.6998.com/","cf.qq.com/","tera.klyou.com/","www.jj.cn/","shenmo.wanmei.com/","www.wanmei.com/","jr.ztgame.com/","mir2.sdo.com/","www.plu.cn/","seer.61.com/","sj.playcool.com/","sw.duoyi.com/","cbzz.6hgame.com/","sgzb.7fgame.com/","dnl.woniu.com/","wow.blizzard.cn/","fs2.175game.com/","lm.kongzhong.com/","www.131.com/","ff.zqgame.com/","bbs.houdao.com/","web.4399.com/","www.ss911.cn/","pk.leiting.com/","mu.zhaouc.net/","kz.zqgame.com/","gd.9you.com/","sq.yy.com/","www.t2uu.com/","www.yuyan.com/","lol.qq.com/index.shtml","woool2.sdo.com/","www.3839.com/","dn.sdo.com/","cf.qq.com/","www.gyyx.cn/","tiandi.object.com.cn/","mho.qq.com/","wf.changyou.com/","tiantang.qq.com/","sh2.wanku.com/","sdo.9you.com/","cq.sdo.com/","world2.wanmei.com/","mu.zhaouc.net/","sds.fly99.com/","x7.changyou.com/","www.duoyi.com/","cos.qq.com/","www.xx5.com/","qg.baiyou100.com/","xlzj.wanmei.com/","zhan.kongzhong.com/","hon.qq.com/","www.crossgate.com.cn/","jxsj.xoyo.com/","www.chinagames.net/","9.xoyo.com/","qn2.163.com/","hua.61.com/","sx.baiyou100.com/","www.awo.cn/","xxyd.1732.com/","pcik.iccgame.com/","lz.syyx.com/","fw.object.com.cn/","t.173.com/","d2.qq.com/","ds.object.com.cn/","space2.ourgame.com/","aobi.100bt.com/","www.youwo.com/","ty.yxfw.com/","rwpd.wanmei.com/","sg.qq.com/","zt2.ztgame.com/","www.ferrygame.com/","www.92wy.com/","cq.xoyo.com/","sh2.wushen.com/","xa.wanmei.com/","djz.kongzhong.com/","fj.163.com/","lx.9you.com/","www.navyfield.com.cn/","www.766.com/","xsh.changyou.com/","pao.sdo.com/","rs.wanku.com/","www.xysj.cn/","www.zuixiaoyao.com/","sg.mud001.com/","www.sgconline.com.cn/","www.luoqi.com.cn/","wf.tciplay.com/","npl.catv.net/","xt.ztgame.com/","sm.qq.com/","jw2.9you.com/","jw2.9you.com/","jl.163.com/","ty.99.com/","sgzb.7fgame.com/","shaiya.cdcgames.net/","hg.youxi.com/","www.91wan.com/","ava.qq.com/","csol.tiancity.com/","www.leyoo.com/","ss.onwind.cn/","jd.changyou.com/","sgsj.wanmei.com/","www.wushuangol.com/","qqgame.qq.com/","www.yt1.com.cn/","igame.qq.com/","bf.sdo.com/","ff.163.com/","www.100bt.com/game/","www.fantasyearth.com.cn/","jh.ztgame.com/","xy.duoyi.com/","www.cga.com.cn/","m2.sdo.com/","www.gamersky.com/","www.173uu.com/","sw.duoyi.com/","xy.linekong.com/","sd.wanmei.com/","zmq.163.com/","kk.sdo.com/","lt.zqgame.com/","www.5617.com/","nana.qq.com/","zxsj.wanmei.com/","lm.8864.com/","xy.tdgame.cn/","tps.qq.com/","mole.61.com/","wf.163.com/","yt.linekong.com/","ff.163.com/","aoqi.100bt.com/","y3.163.com/","www.178.com/","www.3234.com/","gw2.kongzhong.com/","h2.qq.com/","yl.qq.com/","tiantang2.qq.com/","wulin2.wanmei.com/","www.vsa.com.cn/","omd.qq.com/","dnh.9you.com/","tzj.iwgame.com/","ts.online-game.com.cn/","xy2.163.com/","www.woniu.com/","xt2.ztgame.com/","www.21mmo.com/","mh.tiancity.com/","xd.qq.com/","sl.changyou.com/","wuxia.qq.com/","speed.qq.com/","sw.wanmei.com/","www.xianjian.com/","ss.onwind.cn/","sg2.the9.com/","bxqt.cr-eagle.com.cn/","els.ztgame.com/","bnb.sdo.com/","xd.xoyo.com/","yt2.catv.net/","xy2.163.com/","lq.xba.com.cn/","tl.changyou.com/","game.61.com/","t7.qq.com/","sg.wanmei.com/","ts.gfyoyo.com.cn/","as.61.com/","bsg.qq.com/","ly.18day.com/","qqhx.qq.com/","zg.163.com/","xyd2.1732.com/","xlzj.wanmei.com/","xy.qq.com/","my.99.com/","rxjh.17game.com/","mxd.176.com/","www.ljy0.com/","han.70yx.com/","tx3.163.com/","nba2k.qq.com/","www.newyx.net/","yxd.qq.com/","tps.qq.com/","wy.37.com/","fs.xoyo.com/","mx.qq.com/pc/","kok3.ztgame.com/","www.yxdown.com/","www.yzz.cn/","hj.woniu.com/","wz.sdo.com/","sg.ztgame.com/","m2.sdo.com/","tz.catv.net/","go.tnyoo.com/","xyq.163.com/","www.ztgame.com/","yl.qq.com/","ds.sdo.com/","qqtang.qq.com/","dzs.qq.com/","lt.baiyou100.com/","www.51wan.com/lw/","hl.99.com/","www.xoyo.com/","nw.wanmei.com/","nz.qq.com/","mhzx2.wanmei.com/main.htm","dho.818long.com/","ty.changyou.com/","www.7k7k.com/","dnf.qq.com/","hz.changyou.com/","www.xiakeol.com/","skate.9you.com/","bh.the9.com/","www.yeyou.com/","5s.qq.com/","vc.woniu.com/","www.17173.com/","ty.ferrygame.com/","www.uuu9.com/","fs3.xoyo.com/","www.4399.com/","19base.com/index.php","bw.163.com/","pl.gameyj.com/","woool.sdo.com/","web.duowan.com/","www.yy.com/","www.aiaigame.com/","www.tj2.com.cn/","zt.ztgame.com/","xy.ixinyou.com/","xa.wanmei.com/","www.lieguo.com/","v.17173.com/","ztsj.ztgame.com/","ss.onwind.cn/","www.tjnet.com.cn/","cs.gyyx.cn/","z.ztgame.com/","jy.online-game.com.cn/","mir3.sdo.com/","mirs.sdo.com/","kx.99.com/","my.99.com/","cabal.iccgame.com/","xkx.kongzhong.com/","x5.qq.com/","tmz.99.com/","www.sdo.com/","ball.163.com/","www.wl-mj.com/","dn.sdo.com/","www.gameabc.com/","www.battlenet.com.cn/","www.dota2.com.cn/","www.37.com/","dzs.qq.com/","www.51wan.com/","zh.12ha.com/","nycs.syyx.com/","www.17game.com/","tzj.18day.com/","www.kongzhong.com/","www.woyougame.com/","tl.changyou.com/","rxjh.17game.com/","www.yt1.com.cn/","300.jumpw.com/","www.wildstar.com.cn/","www.9game.cn/cwxjlydb/","lj.zqgame.com/","qyz.sdo.com/","gd.9you.com/","sg.9wee.com/","tantra.ccjoy.com/","wt.qq.com/","ow.blizzard.cn/","wd.gyyx.cn/","www.ali213.net/","jjl.yxfw.com/","yz.q1.com/","cs.7fun.com/","9yin.woniu.com/","popogame.163.com/","rs.wanku.com/","qqtang.qq.com/","tuji.163.com/","wot.kongzhong.com/","mx.duoyi.com/","www.zfs.com.cn/","wows.kongzhong.com/","xyd.1732.com/","ffo.qq.com/","shuihu.wushen.com/","www.ispeak.cn/","www.pcgames.com.cn/","ava.qq.com/","www.5173.com/","www.woh.com.cn/","www.3366.com/","ace.yetime.cn/","td.17m3.com/","www.dota2.com.cn/","love.online-game.com.cn/","www.kele8.com/","shenmo.wanmei.com/","tx.uu661.com/","btr.qq.com/","sc.9you.com/","au.9you.com/","wow.blizzard.cn/","world2.wanmei.com/","www.xy.com/","www.pkhlk.com/","shen.qq.com/","aoa.woniu.com/","sc.9you.com/","w2i.wanmei.com/","df.jzyx.com/","t.mop.com/","www.dreamwork.cn/","ll.kongzhong.com/","qqxy.qq.com/","sxz.the9.com/","dpol.changyou.com/","www.baiyou100.com/","bns.qq.com/","sg.qq.com/","www.huoshi.cn/","wf.qq.com/","www.nd.com.cn/products/cngame.shtml","st.163.com/","popkart.tiancity.com/","csol.tiancity.com/","hbq.99.com/","ss.gyyx.cn/","ffo.changyou.com/","zbx.zqgame.com/","300.jumpw.com/","fh2.18day.com/","qqsm.zygames.com/","bm.u0.com/","pla.tarenwang.com/","fs2.xoyo.com/","jz.object.com.cn/","xt.9you.com/","tuji.163.com/","www.fsjoy.com/","nl.9hgame.com/","mm.woniu.com/","www.3dmgame.com/","td.zqgame.com/","www.fodonline.com/","www.eve-online.com.cn/","xlj.1732.com/","pcik.iccgame.com/","nyt2.catv.net/","lol.qq.com/","zhuxian.wanmei.com/","xw.zqgame.com/","ztj.ztgame.com/","xc.sdo.com/","www.eeyy.com/","dzs.qq.com/","www.tjnet.com.cn/","jz.99.com/","www.zqgame.com/","lh.9you.com/","xc.163.com/","ldj.changyou.com/","www.playcool.com/","www.saga3d.com/","ms.9you.com/","bfo.sdo.com/","wot.kongzhong.com/","games.sina.com.cn/","www.t2cn.com/","sg.zqgame.com/","djx.zugame.com/","sds2.1732.com/","www.replays.net/","xy3.163.com/","www.52pk.com/","hp2.70yx.com/","502.catv.net/","sgcq.wanmei.com/","mland.17qiqu.com/","speed.qq.com/","www.gametea.com/","aion.sdo.com/","hy.online-game.com.cn/","www.thkill.com/","dsn.99.com/","zs.176.com/","age.qq.com/","58.gyyx.cn/","tc.zqgame.com/","www.yx-mr.com/","zhlt.zugame.com/","www.xunyou.com/","huoying.qq.com/","zh.163.com/","lw.q1.com/","sl.qq.com/","www.youzu.com/","hs.5ding.com/","www.aszol.com/","www.9game.cn/cwxjlydb/","kr.ejoy.com/","www.linekong.com/","star2.176.com/","www.imop.com/","k.qq.com/","tf.tiancity.com/","fc.xunlei.com/","www.sgamer.com/","jf.qq.com/","17roco.qq.com/","dj.changyou.com/","www.btzol.com/index.htm","games.qq.com/","mxd.sdo.com/","fy.5153.com/","mir2.sdo.com/","kdxy.wanmei.com/","au2.uu5.com/","jf.qq.com/","poker.gt365.com/","firefall.com.cn/","www.m3guo.com/","www.tianyijue.com/","xy.99.com/","game.qq.com/","dtws2.163.com/","www.huowan.com/","sm.kongzhong.com/","yx3.sdo.com/","www.doyo.cn/","5jq.woniu.com/","bao.sdo.com/","au3.9you.com/","jx3.xoyo.com/","jx3.xoyo.com/","rw.joyzone.com.cn/","www.aipai.com/","xyq.163.com/","r2.qq.com/","hy.online-game.com.cn/","xy.zqgame.com/","www.hearthstone.com.cn/","lx.9you.com/","tmz.99.com/","www.cngba.com/","popkart.tiancity.com/","nz.qq.com/","www.heroesofthestorm.com.cn/","mxd.sdo.com/","xcb.sdo.com/","1000y.sdo.com/","www.changyou.com/","www.m3guo.com/v2/","ss.linekong.com/","eafifa.qq.com/","xqn.163.com/","gw2.kongzhong.com/","www.tiancity.com/","xm.xunlei.com/","www.loong3d.com/","www.shumenol.com/","game.21cn.com/","jx2.xoyo.com/","cj7.99.com/","ps2.the9.com/","lm.363.com/","ts.wanmei.com/","sg.iyoyo.com.cn/","lh.ztgame.com/","mj.xoyo.com/","qn2.163.com/","www.duowan.com/","ws.wushen.com/","www.265g.com/","www.tgbus.com/","sdxl.wanmei.com/","csol2.tiancity.com/","www.ssplay.com/","xxz.qq.com/","whjx.game080.com/","fr.baiyou100.com/","pt.yetime.cn/","dl.5ebo.com/index.html","ls.ztgame.com/","cos.qq.com/","chd.sdo.com/","jx.xoyo.com/","ff.sdo.com/","www.r2online.cn/","mx.qq.com/pc/","zhuxian.wanmei.com/","lx.9you.com/","www.m3guo.com/","ge.the9.com/","seiya.wanmei.com/","www.9you.com/","mymir.sdo.com/","xyx.2144.cn/","www.the9.com/","9yin.woniu.com/","www.cngba.com/","ef.9hgame.com/","pet.mop.com/","tx3.163.com/"};
    String y0="http://www.5566.org/indexe.htm";




    JdbcTemplate jdbcTemplate = null;

    public Game37() {
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






   public String g1(int u4){
       String url ;
        String k9="8899.5566";
        String s9="1133.5566";
        String o5="=''+location.hostname;";
        String l5="=''+document.location;";
        String w4=""+"http://www.5566.net/game1.htm";
        String a4=""+"www.5566.net";
        int z2=a4.lastIndexOf('.');
        int s3=0+Integer.parseInt(String.valueOf(s9.charAt(3)));
        int n2=0+Integer.parseInt(String.valueOf(a4.charAt(z2-1)));
        int p5=0+string2Unicode(String.valueOf(o5.charAt(5)));
        int q7=0+string2Unicode( String.valueOf(l5.charAt(6)));
        int u3=0+Integer.parseInt(String.valueOf(s9.charAt(0)));
        int a5=0+Integer.parseInt(String.valueOf(z2-3));
        String d3="game1";
        if(a4!="5566.net"&&a4!="www.5566.net"&&a4!="5566.org"&&a4!="1.5566.org"&&a4!="2.5566.org"&&a4!="3.5566.org"&&a4!="4.5566.org"&&a4!="5.5566.org"&&a4!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+t1[(u4-a5-n2-s3-p5-q7-59)/u3];
        }
        return  url;
    }
   public String  y7(int z0){
       String url = "";
        String b0="3311.5566";
        String e1="=''+location.host;";
        String b6=""+"www.5566.net";
        String g4="6677.5566";
        String k2=""+"http://www.5566.net/game1.htm";
        String i9="=''+document.URL;";
        int l0=b6.lastIndexOf('.');
        int c6=0+ Integer.parseInt(String.valueOf(g4.charAt(3)));
        int i5=0+string2Unicode(String.valueOf(e1.charAt(5)));
        int r4=0+Integer.parseInt(String.valueOf(b6.charAt(l0-3)));
        int b2=0+Integer.parseInt(String.valueOf(b6.charAt(l0-1)));
        int m0=0+Integer.parseInt(String.valueOf(g4.charAt(0)));
        int g3=0+string2Unicode(String.valueOf(i9.charAt(6)));
        String w8="game1";
        if(k2.indexOf("5566")>=0&&k2.indexOf("game1")>=0){
            url = "http://"+t1[(z0-b2-m0-c6-i5-g3-88)/r4];
        }
        return  url;
    }
    public String e3(int n5){
        String url;
        String j8="=''+location.href;";
        String j6=""+"www.5566.net";
        String w0="=''+document.domain;";
        String k9="7766.5566";
        String u7=""+"http://www.5566.net/game1.htm";
        String t8="9988.5566";
        int r8=j6.lastIndexOf('.');
        int w6=0+string2Unicode(String.valueOf(j8.charAt(6)));
        int o7=0+Integer.parseInt(String.valueOf(j6.charAt(r8-3)));
        int e5=0+string2Unicode(String.valueOf(w0.charAt(5)));
        int l6=0+Integer.parseInt(String.valueOf(t8.charAt(3)));
        int o0=0+Integer.parseInt(String.valueOf(t8.charAt(1)));
        int g0=0+Integer.parseInt(String.valueOf(j6.charAt(r8-1)));
        String t7="game1";
        if(u7.indexOf("5566")==-1||u7.indexOf("game1")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+t1[(n5-o7-o0-l6-e5-w6-38)/g0];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("g1")) {
                    tmpUrl = g1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("y7")) {
                    tmpUrl = y7(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("e3")) {

                    tmpUrl = e3(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

                }
            } catch (Exception e) {
                tmpUrl = href.attr("href");
                tmpName = href.text();
            }
            if (tmpUrl.length() > 7) {

//                System.out.println(tmpUrl + "---------" + tmpName);

                inserTable(tag1, tag2, tmpUrl, tmpName);

            }
        }

    }



    public  void getGameUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "娱乐";
        String tag2 ="游戏";
//        System.out.println(p.get(112));
//        //17,39,53,73,90,103,112
        int[] numbers = {17,39,53,73,90,103,112};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }







    }

    public static void main(String[] args) {

        Game37 game37 = new Game37();
        game37.getGameUrls("http://www.5566.net/game1.htm");




    }









}
