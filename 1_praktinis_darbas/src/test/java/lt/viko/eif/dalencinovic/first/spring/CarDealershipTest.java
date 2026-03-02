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

        assertEquals("AutoPlius", dealership.getName());
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

    @Test
    void testSetters() {

        CarDealership dealership = new CarDealership();

        dealership.setName("TestName");
        dealership.setEstablishedYear(2010);
        dealership.setTotalIncome(1500000f);
        dealership.setCars(List.of());

        assertEquals("TestName", dealership.getName());
        assertEquals(2010, dealership.getEstablishedYear());
        assertEquals(1500000f, dealership.getTotalIncome(), 0.001f);
        assertNotNull(dealership.getCars());
    }

    @Test
    void testIdFromBaseEntity() {

        CarDealership dealership = new CarDealership();
        dealership.setId(10L);

        assertEquals(10L, dealership.getId());
    }
}