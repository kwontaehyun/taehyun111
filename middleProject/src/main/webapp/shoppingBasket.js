/**
 * 
 */

let checkBoxAry = document.querySelectorAll('#delete');

let btn = document.getElementById('delBtn')
let cnt = 0;
let selcnt = 1;
let proDuctName = ""
let proDuctNameAry = ""
btn.addEventListener('click', function() {
	checkBoxAry.forEach((val) => {
		if (val.checked == true) {
			if(cnt == 0){
				proDuctName = `?proDuctName${cnt}=`+val.value;
				proDuctNameAry += proDuctName;
			}
			else{
				proDuctName = `&proDuctName${cnt}=`+val.value;
				proDuctNameAry += proDuctName;
			}
			cnt++;
		}
	})
	location.href = `basketDelete.do${proDuctNameAry}&cnt=${cnt}`;
	cnt=0;
	
})

let selbtn = document.getElementById('selBtn')
selbtn.addEventListener('click',function(){
	checkBoxAry.forEach(val=>{
		if(selcnt % 2 == 0){
			val.checked = false;
			
		}else{
			val.checked = true
		}
		
	})
	selcnt++;
})
