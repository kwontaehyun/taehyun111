/**
 * 
 */
let url = location.href;
console.log(url);
let xPos = url.indexOf('x=');
let yPos = url.indexOf('y=');
let zPos = url.indexOf('z=')
console.log(xPos, yPos)

let lat = url.substring(xPos+2,yPos-1);
let lng = url.substring(yPos+2,zPos-1);
let z = url.substring(zPos+2);
z = decodeURI(z);

console.log(lat,lng);

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center: new kakao.maps.LatLng(lat, lng), // 지도의 중심좌표
		level: 3
		// 지도의 확대 레벨
	};

var map = new kakao.maps.Map(mapContainer, mapOption);

// 마커가 표시될 위치입니다 
var markerPosition = new kakao.maps.LatLng(lat, lng);

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
	position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

var iwContent = `<div style="padding:5px;>${z.toString()}<br><a href="https://map.kakao.com/link/map/반갑습니다!,${lat},${lng}" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/Hello World!,${lat},${lng}" style="color:blue" target="_blank">길찾기</a></div>',` // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
	iwPosition = new kakao.maps.LatLng(lat, lng); //인포윈도우 표시 위치입니다
// 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
	position: iwPosition,
	content: iwContent
});

// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
infowindow.open(map, marker);