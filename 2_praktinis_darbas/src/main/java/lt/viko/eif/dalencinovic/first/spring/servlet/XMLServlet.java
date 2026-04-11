package lt.viko.eif.dalencinovic.first.spring.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lt.viko.eif.dalencinovic.first.spring.model.Restaurant;
import lt.viko.eif.dalencinovic.first.spring.model.RestaurantList;
import lt.viko.eif.dalencinovic.first.spring.service.RestaurantWebService;
import lt.viko.eif.dalencinovic.first.spring.service.XMLTransformationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.List;

/**
 * Servlet responsible for generating XML from restaurant data
 * and displaying it in the browser.
 * Uses {@link XMLTransformationService} for XML creation
 * and {@link RestaurantWebService} to retrieve data.
 */
@WebServlet("/xml")
public class XMLServlet extends HttpServlet {

    /**
     * Service for transforming data into XML format.
     */
    @Autowired
    private XMLTransformationService xmlService;

    /**
     * Service for retrieving restaurant data.
     */
    @Autowired
    private RestaurantWebService service;

    /**
     * Handles HTTP GET requests.
     * Retrieves restaurant data, converts it to XML, and displays the result.
     *
     * @param req HTTP request
     * @param resp HTTP response
     * @throws IOException if an input or output error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // Retrieve restaurant data
        List<Restaurant> list = service.getAllRestaurants();

        // Define XML output file
        File xmlFile = new File("src/main/resources/restaurant.xml");

        // Transform data into XML
        xmlService.transformToXML(new RestaurantList(list), xmlFile);

        // Prepare HTML response
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");

        // Read and display XML content
        BufferedReader reader = new BufferedReader(new FileReader(xmlFile));

        out.println("<pre>");
        String line;
        while ((line = reader.readLine()) != null) {
            out.println(line
                    .replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;"));
        }
        out.println("</pre>");

        reader.close();

        // Confirmation message and navigation
        resp.getWriter().println("<p>XML created successfully</p> <a href='/main'>Back</a></body></html>");
    }
}