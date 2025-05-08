package domain.src.main.java.com.calendar.domain.repositories;

import domain.src.main.java.com.calendar.domain.models.Country;

import java.util.List;
import java.util.Optional;

public interface CountryRepository {

    Country save(Country country);

    Optional<Country> findById(Long id);

    List<Country> findAll();

    Country update(Country country);

    void deleteById(Long id);

    boolean existsByName(String name);

    boolean existsById(Long id);
}