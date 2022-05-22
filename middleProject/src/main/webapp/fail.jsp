<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
if (confirm("결제에 실패했습니다. 이전 창으로 돌아가시겠습니까?") == true) { //확인
	location.href = `http://localhost/middleProject/shoppingBasket.do`
} else { //취소
	location.href = `http://localhost/middleProject/index.jsp`
}
</script>
</body>
</html>