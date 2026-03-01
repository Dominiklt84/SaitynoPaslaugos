package lt.viko.eif.dalencinovic.first.spring.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.List;

/**
 * Represents a car dealership entity.
 * This class serves as the root XML element for JAXB transformation.
 */
@XmlRootElement(name = "carDealership")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "car_dealership")
public class CarDealership extends BaseEntity{
    private String name;
    private int establishedYear;
    private float totalIncome;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dealership_id")
    @XmlElementWrapper(name="cars")
    @XmlElement(name="car")
    private List<Car> cars;

    /**
     * Default constructor required by JPA and JAXB.
     */
    public CarDealership() {
    }

    /**
     * Constructor for creating dealership instance.
     */
    public CarDealership(String name, int establishedYear, float totalIncome, List<Car> cars) {
        this.name = name;
        this.establishedYear = establishedYear;
        this.totalIncome = totalIncome;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEstablishedYear() {
        return establishedYear;
    }

    public void setEstablishedYear(int establishedYear) {
        this.establishedYear = establishedYear;
    }

    public float getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(float totalIncome) {
        this.totalIncome = totalIncome;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "CarDealership:" +
                "\n\tname=" + name +
                "\n\testablishedYear=" + establishedYear +
                "\n\ttotalIncome=" + totalIncome +
                "\n\tcars=" + cars;
    }
}
