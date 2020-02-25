<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<style>
#replyBox {
	background-color: gray;
}

#r_content {
	background-color: white;	
	color: black;
}

.imgPro {
	height: 20px;
	width: 20px;
}

img {
	width: 160px;
	height: 140px;
}

</style>

<script>  
$(document).ready(function() {
	jQuery.noConflict();	// 마법의 단어(충돌할때)
	$(".font_color").css("color", "black");
	// 리스트 가기
	$("#btnListAll").click(function() {		
		$("#frmPage").submit();
	});
	
	// 글 수정하기
	$("#btnModify").click(function() {		
		$("#b_title").prop("readonly", false).css("background-color", "white");
		$("#b_content").prop("readonly", false).focus();
		$("#pic").show(1000);
		$(this).hide(600);
		$("button[type=submit]").show(600);
	}); 
	
	// 글 삭제하기
	$("#btnDelete").click(function() {
		var src = $("#img_pic").attr("src");
		console.log(src);
		var str = src.substring(src.lastIndexOf("=") + 1);
		console.log(str);
		if (!confirm("삭제하시겠습니까?") ) {
			return false;
		}
		location.href = "/board/fbDelete?b_num=${fb_vo.b_num}&fileName=" + str;
		alert("삭제 되었습니다");
	});
	
	// 리플 쓰기
	$("#btnReplyRegist").click(function() {
		var b_num = "${fb_vo.b_num}"; // 게시글번호(댓글번호 아님)
		var r_content = $("#r_content").val(); // 댓글내용		
		var sendData = {
				"b_num" : b_num,
				"r_content" : r_content				
		};
		var url = "/reply/register";

		$.ajax({
			"type" : "post",
			"url" : url,
			"headers" : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "post"
			},
			"dataType" : "text",
			"data" : JSON.stringify(sendData),
			"success" : function(rData) {
				console.log(rData);
				replyList();
			}
		}); // $.ajax()
	});
	
	// 리플 수정
	$("#Reply_Table_List").on("click", ".btnReplyUpdate", function() {
		console.log("댓글 수정 버튼");
		var r_num = $(this).attr("data-r_num");
		var r_content = $(this).attr("data-r_content");
		var r_writer = $(this).attr("data-r_writer");
		
		$("#modal_r_num").val(r_num);
		$("#modal_r_content").val(r_content);
		$("#modal_r_writer").val(r_writer);
		
		$("#modal_reply").trigger("click");
	});
	
	// 리플 수정 완료버튼
	$("#btnModalReply").click(function() {
		var r_num = $("#modal_r_num").val();
		var r_content = $("#modal_r_content").val();		
		
		var sendData = {
				"r_num" : r_num,
				"r_content" : r_content,				
		};				
		
		var url = "/reply/update";
		
		$.ajax({
			"type" : "put",
			"url" : url,
			"headers" : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "put"
			},
			"dataType" : "text",
			"data" : JSON.stringify(sendData),
			"success" : function(rData) {
				console.log(rData);
				replyList();
				$("#btnModalClose").trigger("click");
			}
		}); // $.ajax()
	});
	
	// 리플 삭제
	$("#Reply_Table_List").on("click", ".btnReplyDelete", function() {
		console.log("클릭");
		var r_num = $(this).attr("data-r_num");
		var b_num = $(this).attr("data-b_num");
		var url = "/reply/delete/" + r_num + "/" + b_num;
		console.log("r_num" + r_num);
		console.log("b_num" + b_num);
		console.log("url" + url);
		
		$.ajax({
			"type" : "delete",
			"url" : url,
			"headers" : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "delete"
			},
			"success" : function(rData) {
				console.log(rData);
				replyList();
				
			}
		}); // $.ajax()		
	});
	
	
	// 리플 정의
	function replyList() {
		$("#Reply_Table_List").empty();
		var url = "/reply/listAll/${fb_vo.b_num}";
		$.getJSON(url, function(rData) {
			console.log(rData);
			var strHtml = "";
			$(rData).each(function() {
				strHtml += "<tr>";
				strHtml += "<td>" + this.r_num +"</td>";
				strHtml += "<td>" + this.r_content + "</td>";
				if(this.mem_pic == null){
					strHtml += "<td><img src='../resources/images/nothing.jpg' class='imgPro'/>" 
							+ this.r_writer + "</td>";
				} else {
					strHtml += "<td><img src='/board/displayFile?fileName=" + this.mem_pic + "'class='imgPro'/>" 
							+ this.r_writer + "</td>";
				}
				strHtml += "<td>" + dateString(this.r_regdate) + "</td>"; 
				if (this.r_writer == "${memberVo.mem_id}") {
					strHtml += "<td><button type='button' class='btn-xs btn-warning btnReplyUpdate'";
					strHtml += " data-r_num='" + this.r_num + "'";
					strHtml += " data-r_content='" + this.r_content + "'";
					strHtml += " data-r_writer='" + this.r_writer + "'>수정</button></td>";
					strHtml += "<td><button type='button' class='btn-xs btn-danger btnReplyDelete'";
					strHtml += " data-r_num='" + this.r_num + "'";
					strHtml += " data-b_num='" + this.b_num + "'>삭제</button></td>";
				}
				
				strHtml += "</tr>";
			});
			$("#Reply_Table_List").append(strHtml); // <tbody>의 자식 엘리먼트로 html을 추가
		});
	} // replyList()
	
	replyList();
});
</script>


		<!-- Content -->
		<!--
			Note: To show a background image, set the "data-bg" attribute below
			to the full filename of your image. This is used in each section to set
			the background image.
		-->
			<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
				<div class="inner">
					<div class="row">
					<article class="box">
						<header>							
							<h2>글 상세보기</h2>
							<h5>확인용</h5>
							${memberVo}
							${pagingDto}
							${fb_vo }
							<h5>// 확인용</h5>
