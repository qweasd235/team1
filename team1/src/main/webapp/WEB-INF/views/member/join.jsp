<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>TEAM1</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../resources/assets/css/main.css" />
	</head>

<body>


		<!-- Nav -->
			<nav id="menu">
				<ul class="links">

					<li><a href="/board/home">Home</a></li>
					<li><a href="/board/login">Login</a></li>
					<li><a href="/mem/join">Join</a></li>

				</ul>
			</nav>
			
		<!-- Main -->

	<h3>Form</h3>
	<form method="post" action="mem/loginPost">
		<div class="row uniform">
			<div class="6u$ 12u$(xsmall)">
				<input type="text" name="mem_id" id="mem_id" placeholder="아이디" />
			
			<div class="6u$ 12u$(xsmall)">
				<input type="password" name="mem_pw" id="mem_pw" 
					placeholder="비밀번호" />
			</div>
			<div class="6u$ 12u$(xsmall)">
				<input type="text" name="mem_name" id="mem_name" 
					placeholder="이름" />
			</div>
		</div>	
			<!-- Break -->
			<div class="12u$">
				<div class="select-wrapper">
					<select name="category" id="category">
						<option value="">- Category -</option>
						<option value="1">서울/경기</option>
						<option value="1">강원도</option>
						<option value="1">충청/전라</option>
						<option value="1">경남</option>
					</select>
				</div>
			</div>
			<!-- Break -->
			<!-- Break -->
			<div class="12u$">
				<textarea name="s_detail" id="s_detail"
					placeholder="상세설명" rows="6"></textarea>
			</div>
			<!-- Break -->
			<div class="12u$">
				<ul class="actions">
					<li><input type="submit" value="가입완료" /></li>
					<li><input type="reset" value="초기화" class="alt" /></li>
				</ul>
			</div>
		</div>
	</form>

	<hr />
	


		<!-- Scripts -->
			<script src="../resources/assets/js/jquery.min.js"></script>
			<script src="../resources/assets/js/jquery.scrolly.min.js"></script>
			<script src="../resources/assets/js/jquery.scrollex.min.js"></script>
			<script src="../resources/assets/js/skel.min.js"></script>
			<script src="../resources/assets/js/util.js"></script>
			<script src="../resources/assets/js/main.js"></script>
</body>
</html>