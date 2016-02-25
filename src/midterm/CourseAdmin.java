package midterm;

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

@WebServlet("/midtermreview/CourseAdmin")
public class CourseAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() throws ServletException {
		ServletContext context = this.getServletContext();
		
		if (context.getAttribute("courses") == null ){
			
			ArrayList<MidtermReviewCourse> courses 
				= new ArrayList<MidtermReviewCourse>();
			
			courses.add( new MidtermReviewCourse("CS 320", "Web & Internet Programming"));
			courses.add( new MidtermReviewCourse("CS 242", "C Programming"));
			courses.add( new MidtermReviewCourse("CS 337", "Software Design"));
			
			context.setAttribute("courses", courses);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = this.getServletContext();
		ArrayList<MidtermReviewCourse> courses =
				(ArrayList<MidtermReviewCourse>) context.getAttribute("courses");
		
		if (request.getParameter("action") != null && request.getParameter("action").equals("remove")){
			try{
				int id = Integer.parseInt(request.getParameter("id"));
				for (MidtermReviewCourse course : courses){
					if (course.getId() == id){
						courses.remove( course );
						break;
					}
					
				}
			}catch( Exception e ){
			}
		}
			
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("	<meta charset=\"UTF-8\">");
		out.println("	<title>Login</title>");
		out.println("	<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("	<div class=\"page-header\">");
		out.println("		<h1>Course Admin <small> Midterm Review</small></h1>");
		out.println("	</div>");
		
		out.println("	<form action=\"CourseAdmin\" method=\"post\">");
		out.println("      <input type=\"text\" placeholder=\"Course Number\" name=\"number\" />");
		
		if (request.getAttribute("isValidNumber") != null && (Boolean) request.getAttribute("isValidNumber") == false){
			out.println("<p class=\"text-danger\">Invalid Course Number");
		}
		
		out.println("      <br />");
		out.println("      <input type=\"text\" placeholder=\"Course Title\" name=\"title\" />");
		out.println("      <br />");
		out.println("      <input class=\"btn btn-success\" type=\"submit\" value=\"Add Course\" />");
		out.println("	</form>");
		
		out.println("<hr />");
		
		out.println("	<form action=\"CourseAdmin\" method=\"get\">");
		out.println("      <input type=\"text\" placeholder=\"Search Term\" name=\"query\" />");			
		out.println("      <input class=\"btn btn-success\" type=\"submit\" value=\"Search\" />");
		out.println("	</form>");
		
		out.println("   <table class=\"table table-striped table-hover table-bordered\">");
		out.println("     <tr>");
		out.println("       <th>Course Number</th>");
		out.println("       <th>Course Title</th>");
		out.println("       <th>&nbsp;</th>");
		out.println("     </tr>");
		
		for (MidtermReviewCourse course : courses){
			
			if (request.getParameter("query") == null || (				
				course.getTitle().contains( request.getParameter("query") ) ||
			    course.getNumber().contains( request.getParameter("query") ) )){
			
				out.println("  <tr>");
				out.println("    <td>" + course.getNumber() + "</td>");
				out.println("    <td>" + course.getTitle() + "</td>");
				out.println("    <td><a href=\"CourseAdmin?action=remove&id=" + course.getId() + "\">Remove</a></td>");
				out.println("  </tr>");
			}
		}
		
		out.println("   </table>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>	");	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String number = request.getParameter("number");
		
		if (title != null && number != null){
			boolean isValidTitle, isValidNumber;
			
			isValidTitle = title.trim().length() > 0;
			isValidNumber = number.trim().length() > 0;
			
			if (isValidTitle && isValidNumber){
				ServletContext context = this.getServletContext();
				ArrayList<MidtermReviewCourse> courses = (ArrayList<MidtermReviewCourse>) context.getAttribute("courses");
				courses.add(new MidtermReviewCourse(number, title));
			}
			else{
				request.setAttribute("isValidTitle", isValidTitle);
				request.setAttribute("isValidNumber", isValidNumber);
			}
		}
		
		doGet(request, response);
	}
}