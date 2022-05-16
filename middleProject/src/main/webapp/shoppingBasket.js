/**
 * 
 */

let checkBoxAry = document.querySelectorAll('#delete');

let btn = document.getElementById('delBtn')


btn.addEventListener('click', function() {
	checkBoxAry.forEach((val) => {
		if (val.checked == true) {
			let proDuctNameAry = val.value;
			btn.setAttribute("onclick", `document.location.href='basketDelete.do?proDuctName=${proDuctNameAry}'`)
			//val.parentElement.remove();
		}
	})
	
})

