<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
	<!-- Main -->

	<h3>Form</h3>
	<form method="post" action="#">
		<div class="row uniform">
			<div class="6u 12u$(xsmall)">
				<input type="text" name="s_name" id="s_name" value="" placeholder="명소" />
			</div>
			<div class="6u$ 12u$(xsmall)">
				<input type="text" name="s_add" id="s_add" value=""
					placeholder="주소" />
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
					<li><input type="submit" value="작성완료" /></li>
					<li><input type="reset" value="초기화" class="alt" /></li>
				</ul>
			</div>
		</div>
	</form>

	<hr />

	<form method="post" action="#">
		<div class="row uniform">
			<div class="9u 12u$(small)">
				<input type="text" name="query" id="query" value=""
					placeholder="Query" />
			</div>
			<div class="3u$ 12u$(small)">
				<input type="submit" value="Search" class="fit" />
			</div>
		</div>
	</form>

<%@ include file="../include/footer.jsp" %>