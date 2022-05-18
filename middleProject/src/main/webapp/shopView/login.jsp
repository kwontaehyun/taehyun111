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
<body>
<<<<<<< HEAD
	<c:if test="${!empty error}">
		<script>
=======
	<c:if test = "${!empty error}">
	<script>
	
	alert(`${error}`)
	</script></c:if>
	<a href="http://localhost/middleProject/">yedam shop</a>
	<form action="${pageContext.servletContext.contextPath }/login.do" method="post">
	<p>아이디 : <input type="email" name="email" required></p><br>
	<p>비밀번호 : <input type="password" name="pw" required></p><br>
	<input type="submit" value="로그인">
	</form>
	<form action="insert.jsp" method = "post">
	<input type = "submit" value = "회원가입" onsubmit = "location.href='${pageContext.servletContext.contextPath }/shopView/insert.jsp'">
	</form>
>>>>>>> branch 'master' of https://github.com/kwontaehyun/taehyun111
	
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
		<br> <input type="submit" value="로그인">
	</form>
	<form action="insert.jsp" method="post">
		<input type="submit" value="회원가입"
			onsubmit="location.href='${pageContext.servletContext.contextPath }/shopView/insert.jsp'">
	</form>

	<button onclick="javascript:kakaoLogin();">
		<img src="../kakaologin/로그인이미지.png">
	</button>
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script type="text/javascript">
	window.Kakao.init("046c047958de0cd3b816a19cdd02fa4b")
		function kakaoLogin() {
		window.Kakao.Auth.login({
			
			scope: 'account_email, gender , birthday',
			redirectUri: `http://localhost/middleProject/kakaologin.do`
		});
	}
	
	</script>




</body>
</html>