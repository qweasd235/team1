<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>    
<style>
img{
	width : 900px;
	height : 450px;
}
.content{
	width : 900px;
}
.box .detail_info ul il strong{
	display : table-cell;
}
hr{
	margin : 25px;
}
strong{
	width : 95.66px;
}
.title{
	
}

a{
	color : white;
}
span{
	margin-left : 20px;
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
							<img alt='Bootstrap Image Preview' 
								 	src='/board/displayFile?fileName=${vo.s_pic}'/>
						</div>
						<hr>
						<div class="content">
							${vo.s_detail}
						</div>
						<hr>
						<div class="detail_info">
							<h4>상세정보</h4>
							<ul>
								<c:if test="${not empty vo.s_tel}">
								<li>
									<strong id="info">문의 및 안내</strong>
									<span>${vo.s_tel}</span>
								</li>
								</c:if>
								<c:if test="${not empty vo.s_homepage}">
								<li>
									<strong class="title">홈페이지</strong>
									<span>
										<a href="${vo.s_homepage}" target="_blank">${vo.s_homepage}</a>
									</span>
								</li>
								</c:if>
								<c:if test="${not empty vo.s_holiday}">
								<li>
									<strong>휴무일</strong>
									<span>${vo.s_holiday}</span>
								</li>
								</c:if>
								<c:if test="${not empty vo.s_worktime}">
								<li>
									<strong>이용시간</strong>
									<span>${vo.s_worktime}</span>
								</li>
								</c:if>
								<c:if test="${not empty vo.s_cost}">
								<li>
									<strong>입장료</strong>
									<span>${vo.s_cost}</span>
								</li>
								</c:if>
							</ul>
						</div>
						<hr>
						<strong>${vo.s_name} 위치</strong><br>
						<div id="map" style="width:900px;height:400px;"></div>
					</article>
				</div>
			</section>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=027af565dc7eede95404567343c1e203&libraries=services"></script>
<script>
//마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
// var infowindow = new kakao.maps.InfoWindow({zIndex:1});

var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
	level: 6 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

//주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('${vo.s_add}', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">${vo.s_name}</div>'
        });
//         infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
</script>			

<%@ include file="../include/footer.jsp" %>