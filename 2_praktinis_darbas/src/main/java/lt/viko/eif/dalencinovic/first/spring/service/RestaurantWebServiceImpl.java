package lt.viko.eif.dalencinovic.first.spring.service;

import lt.viko.eif.dalencinovic.first.spring.model.MenuItem;
import lt.viko.eif.dalencinovic.first.spring.model.Order;
import lt.viko.eif.dalencinovic.first.spring.model.Restaurant;

import jakarta.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "lt.viko.eif.dalencinovic.first.spring.service.RestaurantWebService")
public class RestaurantWebServiceImpl implements RestaurantWebService{
    private static List<Restaurant> restaurants = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();

    @Override
    public Restaurant getRestaurant(Long id) {
        return restaurants.stream().filter(r -> r.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<MenuItem> getMenu(Long restaurantId) {
        return getRestaurant(restaurantId).getMenu();
    }

    @Override
    public Order createOrder(Order order) {
        orders.add(order);
        return order;
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }
}
