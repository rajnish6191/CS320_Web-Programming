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

@WebServlet("/requests/GuestBookServlet")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		
		ArrayList<GuestBookPost> posts = new ArrayList<GuestBookPost>();
		posts.add(new GuestBookPost("John Doe", "Hello, World!"));
		posts.add(new GuestBookPost("Joe Boxer", "Game Over!"));
		
		if (context.getAttribute("GuestBookPosts") == null)
			context.setAttribute("GuestBookPosts", posts);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = this.getServletContext();
		ArrayList<GuestBookPost> posts = (ArrayList<GuestBookPost>) context.getAttribute("GuestBookPosts");
		
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		if (name != null && name.trim().length() > 0 &&
			message != null && message.trim().length() > 0){
			
			posts.add(new GuestBookPost(name, message) );
		}
			
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Guest Book</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<div class=\"page-header\">");
		out.println("		<h1>Please Sign Our Guest Book <small>CS 320</small></h1>");
		out.println("	</div>");
		
		
		out.println("	<form action=\"GuestBookServlet\" method=\"get\">");
		out.println("		Name: <input type=\"text\" name=\"name\" />");
		out.println("		<br /> ");		
		out.println("		Message: <br /> <textarea name=\"message\" cols=\"20\" rows=\"5\"></textarea>");
		out.println("		<br />");				
		out.println("		<input type=\"submit\" value=\"Post\" />");
		out.println("	</form>");
		
		out.println("<hr />");
		
		for(GuestBookPost post : posts){
			out.println("<div class=\"well\">");
			out.println("	<p>" + post.getMessage() + " - " + post.getName() + " (" + post.getWhen() + ")</p>");
			out.println("</div>");
		}
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>	");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}