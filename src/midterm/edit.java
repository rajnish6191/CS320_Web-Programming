package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(value={"/midterm/edit"})
public class edit extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
     String indexString;
     PrintWriter out;
     int index;
     indexString = request.getParameter("index");
     out = response.getWriter();
     index = -1;
     InventoryItem item;
     index = Integer.parseInt(indexString);
     item = (InventoryItem)StoreAdmin.MidtermInventory.get(index);
     if(item == null)
         return;
     try
     {
         out.println("<html>");
         out.println("<body style='background-color:#15b89a;'>");
         out.println("<form method=\"post\">");
         out.println((new StringBuilder("<input type=\"hidden\" name=\"index\" value=\"")).append(index).append("\">").toString());
         out.println((new StringBuilder("Name:<input type=\"text\" name=\"Name\" value=\"")).append(item.getName()).append("\"/><br>").toString());
         out.println((new StringBuilder("Description:<input type=\"text\" name=\"Description\" value=\"")).append(item.getDescription()).append("\"/><br>").toString());
         out.println((new StringBuilder("Price:<input type=\"text\" name=\"Price\" value=\"")).append(String.format("%.2f", new Object[] {
             Double.valueOf(item.getPrice())
         })).append("\"/><br>").toString());
         out.println((new StringBuilder("Quantity:<input type=\"text\" name=\"Quantity\" value=\"")).append(item.getQuantity()).append("\"/><br>").toString());
         out.println("<input type=\"submit\" value=\"Edit\">");
         out.println("</form>");
         out.println("</html>");
     }
     catch(Exception e)
     {
         out.println("Invalid index.");
     }
 }
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException
 {
     String indexString = request.getParameter("index");
     String name = request.getParameter("Name");
     String description = request.getParameter("Description");
     String priceString = request.getParameter("Price");
     String quantityString = request.getParameter("Quantity");
     PrintWriter out = response.getWriter();
     double price = 0.0D;
     int quantity = 0;
     int index = 0;
     try
     {
         index = Integer.parseInt(indexString);
     }
     catch(NumberFormatException e)
     {
         out.println("Invalid index.");
         return;
     }
     if(name == null || name.isEmpty())
     {
         out.println("The name field can not be empty.");
         return;
     }
     if(description == null || description.isEmpty())
     {
         out.println("The description field can not be empty");
         return;
     }
     try
     {
         price = Double.parseDouble(priceString);
         if(price < 0.0D)
         {
             out.println("The price cannot be negative.");
             return;
         }
     }
     catch(NumberFormatException e)
     {
         out.println("The price must be a number. Floating-point values are okay. ");
         return;
     }
     try
     {
         quantity = Integer.parseInt(quantityString);
         if(quantity < 0)
         {
             out.println("The quantity must be a positive integer.");
             return;
         }
     }
     catch(NumberFormatException e)
     {
         out.println("The quantity must be a positive integer.");
         return;
     }
     StoreAdmin.MidtermInventory.set(index, new InventoryItem(name, description, price, quantity));
     response.sendRedirect("StoreAdmin");
 }
}