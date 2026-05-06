package lt.viko.eif.dalencinovic.first.spring.soap;

import jakarta.xml.bind.annotation.XmlRootElement;

import lt.viko.eif.dalencinovic.first.spring.model.Restaurant;

/**
 * SOAP response object containing restaurant information.
 * Used for transferring a single restaurant through SOAP Web Service.
 */
@XmlRootElement
public class GetRestaurantResponse {

    /**
     * Restaurant returned by the SOAP service.
     */
    private Restaurant restaurant;

    /**
     * Returns restaurant information.
     *
     * @return restaurant object
     */
    public Restaurant getRestaurant() {
        return restaurant;
    }

    /**
     * Sets restaurant information.
     *
     * @param restaurant restaurant object
     */
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}