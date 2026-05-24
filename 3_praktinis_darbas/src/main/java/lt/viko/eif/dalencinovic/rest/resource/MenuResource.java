package lt.viko.eif.dalencinovic.rest.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import lt.viko.eif.dalencinovic.rest.db.RestaurantRepository;
import lt.viko.eif.dalencinovic.rest.model.MenuItem;
import lt.viko.eif.dalencinovic.rest.model.Restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/menu")
@Produces({
        MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML
})
@Consumes(MediaType.APPLICATION_JSON)
public class MenuResource {

    @Autowired
    private RestaurantRepository restaurantRepository;

    private static final Logger logger =
            LoggerFactory.getLogger(MenuResource.class);

    @GET
    public List<MenuItem> getAllMenuItems() {

        return restaurantRepository.findAll()
                .stream()
                .flatMap(restaurant ->
                        restaurant.getMenu().stream())
                .toList();
    }

    @GET
    @Path("/{restaurantId}")
    public List<MenuItem> getMenu(
            @PathParam("restaurantId") Long restaurantId) {

        Restaurant restaurant =
                restaurantRepository.findById(restaurantId)
                        .orElse(null);

        if (restaurant == null) {
            return null;
        }

        return restaurant.getMenu();
    }

    @GET
    @Path("/{restaurantId}/available")
    public List<MenuItem> getAvailableItems(
            @PathParam("restaurantId") Long restaurantId) {

        Restaurant restaurant =
                restaurantRepository.findById(restaurantId)
                        .orElse(null);

        if (restaurant == null) {
            return null;
        }

        return restaurant.getMenu()
                .stream()
                .filter(MenuItem::isAvailable)
                .toList();
    }
}