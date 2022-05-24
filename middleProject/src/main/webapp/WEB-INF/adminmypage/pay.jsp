<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import url('https://cdn.jsdelivr.net/gh/orioncactus/pretendard/dist/web/static/pretendard.css');
*{
	box-sizing:border-box;
	padding:0;
	 font-family: Pretendard, -apple-system, BlinkMacSystemFont, system-ui, Roboto, 'Helvetica Neue', 'Segoe UI', 'Apple SD Gothic Neo', 'Noto Sans KR', 'Malgun Gothic', sans-serif;

}
.pading{
margin: 0 auto;
padding-right: 50px;
height:1000px;
}
#right{
float:right;
overfliw:hidden;
padding:20px;
font-size: 20px;
}
#left{
float:left;
padding:20px;
margin-left:2%;
font-size: 20px;
}
table{
clear:both;
text-align: center;
	width:800px;
}
.margin{
	padding:20px;
	margin: 0 auto;
}
tr{
border: 1px solid;

}

th{
background: black;
color:white;
padding:10px;
}
#img{
 	width:170px;
}
#center{
text-align: center;
margin-bottom:20px;
margin-top:20px;

}
</style>
</head>
<body>
<div class="pading">
	
	<c:if test = "${!empty list}">
		<h4 id="left">${prevdate} 결제내역 : ${prevSum }<span>원</span></h4>
		<h4 id="right">${date} 결제내역 : ${currSum }<span>원</span></h4>
		<table>
		<thead>
		<tr >
		<th>상품명</th>
		<th>이미지</th>
		<th>가격</th>
		<th>수량</th>
		<th>구매자 아이디</th>
		<th>구매날짜</th>
		</tr>
		</thead>
		<c:forEach items="${list}" var="list">
		<tbody >
		<tr class="margin">
		<td>${list.proDuctName }</td>
		<td><img src="upload/${list.pImg }" id="img"></td>
		<td>${list.payPrice}<span>원</span></td>
		<td>${list.itemCount }</td>
		<td>${list.email }</td>
		<td>${list.date}</td>
		</tr>
		</tbody >
		</c:forEach>
		</table>
		<h4 id="center">총 판매가격 : ${money }<span>원</span></h4>
	</c:if>
	</div>
</body>
</html>