package FinalExam;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.QuoteBean;

@WebServlet("/FinalExam/EditQuotationController")
public class EditQuotationController extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		List <beans.QuoteBean> items = (List<beans.QuoteBean>) context.getAttribute("Quot_In");
		int id = Integer.parseInt(request.getParameter("edit"));
		
		for(int i=0;i<items.size();i++) {
			if (items.get(i).getId() == id) {
				request.setAttribute("editItem", items.get(i));
				break;
			}
		}
		request.getRequestDispatcher("/WEB-INF/jsp/sql/EditQuotationView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String author=request.getParameter("author");
		String quote = request.getParameter("quote");
		
		int id = Integer.parseInt(request.getParameter("edit_id"));
		String host = "cs3.calstatela.edu";
		String port = "3306";
		String dbName = "cs320stu16";
		String username = "cs320stu16";
		String password = "tUaRH*T*";
		
		String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
		try{
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			Driver driver = new org.gjt.mm.mysql.Driver();
			Connection connection = 
					DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			String query = "UPDATE `cs320stu16`.`quotation` SET `author` = '"+author+"',`quote` = '"+quote+"' WHERE `quotation`.`id` ="+id;			
			statement.executeUpdate(query);
			System.out.println("Query" +query);
			connection.close();
			response.sendRedirect("../FinalExam/QuotationController");
		} catch (Exception e) {}		
	}
}