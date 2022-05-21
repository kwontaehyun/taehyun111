/**
 * 
 */

let checkBoxAry = document.querySelectorAll('#delete');

let btn = document.getElementById('delBtn')
let cnt = 0;
let selcnt = 1;
let paycnt = 0;
let proDuctName = ""
let proDuctNameAry = ""

let proDuctNum = ""
let proDuctNumAry = ""

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

let payBtn = document.getElementById('kakaopayBtn')
payBtn.addEventListener('click', function(){
	console.log('1111');
	checkBoxAry.forEach((val) => {
		if (val.checked == true) {
			if(paycnt == 0){
				proDuctNum = `?proDuctNum${paycnt}=`+val.value;
				proDuctNumAry += proDuctNum;
			}
			else{
				proDuctNum = `&proDuctNum${paycnt}=`+val.value;
				proDuctNumAry += proDuctNum;
			}
			paycnt++;
		}
	})
	location.href = `kakaopay.do${proDuctNumAry}&cnt=${paycnt}&check=check`;
	paycnt=0;
})


