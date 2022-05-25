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
		
		int firstPage = 0;
		int lastPage = 5;
		String firstPageCheck = request.getParameter("firstPage");
		String lastPageCheck = request.getParameter("lastPage");
		if (firstPageCheck != null || lastPageCheck != null) {
			firstPage = Integer.parseInt(request.getParameter("firstPage"));
			lastPage = Integer.parseInt(request.getParameter("lastPage"));
		}
		
		payService service = new payService();
		int count = service.userCount(email);
		List<payVO> list = service.userPayment(email, firstPage, lastPage);
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("btn", list.size());
		request.setAttribute("maxpage", 100);
		request.setAttribute("page", 8);
		request.getRequestDispatcher("/userpay.jsp").forward(request, response);
		
	}

}
