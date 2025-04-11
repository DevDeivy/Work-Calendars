package com.repositories;

import com.model.Country;

import java.util.List;
import java.util.Optional;

@Repos
public interface CountryRepository extends JpaRepository<Country, Long> {

    Country save(Country country);

    Optional<Country> findById(Long id);

    List<Country> findAll();

    Country update(Country country);

    void deleteById(Long id);

    boolean existsById(Long id);
}