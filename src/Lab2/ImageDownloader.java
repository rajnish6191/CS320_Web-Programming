package Lab2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Lab2/ImageDownloader")
public class ImageDownloader extends HttpServlet 
{
private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{	
	ServletContext context = getServletContext();
	if(request.getParameter("Images")!=null)
	 {
		String fileName=request.getParameter("Images")+".png";
		response.setContentType("image/gif");
		response.setHeader("Content-Disposition", "attachment; filename="+fileName);
		String path = context.getRealPath("Images/"+fileName);
		String filepath=path;
		File file=new File(filepath);
		FileInputStream in=new FileInputStream(file);
		OutputStream outstr=response.getOutputStream();
		byte[] buffer=new byte[4096];
		int bytesread=-1;
		while((bytesread=in.read(buffer))!=-1)
	    	{
				outstr.write(buffer,0,bytesread);
			}	
			in.close();
			outstr.close();
			}
		else
		{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Lab 2</title>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">");
		out.println("</head>");
		out.println("<div class=\"container\">");
		out.println("<div class=\"page-header\">");
		out.println("<h1>Lab 2(Image Downloader)</h1>");
		out.println("<body style='background-color:#cdb79e;'>");      
		out.println("<form action=\"ImageDownLoader\" method=\"get\">");
		out.println("<a href=\"ImageDownloader?Images=bean\">Mr. Bean</a></br>");
		out.println("<a href=\"ImageDownloader?Images=clint\">Mr. Clint</a></br>");
		out.println("<a href=\"ImageDownloader?Images=gaga\">Ms. Gaga</a></br>");
		out.println("<a href=\"ImageDownloader?Images=hermoine\">Ms. Hermoine</a></br>");
		out.println("<a href=\"ImageDownloader?Images=joker\">Mr. Joker</a></br>");
		out.println("<a href=\"ImageDownloader?Images=mj\">Mr. MJ</a></br>");
		out.println("<a href=\"ImageDownloader?Images=penny\">Ms. Penny</a></br>");
		out.println("<a href=\"ImageDownloader?Images=sheldon\">Mr. Sheldon</a></br>");
		out.println("<a href=\"ImageDownloader?Images=steve\">Mr. Steve</a></br>");	
		out.println("</form>");
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");		
			}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request,response);
	}	
}