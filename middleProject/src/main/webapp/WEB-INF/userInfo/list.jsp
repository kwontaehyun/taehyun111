<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath }/list.do" method="post">
<p>회원정보<br></p>
<p>이메일 : ${info.email }<br></p>
<p>성별 : ${info.gender }<br></p>
<p>생년월일 : ${info.jumin }<br></p>
<p>휴대폰번호 : ${info.phone }<br> </p>
<p>주소 : ${info.address }<br></p>
</form>
</body>
</html>