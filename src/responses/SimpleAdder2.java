package responses;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responses/SimpleAdder2")
public class SimpleAdder2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Simple Adder</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<div class=\"page-header\">");
		out.println("		<h1>Simple Adder <small>HttpServletRequest</small></h1>");
		out.println("	</div>");
		
		out.println("	<form action=\"Adder\" method=\"get\">");
		out.println("		<input placeholder=\"Enter an integer\" type=\"text\" name=\"op1\" />");
		out.println("		+ ");		
		out.println("		<input placeholder=\"Enter another integer\" type=\"text\" name=\"op2\" />");		
		out.println("		<br />");
		out.println("		<input type=\"submit\" value=\"Add\" />");
		out.println("	</form>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>	");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}