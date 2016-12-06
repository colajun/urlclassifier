package com.home.mysqldata;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


/**
 * Created by root on 16-4-14.
 */
public class Transfer {
    private String url;

    public void setBody(String body) {
        this.body = body;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String body;
    public  Transfer(String url)
    {
        this.url = url;
    }
    public String getBody()  {

        Document doc = null;
        Elements p = null;
        try {
            doc = Jsoup.connect(url).get();
            p  = doc.getElementsByTag("p");

        } catch (IOException e) {


            return "没有取得文本";
        }
        String tmp =null;
        for(Element p1 : p)
        {
            tmp=tmp+p1.text();

        }
        if(tmp == null){
            return "没有取得文本";
        }
        return tmp.toString().replace("null", "");



    }
}