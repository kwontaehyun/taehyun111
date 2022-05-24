<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원탈퇴</title>
<style>
@import url('https://cdn.jsdelivr.net/gh/orioncactus/pretendard/dist/web/static/pretendard.css');
* {
	margin: 0;
	padding: 0;
	 font-family: Pretendard, -apple-system, BlinkMacSystemFont, system-ui, Roboto, 'Helvetica Neue', 'Segoe UI', 'Apple SD Gothic Neo', 'Noto Sans KR', 'Malgun Gothic', sans-serif;
}

.del {
	margin: 0 auto;
	width: 500px;
	height: 1000px;
}

header h3 {
	text-align: center;
	margin: 20px 0px 30px 0px;
	padding-top: 30px;
	height: 60px;
	font-weight: bold;
}

html {
	height: 100%;
}

body {
	height: 100%;
	font-family: 'Noto Sans KR';
}

header {
	text-align: center;
	margin: 20px;
}

form {
	margin: 0 auto;
	text-allign: center;
}

form tr  {
 margin : 15px;
 padding : 15px;
}

table {
border-spacing : 0;
margin:0;
padding:0;
border:0;
width:100%
}

.del table td {
 padding: 6px 0;
 position:relative;
}
input{
border:none;

}




</style>


</head>
<body>
<script>
	function removeCheck() {
		if (confirm("정말 탈퇴하시겠습니까??")) {
			document.form_del.action = "${pageContext.servletContext.contextPath }/delete.do";
			document.removefrm.submit();
		}
	}
	</script>	
		<div class="del">
	<header>
		<h3>회원 탈퇴</h3>
	</header>
	<c:if test = "${memo}"><script>alert(`${memo}`)</script></c:if>
		<form name="form_del" method="post">
		
			<table>
				<tr>
					<th><span>${info.email }님 안녕하세요</span></th>
				</tr>
				<tr>
					<th><span>여기는 회원탈퇴 페이지입니다.</span></th>
				</tr>
				<tr>
					<th><input type="submit" value="탈퇴" onclick="removeCheck()"></th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>