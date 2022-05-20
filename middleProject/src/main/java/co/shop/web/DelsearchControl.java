package co.shop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.service.ShopService;
import co.shop.vo.ShopVO;

public class DelsearchControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");


		email = (String) session.getAttribute("email");
		
		ShopService service = new ShopService();
		ShopVO info = service.search(email);
		
		

		request.setAttribute("info", info);
		request.getRequestDispatcher("UserDelSearch.jsp").forward(request, response);
	}

}
