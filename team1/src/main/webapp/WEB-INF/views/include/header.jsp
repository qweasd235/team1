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
	</head>
	<body>

		<!-- Header -->
			<header id="header">
				<div class="logo"><a href="/board/home">TEAM1 <span>by TEAM1</span></a></div>
				<span>${memberVo.mem_id}님 환영합니다.</span>
				<a href="#menu" style="background-color: red;"><span>Menu</span></a>
			</header>

		<!-- Nav -->
			<nav id="menu">
				<ul class="links">
					<li><a href="/board/home">Home</a></li>
					<li><a href="/mem/loginGet">로그인</a></li>
					<li><a href="/mem/joinGet">회원가입</a></li>
					<li><a href="/board/regist">명소 등록</a></li>
					<li><a href="#">명소 수정</a></li>
					<li><a href="#">명소 삭제</a></li>
					<li><a href="/board/freeBoard">자유 게시판</a></li>
				</ul>
			</nav>
