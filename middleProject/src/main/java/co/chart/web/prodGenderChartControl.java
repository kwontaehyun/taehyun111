package co.chart.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.shop.service.productService;
import co.shop.web.Controller;

public class prodGenderChartControl implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		productService service = new productService();
		Map<String, Integer> map = service.prodGenderChart();
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(map));
	
	}

}
