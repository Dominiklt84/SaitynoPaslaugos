package lt.viko.eif.dalencinovic.first.spring;

import lt.viko.eif.dalencinovic.first.spring.model.Car;
import lt.viko.eif.dalencinovic.first.spring.model.CarDealership;
import lt.viko.eif.dalencinovic.first.spring.service.XMLTransformationService;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for XMLTransformationService.
 */
class XMLTransformationServiceTest {

    @Test
    void testMarshallingAndUnmarshalling() throws Exception {

        Car car = new Car("Audi", 2021, 55000f, false);
        car.setId(1L);
        CarDealership dealership =
                new CarDealership("Test", 2000, 1000000f, List.of(car));
        dealership.setId(10L);

        XMLTransformationService service = new XMLTransformationService();

        File tempFile = File.createTempFile("test", ".xml");
        tempFile.deleteOnExit();
        service.transformToXML(dealership, tempFile);

        // Load XSD
        URL resource = getClass().getClassLoader()
                .getResource("carDealership.xsd");

        assertNotNull(resource);

        File xsdFile = new File(resource.toURI());

        // Unmarshal
        CarDealership result =
                service.transformToPOJO(tempFile, xsdFile, CarDealership.class);

        // Assertions
        assertEquals("Test", result.getName());
        assertEquals(2000, result.getEstablishedYear());
        assertEquals(1000000f, result.getTotalIncome());

        assertNotNull(result.getCars());
        assertEquals(1, result.getCars().size());

        Car resultCar = result.getCars().get(0);
        assertEquals("Audi", resultCar.getModel());
        assertEquals(2021, resultCar.getYear());
        assertEquals(55000f, resultCar.getPrice());
        assertFalse(resultCar.isElectric());

        tempFile.delete();
    }
}