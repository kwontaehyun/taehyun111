<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* 버튼 */
button {
    margin: 20px;
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

.w-btn:active {
    transform: scale(1.5);
}

.w-btn-outline:active {
    transform: scale(1.5);
  
}
.w-btn-yellow-outline:hover {
    background-color: #ffea00;
    color: #6e6e6e;
}
.w-btn-yellow {
    background-color: #fce205;
    color: #6e6e6e;
    width : 124px;
    height : 54px;
}
.kakaoimg {
width : 10px;
height : 10px;
}
#kakaopayBtn {
width : 110px;
padding: 5px 10px 10px 5px;
}
h2{
padding:30px 10px;

margin : 0 auto;
text-align : center;
}
#btn{
text-align: center;
}


</style>
</head>
<body >
<%
String email = (String) session.getAttribute("email");
int role = (Integer) session.getAttribute("role");
%>

<c:if test = "${!empty error }">
	<script>
	alert('${error}')
	</script>
	</c:if>
	<c:if test="${!empty buy }">
		<script>
			alert(`${buy}`)
		</script>
	</c:if>
	
   <!-- Section-->
   <section class="py-5" id = "list">
      <script src = "mainhome.js"></script>
      <div id = "btn"  > 
       <c:if test ="${!empty email && role == 1}">
      <div>
				<form action="productInsert.jsp">
					<input type="submit" value="상품등록"  class="w-btn-outline w-btn-yellow-outline">
				</form>
			</div>
      </c:if>
      </div>
      
     
      
   </section>
   
</body>
</html>