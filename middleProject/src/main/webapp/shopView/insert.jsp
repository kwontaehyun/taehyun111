<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>

<body>
<h3>회원가입</h3>

<c:if test = "${!empty error}"><script>alert(`${error}`)</script></c:if>
<form id ="join" name="join" action="${pageContext.servletContext.contextPath }/Insert.do" method ="post">
 <p>아이디(이메일) : <input type="email" name="email" required></p><br>
 <p>비밀번호 : <input type="password" name="pw" id="pw" required></p><br>
 <p>비밀번호 확인: <input type="password" name="pwcheck" id="pwcheck" required ></p>
 <br>
 <p>성별 : <input type="radio" name="gender" value="M">남성
          <input type="radio" name="gender" value="F">여성</p><br>
 <p>주민번호 : <input type="number" name="jumin" id ="jumin"required></p><br>
 <p>주소 : <input type="text" name="address"required></p><br>
 <input type="hidden" name="acces"><br>
 <p>휴대폰번호 : <input type="tel"  id="phone" name="phone" value="010"required></p><br>
 <p><input type="submit" value="회원가입" ></p>
</form>
	


</body>