package lt.viko.eif.dalencinovic.first.spring.service;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Utility class responsible for validating XML file against DTD schema.
 */
public class DTDValidator {

    /**
     * Private constructor to prevent instantiation.
     */
    private DTDValidator() {
    }

    /**
     * Validates XML file against DTD defined in DOCTYPE declaration.
     *
     * @param xmlFile XML file to validate
     */
    public static void validate(File xmlFile) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(false);

            DocumentBuilder builder = factory.newDocumentBuilder();

            builder.setErrorHandler(new ErrorHandler() {
                @Override
                public void warning(SAXParseException exception) {
                    System.out.println("DTD Warning: " + exception.getMessage());
                }

                @Override
                public void error(SAXParseException exception) throws SAXException {
                    throw exception;
                }

                @Override
                public void fatalError(SAXParseException exception) throws SAXException {
                    throw exception;
                }
            });

            builder.parse(xmlFile);

            System.out.println("DTD validation successful.");

        } catch (Exception e) {
            throw new RuntimeException("DTD validation failed", e);
        }
    }
}
