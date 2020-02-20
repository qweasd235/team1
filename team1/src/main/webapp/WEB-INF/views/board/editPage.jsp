<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<style>
img {
	width: 160px;
	height: 140px;
}
#subDetail {
	padding: 1px;
	vertical-align: middle;
}
hr {
	margin: 5px;
}
#spot_title {
	font-size: 25px;
	font-weight: bold;
}

.detail_content {
	color: white;
	text-decoration: none;
}
</style>

<script>
	$(function() {
		$(".delSpot").click(function() {
					console.log("delSopt!");
					var src = $(".srcVal").attr("src");
					console.log(src);
					var str = src.substring(src.lastIndexOf("=") + 1);
					console.log(str);
					if (confirm("명소를 삭제하겠습니까?") == true) {
						var s_id = $(this).val();
						location.href = "/board/delSpot?s_id=" + s_id
								+ "&fileName=" + str;
						alert("삭제 완료되었습니다.");
					}
				});

		$(".editSpot").click(function() {
			console.log("editSpot");
			var s_id = $(this).val();
			location.href = "/board/editSpot?s_id=" + s_id
											+ "&page=${dto.page}";
		});

		$(".page-link").click(function(e) {
			e.preventDefault(); // 브라우저의 기본 기능 막기
			var page = $(this).attr("data-page");
			$("input[name=page]").val(page);
			$("#frmPage").submit();
		});

	});
</script>

<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
	<div class="inner">
		<article class="box">
			<!-- 데이터 전송 -->
			<form id="frmPage" action="/board/editPage" method="get">
				<input type="hidden" name="page" value="${dto.page}" />
			</form>
			<div class="content">
				<table>
					<c:forEach items="${list}" var="vo">
						<tr>
							<td><img class="srcVal" alt='Bootstrap Image Preview'
								src='/board/displayFile?fileName=${vo.s_pic}' /></td>
							<td id="subDetail">
								<div id="spot_title">
									<a data-s_id="${vo.s_id}" class="detail_content">${vo.s_name}</a>
								</div>
								<hr> ${vo.s_add} <br>
								<button class="delSpot" name="s_id" value="${vo.s_id }">삭제</button>
								<button class="editSpot" name="s_id" value="${vo.s_id }">수정</button>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<footer>
				<div class="row">
					<div class="col-md-12 text-center">
						<nav>
							<ul class="pagination">

								<c:if test="${dto.hasPrev == true}">
									<li class="page-item"><a class="page-link"
										data-page="${dto.startPage - 1}">이전</a></li>
								</c:if>
								<c:forEach begin="${dto.startPage}" end="${dto.endPage}" var="v">
									<li
										<c:choose>
								<c:when test="${dto.page == v}">
									class="page-item active"
								</c:when>
								<c:otherwise>
									class="page-item"
								</c:otherwise>
							</c:choose>>
										<a class="page-link" data-page="${v}">${v}</a>
									</li>
								</c:forEach>
								<c:if test="${dto.hasNext == true}">
									<li class="page-item"><a class="page-link"
										data-page="${dto.endPage + 1}">다음</a></li>
								</c:if>


							</ul>
						</nav>
					</div>
				</div>
			</footer>
		</article>
	</div>
</section>
<%@ include file="../include/footer.jsp"%>