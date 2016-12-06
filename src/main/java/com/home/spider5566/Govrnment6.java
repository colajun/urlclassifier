package com.home.spider5566;

import com.home.spring.JDBCHelper;
import org.apache.hadoop.mapreduce.v2.proto.MRProtos;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;

/**
 * Created by hadoop on 16-11-16.
 */
public class Govrnment6 {

    String[] d7={"0","www.npc.gov.cn/","www.spp.gov.cn/","www.mof.gov.cn/","www.sara.gov.cn/","www.hmo.gov.cn/","www.ncac.gov.cn/","www.mohurd.gov.cn/","www.most.gov.cn/","www.12388.gov.cn/","www.caea.gov.cn/","www.chinaql.org/","www.customs.gov.cn/","www.cca.org.cn/","www.nra.gov.cn/","www.cq.gov.cn/","www.mps.gov.cn/","www.moa.gov.cn/","nnsa.mep.gov.cn/","www.ssf.gov.cn/","www.acfic.org.cn/","www.mod.gov.cn/","www.gov.hk/","www.ah.gov.cn/","www.cae.cn/","www.zytzb.org.cn/","www.hubei.gov.cn/","www.hlj.gov.cn/","www.jiangsu.gov.cn/","www.women.org.cn/","www.pbc.gov.cn/","www.ggj.gov.cn/","www.shanghai.gov.cn/","www.mcprc.gov.cn/","www.spb.gov.cn/","www.nx.gov.cn/","www.cctb.net/","www.gd.gov.cn/","www.gansu.gov.cn/","www.scio.gov.cn/","www.mohrss.gov.cn/","www.caac.gov.cn/","www.safe.gov.cn/","www.cea.gov.cn/","www.jl.gov.cn/","www.gov.cn/","www.nhfpc.gov.cn/","www.xinjiang.gov.cn/","www.miit.gov.cn/","www.hunan.gov.cn/","www.sc.gov.cn/","www.mwr.gov.cn/","www.shaanxi.gov.cn/","www.zj.gov.cn/","www.tj.gov.cn/","www.cnta.gov.cn/","www.chinagrain.gov.cn/","www.chinacoal-safety.gov.cn/","www.gjxfj.gov.cn/","www.beijing.gov.cn/","www.drc.gov.cn/","www.hainan.gov.cn/","www.saac.gov.cn/","www.ln.gov.cn/","www.qinglian.org/","www.audit.gov.cn","www.mca.gov.cn/","www.sastind.gov.cn/","www.nea.gov.cn/","www.sport.gov.cn/","www.ccdi.gov.cn/","www.chinacoop.gov.cn/","www.circ.gov.cn/","www.cbrc.gov.cn/","www.forestry.gov.cn/","www.cas.cn/","www.nsfc.gov.cn/","www.nsa.gov.cn/","www.mofcom.gov.cn/","www.henan.gov.cn/","www.moj.gov.cn/","www.aqsiq.gov.cn/","www.seac.gov.cn/","www.gxzf.gov.cn/","www.cdpf.org.cn/","www.sdpc.gov.cn/","www.cma.gov.cn/","www.gov.mo/","www.moc.gov.cn/","www.sda.gov.cn/","www.chinasafety.gov.cn/","www.cppcc.gov.cn/","www.sipo.gov.cn/","www.scs.gov.cn/","www.china-language.gov.cn/","www.counsellor.gov.cn/","www.jiangxi.gov.cn/","www.hebei.gov.cn/","www.nsbd.gov.cn/","www.gzgov.gov.cn/","www.saic.gov.cn/","www.csrc.gov.cn/","www.qh.gov.cn/","www.oscca.gov.cn/","www.zhb.gov.cn/","www.gqb.gov.cn/","www.safea.gov.cn/","www.ccyl.org.cn/","www.china-un.org/chn/","www.fmprc.gov.cn/","www.stats.gov.cn/","www.soa.gov.cn/","www.acftu.org/","www.shanxigov.cn/","www.chinasarft.gov.cn/","www.moe.gov.cn/","www.sbsm.gov.cn/","www.mlr.gov.cn/","www.cpad.gov.cn/","www.cssn.cn/","www.sd.gov.cn/","www.tobacco.gov.cn/","www.fujian.gov.cn/","www.chinalaw.gov.cn/","www.chinatax.gov.cn/","www.gwytb.gov.cn/","www.cnsa.gov.cn/","www.nmg.gov.cn/","www.xizang.gov.cn/","www.satcm.gov.cn/","www.xinhuanet.com/","www.idcpc.org.cn/","www.sach.gov.cn","www.court.gov.cn","www.sasac.gov.cn/","www.yn.gov.cn/"};
    String w3="http://www.5566.org/indexe.htm";
    JdbcTemplate jdbcTemplate = null;
    public Govrnment6(){
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

    public String q5(int t8){
        String url = "";
        String s4=""+"www.5566.net";
        String j9="=''+location.href;";
        String n0="=''+location.host;";
        String j5="6644.5566";
        String x7=""+"http://www.5566.net/gov-.htm";
        String f4="7722.5566";
        int z7=s4.lastIndexOf('.');
        int s8=0+Integer.parseInt(String.valueOf(s4.charAt(z7 -3)));
        int o9=0+string2Unicode(String.valueOf(j9.charAt(6)));
        int n4=0+string2Unicode(String.valueOf(n0.charAt(5)));
        int s9=0+Integer.parseInt(String.valueOf(s4.charAt(z7-1)));
        int z1=0+Integer.parseInt(String.valueOf(j5.charAt(1)));
        int o3=0+Integer.parseInt(String.valueOf(j5.charAt(2)));
        String k4="gov";
        if(s4=="5566.net"||s4=="www.5566.net"||s4=="5566.org"||s4=="1.5566.org"||s4=="2.5566.org"||s4=="3.5566.org"||s4=="4.5566.org"||s4=="5.5566.org"||s4=="www.5566.org"){
           url = "http://"+d7[(t8-s8-z1-o3-n4-o9-4)/s9];
        }
        return  url;
    }
    public String  o0(int h7){
        String url ="";
        String c3="2277.5566";
        String x0="=''+location.hostname;";
        String d4=""+"www.5566.net";
        String d1=""+"http://www.5566.net/gov-.htm";
        String y7="=''+document.URL;";
        String b6="1199.5566";
        int o5=d4.lastIndexOf('.');
        int h5=0+Integer.parseInt(String.valueOf(d4.charAt(o5-1)));
        int m1=0+string2Unicode(String.valueOf(x0.charAt(5)));
        int t6=0+Integer.parseInt(String.valueOf(d4.charAt(o5-3)));
        int d8=0+Integer.parseInt(String.valueOf(c3.charAt(1)));
        int a9=0+string2Unicode(String.valueOf(y7.charAt(6)));
        int q4=0+Integer.parseInt(String.valueOf(c3.charAt(3)));
        String y3="gov";
        if(d1.indexOf("5566")>=0&&d1.indexOf("gov")>=0){
            url = "http://"+d7[(h7-h5-d8-q4-m1-a9-73)/t6];
        }
        return  url;
    }
   public String b1(int k2){
       String url;
        String c4="=''+document.domain;";
        String p4="=''+document.location;";
        String l6=""+"http://www.5566.net/gov-.htm";
        String f7="9911.5566";
        String x3=""+"www.5566.net";
        String f4="4466.5566";
        int p5=x3.lastIndexOf('.');
        int s1=0+string2Unicode(String.valueOf(c4.charAt(5)));
        int i5=0+string2Unicode(String.valueOf(p4.charAt(6)));
        int i7=0+Integer.parseInt(String.valueOf(f7.charAt(0)));
        int j1=0+Integer.parseInt(String.valueOf(x3.charAt(p5-1)));
        int l5=0+Integer.parseInt(String.valueOf(x3.charAt(p5-3)));
        int i1=0+Integer.parseInt(String.valueOf(f7.charAt(3)));
        String w2="gov";
        if(x3!="5566.net"&&x3!="www.5566.net"&&x3!="5566.org"&&x3!="1.5566.org"&&x3!="2.5566.org"&&x3!="3.5566.org"&&x3!="4.5566.org"&&x3!="5.5566.org"&&x3!="www.5566.org") {
            url = "http://www.5566.org/indexe.htm";
        }
        else{
            url ="http://"+d7[(k2-l5-j1-i1-s1-i5-9)/i7];
        }

        return  url;
    }





    public  void getUrlAndText(Elements urls, String tag1, String tag2){

        String tmpUrl="";
        String tmpName="";
        String onclick = "";

        for(Element href: urls){

            tmpUrl = href.attr("href");
            tmpName = href.text();

            inserTable(tag1, tag2, tmpUrl, tmpName);

        }



    }
    public  void getGovrnment(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "政法军事";
        String tag2 ="政府";
        String tmpUrl="";
        String tmpName="";
        String onclick = "";
        Elements urls = p.get(17).getElementsByTag("a");
        for(Element href: urls){
            onclick = href.attr("onclick");
            tmpName = href.text();
            if (onclick.substring(0, 2).equalsIgnoreCase("b1")){
                tmpUrl = b1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
            }
            if  (onclick.substring(0, 2).equalsIgnoreCase("o0")){
                tmpUrl = o0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
            }
            if(onclick.substring(0, 2).equals("q5")){

                tmpUrl = q5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

            }
            inserTable(tag1, tag2, tmpUrl, tmpName);
//            System.out.println(tmpUrl+"=============="+tmpName);

        }



    }


    public static void main(String[] args) {

        Govrnment6 govrnment6 = new Govrnment6();
        govrnment6.getGovrnment("http://www.5566.net/gov-.htm");
//        System.out.println("b1(1248)".substring(3,"b1(1248)".indexOf(")") ));


    }




}
