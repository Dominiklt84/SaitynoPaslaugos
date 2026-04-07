package lt.viko.eif.dalencinovic.first.spring.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name="restaurant")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="restaurant")
public class Restaurant extends BaseEntity{
    @XmlElement(required = true)
    private String name;
    @XmlElement
    private String location;
    @XmlElement
    private boolean open;
    @XmlElement
    private float rating;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id")
    @XmlElementWrapper(name = "menu")
    @XmlElement(name="item")
    private List<MenuItem> menu;

    public Restaurant() {
    }

    public Restaurant(String name, String location, boolean open, float rating, List<MenuItem> menu) {
        this.name = name;
        this.location = location;
        this.open = open;
        this.rating = rating;
        this.menu = menu;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

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
