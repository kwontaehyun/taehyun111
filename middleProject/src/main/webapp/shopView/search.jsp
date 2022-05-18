<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${error }
	<form action="${pageContext.servletContext.contextPath }/usersearch.do" method="post">
	  조회 아이디: <input type="text" name="email"><br> 
	  <input type="hidden" name="good" value="search">
	  <input type="submit" value="검색하기">
	</form>
</body>
</html>