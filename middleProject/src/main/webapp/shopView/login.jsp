<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	margin: 0 auto;
}
</style>

<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body id = "body">
	<c:if test="${!empty error}">
		<script>
			alert(`${error}`)
		</script>
	</c:if>
	<a href="http://localhost/middleProject/">yedam shop</a>
	<form action="${pageContext.servletContext.contextPath }/login.do"
		method="post">
		<p>
			아이디 : <input type="email" name="email" required>
		</p>
		<br>
		<p>
			비밀번호 : <input type="password" name="pw" required>
		</p>
		<a href = "http://localhost/middleProject/findID.jsp">아이디 찾기</a>
		<a href = "http://localhost/middleProject/findPW.jsp">비밀번호 찾기</a>
		<br> <input type="submit" value="로그인">
	</form>
	<form action="${pageContext.servletContext.contextPath }/shopView/insert.jsp" method="post">
		<input type="submit" value="회원가입"
			onsubmit="location.href='${pageContext.servletContext.contextPath }/shopView/insert.jsp'">
	</form>

	<form id="form-kakao-login" method="post"
		action="/middleProject/kakaologin.do">
		<input type="hidden" name="email" /> <input type="hidden"
			name="birthday" /> <input type="hidden" name="gender" />
			<input type = "hidden" name = "age_range">
	</form>

	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script>
		window.Kakao.init("046c047958de0cd3b816a19cdd02fa4b")
		Kakao.Auth.login({
			success : function(auth) {
				Kakao.API.request({
					url : '/v2/user/me',
					success : function(response) {
						// 사용자 정보를 가져와서 폼에 추가.
						var account = response.kakao_account;
						document.querySelector(
								'#form-kakao-login > input[name=email]')
								.setAttribute("value", account.email)
						document.querySelector(
								'#form-kakao-login > input[name=birthday]')
								.setAttribute("value", account.birthday)
						document.querySelector(
								'#form-kakao-login > input[name=gender]')
								.setAttribute("value", account.gender)
						// 사용자 정보가 포함된 폼을 서버로 제출한다.
						document.querySelector(
								'#form-kakao-login > input[name=age_range]')
								.setAttribute("value", account.age_range)
						document.querySelector('#form-kakao-login').submit();
					},
				});
			}
		});
		
		let a = document.createElement('a');
		let img = document.createElement('img');
		img.setAttribute("src", "../kakaologin/로그인이미지.png");
		a.appendChild(img);
		document.getElementById('body').appendChild(a);
		
		a.addEventListener('click',function(){
			Kakao.Auth.login();
		})
		
		
		
	</script>

</body>
</html>