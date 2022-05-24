<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>상품수정</title>
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
	height: 35px;
	padding: 10px;
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
	int num = Integer.parseInt(request.getParameter("num"));
	String name = (String) request.getParameter("name");
	int price = Integer.parseInt(request.getParameter("price"));
	String gory = (String) request.getParameter("gory");
	String comment = (String) request.getParameter("comment");
	int sale = Integer.parseInt(request.getParameter("sale"));
	String pImg = (String) request.getParameter("pImg");
	String gender = (String) request.getParameter("gender");
	String email = (String) request.getParameter("email");
	%>

	<div class="wrap wd668">
		<div class="container">
			<div class="all">
				<h2 class="sub_tit_txt">📦상품수정📦</h2>

				<form
					action="${pageContext.servletContext.contextPath }/productModify.do"
					method="post" enctype="multipart/form-data">

					<div class="join_form">
						<table>
							<colgroup>
								<col width="30%" />
								<col width="auto" />
							</colgroup>
							<tbody>
								<tr>
									<th><p>
											<span>📦상품번호</span>
										</p></th>
									<td><p>
											<input type="number" name="num" value=<%=num%> readonly></td>
								</tr>
								<tr>
									<th><p>
											<span>👉아이디</span>
										</p></th>
									<td><input type="email" name="email" value=<%=email%>
										readonly></td>
								</tr>
								<tr>
									<th><p>
											<span>✍상품이름</span>
										</p></th>
									<td><input type="text" name="name" value=<%=name%>></td>
								</tr>
								<tr>
									<th><p>
											<span>💵상품가격</span>
										</p></th>
									<td><input type="number" name="price" value=<%=price%>></td>
								</tr>
								<tr>
									<th><p>
											<span>👓카테고리</span>
										</p></th>
									<td><input type="text" name="category" value=<%=gory%>></td>
								</tr>
								<tr>
									<th><p>
											<span>📃상품설명</span>
										</p></th>
									<td><input type="text" name="comment" value=<%=comment%>></td>
								</tr>
								<tr>
									<th><p>
											<span>🔮세일</span>
										</p></th>
									<td><input type="number" name="sale" value=<%=sale%>></td>
								</tr>
								<tr>
									<th><span>👫성별</span></th>
									<td><input type="radio" name="gender" class="gender" checked value="M" style="width: 15px; height: 15px; border: 1px; margin-top: 5px;">남성
										<br>
									<input type="radio" name="gender" class="gender" value="F" style="width: 15px; height: 15px; border: 1px; margin-top: 5px;">여성<br>
									<input type="radio" name="gender" class="gender" value="MF" style="width: 15px; height: 15px; border: 1px; margin-top: 5px;">공용</td>
								</tr>
								<tr>
									<th><p>
											<span>💷사진</span>
										</p></th>
									<td><input id="file" type="file" name="pimg" value=<%=pImg%>></td>
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