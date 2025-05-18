package com.calendar.api.controllers;

import com.calendar.application.services.CountryService;
import com.calendar.infrastructure.entities.CountryEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    public ResponseEntity<CountryEntity> create(@RequestBody CountryEntity country) {
        return ResponseEntity.ok(countryService.createCountry(country));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryEntity> getById(@PathVariable Long id) {
        return countryService.getCountryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CountryEntity>> getAll() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryEntity> update(@PathVariable Long id, @RequestBody CountryEntity country) {
        country.setId(id);
        return ResponseEntity.ok(countryService.updateCountry(country));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        countryService.deleteCountry(id);
        return ResponseEntity.noContent().build();
    }
}
