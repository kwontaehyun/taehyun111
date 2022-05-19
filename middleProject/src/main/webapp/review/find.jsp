<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>find.jsp</title>
</head>
<body>
	<h3>수정조회입니다.</h3>
	<form action="${pageContext.servletContext.contextPath }/select.do" method="get">
		<input type="email" name='content' readonly value='${list.email}'>
	</form>
<form action="${pageContext.servletContext.contextPath }/moReview.do" method="post"></form>
<p>내용</p>
			<textarea rows="6" cols="50" name="content" required value='${list.content}'></textarea>



</body>
</html>