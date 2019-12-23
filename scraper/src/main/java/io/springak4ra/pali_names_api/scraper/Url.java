package io.springak4ra.pali_names_api.scraper;

public class Url {

    private final String rootUrl = "http://www.palikanon.com/english/pali_names/";
    private String letterUrl;
    private String pageUrl;

    public Url(String letterUrl, String pageUrl) {
        this.letterUrl = letterUrl;
        this.pageUrl = pageUrl;
    }

    public String getLetterUrl() {
        return letterUrl;
    }

    public void setLetterUrl(String letterUrl) {
        this.letterUrl = letterUrl;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getRootUrl() {
        return rootUrl;
    }

    @Override
    public String toString() {
        return "Url{" +
                "letterUrl='" + letterUrl + '\'' +
                ", pageUrl='" + pageUrl + '\'' +
                '}';
    }
}
