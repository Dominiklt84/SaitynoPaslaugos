package lt.viko.eif.dalencinovic.first.spring.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet that displays the main menu page.
 * Provides navigation links to different application functionalities.
 */
@WebServlet("/main")
public class MenuServlet extends HttpServlet {

    /**
     * Handles HTTP GET requests.
     * Generates a simple HTML page with links to available actions.
     *
     * @param req HTTP request
     * @param resp HTTP response
     * @throws IOException if an input or output error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h1>Restaurant Menu</h1>");

        out.println("<a href='/fetch'>1. Fetch data</a><br>");
        out.println("<a href='/xml'>2. Transform to XML</a><br>");
        out.println("<a href='/validate'>3. Validate XML</a><br>");
        out.println("<a href='/html'>4. XML to HTML</a><br>");
        out.println("<a href='/pdf'>5. XML to PDF</a><br>");

        out.println("</body></html>");
    }
}
