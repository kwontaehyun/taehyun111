package co.shop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.service.ShopService;
import co.shop.vo.ShopVO;

public class deleteControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");
		response.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		ShopService service = new ShopService();
		service.delete(email);
		ShopVO info = service.search(email);


		int role = (Integer) session.getAttribute("role");
		session.removeAttribute("email");
		session.removeAttribute("role");
		String kakaoLogout = "카카오로그아웃";
		request.setAttribute("kakaoLogout", kakaoLogout);
		response.sendRedirect("index.jsp");
		
		request.setAttribute("info", info);
		request.getRequestDispatcher("UserDelete.jsp");

	}

}
