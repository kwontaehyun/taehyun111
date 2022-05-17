package co.chart.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.shop.service.ShopService;
import co.shop.web.Controller;

public class genderChartControl implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShopService service = new ShopService();
		Map<String, Integer> map = service.userGenderChart();
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(map));
	}

}
