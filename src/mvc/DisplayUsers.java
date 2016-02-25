package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mvc/DisplayUsers")
public class DisplayUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		
		if (context.getAttribute("users") == null){
			ArrayList<UserBean> users = new ArrayList<UserBean>();
			users.add(new UserBean("John Doe", "john@doe.com", "1!"));
			users.add(new UserBean("Joe Boxer", "joe@boxer.com", "2@"));
			context.setAttribute("users", users);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("currentUser") == null){
			response.sendRedirect("Login.jsp");
			return;
		}
		
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/mvc/DisplayUsers.jsp");
		
		ServletContext context = this.getServletContext();
		ArrayList<UserBean> users = (ArrayList<UserBean>) context.getAttribute("users");
		
		request.setAttribute("users", users);
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}