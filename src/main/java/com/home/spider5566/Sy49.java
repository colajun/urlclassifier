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
 * Created by hadoop on 16-11-24.
 */
public class Sy49 {
    String[]  z7={"0","www.ooopic.com/","www.shphoto.com.cn/","academy.fengniao.com/","www.canon.com.cn/products/camera/index.html","www2.xitek.com/production/","photo.xitek.com/","www.cinsee.com/bbs/","www.tianya.cn/publicforum/articleslist/0/tianyaphoto.shtml","www.jxpa.net/","product.it168.com/list/b/0306_1.shtml","www.zjphoto.com.cn/","www.js.xinhuanet.com/jsssyjxh/","www.weihaiphoto.com/","www.pentax.com.cn/","www.ea360.com/","www.hebpa.net/","cn.hasselblad.com/","www.23ps.com/","vision.xitek.com/classroom/","myphoto.tech.sina.com.cn/","scphoto.sctv.com/","www.xbphotool.com/","www.cnphotos.net","photo.sohu.com/","www.photosanxia.com/","www.benq.com.cn/","www.wangjianxin.com/","www.dpnet.com.cn","www.dslrtips.com/","blog.qq.com/camera/","www.huolieniao.net/","www.zsheying.com/","dv.pcpop.com/","www.cd-pa.com/","consumer.panasonic.cn/product/cameras-camcorders.html","www.imaging-resource.com/","academy.fengniao.com/list_969.html","photo.33519.com/","qicai.fengniao.com/","www.cpanet.cn/","www.rayi.cn/","www.hbssyjxh.com/forum.php","bbs.dpnet.com.cn/","www.unpcn.com/","www.rxsy.net/","www.dpreview.com/","www.gdyphoto.com/","www.cppclub.com/","photo.iqilu.com/","www.long-photo.com/","www.zeiss.com.cn/","tu.fengniao.com/","www.fotomen.cn/","dc.pconline.com.cn/","www.weon.cn/","www.china-photo-model.com/","www.tianxiasy.com/","www.xiangshu.com/","www.qzphoto.com/","dcdv.zol.com.cn/more/2_785.shtml","dc.it168.com/","www.ccsph.com/","photos.nphoto.net/gallery/","news.cnphotos.net/pic/","www.zjphoto.org/","www.23ps.com/","dc.pconline.com.cn/pingce/","www.psahz.com/","www.sxsphoto.com/","www.cppfoto.com/","www.moko.cc/","www.xjsyjxh.cn/","www.68ps.com/","www.bjpanet.com/","www.cphoto.net/","www.chinaphotography.com/","www.7192.com/","www.sonystyle.com.cn/products/ildc/index.htm","www.fujifilm.com.cn/","www.samsung.com/cn/consumer/computers-office/camera-lens/","www.sdasy.com/","www.hsphoto.org/","dc.pchome.net/","www.bssyw.com/","www.julur.com/","tech.sina.com.cn/digi/dv/","www.syzygx.com/","www.hnph.cn/","www.photohn.com/","www.tamron.com.cn/","www.lenstip.com/","www.camgle.com/","photo.dili360.com/","bbs.cnphotos.net/","www.photozone.de/","www.yupoo.com/","dp.pconline.com.cn/list/all.html","product.pchome.net/digital_dc/list__103.html","www.cqpa.org/","bbs.51sheying.com/","www.xitek.com/","www.yqdc.com/","dp.pconline.com.cn/","www.xiangshu.com/pic/2","www.lnsyjxhw.com/","www.wed114.cn/","www.enet.com.cn/dc/","www.dpnet.com.cn/School/SchoolHome.aspx","www.peoplephoto.com/","detail.zol.com.cn/digital_camcorder_index/subcate81_list_1.html","www.kenko-tokina-slik.cn/","www.leica.org.cn/","www.jingnei.net/","www.dxomark.com/","ssx.caisee.cn/","www.zzphoto.org/","www.51sheying.com/","www.nikon.com.cn/","www.enet.com.cn/dv/","www.gitzo.cn/","www.glphotocenter.com/","tuchong.com/","dv.zol.com.cn/","www.135-120-220.com/","www.ttcy.cn/","www.sxpac.com/","www.photographybay.com/","photo.poco.cn/vision.php","sy.huanqiu.com/","www.xinhuanet.com/foto/index.htm","www.xiangshu.com/","photo.poco.cn/jiqiao/","www.pop-photo.com.cn/","www.phenixoptics.com.cn/","arts.cphoto.net/Html/syll/xxyd/index.html","www.51sheyuan.com/","digi.163.com/dc/","www.mamiya.com/","www.cameralabs.com/","www.gdphoto.cn/","product.pconline.com.cn/dc/","www.sonystyle.com.cn/products/slt/index.htm","www.tzphoto.org/","www.missyuan.com/","www.photoker.com/","www.pcpop.com/common/Article_2_005600046_5_0_1.htm","www.photoreview.com.au/","www.casio.com.cn/dc/","dv.pconline.com.cn/","itbbs.pconline.com.cn/dc/","pp.163.com/","www.fengniao.com/","dv.yesky.com/","product.fengniao.com/","www.xrite.cn/imaging.aspx","www.chinavr.net/","www.fotoe.com/main","www.the-digital-picture.com/Reviews/ISO-12233-Sample-Crops.aspx","photo.poco.cn/","www.nphoto.net/","www.photofans.cn/album/index.php","www.cphoto.com.cn/","photo.xitek.com/","www.cpanet.cn/","www.heiguang.com/","product.pchome.net/digital_dv/list__104.html","www.kodak.com.cn/","cn.leica-camera.com/","www.manfrotto.cn/","forums.nphoto.net/","bbs.heiguang.com/","bbs.fengniao.com/forum/","www.photops.com/","www.blanca.com.cn/","www.chinaphoto.cc/","www.whart.net/","dc.pcpop.com/","bbs.xianpp.com/","www.cpaedu.cn/","www.jvc.com.cn/","forum.xitek.com/","www.gzsyphoto.org/","dc.yesky.com/","bbs.photops.com/","bbs.cpanet.cn/","www.jmyx.com.cn/","detail.zol.com.cn/digital_camera_index/subcate15_list_1.html","www.icfpa.cn/","www.olympus.com.cn/","www.benro.cn/","www.sonystyle.com.cn/products/cyber-shot/index.htm","www.sigma-photo.com.cn/","product.it168.com/list/b/0305_1.shtml","www.photoworld.com.cn/","dcbbs.zol.com.cn/","www.julur.com/forum/","dcdv.zol.com.cn/","www.photofans.cn/forum/index.php","www.fjsy.org/","www.dchome.net/","jiaoliu.ahsyj.com/","dv.pchome.net/","www.photofans.cn/","www.52foto.com/","www.sheying8.com/","www.quanjing.com/"};
    String n3="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;

