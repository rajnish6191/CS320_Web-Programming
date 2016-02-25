package requests;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requests/TwoPageCounter")
public class TwoPageCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() throws ServletException {

		ServletContext context = this.getServletContext();
		
		if ( context.getAttribute("SimpleCounter" ) == null)
			context.setAttribute("SimpleCounter", 0);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = this.getServletContext();
		
		int count = (int) context.getAttribute("SimpleCounter");
		
		count++;
		context.setAttribute("SimpleCounter", count);
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title> Two-Page Counter </title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("	<div class=\"container\">");
		
		out.println("		<div class=\"page-header\">");
		out.println("			<h1> 2-Page Counter <small> Requests </small></h1>");
		out.println("		</div>");
		
		out.println("		<h2>Your visit has been recorded. <small>" + new Date() + "</small></h2>");
		
		out.println("		<a class=\"btn btn-primary\" href=\"TwoPageReport\">Two-Page Counter</a>");
		
		out.println("	</div>");
		out.println("</body>");
		out.println("</html>");	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}