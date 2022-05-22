<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test = "${!empty list}">
		<c:forEach items="${list}" var="list">
		<img src="upload/${list.pImg }">
		<h4>제품이름 : ${list.proDuctName }</h4>
		<h4>가격 : ${list.payPrice}원</h4>
		<h4>수량 : ${list.itemCount }개</h4>
		<h4>구매자 아이디 : ${list.email }</h4>
		<h4>구매 날짜 : ${list.date}</h4>
		</c:forEach>
		<h4>총 판매가격 : ${money }</h4>
	</c:if>
</body>
</html>