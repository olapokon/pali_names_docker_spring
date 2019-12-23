package io.springak4ra.pali_names_api;

import io.springak4ra.pali_names_api.PaliName;
import io.springak4ra.pali_names_api.PaliNameRepository;
import io.springak4ra.pali_names_api.scraper.Scraper;
import io.springak4ra.pali_names_api.scraper.Url;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ScraperRunner implements CommandLineRunner {

    private final PaliNameRepository paliNameRepository;
    private Scraper scraper;

    @Autowired
    public ScraperRunner(PaliNameRepository paliNameRepository, Scraper scraper) {

        this.paliNameRepository = paliNameRepository;
        this.scraper = scraper;
    }

    // scrape site contents into th h2 database
    @Override
    public void run(String... args) throws Exception {

        List<Url> pages = scraper.getPages();
        for (Url page: pages) {
            log.info("getting HTML for " + page.toString());

            List<PaliName> onePageNames = scraper.getHTML(page);
            paliNameRepository.saveAll(onePageNames);
        }
    }}
