<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<%@ include file="../include/header.jsp" %>

<script>
$(document).ready(function() {
	
	$("#btnListAll").click(function() {
		location.href = "/board/freeBoardList";
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
							<h2>글 상세보기</h2>
							${fb_vo }
<!-- 							<p>01.01.2017</p> -->
						</header>
						<form id="myform" role="form" method="post" 
							  action="/board/modify">
<%-- 							<input type="hidden" name="bno" value="${boardVo.bno}"/> --%>
<%-- 							<input type="hidden" name="page" value="${pagingDto.page}"/> --%>
<%-- 							<input type="hidden" name="perPage" value="${pagingDto.perPage}"/> --%>
						<div class="form-group">
							<label for="title">제목</label>
							<input type="text" class="form-control" id="b_title" 
								   name="b_title" value="${fb_vo.b_title }"
								   readonly/>
						</div>
						<div class="form-group">
							<label for="content">내용</label><br>
							<textarea rows="5" id="b_content" class="form-control"
								name="b_content" readonly>${fb_vo.b_content }</textarea>
						</div>
						<div class="form-group">
							<label for="writer">글쓴이</label>
							<input type="text" class="form-control" id="b_writer" 
								name="b_writer" value="${fb_vo.b_writer }"
								readonly/>
						</div>
						<hr>
						<div style="clear:both;">
							<button type="submit" class="btn btn-success"
								style="display:none;">완료</button>
							<button type="button" class="btn btn-warning"
								id="btnModify">수정</button>
							<button type="button" class="btn btn-danger"
								id="btnDelete">삭제</button>
							<button type="button" class="btn btn-primary"
								id="btnListAll">목록</button>
				</div>
						
						</form>
					</article>
				</div>
			</section>

<%@ include file="../include/footer.jsp" %>