<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script>
function removeCheck(){
	 if (confirm("정말 삭제하시겠습니까??") ){ 
		 document.form_del.action = "${pageContext.servletContext.contextPath }/delete.do";
	     document.removefrm.submit();
	 }
}

</script>
</head>
<body>
<h4>회원 탈퇴</h4><br>
<form name ="form_del" method="post">
<p>${info.email } 님 안녕하세요</p><br>
<p>여기는 회원탈퇴 페이지입니다.</p><br>
<p>장바구니에 아무것도 없어야.. 탈퇴가능...</p>
<input type="submit" value = "탈퇴" onclick="removeCheck()">
</form>
</body>

</html>