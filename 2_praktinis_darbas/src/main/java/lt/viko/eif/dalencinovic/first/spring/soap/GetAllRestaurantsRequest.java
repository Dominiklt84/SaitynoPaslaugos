package lt.viko.eif.dalencinovic.first.spring.soap;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * SOAP request object used for retrieving all restaurants.
 *
 * <p>
 * This request does not require any parameters because
 * all restaurants are returned from the system.
 * </p>
 */
@XmlRootElement
public class GetAllRestaurantsRequest {
}