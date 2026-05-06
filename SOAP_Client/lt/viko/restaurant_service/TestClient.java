package lt.viko.restaurant_service;

import java.net.URL;
import java.util.List;

public class TestClient {

    public static void main(String[] args) throws Exception {

        URL url = new URL("http://localhost:8090/ws/restaurant?wsdl");

        RestaurantService service = new RestaurantService(url);

        RestaurantPort port = service.getRestaurantPortSoap11();

        GetAllRestaurantsRequest request = new GetAllRestaurantsRequest();

        GetAllRestaurantsResponse response = port.getAllRestaurants(request);

        List<Restaurant> restaurants = response.getRestaurants();

        for (Restaurant r : restaurants) {

            System.out.println("\nRestoranas: " + r.getName());
            System.out.println("Vieta: " + r.getLocation());

            GetMenuRequest menuRequest = new GetMenuRequest();

            menuRequest.setRestaurantId(r.getId());

            GetMenuResponse menuResponse = port.getMenu(menuRequest);

            List<MenuItem> menu = menuResponse.getMenu();

            System.out.println("Meniu:");

            for (MenuItem item : menu) {
                System.out.println("- " + item.getName() + " | " + item.getPrice() + "€");
            }
        }
    }
}