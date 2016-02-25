package Homework1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Homework1/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Boolean isValid = false;
	private static Boolean isValidFirstName, isValidLastName, isValidEmail,
			isValidPassword, isValidReenterPassword = true;
	private static String strFirstNameValidation, strLastNameValidation,
			strEmailValidation, strPasswordValidation,
			strReenterPasswordValidation;
	public Register() {
		super();
	}

	public class Register1 {
		private String strFirstName;
		private String strLastName;
		private String strEmailid;
		private String strPassword;
		private String strReenterPassword;
		public Register1() {
			}
		public final String getStrFirstName() {
			return strFirstName;
			}
		public final void setStrFirstName(String strFirstName) {
				this.strFirstName = strFirstName;
			}
		public final String getStrLastName() {
				return strLastName;
			}
		public final void setStrLastName(String strLastName) {
				this.strLastName = strLastName;
			}
		public final String getStrEmailid() {
				return strEmailid;
			}
		public final void setStrEmail(String strEmail) {
				this.strEmailid = strEmailid;
			}
		public final String getStrPassword() {
				return strPassword;
			}
		public final void setStrPassword(String strPassword) {
				this.strPassword = strPassword;
			}
		public final String getStrReenterPassword() {
			return strReenterPassword;
		}
		public final void setStrReenterPassword(String strReenterPassword) {
			this.strPassword = strReenterPassword;
		 }
		}
	
		public void init() throws ServletException {
		isValidFirstName = true;
		isValidLastName = true;
		isValidEmail = true;
		isValidPassword = true;
		isValidReenterPassword = true;
	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Registration Form</title>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<body>");
	
		out.print("<div class=\"ppanel panel-primary\" style=\"padding: 15px; width: 45%; margin: 15px;\">");
		out.println("<div class=\"panel-heading\" style=\" margin-bottom: 13px;\">");
		out.println("Registration Servlet [By- Rajnish Kumar (CIN: 304470392)]");
		out.println("</div>");

		String strFirstName = request.getParameter("txtFirstName");
		String strLastName = request.getParameter("txtLastName");
		String strEmailid = request.getParameter("txtEmail");
		String strPassword = request.getParameter("txtPassword");
		String strReenterPassword = request.getParameter("txtReenterPassword");
		String strSubmit = request.getParameter("btnSubmit");

		if (strFirstName == null)
			strFirstName = "";
		if (strLastName == null)
			strLastName = "";
		if (strEmailid == null)
			strEmailid = "";
		if (strPassword == null)
			strPassword = "";
		if (strReenterPassword == null)
			strReenterPassword = "";
		out.println(GetErrorMessages(strFirstName, strLastName, strEmailid,
				strPassword, strReenterPassword, strSubmit));

		if (strSubmit != null && isValid) {
			ServletContext context = getServletContext();
			ArrayList<Register1> Register1 = null;
			Register1 objregister1 = new Register1();

			if (context.getAttribute("strUsers") == null) {
				Register1 = new ArrayList<Register1>();
			} else {
				Register1 = (ArrayList<Register1>) context.getAttribute("strUsers");
			}
			out.println("<div class=\"alert alert-success\" style=\"width:auto;height:60px;\"> Welcome, "
					+ strFirstName
					+ ". Congratulations. Registration Successfully </div>");
			out.println("<div>Click <a href=\"../Homework2/Login\" target=\"_self\">here </a> to Login.</div>");

			objregister1.setStrEmail(strEmailid);
			objregister1.setStrFirstName(strFirstName);
			objregister1.setStrLastName(strLastName);
			objregister1.setStrPassword(strPassword);

			Register1.add(objregister1);

			context.setAttribute("strUsers", Register1);

		} else {

			out.println("<form action=\"Register\" method=\"get\">");

			out.println("<table>");

			if (!isValidFirstName) {
				out.println("<tr>");
				out.println("<td style=\"padding:7px;\"></td>");
				out.println("<td style=\"padding:0 0 0 7px;color:red;\">");
				out.println(strFirstNameValidation);
				out.println("</td>");
				out.println("</tr>");

			}
			out.println("<tr>");
			out.println("<td style=\"padding:7px;\">First Name:");
			out.println("</td>");

			out.println("<td style=\"padding:7px;\">");

			out.println("<input type=\"text\" name=\"txtFirstName\" value=\""
					+ strFirstName + "\" />");

			out.println(" </td>");

			out.println("    </tr>");

			if (!isValidLastName) {
				out.println("<tr>");
				out.println("<td style=\"padding:7px;\"></td>");
				out.println("<td style=\"padding:0 0 0 7px;color:red;\">");
				out.println(strLastNameValidation);
				out.println("</td>");
				out.println("</tr>");

			}
			out.println("   <tr>");
			out.println("<td style=\"padding:7px;\">Last Name:");
			out.println("</td>");
			out.println("<td style=\"padding:7px;\">");

			out.println("  <input type=\"text\" name=\"txtLastName\"  value=\""
					+ strLastName + "\"/>");
			out.println("</td>");
			out.println("  </tr>");
			if (!isValidEmail) {
				out.println("<tr>");
				out.println("<td style=\"padding:7px;\"></td>");
				out.println("<td style=\"padding:0 0 0 7px;color:red;\">");
				out.println(strEmailValidation);
				out.println("</td>");
				out.println("</tr>");

			}
			out.println(" <tr>");
			out.println("<td style=\"padding:7px;\">Email ID:");
			out.println("</td>");
			out.println(" <td style=\"padding:7px;\">");

			out.println(" <input type=\"text\" name=\"txtEmail\" value=\""
					+ strEmailid + "\" />");
			out.println(" </td>");
			out.println(" </tr>");

			if (!isValidPassword) {
				out.println("<tr>");
				out.println("<td style=\"padding:7px;\"></td>");
				out.println("<td style=\"padding:0 0 0 7px;color:red;\">");
				out.println(strPasswordValidation);
				out.println("</td>");
				out.println("</tr>");
			}
			out.println(" <tr>");

			out.println("  <td style=\"padding:7px;\">Password:");
			out.println(" </td>");
			out.println("   <td style=\"padding:7px;\">");

			out.println("  <input type=\"password\" name=\"txtPassword\" value=\""
					+ strPassword + "\"/>");
			out.println("   </td>");
			out.println(" </tr>");
			if (!isValidReenterPassword) {
				out.println("<tr>");
				out.println("<td style=\"padding:7px;\"></td>");
				out.println("<td style=\"padding:0 0 0 7px;color:red;\">");
				out.println(strReenterPasswordValidation);
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("  <tr>");
			out.println("<td style=\"padding:7px;\">Reenter Password:");
			out.println("</td>");
			out.println(" <td style=\"padding:7px;\">");

			out.println(" <input type=\"password\" name=\"txtReenterPassword\" value=\""
					+ strReenterPassword + "\" />");
			out.println("</td>");
			out.println("  </tr>");
			out.println("<tr><td style=\"padding:7px;\"></td><td style=\"padding:7px;\"></td></tr>");
			out.println("<tr>");
			out.println(" <td style=\"padding:7px;\"></td>");
			out.println("<td style=\"padding:7px;\">");
			out.println("<input class=\"btn btn-lg btn-primary\" style=\"padding: 4px 12px;\" type=\"submit\" name=\"btnSubmit\" value=\"Submit\" />");
			out.println("</td></tr></table>");
			out.println("</div>");
			out.println("</form>");

		}

		out.println("</body>");
		out.println("</html>");
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private String GetErrorMessages(String strFirstName, String strLastName,
	String strEmail, String strPassword, String strReenterPassword, String strSubmit) {
		isValid = true;
		isValidFirstName = true;
		isValidLastName = true;
		isValidEmail = true;
		isValidPassword = true;
		isValidReenterPassword = true;
		if (strSubmit != null) {
			StringBuilder strErrorMessages = new StringBuilder();
			strErrorMessages.append("<ul style=\"list-style-type:circle\">");
			if (strFirstName == null || strFirstName == "") {
				strFirstNameValidation = "Please Enter First Name.";
				isValidFirstName = false;
				strFirstName = "";
				isValid = false;
			}
			if (strLastName == null || strLastName == "") {
				strLastNameValidation = "Please Enter Last Name.";
				isValidLastName = false;
				strLastName = "";
				isValid = false;
			}
			if (strEmail == null || strEmail == "") {

				strEmailValidation = "Please Enter Email ID.";
				isValidEmail = false;
				strEmail = "";
				isValid = false;
			} else {
				String strRegularExp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

				if (!Pattern.matches(strRegularExp, strEmail)) {
					strEmailValidation = "Please Enter Valid Email ID.";
					isValidEmail= false;
					isValid = false;
				}
			}
			if (strPassword == null || strPassword == "") {

				strPasswordValidation = "Please Enter Password.";
				isValidPassword = false;
				strPassword = "";
				isValid = false;
			}
			if (strReenterPassword == null || strReenterPassword == "") {
				strReenterPasswordValidation = "Please Confirm Password.";
				isValidReenterPassword = false;
				strReenterPassword = "";
				isValid = false;
			}

			if ((strPassword != null || strPassword != "")
					&& strReenterPassword != null || strReenterPassword != "") {

				if (!strPassword.equals(strReenterPassword)) {
					strPasswordValidation = "Match not found between password and repassword.";
					isValidPassword = false;
		
					isValid = false;
				} else {

					String strRegularExp = "((?=.*\\d)(?=.*[a-z])(?=.*[!@#$%^&*]).{3,15})";

					if (!Pattern.matches(strRegularExp, strPassword)
							&& strPassword != "") {
						strPasswordValidation = "Your password must contain atleast 1 number and one of !@#$%^&* characters.";
						isValidPassword = false;
						isValid = false;
					} 
				} 
			} 
		} 
		return "";
	}
}