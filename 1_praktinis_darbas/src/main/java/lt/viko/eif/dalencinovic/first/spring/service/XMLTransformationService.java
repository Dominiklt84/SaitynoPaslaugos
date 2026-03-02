package lt.viko.eif.dalencinovic.first.spring.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.nio.file.Files;

/**
 * Service responsible for transforming POJO objects to XML
 * and transforming XML back to POJO using JAXB.
 */
@Service
public class XMLTransformationService {

    /**
     * Transforms POJO object to XML file.
     *
     * @param object object to transform
     * @param file output XML file
     */
    public void transformToXML(Object object, File file){
        try {
            JAXBContext jaxbContext=JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();
            marshaller.marshal(object, writer);

            String xmlContent = writer.toString();

            String finalXml = xmlContent.replaceFirst("<\\?xml[^>]*>", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<!DOCTYPE carDealership SYSTEM \"carDealership.dtd\">");
            Files.write(file.toPath(), finalXml.getBytes());

            System.out.println("\n===== GENERATED XML =====");
            System.out.println(finalXml);
            System.out.println("===== END OF XML =====\n");

            System.out.println("XML successfully generated.");
        }catch (Exception e){
            throw new RuntimeException("POJO to XML transformation failed", e);
        }
    }

    /**
     * Transforms XML file to POJO object and validates it against XSD schema.
     *
     * @param xmlFile XML file
     * @param xsdFile XSD schema file
     * @param clazz   target class
     * @param <T>     type of returned object
     * @return transformed POJO object
     */
    public <T> T transformToPOJO(File xmlFile, File xsdFile, Class<T> clazz){
        try {
            JAXBContext jaxbContext=JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            Schema schema = schemaFactory.newSchema(new StreamSource(xsdFile));
            unmarshaller.setSchema(schema);

            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);
            spf.setValidating(false);

            SAXParser saxParser = spf.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();

            xmlReader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

            InputSource inputSource = new InputSource(new FileInputStream(xmlFile));

            SAXSource source = new SAXSource(xmlReader, inputSource);

            return clazz.cast(unmarshaller.unmarshal(source));
        }catch (Exception e){
            throw new RuntimeException("XML to POJO transformation failed", e);
        }
    }

}
