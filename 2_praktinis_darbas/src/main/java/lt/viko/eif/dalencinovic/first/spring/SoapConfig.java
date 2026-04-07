package lt.viko.eif.dalencinovic.first.spring;

import jakarta.xml.ws.Endpoint;
import lt.viko.eif.dalencinovic.first.spring.service.RestaurantWebServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoapConfig {
    @Bean
    public Endpoint endpoint(RestaurantWebServiceImpl service) {
        return Endpoint.publish("http://localhost:8090/ws/restaurant", service);
    }
}
