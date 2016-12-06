package com.home.spring;

import org.springframework.jdbc.core.JdbcTemplate;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoop on 16-10-31.
 */
public class TextSplitWOrds {

    JdbcTemplate jdbcTemplate = null;
    HashMap<String, String> map = new HashMap<>();

    public TextSplitWOrds(){
        try {
            jdbcTemplate = JDBCHelper.createMysqlTemplate("mysql1", "jdbc:mysql://192.168.20.50/url?useUnicode=true&characterEncoding=utf8", "root", "root", 5, 30);

            jdbcTemplate.execute("create table if not EXISTS  tb_parser2("
                    +"id int(11) not null auto_increment PRIMARY KEY ,"
                    +"category varchar(255),"+
                    "url varchar(255),"+
                    "text LONGTEXT"+
                    ") ENGINE=MyISAM DEFAULT  CHARSET=utf8;");
            System.out.println("成功创建数据表tb_parser2");

        } catch (Exception e) {
            jdbcTemplate = null;
            System.out.println("mysql未开启或JDBCHelper.createMysqlTemplate中的参数不正确!");
            e.printStackTrace();
        }

        map.put("音乐", "1");map.put("聊天", "2");map.put("游戏", "3");map.put("明星", "4");map.put("交友", "5");map.put("笑话", "6");
        map.put("动漫", "7");map.put("星座", "8");map.put("小说", "9");map.put("体育", "10");map.put("NBA", "11");map.put("足球", "12");
        map.put("网友", "13");map.put("图片", "14");map.put("影视", "15");map.put("视频", "16");map.put("小游戏", "17");map.put("美女", "18");
        map.put("汽车", "19");map.put("手机", "20");map.put("亲子", "21");map.put("健康", "22");map.put("女性", "23");map.put("酷站", "24");
        map.put("宠物", "25");map.put("购物", "26");map.put("时尚", "27");map.put("美食", "28");map.put("旅游", "29");map.put("天气", "30");
        map.put("股票", "31");map.put("基金", "32");map.put("银行", "33");map.put("彩票", "34");map.put("招聘", "35");map.put("房产", "36");
        map.put("团购", "37");map.put("电影", "38");map.put("新闻", "39");map.put("军事", "40");map.put("美图", "41");map.put("社区", "42");
        map.put("网游", "43");map.put("微博", "44");map.put("两性", "45");map.put("地图", "46");map.put("生活", "47");map.put("电视", "48");
        map.put("保险", "49");map.put("儿童", "50");map.put("大学", "51");map.put("英语", "52");map.put("男人", "53");map.put("母婴", "54");
        map.put("家具", "55");map.put("邮箱", "56");map.put("博客", "57");map.put("电脑", "58");map.put("硬件", "59");map.put("桌面", "60");
        map.put("曲艺", "61");map.put("摄影", "62");map.put("数码", "63");map.put("考试", "64");map.put("教育", "65");map.put("政府", "66");
        map.put("法律", "67");map.put("IT", "68");map.put("爱好", "69");map.put("杀毒", "70");map.put("行业", "71");map.put("国外", "72");
        map.put("公益", "73");map.put("科技", "74");map.put("文库", "75");map.put("留学", "76");map.put("宗教", "77");map.put("北京", "78");
        map.put("上海", "79");



    }

    public  String getText(String textmysql) throws IOException,NullPointerException {
        String text = textmysql;
        String  returnValue=null;

//        IKAnalyzer analyzer = new IKAnalyzer(true);
//        StringReader reader = new StringReader(text);
//
//        try {
//            TokenStream ts = analyzer.tokenStream("", reader);
//            CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
//            while (ts.incrementToken()){
//                returnValue+=term.toString()+" ";
//            }
//            analyzer.close();
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        StringReader re = new StringReader(text);
        IKSegmenter ik = new IKSegmenter(re, true);
        Lexeme lex = null;

            while ((lex=ik.next()) != null) {
                returnValue += (lex.getLexemeText() + " ");
            }
            if(returnValue == null){
                return "空指针异常";
            }
            else {
                return  returnValue.replace("null", "");
            }



    }

    public  void inserTable(String category, String url, String text){
        if(jdbcTemplate != null){
            int updates = jdbcTemplate.update("INSERT  INTO  tb_parser2"+
            "(category, url, text) VALUE (?, ?, ?)",
                    category, url, text
            );

            if(updates == 1){
                System.out.println("mysql插入成功");
            }

        }

    }
    public  int getAllcount(){

         return  jdbcTemplate.queryForObject("select count(*) from tb_6655", Integer.class);
    }

    public void getListIterator(int start, int end) throws IOException {




        List rows = jdbcTemplate.queryForList("select url, tag2, title, meta, body  from tb_6655 where id >=? and id <= ?", start, end);
        Iterator it = rows.iterator();
        while (it.hasNext()){
            Map fenxi = (Map)it.next();
            String category = fenxi.get("tag2").toString();
            String url = fenxi.get("url").toString();
            String text = getText(fenxi.get("title").toString()+fenxi.get("meta")+fenxi.get("body"));

            if(text != "空指针异常"){
                inserTable(category, url, map.get(category)+","+text);
            }

//            System.out.println(map.get(category)+","+text);
        }

    }


    public static void main(String[] args) throws IOException {

        TextSplitWOrds textSplitWOrds = new TextSplitWOrds();
        int count = textSplitWOrds.getAllcount();
        int cx = (count /501) +1;
        int countcx=0;
        int start = 0;
        int end = 500;
        while (countcx < cx){

            textSplitWOrds.getListIterator(start, end);
            start += 501;
            end += 501;
            countcx += 1;

        }







    }






}
