package co.prod.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		productService service = new productService();
		productVO vo = service.detailSearch(proDuctNum);
		response.setContentType("text/json;charset=utf-8");

		reviewService service2 = new reviewService();
		List<reviewVO> list = service2.detailPagelist(proDuctNum);
		
		int avgGrade = service2.AvgGrade(proDuctNum);
		
		request.setAttribute("list", list);
		request.setAttribute("vo", vo);
		request.setAttribute("avgGrade", avgGrade);
		request.getRequestDispatcher("/prodDetailPage.jsp").forward(request, response);
	}

}
