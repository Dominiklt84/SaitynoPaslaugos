package lt.viko.eif.dalencinovic.first.spring.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lt.viko.eif.dalencinovic.first.spring.service.DTDValidator;
import lt.viko.eif.dalencinovic.first.spring.service.XMLValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet responsible for validating an XML file against an XSD schema.
 * Uses {@link XMLValidator} to perform validation.
 */
@WebServlet("/validate")
public class ValidateServlet extends HttpServlet {

    /**
     * Service for validating XML files using XSD schema.
     */
    @Autowired
    private XMLValidator xmlValidator;

    /**
     * Handles HTTP GET requests.
     * Validates XML file and displays the result in HTML format.
     *
     * @param req HTTP request
     * @param resp HTTP response
     * @throws IOException if an input or output error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        File xml = new File("src/main/resources/restaurant.xml");
        File xsd = new File("src/main/resources/restaurant.xsd");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");

        try {
            // Validate XML against XSD schema
            xmlValidator.validate(xml, xsd);

            out.println("<p>XML is valid </p>");
        } catch (Exception e) {
            out.println("<p>Validation failed </p>");
            out.println("<p>" + e.getMessage() + "</p>");
        }
        out.println("<a href='/main'>Back</a>");
        out.println("</body></html>");
    }
}
