<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#mypage{
	font-size : 16px;
	font-weight : bold;
}
#logout{
	font-size : 16px;
	font-weight : bold;
}
</style>

</head>
<body>
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="http://localhost/middleProject/">yedam shop</a>
			
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4" id = "ulTag">
				</ul>
				
				<a class="navbar-brand" id = "mypage" href = "mypage.jsp">마이페이지</a>
				<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
				<a class="navbar-brand" id = "logout" href="javascript:kakaoLogout();">로그아웃</a>
				<form id="form-kakao-logout" method="post" action="/middleProject/logout.do">
				</form>
				<script>
				window.Kakao.init("046c047958de0cd3b816a19cdd02fa4b")
					function kakaoLogout() {
			            if (!Kakao.Auth.getAccessToken()) {
			                alert('Not logged in.');
			                document.querySelector('#form-kakao-logout').submit();
			                return;
			            }
			            Kakao.Auth.logout(function() {
			                alert('logout ok\naccess token -> ' + Kakao.Auth.getAccessToken());
			                document.querySelector('#form-kakao-logout').submit();
			            });
			            Kakao.API.request({
			            	  url: '/v1/user/unlink',
			            	  success: function(response) {
			            	    console.log(response);
			            	  },
			            	  fail: function(error) {
			            	    console.log(error);
			            	  },
			            	});
			        }
				</script>
				
				
				<form class="d-flex">
					<a class="btn btn-outline-dark" href= "http://localhost/middleProject/shoppingBasket.do">
						<i class="bi-cart-fill me-1"></i> Cart <span
							class="badge bg-dark text-white ms-1 rounded-pill" id = "CartCnt"></span>
					</a>

				</form>

			</div>
		</div>
	</nav>
	<script src = "menu.js"></script>
</body>
</html>