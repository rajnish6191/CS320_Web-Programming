package requests;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requests/SimpleAdder")
public class SimpleAdder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int op1 = request.getAttribute("op1") == null ? 0 : (int) request.getAttribute("op1");
		int op2 = request.getAttribute("op2") == null ? 0 : (int) request.getAttribute("op2");
		int sum = request.getAttribute("sum") == null ? 0 : (int) request.getAttribute("sum");
		
		boolean hasError = request.getAttribute("hasError") != null;
		boolean formSubmitted = request.getAttribute("formSubmitted") != null;
		
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
		
		if (hasError){
			out.println("<p class=\"text-danger\">Please enter integers</p>");
		}
		
		out.println("	<form action=\"SimpleAdder\" method=\"post\">");
		out.println("		<input value=\"" + (!formSubmitted || hasError ? "" : op1) + "\" placeholder=\"Enter an integer\" type=\"text\" name=\"op1\" />");
		out.println("		+ ");		
		out.println("		<input value=\"" + (!formSubmitted || hasError ? "" : op2) + "\" placeholder=\"Enter another integer\" type=\"text\" name=\"op2\" />");
		out.println("		= ");
		out.println("		" + sum);
		out.println("		<br />");
		out.println("		<input type=\"submit\" value=\"Add\" />");
		out.println("	</form>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>	");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strOp1 = request.getParameter("op1");
		String strOp2 = request.getParameter("op2");
		
		int sum = 0;
		int op1 = 0;
		int op2 = 0;
		
			
		if (strOp1 != null && strOp2 != null){
			
			try{
				op1 = Integer.parseInt(strOp1);
				op2 = Integer.parseInt(strOp2);
				sum = op1 + op2;
			}
			catch(Exception e){
				request.setAttribute("hasError", true);
			}
		}
		request.setAttribute("op1", op1);
		request.setAttribute("op2", op2);
		request.setAttribute("sum", sum);		
		request.setAttribute("formSubmitted", true);	
		doGet(request, response);
	}
}