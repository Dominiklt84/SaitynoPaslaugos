package lt.viko.eif.dalencinovic.first.spring;

import lt.viko.eif.dalencinovic.first.spring.model.Restaurant;
import lt.viko.eif.dalencinovic.first.spring.model.RestaurantList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for RestaurantList wrapper class.
 *
 * Ensures correct handling of restaurant collections
 * and proper XML mapping behavior.
 */
class RestaurantListTest {

    @Test
    void testList() {
        Restaurant r = new Restaurant();
        r.setName("Test");

        RestaurantList list = new RestaurantList(List.of(r));

        assertEquals(1, list.getRestaurants().size());
    }
}