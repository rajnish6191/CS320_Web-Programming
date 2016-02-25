package sessions;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessions/Welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if ( session.getAttribute("user") == null ){
			response.sendRedirect("Login");
			return;
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Welcome</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("<p class=\"text-right\">");
		out.println("  <a href=\"Login?action=logout\">Logout</a>");
		out.println("</p>");
		out.println("	<div class=\"page-header\">");
		out.println("		<h1>Welcome <small> Sessions &amp; Cookies</small></h1>");
		out.println("	</div>");
		
		SessionUser user = (SessionUser) session.getAttribute("user");
		
		out.println("   <h2>Welcome, " + user.getFirst() + "!</h2>");
			
		out.println("</div>");
		out.println("</body>");
		out.println("</html>	");	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}