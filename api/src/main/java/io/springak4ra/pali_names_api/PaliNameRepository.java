package io.springak4ra.pali_names_api;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PaliNameRepository extends CrudRepository<PaliName, Integer> {

    Set<PaliName> findByPaliNameIgnoreCase(String paliName);

    Set<PaliName> findByPaliNameIgnoreCaseContaining(String paliName);

    Set<PaliName> findByPaliNameIgnoreCaseStartingWith(String paliName);

    Set<PaliName> findFirst10ByPaliNameIgnoreCaseStartingWith(String paliName);

    Set<PaliName> findByPaliNameIgnoreCaseEndingWith(String paliName);
}
