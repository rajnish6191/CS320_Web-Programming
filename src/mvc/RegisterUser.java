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

@WebServlet("/mvc/RegisterUser")
public class RegisterUser extends HttpServlet {
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
		String name     = request.getParameter("name");
		String email    = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean hasError = false;
		
		if (name == null || name.trim().length() == 0){
			request.setAttribute("nameError", "Invalid Name");
			hasError = true;
		}
		
		if (email == null || email.trim().length() == 0){
			request.setAttribute("emailError", "Invalid E-mail");
			hasError = true;
		}
		
		if (password == null || password.trim().length() == 0){
			request.setAttribute("passwordError", "Invalid Password");
			hasError = true;
		}
		
		if (hasError){
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/jsp/RegisterUser.jsp");
			
			dispatcher.forward(request, response);
		}
		else{
			((ArrayList<UserBean> )this.getServletContext().getAttribute("users")).add(new UserBean(name, email, password));
			response.sendRedirect("DisplayUsers");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}