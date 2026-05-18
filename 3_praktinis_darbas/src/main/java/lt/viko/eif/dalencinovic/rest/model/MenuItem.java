package lt.viko.eif.dalencinovic.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Represents a menu item entity in the system.
 *
 * This class is used both as a JPA entity and as an XML
 * element for JAXB serialization/deserialization.
 *
 * Each menu item belongs to a restaurant and contains basic
 * information such as name, price, and availability.
 */
@XmlRootElement(name = "menu_item")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="menu_item")
public class MenuItem extends BaseEntity{

    /**
     * Name of the menu item.
     */
    @XmlElement
    private String name;

    /**
     * Price of the menu item.
     */
    @XmlElement
    private float price;

    /**
     * Indicates whether the item is available.
     */
    @XmlElement
    private boolean available;

    /**
     * Default constructor required by JPA and JAXB.
     */
    public MenuItem() {
    }


    /**
     * Constructs a menu item with given parameters.
     *
     * @param name      item name
     * @param price     item price
     * @param available availability status
     */
    public MenuItem(String name, float price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }

    /**
     * @return menu item name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name menu item name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return menu item price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price menu item price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return true if item is available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * @param available availability flag
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Returns formatted string representation of the menu item.
     */
    @Override
    public String toString() {
        return "\n\t\tMenuItem:" +
                "\n\t\t\tname=" + name +
                "\n\t\t\tprice=" + price +
                "\n\t\t\tavailable=" + available;
    }
}
