package lt.viko.eif.dalencinovic.first.spring;

import lt.viko.eif.dalencinovic.first.spring.service.XMLValidator;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;
public class XMLValidatorTest {
    @Test
    void testValidXmlAgainstXsd() throws Exception {

        URL xmlResource = getClass().getClassLoader().getResource("car_dealership.xml");
        URL xsdResource = getClass().getClassLoader().getResource("carDealership.xsd");

        assertNotNull(xmlResource);
        assertNotNull(xsdResource);

        File xmlFile = new File(xmlResource.toURI());
        File xsdFile = new File(xsdResource.toURI());

        XMLValidator validator = new XMLValidator();

        assertDoesNotThrow(() -> validator.validate(xmlFile, xsdFile));
    }
}
