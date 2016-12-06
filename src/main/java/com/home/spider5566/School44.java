package com.home.spider5566;

import com.home.spring.JDBCHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringValueResolver;

import java.io.IOException;

/**
 * Created by hadoop on 16-11-24.
 */
public class School44 {
    String[] s1={"0","www.jilinkj.com/","www.chdxy.cn/","www.gucas.ac.cn/","www.hnjdzy.net/","www.bisu.edu.cn/","www.sntcc.cn/","www.ynasc.com/","www.xthtc.com/","www.ustb.edu.cn/","www.hl.sgcc.com.cn/hdy/","www.fjlzy.com/","www.cqmu.edu.cn/","www.cqnu.edu.cn/","www.hhu.edu.cn","www.fudan.edu.cn","www.gxic.net/","www.gzvtc.cn/","www.fjut.edu.cn/","www.ruc.edu.cn/","www.sdivc.net.cn/","www.cdnu.edu.cn/","www.mastc.edu.cn/","www.lywhxy.com/","www.gzjgxy.cn/","www.hnzj.edu.cn/","www.sdzzvc.cn/","www.ynpsc.edu.cn/","www.zhonghuacollege.com/","www.zzdl.com/","www.xafa.edu.cn/","www.gxstzy.cn/","www.njcmee.net/","www.henau.edu.cn/","www.lnvc.cn/","www.xcc.sc.cn/","www.lygsf.cn/","www.hljnzy.net/","www.ndky.edu.cn/","www.qypt.com.cn/","www.hljlzy.com/","www.hbue.edu.cn/","www.cslg.cn/","www.cueb.edu.cn/","www.caac.net/","www.jxvtc.net/","www.ustl.edu.cn/","www.hnjc.org/","www.hkibmc.com/","www.fimmu.com/","www.njou.edu.cn/","www.tlsz.com.cn/","www.jyvtc.com/","www.jhxy.com.cn/","www.cjgz.edu.cn/","www.8379888.com/","www.gcp.edu.cn/","www.njupt.edu.cn/","www.jzgmxy.com/","www.aust.edu.cn/","www.6789.com.cn/","www.gzgs.org.cn/","www.jluzh.com/","www.zhcpt.edu.cn/","www.cqupt.edu.cn","www.jnzjxy.com.cn/","www.xidian.edu.cn/","www.sias.edu.cn/","www.ahty.net/","www.nyist.net/","www.sdecu.com/","www.xdxy.com.cn/","www.tjuci.edu.cn/","www.asotc.cn/","www.huel.edu.cn/","www.jxhjxy.com/","www.jlict.edu.cn/","klc.qhu.edu.cn/","www.nsmc.edu.cn/","www.xbmu.edu.cn/","www.cqhgzy.com/","www.jinshan-cn.com/","www.ahlyxy.cn/","www.hbvtc.edu.cn/","www.csust.edu.cn/pub/cnxy/","www.hhuc.edu.cn/","www.lncjxy.com/","www.whcm.edu.cn/","www.qledu.net/","www.hepec.edu.cn/","www.buct.edu.cn","www.fit.edu.cn/","www.eszy.edu.cn/","www.jxjsxy.com/","www.jxdx.net/","www.cug.edu.cn/","www.swcvc.net.cn/","www.imppc.cn/","www.zazy.cn/","www.cssttc.gov.cn/","www.fzlmxy.cn/","www.hlau.cn/","www.wdu.edu.cn/","www.njnutz.com/","www.hnucc.com/","www.mdut.cn/","www.cqcfe.com/","www.nanshan.edu.cn/","www.xxvtc.com/","rank.netbig.com/","www.zjtvu.edu.cn/","www.hcit.edu.cn/","www.sxau.edu.cn/","www.hzjzxy.com/","www.lntu.edu.cn/","www.czc.edu.cn/","www.cuit.edu.cn/","www.cpu.edu.cn/","www.pvtc.edu.cn/","www.hnbemc.com/","gzhsvc.com/","www.bszyz.cn/","www.cqrz.edu.cn/","www.canvard.edu.cn/","www.scemi.com/","www.abc.edu.cn/","www.vtcsy.com/","www.hxci.com.cn/","www.scavtc.com/","www.jspi.cn/","www.aku.edu.cn/","www.gxnun.net/","www.whvtc.net/","www.aurora-college.cn/","www.ynny.cn/","www.zbnc.edu.cn/","www.sziit.com.cn/","www.hncc.edu.cn/","www.cyu.edu.cn/","www.gdgm.cn/","www.cieaedu.cn/","www.hljrtvu.org.cn/","www.1957.cn/","www.bcyz.cn/","www.aqvtc.cn/","www.wucc.cn/","www.lngczyxy.com/","www.wnmc.edu.cn/","www.wczy.cn/","www.plaust.edu.cn/","wlxy.yangtzeu.edu.cn/","www.usx.edu.cn/","www.jzhxy.com/","www.hnieyy.cn/","www.hncu.net/","www.gdqy.edu.cn/","www.mju.edu.cn/","www.bjypc.edu.cn/","www.hngczy.cn/","www.nchu.edu.cn/","www.lnpc.cn/","www.bift.edu.cn/","gcxy.sut.edu.cn/","www.amtc.cn/","www.lingnan.edu.cn/","www.hgtc.org.cn/","www.gynvc.edu.cn/","www.ncwu.edu.cn/","www.ccsu.cn","cc.ahmu.edu.cn/welcome/","www.hust.edu.cn/","www.xzvtc.net/","www.bupt.edu.cn","www.plmc.edu.cn/","www.lixin.edu.cn/","www.hbcit.edu.cn/","www.hutc.zj.cn/","www.zhku.edu.cn/","www.dlnu.edu.cn/","gaokao.chsi.com.cn/sch/","www.gzarts.edu.cn/","www.usl.edu.cn/","www.sdjsxy.com/","www.sszss.com/","www.hntky.com/","www.crtvu.edu.cn","www.hzvtc.net/","www.hbtcm.edu.cn/","www.xdca.net/","www.jxjtxy.com/","www.yyvtc.cn/","www.bvtc.com.cn/","www.lnyyzyxy.com/","www.tjeti.com/","www.lzcu.edu.cn/","www.uvu.edu.cn/","www.wxstc.cn/","www.ustc.edu.cn","www.geelyedu.com/","www.jhun.edu.cn/","www.xlglvc.cn/","www.sdlgzy.com/","www.zzyedu.cn/","www.jyu.edu.cn/","zyedu.org/","www.bzvtc.com/","www.sxufe.edu.cn/","www.lntzy.com/","www.nottingham.edu.cn/","www.zisu.edu.cn/","www.jxgzy.cn/","www.bvclss.cn/","www.hftyxy.com/","www.fspt.net/","www.fjny.edu.cn/","www.nit.edu.cn/","www.tianyi.edu.cn/","www.nnxy.cn/","www.sxtyu.com/","www.hainnu.edu.cn/","www.ncbuct.com/","www.wzvtc.cn/","www.yangzixueyuan.com/","gcxy.hbut.edu.cn/","www.zzlg.org/","www.gzmu.edu.cn/","www.ldzy.com/","www.hcvt.cn/","www.bzmc.edu.cn/","www.sdmyxy.cn/","www.hbcszyxy.cn/","www.hftc.edu.cn/","www.zjxu.edu.cn/","www.hebeinu.edu.cn/","www.polyu.edu.hk","www.cqny.net/","www.shu.edu.cn","www.neusoft.edu.cn/","www.hbuas.edu.cn/","www.aepu.com.cn/","www.ujs.edu.cn/","www.fjjyxy.com/","www.njit.edu.cn/","www.yazjy.com/","www.jmu.edu.cn","www.fjpsc.edu.cn/","www.zjvcc.edu.cn/","www.bjuba.com.cn/","www.hljys.cn/","www.henu.edu.cn/","www.lzlqc.com/","210.45.32.151/","www.gxtcmu.edu.cn/","www.taru.edu.cn/","www.jxnu.edu.cn/","www.zzia.edu.cn/","www.xzmy.edu.cn/","www.xhsysu.cn/","www.jssmu.edu.cn/","www.jxaevc.com/","www.bjpldx.edu.cn/","www.hnmu.com.cn/","www.cqswxy.cn/","www.scnu.edu.cn","www.jbzy.com.cn/","www.xysm.csu.edu.cn/","www.biem.edu.cn/","www.bnu.edu.cn","www.zunyiyizhuan.com/","www.sbs.edu.cn/","www.jxysedu.com/","www.hbgy.edu.cn/","www.abtc.edu.cn/","www.hbxftc.com/","www.ujn.edu.cn/","www.lpszy.cn/","www.hzu.edu.cn/","www.jku.edu.cn/","www.tjufe.edu.cn/","www.cqepc.com.cn/","www.glut.edu.cn/","www.jxgymy.com/","www.lntvu.com/","www.hezeu.edu.cn/","www.ycxy.com/","xmgcedu.cn/","www.fjvcb.cn/","www.ynmec.com/","www.luas.edu.cn/","www.hzwx.cn/","www.ahiib.com/","www.tczj.net/","www.gnnu.cn/","www.xisu.edu.cn/","www.gdxa.cn/","www.cmu.edu.cn","www.zhzhu.edu.cn/","www.hnyszy.com.cn/","www.xjjtedu.com/","fstc.cn/","www.cqyti.com/","www.edubzvc.com.cn/","www.hneeu.edu.cn/","www.sxtvu.cn/","www.imuchuangye.cn/","www.nyzyxy.com/","www.cuaa.net/","www.hlbrc.cn/","www.xzyedu.com.cn/","www.sdca.edu.cn/","www.yctei.cn/","www.ahcme.edu.cn/","www.zzjm.edu.cn/","www.fe-edu.com.cn/","kjxy.whsu.edu.cn/","www.qau.edu.cn/","www.ytetc.edu.cn/","www.gench.edu.cn/","www.xit.edu.cn/","www.zjdfc.com/","www.imun.edu.cn/","www.ncnu.edu.tw/","www.pyvtc.cn/","www.cdutetc.cn/","www.shxy.net/","www.xxu.edu.cn/","www.hnjtzy.com.cn/","www.sxjgxy.edu.cn/","www.ggxy.com/","sit.shnu.edu.cn/","www.jlu.edu.cn","www.hnrtu.edu.cn/","www.sjcy.cn/","www.ccutchi.com/","www.nxtc.edu.cn/","www.spvec.com.cn/","www.polus.edu.cn/","www.gxibvc.net/","www.gnun.edu.cn/","www.zstu.edu.cn/","www.hnsyu.net/","www.sanlian.net.cn/","www.ccit.edu.cn/","www.zjhzcc.edu.cn/","www.hsu.edu.cn/","www.wut.edu.cn/","bjxy.zjtcm.net/","www.jnygz.com/","www.xtmc.net/","www.ahjgxy.com/","www.sit.edu.cn/","www.nedu.edu.cn/","www.pzhu.cn/","www.sjziei.com/","www.gdkm.edu.cn/","www.bwu.edu.cn/","www.sxny.cn/","www.hfbhxy.com/","www.cqcmxy.com/","www.schxmvc.com.cn/","www.ccit.js.cn/","www.hncst.edu.cn/","www.ift.edu.mo/","www.zjczxy.cn/","www.whinfo.cn/","www.hlxy.edu.cn/","www.nczyxy.com/","www.ucsanya.com/","www.hkc.edu.cn/","www.xauat.edu.cn","www.ntou.edu.tw/","www.shanxixjxy.com/","www.mnust.cn/","www.tcsisu.com/","www.hebmu.edu.cn/","www.lnfvc.edu.cn/","www.jsafc.edu.cn/","www.tzsz.net/","www.zlxy.cn/","dcxy.ynu.edu.cn/","www.hbgdys.cn/","www.tjnu.edu.cn/","www.zjjy.com.cn/","www.ncut.edu.cn/","www.dxatc.cn/","www.lndhdx.com/","www.nyjy.cn/","www.hbeutc.cn/","www.xzit.edu.cn/","www.xasyu.cn/","whxy.ynart.edu.cn/","www.sict.edu.cn/","www.qzygz.net/","www.citpc.edu.cn/","www.xatzy.cn/","www.eurasia.edu/","www.swun.edu.cn/","www.snnu.edu.cn","www.cumtb.edu.cn/","www.rpc.edu.cn/","www.njau.edu.cn","www.xawl.org/","www.ayit.edu.cn/","www.jhc.cn/","www.nchu.edu.tw/","www.npumd.edu.cn/","www.jxjdxy.com/","www.hfpec.edu.cn/","www.ny2000.com/","www.tifert.edu.cn/","www.hnnd.com.cn/","text6.idcbiz.cn/","www.ahgmedu.cn/","www.cj-edu.com.cn/","www.bcsa.edu.cn/","www.gztrc.edu.cn/","www.jzlg.cn/","www.wlcbyz.com/","www.zhz.cn/","sdw.hunnu.edu.cn/","www.whtvu.com.cn/","www.ordosvc.cn/","www.chntheatre.edu.cn/","www.gduf.edu.cn/","www.fzxy.edu.cn/","www.cqcet.edu.cn/","www.jqzy.com/","www.gzeic.com/","www.gengdan.cn/","www.yntvu.edu.cn/","www.cqvist.net/","www.lnit.edu.cn/","www.cyprxy.net/","www.lnnu.edu.cn/","www.whit.ah.cn/","www.dzvtc.cn/","nstc.sau.edu.cn/","zhujiang.tjufe.edu.cn/","www.he-edu.com/","www.cczu.edu.cn/","www.ysu.edu.cn","www.cqust.edu.cn/","www.scujj.com/","www.sqc.edu.cn/","www.gxau.edu.cn/","www.gxmu.edu.cn/","www.cqyygz.com/","www.dlut.edu.cn","www.jxcfs.com/","www.squ.net.cn/","jgxy.heuet.edu.cn/","www.ntnu.edu.tw/","www.ycptu.edu.cn/","www.cdut.edu.cn/","www.gxdlxy.com/","www.huas.cn/","www.fysf.com/","www.lwvc.edu.cn/","www.hist.edu.cn/","www.imau.edu.cn/","tpxy.usts.edu.cn/","www.cqjy.edu.cn/","www.zptc.cn/","www.gdptc.cn/","210.42.35.198/","www.jmsjs.com/","www.lnpu.edu.cn/","www.xjjszy.net/","www.nuc.edu.cn/","www.qttc.edu.cn/","www.sjtu.edu.cn","www.shumc.edu.cn/","www.gxut.edu.cn/","www.huat.edu.cn/","www.esu.edu.cn/","www.jscvc.cn/","www.tju.edu.cn","minsheng.henu.edu.cn/","www.hebtu.edu.cn","www.imnc.edu.cn/","www.czu.edu.cn/","www.njxzc.edu.cn/","www.sise.com.cn/","www.mitu.cn/","120.194.53.39/","www.nbchs.net/","www.swpu.edu.cn/","www.wipe.edu.cn","www.cqsxedu.com/","www.llhc.edu.cn/","www.jju.edu.cn/","www.whxy.net/","www.cicp.edu.cn/","www.whmzxy.cn/","www.tjbpi.com/","www.hbgyzy.edu.cn/","www.dfzy.edu.cn/","www.hgu.cn/","www.gavtc.cn/","www.bcu.edu.cn/","www.hnfnu.edu.cn/","www.boustead.edu.cn/","www.sgmtu.edu.cn","www.pfc.edu.cn/","www.cduestc.cn/","www.ycvc.edu.cn/","jtxy.heuu.edu.cn/","www.syzyedu.com/","www.xjnyedu.com/","www.jqu.net.cn/","www.ndgzy.com/","www.xhcom.edu.cn/","www.dqsy.net","www.nthu.edu.tw","www.nmjtzy.com/","www.jcut.edu.cn/","www.yxnzy.net/","www.lygtc.net.cn/","www.tynu.edu.cn/","www.xjnu.edu.cn/","www.dzu.edu.cn/","www.qzygz.com/","www.jlart.edu.cn/","www.hpu.edu.cn/","www.bjpc.edu.cn/","www.scatc.net/","www.tjzhic.com/","www.sdor.cn/","www.hqwy.com/","www.lyvtc.cn/","www.sdcet.cn/","www.xjtu.edu.cn","www.hbjcxy.com/","www.whpa.cn/","www.lncc.edu.cn/","www.fibec.cn/","www.tjcm.edu.cn/","www.sxptife.net/","www.zqtbu.com/","www.ahtvu.ah.cn/","www.zj-art.com/","www.fjdy.net/","www.wzu.edu.cn/","www.uir.cn/","www.silkedu.com/","www.sdxlxy.com/","www.hxxy.edu.cn/","www.xacom.edu.cn/","www.sdjtu.edu.cn/","www.gziec.net/","www.hbcnc.edu.cn/","www.sjzpc.edu.cn/","www.anhky.com/","www.yzerc.org/","gxlgxy.com/","www.gxgsxy.com/","www.imtvc.cn/","zs.bxait.cn/","www.lfyjzjxy.com/","www.gdin.edu.cn/","www.sdnu.edu.cn/","www.sycm.com.cn/","www.sicp.sh.cn/","www.cntcvc.com/","www.ecnu.edu.cn","www.xmht.com/","www.heuet.edu.cn/","www.jldh.com.cn/","www.sdcjxy.com/","www.tjgsxy.com.cn/","www.hnust.edu.cn/","www.cqjy.com.cn/","www.ccmusic.edu.cn","www.tsgzy.edu.cn/","www.zjsru.cn/","www.zju.edu.cn","www.atvcn.com/","www.gzkmu.cn/","www.hbwy.com.cn/","zjc.sxit.edu.cn/","www.bhzyxy.net/","www.scdyedu.cn/","www.zzlgxy.net/","www.mdjmu.cn/","www.bibt.edu.cn/","www.imac.edu.cn/","www.sjzjjxy.net/","www.tgcep.cn/","www.hdu.edu.cn/","www.svccc.net/","www.ahip.cn/","www.czie.net/","www.hhstu.edu.cn/","www.sta.edu.cn/","www.bjwszyxy.com/","www.yulinvtc.com.cn/","www.xzlssf.org/","www.hniec.net/","cjc.ecit.cn/","www.suu.com.cn/","218.5.241.27/","www.shsipo.com/","www.pku.edu.cn","www.wlcbzyxy.com.cn/","www.hncpu.com/","www.hnsyyz.cn/","www.sdjzu.edu.cn/","www.yangtzeu.edu.cn/","www.jxgcxy.net/","www.wgxy.net/","www.fdzcxy.com/","www.nhic.edu.cn/","www.ccom.edu.cn","www.sppc.edu.cn/","www.jlsfjy.cn/","www.gdxzzy.cn/","www.nttec.edu.cn/","www.gdufs.edu.cn","wjcollege.ahnu.edu.cn/","www.fzfu.com/","www.njue.edu.cn/","www.sdmc.net.cn/","www.nctc.com.cn/","www.shift.edu.cn/","www.sxvtc.com/","www.sgu.edu.cn/","www.ahau.edu.cn/","www.hrbeu.edu.cn/","www.sgmart.com/","www.ynufe.edu.cn/","kexin.hebeu.edu.cn/","www.hnrpc.com/","www.ntsc.edu.cn/","www.srzy.cn/","www.fjjxu.edu.cn/","www.lcvc.cn/","www.hieu.edu.cn/","www.hunnu.edu.cn/","csxy.usc.edu.cn/","www.swfc.edu.cn/","www.txxy.org/","www.stdu.edu.cn/","www.xaiu.edu.cn/","www.ahlyedu.cn/","xinhua.nxu.edu.cn/","www.gsli.edu.cn/","www.fudan.edu.cn","www.bowenedu.cn/","www.guangshaxy.com/","www.gxkjzy.com/","www.ecupl.edu.cn/","www.fyvtc.edu.cn/","www.fjmzw.com/","www.sdbi.com.cn/","www.scetop.com/","www.gdla.edu.cn/","www.cqwu.net/","www.sdp.edu.cn/","www.xaepi.edu.cn/","www.snbcedu.cn/","www.hceb.edu.cn/","www.njcc.edu.cn/","luojia-whu.cn/","www.qzqgxy.com/","www.jngcxy.com/","www.wfec.cn/","www.lsu.edu.cn/","www.qdqsgw.com/","www.zknu.edu.cn/","www.yau.edu.cn/","www.ahyz.cn/","www.hnyyyz.com/","www.hzvtc.cn/","www.szetop.com/","www.hhhxy.cn/","www.sdufe.edu.cn/","www.jsjzi.edu.cn/","www.jxkeda.com/","www.ccufe.com/","www.hebcpc.cn/","www.jxust.cn/","www.xacsjsedu.com/","www.qhmu.edu.cn/","www.sdwz.cn/","www.sdcit.cn/","www.qziedu.cn/","www.fafu.edu.cn/","www.shengda.edu.cn/","www.bjie.ac.cn/","www.hbmu.edu.cn/","www.forerunnercollege.com/","glxy.yzu.edu.cn/","www.tjqnzyxy.cn/","www.gxevc.com/","www.gsjdxy.com/","www.jxga.com/","www.hljp.edu.cn/","mts.zmc.edu.cn/","www.shjgu.edu.cn/","www.hljucm.net/","www.nwupl.cn/","www.hljstgc.org.cn/","www.scu.edu.cn/","www.wxic.edu.cn/","www.gdepc.cn/","www.zqmc.net/","www.bcpl.cn/","www.gyu.cn/","www.xmdh.com/","www.chzu.edu.cn/","xingjian.gxu.edu.cn/","www.cuc.edu.cn/","www.sctu.edu.cn/","hbtyzy.com/","www.fzu.edu.cn","www.scyesz.com/","www.chd.edu.cn/","www.sdwrp.com/","www.zsc.edu.cn/","www.gsjcxy.com/","www.tsnc.edu.cn/","www.ynu.edu.cn","www.gzvti.com/","www.shbangde.com/","www.kzjsxy.net/","www.sptc.sn.cn/","www.nau.edu.cn/","www.arthn.com/","www.tjmvi.cn/","www.hnut-d.com/","stc.ysu.edu.cn/","www.nxmu.edu.cn/","www.wyu.edu.cn/","www.chaohu.tv/","www.tjus.edu.cn/","www.cugb.edu.cn/","www.aqtc.edu.cn/","www.jjtc.com.cn/","occ.cueb.edu.cn/","www.csust.edu.cn/","www.sicau.edu.cn/","www.lzmc.edu.cn/","www.fvti.cn/","www.ouc.edu.cn/","www.hhtc.edu.cn/","www.tsinghua.edu.cn","www.sirt.edu.cn/","www.asu.edu.cn/","zb.njnu.edu.cn/","www.cdnkxy.com/","www.zync.edu.cn/","www.sxjt.edu.cn/","www.wntc.edu.cn/","www.hbqnxy.com/","www.hlxy.net/","www.ytu.edu.cn","www.thcyzy.org/","www.hnjs.edu.cn/","www.hzjxy.net/","www.gzmodern.cn/","www.gzhnc.edu.cn/","www.cdtu.edu.cn/","hdc.cczu.edu.cn/","www.cncnc.edu.cn/","www.hrbust.edu.cn","www.hljszy.net/","www.qzu.edu.cn/","www.hrbipe.edu.cn/","www.xzcit.edu.cn/","www.sxxh.org/","www.fky.net.cn/","www.ypc.edu.cn/","www.lyvtc.net/","www.jiangnan.edu.cn/","www.xjpcedu.cn/","www.lnmec.net.cn/","www.hnuc.edu.cn/","www.ccswust.com.cn/","www.ccca.edu.cn/","www.tute.edu.cn/","xhc.cumt.edu.cn/","www.czmec.cn/","www.pccu.edu.tw/","www.uestc.edu.cn","www.zjjcxy.cn/","www.neau.edu.cn/","www.cssf.cn/","www.vcit.cn/","www.gxgcedu.com/","www.dlteacher.com/","www.lnjzxy.com/","www.hycollege.net/","www.hevttc.edu.cn/","www.uzz.edu.cn/","www.hhvc.net.cn/","www.tskjzy.cn/","www.lnlzy.cn/","www.gzjtzy.net/","www.jci.edu.cn/","www.njfu.edu.cn","www.habc.edu.cn/","www.umac.mo/","www.gwng.edu.cn/","bhws.tjfsu.edu.cn/","www.nxist.com/","www.xjtlu.edu.cn/cn/","www.ahcbxy.cn/","www.shfc.edu.cn/","www.xcxz.com.cn/","www.scrtvu.net/","www.cqtbi.edu.cn/","www.lnemci.com/","www.hdxy.org/","www.wwoc.cn/","www.zcvc.cn/","www.wfu.edu.cn/","www.gipe.edu.cn/","www.sptpc.com/","www.jxutcm.edu.cn/","www.tawx.com.cn/","www.xingwei.edu.cn/","www.sxdxswxy.com/","www.sccvc.com/","www.nwnu.edu.cn","www.hbsi.edu.cn/","www.sdwm.cn/","www.sontan.net/","www.sxgy.cn/","www.hbswkj.com/","www.xnec.cn/","www.sxtcm.com","www.qzu.zj.cn/","www.rzpt.cn/","www.moe.gov.cn/srcsite/A03/moe_634/201505/t20150521_189479.html","hbklg.hebust.edu.cn/","www.gqkj.com.cn/","www.hljgvc.org.cn/","www.ln.edu.hk/","www.hbsy.cn/","www.xjtsxy.cn/","www.whpu.edu.cn/","www.oxbridge.edu.cn/","www.wbc.edu.cn/","www.cisau.com.cn/","www.snie.edu.cn/","www.nctu.edu.tw/","www.gdst.cc/","www.gdpu.edu.cn/","www.scut.edu.cn","www.lnxdfwxy.com/","www.fjdfxy.com/","www.nymc.cn/","www.yncpu.net/","www.qlmu.edu.cn/","www.zjff.net/","www.sdjnwx.com/","www.sxjzsf.cn/","mdc.gzu.edu.cn/","www.zjpc.net.cn/","www.hkfilm.com/","www.lstc.edu.cn/","www.ljlyzy.org.cn/","www.swu.edu.cn/","www.tjzj.edu.cn/","www.ahjzu.edu.cn/","www.sxmu-jcc.com/","www.nfu.edu.cn/","www.hactcm.edu.cn/","nyxy.hynu.cn/","www.gxjzy.com/","www.hfut.edu.cn/","www.mmc.edu.cn/","www.njty.edu.cn/","www.trzy.edu.cn/","www.ahpu.edu.cn/","www.yapt.cn/","www.lnc.edu.cn/","www.lnylxy.com/","www.ztu.edu.cn/","www.xju.edu.cn","www.swust.edu.cn/","www.gznu.edu.cn/","www.neuq.edu.cn/","www.sqzy.com.cn/","www.zdsoft.com.cn/","scstc.cn/","www.cafuc.edu.cn/","www.cufe.edu.cn/","www.njtc.edu.cn/","www.hkxy.edu.cn/","www.cfzyjsxy.com/","www.ncc.edu.cn/","www.njrts.edu.cn/","www.nuit.edu.cn/","www.csuedu.com/","www.gagx.com.cn/","www.dlswedu.com/","zj.njust.edu.cn/","www.ahnu.edu.cn/","www.lnu.edu.cn","www.hsit.edu.cn/","www.imeic.cn/","www.hdc.edu.cn/","www.fsm.gov.mo/esfsm","www.nmpower.cn/","www.lnist.edu.cn/","www.xianyangzhiyuan.cn/","www.cmoc.cn/","www.hzau.edu.cn/","www.yzpc.edu.cn/","www.sjzuehx.cn/","www.ky.zstu.edu.cn/","www.qhu.edu.cn/","www.qzit.edu.cn/","www.ycu.com.cn/","www.sxsy.com.cn/","www.sxjdxy.org/","www.gdut.edu.cn","www.sccm.cn","gdxy.hfut.edu.cn/","www.jmpt.cn/","www.tjtdxy.cn/","www.lfvtc.cn/","www.hbucvc.edu.cn/","www.sxjztc.edu.cn/","www.bucm.edu.cn/","www.xjmu.org/","www.cqepc.cn/","www.nmgyzyxy.com/","tdxy.njupt.edu.cn/","www.zjjy.net/","www.hebart.com/","www.gxu.edu.cn","www.szai.com/","www.jxytxy.com.cn/","www.bda.edu.cn","www.ldxy.cn/","www.shcmusic.edu.cn/","www.nefu.edu.cn/","www.jxdlzy.com/","www.jcivt.com/","www.tjtvc.com/","www.sthu.cn/","www.xyc.edu.cn/","www.sdsfjy.com/","www.znszy.com/","www.zufedfc.edu.cn/","www.hbqcxy.com/","www.ynnu.edu.cn/","www.cysz.com.cn/","www.qtech.edu.cn/","www.xjgyedu.cn/","sqxy.gmc.edu.cn/","www.kmvtc.net/","www.56edu.com/","www.lidapoly.com/","www.gfxy.com/","www.cqtcedu.com/","www.bjy.ah.cn/","www.qhctc.edu.cn/","www.dyc.edu.cn/","www.sailingedu.com/","www.sdwu.edu.cn/","www.btbu.edu.cn/","www.sisu.edu.cn/","www.glnc.edu.cn/","www.mmc.edu.mo/","www.usth.edu.cn/","www.hbei.com.cn/","www.zjnu.edu.cn/","www.qztc.edu.cn/","www.shvtc.com/","www.bhbhxy.com/","www.sdtvu.com.cn/","www.nmgfzzyxy.com/","www.dlrj.edu.cn/","www.sdada.edu.cn/","www.wit.edu.cn/","www.sypt.cn/","www.aheadedu.com/","www.gnsyky.cn/","www.jsu.edu.cn/","www.xztc.edu.cn/","www.fzacc.com/","www.cqie.cn/","www.dky.bjedu.cn/","www.npuc.edu.cn/","www.scmc.edu.cn/","www.scmpi.cn/","i.guet.edu.cn/new/","www.ynswxy.com/","www.tzc.edu.cn/","www.fjtcm.edu.cn/","www.hsvtc.cn/","www.xiyou.edu.cn","www.hbeu.cn/","www.cqvie.edu.cn/","www.sues.edu.cn/","www.syu.edu.cn/","www.zswxy.cn/","www.tjcsxy.cn/","www.nxmzy.com.cn/","www.cycu.edu.tw/","www.caztc.edu.cn/","www.tjmvti.cn/","www.hnkjxy.net.cn/","www.sru.jx.cn/","www.jlau.edu.cn/","www.njmu.edu.cn","www.ynjw.net/","www.sust.edu.cn/","www.lfsfxy.edu.cn/","www.bvtc.edu.cn/","www.bjut.edu.cn/","www.hku.hk","www.qdu.edu.cn","www.xcitc.edu.cn/","www.sdwfvc.com/","www.jxnyc.net/","www.gxufl.com/","www.ynavc.com/","www.lcudc.cn/","www.tjtc.edu.cn/","www.sut.edu.cn/","www.sjzmc.cn/","www.ksu.edu.cn/","www.cust.edu.cn/","www.wendaedu.com.cn/","sz.gyctcm.edu.cn/","www.sxbac.net.cn/","www.hebnzxy.com/","www.ncst.edu.cn/","www.wuyiu.edu.cn/","www.xhtu.com.cn/","www.bjou.edu.cn/","www.sdut.edu.cn/","kjxy.huat.edu.cn/","www.tjrtvu.edu.cn/","kjxy.shzu.edu.cn/","www.kmyz.edu.cn/","www.gmu.cn/","www.juti.cn/","www.mvcollege.com/","ctea.chinataxedu.net/","www.swjtuhc.cn/","www.qjyz.org/","www.bxxy.com/","www.gdhsc.edu.cn/","www.zjut.edu.cn/","www.yndhvc.com/","www.nju.edu.cn/","www.tuli.edu.cn/","www.bit.edu.cn/","www.jxstnupi.cn/","www.shisu.edu.cn/","www.bdu.edu.cn/","www.ykdx.net/","www.weihaicollege.com/","www.ouhk.edu.hk/","www.dfzyxy.net/","www.lzjtu.edu.cn/","www.thnu.edu.cn/","www.czjdu.com/","www.tjmu.edu.cn/","www.jladi.com/","www.sxtvi.com.cn/","www.zepc.edu.cn/","www.bhsyxy.com/","www.ldxy.edu.cn/","www.cxtc.edu.cn/","www.ustsd.edu.cn/","www.ust.hk","www.hnsfjy.cn/","www.lzzy.net","www.xjart.edu.cn/","www.gdylc.cn/","www.gzhu.edu.cn/","www.ecjtu.jx.cn/","www.wfgsxy.com/","www.imnu.edu.cn/","www.qnzy.net/","www.xtzy.com/","www.hncedu.cn/","www.zjtongji.edu.cn/","www.csiic.com/","www.xjie.edu.cn/","www.gsfc.edu.cn/","www.yctc.edu.cn/","www.gyctcm.edu.cn/","www.zjweu.edu.cn/","wenjing.ytu.edu.cn/","www.hfitu.cn/","www.sjzpt.edu.cn/","www.ahsjxy.cn/","www.ncku.edu.tw/","www.csmzxy.com/","www.imaa.edu.cn/","www.dgpt.edu.cn/","www.mxdx.net/","www.fenglin.org/","www.xiyi.edu.cn/","www.sqmc.edu.cn/","www.yihms.com/","taxq.sdust.edu.cn/","nxfszs.com/","www.zdxy.cn/","www.hsnc.edu.cn/","www.qlnu.edu.cn/","www.sspu.edu.cn/","www.lhmc.edu.cn/","www.fync.edu.cn/","www.min-yuan.com/","www.tmmu.edu.cn/","www.gist-edu.cn/","www.acac.cn/","shmc.fudan.edu.cn/","www.nccu.edu.tw/","www.sjmsxy.net.cn/","www.tongde.com/","www.lcnc.cn/","www.scst.edu.cn/","www.kmu.edu.cn/","www.hnnu.edu.cn/","www.cumtyc.com.cn/","www.gdufe.edu.cn/","www.jlsu.edu.cn/","www.hnevc.com/","www.szjm.edu.cn/","www.open.ha.cn/","www.gxart.cn/","www.whsw.net/","www.hrbcu.edu.cn/","www.sxu.edu.cn","www.jscjxy.cn/","www.qqhrtc.com/","www.nuaa.edu.cn","www.dlufl.edu.cn/","www.helc.edu.cn/","www.syau.edu.cn/","www.hbnyxy.cn/","www.yngsxy.net/","www.gxsy.edu.cn/","www.sau.edu.cn/","www.hfu.edu.cn/","www.sxjczy.com.cn/","www.bjtuhbxy.cn/","www.ahptc.cn/","www.hubu.edu.cn","www.scshpc.com/","www.tjcu.edu.cn/","www.shufe.edu.cn/","www.hbun.net/","www.hnmeida.com.cn/","www.hbasstu.net/","www.ymcn.gx.cn/","www.cjlu.edu.cn/","www.ybu.edu.cn/","www.whjzy.net/","www.zzhxxy.com/","www.ycvc.jx.cn/","www.hnpi.cn/","www.syuct.edu.cn/","www.szitu.cn/","www.gxtznn.com/","www.haue.edu.cn/","qjxy.hznu.edu.cn/","www.afeu.cn/","www.cjxy.edu.cn/","www.synu.edu.cn/","www.cdcas.edu.cn/","www.haie.edu.cn/","www.jgy.gx.cn/","www.whflfa.com/","www.yulinu.edu.cn/","www.pjzy.net.cn/","www.lvtc.edu.cn/","www.whetc.com/","www.xdxd.cn/","www.lnutcm.edu.cn/","www.zjiet.edu.cn/","www.hnzjschool.com/","www.hnwmxy.com/","www.gdsspt.net/","www.hbcf.edu.cn/","huihua.hebtu.edu.cn/","www.yngtxy.net/","www.jxatei.net/","www.huaao.sx.cn/","www.hbmy.edu.cn/","www.chaoshan.cn/","www.hnkjedu.cn/","www.hju.net.cn/","www.dali.edu.cn/","www.chsnenu.edu.cn/","www.yvtc.edu.cn/","jsxy.nau.edu.cn/","www.fxgz.com.cn/","www.bdxy.com.cn/","www.ggzy.edu.cn/","www.cdzy.cn/","www.jzsz.cn/","www.ntua.edu.tw/","acsxy.aufe.edu.cn/","www.ncepu.edu.cn/","www.ynxd.net.cn/","www.wjxvtc.cn/","www.dxalu.com/","www.jzu.edu.cn/","www.gdcvi.net/","www.hr-edu.com/","www.htszedu.cn/","www.usc.edu.cn/","ygxy.fzu.edu.cn/","www.csu.edu.cn/","www.wxwsxy.cn/","www.stbu.edu.cn","www.tjchengjian.com/","www.hhit.edu.cn/","www.hnyzzy.com/","www.huanghaicollege.com/","www.cseptc.net/","www.witpt.edu.cn/","www.gxuwz.edu.cn/","www.gdyzy.edu.cn/","www.yndhec.net/","www.fareast-edu.net/","www.jseti.edu.cn/","www.zlvc.edu.cn/","www.jxtcmstc.com/","www.jcc.jx.cn/","www.jxcb.com/","www.sicfl.edu.cn/","www.ahjzu.edu.cn/cjxy/","www.csgedu.cn/","www.xmafkj.com/","www.aynu.edu.cn/","www.gdmec.cn/","www.ncgxy.com/","www.jlucc.edu.cn/","www.hnupc.net/","www.caa.edu.cn/","www.nmgmsxy.net/","www.wxgyxy.cn/","www.gxccedu.com/"};
    String r2="http://www.5566.org/indexe.htm";


