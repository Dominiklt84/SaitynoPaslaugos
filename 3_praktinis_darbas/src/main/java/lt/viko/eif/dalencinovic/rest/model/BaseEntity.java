package lt.viko.eif.dalencinovic.rest.model;

import jakarta.persistence.*;

/**
 * Base entity class that provides ID field for all entities.
 */
@MappedSuperclass
public class BaseEntity {

    /**
     * Primary key identifier.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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
    public Long getId() {
        return id;
    }

    /**
     * Sets entity identifier.
     *
     * @param id entity ID
     */
    public void setId(Long id) {
        this.id = id;
    }
}
