<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="../../../css/customer.css" type="text/css" rel="stylesheet" />
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
					<h3 class="hidden">방문페이지위치</h3>
					<ul id="breadscrumb" class="block_hlist">
						<li>HOME</li>
						<li>
							고객센터
						</li>
						<li>
							공지사항등록
						</li>
					</ul>
					<form action="" method="post" enctype="multipart/form-data"> 
						<!-- application/x-www-form-urlencoded :데이터 인코딩 방식 (텍스트만)-->
						<!-- multipart/form-data :데이터 인코딩 방식 (데이터도) ! 폼 안의 내용이 Null이 됨
							기존에는 자체적으로 http 분석을 통해 값을 얻었어야 했찌만 cos.jar를 통해 라이브러리를 제공받아서 썻지만 
							servlet 3.0이 되면서 자체적으로 값을 받는 라이브러리 제공
						-->
						<div id="notice-article-detail" class="article-detail margin-large" >						
							<dl class="article-detail-row">
								<dt class="article-detail-title">
									제목
								</dt>
								<dd class="article-detail-data">
									&nbsp;<input name="title"/>
								</dd>
							</dl>				
													
							<dl class="article-detail-row">
								<dt class="article-detail-title">
									첨부파일
								</dt>
								<dd class="article-detail-data">
									&nbsp;<input type="file" id="txtFile" name="file" />
								</dd>
							</dl>
	
							<div class="article-content" >
								<textarea id="txtContent" class="txtContent" name="content"></textarea>
							</div>
							
						</div>
						<p class="article-comment margin-small">						
							<input class="btn-save button" type="submit" value="저장" />
							<a class="btn-cancel button" href="list">취소</a>						
						</p>
					</form>							
				</div>				
				<!-- aside -->
				<jsp:include page="../inc/aside.jsp"></jsp:include>			
			</div>
		</div>
		<!-- footer -->
		<jsp:include page="../../inc/footer.jsp" />
	</body>
</html>
