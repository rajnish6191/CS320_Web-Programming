package Homework2;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

	@WebServlet("/Homework2/Welcome")
	public class Welcome extends HttpServlet
	{
		private static final long serialVersionUID = 1L;
	    public Welcome()
	    {
	    }

	    private String sha256(String message)
	    {
	        String hashValue = "";
	        try
	        {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            md.update(message.getBytes());
	            byte abyte0[];
	            int j = (abyte0 = md.digest()).length;
	            for(int i = 0; i < j; i++)
	            {
	                byte b = abyte0[i];
	                hashValue = (new StringBuilder(String.valueOf(hashValue))).append(String.format("%02X", new Object[] {
	                    Byte.valueOf(b)
	                })).toString();
	            }
	        }
	        catch(NoSuchAlgorithmException e)
	        {
	            e.printStackTrace();
	        }
	        return hashValue;
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException
	    {
	        HttpSession session = request.getSession();
	        if(session.getAttribute("CurrentUser") == null)
	        {
	            boolean login = false;
	            Cookie cookies[] = request.getCookies();
	            if(cookies != null)
	            {
	                ServletContext context = getServletContext();
	                ArrayList users = (ArrayList)context.getAttribute("Users");
	                Cookie acookie[];
	                int j = (acookie = cookies).length;
	                for(int i = 0; i < j; i++)
	                {
	                    Cookie cookie = acookie[i];
	                    if(cookie.getName().equals("Homework2"))
	                    {
	                        for(Iterator iterator = users.iterator();iterator.hasNext();)
	                        {
	                            CS320User user = (CS320User)iterator.next();
	                            if(sha256(user.getEmail()).equals(cookie.getValue()))
	                            {
	                                login = true;
	                                session.setAttribute("CurrentUser", user);
	                                break;
	                            }
	                        }

	                    }
	                }

	            }
	            if(!login)
	            {
	                response.sendRedirect("Login");
	                return;
	            }
	        }
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("\t<meta charset=\"UTF-8\">");
	        out.println("\t<title>Welcome</title>");
	        out.println("\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
	        out.println("</head>");
	        out.println("<body style='background-color:#849b87;'>");
	        out.println("<div class=\"container\">");
	        out.println("<p class=\"text-right\">");
	        out.println("  <a href=\"Login?action=logout\"><b> Click for Logout </b></a>");
	        out.println("</p>");
	        out.println("\t<div class=\"page-header\">");
	        out.println("\t\t<h1>Welcome <small> Homework2; Sessions & Cookies</small></h1>");
	        out.println("\t</div>");
	        CS320User user = (CS320User)session.getAttribute("CurrentUser");
	        out.println((new StringBuilder("   <h2>Welcome, ")).append(user.getFirst()).append(" ").append(user.getLast()).append("!</h2>").toString());
	        out.println("</div>");
	        out.println("</body>");
	        out.println("</html>\t");
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException
	    {
	        doGet(request, response);
	    }
	}