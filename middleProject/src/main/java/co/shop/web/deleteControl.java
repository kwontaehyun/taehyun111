package co.shop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class deleteControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String pw = (String) session.getAttribute("pw");
		session.removeAttribute("email");
		session.removeAttribute("pw");
		session.removeAttribute("role");
		response.sendRedirect("index.jsp");

	}

}