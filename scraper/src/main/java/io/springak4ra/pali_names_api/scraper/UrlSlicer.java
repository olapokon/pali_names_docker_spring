package io.springak4ra.pali_names_api.scraper;

import org.springframework.stereotype.Component;

@Component
public class UrlSlicer {

    public Url sliceUrl(String url) {

        Integer index = url.indexOf("/");
        return new Url(url.substring(0, index + 1), url.substring(index + 1));
    }
}
