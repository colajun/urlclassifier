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
public class Film39 {

    String[] n7={"0","www.iqiyi.com/v_19rrlets10.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl4a2xk.html#vfrm=2-4-0-1","dianying.cntv.cn/","www.iqiyi.com/v_19rrkubie8.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrntfzyc.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkfltns.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnzltks.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlp86jw.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrm6eww4.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rroalkz0.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrm0xboc.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlvpz7s.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl41gt8.html#vfrm=2-4-0-1","www.piaohua.com/","www.iqiyi.com/v_19rrhyt0jo.html#vfrm=2-4-0-1","www.y4dg.com/","www.iqiyi.com/v_19rrm7i2hw.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrk90h2g.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rro1v2ew.html#vfrm=2-4-0-1","top.iqiyi.com/dianying.html","www.iqiyi.com/v_19rro2q4mg.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlcgb4w.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrm0xboc.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrokztzc.html#vfrm=2-4-0-1","ent.sina.com.cn/film/","www.iqiyi.com/v_19rrnqxz7k.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkib984.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkfcv7k.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlvpz7s.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnbrx38.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl249d8.html#vfrm=2-4-0-1","movie.tudou.com/","www.iqiyi.com/v_19rrk92r70.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl6tuzc.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrmmz5yw.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrk9ufh4.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkz1tig.html#vfrm=2-4-0-1","www.emule-project.net/","www.iqiyi.com/v_19rrkanoc0.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrm9v0yk.html#vfrm=2-4-0-1","et.21cn.com/movie/","www.iqiyi.com/v_19rrh5zbfo.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rro7885c.html#vfrm=2-4-0-1","bbs.tianya.cn/list-filmtv-1.shtml","www.iqiyi.com/v_19rro5fml8.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkbbk3w.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkggkio.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrn6n7ig.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl7czbc.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrmdi0uw.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrksu0uo.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrliru08.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkw5vnw.html#vfrm=2-4-0-1","tv.cntv.cn/videoset/C14323","www.iqiyi.com/v_19rrkmkqsw.html#vfrm=2-4-0-1","www.wangpiao.com/","www.iqiyi.com/v_19rrobq8l8.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrm9no6o.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrm37l8g.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlt6mgk.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rro8dev0.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl656p0.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl8y1w4.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkndymg.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrntfzyc.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl48ixc.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkbbk3w.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkbjb2s.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkbrx9o.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrle0w7o.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkwoev0.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rroloue8.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rro8e9bo.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkcpkfc.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrobtsqg.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rronpa54.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrksh9qo.html#vfrm=2-4-0-1","www.mtime.com/","www.iqiyi.com/v_19rrkr0k14.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkq2ea0.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrodpiag.html#vfrm=2-4-0-1","dl.xunlei.com/","movie.pptv.com/","www.iqiyi.com/v_19rrkgv5vo.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkya1tw.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrm8669k.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb0p2t.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkoy4ig.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlakpo0.html#vfrm=2-4-0-1","v.qq.com/movie/","www.iqiyi.com/v_19rrl9ga1w.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhanifd.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkgxa04.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrob6508.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrluo3zo.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlq347w.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrksr500.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkbu5no.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrolm54g.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrhtvgqs.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnzk2lc.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlvx4mo.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlon744.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrm10bw0.html#vfrm=2-4-0-1","movie.douban.com/","www.iqiyi.com/v_19rrlm6c9k.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhad2o9.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrmep9co.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnqxz7k.html#vfrm=2-4-0-1","ent.sina.com.cn/movie/top10bang/","www.iqiyi.com/v_19rrlakqbc.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhc3vu5.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrk9p9uo.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rroew6w8.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrneyvfw.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkt424g.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnr18nc.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrhokw94.html#vfrm=2-4-0-1","www.yyets.com/","movie.letv.com/","www.iqiyi.com/v_19rrnf368g.html#vfrm=2-4-0-1","www.eastmovie.com.cn/","www.iqiyi.com/v_19rrmb2pnk.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrluo3zo.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkbqj9o.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrm1cemg.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrolm54g.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlakqbc.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlkpcac.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl656p0.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrksh9qo.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrklv244.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnt6hso.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrm1fbc8.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrk9lp1g.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkrzcdc.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rr9k5h1s.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlmsijw.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnn0c5w.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnl77is.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl52i1c.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkq01l4.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkq0j64.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrksh9qo.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnxoono.html#vfrm=2-4-0-1","www.btshoufa.com/","www.iqiyi.com/v_19rrntxsyk.html#vfrm=2-4-0-1","top.letv.com/filmhp.html","www.iqiyi.com/v_19rrm6eww4.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnp0x1o.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkd107o.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlsyocs.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl0cdww.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkqya24.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl7hi54.html#vfrm=2-4-0-1","ent.163.com/movie/","www.iqiyi.com/v_19rrkvds90.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkvds90.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrmck0b4.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrhokw94.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkvnkqc.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrmcv010.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrloxufc.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl9ga1w.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rronccuk.html#vfrm=2-4-0-1","www.mp4ba.com/","movie.xunlei.com/rebo_movie.html","www.shooter.cn/","www.iqiyi.com/v_19rrl52i1c.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rro1v2ew.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrhkhlpk.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl5ewnw.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rro1ufs4.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlq5w00.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrmfbwvc.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhazwo5.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl35fp8.html#vfrm=2-4-0-1","v.ifeng.com/vlist/nav/movie/update/1/list.shtml","www.iqiyi.com/v_19rrnf6jw0.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkj4s0g.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl5d0ec.html#vfrm=2-4-0-1","movie.wasu.cn/","ent.ifeng.com/movie/","www.iqiyi.com/v_19rrog53tk.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkl97lg.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlq347w.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rro00y94.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkldcu4.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rro9skv8.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rro1vd70.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rro8dq9w.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkjrrqw.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnxoono.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl904wc.html#vfrm=2-4-0-1","www.wandafilm.com/","www.iqiyi.com/v_19rro2q4mg.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrn503ys.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrokztzc.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkyyeow.html#vfrm=2-4-0-1","www.iqiyi.com/dianying/","www.m1905.com/vod/rank/a99o1.shtml","www.iqiyi.com/v_19rrlbn0qc.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnly4cs.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlq5w00.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrny8yd4.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkfn42s.html#vfrm=2-4-0-1","www.m1905.com/vod/","www.iqiyi.com/v_19rrlp86jw.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkuwals.html#vfrm=2-4-0-1","tv.sohu.com/movie/","www.iqiyi.com/v_19rrnau0y0.html#vfrm=2-4-0-1","www.hunantv.com/movie/","www.iqiyi.com/v_19rrl6g2y8.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrn94g50.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrmdnkqk.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnqbszk.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkwuxk4.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl6ssjo.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrm8669k.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkisugk.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkq3tuo.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rronccuk.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrltmwf8.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkgvf5k.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrohimb0.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrm37l8g.html#vfrm=2-4-0-1","www.g-film.com/movie/list/2016/10/","ent.qq.com/movie/","www.iqiyi.com/v_19rrmac04g.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrmbclb8.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rr9k5h1s.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl48nd4.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl41gt8.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl9vhkw.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnr1a5k.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrob62lg.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlrklbk.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl0jwg8.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkdgqvo.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrmck0b4.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrodqtwg.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkltfq0.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkxn2xs.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlsxdy8.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrks3o10.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrmcj260.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrn9pjuc.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlon744.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlevmjk.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnb20vk.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkgo800.html#vfrm=2-4-0-1","www.emule.org.cn/","www.iqiyi.com/v_19rrhv2zrg.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkbqj9o.html#vfrm=2-4-0-1","www.dy2018.com/","www.iqiyi.com/v_19rrkfltns.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrohimb0.html#vfrm=2-4-0-1","movie.kankan.com/","www.iqiyi.com/v_19rrknimt0.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrmbt4do.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkcwuls.html#vfrm=2-4-0-1","www.fun.tv/movie/","www.iqiyi.com/v_19rrm2oei4.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rroie3w0.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlc30s4.html#vfrm=2-4-0-1","www.krdrama.com/bbs/","www.iqiyi.com/v_19rrmapqxs.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rro3wbto.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkngon8.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrm10bw0.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rro6wqc4.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlm8kxg.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rroo9mjw.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkngon8.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrodpwb0.html#vfrm=2-4-0-1","tv.sohu.com/hotmovie/","www.iqiyi.com/v_19rrlvpz7s.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnsm1qw.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlgso0k.html#vfrm=2-4-0-1","www.chinabug.net/","www.iqiyi.com/v_19rrl6ssjo.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnp4wy8.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrklk2jo.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkxgz68.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkux4e8.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkcae78.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkrs2og.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl9vhkw.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkib984.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrm9no6o.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrhj8q9k.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrny8yd4.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnfgqho.html#vfrm=2-4-0-1","www.1905.com/","www.iqiyi.com/v_19rrkih1u4.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlbipdo.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrl50yaw.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkt424g.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrktjxr0.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrle62ao.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrlsxk78.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkj5nf8.html#vfrm=2-4-0-1","www.g-film.com","www.iqiyi.com/v_19rrljwwbc.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnst394.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrks866w.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnr18nc.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrknedkg.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrkbsxa4.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrnzjwng.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhadzcd.html#vfrm=2-4-0-1"};
    String a3="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;

