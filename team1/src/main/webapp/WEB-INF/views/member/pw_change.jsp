<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %> 
<style>

</style>

<script>
var msg = "${msg}";
if (msg == "pw_change_fail") {
	alert("현재 비밀번호가 틀렸습니다.");
}else if(msg == "pw_not_equal"){
	alert("변경할 비밀번호와 변경할 비밀번호 확인을 똑같이 입력해주세요.");
}

$(document).ready(function(){
	$("#btnCancel").click(function(){
		location.href = "/board/home";
	});
	$("#mem_pw2").keyup(function(){
		if($("#mem_pw").val() != $("#mem_pw2").val()){
			if($("#mem_pw2").val() != ""){
				$("#pwSpan").text("패스워드가 일치하지 않습니다.");
				$("#mem_pw2").focus();
			}
		}else{
			$("#pwSpan").text("패스워드가 일치합니다.");
		}
	});	
	
});
</script>	

<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
				<div class="inner">
					<article class="box">

	<!-- Main -->
	<h3>비밀번호 변경</h3>
	<form id="joinForm" method="post" action="/mem/pw_changePost" autocomplete="off" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>현재 비밀번호</th>
				<td><input type="password" name="old_mem_pw" id="old_mem_pw" required/></td>
			</tr>
			<tr>
				<th>변경할 비밀번호</th>
				<td><input type="password" name="mem_pw" id="mem_pw" required/></td>
			</tr>
			<tr>
				<th>변경할 패스워드 확인</th>
				<td><input type="password" name="mem_pw2" id="mem_pw2" required/>
					<span id="pwSpan"></span>
				</td>
			</tr>
		</table>
			<input type="submit" value="완료" id="btnSubmit"/>
			<input type="button" value="취소" id="btnCancel"/>
	</form>

	<hr />
	</article>
	<c:forEach begin="1" end="7">
		<br>
	</c:forEach>
	</div>
	</section>
<%@ include file="../include/footer.jsp" %>