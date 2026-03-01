package lt.viko.eif.dalencinovic.first.spring.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "carDealership")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "car_dealership")
public class CarDealership extends BaseEntity{
    private String name;
    private int establishedYear;
    private float totalIncome;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "dealership_id")
    @XmlElementWrapper(name="cars")
    @XmlElement(name="car")
    private List<Car> cars;

    public CarDealership() {
    }

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
        return "CarDealership: " +
                "\n\tname=" + name +
                "\n\tcars=" + cars ;
    }
}
