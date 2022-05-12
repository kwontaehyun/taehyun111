package co.shop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.service.ShopService;
import co.shop.vo.ShopVO;

public class InsertControl implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String jumin = request.getParameter("phone");
		String address = request.getParameter("address");
		String acces = request.getParameter("acces");
		
		ShopVO vo = new ShopVO();
		vo.setEmail(email);
		vo.setPw(pw);
		vo.setGender(gender);
		vo.setJumin(jumin);
		vo.setAddress(address);
		vo.setAcces(acces);
		
		ShopService service = new ShopService();
		service.insertMember(vo);
		
		request.setAttribute("email", email);
		
		request.getRequestDispatcher("result/insertOutput.jsp").forward(request, response);
		
		
	}

}
