<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>    
<!DOCTYPE html>
<html>
	<head>
		<title>회원가입</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../resources/assets/css/main.css" />
	</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

</script>	
<body>
	<!-- Main -->

	<h3>회원가입</h3>
	<form id="joinForm" method="post" action="mem/joinPost">
		
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" name="mem_name" required/></td>
			</tr>		
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mem_id" required/>
					<input type="button" value="중복확인" id="btnCheckId"/>
					<span id="resultSpan"></span>
				</td>	
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="mem_pw" required/></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="password" name="mem_pw2" required/></td>
			</tr>
		</table>
			<input type="submit" value="가입완료"/>
			<input type="button" value="취소"/>
	</form>

	<hr />
	


		<!-- Scripts -->
			<script src="../resources/assets/js/jquery.min.js"></script>
			<script src="../resources/assets/js/jquery.scrolly.min.js"></script>
			<script src="../resources/assets/js/jquery.scrollex.min.js"></script>
			<script src="../resources/assets/js/skel.min.js"></script>
			<script src="../resources/assets/js/util.js"></script>
			<script src="../resources/assets/js/main.js"></script>
</body>
</html>