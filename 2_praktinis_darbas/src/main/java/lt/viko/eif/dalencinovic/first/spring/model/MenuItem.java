package lt.viko.eif.dalencinovic.first.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="menu_item")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="menu_item")
public class MenuItem extends BaseEntity{
    @XmlElement(required = true)
    private String name;
    @XmlElement
    private float price;
    @XmlElement
    private boolean available;

    public MenuItem() {
    }

    public MenuItem(String name, float price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "\n\t\tMenuItem:" +
                "\n\t\t\tname=" + name +
                "\n\t\t\tprice=" + price +
                "\n\t\t\tavailable=" + available;
    }
}
