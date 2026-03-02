package lt.viko.eif.dalencinovic.first.spring.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import java.io.File;

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

            java.io.StringWriter writer = new java.io.StringWriter();
            marshaller.marshal(object, writer);

            String xmlContent = writer.toString();

            String finalXml =
                    xmlContent.replaceFirst(
                            "<\\?xml[^>]*>",
                            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                                    "<!DOCTYPE carDealership SYSTEM \"carDealership.dtd\">"
                    );
            java.nio.file.Files.write(file.toPath(), finalXml.getBytes());

            System.out.println("\n===== GENERATED XML =====");
            System.out.println(finalXml);
            System.out.println("===== END OF XML =====\n");

            System.out.println("XML successfully generated.");
        }catch (Exception e){
            throw new RuntimeException("POJO to XML transformation failed", e);
        }
    }

    /**
     * Transforms XML file to POJO object and validates against XSD schema.
     *
     * @param xmlFile XML file
     * @param xsdFile XSD schema file
     * @param clazz target class
     * @return transformed POJO object
     */
    public <T> T transformToPOJO(File xmlFile, File xsdFile, Class<T> clazz){
        try {
            JAXBContext jaxbContext=JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();

            // XSD validation
            javax.xml.validation.SchemaFactory schemaFactory =
                    javax.xml.validation.SchemaFactory.newInstance(
                            javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI
                    );

            javax.xml.validation.Schema schema =
                    schemaFactory.newSchema(xsdFile);

            unmarshaller.setSchema(schema);

            // Create SAX parser that ignores DTD
            javax.xml.parsers.SAXParserFactory spf =
                    javax.xml.parsers.SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);
            spf.setValidating(false);

            javax.xml.parsers.SAXParser saxParser = spf.newSAXParser();

            org.xml.sax.XMLReader xmlReader = saxParser.getXMLReader();

            xmlReader.setFeature(
                    "http://apache.org/xml/features/nonvalidating/load-external-dtd",
                    false
            );

            org.xml.sax.InputSource inputSource =
                    new org.xml.sax.InputSource(new java.io.FileInputStream(xmlFile));

            javax.xml.transform.sax.SAXSource source =
                    new javax.xml.transform.sax.SAXSource(xmlReader, inputSource);

            return clazz.cast(unmarshaller.unmarshal(source));
        }catch (Exception e){
            throw new RuntimeException("XML to POJO transformation failed", e);
        }
    }

}
