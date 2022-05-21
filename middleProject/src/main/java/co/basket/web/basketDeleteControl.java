package co.basket.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.service.basketService;
import co.shop.web.Controller;

public class basketDeleteControl implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		basketService service = new basketService();
		for(int i =0; i<cnt; i++) {
			int proDuctNum = Integer.parseInt(request.getParameter("proDuctName"+i));
			service.deletebasket(proDuctNum);
		}
		request.getRequestDispatcher("/shoppingBasket.do").forward(request, response);
	}
}
