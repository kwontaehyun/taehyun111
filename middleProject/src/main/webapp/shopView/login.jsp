<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
@import url('https://cdn.jsdelivr.net/gh/orioncactus/pretendard/dist/web/static/pretendard.css');
*{
	font-family: Pretendard, -apple-system, BlinkMacSystemFont, system-ui, Roboto, 'Helvetica Neue', 'Segoe UI', 'Apple SD Gothic Neo', 'Noto Sans KR', 'Malgun Gothic', sans-serif;
}

#body{
	text-align: center;
	margin-top: 150px;
}
table{
margin:0 auto;
}


a{
text-decoration: none;
}
.font{
font-weight: 700;
font-size: 60px;
color: black;

}
#margin{
	margin-top: 20px;
}

td input{
	margin-right: 20px;
	width: 240px;
	padding:5px;
	
}
th {
width: 100px;

}
input[type=submit]{
	margin-top: 20px;
	border: none;
	padding: 15px 150px;
	border-radius: 10px;
	font-size: 20px;
	font-weight: 700;
	margin-bottom:20px;
}
.botton{
	border: none;
	background: none;
	font-size:15px;

}

.kaka{
	background: rgb(253, 249, 0);
	margin-top: 10px;
	border: none;
	padding: 15px 110px;
	border-radius: 10px;
	font-size: 20px;
	font-weight: 700;
}



</style>

<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body id = "body">
<div >
	<c:if test="${!empty error}">
		<script>
			alert(`${error}`)
		</script>
	</c:if>
	<a href="http://localhost/middleProject/" class="font">YEDAM SHOP</a>
	<form action="${pageContext.servletContext.contextPath }/login.do" method="post" id="margin">
		<table>
		<tbody>
		<tr>
		<th >아이디</th>
		<td><input type="email" name="email" required></td>
		</tr>
		<tr>
		<th>비밀번호</th>
		<td><input type="password" name="pw" required> </td>
		</tr>
		</tbody>
		</table>
		<input type="submit" value="로그인">
		</form>
		<div>
			<button type="button" onclick="location.href='http://localhost/middleProject/findId.jsp'" class="botton">아이디 찾기</button>
			<button type="button" onclick="location.href='http://localhost/middleProject/findPW.jsp'" class="botton">비밀번호 찾기</button>
			<button type="button" onclick="location.href='${pageContext.servletContext.contextPath }/shopView/insert.jsp'" class="botton">회원가입</button>
		</div>
		<form id="form-kakao-login" method="post" action="/middleProject/kakaologin.do">
			<input type="hidden" name="email" /> 
			<input type="hidden" name="birthday" /> 
			<input type="hidden" name="gender" />
			<input type = "hidden" name = "age_range">
		</form>
	<p id="reauthenticate-popup-result"></p>
<button id="custom-login-btn" onclick="javascript:Kakao.Auth.loginForm()"  class="kaka" class="bi bi-chat-fill"> 
 <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chat-fill" viewBox="0 0 16 16">
  <path d="M8 15c4.418 0 8-3.134 8-7s-3.582-7-8-7-8 3.134-8 7c0 1.76.743 3.37 1.97 4.6-.097 1.016-.417 2.13-.771 2.966-.079.186.074.394.273.362 2.256-.37 3.597-.938 4.18-1.234A9.06 9.06 0 0 0 8 15z"/>
</svg>  카카오 로그인

  
  
  
  
  <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script type="text/javascript">
		window.Kakao.init("046c047958de0cd3b816a19cdd02fa4b")
		
		let custom = document.getElementById('custom-login-btn');
		custom.addEventListener('click',function(){
			Kakao.Auth.loginForm({
				success : function(auth) {
					Kakao.API.request({
						url : '/v2/user/me',
						success : function(response) {
							// 사용자 정보를 가져와서 폼에 추가.
							var account = response.kakao_account;
							document.querySelector(
									'#form-kakao-login > input[name=email]')
									.setAttribute("value", account.email)
							document.querySelector(
									'#form-kakao-login > input[name=birthday]')
									.setAttribute("value", account.birthday)
							document.querySelector(
									'#form-kakao-login > input[name=gender]')
									.setAttribute("value", account.gender)
							// 사용자 정보가 포함된 폼을 서버로 제출한다.
							document.querySelector(
									'#form-kakao-login > input[name=age_range]')
									.setAttribute("value", account.age_range)
							document.querySelector('#form-kakao-login').submit();
						},
					});
				},
				fail : console.log('1111')
			});
			
		})
		
		
	</script>
	
</button>
</div>

</body>
</html>