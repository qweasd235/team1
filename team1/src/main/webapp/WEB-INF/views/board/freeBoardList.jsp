<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    
<style>
span, .font_color{
	color: black;
}

</style>
  
<script>
$(document).ready(function() {
	$("#btnRegister").click(function() {
		location.href = "/board/fbRegisterGet";
	});
	


	$(".title").click(function(e) {
		e.preventDefault();			
		var b_num = $(this).attr("data-b_num");
		$("input[name=b_num]").val(b_num);
		$("#frmPage").attr("action", "/board/fbRead");
		$("#frmPage").submit();
	});
	
	
});
</script>

	<form id="frmPage" action="/board/freeBoardList" method="get">
		<input type="hidden" name="b_num" />						
	</form>

		<!-- Content -->
		<!--
			Note: To show a background image, set the "data-bg" attribute below
			to the full filename of your image. This is used in each section to set
			the background image.
		-->
						
			<section id="post" class="wrapper bg-img" data-bg="wrapper bg-img" style="background-color: black;">
				<div class="inner">
					<article class="box" style="background-color: threedhighlight;">
						<header>
							<h2><span class = "font_color">자유 게시판</span></h2>																																															
							<button type="button" id="btnRegister" class="btn btn-danger">글쓰기</button>
							<br><br>							
<!-- 							<p>01.01.2017</p> -->
						</header>
						<table id="freeBoard">
							<thead>
								<tr>
									<th class="font_color">글번호</th>
									<th class="font_color">글제목</th>
									<th class="font_color">작성자</th>
									<th class="font_color">작성일</th>
									<th class="font_color">조회수</th>
								</tr>
							</thead>
							<tbody>
			<!-- 게시판 글목록 -->					
								<c:forEach items="${list}" var="fb_vo">
								<tr>
									<td>${fb_vo.b_num}</td>

									<td><a href="/board/fbRead" data-b_num="${fb_vo.b_num}" class="title">${fb_vo.b_title}</a></td>

									<td><a data-toggle="modal" data-b_num="${fb_vo.b_num}" class="content">${fb_vo.b_title}</a></td>

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