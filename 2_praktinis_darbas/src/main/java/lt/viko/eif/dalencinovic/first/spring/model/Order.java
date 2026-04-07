package lt.viko.eif.dalencinovic.first.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Entity representing a customer order.
 */
@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="orders")
public class Order extends BaseEntity{
    @XmlElement
    private float totalPrice;
    @XmlElement
    private boolean paid;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @XmlElement
    private Customer customer;

    public Order() {
    }

    public Order(float totalPrice, boolean paid, Customer customer) {
        this.totalPrice = totalPrice;
        this.paid = paid;
        this.customer = customer;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "\n\t\tOrder:" +
                "\n\t\t\ttotalPrice=" + totalPrice +
                "\n\t\t\tpaid=" + paid +
                "\n\t\t\tcustomer=" + customer;
    }
}
