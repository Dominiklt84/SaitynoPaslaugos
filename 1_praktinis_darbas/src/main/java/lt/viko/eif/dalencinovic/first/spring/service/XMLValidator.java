package lt.viko.eif.dalencinovic.first.spring.service;

import org.springframework.stereotype.Service;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

/**
 * Service responsible for validating XML files against XSD schema.
 */
@Service
public class XMLValidator {

    /**
     * Validates XML file against provided XSD schema.
     *
     * @param xml XML file to validate
     * @param xsd XSD schema file
     */
    public void validate(File xml, File xsd) {
        try {
            var schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            var schema = schemaFactory.newSchema(xsd);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            System.out.println("XSD validation successful. ");
        }catch (Exception e){
            throw new RuntimeException("XSD validation failed", e);
        }


    }
}
