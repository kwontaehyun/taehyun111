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
	<c:if test="${!empty error}">
		<script>
			alert(`${error}`)
		</script>
	</c:if>
	
	<c:if test="${!empty checkMeg}">
		<script>
			alert(`${checkMeg}`)
			setTimeout(location.href='http://localhost/middleProject/shopView/login.jsp',4000);
		</script>
	</c:if>

	<form action = "${pageContext.servletContext.contextPath }/idFind.do">
	<span>이메일 : </span><input type = "email" name = "email" value = "${email }" placeholder="이메일을 입력해주세요...">
	<input type = "submit" value = "인증번호 받기">	
	</form>
	<c:if test = "${!empty meg }">
	<form action = "${pageContext.servletContext.contextPath }/idFindCheck.do">
	<span>인증번호 : </span><input type = "text" name = "key">
	<input type = "submit" value = "확인">
	</form>
	</c:if>
</body>
</html>