    JdbcTemplate jdbcTemplate = null;

    public School44() {
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



   public String  g3(int x6){
       String url;
        String l8="6633.5566";
        String t7=""+"http://www.5566.net/school.htm";
        String j8=""+"www.5566.net";
        String c3="=''+location.href;";
        String i3="9977.5566";
        String z0="=''+location.hostname;";
        int z7=j8.lastIndexOf('.');
        int x9=0+Integer.parseInt(String.valueOf(i3.charAt(3)));
        int u0=0+Integer.parseInt(String.valueOf(i3.charAt(1)));
        int f6=0+Integer.parseInt(String.valueOf(j8.charAt(z7-3)));
        int r1=0+string2Unicode(String.valueOf(c3.charAt(6)));
        int v8=0+Integer.parseInt(String.valueOf(j8.charAt(z7-1)));
        int w1=0+string2Unicode(String.valueOf(z0.charAt(5)));
        String x8="school";
        if(t7.indexOf("5566")==-1||t7.indexOf("school")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+s1[(x6-f6-u0-x9-w1-r1-66)/v8];
        }
        return  url;
    }
   public String a2(int t3){
       String url = "";
        String e2="=''+document.domain;";
        String y6="1155.5566";
        String o0="=''+document.URL;";
        String v2=""+"www.5566.net";
        String h7=""+"http://www.5566.net/school.htm";
        String l8="7799.5566";
        int d9=v2.lastIndexOf('.');
        int q6=0+string2Unicode(String.valueOf(e2.charAt(5)));
        int o1=0+Integer.parseInt(String.valueOf(v2.charAt(d9-1)));
        int i9=0+string2Unicode(String.valueOf(o0.charAt(6)));
        int f9=0+Integer.parseInt(String.valueOf(v2.charAt(d9-3)));
        int a0=0+Integer.parseInt(String.valueOf(y6.charAt(1)));
        int s4=0+Integer.parseInt(String.valueOf(y6.charAt(2)));
        String l3="school";
        if(v2!="5566.net"&&v2!="www.5566.net"&&v2!="5566.org"&&v2!="1.5566.org"&&v2!="2.5566.org"&&v2!="3.5566.org"&&v2!="4.5566.org"&&v2!="5.5566.org"&&v2!="www.5566.org"){
              url ="http://www.5566.org/indexe.htm";
   }else{
       url = "http://"+s1[(t3-f9-o1-s4-q6-i9-94)/a0];
   }
   return  url;
}



public String  j2(int i4){
    String url = "";
    String i8="=''+document.location;";
    String n0=""+"www.5566.net";
    String y7="5511.5566";
    String a9="3366.5566";
    String j5=""+"http://www.5566.net/school.htm";
    String q5="=''+location.host;";
    int z1=n0.lastIndexOf('.');
    int s0=0+string2Unicode(String.valueOf(i8.charAt(6)));
    int m9=0+Integer.parseInt(String.valueOf(n0.charAt(z1-3)));
    int g1=0+Integer.parseInt(String.valueOf(a9.charAt(3)));
    int m7=0+Integer.parseInt(String.valueOf(n0.charAt(z1-1)));
    int c9=0+Integer.parseInt(String.valueOf(a9.charAt(0)));
    int p1=0+string2Unicode(String.valueOf(q5.charAt(5)));
    String f7="school";
    if(n0=="5566.net"||n0=="www.5566.net"||n0=="5566.org"||n0=="1.5566.org"||n0=="2.5566.org"||n0=="3.5566.org"||n0=="4.5566.org"||n0=="5.5566.org"||n0=="www.5566.org"){
       url = "http://"+s1[(i4-m7-c9-g1-p1-s0-60)/m9];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("g3")) {
                    tmpUrl = g3(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("j2")) {
                    tmpUrl = j2(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("a2")) {

                    tmpUrl = a2(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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





    public  void  getSchoolUrls(String url){

        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "教育";
        String tag2 ="大学高校";
//        System.out.println(p.get(21));
        //20, 33
        int[] numbers = {21};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }





    }

    public static void main(String[] args) {

        School44 school44 = new School44();

        school44.getSchoolUrls("http://www.5566.net/school.htm");



    }






}
