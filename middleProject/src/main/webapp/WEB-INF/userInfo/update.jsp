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
	<c:if test = "${!empty error}"><script>alert(`${error}`)</script></c:if>
<form  name="update" action="${pageContext.servletContext.contextPath }/update.do" method ="post">
 <p>아이디(이메일) : <input type="email" name="email"  value ="${info.email }" required readonly
 style="width:250px;"></p><br>
 <p>비밀번호 : <input type="password" name="pw" id="pw" required></p><br>
 <p>비밀번호 확인: <input type="password" name="pwcheck" id="pwcheck" required ></p>
 <br>
 <p>성별 : <input type="radio" name="gender" value="M" checked>남성
          <input type="radio" name="gender" value="F">여성</p><br>
 <p>생년월일 : <input type="date" name="jumin" value="${info.jumin }" id ="jumin" required
style="width:250px;"
 ></p><br>
 <p>주소 : <input type="text" name="address" value="${info.address }" required style="width:350px;" ></p><br>
  <input type="hidden" name="acces"><br>
   <input type="hidden" name="loginway"><br>
 <p>휴대폰번호 : <input type="number"  id="phone" value="${info.phone }" name="phone" style="width:250px;" required
 placeholder="숫자만 입력하세요 ex)01010041004"></p><br>
 <p><input type="submit" value="회원정보수정" >
</form>


</body>
</html>