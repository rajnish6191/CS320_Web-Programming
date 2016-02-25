package responses;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responses/Countdown")
public class Countdown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		if (context.getAttribute("Countdown") == null)
			context.setAttribute("Countdown", 10);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = this.getServletContext();
		int count = (int) context.getAttribute("Countdown");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Countdown</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<div class=\"page-header\">");
		out.println("		<h1>Countdown <small>HttpServletResponse</small></h1>");
		out.println("	</div>");
		
		out.println(" 	<h2><small>Countdown Value: </small>" + count + "</h2>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>	");
		
		context.setAttribute("Countdown", count-1);
		
		if (count > 0)
			response.setIntHeader("Refresh", 1);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}