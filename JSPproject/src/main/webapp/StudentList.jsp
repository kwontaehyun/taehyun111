<%@page import="java.util.List"%>
<%@page import="co.edu.StudentDAO"%>
<%@page import="co.edu.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>학생번호</th>
				<th>학생이름</th>
				<th>영어점수</th>
				<th>국어점수</th>
			</tr>
		</thead>
	<tbody>
	<%
	StudentDAO dao = new StudentDAO();
	List<Student> list = dao.studentList();
	for(Student student : list){
		out.println("<tr><td><a href = 'http://localhost/JSPproject/StudentGetServlet?cmd=search&user_id="+student.getStuNo()+"&user_name=gildong&student_eng=100&student_kor=100'>" +student.getStuNo() + "</a></td><td>" +student.getStuName() + "</td><td>" +student.getEngScore() + "</td><td>" +student.getKorScore() + "</td></tr>");
	}
	
	%>
	</tbody>
	</table>
	<a href = "form.jsp">홈화면</a>
</body>
</html>