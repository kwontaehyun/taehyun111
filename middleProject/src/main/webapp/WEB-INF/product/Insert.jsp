<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>μνμΆκ°</title>
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
				<h2 class="sub_tit_txt">π¦μνλ±λ‘π¦</h2>

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
									<th><span>βμνμ΄λ¦</span></th>
									<td><input type="text" name="name"
										placeholder="μνμ΄λ¦μ μλ ₯νμΈμ." required></td>
								</tr>
								<tr>
									<th><span>π΅μνκ°κ²©</span></th>
									<td><input type="number" name="price" 
										placeholder="μνκ°κ²©μ μλ ₯νμΈμ." required></td>
								</tr>
								
								<tr>
								<th><span>πμΉ΄νκ³ λ¦¬</span></th>
								<td><select name="category" class="select">
								<option value =""disabled selected>μΉ΄νκ³ λ¦¬λ₯Ό μ ννμΈμ.</option>
								<option value="μμ°ν°">μμ°ν°</option>
								<option value="μμ">μμ</option>
								<option value="νμ">νμ</option>
								<option value="μ λ°">μ λ°</option>
								<option value="μμΈμ¬λ¦¬">μμΈμ¬λ¦¬</option>
								</select></td>
								</tr>
								
								<tr>
									<th><span>πμνμ€λͺ</span></th>
									<td><input type="text" name="comment"
										placeholder="μνμ€λͺμ μλ ₯νμΈμ." required></td>
								</tr>
								<tr>
									<th><span>π?μΈμΌ</span></th>
									<td><input type="number" name="sale"
										placeholder="ν μΈμ μλ ₯νμΈμ." ></td>
								</tr>
								<tr>
								<th><span>π«μ±λ³</span></th>
								<td><select name="gender" class="select">
								<option value =""disabled selected>μ±λ³μ μ ννμΈμ..</option>
								<option value="M">λ¨μ±</option>
								<option value="F">μ¬μ±</option>
								<option value="MF">κ³΅μ©</option>
								</select></td>
								</tr>
								<tr>
									<th><span>πμμ΄λ</span></th>
									<td><input id="ffile" type="email" name="email"
										value="${email }" readonly></td>
								</tr>
								<tr>
									<th><span>π·μ¬μ§</span></th>
									<td><input id="file" type="file" name="pimg"></td>
								</tr>
								<tr>
									<th>
									<td><input id="inin" type="submit" value="βλ±λ‘"></td>
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