package com.calendar.infrastructure.datapersistence.impl;

import com.calendar.domain.models.Holiday;
import com.calendar.domain.repositories.HolidayRepository;
import com.calendar.infrastructure.datapersistence.jpa.HolidayJpaRepository;
import com.calendar.infrastructure.datapersistence.mapper.DomainEntityMapper;
import com.calendar.infrastructure.entities.HolidayEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public abstract class HolidayRepositoryImpl implements HolidayRepository {

    private final HolidayJpaRepository jpaRepository;

    public HolidayRepositoryImpl(HolidayJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public Holiday save(Holiday holiday) {
        HolidayEntity entity = DomainEntityMapper.toEntity(holiday);
        HolidayEntity saved = jpaRepository.save(entity);
        return DomainEntityMapper.toDomain(saved);
    }

    public Optional<Holiday> findById(Long id) {
        return jpaRepository.findById(id).map(DomainEntityMapper::toDomain);
    }

    public List<Holiday> findAll() {
        return jpaRepository.findAll().stream()
                .map(DomainEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    public Holiday update(Holiday holiday) {
        HolidayEntity entity = DomainEntityMapper.toEntity(holiday);
        HolidayEntity updated = jpaRepository.save(entity);
        return DomainEntityMapper.toDomain(updated);
    }

    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    public boolean existsByName(String name) {
        return jpaRepository.existsByName(name);
    }
}
