<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.min.css">

<script src="https://unpkg.com/swiper/js/swiper.min.js"></script>


<style>
img{
	width : 225.25px;
	height : 155px;
}
.swiper-container{
	width : 901px;
	height : 358px;
}
.swiper-wraper{
	position : absolute;
	left : 100px;
	top : 100px;
}

</style>

<script>
var mySwiper = new Swiper ('.swiper-container', {
	// Optional parameters 
	direction: 'vertical', 
	loop: true, 
	// If we need pagination 
	pagination: {
		el: '.swiper-pagination',
},
// Navigation arrows 
navigation: {
	nextEl: '.swiper-button-next', 
	prevEl: '.swiper-button-prev', 
}, 
// And if we need scrollbar 
scrollbar: { el: '.swiper-scrollbar', 
}, 
})

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
							<div class="swiper-wraper">
								<div class="swiper-slide">
									<img src="../resources/images/">
								   <img src="../resources/images/">
								   <img src="../resources/images/">
								</div>
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
						<div class="content">
						<p>
							<img src="../resources/images/">
							<img src="../resources/images/">
							<img src="../resources/images/">
							<!-- image는 3개만 쓰죠 -->
						</p>
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
							<h2>충북/전라도</h2>
						</header>
						<div class="content">
						<p>
							<img src="../resources/images/">
							<img src="../resources/images/">
							<img src="../resources/images/">
						</p>
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
						<div class="content">
							<p>
								<img src="../resources/images/">
								<img src="../resources/images/">
								<img src="../resources/images/">
							</p>
						</div>
						<footer>
							<a href="/board/detail?s_cate=서울/경기" class="button alt">Learn More</a>
						</footer>
					</article>
				</div>
			</section>

<%@ include file="../include/footer.jsp" %>