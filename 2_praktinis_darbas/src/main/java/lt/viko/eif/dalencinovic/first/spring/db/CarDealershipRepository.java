package lt.viko.eif.dalencinovic.first.spring.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for CarDealership entity.
 * Provides CRUD operations for CarDealership.
 */
@Repository
public interface CarDealershipRepository extends JpaRepository<CarDealership, Long> {
}
