/**
 * 
 */

	window.Kakao.init("046c047958de0cd3b816a19cdd02fa4b")
	let urlInfo = [];
	function kakaoLogin() {
		window.Kakao.Auth.login({
			
			scope: 'account_email, gender , birthday',
			success : function(authObj){
				window.Kakao.API.request({
					url:'/v2/user/me',
					
					success: res =>{
						let kakao_account = res.kakao_account;
						urlInfo.push(kakao_account.email)
						urlInfo.push(kakao_account.gender)
						urlInfo.push(kakao_account.birthday)
						console.log(urlInfo)
					}
				});
				
			}
		});
	}
		