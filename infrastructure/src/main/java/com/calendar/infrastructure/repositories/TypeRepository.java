package com.calendar.infrastructure.repositories;

import com.calendar.infrastructure.entities.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<TypeEntity, Long> {
    boolean existsByName(String name);
}
