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
	<%
int role = (Integer) session.getAttribute("role");
%>

	<div id="layoutSidenav_nav">
		<nav class="sb-sidenav accordion sb-sidenav-dark"
			id="sidenavAccordion">
			<div class="sb-sidenav-menu">
				<div class="nav">

					<div class="sb-sidenav-menu-heading">Information</div>
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
						data-bs-target="#collapseLayouts" aria-expanded="false"
						aria-controls="collapseLayouts">
						<div class="sb-nav-link-icon">
							<svg class="svg-inline--fa fa-table-columns" aria-hidden="true"
								focusable="false" data-prefix="fas" data-icon="table-columns"
								role="img" xmlns="http://www.w3.org/2000/svg"
								viewBox="0 0 512 512" data-fa-i2svg="">
								<path fill="currentColor"
									d="M0 96C0 60.65 28.65 32 64 32H448C483.3 32 512 60.65 512 96V416C512 451.3 483.3 480 448 480H64C28.65 480 0 451.3 0 416V96zM64 416H224V160H64V416zM448 160H288V416H448V160z"></path></svg>
							<!-- <i class="fas fa-columns"></i> Font Awesome fontawesome.com -->
						</div> 회원관리
						<div class="sb-sidenav-collapse-arrow">
							<svg class="svg-inline--fa fa-angle-down" aria-hidden="true"
								focusable="false" data-prefix="fas" data-icon="angle-down"
								role="img" xmlns="http://www.w3.org/2000/svg"
								viewBox="0 0 384 512" data-fa-i2svg="">
								<path fill="currentColor"
									d="M192 384c-8.188 0-16.38-3.125-22.62-9.375l-160-160c-12.5-12.5-12.5-32.75 0-45.25s32.75-12.5 45.25 0L192 306.8l137.4-137.4c12.5-12.5 32.75-12.5 45.25 0s12.5 32.75 0 45.25l-160 160C208.4 380.9 200.2 384 192 384z"></path></svg>
							<!-- <i class="fas fa-angle-down"></i> Font Awesome fontawesome.com -->
						</div>
					</a>
					<div class="collapse" id="collapseLayouts"
						aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="${pageContext.request.contextPath }/list.do">회원정보보기</a>
							<a class="nav-link" href="${pageContext.request.contextPath }/search.do">회원정보수정</a> 
							<a class="nav-link" href="${pageContext.request.contextPath }/delsearch.do">회원탈퇴</a>
							<a class="nav-link" href="${pageContext.request.contextPath }/findMap.jsp">찾아오시는길</a>
							<a class="nav-link" href="http://192.168.0.8/middleProject/shoppingBasket.do">장바구니</a>
							<c:choose>
								<c:when test="${role == 0}">
									<a class="nav-link" href="${pageContext.request.contextPath }/userPay.do">구매내역</a>
								</c:when>
								<c:when test="${role == 1}">
									<a class="nav-link" href="${pageContext.request.contextPath }/adminPay.do">결제내역</a>
								</c:when>
							</c:choose>
							
						</nav>
					</div>
					
					<c:if test="${role == 1}">
					<a class="nav-link"
						href="http://192.168.0.8/middleProject/chart.jsp">
						<div class="sb-nav-link-icon">
							<svg class="svg-inline--fa fa-chart-area" aria-hidden="true"
								focusable="false" data-prefix="fas" data-icon="chart-area"
								role="img" xmlns="http://www.w3.org/2000/svg"
								viewBox="0 0 512 512" data-fa-i2svg="">
								<path fill="currentColor"
									d="M64 400C64 408.8 71.16 416 80 416H480C497.7 416 512 430.3 512 448C512 465.7 497.7 480 480 480H80C35.82 480 0 444.2 0 400V64C0 46.33 14.33 32 32 32C49.67 32 64 46.33 64 64V400zM128 320V236C128 228.3 130.8 220.8 135.9 214.1L215.3 124.2C228.3 109.4 251.4 109.7 263.1 124.8L303.2 171.8C312.2 182.7 328.6 183.4 338.6 173.4L359.6 152.4C372.7 139.3 394.4 140.1 406.5 154.2L472.3 231C477.3 236.8 480 244.2 480 251.8V320C480 337.7 465.7 352 448 352H159.1C142.3 352 127.1 337.7 127.1 320L128 320z"></path></svg>
							<!-- <i class="fas fa-chart-area"></i> Font Awesome fontawesome.com -->
						</div> Charts
					</a>
					</c:if>
					

				</div>
		</nav>
	</div>
</body>
</html>