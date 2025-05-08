package infrastructure.src.main.java.com.calendar.infrastructure.datapersistence.jpa;

import infrastructure.src.main.java.com.calendar.infrastructure.entities.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeJpaRepository extends JpaRepository<TypeEntity, Long> {
    boolean existsByName(String name);
}
