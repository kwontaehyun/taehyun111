<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
<%
String email = (String) session.getAttribute("email");
int role = (Integer) session.getAttribute("role");
%>

<c:if test = "${!empty error }">
	<script>
	alert('${error}')
	</script>
	</c:if>
	<c:if test="${!empty buy }">
		<script>
			alert(`${buy}`)
		</script>
	</c:if>
	
   <!-- Section-->
   <section class="py-5" id = "list">
      <script src = "mainhome.js"></script>
      <div id = "btn" style = "text-align: center" > 
       <c:if test ="${!empty email && role == 1}">
      <div>
				<form action="productInsert.jsp">
					<input type="submit" value="상품등록">
				</form>
			</div>
      </c:if>
      </div>
      
     
      
   </section>
   
</body>
</html>