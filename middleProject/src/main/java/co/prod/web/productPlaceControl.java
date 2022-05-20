package co.prod.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.service.productService;
import co.shop.vo.productVO;
import co.shop.web.Controller;

public class productPlaceControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		int number = Integer.parseInt(request.getParameter("num"));
		
		productService service = new productService();
		productVO vo = new productVO();
		vo.setProDuctNum(number);
		request.setAttribute("vo", vo);
		
		request.getRequestDispatcher("/productModify.jsp").forward(request, response);
	}

}
