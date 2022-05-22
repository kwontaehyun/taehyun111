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
	<%
String email = (String) session.getAttribute("email");
int role = (Integer) session.getAttribute("role");
%>

	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="http://localhost/middleProject/">yedam
				shop</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4" id="ulTag">

				</ul>
			
	<c:choose>
		<c:when test="${!empty email && role == 0}">
		<a class="navbar-brand" id = "mypage" href = "mypage.jsp">마이페이지</a>
				<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
				<a class="navbar-brand" id = "logout" href="javascript:kakaoLogout();">로그아웃</a>
				<form id="form-kakao-logout" method="post" action="/middleProject/logout.do">
				</form>
				<script>
				window.Kakao.init("046c047958de0cd3b816a19cdd02fa4b")
					function kakaoLogout() {
			            if (!Kakao.Auth.getAccessToken()) {
			                document.querySelector('#form-kakao-logout').submit();
			                return;
			            }
			            Kakao.Auth.logout(function() {
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
				</c:when>
		
		
		<c:when test = "${!empty email && role == 1}">
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4" id = "ulTag">
				</ul>
				
				<a class="navbar-brand" id = "mypage" href = "mypage.jsp">관리자페이지</a>
				<a class="navbar-brand" id = "logout" href = "logout.do">로그아웃</a>
			</div>
		</c:when>
		<c:when test = "${email == null}">
				<a href="http://localhost/middleProject/shopView/login.jsp"><svg
						xmlns="http://www.w3.org/2000/svg" width="35" height="35"
						fill="currentColor" class="bi bi-person" viewBox="0 0 16 16"
						id="loginBtn">
  <path
							d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z" />
</svg></a>
		
		</c:when>
	</c:choose>
				<form class="d-flex">
					<a class="btn btn-outline-dark"
						href="http://localhost/middleProject/shoppingBasket.do"> <i
						class="bi-cart-fill me-1"></i> Cart <span
						class="badge bg-dark text-white ms-1 rounded-pill" id = "CartCnt"></span>
					</a>

				</form>

			</div>
		</div>
	</nav>
	<script src="menu.js"></script>
</body>
</html>