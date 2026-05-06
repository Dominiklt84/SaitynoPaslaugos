package lt.viko.eif.dalencinovic.first.spring.soap;

import jakarta.xml.bind.annotation.XmlRootElement;

import lt.viko.eif.dalencinovic.first.spring.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * SOAP response object containing all restaurants.
 * Used for transferring restaurant data through SOAP Web Service.
 */
@XmlRootElement
public class GetAllRestaurantsResponse {

    /**
     * List of restaurants returned by the SOAP service.
     */
    private List<Restaurant> restaurants = new ArrayList<>();

    /**
     * Returns all restaurants.
     *
     * @return list of restaurants
     */
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    /**
     * Sets restaurant list.
     *
     * @param restaurants list of restaurants
     */
    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}