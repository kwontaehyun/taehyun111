<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* basket */
#container {
height:100%;
margin : 0 auto;
text-align : center;
}

#btn {
margin : 10px 10px;
}
#comment {
margin-top : -25px;
margin : 0 auto;
text-align : center;
width : 80%;
padding-bottom : 25px;
}
#censle{
   text-decoration : line-through;
}
.list-table {
	margin-top: 10px;
	position: relative;
	
}
.list-table thead th{
	height:40px;
	border-top:2px solid #080808;
	border-bottom:1px solid #CCC;
	font-weight: bold;
	font-size: 17px;
}
.list-table tbody td{
	text-align:center;
	padding:10px 0;
	border-bottom:1px solid	 #CCC; height:20px;
	font-size: 14px 
}
.bak_item {
	
	
	
}
#prodimg {
	height : 170px;
	width : 170px;
}
h2{
padding:30px 10px;
margin : 0 auto;
text-align : center;
}

#all {
margin : 0 auto;
text-align:center;
}

#page{
	text-align:center;
	font-size:0;
	margin:0 auto;
	margin : 30px 10px 50px 0px;
	border:1px solid #e6e6e6;
	width:35px;
	height:35px;
	line-height:28px;
	background-color:#fff;
	font-size:20px;
	color:#999999;
 }

</style>
</head>
<body>
	<div id=container>
		<c:if test="${!empty list}">
<h2>๐๊ตฌ๋งค๋ด์ญ</h2>
			<c:forEach items="${list}" var="list">
				<div id="checkDelete">
					
					<div id="comment">
					
						<table class="list-table">
						<div id="content">
						<thead>
						
						 <tr>
				              <th width="350">์ํ์ด๋ฆ</th>
				              <th width="350">์ํ์ฌ์ง</th>
				              <th width="120">์ํ๊ฐ๊ฒฉ</th>
				              <th width="150">์ํ์๋</th>
				              <th width="100">๊ตฌ๋งค๋ ์ง</th>
				           </tr>
						
						<tr>
						<div class="bak_item">
						<th width="350">${list.proDuctName }</th>
						<th><img src="upload/${list.pImg }" id="prodimg"></th>
						</div>
						<th width="350">${list.payPrice}์</th>
						<th width="350">${list.itemCount }๊ฐ</th>
						<th width="350">${list.date}</th>
</tr>
					</thead>
					
					</table>
					</div>
				
				</div>
			</c:forEach>
			<div id = "all">
			<c:forEach begin = "1" end = "${count}" step = "5">
   			<button class="w-btn-outline w-btn-yellow-outline" id="page" onlick="location.href='#'"></button>
   			</c:forEach>
   			</div>
   			<script src = "pay.js">
   			
   			</script>
	</c:if>
</body>
</html>