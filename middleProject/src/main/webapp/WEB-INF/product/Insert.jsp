<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>상품추가</title>
<style>
@charset "utf-8";

body {
	height: 100%;
	font-family: 'Noto Sans KR';
}

h2 {
	margin: 70px 70px;
	margin-right: 380px;
}

th {
	margin-bottom: 10px;
}

input {
	margin-bottom: 10px;
}
select{
margin-bottom: 10px;
}

.red_txt {
	color: #ee7272;
}

.join_form {
	width: 100%;
	max-width: 668px;
}

.join_form table {
	border-spacing: 0;
	margin: 0;
	padding: 0;
	border: 0;
	width: 100%;
}

.join_form table input {
	border: 1px solid #ececec;
	font-size: 14px;
	color: #4c4c4c;
	height: 50px;
	padding: 10px;
	width: 100%;
}
.join_form select {
border: 1px solid #ececec;
	font-size: 14px;
	color: #4c4c4c;
	height: 50px;
	
	width: 100%;
}

.container {
	width: 100%;
	margin: 0 auto;
}

#file {
	text-align: center;
	margin: 0 auto;
	height: 50px;
}

.all {
	text-align: center;
	margin: 0 auto;
	margin-left: 280px;
}

#inin {
	margin: 20px 20px 20px 0;
}
</style>
<body>
	<%
	String email = (String) session.getAttribute("email");
	%>

	<div class="wrap wd668">
		<div class="container">
			<div class="all">
				<h2 class="sub_tit_txt">📦상품등록📦</h2>

				<form
					action="${pageContext.servletContext.contextPath }/productInsert.do"
					method="post" enctype="multipart/form-data">

					<div class="join_form">
						<table>
							<colgroup>
								<col width="30%" />
								<col width="auto" />
							</colgroup>
							<tbody>
								<tr>
									<th><span>✍상품이름</span></th>
									<td><input type="text" name="name"
										placeholder="상품이름을 입력하세요." required></td>
								</tr>
								<tr>
									<th><span>💵상품가격</span></th>
									<td><input type="number" name="price" 
										placeholder="상품가격을 입력하세요." required></td>
								</tr>
								
								<tr>
								<th><span>👓카테고리</span></th>
								<td><select name="category" class="select">
								<option value =""disabled selected>카테고리를 선택하세요.</option>
								<option value="아우터">아우터</option>
								<option value="상의">상의</option>
								<option value="하의">하의</option>
								<option value="신발">신발</option>
								<option value="악세사리">악세사리</option>
								</select></td>
								</tr>
								
								<tr>
									<th><span>📃상품설명</span></th>
									<td><input type="text" name="comment"
										placeholder="상품설명을 입력하세요." required></td>
								</tr>
								<tr>
									<th><span>🔮세일</span></th>
									<td><input type="number" name="sale"
										placeholder="할인을 입력하세요." ></td>
								</tr>
								<tr>
								<th><span>👫성별</span></th>
								<td><select name="gender" class="select">
								<option value =""disabled selected>성별을 선택하세요..</option>
								<option value="M">남성</option>
								<option value="F">여성</option>
								<option value="MF">공용</option>
								</select></td>
								</tr>
								<tr>
									<th><span>👉아이디</span></th>
									<td><input id="ffile" type="email" name="email"
										value="${email }" readonly></td>
								</tr>
								<tr>
									<th><span>💷사진</span></th>
									<td><input id="file" type="file" name="pimg"></td>
								</tr>
								<tr>
									<th>
									<td><input id="inin" type="submit" value="✔등록"></td>
									</th>
								</tr>

							</tbody>
						</table>
					</div>
					<!-- form_txtInput E -->
				</form>
			</div>
			<!-- content E-->
		</div>
		<!-- container E -->
</body>