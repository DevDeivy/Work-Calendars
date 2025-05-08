package infrastructure.src.main.java.com.calendar.infrastructure.datapersistence.jpa;

import infrastructure.src.main.java.com.calendar.infrastructure.entities.HolidayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayJpaRepository extends JpaRepository<HolidayEntity, Long> {
    boolean existsByName(String name);
}
