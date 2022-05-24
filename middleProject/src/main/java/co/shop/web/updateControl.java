package co.shop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.service.ShopService;
import co.shop.vo.ShopVO;

public class updateControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");
		response.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");



		email = (String) session.getAttribute("email");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String jumin = request.getParameter("jumin");
		String address = request.getParameter("address");
		String acces = request.getParameter("acces");
		String phone = request.getParameter("phone");
		String loginway = request.getParameter("loginway");
		
		
		ShopVO vo = new ShopVO();
		vo.setEmail(email);
		vo.setPw(pw);
		vo.setGender(gender);
		vo.setJumin(jumin);
		vo.setAddress(address);
		vo.setAcces(acces);
		vo.setPhone(phone);
		vo.setLoginway(loginway);
		
		if(phone.length()==11) {				
			ShopService service1 = new ShopService();
			service1.update(vo);
			ShopService service = new ShopService();
			ShopVO info = service.search(email);
			request.setAttribute("info", info);
			
			request.getRequestDispatcher("userSearch.jsp").forward(request, response);
			
		}
		 else  {
				String error = "전화번호 다시 입력!!";
				request.setAttribute("error", error);
				request.getRequestDispatcher("/search.do").forward(request, response);
			}
		
			
		
	}

}
