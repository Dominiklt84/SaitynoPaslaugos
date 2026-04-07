package lt.viko.eif.dalencinovic.first.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Represents a customer entity in the restaurant.
 * This class is used both as JPA entity and JAXB XML element.
 */
@XmlRootElement(name="customer")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="customer")
public class Customer extends BaseEntity {
    @XmlElement
    private String name;
    @XmlElement
    private String email;

    public Customer() {
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "\n\t\tCustomer:" +
                "\n\t\t\tname=" + name +
                "\n\t\t\temail=" + email;
    }
}
