<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<span>선택 : </span><input id="delete" type="checkbox"
						value="${list.proDuctNum}" name="proDuctName"> <img
						src="upload/${list.pImg }" id="prodimg">
					<div id="comment">
						<h4>제품이름 : ${list.proDuctName }</h4>
						<h4>설명 : ${list.comment }</h4>
						<c:if test="${list.sale == null || list.sale == 0}">
							<h4>
								<span>${list.proDuctPrice}원</span>
							</h4>
						</c:if>
						<c:if test="${list.sale ne 0}">
							<p>
								<span>${list.proDuctPrice}원</span> ${list.sale}%
							</p>
							<h4>
								<fmt:formatNumber type="number" pattern="0"
									value="${list.proDuctPrice - list.proDuctPrice * (list.sale/100)}" />
								원
							</h4>
						</c:if>
						<h4>성별 : ${list.gender}</h4>
					</div>
				</div>
			</c:forEach>

			<button id="delBtn">선택삭제</button>
			<button id="selBtn">전체선택</button>
			<button id="kakaopayBtn">카카오페이 결제</button>

		</c:if>
	</div>
	<c:if test="${!empty buy }">
		<script>
	alert(`${buy}`)
	</script>
	</c:if>
	<script src="shoppingBasket.js"></script>
</body>
</html>