<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<style>
.pagination{
	cursor : pointer;
}
</style>
<html>
	<head>
		<title>TEAM1</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
		<link rel="stylesheet" href="../resources/assets/css/main.css" />		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
		<script src="/resources/js/myscript.js"></script>
		<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
		
		<!-- Scripts -->
			<script src="../resources/assets/js/jquery.min.js"></script>
			<script src="../resources/assets/js/jquery.scrolly.min.js"></script> 
			<script src="../resources/assets/js/jquery.scrollex.min.js"></script>
			<script src="../resources/assets/js/skel.min.js"></script>
			<script src="../resources/assets/js/util.js"></script>
			<script src="../resources/assets/js/main.js"></script>
	</head>
	<body>

		<!-- Header -->
			<header id="header">
				<div class="logo"><a href="/board/home">방방곡곡 <span>by TEAM1</span></a></div>
				<c:choose>
					<c:when test="${memberVo.mem_name != null}">
						<span>${memberVo.mem_id}님 환영합니다.</span>
					</c:when>
					<c:otherwise>
						<span></span>
					</c:otherwise>
				</c:choose>
				<a href="#menu" style="background-color: red;"><span>Menu</span></a>
			</header>

		<!-- Nav -->
			<nav id="menu">
				<ul class="links">
					<li><a href="/board/home">Home</a></li>
					<c:if test="${empty memberVo}">
						<li><a href="/mem/loginGet">로그인</a></li>
						<li><a href="/mem/joinGet">회원가입</a></li>
					</c:if>
					<c:if test="${not empty memberVo}">
						<li><a href="/mem/editmemGet">회원정보 수정</a></li>
						<li><a href="/mem/logout">로그아웃</a></li>
					</c:if>
					<c:if test="${memberVo.mem_id == 'MASTER'}">
					<li>--관리자 페이지--</li>
					<li><a href="/board/regist">명소 등록</a></li>
					<li><a href="/board/editPage">명소 수정/삭제</a></li>
					</c:if>
					<li>--관광지 추천--</li>
					<li><a href="/board/detail?s_cate=서울/경기">서울/경기</a></li>
					<li><a href="/board/detail?s_cate=강원도">강원도</a></li>
					<li><a href="/board/detail?s_cate=충청/전라">충청/전라</a></li>
					<li><a href="/board/detail?s_cate=경남">경상도</a></li>
					<li>--커뮤니티--</li>
					<li><a href="/freeboard/freeBoardList">자유 게시판</a></li>
				</ul>
			</nav>
