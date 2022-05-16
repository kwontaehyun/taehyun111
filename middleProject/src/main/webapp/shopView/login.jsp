<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
body{
	margin : 0 auto;
}
</style>

<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
	<c:if test = "${!empty error}">
	<script>
	window.onload = function() {
	    if(!window.location.hash) {
	        window.location = window.location + '#loaded';
	        window.location.reload();
	    }
	}
	alert(`${error}`)
	</script></c:if>
	<a href="http://localhost/middleProject/">yedam shop</a>
	<form action="${pageContext.servletContext.contextPath }/login.do" method="post">
	<p>아이디 : <input type="email" name="email" required></p><br>
	<p>비밀번호 : <input type="password" name="pw" required></p><br>
	<input type="submit" value="로그인">
	</form>
	<form action="insert.jsp" method = "post">
	<input type = "submit" value = "회원가입">
	</form>
	

</body>
</html>