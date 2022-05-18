package co.shop.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.shop.service.ShopService;
import co.shop.vo.ShopVO;

public class listControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원정보");
	HttpSession session = request.getSession();
	String email = (String) session.getAttribute("email");

	System.out.println(email);
	
	ShopService service = new ShopService();
	ShopVO info = service.search(email);
	
	
	request.setAttribute("info", info);
	request.getRequestDispatcher("userlist.jsp").forward(request, response);
	}

}
