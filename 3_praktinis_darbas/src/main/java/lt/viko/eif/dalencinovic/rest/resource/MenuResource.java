package lt.viko.eif.dalencinovic.rest.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lt.viko.eif.dalencinovic.rest.db.RestaurantRepository;
import lt.viko.eif.dalencinovic.rest.model.MenuItem;
import lt.viko.eif.dalencinovic.rest.model.Restaurant;
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

    @GET
    public List<MenuItem> getAllMenuItems() {

        return restaurantRepository.findAll().stream().flatMap(restaurant -> restaurant
                .getMenu().stream()).toList();
    }

    @GET
    @Path("/{restaurantId}")
    public List<MenuItem> getMenu(@PathParam("restaurantId") Long restaurantId) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);

        if (restaurant == null) {

            return null;
        }

        return restaurant.getMenu();
    }

    @GET
    @Path("/{restaurantId}/available")
    public List<MenuItem> getAvailableItems(@PathParam("restaurantId") Long restaurantId) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);

        if (restaurant == null) {

            return null;
        }

        return restaurant.getMenu().stream().filter(MenuItem::isAvailable).toList();
    }

    @GET
    @Path("/search")
    public List<MenuItem> searchMenuItems(@DefaultValue("0") @QueryParam("price") float price) {

        return restaurantRepository.findAll().stream().flatMap(r -> r.getMenu().stream())
                .filter(item -> item.getPrice() >= price).toList();
    }

    @POST
    @Path("/{restaurantId}")
    public MenuItem addMenuItem(@PathParam("restaurantId") Long restaurantId, MenuItem menuItem) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);

        if (restaurant == null) {

            return null;
        }

        restaurant.getMenu().add(menuItem);

        restaurantRepository.save(restaurant);

        return menuItem;
    }

    @PUT
    @Path("/{restaurantId}/{menuItemId}")
    public MenuItem updateMenuItem(@PathParam("restaurantId") Long restaurantId,
                                   @PathParam("menuItemId") Long menuItemId, MenuItem updatedItem) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);

        if (restaurant == null) {

            return null;
        }

        MenuItem menuItem = restaurant.getMenu().stream().filter(item ->
                item.getId().equals(menuItemId)).findFirst().orElse(null);

        if (menuItem == null) {

            return null;
        }

        menuItem.setName(updatedItem.getName());
        menuItem.setPrice(updatedItem.getPrice());
        menuItem.setAvailable(updatedItem.isAvailable());

        restaurantRepository.save(restaurant);

        return menuItem;
    }

    @DELETE
    @Path("/{restaurantId}/{menuItemId}")
    public String deleteMenuItem(@PathParam("restaurantId") Long restaurantId,
                                 @PathParam("menuItemId") Long menuItemId) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);

        if (restaurant == null) {

            return "Restaurant not found";
        }

        boolean removed = restaurant.getMenu().removeIf(item -> item.getId().equals(menuItemId));

        if (!removed) {

            return "Menu item not found";
        }

        restaurantRepository.save(restaurant);

        return "Menu item deleted";
    }
}