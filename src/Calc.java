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
    
	    서블릿
	    자바프로그램 + 웹 출력/입력
	    출력 : response->스트림, 콘텐츠 종류, 인코딩
	    입력 : 요청할 때 입력->요청 GET, POST
	    GET 요청일 때 전달하는 값의 성절 : 달라는 것에 대한 옵션
	    POST 요청일 때 전달하는 값의 성질 : 계산, 등록, 어떤 처리를 요구하는 데이터
	    
	    POST 요청일 때는 GET을 수반한다.
	     반대로 말하면->GET 요청일 때는 옵션 POST를 수반할 수도 있다.
	             즉, 원하는 내용을 입력대장(Form)을 통해서 원하는 내용을 "제출(POST)"받을 수 있다.
	    
    
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
		//forward 요청시
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
//		out.write("						계산값을 입력하세요");
//		out.write("					</td>");
//		out.write("				</tr>");
//		out.write("				<tr>");
//		out.write("					<td>");
//		out.write("						x값<input type=\"text\" name=\"x\" value=\""+x+"\"/> ");			
//		out.write("					</td>");
//		out.write("				</tr>");				
//		out.write("				<tr>");
//		out.write("					<td>");
//		out.write("						y값<input type=\"text\" name=\"y\" value=\""+y+"\"/> ");
//		out.write("					</td>");
//		out.write("				</tr>");		
//		out.write("				<tr>");
//		out.write("					<td>");
//		out.write("						sum값<span>"+res+"</span>");
//		out.write("						<input type=\"submit\" value=\"계산\"/>");
//		out.write("					</td>");
//		out.write("				</tr>");
//		out.write("			</table>");
//		out.write("		</form>");
//		out.write("		<a href=\"mypage.jsp\">마이페이지</a>");		
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
		case "덧셈":
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
		//post 처리 forward는 다시 post를 요청한다
		//--> 무한루프를 돌아버림
		
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
		out.write("						계산값을 입력하세요");
		out.write("					</td>");
		out.write("				</tr>");
		out.write("				<tr>");
		out.write("					<td>");
		if(chk)
			out.write("						x값<input type=\"text\" name=\"x\" value=\""+x+"\"/> ");			
		else
			out.write("						x값<input type=\"text\" name=\"x\"/>");			
		out.write("					</td>");
		out.write("				</tr>");				
		out.write("				<tr>");
		out.write("					<td>");
		if(chk)
			out.write("						y값<input type=\"text\" name=\"y\" value=\""+y+"\"/> ");
		else
			out.write("						y값<input type=\"text\" name=\"y\"/>");
		out.write("					</td>");
		out.write("				</tr>");		
		out.write("				<tr>");
		out.write("					<td>");
		out.write("						sum값<span>"+res+"</span>");
		out.write("						<input type=\"submit\" value=\"계산\"/>");
		out.write("					</td>");
		out.write("				</tr>");
		out.write("			</table>");
		out.write("		</form>");
		out.write("</body>");
		out.write("</html>");
			
			
	}*/
}
