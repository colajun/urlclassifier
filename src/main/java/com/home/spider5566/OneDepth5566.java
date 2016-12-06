package com.home.spider5566;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

/**
 * Created by hadoop on 16-11-4.
 */
public class OneDepth5566 {

    static Document doc;
    static  String url;
    static  byte[] data;
    static int counter =0;
    static Charset charset;
    static Path file;
    public static void main(String[] args) throws IOException {
        try {
             doc = Jsoup.connect("http://www.5566.net/head.htm").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements p = doc.getElementsByTag("a");


        for(Element tmpp :p ){

            file = Paths.get("/home/hadoop/bigdata/workspace/urlclassifier/src/main/java/com/home/spider5566/5566urls");
           charset = Charset.forName("UTF-8");

            try(OutputStream out = new BufferedOutputStream(Files.newOutputStream(file,CREATE, APPEND))) {


//                out.write(("http://www.5566.net/"+tmpp.attr("href")+"\r\n").getBytes("utf-8"));
               if(!tmpp.attr("href").contains("main.htm")){
                   url = "http://www.5566.net/"+tmpp.attr("href")+"\r\n";
                   data = url.getBytes();
                   out.write(data, 0, data.length);
                   counter++;
               }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        System.out.println("url的总的类别为:"+counter);




    }



}
