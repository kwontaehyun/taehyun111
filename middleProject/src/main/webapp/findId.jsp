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
	String phoneNum = (String) session.getAttribute("phoneNum");
%>
 <c:if test = "${!empty error}">
     <script>
           alert(`${error}`)
     </script>
</c:if>
           
<c:if test = "${!empty success}">
    <script>
           alert(`${success}`)
    </script>
</c:if>

	<form action = "${pageContext.servletContext.contextPath }/phoneCheck.do">
	<span>휴대폰 번호 : </span>
	<input type = "number" name = "phone" value = "${phoneNum }">
	<input type = "submit" value ="인증">
	</form>
	<c:if test = "${!empty phoneNum}">
	<form action = "${pageContext.servletContext.contextPath }/phoneKeyCheck.do">
	<span>인증번호 : </span>
	<input type = "number" name = "code">
	<input type = "submit" value ="확인">
	</form>
	</c:if>
	
	<c:if test = "${!empty emailFind}">
	<p>귀하의 Yedam Shop 계정은 ${emailFind} 입니다.</p>
	</c:if>
	
</body>
</html>