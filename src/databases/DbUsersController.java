package databases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import beans.DbUserBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/databases/DbUsersController")
public class DbUsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String host = "cs3.calstatela.edu";
		String port = "3306";
		String dbName = "cs320stu16";
		String username = "cs320stu16";
		String password = "tUaRH*T*";
		
		String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
		
		try{
			System.out.println("Class.forname");
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			
			System.out.println("Creating Connection");
			Driver driver = new org.gjt.mm.mysql.Driver();
			
			System.out.println("Creating Connection");
			Connection connection = 
					DriverManager.getConnection(url, username, password);
			
			System.out.println("Creating Statement");
			Statement statement = connection.createStatement();
			
			String query = "SELECT * FROM users ";
			
			if (request.getParameter("query") != null){
				query += " WHERE first LIKE '%" + request.getParameter("query") + "%' ";
			}
			System.out.println(query);
				
			ResultSet resultSet = statement.executeQuery(query);
			
			System.out.println("Iterating over results");
			ArrayList<beans.DbUserBean> users = 
					new ArrayList<beans.DbUserBean>(); 
			
			while ( resultSet.next() ){
				int    uid   = resultSet.getInt("uid");
				String first = resultSet.getString("first");
				String last  = resultSet.getString("last");
				String email = resultSet.getString("email");
				String pw    = resultSet.getString("password");
				
				users.add( new beans.DbUserBean(uid, first, last, email, pw));				
			}
			
			connection.close();
			
			request.setAttribute("users", users);
			
			request
				.getRequestDispatcher("/WEB-INF/jsp/sql/IntroToMySQL.jsp")
				.forward(request, response);
			
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		};
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}