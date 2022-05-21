package co.shop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.service.ShopService;
import co.shop.vo.ShopVO;

public class kakaoLoginControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String age_range = request.getParameter("age_range");
		ShopVO members = new ShopVO();
		ShopService service = new ShopService();
		
		
		HttpSession session = request.getSession();
		session.setAttribute("email", email);
		int role = 0;
		session.setAttribute("role", role);
		
		boolean TrueFalse = service.idcheck(email);
		if(TrueFalse == true) {
			
		}else {
			members.setEmail(email);
			members.setGender(gender.substring(0,1).toUpperCase());
			members.setJumin(age_range+","+birthday);
			service.kakaoInsertMember(members);
		}
		response.sendRedirect("index.jsp");
		
		
	}
}
