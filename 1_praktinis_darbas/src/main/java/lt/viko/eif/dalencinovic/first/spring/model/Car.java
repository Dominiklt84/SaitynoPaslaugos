package lt.viko.eif.dalencinovic.first.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

/**
 * Represents a car entity in the dealership.
 * This class is used both as JPA entity and JAXB XML element.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "car")
public class Car extends BaseEntity{
    /**
     * Car model name.
     */
    private String model;
    /**
     * Manufacturing year of the car.
     */
    @Column(name="car_year")
    private int year;
    /**
     * Car price.
     */
    private float price;
    /**
     * Indicates whether the car is electric.
     */
    private boolean electric;

    /**
     * Default constructor required by JPA and JAXB.
     */
    public Car() {
    }

    /**
     * Constructor for creating car instance.
     *
     * @param model    car model
     * @param year     manufacturing year
     * @param price    car price
     * @param electric true if electric
     */
    public Car(String model, int year, float price, boolean electric) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.electric = electric;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }

    @Override
    public String toString() {
        return "\n\t\tCar: " +
                "\n\t\t\tmodel='" + model + '\'' +
                "\n\t\t\t year=" + year +
                "\n\t\t\t price=" + price +
                "\n\t\t\t electric=" + electric;
    }
}
