/**
 * 
 */
 
 let btnList = document.getElementById('btnList');
 
 let allTr = document.querySelectorAll("table tr") // table 하위에 있는 tr 다 가져오기.
 let btn = document.querySelector("button");
 btn.setAttribute('id', "allChk");
 
 let wholeBtn = document.createElement("button");
 wholeBtn.innerHTML = '전체선택';
 wholeBtn.setAttribute('id', "checkAll");
 btnList.appendChild(wholeBtn);
 
 allTr.forEach(function(tr){
	console.log(tr);
	
	btn.addEventListener('click', function(){
		if(tr.firstElementChild.firstElementChild.checked == true){
			tr.remove();
		}	
		
	})
	
	wholeBtn.addEventListener('click', function(){
		tr.firstElementChild.firstElementChild.checked = true;
	})
	
})

