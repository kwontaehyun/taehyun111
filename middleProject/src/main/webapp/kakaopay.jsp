<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action = "kakaopay.do">
	<input type = "hidden" value = "가죽자켓" name = "item_name"> <!-- 상품명 String-->
	<input type = "hidden" value = "으아" name = "item_code"> <!-- 상품코드 String-->
	<input type = "hidden" name = "quantity" value = "1">  <!-- 상품수량 int -->
	<input type = "hidden" name = "total_amount" value = "24000"> <!-- 상품 총액 int -->
	<input type = "hidden" name = "tax_free_amount" value = "0"> <!-- 상품 비과세 금액 -->
	<input type = "submit" value = "카카오페이">
	</form>

</body>
</html>