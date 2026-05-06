
package lt.viko.restaurant_service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the lt.viko.restaurant_service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllRestaurantsRequest_QNAME = new QName("http://www.viko.lt/restaurant-service", "getAllRestaurantsRequest");
    private final static QName _GetRestaurantResponse_QNAME = new QName("http://www.viko.lt/restaurant-service", "getRestaurantResponse");
    private final static QName _GetAllRestaurantsResponse_QNAME = new QName("http://www.viko.lt/restaurant-service", "getAllRestaurantsResponse");
    private final static QName _MenuItem_QNAME = new QName("http://www.viko.lt/restaurant-service", "menu_item");
    private final static QName _Restaurant_QNAME = new QName("http://www.viko.lt/restaurant-service", "restaurant");
    private final static QName _GetMenuResponse_QNAME = new QName("http://www.viko.lt/restaurant-service", "getMenuResponse");
    private final static QName _GetMenuRequest_QNAME = new QName("http://www.viko.lt/restaurant-service", "getMenuRequest");
    private final static QName _GetRestaurantRequest_QNAME = new QName("http://www.viko.lt/restaurant-service", "getRestaurantRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: lt.viko.restaurant_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Restaurant }
     * 
     */
    public Restaurant createRestaurant() {
        return new Restaurant();
    }

    /**
     * Create an instance of {@link GetMenuResponse }
     * 
     */
    public GetMenuResponse createGetMenuResponse() {
        return new GetMenuResponse();
    }

    /**
     * Create an instance of {@link GetMenuRequest }
     * 
     */
    public GetMenuRequest createGetMenuRequest() {
        return new GetMenuRequest();
    }

    /**
     * Create an instance of {@link GetRestaurantRequest }
     * 
     */
    public GetRestaurantRequest createGetRestaurantRequest() {
        return new GetRestaurantRequest();
    }

    /**
     * Create an instance of {@link GetAllRestaurantsResponse }
     * 
     */
    public GetAllRestaurantsResponse createGetAllRestaurantsResponse() {
        return new GetAllRestaurantsResponse();
    }

    /**
     * Create an instance of {@link MenuItem }
     * 
     */
    public MenuItem createMenuItem() {
        return new MenuItem();
    }

    /**
     * Create an instance of {@link GetAllRestaurantsRequest }
     * 
     */
    public GetAllRestaurantsRequest createGetAllRestaurantsRequest() {
        return new GetAllRestaurantsRequest();
    }

    /**
     * Create an instance of {@link GetRestaurantResponse }
     * 
     */
    public GetRestaurantResponse createGetRestaurantResponse() {
        return new GetRestaurantResponse();
    }

    /**
     * Create an instance of {@link BaseEntity }
     * 
     */
    public BaseEntity createBaseEntity() {
        return new BaseEntity();
    }

    /**
     * Create an instance of {@link Restaurant.Menu }
     * 
     */
    public Restaurant.Menu createRestaurantMenu() {
        return new Restaurant.Menu();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllRestaurantsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.viko.lt/restaurant-service", name = "getAllRestaurantsRequest")
    public JAXBElement<GetAllRestaurantsRequest> createGetAllRestaurantsRequest(GetAllRestaurantsRequest value) {
        return new JAXBElement<GetAllRestaurantsRequest>(_GetAllRestaurantsRequest_QNAME, GetAllRestaurantsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRestaurantResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.viko.lt/restaurant-service", name = "getRestaurantResponse")
    public JAXBElement<GetRestaurantResponse> createGetRestaurantResponse(GetRestaurantResponse value) {
        return new JAXBElement<GetRestaurantResponse>(_GetRestaurantResponse_QNAME, GetRestaurantResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllRestaurantsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.viko.lt/restaurant-service", name = "getAllRestaurantsResponse")
    public JAXBElement<GetAllRestaurantsResponse> createGetAllRestaurantsResponse(GetAllRestaurantsResponse value) {
        return new JAXBElement<GetAllRestaurantsResponse>(_GetAllRestaurantsResponse_QNAME, GetAllRestaurantsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MenuItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.viko.lt/restaurant-service", name = "menu_item")
    public JAXBElement<MenuItem> createMenuItem(MenuItem value) {
        return new JAXBElement<MenuItem>(_MenuItem_QNAME, MenuItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Restaurant }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.viko.lt/restaurant-service", name = "restaurant")
    public JAXBElement<Restaurant> createRestaurant(Restaurant value) {
        return new JAXBElement<Restaurant>(_Restaurant_QNAME, Restaurant.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMenuResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.viko.lt/restaurant-service", name = "getMenuResponse")
    public JAXBElement<GetMenuResponse> createGetMenuResponse(GetMenuResponse value) {
        return new JAXBElement<GetMenuResponse>(_GetMenuResponse_QNAME, GetMenuResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMenuRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.viko.lt/restaurant-service", name = "getMenuRequest")
    public JAXBElement<GetMenuRequest> createGetMenuRequest(GetMenuRequest value) {
        return new JAXBElement<GetMenuRequest>(_GetMenuRequest_QNAME, GetMenuRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRestaurantRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.viko.lt/restaurant-service", name = "getRestaurantRequest")
    public JAXBElement<GetRestaurantRequest> createGetRestaurantRequest(GetRestaurantRequest value) {
        return new JAXBElement<GetRestaurantRequest>(_GetRestaurantRequest_QNAME, GetRestaurantRequest.class, null, value);
    }

}
