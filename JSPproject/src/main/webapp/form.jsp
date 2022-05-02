<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form.jsp</title>
</head>
<body>
	<form name="frm" action="StudentGetServlet" method="get">
		<input type="hidden" name="cmd" value="search"> 
		ID: <input type="number" name="user_id" value="hong"><br> 
		Name: <input type="text" name="user_name" value="gildong"><br> 
		Eng: <input type="number" name="student_eng" value="100"><br>
		Kor: <input type="number" name="student_kor" value="100"><br>
		<input type="submit" value="조회"> 
		<input id = "addBtn" type="button" value="입력">
		<input id = "modBtn" type="button" value="수정">
		<input id = "delBtn" type="button" value="삭제">
	
	</form>

	<form name="refrm"></form>

	<script>
	
		let btn = document.querySelector('input[type="submit"]');
		btn.addEventListener('submit', function(){
			e.preventDefault();
			let frm = document.forms.frm;
			frm.action = "StudentGetServlet";
			frm.cmd.value = "search";
			frm.cmd.method = "get";
			frm.submit();
		})
		
		let btn2 = document.querySelector('#addBtn');
		btn2.addEventListener('click', function(){
			let frm = document.forms.frm;
			frm.action = "StudentGetServlet";
			frm.method = "post";
			frm.cmd.value = "add";
			frm.submit();
		})
		
		let btn3 = document.querySelector('#delBtn');
		btn3.addEventListener('click', function(){
			let frm = document.forms.frm;
			frm.action = "StudentGetServlet";
			frm.method = "post";
			frm.cmd.value = "del";
			frm.submit();
		})
		
		let btn4 = document.querySelector('#modBtn');
		btn4.addEventListener('click', function(){
			let frm = document.forms.frm;
			frm.action = "StudentGetServlet";
			frm.method = "post";
			frm.cmd.value = "mod";
			frm.submit();
		})
		
	</script>
	<a href = "StudentList.jsp">학생테이블</a>
</body>
</html>