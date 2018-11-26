<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="../../../../css/customer.css" type="text/css" rel="stylesheet" />
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
						<li id="home">
							<a href="">HOME</a>
						</li>
						<li>
							<a href="">고객센터</a>
						</li>
						<li>
							<a href="">공지사항</a>
						</li>
					</ul>
					<div id="notice-article-detail" class="article-detail margin-large" >						
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								제목
							</dt>
							<dd class="article-detail-data">
								${n.title}
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								작성일
							</dt>
							<dd class="article-detail-data">
								${n.regDate}
							</dd>
						</dl>
						<dl class="article-detail-row half-row">
							<dt class="article-detail-title">
								작성자
							</dt>
							<dd class="article-detail-data half-data" >
								${n.writerId}
							</dd>
						</dl>
						<dl class="article-detail-row half-row">
							<dt class="article-detail-title">
								조회수
							</dt>
							<dd class="article-detail-data half-data">
								${n.hit}
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								첨부파일
							</dt>
							<dd class="article-detail-data">
								<a href="../../upload/aa.jpg" download>aa.png</a>
							</dd>
						</dl>

						<div class="article-content" >
							<img src="../../upload/aa.jpg" /><br />
								${n.content}

						</div>
					</div>
					<p class="article-comment margin-small">
						<a class="btn-list button" href="notice.jsp">목록</a>						
						<a class="btn-edit button" href="edit?id=${n.id }">수정</a>
						<a class="btn-del button" href="noticeDel.jsp">삭제</a>
					</p>
					<div class="margin-small" style="border-top: 1px solid #dfdfdf;">
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								▲ 다음글
							</dt>
							<dd class="article-detail-data">
								다음 글이 없습니다.
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								▼ 이전글
							</dt>
							<dd class="article-detail-data">
								${nextTitle}
							</dd>
						</dl>
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

