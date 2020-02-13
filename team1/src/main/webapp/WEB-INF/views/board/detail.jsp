<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp" %>
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
									<th colspan='2'>${vo.s_pic}</th>
									<th>${vo.s_add }</th>
								</tr>
								<tr>
									<td>${vo.s_detail }</td>
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