package lt.viko.eif.dalencinovic.first.spring.servlet;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lt.viko.eif.dalencinovic.first.spring.service.XMLTransformationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Servlet responsible for transforming XML data into HTML and returning it to the client.
 * Uses {@link XMLTransformationService} to perform XSLT transformation.
 */
@WebServlet("/html")
public class HTMLServlet extends HttpServlet {

    /**
     * Service for transforming XML files into HTML using XSLT.
     */
    @Autowired
    private XMLTransformationService xmlService;

    /**
     * Handles HTTP GET requests.
     * Transforms an XML file into HTML and sends it as a response.
     *
     * @param req HTTP request
     * @param resp HTTP response
     * @throws IOException if an input or output error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        File xml = new File("src/main/resources/restaurant.xml");
        File xsl = new File("src/main/resources/restaurant-to-html.xsl");
        File htmlFile = new File("restaurant1.html");

        try {
            // Perform transformation HTML
            xmlService.transformToHTML(xml, xsl, htmlFile);

            // Set response content type
            resp.setContentType("text/html");

            // Stream generated HTML file to client
            FileInputStream fis = new FileInputStream(htmlFile);
            ServletOutputStream out = resp.getOutputStream();

            fis.transferTo(out);

            fis.close();
            out.flush();

        } catch (Exception e) {
            resp.getWriter().println("HTML error: " + e.getMessage());
        }
    }
}
