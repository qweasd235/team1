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
.box .detail_info ul il strong{
	display : table-cell;
}
hr{
	margin : 25px;
}
strong{
	width : 95.66px;
}
.title{
	
}

a{
	color : white;
}
span{
	margin-left : 20px;
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
						<hr>
						<div class="content">
							${vo.s_detail}
						</div>
						<hr>
						<div class="detail_info">
							<h4>상세정보</h4>
							<ul>
								<c:if test="${not empty vo.s_tel}">
								<li>
									<strong id="info">문의 및 안내</strong>
									<span>${vo.s_tel}</span>
								</li>
								</c:if>
								<c:if test="${not empty vo.s_homepage}">
								<li>
									<strong class="title">홈페이지</strong>
									<span>
										<a href="http://www.cheongpungcablecar.com/" target="_blank">${vo.s_homepage}</a>
									</span>
								</li>
								</c:if>
								<c:if test="${not empty vo.s_holiday}">
								<li>
									<strong>휴무일</strong>
									<span>${vo.s_holiday}</span>
								</li>
								</c:if>
								<c:if test="${not empty vo.s_worktime}">
								<li>
									<strong>이용시간</strong>
									<span>${vo.s_worktime}</span>
								</li>
								</c:if>
								<c:if test="${not empty vo.s_cost}">
								<li>
									<strong>입장료</strong>
									<span>${vo.s_cost}</span>
								</li>
								</c:if>
							</ul>
						</div>
					</article>
				</div>
			</section>

<%@ include file="../include/footer.jsp" %>