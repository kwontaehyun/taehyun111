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

let allBtn = document.querySelectorAll('#pageing');

allBtn.forEach((val, idx) => {
	val.innerHTML = idx+1;
	val.addEventListener('click', function() {
		location.href= `http://192.168.0.8/middleProject/shoppingBasket.do?firstPage=${1 + (5 * (idx))}&lastPage=${(idx+1) * 5}`
	});
	
})

btn.addEventListener('click', function() {
	checkBoxAry.forEach((val) => {
		if (val.checked == true) {
			if (cnt == 0) {
				proDuctName = `?proDuctName${cnt}=` + val.value;
				proDuctNameAry += proDuctName;
			}
			else {
				proDuctName = `&proDuctName${cnt}=` + val.value;
				proDuctNameAry += proDuctName;
			}
			cnt++;
		}
	})

	if (cnt == 0) {
		alert('삭제하실 품목을 선택해주세요');
	}
	else {
		location.href = `basketDelete.do${proDuctNameAry}&cnt=${cnt}`;
		cnt = 0;
	}

})

let selbtn = document.getElementById('selBtn')
selbtn.addEventListener('click', function() {
	checkBoxAry.forEach(val => {
		if (selcnt % 2 == 0) {
			val.checked = false;

		} else {
			val.checked = true
		}

	})
	selcnt++;
})

let payBtn = document.getElementById('kakaopayBtn')
payBtn.addEventListener('click', function() {
	console.log('1111');
	checkBoxAry.forEach((val) => {
		if (val.checked == true) {
			if (paycnt == 0) {
				proDuctNum = `?proDuctNum${paycnt}=` + val.value;
				proDuctNumAry += proDuctNum;
			}
			else {
				proDuctNum = `&proDuctNum${paycnt}=` + val.value;
				proDuctNumAry += proDuctNum;
			}
			paycnt++;
		}
	})

	if (paycnt == 0) {
		alert('구매하실 품목을 선택해주세요.')
	}
	else {
		location.href = `kakaopay.do${proDuctNumAry}&cnt=${paycnt}&check=check`;
		paycnt = 0;
	}
})


