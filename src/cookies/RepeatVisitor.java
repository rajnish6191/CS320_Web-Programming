package cookies;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookies/RepeatVisitor")
public class RepeatVisitor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean repeatVisitor = false;
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null){
			for( Cookie cookie : cookies ){
				if (cookie.getName().equals("repeatVisitor")){
					repeatVisitor = true;
					break;
				}
			}			
			if (repeatVisitor == false){
				Cookie cookie = new Cookie("repeatVisitor", "true");
				response.addCookie( cookie );
			}
				
		}
		else{
			Cookie cookie = new Cookie("repeatVisitor", "true");
			response.addCookie( cookie );
		}
			
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Repeat Visitor</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<div class=\"page-header\">");
		out.println("		<h1>Repeat Visitor <small>Cookies</small></h1>");
		out.println("	</div>");
		
		if (!repeatVisitor)
			out.println("<h2>Welcome!  It looks like it's your first time here.</h2>");
		else
			out.println("<h2>Welcome Back!</h2>");
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>	");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}