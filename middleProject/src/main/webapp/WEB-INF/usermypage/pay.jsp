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
</style>
</head>
<body>
	<div id=container>
		<c:if test="${!empty list}">
<h2>📃구매내역</h2>
			<c:forEach items="${list}" var="list">
				<div id="checkDelete">
					
					<div id="comment">
					
						<table class="list-table">
						<div id="content">
						<thead>
						
						 <tr>
				              <th width="350">상품이름</th>
				              <th width="350">상품사진</th>
				              <th width="120">상품가격</th>
				              <th width="150">상품수량</th>
				              <th width="100">구매날짜</th>
				           </tr>
						
						<tr>
						<div class="bak_item">
						<th width="350">${list.proDuctName }</th>
						<th><img src="upload/${list.pImg }" id="prodimg"></th>
						</div>
						<th width="350">${list.payPrice}원</th>
						<th width="350">${list.itemCount }개</th>
						<th width="350">${list.date}</th>
</tr>
					</thead>
					
					</table>
					</div>
				
				</div>
			</c:forEach>
	</c:if>
</body>
</html>