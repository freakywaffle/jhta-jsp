package com.newlecture.web.controller.customer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.entity.Notice;


@WebServlet("/customer/notice/reg")
@MultipartConfig(
	fileSizeThreshold = 1024*1024, // 1메가 이하는 메모리로 처리
	maxFileSize = 1024*1024*10, //10메가
	maxRequestSize = 1024*1024*10*5  //10메가 5개까지
)
public class NoticeRegController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/customer/notice/reg.jsp");

		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String path = request.getServletContext().getRealPath("/upload");	//베포되는 폴더에 있는 upload (workspace가 아님)
		System.out.println(path);
		
		String filePath = path + File.separator + "aa.jpg";
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Part part = request.getPart("file");// servlet 3 에서 생긴 기능
		
		InputStream fis = part.getInputStream();
		OutputStream fos = new FileOutputStream(filePath); 

		byte[] buf = new byte[1024];
		int size = 1024;		
		
		while((size = fis.read(buf)) != -1) {
			fos.write(buf, 0, size);
		}
		
		fos.flush();
		fos.close();
		
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String sql = "INSERT INTO NOTICE(ID, TITLE, WRITER_ID, CONTENT) VALUES(NOTICE_SEQ.NEXTVAL, ?, ?, ?)";
		
		try {	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");		
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, title);
			st.setString(2, "hyungho");
			st.setString(3, content);
			int affected = st.executeUpdate();
			
			st.close();
			con.close();
			
			response.sendRedirect("list");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
