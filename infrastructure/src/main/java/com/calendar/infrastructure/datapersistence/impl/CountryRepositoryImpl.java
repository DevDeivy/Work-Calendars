package infrastructure.src.main.java.com.calendar.infrastructure.datapersistence.impl;


import domain.src.main.java.com.calendar.domain.models.Country;
import domain.src.main.java.com.calendar.domain.repositories.CountryRepository;
import infrastructure.src.main.java.com.calendar.infrastructure.datapersistence.jpa.CountryJpaRepository;
import infrastructure.src.main.java.com.calendar.infrastructure.datapersistence.mapper.DomainEntityMapper;
import infrastructure.src.main.java.com.calendar.infrastructure.entities.CountryEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public abstract class CountryRepositoryImpl implements CountryRepository {

    private final CountryJpaRepository jpaRepository;

    public CountryRepositoryImpl(CountryJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public Country save(Country country) {
        CountryEntity entity = DomainEntityMapper.toEntity(country);
        CountryEntity saved = jpaRepository.save(entity);
        return DomainEntityMapper.toDomain(saved);
    }

    public Optional<Country> findById(Long id) {
        return jpaRepository.findById(id)
                .map(DomainEntityMapper::toDomain);
    }

    public List<Country> findAll() {
        return jpaRepository.findAll().stream()
                .map(DomainEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    public Country update(Country country) {
        CountryEntity entity = DomainEntityMapper.toEntity(country);
        CountryEntity updated = jpaRepository.save(entity);
        return DomainEntityMapper.toDomain(updated);
    }

    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

}
