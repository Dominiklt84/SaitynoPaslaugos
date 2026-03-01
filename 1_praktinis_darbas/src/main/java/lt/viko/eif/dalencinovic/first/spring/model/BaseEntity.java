package lt.viko.eif.dalencinovic.first.spring.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlTransient;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    public BaseEntity() {
    }

    @XmlTransient
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
