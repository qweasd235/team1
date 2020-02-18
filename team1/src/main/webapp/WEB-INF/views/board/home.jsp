<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<script src="https://unpkg.com/swiper/js/swiper.min.js"></script>



<style>
img{
	width : 800px;
	height : 300px;
}


.swiper-container{
	width:901px;
	height:358px;
}
.swiper-slide{
	  display: -webkit-box;
      display: -ms-flexbox;
      display: -webkit-flex;
      display: flex;
      -webkit-box-pack: center;
      -ms-flex-pack: center;
      -webkit-justify-content: center;
      justify-content: center;
      -webkit-box-align: center;
      -ms-flex-align: center;
      -webkit-align-items: center;
      align-items: center;
}


</style>

<script>
$(document).ready(function() {
	new Swiper('.swiper-container', {
		navigation : {
			nextEl : '.swiper-button-next', // 다음 버튼 클래스명
			prevEl : '.swiper-button-prev', // 이번 버튼 클래스명
		},
	});
});
</script>


		<!-- Banner -->
		<!--
			Note: To show a background image, set the "data-bg" attribute below
			to the full filename of your image. This is used in each section to set
			the background image.
		-->
			<section id="banner" class="bg-img" data-bg="banner.jpg">
				<div class="inner">
					<header>
						<h1>Team1 Project</h1>
						<p>경복궁</p>
					</header>
				</div>
				<a href="#one" class="more">Learn More</a>
			</section>

		<!-- One -->
			<section id="one" class="wrapper post bg-img" data-bg="banner2.jpg">
				<div class="inner">
					<article class="box">
						<header>
							<h2>강원도</h2>
						</header>
						<div class="swiper-container">
							<div class="swiper-wrapper">

								<div class="swiper-slide">
									<img src="../resources/images/mountain.png">
								   <img src="../resources/images/monorail.png">
								   <img src="../resources/images/Daegeumgul.png">
								</div>
								<div class="swiper-slide">								
							       <img src="../resources/images/mountain.png">
								   <img src="../resources/images/monorail.png">
								   <img src="../resources/images/food1.png">
								</div>
								<div class="swiper-slide">
								   <img src="../resources/images/gyeongsang.png">
								   <img src="../resources/images/jeonlado.PNG">
								   <img src="../resources/images/ulsan.PNG">
								</div>
								<div class="swiper-slide">
									<img src="../resources/images/banner5.png">
									<img src="../resources/images/ulsan.PNG">
								    <img src="../resources/images/gyeongsang3.png">
								</div> 								

									<c:forEach items="${list}" var= "vo">
										<c:if test="${vo.s_cate == '강원도'}">
											<div class="swiper-slide">
												<img src="/board/displayFile?fileName=${vo.s_pic}">
											</div>
										</c:if>
								</c:forEach>	

							</div>
							<div class="swiper-button-prev"></div>
							<div class="swiper-button-next"></div>
						</div>
						<footer>					
							<a href="/board/detail?s_cate=강원도" class="button alt">Learn More</a>
						</footer>
					</article>
				</div>
				<a href="#two" class="more">Learn More</a>
			</section>

		<!-- Two -->
			<section id="two" class="wrapper post bg-img" data-bg="banner5.png">
				<div class="inner">
					<article class="box">
						<header>
							<h2>경상도</h2>
						</header>
						<div class="swiper-container">
							<div class="swiper-wrapper">
									<c:forEach items="${list}" var= "vo">
										<c:if test="${vo.s_cate == '경남'}">
											<div class="swiper-slide">
												<img src="/board/displayFile?fileName=${vo.s_pic}">
											</div>
										</c:if>
								</c:forEach>	
							</div>	
							<div class="swiper-button-prev"></div>
							<div class="swiper-button-next"></div>
						</div>	
						<footer>
							<a href="/board/detail?s_cate=경남" class="button alt">Learn More</a>
						</footer>
					</article>
				</div>
				<a href="#three" class="more">Learn More</a>
			</section>

		<!-- Three -->
			<section id="three" class="wrapper post bg-img" data-bg="banner4.png">
				<div class="inner">
					<article class="box">
						<header>
							<h2>충청/전라</h2>
						</header>
						<div class="swiper-container">
							<div class="swiper-wrapper">
									<c:forEach items="${list}" var= "vo">
										<c:if test="${vo.s_cate == '충청/전라'}">
											<div class="swiper-slide">
												<img src="/board/displayFile?fileName=${vo.s_pic}">
											</div>
										</c:if>
								</c:forEach>	
							</div>
							<div class="swiper-button-prev"></div>
							<div class="swiper-button-next"></div>	
						</div>	
						<footer>
							<a href="/board/detail?s_cate=충청/전라" class="button alt">Learn More</a>
						</footer>
					</article>
				</div>
				<a href="#four" class="more">Learn More	</a>
			</section>

		<!-- Four -->
			<section id="four" class="wrapper post bg-img" data-bg="banner3.png">
				<div class="inner">
					<article class="box">
						<header>
							<h2>서울/경기</h2>
						</header>
						<div class="swiper-container">
							<div class="swiper-wrapper">
									<c:forEach items="${list}" var= "vo">
										<c:if test="${vo.s_cate == '서울/경기'}">
											<div class="swiper-slide">
												<img src="/board/displayFile?fileName=${vo.s_pic}">
											</div>
										</c:if>
								</c:forEach>	
							</div>
							<div class="swiper-button-prev"></div>
							<div class="swiper-button-next"></div>		
						</div>	
						<footer>
							<a href="/board/detail?s_cate=서울/경기" class="button alt">Learn More</a>
						</footer>
					</article>
				</div>
			</section>



<%@ include file="../include/footer.jsp" %>