<!-- 							<p>01.01.2017</p> -->
						</header>
						<form id="myform" role="form" method="post" 
							  action="/board/fbModify" enctype="multipart/form-data">
							<input type="hidden" name="b_num" value="${fb_vo.b_num}"/>
<%-- 							<input type="hidden" name="page" value="${pagingDto.page}"/> --%>
<%-- 							<input type="hidden" name="perPage" value="${pagingDto.perPage}"/> --%>
						<div class="form-group">
							<label for="b_title">제목</label>
							<input type="text" class="form-control" id="b_title" 
								   name="b_title" value="${fb_vo.b_title }" style="color: black;"
								   readonly/>
						</div>						
						<div class="form-group">
							<label for="b_content">내용</label><br>
							<textarea rows="5" id="b_content" class="form-control"
								name="b_content" readonly>${fb_vo.b_content }</textarea>
						</div>
						<div class="form-group">
							<label for="b_writer">글쓴이</label>
							<span><strong>${fb_vo.b_writer }</strong></span>
						</div>
						<div class="form-group">
					<c:choose>
					<c:when test="${empty fb_vo.b_pic}">
							<span><img alt='파일 없음' id="img_null"
								src='../resources/images/nothing.jpg'/></span>
					</c:when>
					<c:otherwise>                                  
						<span><img alt='이미지' id="img_pic"
								src='/board/displayFile?fileName=${fb_vo.b_pic}'/></span>
					</c:otherwise>    
					</c:choose>
						</div>
						<div class="12u$" style="display: none;" id="pic"> 
							<input type="file" name="file" id="b_pic" />
						</div>
						<hr>
						<div style="clear:both;">
						<c:if test="${memberVo.mem_id == fb_vo.b_writer}">
							<button type="submit" class="btn btn-success"
								style="display:none;">완료</button>
							<button type="button" class="btn btn-warning"
								id="btnModify">수정</button>
							<button type="button" class="btn btn-danger"
								id="btnDelete">삭제</button>
						</c:if>
							<button type="button" class="btn btn-primary"
								id="btnListAll">목록</button>
						</div>																							
						</form>
						
						<!-- 데이터만 보내기 -->
						<form id="frmPage" action="/board/freeBoardList" method="get">
							<input type="hidden" name="b_num" />
							<input type="hidden" name="page" value="${pagingDto.page}"/>						
						</form>
						
					<!-- 리플 박스 -->	
						<article class="box" id="replyBox">
							<label>댓글</label><br>
							<table> 
								<thead>
									<tr>
										<th>번호</th>
										<th>내용</th>
										<th>작성자</th>
										<th>날짜</th>										
									</tr>
								</thead>
								<tbody id="Reply_Table_List">								
								</tbody>
							</table>
							<form>
							<div class="col-md-11">
								<input type="text" id="r_content" class="form-control" name="r_content"/>
							</div>	
							<div class="col-md-1">
								<button type="button" class="btn btn-success" id="btnReplyRegist">등록</button>
							</div>
							</form>
						<!-- // 리플 박스 -->	
							
	<!-- 댓글 수정 모달 창 -->	
	<div class="row">
		<div class="col-md-12">
			 <a id="modal_reply" href="#modal-container" role="button" class="btn" data-toggle="modal"
			 	style="display: none;">모달창</a>
			
			 <div class="modal fade" id="modal-container" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title font_color" id="myModalLabel">
								댓글 수정하기															
							</h5>  
						</div> 
						<form action="#" method="post">
						<div class="modal-body">
							<input type="hidden" id="modal_r_num"/>
							<label for="modal_r_content" class="font_color">댓글내용</label>
							<input type="text" class="form-control font_color"
								id="modal_r_content"/><br>
							<label class="font_color">작성자</label>
							<div class="font_color">${fb_vo.b_writer}</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"
								id="btnModalReply">
								수정완료
							</button> 
							<button type="button" class="btn btn-secondary" data-dismiss="modal"
								id="btnModalClose">
								닫기
							</button>
						</div>
						</form>
					</div>
					
				</div>
				
			</div>
			</div>
		</div>	
	<!-- // 댓글 수정 모달 창 -->
													
						</article> 
					</article>
					</div>
				</div>
			</section>

<%@ include file="../include/footer.jsp" %>