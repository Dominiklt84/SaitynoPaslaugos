package lt.viko.eif.dalencinovic.first.spring.service;

import java.net.URL;
import java.util.List;

public class TestClient {
    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:8090/ws/restaurant?wsdl");

        RestaurantWebServiceImplService serviceFactory =
                new RestaurantWebServiceImplService(url);

        RestaurantWebService port =
                serviceFactory.getRestaurantWebServiceImplPort();

        List<Restaurant> restaurants = port.getAllRestaurants();

        restaurants.forEach(r ->
                System.out.println(r.getName() + " - " + r.getLocation())
        );
    }
}
