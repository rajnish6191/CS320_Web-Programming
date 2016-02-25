package requests;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requests/GuestBook")
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();		
		
		if (context.getAttribute("GuestBookEntries") == null){
			
			ArrayList<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
			entries.add(new GuestBookEntry("John Doe", "Hello, World!"));
			entries.add(new GuestBookEntry("Joe Boxer", "Game Over!"));
			
			context.setAttribute("GuestBookEntries", entries);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = this.getServletContext();
		ArrayList<GuestBookEntry> entries = (ArrayList<GuestBookEntry>) context.getAttribute("GuestBookEntries");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title> Guest Book </title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("	<div class=\"container\">");
		
		out.println("		<div class=\"page-header\">");
		out.println("			<h1> CS320 Guest Book <small> Requests </small></h1>");
		out.println("		</div>");
		
		out.println("<form action=\"GuestBook\" method=\"post\" />");
		out.println("<input type=\"text\" name=\"username\" placeholder=\"Enter your name\" /> ");
		out.println("<br />");
		out.println("<textarea name=\"message\" rows=\"5\" cols=\"20\" placeholder=\"Enter a message\"></textarea>");
		out.println("<br />");
		out.println("<input type=\"submit\" value=\"post\" />");
		out.println("</form>");
		
		out.println("<hr />");
	
		for(GuestBookEntry entry : entries){
			out.println("		<div class=\"well\">");
			out.println("			<h3>");
			out.println("				" + entry.getMessage());
			out.println("				- ");
			out.println("				" + entry.getUsername());
			out.println("				<small>");
			out.println("					" + entry.getDatePosted());
			out.println("				</small>");
			out.println("			</h3>");
			out.println("		</div>");
		}
	
		
		out.println("	</div>");
		out.println("</body>");
		out.println("</html>");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String message = request.getParameter("message");
		
		if (username != null && username.trim().length() > 0 &&
			message != null && message.trim().length() > 0){
			
			ArrayList<GuestBookEntry> entries = (ArrayList<GuestBookEntry>) this.getServletContext().getAttribute("GuestBookEntries");
			entries.add(new GuestBookEntry(username, message));	
		}	
		doGet(request, response);
	}
}