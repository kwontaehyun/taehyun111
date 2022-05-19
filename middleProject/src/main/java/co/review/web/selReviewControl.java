package co.review.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.service.reviewService;
import co.shop.vo.reviewVO;
import co.shop.web.Controller;

public class selReviewControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int reNum=Integer.parseInt(request.getParameter("reNum"));
		System.out.println(reNum);
		int prodNum = Integer.parseInt(request.getParameter("proDuctNum"));
		System.out.println(prodNum);
		reviewService service=new reviewService();
		reviewVO review=service.selReview(reNum);
		
		request.setAttribute("reNum", review);
		
		request.getRequestDispatcher("detailProduct.do?proDuctNum=" + prodNum).forward(request, response);
		
		
	

}
}