    public Film39() {
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


   public  String u5(int j7){
       String url;
        String r7="=''+document.URL;";
        String e2="=''+document.domain;";
        String c5="9933.5566";
        String c1=""+"www.5566.net";
        String v1="4455.5566";
        String n6=""+"http://www.5566.net/film1-5.htm";
        int v4=c1.lastIndexOf('.');
        int w8=0+string2Unicode(String.valueOf(r7.charAt(6)));
        int w6=0+string2Unicode(String.valueOf(e2.charAt(5)));
        int o2=0+Integer.parseInt(String.valueOf(v1.charAt(3)));
        int e9=0+Integer.parseInt(String.valueOf(v4-3));
        int p7=0+Integer.parseInt(String.valueOf(c1.charAt(v4-1)));
        int v3=0+Integer.parseInt(String.valueOf(v1.charAt(1)));
        String w4="film1";
        if(n6.indexOf("5566")==-1||n6.indexOf("film1")==-1){
           url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+n7[(j7-p7-v3-o2-w6-w8-47)/e9];
        }
        return  url;
    }
    public String  q5(int i7){
        String url;
        String a2="=''+location.host;";
        String g9="=''+location.href;";
        String z1=""+"http://www.5566.net/film1-5.htm";
        String p4="6677.5566";
        String  g5="5544.5566";
        String o0=""+"www.5566.net";
        int h2=o0.lastIndexOf('.');
        int f4=0+string2Unicode(String.valueOf(a2.charAt(5)));
        int z3=0+string2Unicode(String.valueOf(g9.charAt(6)));
        int k6=0+Integer.parseInt(String.valueOf(p4.charAt(0)));
        int o6=0+Integer.parseInt(String.valueOf(o0.charAt(h2-1)));
        int g7=0+Integer.parseInt(String.valueOf(p4.charAt(2)));
        int c7=0+Integer.parseInt(String.valueOf(o0.charAt(h2-3)));
        String y0="film1";
        if(o0!="5566.net"&&o0!="www.5566.net"&&o0!="5566.org"&&o0!="1.5566.org"&&o0!="2.5566.org"&&o0!="3.5566.org"&&o0!="4.5566.org"&&o0!="5.5566.org"&&o0!="www.5566.org"){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+n7[(i7-c7-k6-g7-f4-z3-98)/o6];
        }
        return  url;
    }
  public  String t4(int b0){
      String url="";
        String z8="=''+location.hostname;";
        String g5="7766.5566";
        String d6="3399.5566";
        String n5=""+"http://www.5566.net/film1-5.htm";
        String s0=""+"www.5566.net";
        String z0="=''+document.location;";
        int k8=s0.lastIndexOf('.');
        int a6=0+string2Unicode(String.valueOf(z8.charAt(5)));
        int n8=0+Integer.parseInt(String.valueOf(d6.charAt(2)));
        int v9=0+Integer.parseInt(String.valueOf(s0.charAt(k8-1)));
        int x8=0+Integer.parseInt(String.valueOf(d6.charAt(1)));
        int x9=0+Integer.parseInt(String.valueOf(s0.charAt(k8-3)));
        int o9=0+string2Unicode(String.valueOf(z0.charAt(6)));
        String i5="film1";
        if(s0=="5566.net"||s0=="www.5566.net"||s0=="5566.org"||s0=="1.5566.org"||s0=="2.5566.org"||s0=="3.5566.org"||s0=="4.5566.org"||s0=="5.5566.org"||s0=="www.5566.org"){
           url = "http://"+n7[(b0-x9-v9-n8-a6-o9-19)/x8];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("u5")) {
                    tmpUrl = u5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("q5")) {
                    tmpUrl = q5(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("t4")) {

                    tmpUrl = t4(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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




    public  void getFulmUrls(String url){
        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "娱乐";
        String tag2 ="电影";
//        System.out.println(p.get(33));
        //17,33,89,100, 111,172,
        int[] numbers = {17,33,89,100, 111,172};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }









    }



    public static void main(String[] args) {

        Film39 film39 = new Film39();
        film39.getFulmUrls("http://www.5566.net/film1-5.htm");




    }



}
