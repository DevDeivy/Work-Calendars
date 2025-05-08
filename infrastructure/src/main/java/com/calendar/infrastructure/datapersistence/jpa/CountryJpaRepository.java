package infrastructure.src.main.java.com.calendar.infrastructure.datapersistence.jpa;

import infrastructure.src.main.java.com.calendar.infrastructure.entities.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryJpaRepository extends JpaRepository<CountryEntity, Long> {
}