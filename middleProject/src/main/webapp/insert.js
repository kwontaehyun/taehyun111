/**
 * 
 */


fetch('../userList.do')
	.then(result => result.json())
	.then(result => {
		let loginbtn = document.getElementById('emailcheck')
		let phoneNumCheck = document.getElementById('phoneNumCheck')

		let email = document.getElementById('email')
		let phone = document.getElementById('phone');
		loginbtn.addEventListener('click', function() {
			location.href = `http://localhost/middleProject/insertCheck.do?email=${email.value}`
		})

		phoneNumCheck.addEventListener('click', function() {
			location.href = `http://localhost/middleProject/phoneCheck.do?phone=${phone.value}`
		})
		console.log(result);
		let pTag = document.getElementById('ppp');

		result.forEach(val => {
			pTag.innerHTML = ''
			email.addEventListener('change', function() {
				for (let field in val) {

					if (field == 'email') {
						let emailvalue = document.getElementById('email').value;
						if (val[field] == emailvalue) {
							pTag.innerHTML = '이미 존재하는 이메일 계정입니다.';
						}
					}
				}
			})
		})
		
		let pwcheck = document.getElementById('pwcheck');
		pwcheck.addEventListener('change', function() {
			let pw = document.getElementById('pw').value;
			let pwOverlapCheck = document.getElementById('pwOverlapCheck');
			if (pw != document.getElementById('pwcheck').value) { 
				pwOverlapCheck.innerHTML = '비밀번호가 다릅니다'
			}else{
				pwOverlapCheck.innerHTML = '비밀번호 체크 완료'
			}
		})

	})
	.catch(error => console.log(error))


