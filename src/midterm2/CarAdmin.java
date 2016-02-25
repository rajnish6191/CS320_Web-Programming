package midterm2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Midterm/CarAdmin")
public class CarAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {

		List<Car> entries = new ArrayList<Car>();
		entries.add(new Car("honda", "civic", "1942"));
		entries.add(new Car("hyundai", "hawa", "2012"));
		entries.add(new Car("zata", "maja", "1920"));
		getServletContext().setAttribute("entries", entries);
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Car> entries = (List<Car>) getServletContext().getAttribute(
				"entries");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("Car page");
		out.println("</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Car main page</h2>");
		out.println("<table border='2'>");
		out.println("<tr><th>Make</th> <th>model</th> <th>year</th> <th>operation</th></tr>");
		for (int i = 0; i < entries.size(); i++) {
			Car entry = entries.get(i);
			out.println("<tr><td>" + entry.getMake() + "</td><td> "
					+ entry.getModel() + "</td><td>" + entry.getYear()
					+ "<td><a href='Delete?id= "+i+" '>delete</td>" + "</td></tr>");
		}

		out.println("</table>");

		out.println("<a href='AddCar'> Add car");
		out.println("</a>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}