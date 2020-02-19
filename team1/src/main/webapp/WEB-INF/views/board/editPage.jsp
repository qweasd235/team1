<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<script>
$(function(){
	$(".delSpot").click(function(){
		console.log("delSopt!");
		var src = $(".srcVal").attr("src");
		var str = src.substring(src.lastIndexOf("=") + 1);
		console.log(str);
		if(confirm("명소를 삭제하겠습니까?") == true){
			var s_id = $(this).val();
			location.href = "/board/delSpot?s_id=" + s_id + "&fileName=" + str ;
			alert("삭제 완료되었습니다.");
		}
	});
	
	$(".editSpot").click(function(){
		console.log("editSpot");
		var s_id =$(this).val();
		location.href = "/board/editSpot?s_id=" + s_id;
	});
});

</script>

<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
	<div class="inner">
		<article class="box">
			<div class="content">
				<table>
					<c:forEach items="${list}" var="vo">
						<tr>
							<th rowspan='3'><img alt='Bootstrap Image Preview'
								src='/board/displayFile?fileName=${vo.s_pic}' class="srcVal" width='150' /></th>
							<th>${vo.s_add }</th>
						</tr>
						<tr>
							<td>${vo.s_detail }</td>
						</tr>
						<tr>
							<td><button class="delSpot" name="s_id" value="${vo.s_id }">삭제</button>
								<button class="editSpot" name="s_id" value="${vo.s_id }">수정</button></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<footer>
				<ul class="actions">
					<li><a href="#" class="button alt icon fa-chevron-left"><span
							class="label">Previous</span></a></li>
					<li><a href="#" class="button alt icon fa-chevron-right"><span
							class="label">Next</span></a></li>
				</ul>
			</footer>
		</article>
	</div>
</section>
<%@ include file="../include/footer.jsp"%>