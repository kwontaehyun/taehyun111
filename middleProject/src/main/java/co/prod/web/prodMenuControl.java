package co.prod.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.shop.service.productService;
import co.shop.web.Controller;

public class prodMenuControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");

		productService service = new productService();
		List<String> list = service.cateGory();
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(list));
	}

}
