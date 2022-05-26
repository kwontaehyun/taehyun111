<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>yedamMap.jsp</title>
<style>
<style>
@import url('https://cdn.jsdelivr.net/gh/orioncactus/pretendard/dist/web/static/pretendard.css');

body {
	font-family: 	font-family: Pretendard, -apple-system, BlinkMacSystemFont, system-ui, Roboto, 'Helvetica Neue', 'Segoe UI', 'Apple SD Gothic Neo', 'Noto Sans KR', 'Malgun Gothic', sans-serif;
}

#frm {
	text-decoration: none;
}

#nam {
	font-weight: bold;
}

a:link {
	color: black;
}

a:hover {
	color: red;
}

a:active {
	color: green;
}
#map{
width:95%; 
  height:914px;
}

</style>

</head>
<body>
	<div id="map" >	</div>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=13be2cad1a846175daeb3ba0ef15dde6"></script>
	<script>
		let url = location.href;
		console.log(url); // http://192.168.0.8/HelloAjax/ajax/daumApi.html?x=36.378512&y=127.344399
		let xpos = url.indexOf('x=');
		let ypos = url.indexOf('y=');
		let lat = 35.86907273664552;
		let lng = 128.5932806322255;
		console.log(lat, lng);
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(lat, lng), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 마커가 표시될 위치입니다 
		var markerPosition = new kakao.maps.LatLng(35.86907273664552,
				128.5932806322255);

		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
			position : markerPosition
		});

		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);

		

		var iwContent = '<div style=" weight:200px; height:100px; margin:0 auto; padding:13px 6px 25px 10px;text-align:center; "><a id="nam">👉쇼핑몰 위치👈</a><br><a id="frm" href="https://map.kakao.com/link/to/도착지점 위치,'+35.86907273664552+','+128.5932806322255+'"target="_blank">🕶길찾기</a><br> <a id="frm"  href="https://map.kakao.com/link/roadview/35.86907273664552, 128.5932806322255,'+35.86907273664552+','+128.5932806322255+'" style=target="_blank">📷로드뷰</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		iwPosition = new kakao.maps.LatLng(lat, lng); //인포윈도우 표시 위치입니다

		// 인포윈도우를 생성합니다
		var infowindow = new kakao.maps.InfoWindow({
			position : iwPosition,
			content : iwContent
		});

		// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
		infowindow.open(map, marker);

		// 로드뷰에 올릴 장소명 인포윈도우를 생성합니다.
		var rLabel = new kakao.maps.InfoWindow({
			position : mapCenter,
			content : '스페이스 닷원'
		});
		rLabel.open(rv, rMarker);
	
	</script>
</body>
</html>