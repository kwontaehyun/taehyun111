<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h4>상품목록페이지입니다.</h4>
	
<!-- 	<c:if test="${role == 1}">

			<form action="/productUpdate.do">
				<vo.proDuctNum' hidden
				<input type="submit" value="수정하기">
			</form>
		</c:if>
 -->	
	<c:if test="${!empty vo}">
		<img src="upload/${vo.pImg}">
		<h4>제품이름 : ${vo.proDuctName}</h4>
		<h4>${vo.comment}</h4>

		<c:if test="${vo.sale == null || vo.sale == 0}">
			<h4>${vo.proDuctPrice}원</h4>
		</c:if>
		<c:if test="${vo.sale ne 0}">
			<p>
				<span>${vo.proDuctPrice}원</span> ${vo.sale}%
			<p>
			<h4>${vo.proDuctPrice - (vo.proDuctPrice*(vo.sale/100))}원</h4>
		</c:if>
		<h4>성별 : ${vo.gender}</h4>
		<h4>
			평점 :
		<c:forEach var="cnt" begin="1" end="${avgGrade}" step="1">
			★
		</c:forEach>
		</h4>
		<c:forEach items="${list}" var="list">
			<ul>
				<li>작성자 : ${list.email}</li>
				<li>댓글 : ${list.content}</li>
				<li>평점 : ${list.grade}</li>
			</ul>
			<c:if test="${!empty list.RImg}">
				<li>이미지사진</li>
			</c:if>
		</c:forEach>


		<h3>댓글</h3>
		<form action="${pageContext.servletContext.contextPath }/review.do"
			method="post">
			<p><input type='hidden' name='prodNum' value='${list.reviewNum }'></p>
			<p>내용</p>
			<textarea rows="6" cols="50" name="content"></textarea>
			<p>1111111111</p>
			<br> <span>평점:</span> <select name="grade">
				<option value="5">5
				<option value="4">4
				<option value="3">3
				<option value="2">2
				<option value="1">1
			</select><br>
			<input type="file" name="profile"><br> 
			<input type="submit" value="작성하기">
		</form>


	</c:if>
</body>
</html>