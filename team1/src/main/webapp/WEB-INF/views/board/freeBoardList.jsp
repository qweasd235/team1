<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>

<script>
$(document).ready(function() {
	$("#btnRegister").click(function() {
		location.href = "/board/fbRegisterGet";
	});
});
</script>

		<!-- Content -->
		<!--
			Note: To show a background image, set the "data-bg" attribute below
			to the full filename of your image. This is used in each section to set
			the background image.
		-->
			<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
				<div class="inner">
					<article class="box">
						<header>
							<h2>자유 게시판</h2>
							<button type="button" id="btnRegister" class="btn btn-danger">글쓰기</button>
							<br><br>							
<!-- 							<p>01.01.2017</p> -->
						</header>
						<table>
							<thead>
								<tr>
									<th>글번호</th>
									<th>글제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>조회수</th>
								</tr>
							</thead>
							<tbody>
			<!-- 게시판 글목록 -->					
								<c:forEach items="${list}" var="fb_vo">
								<tr>
									<td>${fb_vo.b_num}</td>
									<td>${fb_vo.b_title}</td>
									<td>${fb_vo.b_writer}</td>
									<td>${fb_vo.b_regdate}</td>
									<td>${fb_vo.b_read_count}</td>
								</tr>
								</c:forEach>
								
							</tbody>
					</table>
					</article>
				</div>
			</section>

<%@ include file="../include/footer.jsp" %>