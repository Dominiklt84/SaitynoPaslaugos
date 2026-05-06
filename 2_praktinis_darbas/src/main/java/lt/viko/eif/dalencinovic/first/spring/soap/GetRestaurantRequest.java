package lt.viko.eif.dalencinovic.first.spring.soap;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * SOAP request object used for retrieving
 * a restaurant by its identifier.
 */
@XmlRootElement
public class GetRestaurantRequest {

    /**
     * Identifier of the restaurant.
     */
    private Long id;

    /**
     * Returns restaurant identifier.
     *
     * @return restaurant id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets restaurant identifier.
     *
     * @param id restaurant id
     */
    public void setId(Long id) {
        this.id = id;
    }
}