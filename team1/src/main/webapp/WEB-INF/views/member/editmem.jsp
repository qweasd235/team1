<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %> 
    

<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
				<div class="inner">
					<article class="box">
<body>					
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
				<td><input type="email" name="mem_email" value="${memberVo.mem_email}"></td>
			</tr>
			<tr>
				<th>프로필 사진</th>
				<td><input type="file" name="file" id="mem_pic"/></td>
			</tr>	
			<tr>
				<td><button>프로필 사진 삭제</button></td>
			</tr>	
		</table>
			<input type="submit" value="수정완료" id="btnSubmit"/>
			<input type="button" value="취소" id="btnCancel"/>
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
	</article>
	</div>
	</section>
