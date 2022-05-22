package co.kakao.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.service.payService;
import co.shop.vo.payVO;
import co.shop.web.Controller;

public class userPayControl implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		payService service = new payService();
		List<payVO> list = service.userPayment(email);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/userpay.jsp").forward(request, response);
		
	}

}
