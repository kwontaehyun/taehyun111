<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
</head>
<body>
	<%
int role = (Integer) session.getAttribute("role");
%>


	<h4>상품목록페이지입니다.</h4>
	<c:if test="${!empty vo}">
	<c:if test ="${role == 1}">
	<form action = "">
	<input type = "submit" value ="상품수정">
	</form>
	<form action = "">
	<input type = "submit" value ="상품삭제">
	</form>
</c:if>
	
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
		<h4>평점 : 
		<c:forEach var="cnt" begin ="1" end = "${avgGrade}" step ="1">
			★
		</c:forEach>
		</h4>
		<form action="${pageContext.servletContext.contextPath }/delReview.do" method="post" enctype="multipart/form-data">
		
		<input type='hidden' name='proDucNum' value='${vo.proDuctNum }' >
		
		<table border="1">
			<tr>
				<th>삭제선택 </th>
				<th>수정선택</th>
				<th>작성자 </th>
				<th>댓글  </th>
				<th>평점  </th>
				<th>이미지 </th>
			</tr>
			
			<c:forEach items="${list}" var="list">
			<tr>
			<td><a href="http://localhost/middleProject/delReview.do?proDuctNum=${vo.proDuctNum }&reNum=${list.reviewNum}" >삭제</a>
			</td>
			<td><a href="review/find.jsp" >조회</a>
			</td>
			<td> ${list.email}</td>
			<td>${list.content}<input type="hidden" name='content' value='${list.content}'></td>
			<td>${list.grade}<input type="hidden" name='grade' value='${list.grade}'></td>
			<td><c:if test="${!empty list.RImg}">
			<img src="${pageContext.servletContext.contextPath }/reviewUpload/${list.RImg }" name="img">
			</c:if>
			</td>
			</tr>
			</c:forEach>
			
			</table>
			</form>	
	

		<h3>댓글</h3>
		<form action="${pageContext.servletContext.contextPath }/review.do" method="post" enctype="multipart/form-data">
		 <p><input type='hidden' name='prodNum' value='${vo.proDuctNum }' ></p>
			<p>내용</p>
			<textarea rows="6" cols="50" name="content" required></textarea>
			<br> <span>평점:</span> <select name="grade" required>
				<option value="5">5</option>
				<option value="4">4</option>
				<option value="3">3</option>
				<option value="2">2</option>
				<option value="1">1</option>
			</select><br>
			<input type="file" name="profile" ><br> 
			<input type="submit" value="작성하기">
			
		</form>
	</c:if>
	
	
</body>
</html>