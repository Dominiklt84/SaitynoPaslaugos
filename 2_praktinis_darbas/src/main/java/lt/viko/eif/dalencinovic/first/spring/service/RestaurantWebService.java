package lt.viko.eif.dalencinovic.first.spring.service;

import lt.viko.eif.dalencinovic.first.spring.model.MenuItem;
import lt.viko.eif.dalencinovic.first.spring.model.Order;
import lt.viko.eif.dalencinovic.first.spring.model.Restaurant;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public interface RestaurantWebService {
    @WebMethod
    Restaurant getRestaurant(Long id);
    @WebMethod
    List<MenuItem> getMenu(Long restaurantId);
    @WebMethod
    Order createOrder(Order order);
    @WebMethod
    List<Order> getOrders();

}
