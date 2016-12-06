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
public class Yl84 {

   String[]  w9={"0","www.taihehospital.com/","nyfy.com.cn/","www.fjxiehe.com/","www.rjh.com.cn/","www.fzetyy.com/","www.nxrmyy.com/","www.nmgyy.cn/","www.gy120.net/","www.54dr.com/","www.qh.xinhuanet.com/Hospital/","www.pkuszh.com/","www.cylh.com/","www.cqzshospital.com/","www.wfszyy.com/","www.longhua.net/","www.hnph.com/","www.ay2fy.com/","www.sgyy.com.cn/","www.hztcm.net/","www.yych.cn/","www.wkdty.com/","www.qzzg.cn/","www.zmchospital.com.cn/","www.dentist.org.cn/","www.cqszyy.com/","www.zzsetyy.cn/","www.znhospital.cn/","www.sysucc.org.cn/","www.njszyy.cn/","www.gzcdc.org.cn/","www.ahskqyy.cn/","www.hnzlyy.com/","www.mtzyy.com.cn/","www.180yy.com/","www.yzsbh.com/","www.hz2y.com/","www.ytzyy.cn/","www.hospital-nsmc.com.cn/","www.ipmch.com.cn/","www.xyyfy.com/","www.ptxyfsyy.com.cn/","www.aqslyy.com.cn/","www.yjsyy.com/","www.hffy.com/","www.yczyy.com.cn/","www.fjmdyy.com/","www.hbpphosp.cn/","www.hospital305.com/","www.gxbssyy.com/","www.oio.com.cn/","www.sypzhealth.com/","www.fzfybj.com/","www.hz3201.com/","www.taishanyy.com/","www.zhongyihospital.com/","www.ddzyy.cn/","www.zsszyy.com/","www.sd-cancer.com/","www.sd-eh.com/","www.z2hospital.com/","www.ahhfsy.cn/","www.dl-qy.com/","www.nyefy.com/","www.ldyy.net.cn/","www.qhzyy.com.cn/","www.ywzxyy.com/","www.bjdth.com/","www.kyfey.com/","www.bjxkyy.cn/","www.ly120.cn/","www.etyy.com/","www.dl3y.com/","www.nmgfy.com/","www.chhospital.com.cn/","rmyy.maoming.gov.cn/","www.qzhospital.com/","www.ls-hospital.com/","www.ahnmc.com/","www.xyhospital.com/","www.hf2y.com/","xjwww.fmmu.edu.cn/","www.xyeyy.com/","www.jyfy.com.cn/","www.gzzyy.com/","www.lntcm.com.cn/","www.hrbmutumour.cn/","www.tjskq.com/","www.pinganyiyuan.com/","www.jyyyw.com/","www.firsthospital.cn/","www.cqwjyy.com/","www.0378-120.com/","www.fjhospital.com/","www.myzxyy.com/","www.grmg.com.cn/","www.jmszxyy.com/","www.xmdeyy.com/","www.bjch.com/","www.renji.com/","www.yjhospital.com/","www.beijing120.com/","www.bddhospital.com.cn/","puaihospital.net/","www.huijing.org/","www.gamhospital.ac.cn/","www.xcszxyy.cn/","www.tj4thch.cn/","www.czzyy.com/","www.hzhhyy.com/","www.tjmugh.com.cn/","www.xmtcm.com/","www.sdey.net/","www.cqrmhospital.com/","www.dmxrmyy.com/","www.sxsrmyy.com/","www.bj-fxh.com/","www.e5413.com/","www.shchildren.com.cn/","www.pumch.cn/","www.hzhospital.com/","www.454hosp.cn/","www.sichuancancer.org/","www.szszyy.cn/","www.xinhuahospital.com/","www.xfszyy.com/","www.easthospital.cn/","ch.shmu.edu.cn/","www.hnfph.com.cn/","www.shchildren.com.cn/","www.wjgdyy.com/","www.epzyy.cn/","www.301hospital.com.cn/","www.gxrkyy.com/","www.plhospital.com/","www.czzxy.cn/","www.lfzyy.com/","www.fyey.cn/","www.sctcm120.com/","www.cd3120.com/","www.hdhospital.com/","www.sm2y.com/","www.cd2120.com/","www.lzry.com.cn/","www.xmfh.com.cn/","www.jxsrmyy.cn/","www.hcsrmyy.com/","www.zyyfy.com/","www.xmzsh.com/","www.gsfybjy.com/","www.dd2hospital.com/","www.bfh.com.cn/","www.xxszxyy.com.cn/","www.tsfy.com/","www.klyy.com","www.lyrmyy.com/","www.jggsyy.com/","www.xadyyy.com/","www.szbayy.com/","www.jst-hosp.com.cn","www.cthhmu.com/","www.bddyyy.com.cn/","www.syshospital.com/","www.jxcdc.cn/","www.zzzyyy.com/","www.dlzxyy.com/","www.pkuh6.cn/Hospitals/Main","www.81ek.com/","www.azyfy.com/","www.5055.cn/","www.czrmyy.com/","www.njsdyyy.com/","www.tzszyy.com/","www.nych.cn/","www.jnrmyy.com/","www.chinasee.com.cn/","www.gszyy.com/","www.sxatcm.com/","www.xmfybj.cn/","www.cmu4h.cn/","www.bcdh.cn/","www.fskwjzyy.com/","www.dqeyy.net/","www.smdyyy.cn/","www.kmszy.com/","www.ahetyy.com/","www.lydyyy.com.cn/","www.changshacentralhospital.com/","www.bbszyy.com/","www.hospital-cqmu.com/","www.xmkq.com/","www.gysfybjy.com/","www.szkid.com.cn/","www.fzzyy.com/","www.sjzfh.com/","www.ndzyy.com/","www.ahszlyy.cn/","www.xwzy.com.cn/","www.yangzhouyiyuan.com/","www.xysdyrmyy.cn/","www.hzch.gd.cn/","www.yhfh.com/","www.byefy.com/","www.srrsh.com/","www.nxzsyy.com/","www.east120.com/","www.shcnfb.com/","www.dalian-tcm.com/","jm.rise99.com/","www.jdey.com.cn/","www.xinhuamed.com.cn/","www.shaanxijh.com/","www.jnszyyy.com/","www.zzssy.com/","www.dzcch.com/","www.lnyy.com.cn/","www.zzzyy.com/","www.gxfybj.com/","www.zyxyfy.com/","qdumh.qd.sd.cn/","www.ffmmh.com/","www.njglyy.com/","www.szrch.com/","www.srmyy.com/","www.lnsyy.com/","www.wjhospital.com.cn/","www.semeye.com/","www.zbzxyy.com/","www.fybj.net/","www.tungwah.com/","www.xy3yy.com/","www.fckyy.com/","www.tjh.com.cn/","www.fjsl.com.cn/","www.nwwch.com/","www.bydyhos.com/","www.bjgrh.com.cn/","www.bjzhongyi.com/","www.sdjneye.com/","www.bjzxyy.com/","www.zbdyyy.com/","www.eye029.com/","www.shdmu.com/","www.sy5y.com.cn/","www.306.cn/","www.ahmmhg.com/","www.np2y.com/","www.zzusah.com/","www.fyyy.com/","www.njkq.net/","www.e3861.com/","www.jlsyy.net/","www.whyljz.com.cn/","www.sthospital.com/","www.xieheh.com/","www.hbkgyy.com/","www.kmeye.com/","www.ayzlw.com/","www.81yy.com/","www.xydyfy.cn/","www.xjtcm.com/","www.gzsums.net/","www.hb2h.com/","www.hbsxkyy.com/","www.hz-hospital.com/","www.t-dsyy.com/","www.wuhanmcc.com/","www.xtrmyy.cn/","www.175yy.com/","www.gy3y.com/","www.jxsxkyy.cn/","www.xcsyy.com/","nn2yy.com/","www.crrc.com.cn/","www.xcdqyy.com/","www.cq5y.com/","www.jnidhosp.com/","www.zjyy.com.cn/","www.ldzxyy.com/","www.jmrmyy.com/","www.nbszyy.com.cn/","www.byfy.cn/","www.hnszyy.com.cn/","www.cnjws.com/","hfkq.com.cn/","www.sahcqmu.com/","www.ylsdyrmyy.com/","www.jhhospital.com/","www.gxmuyfy.cn/","www.gzsrmyy.com/","www.xkyy.com.cn/","www.szxx.com.cn/shop/szslyy/","www.tssdsyy.cn/","www.120.org.cn/","kqyxy.lzu.edu.cn/","www.hssyy.com/","www.shxkyy.com/","www.jdfy.cn/","www.jzsyy.com/","www.qqhryxydyfsyy.com/","www.dph-fsi.com/","www.ycyy.com.cn/","www.jssdezyy.com/","www.cqflzxyy.com.cn/","www.sgyy.cn/","www.cdzxy.com/","www.sns120.com/","www.xjzlyy.com/","www.tongjihospital.com.cn/","www.hhsyy.com/","www.tjchangzheng.com/","www.shsfkyy.com/","www.jmsuf.com/","www.sdfey.com/","www.ydsy.cn/","www.shskin.com/","www.tj3zx.cn/","www.yxhospital.com/","www.whfph.com/","www.cicams.ac.cn/","www.chinapsy.com/","unit.xjtu.edu.cn/xamuoral/cms/","www.nc2y.cn/","www.shanguoying.com/","www.lzgryy.com/","www.njfybjy.com/","www.c-nbh.com/","www.rmhospital.com/","www.cq9yuan.com/","www.qjzxyy.com/","www.hyfyuan.com/","www.nfyy.com/","www.gz8h.com.cn/","www.bjtth.org/","www.hzch.gd.cn/","www.gsyy.cn/","www.jhwyy.com/","www.npyy.com.cn/","www.jlhtcm.com/","www.czfph.com/","www.gzfezx.com/","www.tjchildrenshospital.com/","www.asch.net.cn/","www.ydyy.cn/","www.syhospital.com/","www.zzsqy.com.cn/","www.njsech.net/","www.zsdfyy.com/","www.btzxyy.com/","www.nksyyy.com/","www.ptsyy.com/","www.51dentist.com/","www.lnph.com/","www.xiameneye.org.cn/","www.huaihe.com.cn","www.hrbmush.edu.cn/","www.xjrmyy.com/","www.bddhospital.com/","www.sdzydfy.com/","www.lydeyy.com/","www.yc2e.com/","www.zjhospital.org.cn/","www.scmc.com.cn/","www.gxbssyy.com/","www.xcq-zyy.com/","www.sydyy.net.cn/","www.fzsdyyy.com/","www.shaphc.org/","www.fshospital.org.cn/","www.arurahp.com/","www.zjkq.com.cn/","www.gzpyzy.cn/","www.hdsdyyy.com/","www.cyfy.cn/","www.zmed.cn/","www.jygsyy.com/","www.srsrmyy.cn/","www.jzhchm.com.cn/","kqwww.fmmu.edu.cn/","www.huadonghospital.com/","www.eye.ac.cn/","www.lffybj.com/","www.qzeyy.com/","www.gxzyy.com.cn/","www.kstcm.org.cn/","www.120cq.com.cn/","www.gsfybjy.com/","www.hnsrmyy.com/","www.cz96120.com/","www.gxhospital.com/","www.dg-tcm.com/","www.ychcqmu.com/","www.ayzyy.com/","www.smhc.org.cn/","www.jxndefy.cn/","www.jzszyyy.com/","www.puh3.net.cn/","www.ljzy.com.cn/","www.anti-cancer.com.cn/","www.gdhtcm.com/","www.xachyy.com/","www.fjfk.com/","www.idv.com.cn/","www.kmsdyrmyy.com/","www.tufh.com.cn/login/index.asp","www.zs-hospital.com/","www.tsrmyy.cn/","www.gmcah.com/","www.zjuch.cn/","www.nt2191.com/","www.syhos.cn/","www.2113515.com.cn/","www.lydsyy.com/","www.wuxiph.com/","www.hnetyy.net/","www.qhdsdyyy.com/","www.tjydkq.com/","www.gxyyfy.cn/","www.nn9yy.com/","www.711hospital.com/","www.302hospital.com/","www.fstcm.com.cn/","www.xqhospital.com.cn/","www.tj-fch.com/","www.zzfh.com/","www.zgchospital.com/","www.hljtcm.com.cn/","www.yy8080120.com/","www.yueyangyy.com/","www.hosp1.ac.cn/","www.jshtcm.com/","www.ntdsyy.com/","www.tjtcm.cn/","www.hbszyy.cn/","www.zssy.com.cn/","ss.bjmu.edu.cn/","www.syzyy.com/","www.syhos.com/","www.sippr120.cn/","www.fuwaihospital.org/","www.lcszyy.com/","www.wjzdyy.cn/","www.xjykdefy.com/","www.chdyyy.com/","www.sjzsdyyy.com/","www.bjszyy.com/","www.bch.com.cn/","www.cnhch.com/","www.guobin.net/","www.cqgc.com/","www.zjztyy.com/","www.hnzhy.com/","www.sph.com.cn/","www.zxhospital.com/","www.fjsfy.com/","www.laszyy.cn/","www.51ht.com/","www.yd2y.com.cn/","www.jxszyy.com/","www.ahslyy.com.cn/","www.hljzy.cn/","www.hbch.com.cn/","www.kj-hospital.com/","www.zzslyy.com/","www.hzkq.com.cn/","www.cqsjwzx.com/","www.999brain.com/","www.tsyy120.com/","www.zydey.com.cn/","www.ybyy.net/","www.dyyy.xjtu.edu.cn/","www.303yy.com/","hospital.nc.sgcc.com.cn/","www.jinshanhos.org.cn/","www.gxzlyy.com/","www.tzzxyy.com/","www.tzhospital.com/","www.fzpfy.com/","www.hizyy.com/","www.xtzxyy.com/","www.huaihe.com.cn/","www.wfph.cn/","www.anhuitb.com/","www.xkyy.org/","www.jstzhospital.com/","www.nn3yy.com/","www.bbmnk.com/","www.shca.org.cn/","www.cdyfy.com/","www.gyzyy.com/","www.mzrmyy.com/","fcc.zzu.edu.cn/","www.qhrch.com/","www.lchospital.cn/","szy.sh.cn/","www.gzbrain.cn/","www.9hospital.com.cn/","www.byyfy.com.cn/","www.fybjsd.com/","www.gbyy.com.cn/","www.zydsy.com/","www.byjd.com/","www.jsnydefy.com/","www.hssey.com/","www.hbs6yy.com/","www.lzdyyy.com/","www.dfmhp.com.cn/","www.gxzlyy.com/","www.glrmyy.com/","www.anzhen.org/","www.lnszl.com/","www.bjcyh.com.cn/","www.womanhospital.cn/","www.251yy.com.cn/","www.fzsdeyy.com/","www.nbdlyy.com/","www.etyy.cn/","www.hospitalstar.com/","www.fysyy.com/","www.phhp.com.cn/","www.whszyy.cn/whzyy/","www.xyhos.com/","www.whhospital.com/","www.fjsj.com/","www.cqsxzxyy.com/","www.tjskq.com/","www.bjogh.com.cn/","www.ahbzyy.com/","www.bjad.com.cn/","www.zgwhfe.com/","www.gztcm.com.cn/","www.jszlyy.com.cn/","www.czey.com/","www.nhrmyy.cn/","www.hnsrmyy.net/","www.gzszyy.com/","kq.gxmu.edu.cn/","www.gxwzszyyy.com/","www.njxkyy.net/","www.fx-hospital.com/","hospital.glmc.edu.cn/","www.ntzyy.com/","www.ahmch.com.cn/","www.gzcancer.com/","www.whtcm.com/","www.cdszxyy.com/","www.jxsetyy.cn/","www.shczyy.com/","www.cdsyy.com/","www.stszyy.cn/","www.nh2h.com/","www.whsyy.net/","www.qiluhospital.com/","www.jlszlyy.com/","www.xwhosp.com.cn/","www.hyszxyy.com/","www.tjzyefy.com/","www.chizhouhospital.com/","www.ccsfuchan.com/","www.bb1y.com/","www.cmu1h.com/","www.yasrmyy.cn/","www.gxmzyy.com/","www.wj-hospital.com/","www.dtzxy.com/","www.51mch.com/","www.xahhyy.com/","www.stuh.com.cn/","www.jsph.net/","www.zdkqyy.com/","www.peacehospital.com/","www.yanbianhospital.com/","www.cd120.com/","www.tj2rm.com/","tdwww.fmmu.edu.cn/","www.huashan.org.cn/","www.chcmu.com/","www.bjyah.com/","www.jzszxyy.com/","fyy.sdfyy.cn/","www.jlsfcyy.com/","www.px120.com/","www.zz8y.com/","www.xazyy.com/","www.scmy120.com/","www.hljhospital.net/","www.hunanzy.com/","www.ahbbsy.com/","stmchh.shantou.gov.cn/","www.szszyy.net/","www.ypfph.com/","www.hnxhyl.com/xhyy/","www.tnsi.org/","qdslyy.qdslyy.cn/","www.2yuan.org/","www.jd120.com/","www.samsph.com/","www.jzyy1949.com/","www.first-hospital.com/","www.sxzlyy.com/","www.jyyy.com.cn/","www.szdsyy.com/","www.xatongji.com/","www.cqch.cn/","www.jz3y.com/","www.hbpch.com/","www.hbydsy.com/","www.xztcm.com/","www.trhos.com/","www.zjrj.com/","www.pkuh6.cn/","www.bjcancer.org/","www.szszyy.net/","www.fy114.com.cn/","www.ytyhdyy.com/","www.xnyy.cn/","www.nmgdxyy.com/","www.gzszlyy.cn/","www.zjhospital.com.cn/","www.307hospital.com/","www.nnxiehe.com/","www.sspph.cn/","www.wxfuyou.com/","www.ynbsyy.com/","www.jsxyfy.com/","www.zjhtcm.com/","www.fqey.com/","www.phn.cn/","www.xaszxyy.com/","www.aysfy.cn/","www.fybjy.com.cn/","www.421hp.com/","www.zhengxing.com.cn/","www.sjzfcyy.com/","www.nhfyyy.com/","www.gzhosp.cn/","www.whuh.com/","www.bssyy.com/","www.zy91.com/","www.whzyy.net/","www.zjtongde.com/","www.gzrch.com/","www.spph-sx.com/","www.nn1yy.com/","www.st2yy.com.cn/","www.hz3yy.com/","www.qzdyyy.com/","www.umc.net.cn/","www.qzsyy.com/","www.shiyanhospital.com/","www.nkhospital.com.cn/","www.huaibeihosp.com/","www.363120.com/","www.ayzlw.com/","www.hnpysrmyy.com/","www.hgyy.org.cn/","www.phbjmu.edu.cn/","www.fzsdsyy.com/","218.2.28.147:1818/","www.5413.com.cn/","www.nchospital.com/","www.lyszxyy.com/","www.ahmhcentre.com/","www.wjzdyy.cn/","www.hfyy.cn/","www.rcstar.com/","www.bghospital.cn/","www.ncsyy.com/","www.nbdyyy.com/","www.zchospital.com/","www.lyszyy.com/","www.tjmuch.com/","www.xyzlyy.com/","www.cmudental.com/","www.cqsfybjy.com/","www.dletyy.com/","www.aqhospital.com/","www.hnzyfy.com/","www.hrb242.com/","www.myfy.com.cn/","www.wzhealth.com/","hnwzs.cn/","www.91985.com/","www.hdzxyy.com/","www.fjzl.com.cn/","www.dongfangyy.com.cn/","www.lshospital.zj.cn/","www.sydey.com/","www.china-fushan.org/","www.ahlzmc.com/","www.jxcancer.cn/","www.whuss.com/","www.hbhtcm.com/","www.whjy.com.cn/","www.fzcrb.com/","www.whyyy.com.cn","www.zjhospital.com/","www.gszlyy.com/","www.fxzxyy.com/","www.no1ayyy.com/","www.xiangya.com.cn/","www.hyshyy.com/","www.motherchildren.com/","www.qyry.com/","www.hbfy.com/","www.zryhyy.com.cn/","www.gzzoc.com/","www.zbzyy.com/","www.gf120.com/","www.3579999.com/","www.nbdeyy.com/","www.gzzyzyy.com/","www.hkclinic.com/","www.sztcm.org.cn/","www.309yy.com/","www.5thhospital.com/","www.szfy120.com/","www.yczxyy.com/","www.hzszlyy.com/","www.8502222.com/","www.dgphospital.com/","www.wuxihospital.com/","www.bjgrh.com/","www.ylgk.com/","www.ldey.cn/","www.zy120.com/","www.crrc.com.cn/","www.ztzy.com/","www.hjzyy.com.cn/","www.szfthp.com/","www.hxkq.org/ylhl_gk.htm","www.sxsyk.com/","www.hszxyy.com.cn/","www.mdjdyyy.cn/","www.zsufivehos.com/","www.ayfy.com/","www.xixiyy.cn/","www.hljkfhos.com/","www.zsph.com/","www.sdhospital.com.cn/","www.411yy.com/","www.gskfzx.com/","www.minkang.com/","www.dyrmyy.cn/","www.qdhaici.cn/","www.haikoumh.com.cn/","www.411yy.com/","www.zqts.com/","www.layy.cn/","www.dzmyy.com.cn/","www.zs-hospital.sh.cn/","www.sjzsdeyy.com/","www.6thhosp.com/","www.bjhmoh.cn/","www.qdzxy.com/","www.bhlgh.com/","www.7yuan.cn/","www.zxyy.cn/","www.gl181.com/","www.yn-tcm-hospital.com/","www.hmzyet.com/","www.dlhospital.com/","www.njch.com.cn/","www.shdsyy.com.cn/","www.9hospital.net/","www.tjorthop.org/","www.xmdsyy.com/","www.tlhos.com/","www.dmu-1.com/","www.qzzyy.com.cn/","www.sxcahosp.com/","www.gyey.com/","www.zzszyy.com/","www.cqdent.com/","www.zsy.cn/","www.zhhospital.cn/","www.ylyy.org/","www.njzy666.com","www.ndsyy.com/","www.wzhosp.com/","www.gyfyy.com/","www.ly2hos.com/","www.yb120.cn/","www.ehbh.cn/","www.syhhyy.com/","www.zzgkyy.com/","www.sj-hospital.org/","www.jndsyy.cn/","www.e5421.com/","www.jdyy.cn/","www.glzyy.com/","www.nxxh.net/","www.jyry.com/","www.fjpfb.com/","www.qhsrmyy.com/","www.fdeent.org/"};
    String n3="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;
    public Yl84(){
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


    public String  s8(int r7){
        String url = "";
        String e9="=''+document.domain;";
        String o9="7711.5566";
        String v5=""+"http://www.5566.net/yi4-4.htm";
        String e0="9988.5566";
        String y7=""+"www.5566.net";
        String w1="=''+location.href;";
        int f2=y7.lastIndexOf('.');
        int x7=0+string2Unicode(String.valueOf(e9.charAt(5)));
        int u4=0+Integer.parseInt(String.valueOf(e0.charAt(2)));
        int c4=0+Integer.parseInt(String.valueOf(e0.charAt(1)));
        int k9=0+Integer.parseInt(String.valueOf(y7.charAt(f2-1)));
        int j1=0+Integer.parseInt(String.valueOf(y7.charAt(f2-3)));
        int e7=0+string2Unicode(String.valueOf(w1.charAt(6)));
        String q5="yi4";
        if(y7=="5566.net"||y7=="www.5566.net"||y7=="5566.org"||y7=="1.5566.org"||y7=="2.5566.org"||y7=="3.5566.org"||y7=="4.5566.org"||y7=="5.5566.org"||y7=="www.5566.org"){
            url = "http://"+w9[(r7-j1-k9-u4-x7-e7-76)/c4];
        }
        return  url;
    }
    public String  z1(int d6){
        String url;
        String a1="4422.5566";
        String w7="8899.5566";
        String g6=""+"http://www.5566.net/yi4-4.htm";
        String h3="=''+location.host;";
        String i5="=''+document.URL;";
        String k2=""+"www.5566.net";
        int e8=k2.lastIndexOf('.');
        int w5=0+Integer.parseInt(String.valueOf(k2.charAt(e8-1)));
        int x3=0+Integer.parseInt(String.valueOf(a1.charAt(3)));
        int p7=0+Integer.parseInt(String.valueOf(a1.charAt(0)));
        int d7=0+string2Unicode(String.valueOf(h3.charAt(5)));
        int q1=0+string2Unicode(String.valueOf(i5.charAt(6)));
        int z2=0+Integer.parseInt(String.valueOf(k2.charAt(e8-3)));
        String o1="yi4";
        if(g6.indexOf("5566")==-1||g6.indexOf("yi4")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+w9[(d6-w5-p7-x3-d7-q1-4)/z2];
        }
        return  url;
    }
   public String  x6(int j4){
       String url;
        String l4="1177.5566";
        String o9="2244.5566";
        String d9=""+"www.5566.net";
        String x8="=''+location.hostname;";
        String n9=""+"http://www.5566.net/yi4-4.htm";
        String y6="=''+document.location;";
        int v3=d9.lastIndexOf('.');
        int x0=0+Integer.parseInt(String.valueOf(d9.charAt(v3-1)));
        int b6=0+Integer.parseInt(String.valueOf(l4.charAt(3)));
        int g8=0+Integer.parseInt(String.valueOf(d9.charAt(v3-3)));
        int m0=0+string2Unicode(String.valueOf(x8.charAt(5)));
        int q8=0+Integer.parseInt(String.valueOf(l4.charAt(1)));
        int l8=0+string2Unicode(String.valueOf(y6.charAt(6)));
        String k0="yi4";
        if(d9!="5566.net"&&d9!="www.5566.net"&&d9!="5566.org"&&d9!="1.5566.org"&&d9!="2.5566.org"&&d9!="3.5566.org"&&d9!="4.5566.org"&&d9!="5.5566.org"&&d9!="www.5566.org"){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
            url = "http://"+w9[(j4-g8-q8-b6-m0-l8-64)/x0];
        }
        return url;

    }

    public  void getUrlAndText(Elements urls, String tag1, String tag2) {

        String tmpUrl = "";
        String tmpName = "";
        String onclick = "";

        for (Element href : urls) {
            try {
                onclick = href.attr("onclick");
                tmpName = href.text();
                if (onclick.substring(0, 2).equalsIgnoreCase("s8")) {
                    tmpUrl = s8(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("z1")) {
                    tmpUrl = z1(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("x6")) {

                    tmpUrl = x6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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
        String tag1 = "健康医疗";
        String tag2 = "各地医院";
//        System.out.println(p.get(20));
        //
        int[] numbers = {20};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }



    }

    public static void main(String[] args) {

        Yl84 yl84 = new Yl84();
        yl84.getUrls("http://www.5566.net/yi4-4.htm");

    }





}
