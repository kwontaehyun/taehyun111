package co.shop.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.shop.service.ShopService;
import co.shop.vo.ShopVO;

public class userInsertControl implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		
		ShopService service = new ShopService();
		List<ShopVO> list = service.listShop();
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(list));
		
	}

}
