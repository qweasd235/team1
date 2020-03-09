<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>


<style>
#btnListAll {
	background-color: green;
}

#b_title {
	background-color: white;
}


</style>

<script>
$(function() {
	$(".font_color").css("color", "black");
	$("#btnListAll").click(function() {	
		location.href = "/freeboard/freeBoardList";
	});
	
	$("#btnSubmit").click(function() {
		var b_content = CKEDITOR.instances.b_content.getData();
		if ($("#b_title").val() == "") {
			$("#b_title_span").text("제목을 입력해 주세요.").css("color", "yellow");
			$("#b_title").focus();
			return false;
		} else if (b_content == "") {
			alert("내용을 입력해 주세요");
			CKEDITOR.instances.b_content.focus();
			return false;
		}
				
	});
	
});	
</script>

<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
	<div class="inner">
	<article class="box">
	<!-- Main -->

	<h3>글쓰기</h3>
	<form id="form" method="post" action="/freeboard/fbRegisterPOST" enctype="multipart/form-data">	
		<div class="row uniform">
			<div class="12u$">
				<input type="text" name="b_title" id="b_title" placeholder="제목" class="font_color"/>
				<span id="b_title_span"></span>
			</div>					
			<div class="12u$">
<!-- 			<textarea name="b_content" id="b_content" placeholder="내용" rows="6"></textarea>	 -->

			<textarea class="form-control" id="b_content" name="b_content"></textarea>
			
<script type="text/javascript">
   CKEDITOR.replace('b_content' 
                  , {height: 200,  
 	 			   width: 900 
                  });    

</script>

			</div>
			<div class="12u$">
				<input type="file" name="file" id="b_pic"/>
			</div>
			<!-- Break -->
			<div class="12u$">
				<ul class="actions">
					<li>
						<input type="submit" value="작성완료" id="btnSubmit"/>
						<button type="button" 
								id="btnListAll">목록가기</button>
					</li>
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