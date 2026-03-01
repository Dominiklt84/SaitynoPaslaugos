package lt.viko.eif.dalencinovic.first.spring.db;

import lt.viko.eif.dalencinovic.first.spring.model.CarDealership;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for CarDealership entity.
 */
public interface CarDealershipRepository extends JpaRepository<CarDealership,Integer> {
}
