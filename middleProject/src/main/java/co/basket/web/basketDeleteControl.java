package co.basket.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.service.basketService;
import co.shop.web.Controller;

public class basketDeleteControl implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String proDuctName = request.getParameter("proDuctName");
		basketService service = new basketService();
		service.deletebasket(proDuctName);
		request.getRequestDispatcher("/shoppingBasket.do").forward(request, response);
	}

}
