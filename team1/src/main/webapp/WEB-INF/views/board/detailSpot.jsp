<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<style>
img {
	width: 900px;
	height: 450px;
}

.content {
	width: 900px;
}

.box .detail_info ul il strong {
	display: table-cell;
}

hr {
	margin: 25px;
}

strong {
	width: 95.66px;
}

.title {
	
}

a {
	color: white;
}

span {
	margin-left: 20px;
}

.imgPro {
	height: 20px;
	width: 20px;
}

.sel > option {
	background-color: black;
}

</style>

<section id="post" class="wrapper bg-img" data-bg="banner2.jpg">
	<div class="inner">
		<article class="box">
			<header>
				<h2>${vo.s_name}</h2>
				<p>${vo.s_add}</p>
			</header>
			<div class="spot_photo">
				<c:choose>
					<c:when test="${not empty vo.s_pic}">
							<img alt='Bootstrap Image Preview'
							src='/board/displayFile?fileName=${vo.s_pic}' />
					</c:when>
						<c:otherwise>
							<img alt='Bootstrap Image Preview'
								src='../resources/images/nothing.jpg'/>
						</c:otherwise>
					</c:choose>
			
			</div>
			<hr>
			<div class="content">${vo.s_detail}</div>
			<hr>
			<div class="detail_info">
				<h4>상세정보</h4>
				<ul>
					<c:if test="${not empty vo.s_tel}">
						<li><strong id="info">문의 및 안내</strong> <span>${vo.s_tel}</span>
						</li>
					</c:if>
					<c:if test="${not empty vo.s_homepage}">
						<li><strong class="title">홈페이지</strong> <span> <a
								href="${vo.s_homepage}" target="_blank">${vo.s_homepage}</a>
						</span></li>
					</c:if>
					<c:if test="${not empty vo.s_holiday}">
						<li><strong>휴무일</strong> <span>${vo.s_holiday}</span></li>
					</c:if>
					<c:if test="${not empty vo.s_worktime}">
						<li><strong>이용시간</strong> <span>${vo.s_worktime}</span></li>
					</c:if>
					<c:if test="${not empty vo.s_cost}">
						<li><strong>입장료</strong> <span>${vo.s_cost}</span></li>
					</c:if>
				</ul>
			</div>
				<hr>
					<strong>${vo.s_name} 위치</strong><br>
					<div class="map_wrap">
						<div id="map" style="width:900px;height:400px; position:relative; overflow:hidden;"></div>
						<div class="custom_typecontrol radius_border">
       						 <span id="btnRoadmap" class="selected_btn" onclick="setMapType('roadmap')">지도</span>
       						 <span id="btnSkyview" class="btn" onclick="setMapType('skyview')">스카이뷰</span>
   						 </div>
   					</div>			
				<!-- // 댓글 작성 -->
				<div>
				<c:if test="${not empty memberVo.mem_id}">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label for="m_detail">댓글내용</label> 
								<input type="text" id="m_detail" class="form-control" />
							</div>						
							<div class="form-group">
								<label for="mark"> 
								<select class="sel" name="point" id="m_point">
										<option value="1">★☆☆☆☆</option>
										<option value="2">★★☆☆☆</option>
										<option value="3">★★★☆☆</option>
										<option value="4">★★★★☆</option>
										<option value="5">★★★★★</option>
								</select>
								</label>
							</div>
							<div class="form-group">
								<button type="button" class="btn-xs btn-success" id="btnReply">작성완료</button>
							</div>
						</div>
						</div>
					</c:if>	
				<hr />

				<!-- 댓글 목록 -->
				<div class="row" >
					<div class="col-md-12">
					<c:if test="${not empty paramMap}">
						<div>평균 평점 : ${paramMap.avg } 점 참여자 :${paramMap.total } 명</div>
					</c:if>
						<table class="table">
							<thead id="replyHead">
								
							</thead>
							<tbody id="replyList">

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</article>
	</div>
