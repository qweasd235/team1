<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<style>
img{
	width : 250px;
	height : 150px;
}
</style>


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
						<div class="content">
						<p><img src="../resources/images/monorail.png">
						   <img src="../resources/images/mountain.png">
						   <img src="../resources/images/Daegeumgul.png">
<!-- 						   <img src="../resources/images/Skywalk.png"> 이거는 사진이 너무커서 안씀-->
						</p>
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
							<img src="../resources/images/ulsan.PNG">
							<img src="../resources/images/gyeongsang.png">
							<img src="../resources/images/gyeongsang3.png">
							<!-- image는 3개만 쓰죠 -->
						</p>
						</div>
						<footer>
							<a href="/board/detail?s_cate=서울/경기" class="button alt">Learn More</a>
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
							<h2>전라도</h2>
						</header>
						<div class="content">
						<p>
							<img src="../resources/images/jeonlado.PNG">
							<img src="../resources/images/jeonlado2.PNG">
							<img src="../resources/images/jeonlado3.PNG">
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
							<h2>경기도</h2>
						</header>
						<div class="content">
							<p>
								<img src="../resources/images/gyeong.PNG">
								<img src="../resources/images/gyeong2.PNG">
								<img src="../resources/images/gyeong3.PNG">
							</p>
						</div>
						<footer>
							<a href="/board/detail?s_cate=경남" class="button alt">Learn More</a>
						</footer>
					</article>
				</div>
			</section>

<%@ include file="../include/footer.jsp" %>