<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberUpdateOutput.jsp</title>
</head>
<body>
<h3>${id}가 수정되었습니다</h3>
<h3>이름 : ${name } / 이메일 : ${email} / 비밀번호 : ${passwd}</h3>

<jsp:include page="home.jsp"></jsp:include>

</body>
</html>