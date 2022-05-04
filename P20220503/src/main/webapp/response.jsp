<%@page import="co.edu.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response.jsp</title>
</head>
<body>
	<%
		String id = (String) request.getAttribute("id"); //리턴이 오브젝트타입이기때문에 형변환해줘야함.
		String name = (String) request.getAttribute("name");
		Student student = (Student) request.getAttribute("result");
	%>
	<h3>id: <%=id %></h3>
	<h3>name: <%=name %></h3>
	<h3>no: <%=student.getStuNo() %></h3>
	<h3>name: <%=student.getStuName() %></h3>
	
</body>
</html>