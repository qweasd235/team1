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
	
	$("#freeBoard").on("click", ".content", function() {
		console.log("clicked freeboard");
		$("#modal-a").trigger("click");
		
		var b_num = $(this).attr("data-b_num");
		console.log(b_num);	
		
	});
	
	
	
});
</script>

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
			
<!-- 	상세보기 모달 창 -->			
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			 <a id="modal-a" href="#modal-container" role="button" class="btn" data-toggle="modal"
			 	>Launch demo modal</a>
			
			 <div class="modal fade" id="modal-container" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="myModalLabel">
								상세보기
							</h5> 
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						
						<div class="modal-footer">
							
							<button type="button" class="btn btn-secondary" data-dismiss="modal"
								id="btnModalClose">
								닫기
							</button>
						</div>
					</div>
					
				</div>
				
			</div>
			
		</div>
	</div>
</div>
			

	
<%@ include file="../include/footer.jsp" %>