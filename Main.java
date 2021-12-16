package main.java.com.company;

import java.io.*;
import java.util.*;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Сайт");
        String site = reader.readLine();
        
        System.out.println("Уровень вложения:");
        int max = Integer.parseInt(reader.readLine());
        
        System.out.println("Укажите путь, куда сохранить результат:");
        String result = reader.readLine();
        reader.close();
        
        GetLinks gl = new GetLinks();
        gl.linksParser(site, max, result);





//        System.out.println(document);

//        String title = document.title();
//        String h1 = document.body().getElementsByTag("h1").text();
//        String description = document.head().getElementsByTag("description").text();
//
//        System.out.println(title);
//        System.out.println(h1);
//        System.out.println(description);

//        Elements h1 = document.select("h1");
//        Elements titleElem = document.select("head > title");
//        Elements descElem = document.select("meta");
//        String [] meta = descElem.toString().split("\n");
//        for (String description: meta){
//            if (description.startsWith("<meta name=\"description\"")) System.out.println(description);
//        }
//        System.out.println(h1);
//        System.out.println(titleElem);


        //  System.out.println(descElem);
//
//        String HTMLSTring = "<!DOCTYPE html>"
//                + "<html>"
//                + "<head>"
//                + "<title>Новый мировой стандарт освещения | ЦЕНТРСВЕТ</title>"
//                + "</head>"
//                + "<body>"
//                + "<table><tr><td><h1>HelloWorld</h1></tr>"
//                + "</table>"
//                + "</body>"
//                + "</html>";
//
//        Document newHtml = Jsoup.parse(HTMLSTring);
//
//        title = newHtml.title();
//        h1 = newHtml.body().getElementsByTag("h1").text();
//
//        System.out.println(title);
//        System.out.println(h1);
//       System.out.println(description);


    }

}
