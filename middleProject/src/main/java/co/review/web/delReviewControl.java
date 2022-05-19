package co.review.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.service.reviewService;
import co.shop.web.Controller;

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
		int prodNum = Integer.parseInt(request.getParameter("proDuctNum"));
		System.out.println(prodNum);
		String reEmail = request.getParameter("list.email");
		System.out.println(reEmail);
		
		//계정이없으면 입력막음
		if (email == null) {
			request.setAttribute("error", "로그인후이용해주세요");
			request.getRequestDispatcher("shopView/login.jsp").forward(request, response);
			return;
		} else if (email.equals(reEmail)) { // 이메일이 일치안하면 삭제못함
			request.setAttribute("error", "본인것만 하세요");
			request.getRequestDispatcher("detailProduct.do?proDuctNum=" + prodNum).forward(request, response);
			return;
		}
		
			int reNum=Integer.parseInt(request.getParameter("reNum"));
			System.out.println(reNum);
		
		reviewService service = new reviewService();
		service.reviewDelete(reNum,email);

		request.setAttribute("reNum", reNum);
		request.getRequestDispatcher("detailProduct.do?proDuctNum=" + prodNum).forward(request, response);
		

	}

}
