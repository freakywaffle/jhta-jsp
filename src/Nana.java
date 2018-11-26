import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/hello")
public class Nana extends HttpServlet
{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		PrintWriter out = response.getWriter();

		int cnt = 3;
		
		
		String cnt_ = request.getParameter("cnt");
		
		if(cnt_ != null&&!cnt_.equals(""))
			cnt = Integer.parseInt(cnt_);
		
		for (int i = 0; i < cnt; i++) {
			
			out.println((i+1)+"¾È³ç servlet!!<br/>");
		}
		
	}
}