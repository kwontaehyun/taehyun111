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
	${error }
	<h3>회원정보수정</h3>
   		<c:choose>
   	 <c:when test="${!empty result }"><h3>${result }</h3></c:when>
   	 <c:otherwise>
	 <form action="${pageContext.servletContext.contextPath }/update.do" method="post">
	 이메일 : <input type="text" name="email" value="${user.email }"><br>
	 비밀번호 : <input type="text" name="pw" value="${user.pw }"><br>
	 성별 : <input type="radio" name="gender" value="M">남성
          <input type="radio" name="gender" value="F">여성<br>
	 주민번호 : <input type="number" name="jumin" value="${user.jumin }"><br>
	 주소 : <input type="text" name="address" value="${user.address }"><br>
	 전화번호 : <input type="text" name="phone" value="${user.phone }"><br>
	 <input type="submit" value="수정"> 
	 </form>	
   	 </c:otherwise>
   	 </c:choose>


</body>
</html>