/**
 * post.js
 */

document.addEventListener('DOMContentLoaded', init);

function init() {
	let xhtp = new XMLHttpRequest();
	xhtp.open('get', '../studentList.json');
	xhtp.send();
	xhtp.onload = function() {
		let data = JSON.parse(xhtp.responseText);
		console.log(data);
		let tbodyList = document.getElementById('list');
		data.forEach(function(val) {
			tbodyList.appendChild(makeTr(val));
		})
	}// end of onload

	let modBtn = document.querySelector('input[type="button"]');
	modBtn.addEventListener('click', modStudent);

} // end of init()

function modStudent() {
	let no = document.querySelector('input[name=sno]').value;
	let name = document.querySelector('input[name=sname]').value;
	let eng = document.querySelector('input[name="seng"]').value;
	let kor = document.querySelector('input[name="skor"]').value;

	let xhtp = new XMLHttpRequest();
	xhtp.open('get', `modStudentServlet?sno=${no}&sname=${name}&seng=${eng}&skor=${kor}`);
	xhtp.send();
	xhtp.onload = function() {
		console.log(xhtp.responseText);
		let result = JSON.parse(xhtp.responseText);
		
		if (result.retCode == "OK") {
			let obj = {
				StuNo: result.stuNo,
				stuName: result.stuName,
				engScore: result.engScore,
				korScore: result.korScore
			};
			let newTr = makeTr(obj);
			let oldTr = document.getElementById(obj.StuNo);
			document.getElementById('list').replaceChild(newTr, oldTr); // 새로운 tr => 이전 tr 대체
		}
		else {
			alert('변경 중 오류.');
		}
	}
}


//한건추가. 
function addStudent(e) {
	e.preventDefault(); // submit -> 차단
	let no = document.querySelector('input[name="sno"]').value;
	let name = document.querySelector('input[name="sname"]').value;
	let eng = document.querySelector('input[name="seng"]').value;
	let kor = document.querySelector('input[name="skor"]').value;
	let xhtp = new XMLHttpRequest(); //비동기방식으로 서버의 파일을 요청.
	xhtp.open('get', `addStudentServlet?sno=${no}&sname=${name}&seng=${eng}&skor=${kor}`);
	xhtp.send(); //보내는거
	xhtp.onload = function() { //페이지를 요청하고, 요청된결과를 받아오고나면. 실행할함수정의
		let result = JSON.parse(xhtp.responseText);
		if (result.retCode == 'Success') {
			// 리스트 새로운 값 추가.
			successCallBack2(result); // {retCode:?, stuNo:?, stuName: ?, escore: ?, kscore: ?}}
		} else if (result.retCode == 'Fail') {
			// 처리중 에러가 발생.
			failCallBack();
		}
	} //end of function()  
}//end of addstudent()

function successCallBack2(retObj) {
	console.log(retObj);
	let obj = {
		StuNo: retObj.stuNo,
		stuName: retObj.stuName,
		engScore: retObj.engScore,
		korScore: retObj.korScore
	};
	document.getElementById('list').appendChild(makeTr(obj));
} // end of successCallBack2()
function successCallBack() {
	//사용자 입력값을 id='list' 하위 추가
	let no = document.querySelector('input[name="sno"]').value;
	let name = document.querySelector('input[name="sname"]').value;
	let eng = document.querySelector('input[name="seng"]').value;
	let kor = document.querySelector('input[name="skor"]').value;

	let person = {};
	person.no = no;
	person.name = name;
	person.eng = eng;
	person.kor = kor;

	document.getElementById('list').appendChild(makeTr(person));

}

function failCallBack() {
	alert('처리중 에러발생.')
}


function makeTr(ary) {
	let tr = document.createElement('tr')
	tr.setAttribute('id', ary.StuNo);
	for (let field in ary) {
		let td = document.createElement('td');
		td.innerHTML = ary[field];
		tr.appendChild(td);
	}

	//삭제버튼 생성
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.innerHTML = '삭제버튼';
	tr.appendChild(td);
	td.appendChild(btn);

	btn.addEventListener('click', function(e) {
		let id = e.target.parentElement.parentElement.firstChild.innerHTML;
		console.log(id); // 119
		let xhtp = new XMLHttpRequest();
		xhtp.open('get', `delStudentServlet?delId=` + id);

		xhtp.send();
		xhtp.onload = function() {
			let result = JSON.parse(xhtp.responseText);
			if (result.retCode == 'OK') {
				document.getElementById(result.retVal).remove();
				alert(result.retVal + '번이 삭제되었습니다.');
			}
			else if (result.retCode == 'NG') {
				console.log(result.retVal);
			}
		}
	})
	return tr;
}

