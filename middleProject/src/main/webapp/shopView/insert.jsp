<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h3>회원가입</h3>
<form action="" method ="post">
 <p>아이디(이메일) : <input type="email" name="email"></p><br>
 <p>비밀번호 : <input type="password" name="pw" ></p><br>
 <p>비밀번호 확인 : <input type="password" name="pw" ></p><br>
 <p>성별 : <input type="text" name="gender"></p><br>
 <p>주민번호 : <input type="text" name="jumin"></p><br>
 <p>휴대폰번호 : <input type="tel" name="phone"></p><br>
 <p>주소 : <input type="text" name="address"></p><br>
 <input type="hidden" name="acces"><br>
 <p><input type="submit" value="회원가입"></p>

</form>

</body>
</html>