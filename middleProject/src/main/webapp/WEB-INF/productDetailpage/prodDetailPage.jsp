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
		<h4>평점 : 
		<c:forEach var="cnt" begin ="1" end = "${avgGrade}" step ="1">
			★
		</c:forEach>
		</h4>
		<form action="${pageContext.servletContext.contextPath }/delReview.do" method="post" enctype="multipart/form-data">
		<input type='hidden' name='proDucNum' value='${vo.proDuctNum }' >
		
		<table border="1">
			<tr>
				<th>선택 </th>
				<th>작성자 </th>
				<th>댓글  </th>
				<th>평점  </th>
				<th>이미지 </th>
			</tr>
			<c:forEach items="${list}" var="list">
			<tr>
			<td><button type="button" id="delBtn">삭제</button><input type="hidden" value="${review.reviewNum }"></td>
			<td> ${list.email}</td>
			<td>${list.content}</td>
			<td>${list.grade}</td>
			<td><c:if test="${!empty list.RImg}">
			<img src="${pageContext.servletContext.contextPath }/reviewUpload/${list.RImg }">
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
	
	<script type="text/javascript">
	
	
	let ck=document.=qeury
	ck.forEach(val=>
	val.add
	
	)}
	ckdocument.addEventListener('click',function(){
	
	
	
	
		//document.addEventListener('DOMContentLoaded',function(){
		//	  let btn = document.querySelector('button');
			  //버튼에 클릭 이벤트가 실행되면 function을 실행하세요
		//	  btn.addEventListener('click', function () {
			    //입력값1, 입력값2
			//    let name = document.getElementById('userName').value
			//    let age = document.getElementById('userAge').value
			  
			//    if(!name) {
			//      alert('이름을 입력하세요..');
			//      return; // function 종료 > return
			//    }
			//      alert('나이를 입력하세요..')
			//      return;
			 //   }
			    //태그만들때 createElement
			 //   let span1 = document.createElement('span'); //<span>${name}</span>
			 //   span1.innerHTML = name;
			 //   let span2 = document.createElement('span');//<span>${age}</span>
			 //   span2.innerHTML = age;
			 //   let div1 = document.createElement('div');
			 //   div1.appendChild(span1); // <div><span></span></div>
			 //   div1.appendChild(span2); // <div><span></span><span></span></div>
			  
			//    document.getElementById('show').appendChild(div1);
			  
			//  });
		//	})
	
})
	

	
	</script>
	
</body>
</html>