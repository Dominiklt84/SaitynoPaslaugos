package lt.viko.eif.dalencinovic.first.spring.model;

import jakarta.persistence.*;

/**
 * Base entity class that provides ID field for all entities.
 * <p>
 * This class is intended to be extended by JPA entity classes.
 */
@MappedSuperclass
public class BaseEntity {
    /**
     * Primary key identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    /**
     * Default constructor.
     */
    protected BaseEntity(){
    }

    /**
     * Returns entity identifier.
     *
     * @return entity ID
     */
    public long getId() {
        return id;
    }

    /**
     * Sets entity identifier.
     *
     * @param id entity ID
     */
    public void setId(long id) {
        this.id = id;
    }
}
