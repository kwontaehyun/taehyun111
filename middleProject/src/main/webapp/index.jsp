<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
String email = (String) session.getAttribute("email");
String pw = (String) session.getAttribute("pw");
int role = (Integer) session.getAttribute("role");
%>
	<c:choose>
		<c:when test="${!empty email && !empty pw && role == 0}"><jsp:forward page="user.homepage.tiles"></jsp:forward></c:when>
		<c:when test = "${!empty email && !empty pw && role == 1}"><jsp:forward page="admin.homepage.tiles"></jsp:forward></c:when>
		<c:when test = "${email == null && pw == null}">
		<jsp:forward page="myapp.homepage.tiles"></jsp:forward>
		</c:when>
	</c:choose>

</body>
</html>