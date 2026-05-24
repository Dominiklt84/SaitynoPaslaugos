package lt.viko.eif.dalencinovic.rest.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Context;

import lt.viko.eif.dalencinovic.rest.db.RestaurantRepository;
import lt.viko.eif.dalencinovic.rest.model.Restaurant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/restaurants")
@Produces({
        MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML
})
@Consumes(MediaType.APPLICATION_JSON)
public class RestaurantResource {

    private static final Logger logger =
            LoggerFactory.getLogger(RestaurantResource.class);

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GET
    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    @GET
    @Path("/{id}")
    public Restaurant getRestaurantById(
            @PathParam("id") Long id) {

        return restaurantRepository.findById(id)
                .orElse(null);
    }

    @POST
    public Restaurant addRestaurant(Restaurant restaurant) {

        return restaurantRepository.save(restaurant);
    }

    @PUT
    @Path("/{id}")
    public Restaurant updateRestaurant(
            @PathParam("id") Long id,
            Restaurant updatedRestaurant) {

        Restaurant restaurant =
                restaurantRepository.findById(id)
                        .orElse(null);

        if (restaurant == null) {
            return null;
        }

        restaurant.setName(updatedRestaurant.getName());
        restaurant.setLocation(updatedRestaurant.getLocation());
        restaurant.setOpen(updatedRestaurant.isOpen());
        restaurant.setRating(updatedRestaurant.getRating());
        restaurant.setMenu(updatedRestaurant.getMenu());

        return restaurantRepository.save(restaurant);
    }

    @DELETE
    @Path("/{id}")
    public String deleteRestaurant(
            @PathParam("id") Long id) {

        Restaurant restaurant =
                restaurantRepository.findById(id)
                        .orElse(null);

        if (restaurant == null) {
            return "Restaurant not found";
        }

        restaurantRepository.delete(restaurant);

        return "Restaurant deleted";
    }

    @GET
    @Path("/search")
    public List<Restaurant> searchRestaurants(
            @DefaultValue("0")
            @QueryParam("rating") float rating) {

        return restaurantRepository.findAll()
                .stream()
                .filter(r -> r.getRating() >= rating)
                .toList();
    }

    @GET
    @Path("/header")
    public String getHeader(
            @HeaderParam("client-name") String clientName) {

        return "Client name: " + clientName;
    }

    @GET
    @Path("/cookie")
    public String getCookie(
            @CookieParam("sessionId") String sessionId) {

        return "Session ID: " + sessionId;
    }

    @GET
    @Path("/headers")
    public String getAllHeaders(@Context HttpHeaders headers){

        for (String header : headers.getRequestHeaders().keySet()) {

            System.out.println(header + " -> "
                    + headers.getRequestHeaders().get(header));
        }

        return "Headers printed in console";
    }
}