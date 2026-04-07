package lt.viko.eif.dalencinovic.first.spring.model;

import jakarta.xml.bind.annotation.*;

import java.util.List;

/**
 * Wrapper class representing a collection of restaurants.
 *
 * This class is used for XML serialization/deserialization JAXB,
 * allowing multiple {@link Restaurant} objects to be grouped
 * under a single root element.
 */
@XmlRootElement(name = "restaurants")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"restaurants"})
public class RestaurantList {

    /**
     * List of restaurant objects.
     */
    @XmlElement(name = "restaurant")
    private List<Restaurant> restaurants;

    /**
     * Default constructor required by JAXB.
     */
    public RestaurantList() {}

    /**
     * Constructs a wrapper with a list of restaurants.
     *
     * @param restaurants list of restaurant entities
     */
    public RestaurantList(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    /**
     * @return list of restaurants
     */
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    /**
     * @param restaurants list of restaurants
     */
    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}