/**
 * 
 */

let allBtn = document.querySelectorAll('#page');
console.log(allBtn)
allBtn.forEach(function pageing(val, idx) {
	val.innerHTML = idx + 1;
	val.addEventListener('click', function() {

		location.href = `http://localhost/middleProject/userPay.do?firstPage=${1 + 5 * idx}&lastPage=${(idx + 1) * 5}`
	});
});

let Btn = document.querySelectorAll('#pageing');
console.log(allBtn)
Btn.forEach(function pageing(val, idx) {
	val.innerHTML = idx + 1;
	val.addEventListener('click', function() {

		location.href = `http://localhost/middleProject/adminPay.do?firstPage=${1 + 5 * idx}&lastPage=${(idx + 1) * 5}`
	});
});