<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<%
	int role = (Integer) session.getAttribute("role");
	%>


	<h4>상품목록페이지입니다.</h4>
	<c:if test="${!empty vo}">
		<c:if test="${role == 1}">
			<form action="${pageContext.servletContext.contextPath }/productModify.jsp" method="post" enctype="multipart/form-data">
				<input type="hidden" value="${vo.proDuctNum}" name="num">
				<input type="submit" value="상품수정">
			</form>
			   <form action="${pageContext.servletContext.contextPath }/productDelete.do">
                  <input type="hidden" name="num" value="${vo.proDuctNum }" >
                  <input type="submit" value="상품삭제">
            </form>   
		</c:if>

		<img src="upload/${vo.pImg}">
		<h4>제품이름 : ${vo.proDuctName}</h4>
		<h4>${vo.comment}</h4>

		<c:if test="${vo.sale == null || vo.sale == 0}">
			<h4>${vo.proDuctPrice}원</h4>
			
			<a name ="basket" href="http://localhost/middleProject/shoppingBasket.do?proDuctNum=${vo.proDuctNum }">장바구니
			</a>
			
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
		<form action = "kakaopay.do">
			<input type = "hidden" name = "item_name" value = "${vo.proDuctName }"> <!-- 상품명 String-->
			<input type = "hidden" name = "item_code" value = "${vo.proDuctNum}"> <!-- 상품코드 String-->
			<input type = "hidden" name = "quantity" value = "1">  <!-- 상품수량 int -->
			<input type = "hidden" name = "total_amount" value = "${vo.proDuctPrice}"> <!-- 상품 총액 int -->
			<input type = "hidden" name = "tax_free_amount" value = "0"> <!-- 상품 비과세 금액 -->
			<input type = "submit" value = "카카오페이결제">
		</form>
		
			<form action="${pageContext.servletContext.contextPath }/select.do" method="post" enctype="multipart/form-data">
		
			<input type='hidden' name='proDucNum' value='${vo.proDuctNum }'>
			<fieldset>
			<legend>댓글</legend>
			<table border="1">
				<tr>
					<th>수정</th>
					<th>삭제선택</th>
					<th>작성자</th>
					<th>댓글</th>
					<th>평점</th>
					<th>이미지</th>
				</tr>
				<c:forEach items="${list}" var="list">
					<tr>
						<td><a href="#" id="mBtn" >수정</a></td>
						<td><a href="http://localhost/middleProject/delReview.do?proDuctNum=${vo.proDuctNum }&reNum=${list.reviewNum}">삭제</a>
						</td>
						<td><span id="em">${list.email}</span></td>
						<td><span id="co">${list.content}</span></td>
						<td><span id="gr">${list.grade}</span></td>
						<td><c:if test="${!empty list.RImg}">
							<span id="im"><img src="${pageContext.servletContext.contextPath }/reviewUpload/${list.RImg }" name="img"></span>
							</c:if>
						</td>
					</tr>
				</c:forEach>
					</table>
					</fieldset>
				</form>
			
				<hr>
				
				<form action="${pageContext.servletContext.contextPath }/review.do" method="post" enctype="multipart/form-data" id = "form">
						<input type='hidden' name='prodNum' value='${vo.proDuctNum }'>
						<input type='hidden' name='proNum' value='${list[0].proDuctNum }' >
						<input type='hidden' name='reNum'  value='${list[0].reviewNum }'>
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
					<input type="file" name="profile"><br>
					<input type="submit" value="작성하기" id = "btn">
				</form>
				
				
				</c:if>
		</body>
		<script>
				var mBtn = document.getElementById('mBtn');
				document.addEventListener('DOMContentLoaded', function () {

				      mBtn.addEventListener('click', function(){
				    	  
				    	  let btn = document.getElementById('btn')
				    	  btn.setAttribute("value", "수정하기");
				    	  let form = document.getElementById('form')
				    	  form.setAttribute("action", "moReview.do")
				    	  
				      })


				      });
			</script>	
</body>
<script>

</script>
</html>