package io.springak4ra.pali_names_api.controllers;


import io.springak4ra.pali_names_api.PaliName;
import io.springak4ra.pali_names_api.services.PaliNameService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class PaliNameController {

    private PaliNameService paliNameService;

    public PaliNameController(PaliNameService paliNameService) {
        this.paliNameService = paliNameService;
    }

    @GetMapping("/search/exact/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Set<PaliName> getPaliName(@PathVariable String name) {

        return paliNameService.getPaliName(name);
    }

    @GetMapping("/search/contains/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Set<PaliName> getPaliNamesContaining(@PathVariable String name) {

        return paliNameService.getPaliNamesContaining(name);
    }

    @GetMapping("/search/startsWith/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Set<PaliName> getPaliNamesStartingWith(@PathVariable String name) {

        return paliNameService.getPaliNamesStartingWith(name);
    }

    @GetMapping("/search/startsWithLimited/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Set<PaliName> getFirst10PaliNamesStartingWith(@PathVariable String name) {

        return paliNameService.getFirst10PaliNamesStartingWith(name);
    }

    @GetMapping("/search/endsWith/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Set<PaliName> getPaliNamesEndingWith(@PathVariable String name) {

        return paliNameService.getPaliNamesEndingWith(name);
    }
}
