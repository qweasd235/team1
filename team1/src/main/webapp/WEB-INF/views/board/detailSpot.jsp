<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>    
<style>
img{
	width : 900px;
	height : 450px;
}
.content{
	width : 900px;
}
</style>    
    
<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
				<div class="inner">
					<article class="box">
						<header>
							<h2>${vo.s_name}</h2>
							<p>${vo.s_add}</p>
						</header>
						<div class="spot_photo">
							<img alt='Bootstrap Image Preview' 
								 	src='/board/displayFile?fileName=${vo.s_pic}'/>
						</div>
						<div class="content">
							${vo.s_detail}
						</div>
					</article>
				</div>
			</section>

<%@ include file="../include/footer.jsp" %>