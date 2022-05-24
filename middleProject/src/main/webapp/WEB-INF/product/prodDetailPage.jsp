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
@import url('https://cdn.jsdelivr.net/gh/orioncactus/pretendard/dist/web/static/pretendard.css');
*{
	box-sizing:border-box;
	padding:0;
	font-family: Pretendard, -apple-system, BlinkMacSystemFont, system-ui, Roboto, 'Helvetica Neue', 'Segoe UI', 'Apple SD Gothic Neo', 'Noto Sans KR', 'Malgun Gothic', sans-serif;

}

/* 버튼 */
button {
    margin: 20px;
}

.w-btn {
    position: relative;
    border: none;
    display: inline-block;
    padding: 15px 30px;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    font-weight: 600;
    transition: 0.25s;
background: url( "https://play-lh.googleusercontent.com/W43xj43ErMIs5BQgCdMKEa0NXCoUUW8DjQc5SxcDfLrC26H8sHDmoFIUWLYmsQahpo0" ) no-repeat;
}

.w-btn-outline {
    position: relative;
    padding: 15px 30px;
    border-radius: 15px;
    font-family: "paybooc-Light", sans-serif;
    box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
    text-decoration: none;
    font-weight: 600;
    transition: 0.25s;
     border: #fff200;
}
.w-btn:hover {
    letter-spacing: 2px;
    transform: scale(1.2);
    cursor: pointer;
}

.w-btn-outline:hover {
    letter-spacing: 2px;
    transform: scale(1.2);
    cursor: pointer;
}

.w-btn:active {
    transform: scale(1.5);
}

.w-btn-outline:active {
    transform: scale(1.5);
  
}
.w-btn-yellow-outline:hover {
    background-color: #ffea00;
    color: #6e6e6e;
}
.w-btn-yellow {
    background-color: #fce205;
    color: #6e6e6e;
    width : 124px;
    height : 54px;
}
.kakaoimg {
width : 10px;
height : 10px;
}
#kakaopayBtn {
width : 110px;
padding: 5px 10px 10px 5px;
}
h2{
padding:30px 10px;

margin : 0 auto;
text-align : center;
}

/* 센터 */

body{
	height:100%;

}
.center{
	text-align: center;
}
table{
	width:100%;
	font-size: 20px;

}
a{
	text-decoration: none;
	color:#666;
}
tr{
	border: 1px solid;
}
th{
	font-size:15pt;
 	color:#fff;
 	background:black;
 	text-decoration: none;
 	padding:10px;
 	text-align: center;

}
td{
	text-align: center;
	height: 130px;
}
h4{
	font-size:15pt;
	margin-bottom: 30px;
}
input{
    border: 0;
    color: #6e6e6e;
    font-size:15px;
    margin-bottom:20px;
}
#left{
	float:left;
	width:40%;
	height: 30%;
	margin-left:6%;
	margin-right: 10%;
	margin-top: 5%;
	
}

#prod_right {
	float:left;
}

input {
	padding: 10px;

}

#dea{
	clear:both;
	padding-top: 50px;
	padding-right: 100px;
	padding-left:100px;
}

/* */
.right{
	overflow: hidden;
	
}

.right form {
	
	float: right;
}

.padding{
	padding-top:300px;
	text-align:left;
	
}

#censle{
	text-decoration : line-through;

}

.size{
	font-size: 30px;
	font-weight: 700;
}
.name{
	font-weight: 700;
	font-size: 50px;
}
.gr{
	color:#666;

}
.co{
width: 500px;
}
.em{

width: 300px;
}
/* 삭제버튼 */
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-square-fill" viewBox="0 0 16 16">
  <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm3.354 4.646L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 1 1 .708-.708z"/>
</svg>


/*평점관련 */

#area {
	float: left;
}


.bt {
	float: left;
} 
/* star */
.star-rating {
	display: flex;
	flex-direction: row-reverse;
	font-size: 1.5em;
	justify-content: space-around;
	text-align: center;
	width: 5em;
	margin:0 auto;
}

.star-rating input {
	display: none;
}

