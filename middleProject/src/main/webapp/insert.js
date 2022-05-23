/**
 * 
 */

let loginbtn = document.getElementById('emailcheck')
let phoneNumCheck = document.getElementById('phoneNumCheck')
let idCheck = document.getElementById('idCheck')

let phoneCheck = document.getElementById('phoneCheck')

loginbtn.addEventListener('click', function() {
	let email = document.getElementById('email');
	location.href = `http://localhost/middleProject/insertCheck.do?email=${email.value}`
	
})


phoneNumCheck.addEventListener('click', function() {
	let phone = document.getElementById('phone');
	location.href =`http://localhost/middleProject/phoneCheck.do?phone=${phone.value}`
})


idCheck.addEventListener('click', function(){
	let key = document.getElementById('key');
	location.href =`http://localhost/middleProject/idphoneCheck.do?key=${key.value}`
	
})

phoneCheck.addEventListener('click', function(){
	let phonekey = document.getElementById('phonekey');
	location.href = `http://localhost/middleProject/idphoneCheck.do?phonekey=${phonekey.value}`
})