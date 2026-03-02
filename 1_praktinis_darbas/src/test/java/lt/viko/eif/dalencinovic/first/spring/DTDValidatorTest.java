package lt.viko.eif.dalencinovic.first.spring;

import lt.viko.eif.dalencinovic.first.spring.service.DTDValidator;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;
public class DTDValidatorTest {
    @Test
    void testValidXmlAgainstDtd() throws Exception {

        URL xmlResource = getClass().getClassLoader().getResource("car_dealership.xml");

        assertNotNull(xmlResource);

        File xmlFile = new File(xmlResource.toURI());

        assertDoesNotThrow(() -> DTDValidator.validate(xmlFile));
    }
}
