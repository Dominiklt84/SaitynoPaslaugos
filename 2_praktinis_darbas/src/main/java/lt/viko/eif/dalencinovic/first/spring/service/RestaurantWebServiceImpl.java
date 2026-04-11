package lt.viko.eif.dalencinovic.first.spring.service;

import lt.viko.eif.dalencinovic.first.spring.db.RestaurantRepository;
import lt.viko.eif.dalencinovic.first.spring.model.MenuItem;
import lt.viko.eif.dalencinovic.first.spring.model.Restaurant;

import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of Restaurant SOAP Web Service.
 * Uses database repository to retrieve restaurant data.
 */
@Service
@WebService(endpointInterface = "lt.viko.eif.dalencinovic.first.spring.service.RestaurantWebService")
public class RestaurantWebServiceImpl implements RestaurantWebService{

    /**
     * Repository for accessing restaurant data from database.
     */
    @Autowired
    private RestaurantRepository restaurantRepository;

    /**
     * Retrieves restaurant from database.
     */
    @Override
    public Restaurant getRestaurant(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves menu from database.
     */
    @Override
    public List<MenuItem> getMenu(Long restaurantId) {
        Restaurant restaurant=getRestaurant(restaurantId);
        return restaurant!=null ? restaurant.getMenu():null;
    }

    /**
     * Retrieves all restaurants from the database.
     */
    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
