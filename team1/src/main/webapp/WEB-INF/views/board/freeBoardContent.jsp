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
	
	$("#btnModify").click(function() {
		$("#b_title").prop("readonly", false).val("");
		$("#b_content").prop("readonly", false).val("");
		$(this).hide(600);
		$("button[type=submit]").show(600);
	}); 
	
	$("#btnDelete").click(function() {
		location.href = "/board/fbDelete?b_num=${fb_vo.b_num}";
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
							${memberVo}
							<h2>글 상세보기</h2>
							${fb_vo }
<!-- 							<p>01.01.2017</p> -->
						</header>
						<form id="myform" role="form" method="post" 
							  action="/board/fbModify">
							<input type="hidden" name="b_num" value="${fb_vo.b_num}"/>
<%-- 							<input type="hidden" name="page" value="${pagingDto.page}"/> --%>
<%-- 							<input type="hidden" name="perPage" value="${pagingDto.perPage}"/> --%>
						<div class="form-group">
							<label for="b_title">제목</label>
							<input type="text" class="form-control" id="b_title" 
								   name="b_title" value="${fb_vo.b_title }" style="color: black;"
								   readonly/>
						</div>
						<div class="form-group">
							<label for="b_content">내용</label><br>
							<textarea rows="5" id="b_content" class="form-control"
								name="b_content" readonly>${fb_vo.b_content }</textarea>
						</div>
						<div class="form-group">
							<label for="b_writer">글쓴이</label>
							<input type="text" class="form-control" id="b_writer" 
								name="b_writer" value="${fb_vo.b_writer }" style="color: black;"
								readonly/>
						</div>
						<hr>
						<div style="clear:both;">
						<c:if test="${memberVo.mem_id == fb_vo.b_writer}">
							<button type="submit" class="btn btn-success"
								style="display:none;">완료</button>
							<button type="button" class="btn btn-warning"
								id="btnModify">수정</button>
							<button type="button" class="btn btn-danger"
								id="btnDelete">삭제</button>
						</c:if>
							<button type="button" class="btn btn-primary"
								id="btnListAll">목록</button>
				</div>
						
						</form>
					</article>
				</div>
			</section>

<%@ include file="../include/footer.jsp" %>