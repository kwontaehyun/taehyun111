<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
int role = (Integer) session.getAttribute("role");
%>
<body>
	<c:choose>
		<c:when test="${role == 1}"><jsp:forward page="admin.mypage.tiles"></jsp:forward></c:when>
		<c:otherwise>
			<jsp:forward page="user.mypage.tiles"></jsp:forward>
		</c:otherwise>
	</c:choose>
</body>
</html>