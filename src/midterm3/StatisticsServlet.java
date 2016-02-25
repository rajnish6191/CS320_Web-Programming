package midterm3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/midterm/StatisticsServlet")
public class StatisticsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StatisticsServlet() {
		super();
	}

	public void init() throws ServletException {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		ServletContext context = getServletContext();
		ArrayList<Quotaions> lstQuotaions = (ArrayList<Quotaions>) context
				.getAttribute("strQuotes");

		StringBuilder strString = new StringBuilder();

		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>CS320 Midterm – Quotation Generator</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"StatisticsServlet\" method=\"get\">");
		strString.append("<table border=\"1\">");
		strString.append("<tr>");
		strString.append("<td>");
		strString.append("quote");
		strString.append("</td>");
		strString.append("<td>");
		strString.append("author");
		strString.append("</td>");
		strString.append("</tr>");
		if (lstQuotaions != null) {

			for (Quotaions q : lstQuotaions) {
				
				strString.append("<tr>");
				strString.append("<td>");
				strString.append(q.getStrAuthor());
				strString.append("</td>");
				strString.append("<td>");
				strString.append(q.getStrQuote());
				strString.append("</td>");
				strString.append("<td>");
				strString.append(q.getIntVisitedCount());
				strString.append("</td>");
				strString.append("</tr>");
			}
		}
		strString.append("</table>");
		out.println(strString.toString());
		out.println("</br>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}