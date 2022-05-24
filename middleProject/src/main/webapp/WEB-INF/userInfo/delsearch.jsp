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
	width: 800px;
	height: 823px;
}

header h5 {
	font-weight: bold;
	margin-bottom:60px;
}
header h3 {
	text-align: center;
	margin: 20px 0px 80px 0px;
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
    margin-top: 50px;
}


.w-btn {
    position: relative;
    border: none;
    display: inline-block;
    padding: 15px 30px;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    font-weight: 600;
    transition: 0.25s;
background: url( "https://play-lh.googleusercontent.com/W43xj43ErMIs5BQgCdMKEa0NXCoUUW8DjQc5SxcDfLrC26H8sHDmoFIUWLYmsQahpo0" ) no-repeat;
}


.w-btn-outline {
    position: relative;
    padding: 15px 30px;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    font-weight: 600;
    transition: 0.25s;
     border: #fff200;
}

.w-btn:hover {
    letter-spacing: 2px;
    transform: scale(1.2);
    cursor: pointer;
}

.w-btn-outline:hover {
    letter-spacing: 2px;
    transform: scale(1.2);
    cursor: pointer;
}

.w-btn-yellow-outline:hover {
    background-color:rgb(35, 35, 35);
    color: white;
}
.w-btn-yellow {
    background-color: #fce205;
    color: #6e6e6e;
    width : 124px;
    height : 54px;
}
table{
text-align:center;
}


</style>
<script>
	function removeCheck() {
		if (confirm("정말 탈퇴하시겠습니까??")) {
			document.form_del.action = "${pageContext.servletContext.contextPath }/delete.do";
			document.removefrm.submit();
		}
	}
	</script>	

</head>
<body>
		<div class="del">
	<header>
		<h3>회원 탈퇴</h3>
		<h5>회원탈퇴를 신청하기 전에 안내사항을 꼭 확인해주세요.</h5>
	</header>
	<c:if test = "${memo}"><script>alert(`${memo}`)</script></c:if>
		<form name="form_del" method="post">
		
			<table>
				<tr>
					<th><span>${info.email }님 안녕하세요.</span></th>
				</tr>
				<tr>
					<th><span>탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두 삭제됩니다.</span></th>
				</tr>
				<tr>
					<th><span>서비스 탈퇴 후에는 그 동안 이용하셨던 모든 내역의 서비스 등을 이용할 수 없습니다.</span></th>
				</tr>
				<tr>
					<th><span>탈퇴 즉시 개인정보는 삭제되며, 어떠한 방법으로도 복원할 수 없습니다.</span></th>
				</tr>
				<tr>
					<th><span>전자상거래 서비스 등의 거래내역은 전자상거래 등에서의 소비자 보호에 관한 법률에 의거하여 보관됩니다.</span></th>
				</tr>	
	
				<tr>
					<th><input type="submit" id="btn" value="탈퇴" onclick="removeCheck()" class="w-btn-outline w-btn-yellow-outline"></th>
				</tr>
				</table>


		</form>
	</div>
</body>
</html>