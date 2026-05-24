package lt.viko.eif.dalencinovic.rest.configuration;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class responsible for REST service startup information.
 *
 * Prints endpoint and WADL information after application startup.
 */
@Configuration
public class RestConfig {

    /**
     * REST endpoint URL loaded from application properties.
     */
    @Value("${restaurant.service.endpoint-url}")
    private String endpointUrl;

    /**
     * Prints REST service information after startup.
     */
    @PostConstruct
    public void publish() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("Restaurant REST service started");
        System.out.println("Endpoint: " + endpointUrl);
        System.out.println("WADL: " + endpointUrl + "/application.wadl");
        System.out.println("=================================");
        System.out.println();

    }
}