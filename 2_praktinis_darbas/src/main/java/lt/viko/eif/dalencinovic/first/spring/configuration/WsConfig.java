package lt.viko.eif.dalencinovic.first.spring.configuration;

import jakarta.annotation.PostConstruct;
import jakarta.xml.ws.Endpoint;
import lt.viko.eif.dalencinovic.first.spring.service.RestaurantWebServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class responsible for publishing
 * the SOAP Web Service endpoint.
 */
@Configuration
public class WsConfig {

    /**
     * SOAP Web Service implementation instance.
     */
    private final RestaurantWebServiceImpl restaurantWebService;

    /**
     * SOAP endpoint URL loaded from application properties.
     */
    private final String endpointUrl;

    /**
     * Published SOAP endpoint instance.
     */
    private Endpoint endpoint;


    /**
     * Constructs SOAP configuration with required dependencies.
     *
     * @param restaurantWebService SOAP Web Service implementation
     * @param endpointUrl URL used for publishing the SOAP endpoint
     */
    public WsConfig(RestaurantWebServiceImpl restaurantWebService,
            @Value("${restaurant.service.endpoint-url}") String endpointUrl) {
        this.restaurantWebService = restaurantWebService;
        this.endpointUrl = endpointUrl;
    }

    /**
     * Publishes SOAP endpoint after Spring context initialization.
     *
     * <p>
     * The method publishes the SOAP Web Service and prints
     * endpoint information to the console.
     * </p>
     */
    @PostConstruct
    public void publish() {

        endpoint = Endpoint.publish(endpointUrl, restaurantWebService);

        System.out.println();
        System.out.println("=================================");
        System.out.println("Restaurant SOAP service started");
        System.out.println("Endpoint: " + endpointUrl);
        System.out.println("WSDL: " + endpointUrl + "?wsdl");
        System.out.println("=================================");
        System.out.println();
    }
}