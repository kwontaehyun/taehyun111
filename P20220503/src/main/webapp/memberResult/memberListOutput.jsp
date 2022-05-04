<%@page import="java.util.List"%>
<%@page import="co.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberResult/memberListOutput</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty all}">
			<h3>회원정보가 없습니다.</h3>
		</c:when>
		<c:otherwise>
			<table border="1">
				<thead>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>비밀번호</th>
						<th>이메일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${all }" var="member">
						<tr>
							<td>${member.id}</td>
							<td>${member.name}</td>
							<td>${member.passwd}</td>
							<td>${member.email}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
	<%
	List<MemberVO> list = (List<MemberVO>) request.getAttribute("all");
	if (list.isEmpty()) {
		out.print("<h3>회원정보가 없습니다.</h3>");
	} else {
	%>
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>비밀번호</th>
				<th>이메일</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (MemberVO mem : list) {
				out.print("<tr><td>" + mem.getId() + "</td><td>" + mem.getName() + "</td><td>" + mem.getPasswd() + "</td><td>"
				+ mem.getEmail() + "</td></tr>");
			}
			%>
		</tbody>
	</table>
	<%
	}
	%>
	<jsp:include page="home.jsp"></jsp:include>
</body>
</html>