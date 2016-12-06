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
public class Dsj40 {
    String[] i8={"0","www.iqiyi.com/v_19rrgzy5ls.html","www.iqiyi.com/a_19rrhbeaxt.html#vfrm=2-4-0-1","www.letv.com/tv/10006243.html","www.iqiyi.com/a_19rrhaywod.html","www.iqiyi.com/a_19rrhb94rh.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrh9rfup.html#vfrm=2-4-0-1","www.letv.com/tv/10010209.html","www.le.com/tv/10030288.html","www.iqiyi.com/a_19rrhayynx.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rr9bx0uo.html","www.iqiyi.com/a_19rrhbd5hd.html#vfrm=2-4-0-1","www.letv.com/tv/10019913.html","www.iqiyi.com/a_19rrhanm25.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhawpl5.html#vfrm=2-4-0-1","www.le.com/tv/10031347.html","www.iqiyi.com/a_19rrhc1qo9.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb8ee1.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrh9oonl.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhagxp5.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb51ct.html","www.letv.com/tv/10018140.html","www.iqiyi.com/a_19rrhbff8t.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhas2wp.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhavzfp.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhap9m5.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbf1gp.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb56rx.html#vfrm=2-4-0-1","tv.letv.com/","www.iqiyi.com/a_19rrhaq771.html#vfrm=2-4-0-1","tv.tudou.com/","www.iqiyi.com/a_19rrha00o9.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhacind.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhc2wxp.html","v.sogou.com/top/teleplay/index.html","www.tudou.com/top/r30c.html","www.iqiyi.com/a_19rrhb9929.html#vfrm=2-4-0-1","www.letv.com/tv/93334.html","www.iqiyi.com/a_19rrhb0w7x.html","www.iqiyi.com/a_19rrhakcol.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbc5yl.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb27kd.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rr9etpsc.html","www.iqiyi.com/v_19rrm47xu8.html","www.iqiyi.com/a_19rrhayhrp.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rr9c6jec.html","www.iqiyi.com/a_19rrhc1qpt.html","www.iqiyi.com/a_19rrhayyip.html","www.iqiyi.com/a_19rrhbz2oh.html","www.iqiyi.com/a_19rrhb8bpd.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbgr8t.html#vfrm=2-4-0-1","www.letv.com/tv/10012352.html","www.iqiyi.com/a_19rrhb0zu9.html","www.letv.com/tv/10008912.html","www.iqiyi.com/a_19rrh9qzjd.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb5jmt.html","www.iqiyi.com/a_19rrh9y41h.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhaycb1.html","www.iqiyi.com/a_19rrhayyr1.html","www.iqiyi.com/a_19rrha01hl.html#vfrm=2-4-0-1","tv.kankan.com/","www.le.com/tv/10012076.html","www.iqiyi.com/a_19rrhb3lc5.html","www.iqiyi.com/a_19rrhbzt9l.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhacikl.html#vfrm=2-4-0-1","www.letv.com/tv/10007524.html","www.iqiyi.com/a_19rrhazryl.html","www.letv.com/tv/95709.html","www.letv.com/tv/10017618.html","www.iqiyi.com/a_19rrhb4chd.html","top.iqiyi.com/dianshiju.html","www.iqiyi.com/a_19rrh9xd69.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb9gyd.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb5t19.html","www.iqiyi.com/a_19rrhbbh01.html#vfrm=2-4-0-1","www.letv.com/tv/10021286.html","www.letv.com/tv/81401.html","www.le.com/tv/10004306.html","www.iqiyi.com/a_19rrh9wb2d.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbd6ad.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhacifx.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbbih1.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhc3i3l.html","www.iqiyi.com/v_19rrhjtpjc.html","www.iqiyi.com/a_19rrhb8tjt.html#vfrm=2-4-0-1","www.le.com/tv/10010364.html","www.iqiyi.com/a_19rrh9ut7d.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb3hf5.html","dianshiju.cntv.cn/","www.iqiyi.com/v_19rr9convg.html","www.iqiyi.com/a_19rrhadrh1.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrha01kd.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rr9kpl2k.html","www.iqiyi.com/a_19rrgiiy9h.html","www.iqiyi.com/a_19rrhaj2id.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb4zoh.html#vfrm=2-4-0-1","www.le.com/tv/10030568.html","www.iqiyi.com/a_19rrhb0y75.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbd5ml.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbewsp.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhavlj1.html#vfrm=2-4-0-1","www.letv.com/tv/10009400.html","www.letv.com/tv/80195.html","www.iqiyi.com/a_19rrhb37h5.html","www.iqiyi.com/a_19rrhb6mt1.html","www.iqiyi.com/a_19rrhb3kcx.html","www.iqiyi.com/a_19rrhaj2j1.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb6mfh.html","www.iqiyi.com/a_19rrhc3795.html","www.letv.com/tv/10014548.html","www.letv.com/tv/10008538.html","www.iqiyi.com/a_19rrh9utbp.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhc496p.html#vfrm=2-4-0-1","www.le.com/tv/10008904.html","www.iqiyi.com/a_19rrhavlgl.html","www.letv.com/tv/10007460.html","www.iqiyi.com/a_19rrh9w8vh.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbg5xp.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrh9nma5.html#vfrm=2-4-0-1","www.le.com/tv/10019913.html","www.le.com/tv/10030665.html","www.iqiyi.com/a_19rrhaaph9.html#vfrm=2-4-0-1","www.letv.com/tv/10009176.html","www.letv.com/ptv/vplay/22965591.html","www.letv.com/tv/10030296.html","video.sina.com.cn/movie/category/teleplay/index.html","www.letv.com/tv/10010517.html","www.iqiyi.com/a_19rrhbduzt.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb59at.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhaniyh.html#vfrm=2-4-0-1","www.letv.com/tv/10009366.html","www.iqiyi.com/a_19rrhbfqf1.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb8ind.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhazxil.html","www.iqiyi.com/a_19rrhb8d05.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb510t.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb1tal.html","www.letv.com/tv/10030288.html","www.hunantv.com/tv/","www.iqiyi.com/a_19rrhaxj4x.html","www.letv.com/tv/10025348.html","www.iqiyi.com/a_19rrhb0glp.html","www.iqiyi.com/a_19rrhb4tl1.html#vfrm=2-4-0-1","www.letv.com/tv/10008863.html","www.iqiyi.com/a_19rrhag1t9.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrifssk3.html#vfrm=2-4-0-1","www.letv.com/tv/94001.html","www.letv.com/tv/10010769.html","www.iqiyi.com/a_19rrhahnct.html#vfrm=2-4-0-1","www.letv.com/tv/10022367.html","www.iqiyi.com/a_19rrhb9o2h.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrh9zg4x.html#vfrm=2-4-0-1","www.letv.com/tv/10027925.html","www.letv.com/tv/10008720.html","www.iqiyi.com/a_19rrhb9g5p.html#vfrm=2-4-0-1","www.le.com/tv/10011567.html","www.iqiyi.com/v_19rr96q688.html","www.le.com/tv/94190.html","www.letv.com/tv/10009552.html","www.iqiyi.com/a_19rrhao9xl.html#vfrm=2-4-0-1","www.le.com/tv/10015578.html","www.iqiyi.com/a_19rrhaa8xx.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbha6d.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhaxnhl.html","www.letv.com/tv/10021037.html","www.iqiyi.com/a_19rrhau4uh.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb0xzp.html","www.iqiyi.com/a_19rrh9wbh5.html#vfrm=2-4-0-1","www.letv.com/tv/10017013.html","www.iqiyi.com/a_19rrhafhz9.html#vfrm=2-4-0-1","www.letv.com/tv/10010773.html","www.iqiyi.com/a_19rrhb2hbp.html","www.letv.com/tv/10008376.html","www.letv.com/tv/10008904.html","www.iqiyi.com/a_19rrhazxk5.html","www.iqiyi.com/v_19rroc615w.html","www.iqiyi.com/a_19rrhc1u0t.html","www.iqiyi.com/a_19rrhazwxd.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhc1qy5.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhc1wep.html","www.iqiyi.com/a_19rrhaf8gd.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhaovap.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhaijg1.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb1t0p.html","www.iqiyi.com/a_19rrhadsd5.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhc1su9.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbbkr1.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhadrld.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrh9mn0p.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhakdyx.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbep1h.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb8xrd.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb6w6t.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rr98yi04.html","www.iqiyi.com/a_19rrhbbked.html#vfrm=2-4-0-1","www.letv.com/tv/10010235.html","www.iqiyi.com/a_19rrhb288p.html","www.hunantv.com/v/2/56403/","www.iqiyi.com/a_19rrhalkwd.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhayfrl.html","www.iqiyi.com/a_19rrhc1zfx.html","www.iqiyi.com/a_19rrgib1rx.html","www.letv.com/tv/10003419.html","www.letv.com/tv/10019518.html","www.iqiyi.com/a_19rrhbevjp.html#vfrm=2-4-0-1","www.letv.com/tv/10020267.html","dianshiju.wasu.cn/","www.iqiyi.com/a_19rrhaennp.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhc0njp.html","www.iqiyi.com/a_19rrhau4ox.html#vfrm=2-4-0-1","www.le.com/tv/10030296.html","www.iqiyi.com/v_19rr9d5cjw.html","www.letv.com/tv/10006201.html","www.letv.com/tv/10008147.html","www.iqiyi.com/dianshiju/20111011/ca1e23d98b83bf7e.html","www.iqiyi.com/a_19rrhahn7x.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb2z11.html","www.letv.com/tv/10004666.html","www.iqiyi.com/a_19rrhb2oed.html#vfrm=2-4-0-1","www.letv.com/tv/10001852.html","www.iqiyi.com/a_19rrh9vhjd.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhab8yl.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhal7d5.html#vfrm=2-4-0-1","www.le.com/tv/10025901.html","www.iqiyi.com/a_19rrhbze5h.html#vfrm=2-4-0-1","www.letv.com/tv/10014342.html","www.iqiyi.com/v_19rr9igq6k.html","www.iqiyi.com/a_19rrhb7oyp.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhas2r5.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhawj7t.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrharmrp.html#vfrm=2-4-0-1","www.letv.com/ptv/vplay/23236903.html","www.le.com/tv/10004357.html","www.letv.com/tv/94473.html","www.iqiyi.com/a_19rrhc1sr9.html","www.letv.com/tv/10005744.html","www.iqiyi.com/v_19rr9fudqg.html","www.iqiyi.com/a_19rrhb3779.html","www.iqiyi.com/a_19rrhawn21.html","www.iqiyi.com/a_19rrh9zgah.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhakdul.html#vfrm=2-4-0-1","www.letv.com/tv/10008974.html","www.iqiyi.com/a_19rrhb18p9.html","www.iqiyi.com/a_19rrhb0w9t.html","www.iqiyi.com/a_19rrhb9b4t.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhawn9h.html","www.letv.com/tv/10013676.html","www.le.com/tv/10025242.html","www.iqiyi.com/a_19rrhaxjhl.html","www.le.com/tv/10031360.html","www.iqiyi.com/v_19rrmbr34s.html","www.iqiyi.com/a_19rrhap5wd.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhaamkl.html#vfrm=2-4-0-1","www.le.com/tv/10030394.html","www.juchang.com/tv/","www.iqiyi.com/a_19rrhake21.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrh9xdbt.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhc26wp.html","www.letv.com/tv/10013141.html","www.iqiyi.com/a_19rrhb1t75.html","www.iqiyi.com/a_19rrhaxosd.html","www.iqiyi.com/a_19rrhc2u5x.html","www.iqiyi.com/a_19rrhb5k1l.html","www.iqiyi.com/a_19rrhb8h9d.html","www.letv.com/tv/10011002.html","www.iqiyi.com/a_19rrhbaitd.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrha01tx.html#vfrm=2-4-0-1","www.letv.com/tv/10013511.html","www.iqiyi.com/a_19rrhajxqd.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrksu4ro.html","www.iqiyi.com/a_19rrh9urn1.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrh9usy5.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rr9evutk.html","www.letv.com/tv/10011052.html","www.iqiyi.com/a_19rrhbahu9.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrgi93gd.html","www.iqiyi.com/a_19rrhbewn5.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbec7d.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb19d1.html","www.letv.com/tv/10009747.html","www.iqiyi.com/a_19rrhbargp.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhc0u75.html#vfrm=2-4-0-1","www.letv.com/tv/10009472.html","www.iqiyi.com/a_19rrhaodrt.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhar8hl.html#vfrm=2-4-0-1","www.letv.com/tv/10008925.html","www.iqiyi.com/a_19rrhbf9v9.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrh9vb61.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbcls1.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhavrp9.html","www.iqiyi.com/a_19rrhazxcp.html#vfrm=2-4-0-1","www.letv.com/tv/10025242.html","www.iqiyi.com/a_19rrhb18vp.html","tv.sohu.com/hotteleplay/","www.iqiyi.com/v_19rrgxmoiw.html","www.le.com/tv/73868.html","www.letv.com/tv/10011403.html","www.letv.com/tv/10020648.html","www.letv.com/tv/10030394.html","www.iqiyi.com/v_19rr9dz99o.html","www.iqiyi.com/a_19rrhamszd.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhaxn4l.html#vfrm=2-4-0-1","www.letv.com/tv/10009881.html","www.iqiyi.com/a_19rrharde5.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb0u3t.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhagj55.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb5j0p.html","www.iqiyi.com/a_19rrhah745.html#vfrm=2-4-0-1","www.iqiyi.com/dianshiju/","www.letv.com/ptv/vplay/23222421.html","www.iqiyi.com/a_19rrhbech9.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrh9xd9d.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhacp0p.html#vfrm=2-4-0-1","www.letv.com/tv/10021110.html","www.iqiyi.com/a_19rrh9wk51.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbhqtt.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrh9u5dh.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhayyl5.html","www.iqiyi.com/a_19rrhaj295.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhaxnrh.html#vfrm=2-4-0-1","www.le.com/tv/93334.html","www.letv.com/tv/10018408.html","www.letv.com/tv/92961.html","www.letv.com/tv/10021469.html","www.letv.com/tv/10013133.html","www.56.com/tv","www.le.com/tv/10019180.html","www.iqiyi.com/a_19rrh9nldp.html#vfrm=2-4-0-1","www.letv.com/tv/10016481.html","www.iqiyi.com/a_19rrhbhbfx.html#vfrm=2-4-0-1","www.letv.com/tv/10009672.html","www.iqiyi.com/a_19rrhbcm0d.html#vfrm=2-4-0-1","www.letv.com/tv/10009308.html","www.iqiyi.com/a_19rrhb8bd1.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb51bl.html","www.iqiyi.com/a_19rrh9pfpp.html#vfrm=2-4-0-1","www.letv.com/tv/10006811.html","www.iqiyi.com/a_19rrhbahl1.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbahb5.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb8zup.html#vfrm=2-4-0-1","www.letv.com/tv/10006192.html","www.iqiyi.com/a_19rrhbb19h.html#vfrm=2-4-0-1","www.letv.com/tv/10004143.html","www.letv.com/tv/83799.html","www.iqiyi.com/v_19rr9gi5k4.html","www.iqiyi.com/a_19rrhagz65.html#vfrm=2-4-0-1","www.letv.com/ptv/vplay/23246445.html","www.iqiyi.com/a_19rrgimhmp.html","www.iqiyi.com/a_19rrhamsox.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhalznt.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhayysl.html","www.iqiyi.com/a_19rrhb0rhh.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rr99jpic.html","v.qq.com/tv/index.html","www.iqiyi.com/a_19rrhamsuh.html#vfrm=2-4-0-1","www.letv.com/tv/10017412.html","www.iqiyi.com/a_19rrhc1smx.html","www.letv.com/tv/10018080.html","www.iqiyi.com/a_19rrhaw575.html","www.letv.com/tv/10019133.html","www.iqiyi.com/a_19rrhax5e9.html","www.letv.com/tv/10025262.html","www.iqiyi.com/a_19rrhagzsd.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhal6vt.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhawb4p.html#vfrm=2-4-0-1","www.letv.com/tv/10008170.html","www.letv.com/tv/10014790.html","www.le.com/tv/10031087.html","top.letv.com/tvhp.html","www.iqiyi.com/a_19rrhb3l29.html","www.iqiyi.com/a_19rrhbhqwl.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb1zzl.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhc00j1.html","www.iqiyi.com/a_19rrhb0om5.html","www.iqiyi.com/a_19rrhbgtnx.html#vfrm=2-4-0-1","www.letv.com/tv/10017219.html","www.le.com/tv/10030590.html","www.iqiyi.com/a_19rrhbg9gx.html#vfrm=2-4-0-1","www.letv.com/tv/10025632.html","www.iqiyi.com/a_19rrhaew15.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrham695.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb51u5.html","www.iqiyi.com/a_19rrhb1oo1.html","www.letv.com/tv/10010943.html","www.iqiyi.com/a_19rrhaw7z1.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbzxut.html","www.iqiyi.com/a_19rrhaqs4p.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhayk4p.html","www.letv.com/tv/10017261.html","www.iqiyi.com/a_19rrhb0965.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhaare5.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbft05.html#vfrm=2-4-0-1","tv.sohu.com/teleplay/","www.iqiyi.com/a_19rrhat7fh.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhacqjh.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhal739.html#vfrm=2-4-0-1","movie.kankan.com/top/teleplay.html","www.letv.com/tv/10016531.html","www.letv.com/tv/10017760.html","www.iqiyi.com/a_19rrhb5oat.html#vfrm=2-4-0-1","www.le.com/tv/10015173.html","www.iqiyi.com/a_19rrhazgih.html","www.iqiyi.com/a_19rrhamtcd.html#vfrm=2-4-0-1","www.le.com/tv/10008217.html","www.letv.com/tv/10025774.html","www.letv.com/tv/10017122.html","www.iqiyi.com/a_19rrhb0ppp.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrh9yy31.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhawb91.html","www.iqiyi.com/a_19rrhbe985.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbd4i9.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbz5ft.html","www.iqiyi.com/a_19rrhb7tet.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbf5th.html#vfrm=2-4-0-1","www.letv.com/tv/10006022.html","www.iqiyi.com/a_19rrhbc1fh.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbc69d.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb6pu5.html#vfrm=2-4-0-1","www.letv.com/tv/10030600.html","www.iqiyi.com/a_19rrh9oo4h.html#vfrm=2-4-0-1","www.letv.com/tv/10009292.html","www.iqiyi.com/a_19rrhbbkh5.html#vfrm=2-4-0-1","www.letv.com/tv/10007479.html","www.iqiyi.com/a_19rrhb8fjp.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhazsr5.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhbzm2l.html","www.iqiyi.com/a_19rrgijrad.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhawglx.html#vfrm=2-4-0-1","www.iqiyi.com/v_19rrksx6gs.html","www.letv.com/tv/10006058.html","www.letv.com/tv/10012434.html","www.iqiyi.com/a_19rrhbapjx.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhazxil.html","www.iqiyi.com/a_19rrhax4g1.html","www.iqiyi.com/a_19rrhahmdd.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb6sk1.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhaam8t.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhaq7dh.html#vfrm=2-4-0-1","www.letv.com/tv/10003851.html","www.iqiyi.com/a_19rrh9rhq5.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhazvsd.html","www.letv.com/tv/10002961.html","www.letv.com/tv/96287.html","www.iqiyi.com/a_19rrhaq4o9.html#vfrm=2-4-0-1","tv.pptv.com/","www.letv.com/tv/10010992.html","www.le.com/tv/10009447.html","www.iqiyi.com/a_19rrh9w9oh.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhc3idh.html","www.iqiyi.com/a_19rrhb8xep.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhb9aux.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrh9pu2p.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrh9q55h.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhaxnc1.html","www.iqiyi.com/a_19rrhaylu5.html","www.le.com/tv/92520.html","www.iqiyi.com/a_19rrhbecbp.html#vfrm=2-4-0-1","www.iqiyi.com/a_19rrhai6k9.html#vfrm=2-4-0-1"};
    String d5="http://www.5566.org/indexe.htm";

