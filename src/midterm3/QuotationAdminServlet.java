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

@WebServlet("/midterm/QuotationAdminServlet")
public class QuotationAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QuotationAdminServlet() {
		super();
	}
	public void init() throws ServletException {
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		boolean blIsValid = true;
		PrintWriter out = response.getWriter();
		StringBuilder strString = new StringBuilder();
		StringBuilder strValidation = new StringBuilder();
		String strQuotaion = request.getParameter("txtQuotaion");
		String strAuthor = request.getParameter("txtAuthor");
		String btnAddQuotation = request.getParameter("btnAddQuotation");
		String hdnremove = request.getParameter("remove");
		String id = request.getParameter("id");
		if (btnAddQuotation != null) {
			strValidation.append("<ul style=\"list-style-type:circle\">");

			if (strQuotaion == "") {
				blIsValid = false;
				strValidation.append("<li>");
				strValidation.append("Please enter quotation");
				strValidation.append("</li>");
			}
			if (strAuthor == "") {

				blIsValid = false;
				strValidation.append("<li>");
				strValidation.append("Please enter author");
				strValidation.append("</li>");
			}
			strValidation.append("</ul>");
		}

		ServletContext context = getServletContext();
		ArrayList<Quotaions> lstQuotaion = (ArrayList<Quotaions>) context
				.getAttribute("strQuotes");
		if (btnAddQuotation != null && blIsValid) {
			Quotaions objQuotation = new Quotaions(strQuotaion, strAuthor);

			if (lstQuotaion == null) {
				lstQuotaion = new ArrayList<Quotaions>();
			} else {
				lstQuotaion = (ArrayList<Quotaions>) context
						.getAttribute("strQuotes");
			}

			lstQuotaion.add(objQuotation);
			context.setAttribute("strQuotes", lstQuotaion);
			response.sendRedirect("../midterm/QuotationAdminServlet");
		}

		if (id != null) {

			int i = Integer.parseInt(id) - 1;
			lstQuotaion = (ArrayList<Quotaions>) context
					.getAttribute("strQuotes");
			
			Quotaions q = lstQuotaion.get(i);

			if (q != null && lstQuotaion != null)
				lstQuotaion.remove(i);

			context.setAttribute("strQuotes", lstQuotaion);
			response.sendRedirect("../midterm/QuotationAdminServlet");
		}

		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>CS320 Midterm – Quotation Generator</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"QuotationAdminServlet\" method=\"get\">");
		out.println("<table border='1' width=\"100%\">");
		out.println("<tr>");
		out.println("<td width=\"30%\">");
		out.println("actual quotation");
		out.println("</td>");
		out.println("<td>");
		out.println("author");
		out.println("</td>");

		out.println("<td>");
		out.println("</td>");

		out.println("</tr>");

		if (lstQuotaion != null) {
			int i = 1;
			for (Quotaions quotaions : lstQuotaion) {

				strString.append("<tr>");
				strString.append("<td>");
				strString.append(quotaions.getStrAuthor());
				strString.append("</td>");
				strString.append("<td>");
				strString.append(quotaions.getStrQuote());
				strString.append("</td>");
				strString.append("<td>");
				strString
						.append("<a href=\"../midterm/QuotationAdminServlet?id="
								+ i + "\" target=\"_self\">remove </a>");
				strString.append("<input type=\"hidden\"  name=\"remove\" />");
				strString.append("</td>");
				strString.append("</tr>");
				i++;
			}
		}

		if (strString != null && strString.length() > 0)
			out.println(strString.toString());

		out.println("</table>");

		out.println("</br>");
		out.println("</br>");
		out.println("</br>");
		out.println("</br>");
		out.println("</br>");

		if (!blIsValid) {
			out.println(strValidation);
		}

		out.println("</br>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Quotaion");
		out.println("</td>");
		out.println("<td>");
		out.println("<input type=\"text\" name=\"txtQuotaion\"  />");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Author");
		out.println("<td>");
		out.println("<input type=\"text\" name=\"txtAuthor\"  />");
		out.println("</td>");
		out.println("<td>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>");

		out.println("<td>");
		out.println("<input type=\"submit\" name=\"btnAddQuotation\" value=\"Add\" />");
		out.println("</td>");
		out.println("<td>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}