package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value={"/midterm/add"})
public class add extends HttpServlet {
    private static final long serialVersionUID = 1;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body style='background-color:#849b87;'>");
        out.println("<form method=\"post\"><br><br>");
        out.println("Name:<input type=\"text\" name=\"Name\" /><br> <br>");
        out.println("Description:<input type=\"text\" name=\"Description\" /><br><br>");
        out.println("Price:<input type=\"text\" name=\"Price\" /><br><br>");
        out.println("Quantity:<input type=\"text\" name=\"Quantity\" /><br><br><br>");
        out.println("<input type=\"submit\" value=\"Add New Item\">");
        out.println("</form>");
        out.println("</html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("Name");
        String description = request.getParameter("Description");
        String priceString = request.getParameter("Price");
        String quantityString = request.getParameter("Quantity");
        PrintWriter out = response.getWriter();
        double price = 0.0;
        int quantity = 0;
        if (name == null || name.isEmpty()) {
            out.println("The name field can not be empty");
            return;
        }
        if (description == null || description.isEmpty()) {
            out.println("The description field can not be empty");
            return;
        }
        try {
            price = Double.parseDouble(priceString);
            if (price < 0.0) {
                out.println("The price cannot be negative.");
                return;
            }
        }
        catch (NumberFormatException e) {
            out.println("The price must be a number or a Floating-point values but can't be negative ");
            return;
        }
        try {
            quantity = Integer.parseInt(quantityString);
            if (quantity < 0) {
                out.println("Must be a positive integer");
                return;
            }
        }
        catch (NumberFormatException e) {
            out.println("Must be a positive integer");
            return;
        }
        StoreAdmin.MidtermInventory.add(new InventoryItem(name, description, price, quantity));
        response.sendRedirect("StoreAdmin");
    }
}