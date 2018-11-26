<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="../../css/notice.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<!-- header -->
		<jsp:include page="../../inc/header.jsp" />
		<div id="visual" class="customer">
			<div class="top-wrapper">

			</div>
		</div>
		<div id="main">
			<div class="top-wrapper clear">
				<div id="content">
					<h2>공지사항</h2>
					<h3 class="hidden">방문페이지 로그</h3>
					<ul id="breadscrumb" class="block_hlist clear">
						<li>HOME</li>
						<li>
							고객센터
						</li>
						<li>
							공지사항목록
						</li>
					</ul>
					<h3 class="hidden">공지사항 목록</h3>
					<form id="content-searchform" class="article-search-form" action="notice.jsp" method="get">
						<fieldset>
							<legend class="hidden">
								목록 검색 폼
							</legend>
							<input type="hidden" name="pg" value="" />
							<label for="f"
							class="hidden">검색필드</label>
							<select name="f">
								<option value="TITLE">제목</option>
								<option value="CONTENT">내용</option>
							</select>
							<label class="hidden" for="q">검색어</label>
							<input type="text"
							name="q" value="" />
							<input type="submit" value="검색" />
						</fieldset>
					</form>
					<table class="article-list margin-small">
						<caption class="hidden">
							공지사항
						</caption>
						<thead>
							<tr>
								<th class="seq">번호</th>
								<th class="title">제목</th>
								<th class="writer">작성자</th>
								<th class="regdate">작성일</th>
								<th class="hit">조회수</th>
							</tr>
						</thead>
						<tbody>

						<c:forEach var="notice" items="${list}">
							<tr>
								<td class="seq">${notice.id}</td>
								<td class="title"><a href="detail?id=${notice.id}">${notice.title}</a></td>
								<td class="writer">${notice.writerId}</td>
								<td class="regdate">${notice.regDate}</td>
								<td class="hit">${notice.hit}</td>
							</tr>
						</c:forEach>	

						</tbody>
					</table>
					<p class="article-comment margin-small">
						<a class="btn-write button" href="reg">글쓰기</a>
					</p>
					<p id="cur-page" class="margin-small">
						<span class="strong">1</span> /
						10	page
					</p>
					<div id="pager-wrapper" class="margin-small">
						<div class="pager clear">
							<p id="btnPrev">
								<a class="button btn-prev"
								href="notice.jsp">이전</a>
							</p>
							<ul>
							<c:forEach var="i" begin="1" end="5">
								<c:set var="cls" value="${i==(empty param.p?1:param.p)?'strong':''}"/>							
								<li>								
									<a class="${cls}" href="?p=${i}">${i}</a>
								</li>
							</c:forEach>
							</ul>
							<p id="btnNext">
								<span class="button btn-next">다음</span>
							</p>
						</div>
					</div>
				</div>
				<!-- aside -->
				<jsp:include page="../inc/aside.jsp"></jsp:include>
			</div>
		</div>
		<!-- footer -->
		<jsp:include page="../../inc/footer.jsp" />
	</body>
</html>