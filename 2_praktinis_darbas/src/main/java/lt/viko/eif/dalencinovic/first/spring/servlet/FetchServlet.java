package lt.viko.eif.dalencinovic.first.spring.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lt.viko.eif.dalencinovic.first.spring.model.Restaurant;

import lt.viko.eif.dalencinovic.first.spring.service.RestaurantWebService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet responsible for fetching and displaying all restaurants.
 * Uses {@link RestaurantWebService} to retrieve data from the backend.
 */
@WebServlet("/fetch")
public class FetchServlet extends HttpServlet {

    /**
     * Service for retrieving restaurant data.
     */
    @Autowired
    private RestaurantWebService service;

    /**
     * Handles HTTP GET requests.
     * Retrieves all restaurants and displays them in a simple HTML response.
     *
     * @param req HTTP request
     * @param resp HTTP response
     * @throws IOException if an input or output error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        List<Restaurant> list = service.getAllRestaurants();

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");

        list.forEach(r -> out.println("<p>" + r + "</p>"));

        out.println("<a href='/main'>Back</a>");
        out.println("</body></html>");
    }
}