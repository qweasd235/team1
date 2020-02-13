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
							<h2>자유 게시판</h2>
							<button type="button" id="btnRegister" class="btn btn-danger">글쓰기</button>
							<br><br>
<!-- 							<p>01.01.2017</p> -->
						</header>
						<table>
							<thead>
								<tr>
									<th>글번호</th>
									<th>글제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>조회수</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>1</td>
									<td>1</td>
									<td>1</td>
									<td>1</td>
								</tr>
								<tr>
									<td>2</td>
									<td>2</td>
									<td>2</td>
									<td>2</td>
									<td>2</td>
								</tr>
								<tr>
									<td>3</td>
									<td>3</td>
									<td>3</td>
									<td>3</td>
									<td>3</td>
								</tr>
							</tbody>
					</table>
					</article>
				</div>
			</section>

<%@ include file="../include/footer.jsp" %>