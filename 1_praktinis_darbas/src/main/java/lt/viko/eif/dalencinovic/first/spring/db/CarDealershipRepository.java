package lt.viko.eif.dalencinovic.first.spring.db;

import lt.viko.eif.dalencinovic.first.spring.model.CarDealership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDealershipRepository extends JpaRepository<CarDealership,Long> {
}
