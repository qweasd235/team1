<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
	<div class="inner">
	<article class="box">
	<!-- Main -->

	<h3>글쓰기</h3>
	<form method="post" action="/board/fbRegisterPOST" enctype="multipart/form-data">	
		<div class="row uniform">
			<div class="12u$">
				<input type="text" name="b_title" id="b_title" placeholder="제목" />
			</div>					
			<div class="12u$">
				<textarea name="b_content" id="b_content" placeholder="내용" rows="6"></textarea>
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
	<c:forEach begin="1" end="5">
		<br> 
	</c:forEach>

</section>


<%@ include file="../include/footer.jsp" %>