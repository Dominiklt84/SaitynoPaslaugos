package lt.viko.eif.dalencinovic.rest;

import lt.viko.eif.dalencinovic.rest.model.BaseEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link BaseEntity} class.
 *
 * Tests ID field setter and getter methods.
 */
public class BaseEntityTest {

    static class TestEntity extends BaseEntity {}

    /**
     * Tests if entity ID is correctly set and returned.
     */
    @Test
    void testIdGetterAndSetter() {

        TestEntity entity = new TestEntity();
        entity.setId(100L);

        assertEquals(100L, entity.getId());
    }
}