package responses;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responses/Spreadsheet")
public class Spreadsheet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=Fruits.xls");
		
		out.println("\tQ1\tQ2\tQ3\tQ4\tTotal");
		out.println("Apples\t78\t45\t26\t80\t=SUM(B2:E2)");
		out.println("Oranges\t33\t47\t52\t14\t=SUM(B3:E3)");	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}