</section>

	<div class="row">
		<div class="col-md-12">
			 <a id="modal-a" href="#modal-container" role="button" class="btn" data-toggle="modal"
			 	style="display:none;">Launch demo modal</a>
			
			 <div class="modal fade" id="modal-container" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title font_color" id="myModalLabel">
								댓글 수정하기
							</h5> 
							<button type="button" class="close font_color" data-dismiss="modal">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">
							<input type="hidden" id="modal_m_id"/>
							<label for="modal_m_detail" class="font_color">댓글내용</label>
							<input type="text" class="form-control font_color"
								id="modal_m_detail"/>
							<label for="modal_mem_id" class="font_color">평점</label>
							<select name="point" id="modal_m_point" class="font_color">
										<option value="1">★☆☆☆☆</option>
										<option value="2">★★☆☆☆</option>
										<option value="3">★★★☆☆</option>
										<option value="4">★★★★☆</option>
										<option value="5">★★★★★</option>
								</select>
<!-- 							<input type="hidden" class="form-control" -->
<!-- 								id="modal_mem_id"/> -->
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary font_color"
								id="btnModalReply">
								수정완료
							</button> 
							<button type="button" class="btn btn-secondary font_color" data-dismiss="modal"
								id="btnModalClose">
								닫기
							</button>
						</div>
					</div>
					
				</div>
				
			</div>
			
		</div>
	</div>

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=027af565dc7eede95404567343c1e203&libraries=services"></script>
<script>
	//마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
	// var infowindow = new kakao.maps.InfoWindow({zIndex:1});

	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center : new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
		level : 4
	//지도의 레벨(확대, 축소 정도)
	};

	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

	// 지도타입 컨트롤의 지도 또는 스카이뷰 버튼을 클릭하면 호출되어 지도타입을 바꾸는 함수입니다
	function setMapType(maptype) { 
	    var roadmapControl = document.getElementById('btnRoadmap');
	    var skyviewControl = document.getElementById('btnSkyview'); 
	    if (maptype === 'roadmap') {
	        map.setMapTypeId(kakao.maps.MapTypeId.ROADMAP);    
	        roadmapControl.className = 'selected_btn';
	        skyviewControl.className = 'btn';
	    } else {
	        map.setMapTypeId(kakao.maps.MapTypeId.HYBRID);    
	        skyviewControl.className = 'selected_btn';
	        roadmapControl.className = 'btn';
	    }
	}	
	
	//주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	// 주소로 좌표를 검색합니다
	geocoder
			.addressSearch(
					'${vo.s_add}',
					function(result, status) {

						// 정상적으로 검색이 완료됐으면 
						if (status === kakao.maps.services.Status.OK) {

							var coords = new kakao.maps.LatLng(result[0].y,
									result[0].x);

							// 결과값으로 받은 위치를 마커로 표시합니다
							var marker = new kakao.maps.Marker({
								map : map,
								position : coords
							});

							// 인포윈도우로 장소에 대한 설명을 표시합니다
							var infowindow = new kakao.maps.InfoWindow(
									{
										content : '<div style="width:150px;text-align:center;padding:6px 0;">${vo.s_name}</div>'
									});
							//         infowindow.open(map, marker);

							// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							map.setCenter(coords);
						}
					});

	$(function() {
		jQuery.noConflict();
		$(".font_color").css("color", "black");
		// 댓글 작성 완료 버튼
		$("#btnReply").click(function() {
			var s_id = "${vo.s_id}"; // 게시글번호(댓글번호 아님)
			var m_detail = $("#m_detail").val(); // 댓글내용
			var mem_id = "${memberVo.mem_id}" // 작성자
			var m_point = $("#m_point").val(); // 평점
			
			if (m_detail == "") {
				alert("댓글 내용을 입력해주세요");	
				return false;
			}
			
			var sendData = {
				"s_id" : s_id,
				"m_detail" : m_detail,
				"mem_id" : mem_id,
				"m_point" : m_point
			};
			var url = "/mark/write";
			//	 		$.post(url, JSON.stringify(sendData), function(rData) {
			//	 			console.log(rData);
			//	 		}); // 처리 안됨

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
					$("#m_detail").val("");
					$("#m_point").val("1");
					replyList();
				}
			}); // $.ajax()
		});
		
		
		// 댓글 수정 버튼
		$("#replyList").on("click", ".btnReplyUpdate", function() {
			console.log("댓글 수정 버튼");
			var m_id = $(this).attr("data-m_id");
			var m_detail = $(this).attr("data-m_detail");
			var m_point = $(this).attr("data-m_point");
// 			var mem_id = $(this).attr("data-mem_id");
			$("#modal_m_id").val(m_id);
			$("#modal_m_detail").val(m_detail);
			$("#modal_m_point").val(m_point);
			
			switch(m_point){
			case 5 : $("#modal_m_point").val("5").prop("selected", true);
				break;
			case 4 : $("#modal_m_point").val("4").prop("selected", true);
				break;
			case 3 : $("#modal_m_point").val("3").prop("selected", true);
				break;
			case 2 : $("#modal_m_point").val("2").prop("selected", true);
				break;
			case 1 : $("#modal_m_point").val("1").prop("selected", true);
				break;
			}
			
			
// 			$("#modal_mem_id").val(mem_id);
			$("#modal-a").trigger("click");
		});
		
		// 모달창 완료 버튼
		$("#btnModalReply").click(function() {
			var m_id = $("#modal_m_id").val();
			var m_detail = $("#modal_m_detail").val();
// 			var mem_id = $("#modal_mem_id").val();
			var m_point = $("#modal_m_point").val();
			
			var sendData = {
					"m_id" : m_id,
					"m_detail" : m_detail,
// 					"mem_id" : mem_id,
					"m_point" : m_point
			};
			
			var url = "/mark/editMark";
			
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
		
		// 댓글 삭제 버튼
		$("#replyList").on("click", ".btnReplyDelete", function() {
			console.log("댓글 삭제 버튼");
			var m_id = $(this).attr("data-m_id");
			var s_id = $(this).attr("data-s_id");
			var url = "/mark/delete/" + m_id + "/" + s_id;
			
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
					$("#btnModalClose").trigger("click");
					if(rData != ""){
						$("#replyHead").empty();
					}
				}
			}); // $.ajax()
		});
		
		//댓글 헤더
		
		function replyHead(){
			var str = "";
			str +=	"<tr>";
			str +=  "<th>번호</th>";
			str +=	"<th>평점</th>";
			str +=	"<th>댓글내용</th>";
			str +=	"<th>작성자</th>";
			str +=	"<th>날짜</th>";
			str +=   "</tr>";

			$("#replyHead").append(str);
		}
	
		// 댓글 목록 가져오기 - 정의
		function replyList() {
			var i = 1;
			$("#replyList").empty();
			var url = "/mark/listAll/${vo.s_id}";
			$.getJSON(url, function(rData) {
				console.log(rData);
				if(rData != ""){
					$("#replyHead").empty();
					replyHead();
				}
				var strHtml = "";
				$(rData).each(function() {
					strHtml += "<tr>";
					strHtml += "<td>" + i++ +"</td>";
					
					switch(this.m_point){
					case 5 : strHtml += "<td> ★★★★★ </td>";
						break;
					case 4 : strHtml += "<td> ★★★★☆ </td>";
						break;
					case 3 : strHtml += "<td> ★★★☆☆ </td>";
						break;
					case 2 : strHtml += "<td> ★★☆☆☆ </td>";
						break;
					case 1 : strHtml += "<td> ★☆☆☆☆ </td>";
						break;
					}
					
					strHtml += "<td width='250px' style='word-break:break-all'>" + this.m_detail + "</td>";
					
					if(this.mem_pic == null){
						strHtml += "<td><img src='../resources/images/nothing.jpg' class='imgPro'/>"
								+ this.mem_id + "</td>";
					} else {
						strHtml += "<td><img src='/board/displayFile?fileName=" + this.mem_pic + "'class='imgPro'/>" 
								+ this.mem_id + "</td>";
					}
					
					strHtml += "<td>" + dateString(this.m_reg_date) + "</td>";
					
					if(this.mem_id == "${memberVo.mem_id}"){
						strHtml += "<td><button type='button' class='btn-xs btn-warning btnReplyUpdate'";
						strHtml += " data-m_id='" + this.m_id + "'";
						strHtml += " data-m_point='" + this.m_point + "'";
						strHtml += " data-m_detail='" + this.m_detail + "'";
						strHtml += " data-mem_id='" + this.mem_id + "'>수정</button></td>";
						strHtml += "<td><button type='button' class='btn-xs btn-danger btnReplyDelete'";
						strHtml += " data-m_id='" + this.m_id + "'";
						strHtml += " data-s_id='" + this.s_id + "'>삭제</button></td>";
					}
				
					
					strHtml += "</tr>";
				});
				$("#replyList").append(strHtml); // <tbody>의 자식 엘리먼트로 html을 추가
			});
		}
		replyList();
		
	})
</script>

<%@ include file="../include/footer.jsp"%>