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
 * Created by hadoop on 16-11-27.
 */
public class Eat73 {
    String[] r6={"0","food.xtrb.cn/","cook.poco.cn/","www.gz-travel.net/msyl/","www.ptccc.com/","food.hiao.com/","meishi.dezhoudaily.com/","food.szonline.net/","eat.online.sh.cn/","www.longnan.ccoo.cn/meishi/","gd.sina.com.cn/food/zt/dgmeishpd/index.shtml","www.xinshipu.com/","ms.xiangyang.net/","www.iecate.com/","www.zztv.tv/tvprogram/program_64.shtml","travel.citygf.com.cn/fsmeishi/","cate.66wz.com/","cq.qq.com/eat/","www.dtnews.cn/food/","bbs.tianya.cn/list-96-1.shtml","www.cqmsw.roboo.com/","www.qhdmsw.com/","chwl.scol.com.cn/","www.qthcy.com/","www.022ms.com/","www.78ms.com/","food.ts.cn/","yingyang.51240.com/","www.cqsq.com/list/149/","www.xa01.com/","food.runsky.com/","henan.qq.com/food/","www.sc168.com/pindao/meishi/node_900.htm","www.nymsw.net/","www.weidaoxj.com/","www.beitaichufang.com/","www.douguo.com/caipu/","www.yuxi.cn/ms/index.shtml","meishi.beihai365.com/","gl.food.poco.cn/","www.zhms.cn/","www.6eat.com/","www.cooking.net.cn/","eat.gd.sina.com.cn/","www.smnet.com.cn/mspd/","food.c3618.cn/","www.hgsm.com.cn/","www.openrice.com.cn/","www.ccmsh.com/","www.pdswyc.com/","www.kmmsw.net/","www.meishichina.com/","www.0745tv.com/folder105/","chihe.sohu.com/","www.meishichina.com/Eat/","sgfood.sgxw.cn/","www.056177.com/","www.512ms.com/","food.poco.cn/","food.dqdaily.com/","csms.czonline.net/","chihuo.jstv.com/","meishi.0513.org/","food.xiadu.com/","www.0559ms.com/","sh.sina.com.cn/food/","cd.qq.com/ieat/","www.chi020.com/","www.dzxw.net/food/","www.jmnews.com.cn/a/food.htm","cate.cnr.cn/","www.gscn.com.cn/food/","jjsx.china.com.cn/meishi/","eat.sh/","www.gudumami.cn/","food.52zjk.cn/","www.hualongxiang.com/meishi","food.cnbb.com.cn/","food.e0514.com/","gd.qq.com/food/","ms.shm.com.cn/","hb.qq.com/enjoy/","www.chaofood.com/","www.gudumami.cn/","www.hbtv.com.cn/column/food/","www.kaifeng365.net/","www.lpswz.com/news/node_178.htm","cctv.cntv.cn/lm/tiantianyinshi/","www.yccycs.com/","www.cngdmsw.roboo.com/","www.bzcm.net/canyin/","www.eat4.com/fancy/index.html","www.0771eat.com/","ln.qq.com/food/","www.sxrtv.com/content/w/f/","www.0746msw.com/","www.tzmsw.net/","www.sxszmsw.com/","www.eat4.com/western/index.html","eat.changsha.cn/","www.comedali.com/food/","www.zznews.cn/meishi/","www.jgsdaily.com/ms/","www.cqmsw.cn/","www.whms512.com/","food.qianggen.com/","www.msw123.cn/","www.hebeicy.com/","www.nmgcy.org.cn/","www.czlook.com/czcms/zixunban/changzhimeishi/","www.xmmeishi.com/","www.07908.com/forum-121-1.html","www.xiaomishu.com/","www.sanxia.cc/","www.tfysw.com/","www.yznews.com.cn/yznews08/mspd/","www.sqmsw.com/","www.314ms.com/","www.eatlz.com/","www.hb.xinhuanet.com/food/","food.taizhou.com.cn/","bbs.chizhouren.com/forum-57-1.html","club.chihe.sohu.com/","www.zjeat.com/","food.yunnan.cn/","www.tfysw.com/","www.0467ms.com/","food.19lou.com/","www.haodou.com/recipe/all","www.kfeat.com/","www.0558hc.com/","www.mdjcy.com/","www.suizhoushi.com/foods/","eat.gansudaily.com.cn/","www.ihgx.cn/","meal.dbw.cn/","www.ycms.cn/","www.ccas.com.cn/","www.eat4.com/domestic/index.html","www.wifi0832.com/","www.lyxfzn.com/","hbeat.net/","food.zbinfo.net/","c.zyrb.com.cn/","food.0575360.com/","www.haodou.com/","www.zzms.cn/","www.xamsw.cn/","www.iweihai.cn/food/","www.xj.xinhuanet.com/meishi/","life.dayoo.com/meal/","food.dlxww.com/","www.bjys.org/","food.bandao.cn/","www.bjcate.com/","food.hyqss.cn/","www.jsmsw.com.cn/","www.meishitui.com/","gz.food.poco.cn/","www.veg520.com/","www.zghnc.com/","www.nbtv.cn/meishi/","eat.cnwest.com/","www.qianmeishi.com/","bbs.zjchina.cc/forum-169-1.html","caipu.haochi123.com/","www.gamsw.com/","www.koubei.com/","www.zspoco.com/","www.rrmsw.com/","www.lysss.com/","www.scfood.net/","www.jxmsw.org/","www.zsnews.cn/Eating/","www.zsfood.cn/modoer/","food.lhjiaju.com/","food.yinsha.com/","www.chinatibetnews.com/shxf/ms/","food.lzep.cn/","food.gxsky.com/","www.51ttyy.com/","www.qjxxw.cn/forum-43-1.html","www.eat4.com/","wenzhou.news.163.com/special/03440PCK/meishi.html","food.bajingwang.com/","www.yummyshandong.com/","food.tiboo.cn/","www.meishij.net/chufang/diy/","meishi.wh5000.com/","huzhou.19lou.com/forum-763-1.html","bbs.habctv.com/forum-43-1.html","www.hainanms.com/","www.qzfood.com/","food.hinews.cn/","hn.qq.com/food/","www.jiaodong.net/food/","fj.qq.com/eat/","food.jinhua.com.cn/","www.xmcy.net/","food.ahlife.com/","food.hdzc.net/","www.wnnews.cn/food/","chihehuizhou.com/","www.syms163.com/","www.cywtv.cn/","www.nxing.cn/meishicn/","www.hrbmeishi.cn/","www.szeat.net/","www.cdcate.com/","www.mcdonalds.com.cn/coupon/detail","www.dianping.com/","js.qq.com/eat/","www.00752.com/","cate.syd.com.cn/","www.jnnews.tv/food/","henan.sina.com.cn/food/","www.nalichi.com/","www.meishij.net/","www.hzmsw.cc/","www.zhms.cn/Ms_menu/","www.hf777.com/","www.00752.com/","www.xc777.com/","www.0415food.com/","zj.qq.com/food/","www.100du.com/","www.0771ms.com/","www.qdmeishi.com/","www.lygsms.com/","sd.ifeng.com/food/","www.sbar.com.cn/","food.xizi.com/","xian.qq.com/food/","www.cook18.com/","bbs.nantaihu.com/thread-htm-fid-6.html","food.xmfish.com/","www.ttmeishi.com/","blog.sina.com.cn/lm/eatblog.html","ms.qjren.com/","www.qunachi.com/","www.xyxunwei.com/","meishi.liaozhai.tv/","www.hyqss.cn/zhuanti/mwhy/","food.hsw.cn/","eat.cqnews.net/","wish.gdzjdaily.com.cn/","food.baotounews.com.cn/","food.huainet.com/","www.0598food.com/","m.thmz.com/","food.cntv.cn/","www.wenzcyw.com/","www.dlmsw168.com/","food.iyaxin.com/","www.czxww.cn/ms/List/List_3795.html","7.st001.com/","www.jsms123.com/","www.gztsxc.com/","www.n21.cc/ms/","www.dycy001.com/","food.hinews.cn/","bbs.tlt.cn/forum-7-1.html","www.1797.com.cn/","youhui.kfc.com.cn/","ms.0735.com/","cate.kunming.cn/","www.ndmsw.com/","www.lzmsb.com/","food.online.qh.cn/","food.gxnews.com.cn/","www.linyi.com/life/food.html","food.gdzj8.com/","henan.163.com/meishi/"};
    String o7="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public Eat73(){
        try {
            jdbcTemplate = JDBCHelper.createMysqlTemplate("mysql1", "jdbc:mysql://192.168.21.60/urlclassifier?useUnicode=true&characterEncoding=utf8", "root", "root", 5, 30);

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

    public String  o2(int x1){
        String url;
        String i4="=''+location.host;";
        String a8="=''+location.href;";
        String y4="1133.5566";
        String a3=""+"www.5566.net";
        String o3="2277.5566";
        String w8=""+"http://www.5566.net/eat-1.htm";
        int h1=a3.lastIndexOf('.');
        int c4=0+string2Unicode(String.valueOf(i4.charAt(5)));
        int n8=0+string2Unicode(String.valueOf(a8.charAt(6)));
        int v8=0+Integer.parseInt(String.valueOf(o3.charAt(3)));
        int x3=0+Integer.parseInt(String.valueOf(a3.charAt(h1-3)));
        int j8=0+Integer.parseInt(String.valueOf(a3.charAt(h1-1)));
        int j1=0+Integer.parseInt(String.valueOf(o3.charAt(1)));
        String d8="eat";
        if(a3!="5566.net"&&a3!="www.5566.net"&&a3!="5566.org"&&a3!="1.5566.org"&&a3!="2.5566.org"&&a3!="3.5566.org"&&a3!="4.5566.org"&&a3!="5.5566.org"&&a3!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+r6[(x1-x3-j1-v8-c4-n8-51)/j8];
        }
        return  url;
    }
    public String  l8(int q6){
        String url;
        String c8=""+"http://www.5566.net/eat-1.htm";
        String o1="=''+location.hostname;";
        String w6="=''+document.location;";
        String d0=""+"www.5566.net";
        String x4="6688.5566";
        String b4="3311.5566";
        int o6=d0.lastIndexOf('.');
        int d1=0+Integer.parseInt(String.valueOf(b4.charAt(1)));
        int g2=0+string2Unicode(String.valueOf(o1.charAt(5)));
        int h0=0+string2Unicode(String.valueOf(w6.charAt(6)));
        int m8=0+Integer.parseInt(String.valueOf(d0.charAt(o6-3)));
        int v7=0+Integer.parseInt(String.valueOf(b4.charAt(2)));
        int t4=0+Integer.parseInt(String.valueOf(d0.charAt(o6-1)));
        String u7="eat";
        if(c8.indexOf("5566")==-1||c8.indexOf("eat")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+r6[(q6-t4-d1-v7-g2-h0-41)/m8];
        }
        return  url;
    }
   public String  e9(int c6){
       String url = "";
        String b2="8866.5566";
        String y4="7722.5566";
        String u1="=''+document.URL;";
        String v6=""+"www.5566.net";
        String e6="=''+document.domain;";
        String l6=""+"http://www.5566.net/eat-1.htm";
        int n1=v6.lastIndexOf('.');
        int j2=0+Integer.parseInt(String.valueOf(v6.charAt(n1-1)));
        int y8=0+Integer.parseInt(String.valueOf(b2.charAt(2)));
        int s7=0+string2Unicode(String.valueOf(u1.charAt(6)));
        int x7=0+Integer.parseInt(String.valueOf(v6.charAt(n1-3)));
        int n5=0+string2Unicode(String.valueOf(e6.charAt(5)));
        int w0=0+Integer.parseInt(String.valueOf(b2.charAt(1)));
        String o9="eat";
        if(v6=="5566.net"||v6=="www.5566.net"||v6=="5566.org"||v6=="1.5566.org"||v6=="2.5566.org"||v6=="3.5566.org"||v6=="4.5566.org"||v6=="5.5566.org"||v6=="www.5566.org"){
           url = "http://"+r6[(c6-x7-j2-y8-n5-s7-81)/w0];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("o2")) {
                    tmpUrl = o2(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("l8")) {
                    tmpUrl = l8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("e9")) {

                    tmpUrl = e9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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



    public  void  getUrls(String url){


        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "生活";
        String tag2 = "美食";
//        System.out.println(p.get(46));
//        //20,35, 46
        int[] numbers = {20,35, 46};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }


    }
    public static void main(String[] args) {

        Eat73 eat73 = new Eat73();
        eat73.getUrls("http://www.5566.net/eat-1.htm");



    }





}
