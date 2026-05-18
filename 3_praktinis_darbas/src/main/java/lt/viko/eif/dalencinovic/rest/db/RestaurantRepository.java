package lt.viko.eif.dalencinovic.rest.db;

import lt.viko.eif.dalencinovic.rest.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Restaurant entity.
 * Provides CRUD operations for Restaurant.
 */
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
}