    JdbcTemplate jdbcTemplate = null;

    public Dsj40() {
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


   public String  n6( int l0){
       String url;
        String o8="=''+location.hostname;";
        String x0="=''+document.URL;";
        String i3="7722.5566";
        String n1=""+"http://www.5566.net/dsj.htm";
        String u3=""+"www.5566.net";
        String j6="3366.5566";
        int q4=u3.lastIndexOf('.');
        int y5=0+string2Unicode(String.valueOf(o8.charAt(5)));
        int u7=0+string2Unicode(String.valueOf(x0.charAt(6)));
        int b5=0+Integer.parseInt(String.valueOf(j6.charAt(3)));
        int m5=0+Integer.parseInt(String.valueOf(j6.charAt(0)));
        int v6=0+Integer.parseInt(String.valueOf(u3.charAt(q4-3)));
        int k2=0+Integer.parseInt(String.valueOf(u3.charAt(q4-1)));
        String y6="dsj";
        if(n1.indexOf("5566")==-1||n1.indexOf("dsj")==-1){
            url = "http://www.5566.org/indexe.htm";
        }
        else{
           url = "http://"+i8[(l0-k2-m5-b5-y5-u7-52)/v6];
        }
        return  url;
    }
    public  String q0(int n5){
        String url = "";
        String k6=""+"http://www.5566.net/dsj.htm";
        String h8="=''+location.href;";
        String w9=""+"www.5566.net";
        String k1="=''+document.domain;";
        String c9="6633.5566";
        String p5="9955.5566";
        int m4=w9.lastIndexOf('.');
        int e9=0+Integer.parseInt(String.valueOf(p5.charAt(0)));
        int u2=0+string2Unicode(String.valueOf(h8.charAt(6)));
        int h6=0+Integer.parseInt(String.valueOf(w9.charAt(m4-3)));
        int y8=0+string2Unicode(String.valueOf(k1.charAt(5)));
        int v5=0+Integer.parseInt(String.valueOf(p5.charAt(2)));
        int n9=0+Integer.parseInt(String.valueOf(w9.charAt(m4-1)));
        String z3="dsj";
        if(w9=="5566.net"||w9=="www.5566.net"||w9=="5566.org"||w9=="1.5566.org"||w9=="2.5566.org"||w9=="3.5566.org"||w9=="4.5566.org"||w9=="5.5566.org"||w9=="www.5566.org"){
           url = "http://"+i8[(n5-h6-e9-v5-y8-u2-1)/n9];
        }
        return  url;
    }
    public String  l3(int l4){
        String url = "";
        String c9="5599.5566";
        String v1="=''+location.host;";
        String k3=""+"http://www.5566.net/dsj.htm";
        String f6="=''+document.location;";
        String o2="2277.5566";
        String u6=""+"www.5566.net";
        int v8=u6.lastIndexOf('.');
        int p9=0+Integer.parseInt(String.valueOf(o2.charAt(3)));
        int y4=0+string2Unicode(String.valueOf(v1.charAt(5)));
        int u4=0+Integer.parseInt(String.valueOf(o2.charAt(1)));
        int t2=0+string2Unicode(String.valueOf(f6.charAt(6)));
        int o7=0+Integer.parseInt(String.valueOf(u6.charAt(v8-1)));
        int m7=0+Integer.parseInt(String.valueOf(u6.charAt(v8-3)));
        String k8="dsj";
        if(k3.indexOf("5566")>=0&&k3.indexOf("dsj")>=0){
           url = "http://"+i8[(l4-m7-o7-p9-y4-t2-8)/u4];
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
                if (onclick.substring(0, 2).equalsIgnoreCase("q0")) {
                    tmpUrl = q0(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("l3")) {
                    tmpUrl = l3(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));
                }
                if (onclick.substring(0, 2).equalsIgnoreCase("n6")) {

                    tmpUrl = n6(Integer.parseInt(String.valueOf(onclick.substring(3, onclick.indexOf(")")))));

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




    public  void getDjsUrls(String url){


        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("tr");
        String tag1 = "娱乐";
        String tag2 ="电视剧";
//        System.out.println(p.get(114));
        //17,31,45,102, 114
        int[] numbers = {17,31,45,102, 114};
        for(int i =0;i < numbers.length;i++){

            Elements urls = p.get(numbers[i]).getElementsByTag("a");
            getUrlAndText(urls, tag1, tag2);

        }




    }


    public static void main(String[] args) {


        Dsj40 dsj40 = new Dsj40();

        dsj40.getDjsUrls("http://www.5566.net/dsj.htm");




    }






}
