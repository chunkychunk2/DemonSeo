package main.java.com.company;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GetLinks {
    private final ArrayList<String> lines = new ArrayList<>();

    public boolean notYetVisited(String link) {
        return !lines.contains(link);
    }

    public void  linksParser(String site, int max, String result) throws IOException {
        Document doc = Jsoup.connect(site).get();
        Elements links = doc.select("a[href]");
        for (Element link : links) {
            String absLink = link.attr("abs:href");
            if (absLink.contains(site) && notYetVisited(absLink)) {
                lines.add(absLink);
            }
        }
        ArrayList<String> lines2 = new ArrayList<>();
        for (int j = 0; j < max-1; j++) {
            for (String line : lines) {
                try {
                    Document doc2 = Jsoup.connect(line).get();
                    Elements links2 = doc2.select("a[href]");
                    for (Element link : links2) {
                        String absLink = link.attr("abs:href");

                        if (absLink.contains(site) && notYetVisited(absLink)) {
                            lines2.add(absLink);
                        }
                    }
                } catch (HttpStatusException e) {
                    lines2.add("404 " + line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            lines.addAll(lines2);
        }
        Set<String> set = new HashSet<>(lines);
        lines.clear();
        lines.addAll(set);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(result))){ // "/Users/user/Desktop/DemonSeo/src/main/java/result"
            for (String l:lines) writer.write(l + "\n");} catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Готово!");
    }
}
