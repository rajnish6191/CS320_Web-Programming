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

@WebServlet("/Midterm/AddCar")
public class AddCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Car> entries = new ArrayList<Car>();

	public void init() throws ServletException {

		entries.add(new Car("honda", "civic", "1942"));
		entries.add(new Car("hyundai", "hawa", "2012"));
		entries.add(new Car("zata", "maja", "1920"));
		getServletContext().setAttribute("entries", entries);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>CAR");
		out.println("<title>");
		out.println("ADD car");
		out.println("</title>");
		out.println("</head>");
		out.println("<form action='AddCar' method='post'>");

		out.println("<ul>");
		if (makeerror != "")
			out.println("<li style=\"color:red;\" >" + makeerror + "</li>");
		if (modelerror != "")
			out.println("<li style=\"color:red;\">" + modelerror + "</li>");
		if (yearerror != "")
			out.println("<li style=\"color:red;\">" + yearerror + "</li>");
		out.println("</ul>");

		out.println("<br>Make: <input type=\"text\" name=\"make\" value=\""
				+ smake + "\" /><br>");

		out.println("<br>Model: <input type=\"text\" name=\"model\" value=\""
				+ smodel + "\"/><br>");

		out.println("<br>Year: <input type=\"text\" name=\"year\" value=\""
				+ syear + "\"/><br>");

		out.println("<br><input type=\"submit\" value=\"submit\" name=\"add\" /><br>");
		out.println("</br>");
		out.println("<table cellpadding=\"5\" border='2'>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Search");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type=\"text\" name=\"Search\">");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Search Field");
		out.println("</td>");
		out.println("<td>");
		out.println("<Select name=\"searchfield\">");
		out.println("<option value=\"model\">model</option>");
		out.println("<option value=\"make\">make</option>");
		out.println("<option value=\"year\">year</option>");
		out.println("<option value=\"all\">all</option>");
		out.println("</Select>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("</td>");
		out.println("<td>");
		out.println("<br><input type=\"submit\" value=\"search\" name=\"search\"/><br>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</br>");
		out.println("<h2>Search Results</h2>");
		out.println("<table border='2'>");
		out.println("<tr><th>Make</th> <th>model</th> <th>year</th></tr>");
		for (int i = 0; i < newlist.size(); i++) {
			Car entry = newlist.get(i);
			out.println("<tr><td>" + entry.getMake() + "</td><td> "
					+ entry.getModel() + "</td><td>" + entry.getYear()
					+ "</td></tr>");
		}

		out.println("</table>");
		out.println("</br>");
		out.println("<h2>Car Aministrator</h2>");
		out.println("<table border='2'>");
		out.println("<tr><th>Make</th> <th>model</th> <th>year</th> <th>operation</th></tr>");
		for (int i = 0; i < entries.size(); i++) {
			Car entry = entries.get(i);
			out.println("<tr><td>" + entry.getMake() + "</td><td> "
					+ entry.getModel() + "</td><td>" + entry.getYear()
					+ "<td><a href='Delete?id=" + i + "'>delete</td>"
					+ "</td></tr>");
		}

		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	List<Car> newlist = new ArrayList<Car>();

	String smake = "";
	String smodel = "";
	String syear = "";
	String makeerror = "";
	String modelerror = "";
	String yearerror = "";

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		boolean isValid = true;

		List<Car> entries = (List<Car>) getServletContext().getAttribute(
				"entries");

		if (entries == null || entries.size() == 0) {
			entries = new ArrayList<Car>();
		}

		String make = smake = request.getParameter("make");
		String model = smodel = request.getParameter("model");
		String year = syear = request.getParameter("year");
		String add = request.getParameter("add");
		String search = request.getParameter("search");

		if (add != null) {

			if (make == "" || make == null) {
				isValid = false;
				makeerror = "please enter make";
			} else
				makeerror = "";

			if (model == "" || model == null) {
				isValid = false;
				modelerror = "please enter model";
			} else
				modelerror = "";

			if (year == "" || year == null) {
				isValid = false;
				yearerror = "please enter year";
			} else {
				if (year.length() > 4) {
					isValid = false;
					yearerror = "please enter valid year";
				} else
					yearerror = "";

			}

			if (isValid) {
				entries.add(new Car(make, model, year));
				makeerror = "";
				modelerror = "";
				yearerror = "";
				request.setAttribute("entries", entries);
			}

			response.sendRedirect("AddCar");
		}

		if (search != null) {

			String searchvalue = request.getParameter("searchfield");
			String searchtext = request.getParameter("Search");

			newlist = new ArrayList<Car>();

			if (searchvalue.equals("model")) {

				for (Car car : entries) {

					if (car.getModel().toLowerCase()
							.contains(searchtext.toLowerCase())) {
						newlist.add(car);
					}
				}
			}

			if (searchvalue.equals("make")) {
				for (Car car : entries) {

					if (car.getMake().toLowerCase()
							.contains(searchtext.toLowerCase())) {
						newlist.add(car);
					}
				}
			}

			if (searchvalue.equals("year")) {

				for (Car car : entries) {

					if (car.getYear().toLowerCase()
							.contains(searchtext.toLowerCase())) {
						newlist.add(car);
					}
				}
			}

			if (searchvalue.equals("all")) {

				for (Car car : entries) {

					if (car.getModel().toLowerCase()
							.contains(searchtext.toLowerCase())) {
						newlist.add(car);
					}
					if (car.getMake().toLowerCase()
							.contains(searchtext.toLowerCase())) {
						newlist.add(car);
					}
					if (car.getYear().toLowerCase()
							.contains(searchtext.toLowerCase())) {
						newlist.add(car);
					}
				}
			}

			response.sendRedirect("AddCar");

		}
	}
}