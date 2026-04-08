package lt.viko.eif.dalencinovic.first.spring;

import lt.viko.eif.dalencinovic.first.spring.service.XMLValidator;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for XMLValidator.
 *
 * Validates XML documents against XSD schema
 * and ensures validation errors are properly detected.
 */
public class XMLValidatorTest {
    @Test
    void testValidXmlAgainstXsd() throws Exception {

        URL xmlResource = getClass().getClassLoader().getResource("restaurant.xml");
        URL xsdResource = getClass().getClassLoader().getResource("restaurant.xsd");

        assertNotNull(xmlResource);
        assertNotNull(xsdResource);

        File xmlFile = new File(xmlResource.toURI());
        File xsdFile = new File(xsdResource.toURI());

        XMLValidator validator = new XMLValidator();

        assertDoesNotThrow(() -> validator.validate(xmlFile, xsdFile));
    }
}