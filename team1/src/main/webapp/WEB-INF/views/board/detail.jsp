<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>    
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
}
 
/* #paging > li { */
/* 	float: letf; */
/* 	display: inline; */
	
/* } */
</style>    
 
<script>
	$(document).ready(function() {

		$(".detail_content").click(function(e) {
			// 		e.preventDefault();
			var s_id = $(this).attr("data-s_id");
			location.href = "/board/detailContent?s_id=" + s_id;
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
						<header>
				<!-- 							<h2>Nibh non lobortis mus nibh</h2> -->
				<!-- 							<p>01.01.2017</p> -->
			</header>
			
			<!-- 데이터 전송 -->
			<form id="frmPage" action="/board/detail" method="get">
				<input type="hidden" name="s_cate" value="${s_cate}" /> 
				<input type="hidden" name="page" value="${dto.page}" />
			</form>
				
			<div class="content">

				<table>
					<c:forEach items="${list}" var="vo">
						<tr>
							<td><img alt='Bootstrap Image Preview'
								src='/board/displayFile?fileName=${vo.s_pic}' /></td>
							<td id="subDetail">
								<div id="spot_title">
									<a data-s_id="${vo.s_id}" class="detail_content">${vo.s_name}</a>
								</div>
								<hr> 
								${vo.s_add}
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
<!-- 					<li><a href="#" class="button alt icon fa-chevron-left"><span class="label">Previous</span></a></li> -->

						<c:if test="${dto.hasPrev == true}">
							<li class="page-item">
								<a class="page-link" data-page="${dto.startPage - 1}">이전</a>
							</li>
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
							<li class="page-item">
								<a class="page-link" data-page="${dto.endPage + 1}">다음</a>
							</li>
						</c:if>
						
						
						
			
<!-- 						<li><a href="#" class="button alt icon fa-chevron-right"><span class="label">Next</span></a></li> -->
				</ul>
				</nav>
				</div>
				</div>
			</footer>
					</article>
				</div>
			</section>

<%@ include file="../include/footer.jsp" %>