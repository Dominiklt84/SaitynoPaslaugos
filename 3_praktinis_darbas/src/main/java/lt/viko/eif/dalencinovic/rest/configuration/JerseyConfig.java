package lt.viko.eif.dalencinovic.rest.configuration;

import com.fasterxml.jackson.core.util.JacksonFeature;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import jakarta.annotation.PostConstruct;
import lt.viko.eif.dalencinovic.rest.resource.MenuResource;
import lt.viko.eif.dalencinovic.rest.resource.RestaurantResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    @Value("${openapi.url}")
    private String openApiUrl;

    public JerseyConfig() {

        register(RestaurantResource.class);
        register(MenuResource.class);

        register(JacksonFeature.class);
        register(OpenApiResource.class);
    }

    @PostConstruct
    public void printEndpoint() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("OpenAPI: " + openApiUrl);
        System.out.println("=================================");
        System.out.println();
    }
}
