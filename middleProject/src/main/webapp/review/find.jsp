<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>find.jsp</title>

<style>
#area { float: left; } .star-rating { float: left; } .bt { float: left;
} /* star */ .star-rating { display: flex; flex-direction: row-reverse;
font-size: 1.5em; justify-content: space-around; text-align: center;
width: 5em; } .star-rating input { display: none; } .star-rating label {
color: #ccc; cursor: pointer; } .star-rating :checked ~label { color:
#fc0; } .star-rating label:hover, .star-rating label:hover ~label {
color: #fc0; }
</style>
</head>
<body>
	<h3>수정조회입니다.</h3>
	<form action="${pageContext.servletContext.contextPath }/select.do" method="get">
		<input type="email" name='content' readonly value='${email }'>
	</form>
	
	<form action="${pageContext.servletContext.contextPath }/moReview.do" method="post" enctype="multipart/form-data">
		<input type='hidden' name='prodNum' value='${list.proDuctNum }'>
		<input type='hidden' name='reNum' value='${list.reviewNum }'>
				<p>내용</p>
				<textarea rows="6" cols="50" name="content" required></textarea>
				<br>
				<div class="star-rating">
					<input type="radio" id="5-stars" name="grade" value="5"> <label for="5-stars" class="star">&#9733;</label>
					<input type="radio" id="4-stars" name="grade" value="4"> <label for="4-stars" class="star">&#9733;</label> 
					<input type="radio" id="3-stars" name="grade" value="3"> <label for="3-stars" class="star">&#9733;</label>
					<input type="radio" id="2-stars" name="grade" value="2"> <label for="2-stars" class="star">&#9733;</label> 
					<input type="radio" id="1-star" name="grade" value="1"> <label for="1-star" class="star">&#9733;</label>
				</div>
		<input type="file" name="profile" ><br>
		<input type="submit" value="수정완료">
		</form>
		
	

</body>
</html>