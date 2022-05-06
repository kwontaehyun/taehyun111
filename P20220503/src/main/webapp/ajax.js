/**
 *  ajax.js
 */
 
 let fields = ['id', 'name', 'email', 'passwd', 'profile'];
 function makeTr(member = {}){
	let tr = document.createElement('tr');
	for(let field of fields){
		let td = document.createElement('td');
		td.innerHTML = `${member[field] ? member[field] : '' }`;
		tr.appendChild(td);
	}
	return tr;
	}
	
	function init(){
		//서버에서 회원리스트 => 화면출력.
		let ajax = new XMLHttpRequest();
		
		fetch('memberListJson.do')
			.then(result =>
				result.json()
			)
			.then(result1 => {
				result1.forEach(val =>{
					document.getElementById('list').appendChild(makeTr(val));
				}) 
				
			})
			.catch(error => console.log(error))
			
		let frm = document.forms.frm
		frm.addEventListener('submit', function(e){
			e.preventDefault();
			
			let formData = new FormData(frm); // form 태그요소를 multipart요청으로 처리.
			
			let a = formDataToEncoding(formData)
			console.log(a)
			
			//for(let keyVal of formData.entries()){
			//	console.log(keyVal[0] + ',' + keyVal[1]);
			//}
			
			//post방식 요청.
			fetch(frm.action,{
				method: 'post',
				headers: {'Content-type' : 'application/x-www-form-urlencoded'},
				body: formDataToEncoding(formData)
			})
				.then(data => data.json())
				.then(result => {
					console.log(result);
					document.getElementById('list').appendChild(makeTr(result));
				})
				.catch(error => console.log(error))
			
		});
	}
	init();
	function formDataToEncoding(frmData = []){
		// id=user1&name=Hong&email=aaa@aa.aa&passwd=1234
		let ary = [];
		for(let keyVal of frmData.entries()){
			ary.push(keyVal[0] + '=' + keyVal[1]);
		}
		return ary.join('&');
	}
	

