package com.calendar.infrastructure.repositories;

import com.calendar.infrastructure.entities.HolidayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends JpaRepository<HolidayEntity, Long> {
    boolean existsByName(String name);
}
