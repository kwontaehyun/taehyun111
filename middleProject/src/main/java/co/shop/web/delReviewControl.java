package co.shop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.service.reviewService;

public class delReviewControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("삭제처리 ");

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");
		response.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		System.out.println(email);
		int prodNum = Integer.parseInt(request.getParameter("proDucNum"));
		System.out.println(prodNum);

		if (email == null) {
			request.setAttribute("error", "로그인후이용해주세요");
			request.getRequestDispatcher("shopView/login.jsp").forward(request, response);
			return;
		}
		
		
		
		
		
		String check=request.getParameter("check");
		System.out.println(check);
		
		
		if(check !=null) {
		reviewService service=new reviewService();
		service.reviewDelete(email);
		
		request.setAttribute("email", email);
		request.getRequestDispatcher("detailProduct.do?proDuctNum=" + prodNum).forward(request, response);
		}

	}

}
