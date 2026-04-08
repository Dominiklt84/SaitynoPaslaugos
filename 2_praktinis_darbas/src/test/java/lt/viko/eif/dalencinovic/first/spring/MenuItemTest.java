package lt.viko.eif.dalencinovic.first.spring;

import lt.viko.eif.dalencinovic.first.spring.model.MenuItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for MenuItem entity.
 *
 * Validates getters, setters, and object state consistency.
 */
class MenuItemTest {

    @Test
    void testMenuItem() {
        MenuItem item = new MenuItem("Burger", 5.99f, true);

        assertEquals("Burger", item.getName());
        assertEquals(5.99f, item.getPrice());
        assertTrue(item.isAvailable());
    }
}