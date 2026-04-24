
package lt.viko.eif.dalencinovic.first.spring.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the lt.viko.eif.dalencinovic.first.spring.service package. 
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

    private final static QName _GetMenuResponse_QNAME = new QName("http://service.spring.first.dalencinovic.eif.viko.lt/", "getMenuResponse");
    private final static QName _GetMenu_QNAME = new QName("http://service.spring.first.dalencinovic.eif.viko.lt/", "getMenu");
    private final static QName _Restaurant_QNAME = new QName("http://service.spring.first.dalencinovic.eif.viko.lt/", "restaurant");
    private final static QName _GetRestaurant_QNAME = new QName("http://service.spring.first.dalencinovic.eif.viko.lt/", "getRestaurant");
    private final static QName _GetAllRestaurants_QNAME = new QName("http://service.spring.first.dalencinovic.eif.viko.lt/", "getAllRestaurants");
    private final static QName _GetAllRestaurantsResponse_QNAME = new QName("http://service.spring.first.dalencinovic.eif.viko.lt/", "getAllRestaurantsResponse");
    private final static QName _MenuItem_QNAME = new QName("http://service.spring.first.dalencinovic.eif.viko.lt/", "menu_item");
    private final static QName _GetRestaurantResponse_QNAME = new QName("http://service.spring.first.dalencinovic.eif.viko.lt/", "getRestaurantResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: lt.viko.eif.dalencinovic.first.spring.service
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
     * Create an instance of {@link GetMenu }
     * 
     */
    public GetMenu createGetMenu() {
        return new GetMenu();
    }

    /**
     * Create an instance of {@link GetRestaurant }
     * 
     */
    public GetRestaurant createGetRestaurant() {
        return new GetRestaurant();
    }

    /**
     * Create an instance of {@link GetAllRestaurants }
     * 
     */
    public GetAllRestaurants createGetAllRestaurants() {
        return new GetAllRestaurants();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMenuResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.spring.first.dalencinovic.eif.viko.lt/", name = "getMenuResponse")
    public JAXBElement<GetMenuResponse> createGetMenuResponse(GetMenuResponse value) {
        return new JAXBElement<GetMenuResponse>(_GetMenuResponse_QNAME, GetMenuResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMenu }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.spring.first.dalencinovic.eif.viko.lt/", name = "getMenu")
    public JAXBElement<GetMenu> createGetMenu(GetMenu value) {
        return new JAXBElement<GetMenu>(_GetMenu_QNAME, GetMenu.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Restaurant }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.spring.first.dalencinovic.eif.viko.lt/", name = "restaurant")
    public JAXBElement<Restaurant> createRestaurant(Restaurant value) {
        return new JAXBElement<Restaurant>(_Restaurant_QNAME, Restaurant.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRestaurant }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.spring.first.dalencinovic.eif.viko.lt/", name = "getRestaurant")
    public JAXBElement<GetRestaurant> createGetRestaurant(GetRestaurant value) {
        return new JAXBElement<GetRestaurant>(_GetRestaurant_QNAME, GetRestaurant.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllRestaurants }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.spring.first.dalencinovic.eif.viko.lt/", name = "getAllRestaurants")
    public JAXBElement<GetAllRestaurants> createGetAllRestaurants(GetAllRestaurants value) {
        return new JAXBElement<GetAllRestaurants>(_GetAllRestaurants_QNAME, GetAllRestaurants.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllRestaurantsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.spring.first.dalencinovic.eif.viko.lt/", name = "getAllRestaurantsResponse")
    public JAXBElement<GetAllRestaurantsResponse> createGetAllRestaurantsResponse(GetAllRestaurantsResponse value) {
        return new JAXBElement<GetAllRestaurantsResponse>(_GetAllRestaurantsResponse_QNAME, GetAllRestaurantsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MenuItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.spring.first.dalencinovic.eif.viko.lt/", name = "menu_item")
    public JAXBElement<MenuItem> createMenuItem(MenuItem value) {
        return new JAXBElement<MenuItem>(_MenuItem_QNAME, MenuItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRestaurantResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.spring.first.dalencinovic.eif.viko.lt/", name = "getRestaurantResponse")
    public JAXBElement<GetRestaurantResponse> createGetRestaurantResponse(GetRestaurantResponse value) {
        return new JAXBElement<GetRestaurantResponse>(_GetRestaurantResponse_QNAME, GetRestaurantResponse.class, null, value);
    }

}
