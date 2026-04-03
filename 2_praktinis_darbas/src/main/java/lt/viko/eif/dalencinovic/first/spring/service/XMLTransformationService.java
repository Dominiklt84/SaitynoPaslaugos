package lt.viko.eif.dalencinovic.first.spring.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lt.viko.eif.dalencinovic.first.spring.model.RestaurantList;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.stereotype.Service;

import javax.xml.XMLConstants;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;
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
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass(), RestaurantList.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();
            marshaller.marshal(object, writer);

            String xmlContent = writer.toString();

            String finalXml = xmlContent.replaceFirst("<\\?xml[^>]*>", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<!DOCTYPE carDealership SYSTEM \"restaurant.dtd\">");
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

            return clazz.cast(unmarshaller.unmarshal(xmlFile));
        }catch (Exception e){
            throw new RuntimeException("XML to POJO transformation failed", e);
        }
    }

    public void transformToHTML(File xml, File xsl, File output){
        try {
            TransformerFactory factory =TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsl));

            transformer.transform(new StreamSource(xml),new StreamResult(output));
            System.out.println("HTML generated");
        }catch (Exception e){
            throw new RuntimeException("HTML transform failed",e);
        }
    }

    public void transformToPDF(File xml, File xsl, File pdf){
        try {
            FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
            OutputStream out = new FileOutputStream(pdf);

            FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

            Fop fop=fopFactory.newFop(MimeConstants.MIME_PDF,foUserAgent, out);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer=factory.newTransformer(new StreamSource(xsl));

            Source src=new StreamSource(xml);
            Result res = new SAXResult(fop.getDefaultHandler());

            transformer.transform(src,res);

            out.close();

            System.out.println("PDF generated");

        }catch (Exception e){
            throw new RuntimeException("PDF transform failed",e);
        }
    }
}
