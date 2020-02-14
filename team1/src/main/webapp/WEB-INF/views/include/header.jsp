<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
	<head>
		<title>TEAM1</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../resources/assets/css/main.css" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	</head>
	<body>

		<!-- Header -->
			<header id="header">
				<div class="logo"><a href="/board/home">TEAM1 <span>by TEAM1</span></a></div>
				<c:choose>
					<c:when test="${memberVo.mem_name != null}">
						<span>${memberVo.mem_name}님 환영합니다.</span>
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
						<li><a href="/mem/logout">로그아웃</a></li>
					</c:if>
					<c:if test="${memberVo.mem_id == 'MASTER'}">
					<li><a href="/board/regist">명소 등록</a></li>
					<li><a href="#">명소 수정</a></li>
					<li><a href="#">명소 삭제</a></li>
					</c:if>
					<li><a href="/board/freeBoardList">자유 게시판</a></li>
				</ul>
			</nav>
