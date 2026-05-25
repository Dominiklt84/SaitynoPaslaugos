package lt.viko.eif.dalencinovic.rest;

import lt.viko.eif.dalencinovic.rest.model.MenuItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for MenuResource class.
 *
 * Tests menu item object creation
 * and field updates.
 */
public class MenuResourceTest {

    /**
     * Tests menu item creation
     * using parameterized constructor.
     */
    @Test
    void createMenuItem() {

        MenuItem item = new MenuItem("Pizza", 12.5f, true);

        assertEquals("Pizza", item.getName());
        assertEquals(12.5f, item.getPrice());
        assertTrue(item.isAvailable());
    }

    /**
     * Tests updating menu item availability.
     */
    @Test
    void changeAvailability() {

        MenuItem item = new MenuItem();

        item.setAvailable(false);

        item.setAvailable(true);

        assertTrue(item.isAvailable());
    }
}