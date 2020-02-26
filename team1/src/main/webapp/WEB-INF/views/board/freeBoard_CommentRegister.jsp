<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
	<div class="inner">
	<article class="box">
	<!-- Main -->
${fb_vo}
	<h3>답글쓰기</h3>
	<form method="post" action="/board/fbCommentPOST" enctype="multipart/form-data">	
			<input type="hidden" name="b_ref" value="${fb_vo.b_ref}"/>
			<input type="hidden" name="b_step" value="${fb_vo.b_step}"/>
			<input type="hidden" name="b_level" value="${fb_vo.b_level}"/>
		<div class="row uniform">
			<div class="12u$">
				<input type="text" name="b_title" id="b_title" placeholder="제목" />
			</div>					
			<div class="12u$">
				<textarea name="b_content" id="b_content" placeholder="내용" rows="6">${fb_vo.b_content}</textarea>
			</div>
			<div class="12u$">
				<input type="file" name="file" id="b_pic"/>
			</div>
			<!-- Break -->
			<div class="12u$">
				<ul class="actions">
					<li><input type="submit" value="작성완료" /></li>
					<li><input type="reset" value="초기화" class="alt" /></li>
				</ul>
			</div>
		</div>
	</form>

	</article>
	</div>
	<br><br><br>   
	

</section>


<%@ include file="../include/footer.jsp" %>