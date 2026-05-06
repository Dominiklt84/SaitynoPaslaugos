package lt.viko.eif.dalencinovic.first.spring.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import lt.viko.eif.dalencinovic.first.spring.soap.*;

/**
 * SOAP Web Service interface responsible for handling restaurant operations.
 * Provides methods for retrieving restaurant information and restaurant menus.
 */
@WebService(
        name = "RestaurantPort",
        targetNamespace = RestaurantWebService.NAMESPACE,
        serviceName = "RestaurantService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL,
        parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface RestaurantWebService {

    /**
     * SOAP namespace used by the Restaurant Web Service.
     */
    String NAMESPACE = "http://www.viko.lt/restaurant-service";

    /**
     * Retrieves all restaurants from the database.
     *
     * @param request SOAP request object
     * @return response containing all restaurants
     */
    @WebMethod(operationName = "getAllRestaurants")
    @WebResult(name = "getAllRestaurantsResponse", targetNamespace = NAMESPACE)
    GetAllRestaurantsResponse getAllRestaurants(
            @WebParam(name = "getAllRestaurantsRequest", targetNamespace = NAMESPACE)
            GetAllRestaurantsRequest request);

    /**
     * Retrieves a single restaurant by its identifier.
     *
     * @param request SOAP request containing restaurant id
     * @return response containing restaurant data
     */
    @WebMethod(operationName = "getRestaurant")
    @WebResult(name = "getRestaurantResponse", targetNamespace = NAMESPACE)
    GetRestaurantResponse getRestaurant(
            @WebParam(name = "getRestaurantRequest", targetNamespace = NAMESPACE)
            GetRestaurantRequest request);

    /**
     * Retrieves menu items for a selected restaurant.
     *
     * @param request SOAP request containing restaurant id
     * @return response containing menu items
     */
    @WebMethod(operationName = "getMenu")
    @WebResult(name = "getMenuResponse", targetNamespace = NAMESPACE)
    GetMenuResponse getMenu(
            @WebParam(name = "getMenuRequest", targetNamespace = NAMESPACE)
            GetMenuRequest request);
}