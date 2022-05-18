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
%>

<c:choose>
		<c:when test="${!empty email}"><jsp:forward
				page="user.detailpage.tiles"></jsp:forward></c:when>
		<c:otherwise><jsp:forward page="guest.detailpage.tiles"></jsp:forward></c:otherwise>
	</c:choose>
</body>
</html>