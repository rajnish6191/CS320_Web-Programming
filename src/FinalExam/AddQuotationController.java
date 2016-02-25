package FinalExam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FinalExam/AddQuotationController")
public class AddQuotationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request
		.getRequestDispatcher("/WEB-INF/jsp/AddQuotationView.jsp")
		.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strAuthor=request.getParameter("author");
		String strQuote=request.getParameter("quote");
				
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
			if(!(strAuthor == "" || strQuote == ""))
			{
				String querry="Insert into quotation(author,quote)" +"values('"+strAuthor+"','"+strQuote+"')";
				System.out.println("Query" + querry);
				statement.executeUpdate(querry);
				request.setAttribute("success", "true");
				
			}
			else
			{
				request.setAttribute("success", "false");
				
			}
			connection.close();
		}
		catch(Exception e)
		{	
		}
		doGet(request,response);
	}	
}