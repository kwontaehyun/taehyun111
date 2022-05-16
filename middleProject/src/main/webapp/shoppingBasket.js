/**
 * 
 */

let checkBoxAry = document.querySelectorAll('#delete');

let btn = document.getElementById('delBtn')
let cnt = 0;
let proDuctName = ""
let proDuctNameAry = ""
btn.addEventListener('click', function() {
	checkBoxAry.forEach((val) => {
		if (val.checked == true) {
			if(cnt == 0){
				proDuctName = "?proDuctName="+val.value;
				proDuctNameAry += proDuctName;
			}
			else{
				proDuctName = "&proDuctName="+val.value;
				proDuctNameAry += proDuctName;
			}
			 
			btn.setAttribute("onclick", `document.location.href='basketDelete.do'${proDuctNameAry}`)
			//val.parentElement.remove();
		}
	})
	
})

