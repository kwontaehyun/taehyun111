/**
 * 
 */
let field = ['id', 'sido', 'address', 'phoneNumber', 'zipCode', 'lat', 'lng'];

function init() {
	let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&returnType=JSON&serviceKey=8PIUhwI8DldGqZATrV5BC%2BxZnCk72BhR5x8ych8FavqbPelV6SEaQQ1IynjgkEiORd8LvYs6UbQ%2FeY7eUaZvcg%3D%3D`
	let xhtp = new XMLHttpRequest(); //비동기처리 방식(Asychronous Javascript And Xml)
	xhtp.open('get', url);
	xhtp.send();
	xhtp.onload = loadCallBack;
	let findBtn = document.getElementById('findBtn');

	findBtn.addEventListener('click', findCallBack); 

}// end of init()

// this.
let obj = {
	name : 'Hong',
	age : 20,
	showInfo : function(){
		return this.name + ' , ' + this.age;
	}
}
function globalFnc(){
	console.log(this);
}
globalFnc(); // 이벤트가 시작하기전이기때문에 this는 window를 가르킴
init(); 
function loadCallBack() {
	result = JSON.parse(this.responseText);
	console.log(result);
	console.log("총건수: " + result.totalCount)

	console.log(result.data[0]);
	result.data.forEach(function(val) {
		if (val.sido == '서울특별시')
			console.log(`id : ${val.id}, 도시 : ${val.sido}`);
	});

	let filterAry = result.data.filter(function(val) {
		return val.sido == '대전광역시';
	});

	console.log(filterAry);

	//head
	let head = document.getElementById('thead');

	let tr = document.createElement('tr');
	head.appendChild(tr);
	field.forEach(function(elem) {
		let th = document.createElement('th');
		th.innerHTML = elem.toUpperCase();
		tr.appendChild(th);
	})

	makeBody(filterAry);

} // end of loadCallBack()

function makeBody(ary) {
	let body = document.getElementById('tbody');
	//이미 생성된 조회정보가 있으면 삭제.
	let childTr = document.querySelectorAll('#tbody>tr')
	childTr.forEach(val => {
		//val.remove();//tr삭제
		body.removeChild(val);
	})

	ary.forEach(function(center) {
		let tr = document.createElement('tr');
		body.appendChild(tr);
		field.forEach(function (val) {
			let td = document.createElement('td');
			//address 필드 일 경우 링크.
			if(val == 'address'){
				let aTag = document.createElement('a');
				aTag.style.textDecoration = "none"
				aTag.setAttribute("href", `daumApi.html?x=${center.lat}&y=${center.lng}&z=${center.facilityName}`);
				aTag.setAttribute("target", `_blank`);
				aTag.innerHTML = center[val];
				td.appendChild(aTag);
			}
			else{
				td.innerHTML = center[val];
			}
			
			tr.appendChild(td);

	})//body
})//end of makeBody();


function findCallBack() {
	//기능구현. input.value 속성을 읽어와서 filterAry => 헤더, 바디.
	let searchSido = document.getElementById('sido').value;

	let filterAry = result.data.filter(function(val) {
		//return val.sido.startsWith(searchSido);
		//return val.sido == searchSido;
		return val.sido.indexOf(searchSido) != -1;
	});

	makeBody(filterAry);

	document.getElementById('sido').value = "";
	//입력값 초기화.
}