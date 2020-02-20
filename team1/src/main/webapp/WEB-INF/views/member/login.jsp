<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>    
<script>
$(function(){
	
	var msg = "${msg}";
	if (msg == "login_fail") {
		alert("로그인 실패");
	}
	
	$(".changeColor").css("background-color", "white")
	 				 .css("color", "black");
	
	$("#btnCancel").click(function(){
		location.href = "/board/home";
	});
	
});
</script>
<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
				<div class="inner">
					<article class="box">
<body>

<!-- Main -->
	<form id="loginForm" method="post" action="/mem/loginPost">
		<h3>로그인</h3>
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input class="changeColor" type="text" id="mem_id" name="mem_id" required/>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input class="changeColor" type="password" id="mem_id" name="mem_pw" required/></td>
			</tr>
		</table>
			<input type="submit" value="로그인" id="btnSubmit"/>
			<input type="button" value="취소" id="btnCancel"/>
	</form>

	<hr />

</body>
</article>
</div>
</section>
</html>
<%@ include file="../include/footer.jsp" %>