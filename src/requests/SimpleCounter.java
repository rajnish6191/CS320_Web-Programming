package requests;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requests/SimpleCounter")
public class SimpleCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static int count = 0;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title> Simple Page Counter </title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("	<div class=\"container\">");
		
		out.println("		<div class=\"page-header\">");
		out.println("			<h1> Simple Page Counter <small> Requests </small></h1>");
		out.println("		</div>");
		
		out.println("		<h2><small>This page has been viewed:</small> " + ++count + " time(s).</h2>");
		
		out.println("	</div>");
		out.println("</body>");
		out.println("</html>");		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}