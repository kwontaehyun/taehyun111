<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
body{
	margin : 10px auto;
	padding: 20px;
}

</style>

<title></title>
</head>

<body>
<h3>회원가입</h3>

<c:if test = "${!empty error}"><script>alert(`${error}`)</script></c:if>
<form id ="join" name="join" action="${pageContext.servletContext.contextPath }/Insert.do" method ="post">
 <p>아이디(이메일) : <input type="email" name="email" required
 style="width:250px;"></p><br>
 <p>비밀번호 : <input type="password" name="pw" id="pw" required></p><br>
 <p>비밀번호 확인: <input type="password" name="pwcheck" id="pwcheck" required ></p>
 <br>
 <p>성별 : <input type="radio" name="gender" value="M">남성
          <input type="radio" name="gender" value="F">여성</p><br>
 <p>주민번호 : <input type="number" name="jumin" id ="jumin"required
style="width:250px;"
 placeholder="숫자만 입력하세요 ex)YYMMDD000000"
 ></p><br>
 <p>주소 : <input type="text" name="address"required style="width:350px;" ></p><br>
 <input type="hidden" name="acces"><br>
 <p>휴대폰번호 : <input type="number"  id="phone" name="phone" style="width:250px;" required
 placeholder="숫자만 입력하세요 ex)01010041004"></p><br>
 <p><input type="submit" value="회원가입" ></p>
</form>
	


</body>