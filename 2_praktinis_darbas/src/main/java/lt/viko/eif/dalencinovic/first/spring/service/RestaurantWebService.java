package lt.viko.eif.dalencinovic.first.spring.service;

import lt.viko.eif.dalencinovic.first.spring.model.MenuItem;
import lt.viko.eif.dalencinovic.first.spring.model.Order;
import lt.viko.eif.dalencinovic.first.spring.model.Restaurant;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

/**
 * SOAP Web Service interface for managing restaurant data.
 * Provides operations for retrieving restaurants, menus and orders.
 */
@WebService
public interface RestaurantWebService {

    /**
     * Retrieves a restaurant by its ID.
     *
     * @param id unique restaurant identifier
     * @return Restaurant object or null if not found
     */
    @WebMethod
    Restaurant getRestaurant(Long id);

    /**
     * Retrieves menu items for a specific restaurant.
     *
     * @param restaurantId restaurant ID
     * @return list of menu items
     */
    @WebMethod
    List<MenuItem> getMenu(Long restaurantId);

    /**
     * Creates a new order.
     *
     * @param order order to create
     * @return created order
     */
    @WebMethod
    Order createOrder(Order order);

    /**
     * Returns all created orders.
     *
     * @return list of orders
     */
    @WebMethod
    List<Order> getOrders();

}