.star-rating label {
	color: #ccc;
	cursor: pointer;
}

.star-rating :checked ~label {
	color: #fc0;
}

.star-rating label:hover, .star-rating label:hover ~label {
	color: #fc0;
}

</style>

</head>
<body>
	<%
	int role = (Integer) session.getAttribute("role");
	%>

<div>
<c:if test="${!empty error}">
		<script>
			alert(`${error}`)
		</script>
	</c:if>
	<c:if test="${!empty vo}">
		<c:if test="${role == 1}">
		<div class="right">
			<form action="${pageContext.servletContext.contextPath }/productDelete.do">
				<input type="hidden" name="num" value="${vo.proDuctNum }"> 
				<input  type="submit" value="상품삭제" id = "delProdBtn">
			</form>
			<form action="${pageContext.servletContext.contextPath }/productModify.jsp" method="get" enctype="multipart/form-data">
				<input type="hidden" value="${vo.proDuctNum}" name="num">
				<input type="hidden" value="${vo.proDuctName}" name="name">
				<input type="hidden" value="${vo.proDuctPrice}" name="price"> 
				<input type="hidden" value="${vo.cateGory}" name="gory"> 
				<input type="hidden" value="${vo.comment}" name="comment"> 
				<input type="hidden" value="${vo.sale}" name="sale"> 
				<input type="hidden" value="${vo.pImg}" name="pImg"> 
				<input type="hidden" value="${vo.gender}" name="gender"> 
				<input type="hidden" value="${vo.email}" name="email"> 
				<input  type="submit" value="상품수정">
			</form>
			
			</div>
			<script>
			let delProdBtn = document.getElementById('delProdBtn');
			delProdBtn.addEventListener('click', function(){
				if (confirm("상품을 삭제 하시겠습니까?") == true) {    //확인
					
				}else{
					 event.preventDefault();
				}
			})
			</script>
			
		</c:if>
		<img id="left" src="upload/${vo.pImg}">
		
		
		
		
		
		
		<div class="padding">
		<h4 class="name">${vo.proDuctName}</h4>
		<h4>${vo.comment}</h4>
		<c:if test="${vo.sale == null || vo.sale == 0}">
			<h4>${vo.proDuctPrice}원</h4>
		</c:if>
		
			
		
		<div id="prod_right">
		<c:if test="${vo.sale ne 0}">
			<p>
				<span>${vo.sale}%</span>  <span id="censle" >${vo.proDuctPrice}원</span> 
			</p>
			<h4 class="size"><fmt:formatNumber type="number" pattern="0" value="${vo.proDuctPrice - (vo.proDuctPrice*(vo.sale/100))}" /> 원 </h4>
		</c:if>
		<h4>성별 : ${vo.gender}</h4>
		<h4> 평점 : <c:forEach var="cnt" begin="1" end="${avgGrade}" step="1" ><span class="gr"> &#9733; </span></c:forEach> </h4>
		
		<form action="kakaopay.do">
		<fieldset id="width">
			<input type="hidden" name="item_name" value="${vo.proDuctName }">
			<!-- 상품명 String-->
			<input type="hidden" name="item_code" value="${vo.proDuctNum}">
			<!-- 상품코드 String-->
			<input type="hidden" name="sale" value="${vo.sale}"> <input
				type="hidden" name="quantity" value="1">
			<!-- 상품수량 int -->
			<input type="hidden" name="total_amount" value="${vo.proDuctPrice}">
			<!-- 상품 총액 int -->
			<input type="hidden" name="tax_free_amount" value="0">
			<!-- 상품 비과세 금액 -->
			<input type="submit" value="카카오페이결제"  class="w-btn-outline w-btn-yellow-outline">
			
			
		</fieldset>
		</form>
		<a  name="basket" href="http://localhost/middleProject/shoppingBasket.do?proDuctNum=${vo.proDuctNum }" class="w-btn-outline w-btn-yellow-outline">장바구니 </a>
		</div>
		</div>
		
		
		
		
		
		
		<div class="center">
		<div class="padding">
		<form  action="${pageContext.servletContext.contextPath }/select.do"
			method="post" enctype="multipart/form-data" id="dea">

			<input type='hidden' name='proDucNum' value='${vo.proDuctNum }'>
			<fieldset>
				<legend>상품평</legend>
				<table border="1">
					<thead>
						<tr>
							<th class="em">작성자</th>
							<th class="co">댓글</th>
							<th>평점</th>
							<th>이미지</th>
							<th>수정</th>
							<th>삭제</th>
						</tr>
					</thead>
					<c:forEach items="${list}" var="list">
						<tbody>
							<tr>
								<td><span id="em">${list.email}</span></td>
								<td><span id="co">${list.content}</span></td>
								<td><span id="gr">&#9733; ${list.grade}</span></td>
								<td><span id="im"><c:if test="${!empty list.RImg}">
											<img src="${pageContext.servletContext.contextPath }/reviewUpload/${list.RImg }" name="img" style="width:200px; height:150px;">
										</c:if></span></td>
								<td><a href="#btn" id="mBtn">수정</a></td>
								<td><a 
									href="http://localhost/middleProject/delReview.do?proDuctNum=${vo.proDuctNum }&reNum=${list.reviewNum}" class="bi bi-x-square-fill"></a>
								</td>
							</tr>
						</tbody>
						
					</c:forEach>

				</table>
				
			</fieldset>
		</form>
			</div>
		<hr>
		<form action="${pageContext.servletContext.contextPath }/review.do"
			method="post" enctype="multipart/form-data" id="form">
			<fieldset>
			<legend>리뷰 쓰기</legend>
			<input type='hidden' name='prodNum' value='${vo.proDuctNum }'>
			<input type='hidden' name='proNum' value='${list[0].proDuctNum }'>
			<input type='hidden' name='reNum' value='${list[0].reviewNum }'>
			<p>내용</p>
			<textarea id="textraea" rows="6" cols="50" name="content" required></textarea>
			<br>
			<span>평점</span>
			<div class="star-rating">
				<input type="radio" id="5-stars" name="grade" value="5"> <label for="5-stars" class="star">&#9733;</label> 
				<input type="radio" id="4-stars" name="grade" value="4"> <label for="4-stars" class="star">&#9733;</label> 
				<input type="radio" id="3-stars" name="grade" value="3"> <label for="3-stars" class="star">&#9733;</label>
				<input type="radio" id="2-stars" name="grade" value="2"> <label for="2-stars" class="star">&#9733;</label> 
				<input type="radio" id="1-star" name="grade" value="1"> <label for="1-star" class="star">&#9733;</label>
			</div><br>
			<input type="file" name="profile"><br> 
			<input type="submit" value="작성하기" id="btn" class="w-btn-outline w-btn-yellow-outline">
			<div id="image_container"></div>
			</fieldset>
		</form>
		</div>
		<span id="btnList"></span>
	</c:if>
	</div>
</body>
<script>
	let mBtn = document.querySelectorAll('#mBtn');
	let co = document.querySelectorAll('#co');
	let gr = document.querySelectorAll('#gr');
	let im = document.querySelectorAll('#im');
	let textarea = document.getElementById('textraea');
	let img = document.createElement("img");
	let grade =	document.querySelectorAll('#form > div > input[type=radio]')
	let cnt = 1;
	let tbody = document.querySelectorAll('table > tbody')
	document.addEventListener('DOMContentLoaded', function() {
		mBtn.forEach((val,idx) =>{
			val.addEventListener('click', function() {

				let btn = document.getElementById('btn')
				btn.setAttribute("value", "수정하기");
				let form = document.getElementById('form')
				form.setAttribute("action", "moReview.do")
				
				textarea.innerHTML = co[idx].innerHTML;
				for(let i =0; i<5; i++){
					if(grade[i].value == gr[idx].innerHTML){
						grade[i].innerHTML = idx+1;
					}
				}
				console.log(im[idx].firstElementChild.src)
				img.setAttribute("src", im[idx].firstElementChild.src);
				document.querySelector("#image_container").appendChild(img);

			})
		})
	})	
	
	
</script>
</html>