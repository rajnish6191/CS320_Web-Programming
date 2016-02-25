package midterm3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/midterm/QuotationServlet")
public class QuotationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QuotationServlet() {
		super();
	}
	public static int intQuotaion = 1;
	public ArrayList<Integer> lsti = new ArrayList<Integer>();
	public void init() throws ServletException {
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		ServletContext context = getServletContext();
		ArrayList<Quotaions> lstQuotaions = (ArrayList<Quotaions>) context
				.getAttribute("strQuotes");

		StringBuilder strString = new StringBuilder();
		String btnSubmit = request.getParameter("btnSubmit");
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>CS320 Midterm – Quotation Generator</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"QuotationServlet\" method=\"get\">");

		Quotaions q = null;
		int i = 0;
		int k = 0;

		if (btnSubmit != null && btnSubmit.equals("Submit")) {
			Random r = new Random();

			i = r.nextInt(lstQuotaions.size());
			lstQuotaions.get(i);
			if (lsti.contains(intQuotaion))
			{
				intQuotaion = intQuotaion +1;
				lsti.add(intQuotaion);
			}
			else
				lsti.add(intQuotaion);
		}

		if (btnSubmit != null && btnSubmit.equals("Submit")
				&& lstQuotaions != null) {

			q = lstQuotaions.get(i);
			q.setIntVisitedCount(lsti.get(i));
			strString.append("<table border=\"1\">");
			strString.append("<tr>");
			strString.append("<td>");
			strString.append("quote");
			strString.append("</td>");
			strString.append("<td>");
			strString.append("author");
			strString.append("</td>");
			strString.append("</tr>");
			strString.append("<tr>");
			strString.append("<td>");
			strString.append(q.getStrAuthor());
			strString.append("</td>");
			strString.append("<td>");
			strString.append(q.getStrQuote());
			strString.append("</td>");
			strString.append("</tr>");

			strString.append("</table>");
			out.println(strString.toString());
		}
		out.println("</br>");

		out.println("<input type=\"submit\" name=\"btnSubmit\" value=\"Submit\" />");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}