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
/* basket */
#container {
height:100%;
margin : 0 auto;
text-align : center;
}

#btn {
margin : 10px 10px;
}
#comment {
margin-top : -25px;
margin : 0 auto;
text-align : center;
width : 900px;
}
#censle{
   text-decoration : line-through;
}
.list-table {
	margin-top: 20px;
	position: relative;
	
}
.list-table thead th{
	height:40px;
	border-top:2px solid #080808;
	border-bottom:1px solid #CCC;
	font-weight: bold;
	font-size: 17px;
}
.list-table tbody td{
	text-align:center;
	padding:10px 0;
	border-bottom:1px solid	 #CCC; height:20px;
	font-size: 14px 
}
.bak_item {
	
	height: 10px;
	margin-top: 5px;
}
#prodimg {
	height : 170px;
	width : 170px;
}

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
     background-color:rgb(35, 35, 35);
    color: white;
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
width : 800px;
}

</style>

</head>

<h2>👜장바구니</h2>
<body>
	<div id=container>
		<c:if test="${!empty list}">
			<c:forEach items="${list}" var="list">
				<div id="checkDelete">
					
					<div id="comment">
					
						<table class="list-table">
						<div id="content">
						<thead>
						
						 <tr>
				              <th width="350">상품이름</th>
				              <th width="120">상품사진</th>
				              <th width="120">상품설명</th>
				              <th width="150">상품금액</th>
				              <th width="100">성별</th>
				           </tr>
						
						<tr>
						<div class="bak_item">
						<th width="350">${list.proDuctName }
						<input id="delete" type="checkbox" value="${list.proDuctNum}" name="proDuctName"></th>
						<th><img src="upload/${list.pImg }" id="prodimg"></th>
						</div>
						
						<th width="350">${list.comment }</th>
						<c:if test="${list.sale == null || list.sale == 0}">
								<th width="120" ><span>✅${list.proDuctPrice}원</span></th>
						</c:if>
						<c:if test="${list.sale ne 0}">
						
								<th width="120"><span id="censle">${list.proDuctPrice}원</span> ${list.sale}%
								✅<fmt:formatNumber type="number" pattern="0"
									value=" ${list.proDuctPrice - list.proDuctPrice * (list.sale/100)}" />원</th>
						</c:if>
						</div>
						<th width="100">${list.gender}</th>
				
					</tr>
					</thead>
					</table>
					</div>
				
				</div>
			</c:forEach>

			<div id = "btn">
			<button class="w-btn-outline w-btn-yellow-outline" id="delBtn">선택삭제</button>
			<button class="w-btn-outline w-btn-yellow-outline" id="selBtn">전체선택</button>
			<button class="w-btn w-btn-yellow" type="button"id="kakaopayBtn"><img src="upload/카페사진.png" alt="이미지" width = "80px" height= "45px"></button>
			</div>

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