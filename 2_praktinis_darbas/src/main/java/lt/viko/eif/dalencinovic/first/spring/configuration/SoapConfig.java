package lt.viko.eif.dalencinovic.first.spring.configuration;

import jakarta.xml.ws.Endpoint;
import lt.viko.eif.dalencinovic.first.spring.service.RestaurantWebServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for SOAP web service.
 *
 * This class publishes a SOAP endpoint using JAX-WS.
 * The web service becomes accessible at the specified URL.
 */
@Configuration
public class SoapConfig {

    /**
     * Publishes the SOAP web service endpoint.
     *
     * @param service implementation of the web service
     * @return published endpoint instance
     */
    @Bean
    public Endpoint endpoint(RestaurantWebServiceImpl service) {
        return Endpoint.publish("http://localhost:8090/ws/restaurant", service);
    }
}
