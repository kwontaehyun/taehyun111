<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<style>
@import url('https://cdn.jsdelivr.net/gh/orioncactus/pretendard/dist/web/static/pretendard.css');
* {
	margin: 0;
	padding: 0;
	font-family: Pretendard, -apple-system, BlinkMacSystemFont, system-ui, Roboto, 'Helvetica Neue', 'Segoe UI', 'Apple SD Gothic Neo', 'Noto Sans KR', 'Malgun Gothic', sans-serif;
}

.find{
text-align:center;
padding:250px;

}

#tt{
font-weight:580;
}

#phone{
margin-left:10px;
height:30px;
width:200px;
text-align:center;
}

#code{
margin-left:10px;
height:30px;
width:200px;
text-align:center;
}

p{
margin-bottom : 20px;
}

#btn{
margin:24px;
padding:15px 30px;
}

.w-btn {
    position: relative;
    border: none;
    display: inline-block;
    padding: 10px 10x;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 10px 10px rgba(0, 0, 0, 0.2);
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
    transform: scale(0.8);
    cursor: pointer;
}

.w-btn-outline:hover {
    letter-spacing: 2px;
    transform: scale(0.8);
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

#ckbt{
margin-left:7px;
width:75px;
height:34px;
    position: relative;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    text-decoration: solid 1px;
    font-weight: 600;
    transition: 0.25s;
     border: #fff200;


}
</style>
<meta charset="UTF-8">
<title>findId.jsp</title>
</head>
<div class="find">
<body>
<%
	String phoneNum = (String) session.getAttribute("phoneNum");
%>
 <c:if test = "${!empty error}">
     <script>
           alert(`${error}`)
     </script>
</c:if>
           
<c:if test = "${!empty success}">
    <script>
           alert(`${success}`)
    </script>
</c:if>

	<form action = "${pageContext.servletContext.contextPath }/phoneCheck.do">
	<h4>아이디를 잊어버리셨습니까 ? </h4><br>
	<p>가입할 때 사용하신 <span id="tt">휴대폰번호</span>를 입력해주세요.</p>
	<span>휴대폰 번호  
	<input type = "number" name = "phone" value = "${phoneNum }" required placeholder="전화번호를 입력해주세요."></span>
	<br><input id= "btn" class="w-btn-outline w-btn-yellow-outline" type = "submit" value ="인증">
	</form>
	<c:if test = "${!empty phoneNum}">
	<form action = "${pageContext.servletContext.contextPath }/phoneKeyCheck.do">
	<span>인증번호  
	<input type = "number" id="code" name = "code"  placeholder="인증번호를 입력해주세요." required ></span>
	<input  id="ckbt" type = "submit" value ="확인">
	</form>
	</c:if>
	
	<c:if test = "${!empty emailFind}">
	<p>귀하의 Yedam Shop 계정은 ${emailFind} 입니다.</p>
	</c:if>
</div>	
</body>
</html>

