<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>    
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(function(){
	$("#btnCancel").click(function(){
		location.href = "/board/home";
	});
	$("#btnSubmit").click(function(){
		if("${memberVo.mem_id == null || memberVo.mem_pw == null}"){
			alert("아이디와 패스워드를 확인해주세요");
			$("#mem_id").focus();
			return false;
		}
	});	
});
</script>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../resources/assets/css/main.css" />
<title>로그인</title>
</head>
<body>

<!-- Main -->
	<form id="loginForm" method="post" action="/mem/loginPost">
		<h3>로그인</h3>
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" id="mem_id" name="mem_id" required/>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" id="mem_id" name="mem_pw" required/></td>
			</tr>
		</table>
			<input type="submit" value="로그인" id="btnSubmit"/>
			<input type="button" value="취소" id="btnCancel"/>
	</form>

	<hr />

</body>
</html>
<%@ include file="../include/footer.jsp" %>