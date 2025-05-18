package com.calendar.application.services;


import com.calendar.infrastructure.repositories.CountryRepository;
import com.calendar.infrastructure.entities.CountryEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public CountryEntity createCountry(CountryEntity country) {
        return countryRepository.save(country);
    }

    public Optional<CountryEntity> getCountryById(Long id) {
        return countryRepository.findById(id);
    }

    public List<CountryEntity> getAllCountries() {
        return countryRepository.findAll();
    }

    public CountryEntity updateCountry(CountryEntity country) {
        if (countryRepository.existsById(country.getId())) {
            return countryRepository.save(country);
        } else {
            throw new IllegalArgumentException("Country not found");
        }
    }

    public void deleteCountry(Long id) {
        if (countryRepository.existsById(id)) {
            countryRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Country not found");
        }
    }

    public boolean existsById(Long id) {
        return countryRepository.existsById(id);
    }
}