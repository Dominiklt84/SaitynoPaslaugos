package lt.viko.eif.dalencinovic.first.spring.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

@Service
public class XMLTransformationService {

    public void transformToXML(Object object, File file){
        try {
            JAXBContext jaxbContext=JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(object, file);
            marshaller.marshal(object, System.out);
        }catch (Exception e){
            throw new RuntimeException("POJO to XML failed", e);
        }
    }

    public <T> T transformToPOJO(File xmlFile, File xsdFile, Class<T> clazz){
        try {
            JAXBContext jaxbContext=JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();

            SchemaFactory schemaFactory= SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(xsdFile);
            unmarshaller.setSchema(schema);

            return clazz.cast(unmarshaller.unmarshal(xmlFile));
        }catch (Exception e){
            throw new RuntimeException("XML to POJO failed", e);
        }
    }

}
