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
 * Servlet responsible for transforming XML data into a PDF document
 * and sending it to the client.
 * Uses {@link XMLTransformationService} to perform the transformation.
 */
@WebServlet("/pdf")
public class PdfServlet extends HttpServlet {

    /**
     * Service for transforming XML files into PDF using XSLT.
     */
    @Autowired
    private XMLTransformationService xmlService;

    /**
     * Handles HTTP GET requests.
     * Transforms XML into PDF and streams the generated file to the client.
     *
     * @param req HTTP request
     * @param resp HTTP response
     * @throws IOException if an input or output error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        File xml = new File("src/main/resources/restaurant.xml");
        File xsl = new File("src/main/resources/restaurant-to-pdf.xsl");
        File pdfFile = new File("restaurant1.pdf");

        try {
            // Transform XML to PDF
            xmlService.transformToPDF(xml, xsl, pdfFile);

            // Set response headers for PDF display
            resp.setContentType("application/pdf;charset=UTF-8");
            resp.setHeader("Content-Disposition", "inline; filename=restaurant1.pdf");

            // Stream PDF file to client
            FileInputStream fis = new FileInputStream(pdfFile);
            ServletOutputStream out = resp.getOutputStream();

            fis.transferTo(out);

            fis.close();
            out.flush();

        } catch (Exception e) {
            resp.getWriter().println("<p>PDF error: </p>" + e.getMessage());
        }
    }
}
