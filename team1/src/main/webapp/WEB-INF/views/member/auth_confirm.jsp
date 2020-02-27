<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>    
<script>
$(function(){
	$("#btnConfirm").click(function(){
			location.href="/board/home";	
		});
	});
</script>

<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
				<div class="inner">
					<article class="box">

<!-- Main -->
			  <p class="scMessage1">인증메일을 전송하였습니다.</p>
        <p class="scMessage2">인증메일의 링크를 누르면 회원가입이 완료됩니다.</p>
        
	
			<input type="submit" value="확인" id="btnConfirm"/>
			


	<hr />

</article>
</div>
<br><br><br><br><br><br><br><br><br>       
</section>


<%@ include file="../include/footer.jsp" %>