package sessions;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessions/SessionCounter")
public class SessionCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String sessionId = session.getId();
		
		if (session.getAttribute("counter") == null)
			session.setAttribute("counter", 0);
		int count = (int) session.getAttribute("counter");
		
		session.setAttribute("counter", ++count);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Session Counter</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<div class=\"page-header\">");		
		out.println("		<h1>Session Counter <small> JSESSIONID: " + sessionId + "</small></h1>");
		out.println("	</div>");
		
		out.println("	<h3><small>This page has been viewed:</small> " + count + " time(s).</h3>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>	");	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}