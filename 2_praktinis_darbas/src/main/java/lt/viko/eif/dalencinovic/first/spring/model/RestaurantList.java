package lt.viko.eif.dalencinovic.first.spring.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "restaurants")
@XmlAccessorType(XmlAccessType.FIELD)
public class RestaurantList {

    @XmlElement(name = "restaurant")
    private List<Restaurant> restaurants;

    public RestaurantList() {}

    public RestaurantList(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}