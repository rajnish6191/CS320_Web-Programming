package responses;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responses/Adder")
public class Adder extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int op1 = 0, op2 = 0; 
		
		try{
			op1 = Integer.parseInt( request.getParameter("op1") );
			op2 = Integer.parseInt( request.getParameter("op2") );
		}catch(Exception e){
			response.sendRedirect("AdderError.html");
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Adder Servlet</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<div class=\"page-header\">");
		out.println("		<h1>Adder Servlet <small>HttpServletResponse</small></h1>");
		out.println("	</div>");
		
		out.println("	<h2>");
		out.println("	" + op1 + " + " + op2 + " = " + (op1 + op2) );
		out.println("	</h2>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>	");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}