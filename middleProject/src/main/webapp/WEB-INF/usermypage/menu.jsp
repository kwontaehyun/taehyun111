<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
							<a class="nav-link" href="${pageContext.request.contextPath }/update.do">회원정보수정</a> 
							<a class="nav-link" href="${pageContext.request.contextPath }/delete.do">회원탈퇴</a>
							<a class="nav-link" href="${pageContext.request.contextPath }/findMap.jsp">찾아오시는길</a>
							
						</nav>
					</div>

				</div>
		</nav>
	</div>
</body>
</html>