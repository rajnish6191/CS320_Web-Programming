package FinalExam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FinalExam/QuotationController")
public class QuotationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
ServletContext context = this.getServletContext();
		
		String host = "cs3.calstatela.edu";
		String port = "3306";
		String dbName = "cs320stu16";
		String username = "cs320stu16";
		String password = "tUaRH*T*";
		
		String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
		
		try
		{	
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			Driver driver = new org.gjt.mm.mysql.Driver();
			Connection connection = 
					DriverManager.getConnection(url, username, password);
			
			Statement statement = connection.createStatement();
			int dltid = 0 ;
			if(request.getParameter("delete") != null) {
				dltid = Integer.parseInt(request.getParameter("delete"));
				String query = "DELETE FROM quotation WHERE id=" +dltid;
				System.out.println("Delete Query" +query);
				statement.executeUpdate(query);
				System.out.println("Delete Query" +query);	
			}
			String query = "SELECT * FROM quotation";
			
			if (request.getParameter("query") != null){
				query += " WHERE author LIKE '%" + request.getParameter("query") + "%' ";
				query += "    OR quote LIKE '%" + request.getParameter("query") + "%' ";
				  request.setAttribute("highlight", "true");
				}
			ResultSet resultSet = statement.executeQuery(query);
			ArrayList<beans.QuoteBean> quotes = 
					new ArrayList<beans.QuoteBean>(); 
			
			while ( resultSet
					.next() )
			{
				quotes.add( new beans.QuoteBean(resultSet.getInt("id"),resultSet.getString("author") , resultSet.getString("quote")));		
			}
			connection.close();	
			request.setAttribute("quotes", quotes);
			context.setAttribute("Quot_In",quotes);
			request
			.getRequestDispatcher("/WEB-INF/jsp/QuotationView.jsp")
			.forward(request, response);
		}
		catch(Exception e)
		{
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}