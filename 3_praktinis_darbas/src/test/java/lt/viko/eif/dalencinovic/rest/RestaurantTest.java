package lt.viko.eif.dalencinovic.rest;

import lt.viko.eif.dalencinovic.rest.model.MenuItem;
import lt.viko.eif.dalencinovic.rest.model.Restaurant;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link Restaurant} class.
 *
 * Tests restaurant creation, field updates,
 * and string representation.
 */
public class RestaurantTest {

    /**
     * Tests restaurant object creation
     * with menu items.
     */
    @Test
    void createRestaurant() {

        List<MenuItem> menu = new ArrayList<>();

        menu.add(new MenuItem("Pizza", 12.5f, true));

        Restaurant restaurant = new Restaurant("Food Place", "Vilnius", true, 4.8f,
                menu);

        assertEquals("Food Place", restaurant.getName());

        assertEquals("Vilnius", restaurant.getLocation());

        assertTrue(restaurant.isOpen());

        assertEquals(4.8f, restaurant.getRating());

        assertEquals(1, restaurant.getMenu().size());
    }

    /**
     * Tests updating restaurant fields
     * using setter methods.
     */
    @Test
    void updateRestaurantFields() {

        Restaurant restaurant = new Restaurant();

        restaurant.setName("Burger House");
        restaurant.setLocation("Kaunas");
        restaurant.setOpen(false);
        restaurant.setRating(4.2f);

        assertEquals("Burger House", restaurant.getName());

        assertEquals("Kaunas", restaurant.getLocation());

        assertFalse(restaurant.isOpen());

        assertEquals(4.2f, restaurant.getRating());
    }

    /**
     * Tests string representation
     * returned by toString() method.
     */
    @Test
    void returnToString() {

        Restaurant restaurant = new Restaurant();

        restaurant.setName("Food Place");

        String result = restaurant.toString();

        assertTrue(result.contains("Food Place"));
    }
}