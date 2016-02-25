package midterm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(value={"/midterm/delete"})
public class delete extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String deleteIndexString = request.getParameter("index");
        if(deleteIndexString != null)
        {
            int index = -1;
            try
            {
                index = Integer.parseInt(deleteIndexString);
                StoreAdmin.MidtermInventory.remove(index);
            }
            catch(Exception exception) { }
        }
        response.sendRedirect("StoreAdmin");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}