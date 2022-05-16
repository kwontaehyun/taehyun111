package co.basket.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.shop.service.basketService;
import co.shop.vo.basketVO;
import co.shop.web.Controller;

public class basketControl implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		if(email != null) {

			basketService service = new basketService();
			List<basketVO> list = service.basketList(email);
			
			Gson gson = new GsonBuilder().create();
			response.getWriter().print(gson.toJson(list));
				
		}
		
	}

}
