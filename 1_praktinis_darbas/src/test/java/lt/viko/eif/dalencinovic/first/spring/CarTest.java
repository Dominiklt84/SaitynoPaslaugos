package lt.viko.eif.dalencinovic.first.spring;

import lt.viko.eif.dalencinovic.first.spring.model.Car;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for Car model.
 */
class CarTest {

    @Test
    void testCarConstructorAndGetters() {

        Car car = new Car("Tesla", 2023, 45000f, true);

        assertEquals("Tesla", car.getModel());
        assertEquals(2023, car.getYear());
        assertEquals(45000f, car.getPrice());
        assertTrue(car.isElectric());
    }

    @Test
    void testSetters() {

        Car car = new Car();

        car.setModel("Audi");
        car.setYear(2020);
        car.setPrice(38000f);
        car.setElectric(false);

        assertEquals("Audi", car.getModel());
        assertEquals(2020, car.getYear());
        assertEquals(38000f, car.getPrice());
        assertFalse(car.isElectric());
    }
}