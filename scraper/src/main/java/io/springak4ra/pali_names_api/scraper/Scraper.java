package io.springak4ra.pali_names_api.scraper;

import io.springak4ra.pali_names_api.PaliName;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class Scraper {

    private final String mainPageUrl = "http://www.palikanon.com/english/pali_names/dic_idx.html";

    private UrlBuilder urlBuilder;
    private UrlSlicer urlSlicer;

    @Autowired
    public Scraper(UrlBuilder urlBuilder, UrlSlicer urlSlicer) {
        this.urlBuilder = urlBuilder;
        this.urlSlicer = urlSlicer;
    }

    public List<Url> getPages() {
        Document document = null;
        try {
            document = Jsoup.connect(mainPageUrl).get();
        } catch (IOException e) {
            log.error("scraping failed at getPages for " + mainPageUrl);
            e.printStackTrace();
        }

        List<Url> letterUrls = new ArrayList<>();

        document.select("b a").forEach(el -> {
            Url newUrl = urlSlicer.sliceUrl(el.attr("href"));
            letterUrls.add(newUrl);
        });

//        System.out.println(letterUrls);

        List<Url> allUrls = new ArrayList<>();

        for (Url letterUrl: letterUrls) {
            allUrls.add(letterUrl);

            String currentUrl = urlBuilder.getUrl(letterUrl.getLetterUrl(), letterUrl.getPageUrl());

            try {
                document = Jsoup.connect(currentUrl).get();
            } catch (IOException e) {
                log.error("scraping failed at " + currentUrl);
                e.printStackTrace();
            }

            document.select("td").select("a").forEach(el -> {
                allUrls.add(new Url(letterUrl.getLetterUrl(), el.attr("href")));
            });
        }

        return  allUrls;
    }

    public List<PaliName> getHTML(Url url) {
        List<PaliName> namesArray = new ArrayList<>();
        Document document = null;
        try {
            document = Jsoup.connect(urlBuilder.getUrl(url.getLetterUrl(), url.getPageUrl())).get();
        } catch (IOException e) {
            log.error("scraping failed at getHTML for " + url.toString());
            e.printStackTrace();
        }

        document.select("li b").forEach(el -> {

            if (!el.text().trim().isEmpty()) {

                String link = urlBuilder.getUrl(url.getLetterUrl(), url.getPageUrl());

                if (el.select("a").size() > 0 && el.select("a").hasAttr("href")) {

                    link = el.select("a").attr("href");

                    if (link.substring(0, 1).equals(".")) {
                        link = url.getRootUrl() + link.substring(3);
                    } else if (url.getPageUrl().equals("../maha/maha.htm")) {
                        link = url.getRootUrl() + "maha/" + link;
                    } else {
                        link = url.getRootUrl() + url.getLetterUrl() + link;
                    }
                }

                PaliName paliName = new PaliName();
                paliName.setPaliName(el.text().trim());
                paliName.setLink(link);
                namesArray.add(paliName);
            }

        });

        return namesArray;
    }
}
