<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#container {
	width: 70%;
	margin: 0 auto;
}

#prodimg {
	width: 300px;
	height: 250px;
}

#comment {
	
}

#clear {
	
}
</style>
</head>
<body>
	<h4>장바구니</h4>
	<div id=container>
		<c:if test="${!empty list}">
			<c:forEach items="${list}" var="list">
					<div id="checkDelete">
						<span>선택 : </span><input id = "delete" type = "checkbox" value = "삭제">
						
						<img src="upload/${list.pImg }" id="prodimg">
						<div id="comment">
							<h4>제품이름 : ${list.proDuctName }</h4>
							<h4>설명 : ${list.comment }</h4>
							<c:if test="${list.sale == null || list.sale == 0}">
								<h4>${list.proDuctPrice}원</h4>
							</c:if>
							<c:if test="${list.sale ne 0}">
								<p>
									<span>${list.proDuctPrice}원</span> ${list.sale}%
								<p>
								<h4>${list.proDuctPrice - (vo.proDuctPrice*(list.sale/100))}원</h4>
							</c:if>
							<h4>성별 : ${list.gender}</h4>
							<form action = "basketDelete.do" method = "get">
							<input type = "hidden" name = "proDuctName" value = "${list.proDuctName}">
							<input type = "submit" value = "삭제하기">
							</form>
						</div>
					</div>
			</c:forEach>
			<c:if test = "${!empty moneySum}"><h4>총 합계 : ${moneySum}원</h4> </c:if>

		</c:if>
	</div>
</body>
</html>