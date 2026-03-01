package lt.viko.eif.dalencinovic.first.spring;

import lt.viko.eif.dalencinovic.first.spring.model.Car;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    void testCarCreation() {
        Car car = new Car("Tesla", 2023, 45000f, true);

        assertEquals("Tesla", car.getModel());
        assertEquals(2023, car.getYear());
        assertEquals(45000f, car.getPrice());
        assertTrue(car.isElectric());
    }
}