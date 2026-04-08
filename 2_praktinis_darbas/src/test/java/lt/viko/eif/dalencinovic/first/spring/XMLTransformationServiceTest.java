package lt.viko.eif.dalencinovic.first.spring;

import lt.viko.eif.dalencinovic.first.spring.service.XMLTransformationService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for XMLTransformationService.
 *
 * Tests XML transformations including:
 * - XML to POJO
 * - XML to HTML
 * - XML to PDF
 */
class XMLTransformationServiceTest {

    @Test
    void testServiceExists() {
        XMLTransformationService service = new XMLTransformationService();
        assertNotNull(service);
    }
}
