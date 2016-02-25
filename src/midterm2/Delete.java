package midterm2;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Midterm/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Delete() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Car> entries = (List<Car>) getServletContext().getAttribute(
				"entries");
		
		String id = request.getParameter("id");
		Car objCar = entries.get(Integer.valueOf(id));
		entries.remove(objCar);
		getServletContext().setAttribute("entries", entries);
		response.sendRedirect("AddCar");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}