

/**
 * 
 */

let pAry = [];

fetch('../userList.do')
	.then(result => result.json())
	.then(result => {
		let loginbtn = document.getElementById('emailcheck')

		let email = document.getElementById('email')
		loginbtn.addEventListener('click', function() {
			location.href = `http://192.168.0.8/middleProject/insertCheck.do?email=${email.value}`
		})

		console.log(result);
		let pTag = document.getElementById('ppp');

		result.forEach(val => {

			for (let field in val) {
				if (field == 'email') {
					pAry.push(val[field]);
				}
			}

		})


		email.addEventListener('change', function() {
         for (let field in pAry) {
            
            let emailvalue = document.getElementById('email').value;
            if(emailvalue == ''){
               pTag.innerHTML = '';
            }
            else if (pAry[field] == emailvalue && emailvalue != '') {
               pTag.innerHTML = '이미 존재하는 이메일 계정입니다.';
               return;
            }else if(pAry[field] != emailvalue && emailvalue != ''){
               pTag.innerHTML = '사용가능한 이메일 계정입니다.';
            }
            
            if(emailvalue.indexOf('@') == -1 && emailvalue != ''){
               pTag.innerHTML = '아이디는 이메일 형식입니다.'
            }
            if(emailvalue.indexOf('co.') == -1 && emailvalue != ''){
               pTag.innerHTML = '아이디는 이메일 형식입니다.'
            }
            
         }
      })

		let pwcheck = document.getElementById('pwcheck');
		pwcheck.addEventListener('change', function() {
			let pw = document.getElementById('pw').value;
			let pwOverlapCheck = document.getElementById('pwOverlapCheck');
			if (pw != document.getElementById('pwcheck').value) {
				pwOverlapCheck.innerHTML = '비밀번호가 다릅니다'
			} else {
				pwOverlapCheck.innerHTML = '비밀번호 체크 완료'
			}
		})

	})
	.catch(error => console.log(error))


