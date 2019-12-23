package io.springak4ra.pali_names_api.scraper;

import org.springframework.stereotype.Component;

@Component
public class UrlBuilder {

    private final String rootUrl = "http://www.palikanon.com/english/pali_names/";
//    private static StringBuffer stringBuffer =
//            new StringBuffer("http://www.palikanon.com/english/pali_names/");

    public String getUrl(String letterUrl, String pageUrl) {
//        stringBuffer.append(letterUrl).append(pageUrl);
//        return String.valueOf(stringBuffer);

        return rootUrl + letterUrl + pageUrl;
    }
}
