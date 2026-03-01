package lt.viko.eif.dalencinovic.first.spring;

import lt.viko.eif.dalencinovic.first.spring.model.Car;
import lt.viko.eif.dalencinovic.first.spring.model.CarDealership;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for CarDealership model.
 */
class CarDealershipTest {

    @Test
    void testDealershipCreation() {

        Car car = new Car("BMW", 2022, 60000f, false);

        CarDealership dealership =
                new CarDealership("AutoLux", 2008, 2000000f, List.of(car));

        assertEquals("AutoLux", dealership.getName());
        assertEquals(2008, dealership.getEstablishedYear());
        assertEquals(2000000f, dealership.getTotalIncome());
        assertNotNull(dealership.getCars());
        assertEquals(1, dealership.getCars().size());

        Car storedCar = dealership.getCars().get(0);
        assertEquals("BMW", storedCar.getModel());
        assertEquals(2022, storedCar.getYear());
        assertEquals(60000f, storedCar.getPrice());
        assertFalse(storedCar.isElectric());
    }
}