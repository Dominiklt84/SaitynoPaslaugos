package lt.viko.eif.dalencinovic.first.spring;

import lt.viko.eif.dalencinovic.first.spring.model.Car;
import lt.viko.eif.dalencinovic.first.spring.model.CarDealership;
import lt.viko.eif.dalencinovic.first.spring.service.XMLTransformationService;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class XMLTransformationServiceTest {

    @Test
    void testMarshallingAndUnmarshalling() {

        Car car = new Car("Audi", 2021, 55000f, false);
        CarDealership dealership =
                new CarDealership("Test", 2000, 1000000f,  List.of(car));

        XMLTransformationService service = new XMLTransformationService();

        File file = new File("test.xml");

        service.transformToXML(dealership, file);

        CarDealership result =
                service.transformToPOJO(
                        file,
                        new File("src/main/resources/carDealership.xsd"),
                        CarDealership.class
                );

        assertEquals("Test", result.getName());
        assertEquals(1, result.getCars().size());
    }
}