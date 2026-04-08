package lt.viko.eif.dalencinovic.first.spring;

import lt.viko.eif.dalencinovic.first.spring.model.MenuItem;
import lt.viko.eif.dalencinovic.first.spring.model.Restaurant;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Restaurant entity.
 *
 * Verifies field assignments, relationships with MenuItem,
 * and data integrity.
 */
class RestaurantTest {

    @Test
    void testRestaurantCreation() {
        MenuItem item = new MenuItem("Pizza", 10.5f, true);

        Restaurant restaurant = new Restaurant("Test", "Vilnius", true, 4.5f, List.of(item));

        assertEquals("Test", restaurant.getName());
        assertEquals("Vilnius", restaurant.getLocation());
        assertTrue(restaurant.isOpen());
        assertEquals(4.5f, restaurant.getRating());
        assertEquals(1, restaurant.getMenu().size());
    }
}