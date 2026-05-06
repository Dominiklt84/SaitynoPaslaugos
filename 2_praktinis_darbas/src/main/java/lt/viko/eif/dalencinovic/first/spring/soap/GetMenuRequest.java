package lt.viko.eif.dalencinovic.first.spring.soap;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * SOAP request object used for retrieving
 * menu items of a selected restaurant.
 */
@XmlRootElement
public class GetMenuRequest {

    /**
     * Identifier of the restaurant.
     */
    private Long restaurantId;

    /**
     * Returns restaurant identifier.
     *
     * @return restaurant id
     */
    public Long getRestaurantId() {
        return restaurantId;
    }

    /**
     * Sets restaurant identifier.
     *
     * @param restaurantId restaurant id
     */
    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}