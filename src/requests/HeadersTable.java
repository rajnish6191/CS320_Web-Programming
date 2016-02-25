package requests;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requests/HeadersTable")
public class HeadersTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Request Headers</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<div class=\"page-header\">");
		out.println("		<h1>Request Headers <small>HttpServletRequest</small></h1>");
		out.println("	</div>");
		
		out.println("	<table class=\"table table-bordered table-striped table-hover\">");
		out.println("		<tr>");
		out.println("			<th>Header Name</th>");
		out.println("			<th>Header Value</th>");
		out.println("		</tr>");
		
		Enumeration<String> headers = request.getHeaderNames();
		
		while(headers.hasMoreElements()){
			
			String headerName = headers.nextElement();
			
			out.println("	<tr>");
			out.println("		<td>" + headerName + "</td>");
			out.println("		<td>" + request.getHeader(headerName) + "</td>");
			out.println("	</tr>");
			
		}
		
		out.println(" 	</table>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>	");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}