<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<script>
$(document).ready(function(){
	$("#btnCancel").click(function(){
		location.href = "/board/home";
	});
	
	$("#pw_change").click(function(){
		location.href = "/mem/pw_changeGet";
	});
	$("#btnSubmit").click(function(){
		if($("mem_email").val == ""){
			alert("변경할 이메일 주소를 입력해주세요.");
			$("#mem_email").focus();
			return false;
		}	
	});
	
	
	$("#delPic").click(function(){
		console.log("clcikDEl");
			var url = "/mem/deletePic";
			
			$.get(url, function(rData) {
				console.log(rData);
				alert("삭제되었습니다");
				
			});
//				$.ajax({
//					"type" : "put",
//					"url" : url,
//					"headers" : {
//						"Content-Type" : "application/json",
//						"X-HTTP-Method-Override" : "put"
//					},
//					"dataType" : "text",
//					"success" : function(rData) {
//					console.log(rData);
//					alert("삭제되었습니다");
//					}
//				})
	});
});
</script> 
   
   <section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
				<div class="inner">
					<article class="box">
			
			<!-- Main -->


	<h3>회원정보 수정</h3>
	<form id="editForm" method="post" action="/mem/editmemPost" autocomplete="off" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" name="mem_name" value="${memberVo.mem_name}" readonly/></td>
			</tr>		
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mem_id" value="${memberVo.mem_id}" readonly/></td>	
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="mem_email" id="mem_email" value="${memberVo.mem_email}"></td>
			</tr>
			<tr>
				<th>프로필 사진</th>
				<td><input type="file" name="file" id="mem_pic"/></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="button" id="pw_change" value="비밀번호 변경"/></td>
			</tr>
			<tr>
				<th>프로필 사진 삭제</th>
				<td><input type="button" id="delPic" value="프로필 사진 삭제"/></td>			
			</tr>
		</table>
			<input type="submit" value="수정완료" id="btnSubmit"/>
			<input type="button" value="취소" id="btnCancel"/>
	</form>
			
			<hr />

	
	</article>
	</div>
	</section>
<%@ include file="../include/footer.jsp" %>
