package lt.viko.eif.dalencinovic.rest;

import lt.viko.eif.dalencinovic.rest.model.MenuItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link MenuItem} class.
 *
 * Tests object creation, field updates,
 * and string representation.
 */
public class MenuItemTest {

    /**
     * Tests menu item object creation
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
     * Tests updating menu item fields
     * using setter methods.
     */
    @Test
    void updateMenuItemFields() {

        MenuItem item = new MenuItem();

        item.setName("Burger");
        item.setPrice(8.5f);
        item.setAvailable(false);

        assertEquals("Burger", item.getName());
        assertEquals(8.5f, item.getPrice());
        assertFalse(item.isAvailable());
    }

    /**
     * Tests string representation
     * returned by toString() method.
     */
    @Test
    void returnToString() {

        MenuItem item = new MenuItem("Pizza", 10.0f, true);

        String result = item.toString();

        assertTrue(result.contains("Pizza"));
        assertTrue(result.contains("10.0"));
    }
}