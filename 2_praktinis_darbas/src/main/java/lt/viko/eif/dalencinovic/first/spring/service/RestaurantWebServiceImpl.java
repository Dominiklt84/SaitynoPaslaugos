package lt.viko.eif.dalencinovic.first.spring.service;

import jakarta.jws.WebService;
import lt.viko.eif.dalencinovic.first.spring.db.RestaurantRepository;
import lt.viko.eif.dalencinovic.first.spring.soap.*;
import org.springframework.stereotype.Service;

/**
 * SOAP Web Service implementation responsible for restaurant operations.
 * Provides methods for retrieving restaurants and their menu data.
 */
@Service
@WebService(
        endpointInterface = "lt.viko.eif.dalencinovic.first.spring.service.RestaurantWebService",
        targetNamespace = RestaurantWebService.NAMESPACE,
        serviceName = "RestaurantService",
        portName = "RestaurantPortSoap11"
)
public class RestaurantWebServiceImpl implements RestaurantWebService {

    /**
     * Repository used for accessing restaurant data from database.
     */
    private final RestaurantRepository repository;

    /**
     * Creates a new web service implementation instance.
     *
     * @param repository repository for restaurant data access
     */
    public RestaurantWebServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieves all restaurants from the database.
     *
     * @param request SOAP request object
     * @return response containing all restaurants
     */
    @Override
    public GetAllRestaurantsResponse getAllRestaurants(GetAllRestaurantsRequest request) {

        GetAllRestaurantsResponse response = new GetAllRestaurantsResponse();

        response.getRestaurants().addAll(repository.findAll());

        System.out.println("Fetched restaurants: " + response.getRestaurants().size());

        return response;
    }

    /**
     * Retrieves a restaurant by its identifier.
     *
     * @param request SOAP request containing restaurant id
     * @return response containing restaurant information
     */
    @Override
    public GetRestaurantResponse getRestaurant(GetRestaurantRequest request) {

        GetRestaurantResponse response = new GetRestaurantResponse();

        response.setRestaurant(repository.findById(request.getId()).orElse(null));

        return response;
    }

    /**
     * Retrieves menu items for a selected restaurant.
     *
     * @param request SOAP request containing restaurant id
     * @return response containing restaurant menu items
     */
    @Override
    public GetMenuResponse getMenu(GetMenuRequest request) {

        GetMenuResponse response = new GetMenuResponse();

        repository.findById(request.getRestaurantId()).ifPresent(r -> response.getMenu().addAll(r.getMenu()));

        return response;
    }
}