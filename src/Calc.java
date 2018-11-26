import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/add")
public class Calc extends HttpServlet{
	/*
    
	    ����
	    �ڹ����α׷� + �� ���/�Է�
	    ��� : response->��Ʈ��, ������ ����, ���ڵ�
	    �Է� : ��û�� �� �Է�->��û GET, POST
	    GET ��û�� �� �����ϴ� ���� ���� : �޶�� �Ϳ� ���� �ɼ�
	    POST ��û�� �� �����ϴ� ���� ���� : ���, ���, � ó���� �䱸�ϴ� ������
	    
	    POST ��û�� ���� GET�� �����Ѵ�.
	     �ݴ�� ���ϸ�->GET ��û�� ���� �ɼ� POST�� ������ ���� �ִ�.
	             ��, ���ϴ� ������ �Է´���(Form)�� ���ؼ� ���ϴ� ������ "����(POST)"���� �� �ִ�.
	    
    
    */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
//		PrintWriter out = resp.getWriter();
		int x = 0;
		int y = 0;
		int res = 0;
		//forward ��û��
		/*Object res_ = req.getAttribute("res");
		if(res_ != null)
			res = Integer.parseInt(res_+"");*/
		
		String res_ = req.getParameter("r");
		if(res_ != null)
			res = Integer.parseInt(res_);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("add.jsp");
		
		req.setAttribute("sum", res);
		
		dispatcher.forward(req, resp);
		
//		out.write("<!DOCTYPE html>");
//		out.write("<html>");
//		out.write("<head>");
//		out.write("<meta charset=\"UTF-8\">");
//		out.write("<title>Insert title here</title>");
//		out.write("</head>");
//		out.write("<body>");
//		out.write("		<form action=\"add\" method=\"post\">");
//		out.write("			<table border=\"1\">");
//		out.write("				<tr>");
//		out.write("					<td>");
//		out.write("						��갪�� �Է��ϼ���");
//		out.write("					</td>");
//		out.write("				</tr>");
//		out.write("				<tr>");
//		out.write("					<td>");
//		out.write("						x��<input type=\"text\" name=\"x\" value=\""+x+"\"/> ");			
//		out.write("					</td>");
//		out.write("				</tr>");				
//		out.write("				<tr>");
//		out.write("					<td>");
//		out.write("						y��<input type=\"text\" name=\"y\" value=\""+y+"\"/> ");
//		out.write("					</td>");
//		out.write("				</tr>");		
//		out.write("				<tr>");
//		out.write("					<td>");
//		out.write("						sum��<span>"+res+"</span>");
//		out.write("						<input type=\"submit\" value=\"���\"/>");
//		out.write("					</td>");
//		out.write("				</tr>");
//		out.write("			</table>");
//		out.write("		</form>");
//		out.write("		<a href=\"mypage.jsp\">����������</a>");		
//		out.write("</body>");
//		out.write("</html>");
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		String cmd = req.getParameter("act");
		
		int x = 0;
		int y = 0;
		int res = 0;		
		
		switch (cmd) {
		case "����":
			String x_ = req.getParameter("x");
			String y_ = req.getParameter("y");				
			
			if(x_ != null && y_ != null && !x_.equals("") && !y_.equals("")) {
				x = Integer.parseInt(x_);
				y = Integer.parseInt(y_);
				
				res = x+y;
				
			}
			
			break;
		case "session":
			String res1 = req.getParameter("sum");
			HttpSession session = req.getSession();
			session.setAttribute("sum", res1);
		
			break;
		case "application":
			String res2 = req.getParameter("sum");
			ServletContext application = req.getServletContext();
			application.setAttribute("sum", res2);
			
			break;
		}
		
		
		
		
		
		
		/*RequestDispatcher dispatcher = req.getRequestDispatcher("/add");
		
		req.setAttribute("res", res);
		
		dispatcher.forward(req, resp);*/
		//post ó�� forward�� �ٽ� post�� ��û�Ѵ�
		//--> ���ѷ����� ���ƹ���
		
		resp.sendRedirect("add?r="+res);	
	
	}
	
	
	/*public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		int x = 0;
		int y = 0;
		int res = 0;
		
		boolean chk = false;
		
		if(req.getMethod().equals("POST")) {
			chk = true;
		
			String x_ = req.getParameter("x");
			String y_ = req.getParameter("y");			
			
			
			
			if(x_ != null && y_ != null && !x_.equals("") && !y_.equals("")) {
				x = Integer.parseInt(x_);
				y = Integer.parseInt(y_);
				
				res = x+y;
				
			}
		}
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("		<form action=\"add\" method=\"post\">");
		out.write("			<table border=\"1\">");
		out.write("				<tr>");
		out.write("					<td>");
		out.write("						��갪�� �Է��ϼ���");
		out.write("					</td>");
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td>");
		if(chk)
			out.write("						x��<input type=\"text\" name=\"x\" value=\""+x+"\"/> ");			
		else
			out.write("						x��<input type=\"text\" name=\"x\"/>");			
		out.write("					</td>");
		out.write("				</tr>");				
		out.write("				<tr>");
		out.write("					<td>");
		if(chk)
			out.write("						y��<input type=\"text\" name=\"y\" value=\""+y+"\"/> ");
		else
			out.write("						y��<input type=\"text\" name=\"y\"/>");
		out.write("					</td>");
		out.write("				</tr>");		
		out.write("				<tr>");
		out.write("					<td>");
		out.write("						sum��<span>"+res+"</span>");
		out.write("						<input type=\"submit\" value=\"���\"/>");
		out.write("					</td>");
		out.write("				</tr>");
		out.write("			</table>");
		out.write("		</form>");
		out.write("</body>");
		out.write("</html>");
			
			
	}*/
}
