package midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(value={"/midterm/StoreAdmin"})
public class StoreAdmin extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public static ArrayList MidtermInventory = new ArrayList();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
     PrintWriter out = response.getWriter();
     ArrayList display = new ArrayList();
     String searchText = request.getParameter("text");
     String selectedItem = request.getParameter("item");
     if(searchText == null || selectedItem == null || searchText.isEmpty() || selectedItem.isEmpty())
    	 display.addAll(MidtermInventory);
     else
     if(selectedItem.equalsIgnoreCase("name"))
     {
         for(Iterator iterator = MidtermInventory.iterator(); iterator.hasNext();)
         {
             InventoryItem item = (InventoryItem)iterator.next();
             if(item.getName().toLowerCase().contains(searchText.toLowerCase()))
                 display.add(item);
         }
     } else
     if(selectedItem.equalsIgnoreCase("description"))
     {
         for(Iterator iterator1 = MidtermInventory.iterator(); iterator1.hasNext();)
         {
             InventoryItem item = (InventoryItem)iterator1.next();
             if(item.getDescription().toLowerCase().contains(searchText.toLowerCase()))
                 display.add(item);
         }
     } else
     if(selectedItem.equalsIgnoreCase("price"))
     {
         double price = 0.0D;
         try
         {
             price = Double.parseDouble(searchText);
         }
         catch(NumberFormatException e)
         {
             out.println("Not a Valid Input");
             return;
         }
         for(Iterator iterator4 = MidtermInventory.iterator(); iterator4.hasNext();)
         {
             InventoryItem item = (InventoryItem)iterator4.next();
             if(item.getPrice() < price)
                 display.add(item);
         }
     } else
     if(selectedItem.equalsIgnoreCase("all"))
     {
         for(Iterator iterator2 = MidtermInventory.iterator(); iterator2.hasNext();)
         {
             InventoryItem item = (InventoryItem)iterator2.next();
             if(item.getDescription().toLowerCase().contains(searchText.toLowerCase()) || item.getName().toLowerCase().contains(searchText.toLowerCase()))
                 display.add(item);
         }
     }
     out.println("<table><br>");
     out.println("<tr><br><br>");
     out.println("<br><br>");
     out.print("<th>Name</th>");
     out.print("<th>Description</th>");
     out.print("<th>Price</th>");
     out.print("<th>Inventory</th>");
     out.print("<th>Edit</th>");
     out.print("<th>Delete</th>");
     out.println("</tr>");
     for(Iterator iterator3 = display.iterator(); iterator3.hasNext(); out.println("</tr>"))
     {
         InventoryItem item = (InventoryItem)iterator3.next();
         int index = MidtermInventory.indexOf(item);
         out.println("<tr>");
         out.print((new StringBuilder("<td>")).append(item.getName()).append("</td>").toString());
         out.print((new StringBuilder("<td>")).append(item.getDescription()).append("</td>").toString());
         out.print((new StringBuilder("<td>")).append(String.format("%.2f", new Object[] {
             Double.valueOf(item.getPrice())
         })).append("</td>").toString());
         out.print((new StringBuilder("<td>")).append(item.getQuantity()).append("</td>").toString());
         out.print((new StringBuilder("<td><a href=\"edit?index=")).append(index).append("\">edit</a></td>").toString());
         out.print((new StringBuilder("<td><a href=\"delete?index=")).append(index).append("\">delete</a></td>").toString());
     }
     out.println("<tr>");
     out.println("<body style='background-color:#cdb79e;'>");
     out.println("<form><br>");
     out.println("<input name=\"text\">");
     out.println("<select name=\"item\">");
     out.print("<option value=\"Name\">Name</option>");
     out.print("<option value=\"Description\">Description</option>");
     out.print("<option value=\"Price\">Price</option>");
     out.print("<option value=\"All\">All</option>");
     out.print("<input type=\"submit\" value=\"Search\">");
     out.println("<form>");
     out.println("</select>");
     out.println("</tr>");
     out.println("</table>");
     out.println("<br><br><br><br><br><br><br><br>");
     out.println("<a href=\"add\">Add New Item</a>");
 }
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException
 {
     doGet(request, response);
 }
}