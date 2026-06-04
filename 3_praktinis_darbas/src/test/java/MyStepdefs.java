import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Cucumber step definitions for restaurant API tests.
 */
public class MyStepdefs {

    /**
     * JSON media type.
     */
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * REST API base URL.
     */
    public static final String HOST = "http://localhost:8099";

    /**
     * HTTP client.
     */
    private final OkHttpClient client = new OkHttpClient();

    /**
     * Stores GET response body.
     */
    private String responseString;

    /**
     * Creates a new restaurant in the system.
     *
     * @throws IOException if request fails
     */
    @Given("new restaurant added to the system")
    public void newRestaurantAddedToTheSystem()
            throws IOException {

        String json = """
                {
                  "name":"Jammi",
                  "location":"Vilnius",
                  "open":true,
                  "rating":4.0
                }
                """;

        RequestBody body = RequestBody.create(json, JSON);

        Request request = new Request.Builder()
                        .url(HOST + "/restaurants")
                        .post(body)
                        .build();

        try (Response response = client.newCall(request).execute()) {

            if (!response.isSuccessful()) {

                throw new RuntimeException("Restaurant was not created");
            }
        }
    }

    /**
     * Requests all restaurants from the API.
     *
     * @throws IOException if request fails
     */
    @When("user navigates to restaurants list")
    public void userNavigatesToRestaurantsList() throws IOException {

        Request request = new Request.Builder()
                        .url(HOST + "/restaurants")
                        .get()
                        .build();

        try (Response response = client.newCall(request).execute()) {

            responseString = response.body().string();
        }
    }

    /**
     * Verifies that created restaurant
     * exists in returned list.
     */
    @Then("restaurant list should contain 1 restaurant")
    public void restaurantListShouldContainOneRestaurant() {

        assertTrue(responseString.contains("Jammi"));
    }
}