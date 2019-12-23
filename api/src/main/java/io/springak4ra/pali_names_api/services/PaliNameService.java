package io.springak4ra.pali_names_api.services;

import io.springak4ra.pali_names_api.PaliName;

import java.util.List;
import java.util.Set;

public interface PaliNameService {

    Set<PaliName> getPaliName(String name);

    Set<PaliName> getPaliNamesContaining(String name);

    Set<PaliName> getPaliNamesStartingWith(String name);

    Set<PaliName> getFirst10PaliNamesStartingWith(String name);

    Set<PaliName> getPaliNamesEndingWith(String name);
}
