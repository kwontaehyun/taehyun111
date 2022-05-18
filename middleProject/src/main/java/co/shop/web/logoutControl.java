package co.shop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logoutControl implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		int role = (Integer) session.getAttribute("role");
		session.removeAttribute("email");
		session.removeAttribute("role");
		String kakaoLogout = "카카오로그아웃";
		request.setAttribute("kakaoLogout", kakaoLogout);
		response.sendRedirect("index.jsp");
	}

}
