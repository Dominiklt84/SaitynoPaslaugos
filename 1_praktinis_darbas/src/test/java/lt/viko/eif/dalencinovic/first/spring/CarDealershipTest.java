package lt.viko.eif.dalencinovic.first.spring;

import lt.viko.eif.dalencinovic.first.spring.model.Car;
import lt.viko.eif.dalencinovic.first.spring.model.CarDealership;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarDealershipTest {

    @Test
    void testDealershipCreation() {
        Car car = new Car("BMW", 2022, 60000f, false);

        CarDealership dealership =
                new CarDealership("AutoLux", 2008, 2000000f,  List.of(car));

        assertEquals("AutoLux", dealership.getName());
        assertEquals(1, dealership.getCars().size());
    }
}