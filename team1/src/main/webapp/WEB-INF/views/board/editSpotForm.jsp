<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<style>
option{
	color : black;
}
</style>

	<!-- Main -->
<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
	<div class="inner">
		<article class="box">
			<h3>명소 수정/삭제</h3>
	<form method="post" action="/board/editSpotPro" enctype="multipart/form-data">
	<input type="hidden" name="s_ref" value="MASTER">
	<input type="hidden" name="page" value="${pagingDto.page}">
	<input type="hidden" name="s_id" value="${vo.s_id}">
	
		<div class="row uniform">
			<div class="6u 12u$(xsmall)">
				<input type="text" name="s_name" id="s_name" placeholder="명소" value="${vo.s_name }"/>
			</div>
			<div class="6u$ 12u$(xsmall)">
				<input type="text" name="s_add" id="s_add" placeholder="주소" value="${vo.s_add }" />
			</div>
			<!-- Break -->
			<div class="6u 12u$(xsmall)">
				<input type="text" name="s_tel" id="s_tel" placeholder="명소 안내 전화번호" value="${vo.s_tel}"/>
			</div>
			<div class="6u$ 12u$(xsmall)">
				<input type="text" name="s_homepage" id="s_homepage" placeholder="명소 홈페이지" value="${vo.s_homepage}"/>
			</div>
			<div class="6u 12u$(xsmall)">
				<input type="text" name="s_holiday" id="s_holiday" placeholder="명소 휴무일" value="${vo.s_holiday}"/>
			</div>
			<div class="6u$ 12u$(xsmall)">
				<input type="text" name="s_worktime" id="s_worktime" placeholder="명소 운영시간" value="${vo.s_worktime}"/>
			</div>
			<div class="12u$">
				<input type="text" name="s_cost" id="s_cost" placeholder="명소 입장료" value="${vo.s_cost}"/>		
			</div>
			
			<!-- Break -->
			<div class="12u$">
				<div class="select-wrapper">
					<select name="s_cate" id="s_cate">
						<option value="">- Category -</option>
						<option value="서울/경기"
						<c:if test="${vo.s_cate == '서울/경기'}">
							selected
						</c:if>
						>서울/경기</option>
						<option value="강원도"
						<c:if test="${vo.s_cate == '강원도'}">
							selected
						</c:if>
						>강원도</option>
						<option value="충청/전라"
						<c:if test="${vo.s_cate == '충청/전라'}">
							selected
						</c:if>
						>충청/전라</option>
						<option value="경남"
						<c:if test="${vo.s_cate == '경남'}">
							selected
						</c:if>
						>경남</option>
					</select>
				</div>
			</div>
			<!-- Break -->
			<!-- Break -->
			<div class="12u$">
				<textarea name="s_detail" id="s_detail"
					placeholder="상세설명" rows="6">${vo.s_detail}</textarea>
			</div>
			<div class="12u$">
				<input type="file" name="file" id="s_pic" value="${vo.s_pic }"/>
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
	</article>
</div>
</section>	
<%@ include file="../include/footer.jsp" %>