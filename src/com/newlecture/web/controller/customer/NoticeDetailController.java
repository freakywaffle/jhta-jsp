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


@WebServlet("/customer/notice/detail")
public class NoticeDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id_ = request.getParameter("id");
	
			int id = Integer.parseInt(id_);
	
			
			String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
			String sql = "SELECT * FROM NOTICE WHERE ID="+id;
			String sql2 = "select * from notice where id = (select max(id) from notice where id<"+id+")";
			
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
			ResultSet rs2 = st.executeQuery(sql2);
			rs2.next();
			String ntitle = rs2.getString("title");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customer/notice/detail.jsp");
			
			request.setAttribute("n", n);
			request.setAttribute("nextTitle", ntitle);
			dispatcher.forward(request, response);
			
			
			rs.close();
			rs2.close();
			st.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
