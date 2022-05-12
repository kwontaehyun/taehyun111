package co.shop.web2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.shop.dao.productDAO;
import co.shop.vo.productVO;
import co.shop.web.Controller;

//productMain.do
public class productControl implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		
		productDAO dao = new productDAO();
		List<productVO> list = dao.proDuctList();
		
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(list));
	}
}
