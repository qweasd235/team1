<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>
<style>
img{ 
 	width : 160px; 
 	height : 140px;
 } 
 
 #subDetail{
 	padding : 1px;
 	vertical-align : middle;
 }
hr{
	margin : 5px;
}
#spot_title{
	font-size : 25px;
	font-weight : bold;
}
.detail_content{
	color : white;
}
</style>

<script>
$(document).ready(function(){
	$(".detail_content").click(function(e){
// 		e.preventDefault();
		var s_id = $(this).attr("data-s_id");
// 		console.log(s_id);
		location.href = "/board/detailContent?s_id=" + s_id;
	});
});	
</script>
<!-- 		<form id= -->

		<!-- Content -->
		<!--
			Note: To show a background image, set the "data-bg" attribute below
			to the full filename of your image. This is used in each section to set
			the background image.
		-->
			<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
				<div class="inner">
					<article class="box">
						<header>
<!-- 							<h2>Nibh non lobortis mus nibh</h2> -->
<!-- 							<p>01.01.2017</p> -->
						</header>
						<div class="content">

						<table>
							<c:forEach items="${list}" var="vo">
								<tr>
									<td>
										<img alt='Bootstrap Image Preview' 
										 	src='/board/displayFile?fileName=${vo.s_pic}'/>
									</td>
									<td id="subDetail">
										<div id="spot_title">
										<a data-s_id="${vo.s_id}" class="detail_content">${vo.s_name}</a></div>
									<hr>  
									${vo.s_add}</td>
								</tr>
							</c:forEach>
						</table>
						</div>
						<footer>
							<ul class="actions">
								<li><a href="#" class="button alt icon fa-chevron-left"><span class="label">Previous</span></a></li>
								<li><a href="#" class="button alt icon fa-chevron-right"><span class="label">Next</span></a></li>
							</ul>
						</footer>
					</article>
				</div>
			</section>

<%@ include file="../include/footer.jsp" %>