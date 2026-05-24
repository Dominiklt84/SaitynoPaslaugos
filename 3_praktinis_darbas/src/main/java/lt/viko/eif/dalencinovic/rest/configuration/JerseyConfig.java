package lt.viko.eif.dalencinovic.rest.configuration;

import com.fasterxml.jackson.core.util.JacksonFeature;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import lt.viko.eif.dalencinovic.rest.resource.MenuResource;
import lt.viko.eif.dalencinovic.rest.resource.RestaurantResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        register(RestaurantResource.class);
        register(MenuResource.class);
        register(JacksonFeature.class);
        register(OpenApiResource.class);
    }
}
