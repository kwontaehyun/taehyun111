<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
 <form action="${pageContext.servletContext.contextPath }/list.do" method="post">

			<p>이메일 : ${info.email }</p>
			<p>비밀번호 : ${info.pw }	</p>
			<p>성별 : ${info.gender }</p>
			<p>주소 : ${info.address }</p>
			<p>생년월일 : ${info.jumin }</p>	
			<p>전화번호 : ${info.phone }</p>

</form>
</body>
</html>