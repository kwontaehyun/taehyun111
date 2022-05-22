package co.kakao.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.service.payService;
import co.shop.vo.payVO;
import co.shop.web.Controller;

public class adminPayControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		payService service = new payService();
		List<payVO> list = service.sumPaySelect();
		
		int money = service.sumPayMoney();
		
		request.setAttribute("list", list);
		request.setAttribute("money", money);
		request.getRequestDispatcher("/adminpay.jsp").forward(request, response);
	}

}