    public Sy49() {
        try {
            jdbcTemplate = JDBCHelper.createMysqlTemplate("mysql1", "jdbc:mysql://192.168.21.60/urlclassifier?useUnicode=true&characterEncoding=utf8", "root", "root", 5, 30);

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


   public String   f4(int j3){
       String url;
        String e1="8866.5566";
        String f5="7755.5566";
        String x8=""+"http://www.5566.net/sy-4.htm";
        String b3="=''+document.location;";
        String h1=""+"www.5566.net";
        String g8="=''+location.hostname;";
        int u8=h1.lastIndexOf('.');
        int a5=0+Integer.parseInt(String.valueOf(h1.charAt(u8-1)));
        int u5=0+Integer.parseInt(String.valueOf(e1.charAt(3)));
        int h5=0+Integer.parseInt(String.valueOf(e1.charAt(1)));
        int p9=0+string2Unicode(String.valueOf(b3.charAt(6)));
        int i2=0+Integer.parseInt(String.valueOf(h1.charAt(u8-3)));
        int d9=0+string2Unicode(String.valueOf(g8.charAt(5)));
        String y7="sy";
        if(h1!="5566.net"&&h1!="www.5566.net"&&h1!="5566.org"&&h1!="1.5566.org"&&h1!="2.5566.org"&&h1!="3.5566.org"&&h1!="4.5566.org"&&h1!="5.5566.org"&&h1!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+z7[(j3-i2-a5-u5-d9-p9-86)/h5];
        }
        return  url;
    }
   public String  k8(int j9){
       String url ="";
        String v6=""+"www.5566.net";
        String h0="=''+document.domain;";
        String z1="6688.5566";
        String e3="=''+document.URL;";
        String q9=""+"http://www.5566.net/sy-4.htm";
        String l5="2299.5566";
        int g6=v6.lastIndexOf('.');
        int x9=0+Integer.parseInt(String.valueOf(v6.charAt(g6-3)));
        int z2=0+string2Unicode(String.valueOf(h0.charAt(5)));
        int c6=0+Integer.parseInt(String.valueOf(l5.charAt(2)));
        int l1=0+string2Unicode(String.valueOf(e3.charAt(6)));
        int f6=0+Integer.parseInt(String.valueOf(l5.charAt(1)));
        int t0=0+Integer.parseInt(String.valueOf(v6.charAt(g6-1)));
        String s8="sy";
        if(v6=="5566.net"||v6=="www.5566.net"||v6=="5566.org"||v6=="1.5566.org"||v6=="2.5566.org"||v6=="3.5566.org"||v6=="4.5566.org"||v6=="5.5566.org"||v6=="www.5566.org"){
           url = "http://"+z7[(j9-t0-f6-c6-z2-l1-44)/x9];
        }
        return  url;
    }
   public String  y9(int h7){
       String url ;
        String x7=""+"www.5566.net";
        String p7="=''+location.href;";
        String k0=""+"http://www.5566.net/sy-4.htm";
        String g7="=''+location.host;";
        String t8="5577.5566";
        String f5="9922.5566";
        int h3=x7.lastIndexOf('.');
        int x3=0+Integer.parseInt(String.valueOf(x7.charAt(h3-3)));
        int b2=0+string2Unicode(String.valueOf(p7.charAt(6)));
        int j8=0+Integer.parseInt(String.valueOf(t8.charAt(1)));
        int i4=0+string2Unicode(String.valueOf(g7.charAt(5)));
        int w5=0+Integer.parseInt(String.valueOf(x7.charAt(h3-1)));
        int t9=0+Integer.parseInt(String.valueOf(t8.charAt(3)));
        String  r6="sy";
        if(k0.indexOf("5566")==-1||k0.indexOf("sy")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+z7[(h7-x3-j8-t9-i4-b2-23)/w5];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("f4")) {
                    tmpUrl = f4(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("k8")) {
                    tmpUrl = k8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("y9")) {

                    tmpUrl = y9(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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

    public  void  getSyUrls9(String url) {

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "文化艺术";
        String tag2 ="艺术 -> 摄影";
//        System.out.println(p.get(146));
        //17,38,57,69,92, 109,118,124,133,146
        int[] numbers = {17,38,57,69,92, 109,118,124,133,146};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }





    }
    public static void main(String[] args) {


        Sy49 sy49 = new Sy49();
        sy49.getSyUrls9("http://www.5566.net/sy-4.htm");


    }







}
