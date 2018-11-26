package com.newlecture.web.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;

@WebServlet("/customer/notice/edit")
public class NoticeEditController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String sql = "SELECT * FROM NOTICE WHERE ID="+id;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);			
			rs.next();
			Notice n = new Notice(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getString("writer_id"),
					rs.getDate("regdate"),
					rs.getInt("hit")
					
					);
			
			request.setAttribute("n", n);
			
			rs.close();
			st.close();
			con.close();
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customer/notice/edit.jsp");
			
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String sql = "UPDATE NOTICE SET TITLE = ?, CONTENT = ? WHERE ID = ?";
	}
}
