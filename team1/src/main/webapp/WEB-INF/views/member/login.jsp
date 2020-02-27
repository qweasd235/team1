<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>    
<script>
$(function(){
	
	var msg = "${msg}";
	if (msg == "notVerify") {
		alert("이메일 인증을 하지 않으셨습니다. 가입하실때 입력하신 이메일을 확인해주세요");
	}else if(msg == "notCorrect"){
		alert("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다");
	}
	
// 	$(".changeColor").css("background-color", "white")
// 	 				 .css("color", "black");
	
	$("#btnCancel").click(function(){
		location.href = "/board/home";
	});
	
});
</script>


<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
				<div class="inner">
					<article class="box">

<!-- Main -->
	<form id="loginForm" method="post" action="/mem/loginPost" autocomplete="off">
		<h3>로그인</h3>
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input class="changeColor" type="text" id="mem_id" name="mem_id" required/>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input class="changeColor" type="password" id="mem_pw" name="mem_pw" required/></td>
			</tr>
		</table>
			<input type="submit" value="로그인" id="btnSubmit"/>
			<input type="button" value="취소" id="btnCancel"/>
	</form>

	<hr />

</article>
</div>
<br><br><br><br><br><br><br><br><br>       
</section>


<%@ include file="../include/footer.jsp" %>