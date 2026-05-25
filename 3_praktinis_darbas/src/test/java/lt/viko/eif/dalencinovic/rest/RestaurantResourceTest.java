package lt.viko.eif.dalencinovic.rest;

import lt.viko.eif.dalencinovic.rest.model.MenuItem;
import lt.viko.eif.dalencinovic.rest.model.Restaurant;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for RestaurantResource class.
 *
 * Tests restaurant object creation
 * and field updates.
 */
public class RestaurantResourceTest {

    /**
     * Tests restaurant creation
     * using parameterized constructor.
     */
    @Test
    void createRestaurant() {

        Restaurant restaurant = new Restaurant("Food Place", "Vilnius", true, 4.5f,
                new ArrayList<>());

        assertEquals("Food Place", restaurant.getName());
        assertEquals("Vilnius", restaurant.getLocation());
        assertTrue(restaurant.isOpen());
        assertEquals(4.5f, restaurant.getRating());
    }

    /**
     * Tests updating restaurant name.
     */
    @Test
    void updateRestaurantName() {

        Restaurant restaurant = new Restaurant();

        restaurant.setName("Old Name");

        restaurant.setName("New Name");

        assertEquals("New Name", restaurant.getName());
    }

    /**
     * Tests adding menu item
     * to restaurant menu list.
     */
    @Test
    void addMenuItemToRestaurant() {

        Restaurant restaurant = new Restaurant();

        restaurant.setMenu(new ArrayList<>());

        MenuItem item = new MenuItem("Burger", 9.5f, true);

        restaurant.getMenu().add(item);

        assertEquals(1, restaurant.getMenu().size());
    }
}
