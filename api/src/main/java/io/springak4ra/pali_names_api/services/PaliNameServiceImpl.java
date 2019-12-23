package io.springak4ra.pali_names_api.services;

import io.springak4ra.pali_names_api.PaliName;
import io.springak4ra.pali_names_api.PaliNameRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaliNameServiceImpl implements PaliNameService {

    private final PaliNameRepository paliNameRepository;

    public PaliNameServiceImpl(PaliNameRepository nameRepository) {
        this.paliNameRepository = nameRepository;
    }

    @Override
    public Set<PaliName> getPaliName(String name) {

        Set<PaliName> result = paliNameRepository.findByPaliNameIgnoreCase(name);
        return result;
    }

    @Override
    public Set<PaliName> getPaliNamesContaining(String name) {

        Set<PaliName> results = paliNameRepository.findByPaliNameIgnoreCaseContaining(name);
        return results;
    }

    @Override
    public Set<PaliName> getPaliNamesStartingWith(String name) {

        Set<PaliName> results = paliNameRepository.findByPaliNameIgnoreCaseStartingWith(name);
        return results;
    }

    @Override
    public Set<PaliName> getFirst10PaliNamesStartingWith(String name) {

        Set<PaliName> results = paliNameRepository.findFirst10ByPaliNameIgnoreCaseStartingWith(name);
        return results;
    }

    @Override
    public Set<PaliName> getPaliNamesEndingWith(String name) {

        Set<PaliName> results = paliNameRepository.findByPaliNameIgnoreCaseEndingWith(name);
        return results;
    }
}
