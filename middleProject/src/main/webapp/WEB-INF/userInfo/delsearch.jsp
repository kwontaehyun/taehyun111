<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h3>회원 탈퇴</h3>
<form action="${pageContext.servletContext.contextPath }/delete.do" method="post">
<p>${info.email } 님 안녕하세요</p>
<p>여기는 회원탈퇴 페이지입니다.</p>
<input type="submit" value = "탈퇴">
</form>
</body>
</html>