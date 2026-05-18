package lt.viko.eif.dalencinovic.rest.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.List;

/**
 * Represents a restaurant entity in the system.
 *
 * This class is used as JPA entity for database persistence
 * and JAXB model for XML serialization/deserialization
 *
 * A restaurant contains general information such as name,
 * location, status, rating, and a list of menu items.
 */
@XmlRootElement(name="restaurant")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="restaurant")
public class Restaurant extends BaseEntity{

    /**
     * Name of the restaurant.
     */
    @XmlElement(required = true)
    private String name;

    /**
     * Location of the restaurant.
     */
    @XmlElement
    private String location;

    /**
     * Indicates whether the restaurant is open.
     */
    @XmlElement
    private boolean open;

    /**
     * Rating of the restaurant.
     */
    @XmlElement
    private float rating;

    /**
     * List of menu items available in the restaurant.
     */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id")
    @XmlElementWrapper(name = "menu")
    @XmlElement(name="item")
    private List<MenuItem> menu;

    /**
     * Default constructor required by JPA and JAXB.
     */
    public Restaurant() {
    }

    /**
     * Constructs a restaurant with all attributes.
     *
     * @param name     restaurant name
     * @param location restaurant location
     * @param open     open/closed status
     * @param rating   restaurant rating
     * @param menu     list of menu items
     */
    public Restaurant(String name, String location, boolean open, float rating, List<MenuItem> menu) {
        this.name = name;
        this.location = location;
        this.open = open;
        this.rating = rating;
        this.menu = menu;
    }

    /**
     * @return restaurant location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location restaurant location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return restaurant name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name restaurant name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return true if restaurant is open
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * @param open open/closed status
     */
    public void setOpen(boolean open) {
        this.open = open;
    }

    /**
     * @return restaurant rating
     */
    public float getRating() {
        return rating;
    }

    /**
     * @param rating restaurant rating
     */
    public void setRating(float rating) {
        this.rating = rating;
    }

    /**
     * @return list of menu items
     */
    public List<MenuItem> getMenu() {
        return menu;
    }

    /**
     * @param menu list of menu items
     */
    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

    /**
     * Returns formatted string representation of the restaurant.
     */
    @Override
    public String toString() {
        return "\nRestaurant:" +
                "\n\tname=" + name +
                "\n\tlocation=" + location +
                "\n\topen=" + open +
                "\n\trating=" + rating +
                "\n\tmenu=" + menu;
    }
}
