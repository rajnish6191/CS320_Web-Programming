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

@WebServlet("/Homework2/Login")
public class Login extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    public void init() throws ServletException
    {
        super.init();
        ServletContext context = getServletContext();
        if(context.getAttribute("SessionsUsers") == null)
        {
            ArrayList users = new ArrayList();
            users.add(new CS320User("John", "Doe", "john@doe.com", "1!"));
            users.add(new CS320User("Joe", "Boxer", "joe@boxer.com", "2@"));
            context.setAttribute("Users", users);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        if(request.getParameter("action") != null && request.getParameter("action").equals("logout"))
            session.invalidate();
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("\t<meta charset=\"UTF-8\">");
        out.println("\t<title>Login Servlet Page</title>");
        out.println("\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        out.println("\t<div class=\"page-header\">");
        out.println("\t\t<h1>Login</h1>");
        out.println("\t</div>");
        if(request.getAttribute("error") != null)
            out.println((new StringBuilder("<p class=\"text-danger\">")).append(request.getAttribute("error")).append("</p>").toString());
        out.println("<body style='background-color:#cdb79e;'>");
        out.println("\t<form action=\"Login\" method=\"post\">");
        out.println("      <input type=\"text\" placeholder=\"Username\" name=\"username\" />");
        out.println("      <br />");
        out.println("      <input type=\"password\" placeholder=\"Password\" name=\"password\" />");
        out.println("      <br />");
        out.println("      <input class=\"btn btn-success\" type=\"submit\" value=\"Login\" />");
        out.println("      <br />");
        out.println("      <input type=\"checkbox\" name=\"rememberMe\" /> Remember Me");
        out.println("\t</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>\t");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ServletContext context = getServletContext();
        ArrayList users = (ArrayList)context.getAttribute("Users");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        for(Iterator iterator = users.iterator(); iterator.hasNext();)
        {
            CS320User user = (CS320User)iterator.next();
            if(user.getEmail().equals(username) && user.getPassword().equals(password))
            {
                HttpSession session = request.getSession();
                session.setAttribute("CurrentUser", user);
                if(rememberMe != null && rememberMe.equals("on"))
                    try
                    {
                        MessageDigest md = MessageDigest.getInstance("SHA-256");
                        md.update(user.getEmail().getBytes());
                        String hashValue = "";
                        byte abyte0[];
                        int j = (abyte0 = md.digest()).length;
                        for(int i = 0; i < j; i++)
                        {
                            byte b = abyte0[i];
                            hashValue = (new StringBuilder(String.valueOf(hashValue))).append(String.format("%02X", new Object[] {
                                Byte.valueOf(b)
                            })).toString();
                        }

                        Cookie cookie = new Cookie("Homework2", hashValue);
                        cookie.setMaxAge(0x15180);
                        response.addCookie(cookie);
                    }
                    catch(NoSuchAlgorithmException e)
                    {
                        e.printStackTrace();
                    }
                response.sendRedirect("Welcome");
                break;
            }
        }

        request.setAttribute("error", "Invalid Username and/or Password");
        doGet(request, response);
    }
}