package com.home.mysqldata;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by root on 16-4-14.
 */
public class Analyzer1 {
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private String body;
    public Analyzer1(String bodyss)
    {

        this.body = bodyss;

    }
    public  String endAnalyzer() throws IOException {

        Analyzer analyzer = new IKAnalyzer(false);
        StringReader reader = new StringReader(body);
        TokenStream ts = analyzer.tokenStream("", reader);
        CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
        String tmp =null;
        ts.reset();
        while (ts.incrementToken())
        {

            tmp=tmp+(term.toString()+" ");



        }


        analyzer.close();
        reader.close();
        if(tmp== null){
            return "没有取得文本";
        }
        return "10,"+tmp.toString().replace("null", "");


    }




}