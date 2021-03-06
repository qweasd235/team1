<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %> 
<style>

</style>

<script>
$(document).ready(function(){
	$(".changeColor").css("background-color", "white")
					 .css("color", "black");
	
	
	$("#btnCancel").click(function(){
		location.href = "/board/home"
	});
		
	$("#btnSubmit").click(function(){
		if($("#mem_id").val() == ""){
			alert("아이디를 입력해 주세요.");
			$("#mem_id").focus();
			return false;
		}
		if($("#mem_pw").val()==""){
			alert("비밀번호를 입력해주세요.");
			$("#mem_pw").focus();
			return false;
		}
		
		if($("#mem_name").val()==""){
			alert("성명을 입력해주세요.");
			$("#mem_name").focus();
			return false;
		}
		
		if($("#mem_email").val()==""){
			alert("이메일을 입력해주세요.");
			$("#mem_email").focus();
			return false;
		}
		
		if(isCheckId == false){
			alert("아이디 중복을 체크해 주세요.");
			return false;
		}		
		
		if($("#mem_pw").val() != $("#mem_pw2").val()){
			alert("패스워드와 패스워드 확인을 동일하게 입력해주세요.");
			$("#mem_pw2").focus();
			return false;
		}
				
		var mem_id = $("input[name=mem_id]").val();
		console.log("--------------------");
		for(var v = 0; v < mem_id.length; v++){
			var keyCode = mem_id.charCodeAt(v); // 해당위치번째 문자의 코드값
// 			console.log(keyCode);
			if(!(65 <= keyCode && keyCode <= 90) &&  	//영소문자가 아니고
					!(48 <= keyCode && keyCode <= 57) &&
					!(97 <= keyCode && keyCode <= 122)){	//숫자가 아니면
				alert("유효하지 않은 아이디\n영소문자와 숫자 조합으로 입력");
				$("input[name=mem_id]").val("").focus();
				return false; //for 종료, 폼 전송 X
			}
		}
	});	
	
	
		var isCheckId = false;
		$("#btnCheckId").click(function(){
			var mem_id = $("input[name=mem_id]").val();
			var url = "/mem/checkId";
			var sendData = {
					"mem_id" : mem_id
			};
			$.post(url, sendData, function(receivedData){
				var v = receivedData; 
// 				console.log(receivedData);
				if(v == 1){
					$("#resultSpan").text("사용중인 아이디");
					isCheckId = false;
				}else if (v == 0){
					$("#resultSpan").text("사용가능한 아이디");
					isCheckId = true;
				}
			});	// $.get
		}); // $(#btnCheckId)

	
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
}); //ready
</script>	

<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
				<div class="inner">
					<article class="box">

	<!-- Main -->

	<h3>회원가입</h3>
	<form id="joinForm" method="post" action="/mem/joinPost" autocomplete="off" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mem_id" id="mem_id" required/>
					<input type="button" value="중복확인" id="btnCheckId"/>
					<span id="resultSpan"></span>
				</td>	
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" name="mem_pw" id="mem_pw" required/></td>
			</tr>
			<tr>
				<th>패스워드 확인</th>
				<td><input type="password" name="mem_pw2" id="mem_pw2" required/>
					<span id="pwSpan"></span>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="mem_name" id="mem_name" required/></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="mem_email" id="mem_email" required/></td>
			</tr>
			<tr>
				<th>프로필 사진</th>
				<td><input type="file" name="file" id="mem_pic"/></td>
			</tr>	
		</table>
			<input type="submit" value="가입완료" id="btnSubmit"/>
			<input type="button" value="취소" id="btnCancel"/>
	</form>

	<hr />

	</article>
	</div>
	</section>
<%@ include file="../include/footer.jsp" %>