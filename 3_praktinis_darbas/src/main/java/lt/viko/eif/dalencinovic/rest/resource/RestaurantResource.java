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

    private static final Logger logger = LoggerFactory.getLogger(RestaurantResource.class);

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GET
    public List<Restaurant> getRestaurants() {

        logger.debug("Fetching all restaurants");

        return restaurantRepository.findAll();
    }

    @GET
    @Path("/{id}")
    public Restaurant getRestaurantById(@PathParam("id") Long id) {

        logger.debug("Path parameter: id: " + id);

        return restaurantRepository.findById(id).orElse(null);
    }

    @POST
    public Restaurant addRestaurant(Restaurant restaurant) {

        logger.debug("Adding restaurant: " + restaurant.getName());

        return restaurantRepository.save(restaurant);
    }

    @PUT
    @Path("/{id}")
    public Restaurant updateRestaurant(@PathParam("id") Long id, Restaurant updatedRestaurant) {

        logger.debug("Updating restaurant with id: " + id);

        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

        if (restaurant == null) {

            logger.error("Restaurant not found with id: " + id);

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
    public String deleteRestaurant(@PathParam("id") Long id) {

        logger.debug("Deleting restaurant with id: " + id);
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

        if (restaurant == null) {

            logger.error("Restaurant not found with id: " + id);

            return "Restaurant not found";
        }

        restaurantRepository.delete(restaurant);

        return "Restaurant deleted";
    }

    @GET
    @Path("/search")
    public List<Restaurant> searchRestaurants(@DefaultValue("0") @QueryParam("rating") float rating) {

        logger.debug("Query parameter: rating = " + rating);

        return restaurantRepository.findAll().stream().filter(r -> r.getRating() >= rating).toList();
    }

    @GET
    @Path("/owner")
    public String getRestaurantOwner(@HeaderParam("Restaurant-Owner") String ownerName) {

        logger.debug("Header parameter: Restaurant-Owner = " + ownerName);

        return "Restaurant owner: " + ownerName;
    }

    @GET
    @Path("/headers")
    public String getAllHeaders(@Context HttpHeaders headers){

        for (String header : headers.getRequestHeaders().keySet()) {

            System.out.printf("This header was set: %-20s %50s\n",
                    header, headers.getRequestHeaders().get(header));
        }

        return " ";
    }

    @POST
    @Path("/form")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String addRestaurantForm(@FormParam("name") String name, @FormParam("location") String location,
            @FormParam("rating") float rating) {

        logger.debug("Form parameters: name: "+name+", location: "+location+", rating: "+rating);

        Restaurant restaurant = new Restaurant();

        restaurant.setName(name);
        restaurant.setLocation(location);
        restaurant.setRating(rating);
        restaurant.setOpen(true);

        restaurantRepository.save(restaurant);

        return "Restaurant added successfully";
    }

    @GET
    @Path("/matrix/{name}")
    public List<Restaurant> getRestaurantInfo(@PathParam("name") String name, @MatrixParam("city") String city,
                                              @MatrixParam("rating") float rating) {

        logger.debug("Matrix parameters: city: "+city+", rating: "+rating);

        return restaurantRepository.findAll().stream()
                .filter(r -> r.getName().equalsIgnoreCase(name))
                .filter(r -> r.getLocation().equalsIgnoreCase(city))
                .filter(r -> r.getRating() >= rating)
                .toList();
    }
}