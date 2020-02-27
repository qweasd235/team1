<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>    

<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
				<div class="inner">
					<article class="box">

<!-- Main -->
	<script type="text/javascript">
		${vo}	
		var userName = '${mem_name}';

		alert(userName + '님 회원가입을 축하합니다. 이제 로그인이 가능 합니다.');
		console.log('123');
		window.open('', '_self', ''); // 브라우저창 닫기
		/* window.close(); // 브라우저 창 닫기 */
		self.location = '/';
		</script>
	<hr />

</article>
</div>
<br><br><br><br><br><br><br><br><br>       
</section>


<%@ include file="../include/footer.jsp" %>