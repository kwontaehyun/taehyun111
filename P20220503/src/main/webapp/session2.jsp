<%@page import="co.edu.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = (String) session.getAttribute("id");
		String pw = (String) session.getAttribute("pwd");
		out.print("<h3>아이디: " + id + "</h3>");
		out.print("<h3>비밀번호: " + pw + "</h3>");
	%>
</body>
</html>