<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/productInsert.do" method="post" enctype="multipart/form-data">
        상품번호: <input type="number" name="num"><br>
        상품이름: <input type="text" name="name"><br>
        상품가격: <input type="number" name="price"><br>
        카테고리: <input type="text" name="category"><br>
        내용: <input type="text" name="comment"><br>
        세일: <input type="number" name="sale"><br>
        사진: <input type="file" name="pimg"><br>
        성별: <input type="text" name="gender"><br>
        아이디: <input type="email" name="email"><br>
        <input type="submit" value="등록">
    </form>
</body>
</html>