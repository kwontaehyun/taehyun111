package co.prod.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.service.productService;
import co.shop.service.reviewService;
import co.shop.vo.productVO;
import co.shop.vo.reviewVO;
import co.shop.web.Controller;

public class detailControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String proDuctNum = request.getParameter("proDuctNum");
		String firstPageCheck = request.getParameter("firstPage");
		String lastPageCheck = request.getParameter("lastPage");
		productService service = new productService();
		productVO vo = service.detailSearch(proDuctNum);
		int firstPage = 0;
		int lastPage = 5;
		
		if (firstPageCheck != null || lastPageCheck != null) {
			firstPage = Integer.parseInt(request.getParameter("firstPage"));
			lastPage = Integer.parseInt(request.getParameter("lastPage"));
		}
		reviewService service2 = new reviewService();
		List<reviewVO> list = service2.detailPagelist(proDuctNum,firstPage, lastPage);
		
		int avgGrade = service2.AvgGrade(proDuctNum);
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		int count = service2.count(proDuctNum);
		request.setAttribute("list", list);
		request.setAttribute("vo", vo);
		request.setAttribute("avgGrade", avgGrade);
		request.setAttribute("email", email);
		request.setAttribute("count", count);
		request.getRequestDispatcher("/detailPage.jsp").forward(request, response);
	}

}
