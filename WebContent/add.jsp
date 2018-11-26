<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- <%!
	private int add(int x, int y){
		return x+y;
	}
%>
<% 
	int x=3;
	int y=4;
	
	int sum = x+y;
%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add" method="post">
		<table border="1">
			<tr>
				<td>
					계산값을 입력하세요
				</td>
			</tr>
			<tr>
				<td>
					x값<input type="text" name="x"/>					
				</td>
			</tr>
			<tr>
				<td>
					y값<input type="text" name="y"/>
				</td>
			</tr>
			<tr>
				<td>
					<label>sum값:<%= request.getAttribute("sum") %> - ${param.r}</label>
					<input type="hidden" name="sum" value="${sum}">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" name="act" value="덧셈"/>
					<input type="submit" name="act" value="application"/>
					<input type="submit" name="act" value="session"/>
					<input type="submit" name="act" value="cookie"/>
				</td>
			</tr>
			<tr>
				<td>
					<a href="mypage.jsp">마이페이지</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>