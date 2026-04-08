package lt.viko.eif.dalencinovic.first.spring;

import lt.viko.eif.dalencinovic.first.spring.model.BaseEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for BaseEntity class.
 *
 * Verifies basic functionality such as ID handling
 * and inherited behavior for entity classes.
 */
public class BaseEntityTest {
    static class TestEntity extends BaseEntity {}

    @Test
    void testIdGetterAndSetter() {
        TestEntity entity = new TestEntity();
        entity.setId(100L);

        assertEquals(100L, entity.getId());
    }
}
