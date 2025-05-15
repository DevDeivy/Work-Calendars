package com.calendar.infrastructure.datapersistence.impl;

import com.calendar.domain.models.Type;
import com.calendar.domain.repositories.TypeRepository;
import com.calendar.infrastructure.datapersistence.jpa.TypeJpaRepository;
import com.calendar.infrastructure.datapersistence.mapper.DomainEntityMapper;
import com.calendar.infrastructure.entities.TypeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public abstract class TypeRepositoryImpl implements TypeRepository {

    private final TypeJpaRepository jpaRepository;

    public TypeRepositoryImpl(TypeJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Type save(Type type) {
        TypeEntity entity = DomainEntityMapper.toEntity(type);
        TypeEntity saved = jpaRepository.save(entity);
        return DomainEntityMapper.toDomain(saved);
    }

    public Optional<Type> findById(Long id) {
        return jpaRepository.findById(id).map(DomainEntityMapper::toDomain);
    }

    public List<Type> findAll() {
        return jpaRepository.findAll().stream()
                .map(DomainEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    public Type update(Type type) {
        TypeEntity entity = DomainEntityMapper.toEntity(type);
        TypeEntity updated = jpaRepository.save(entity);
        return DomainEntityMapper.toDomain(updated);
    }

    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    public boolean existsByName(String name) {
        return jpaRepository.existsByName(name);
    }

    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }
}
