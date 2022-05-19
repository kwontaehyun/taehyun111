package co.shop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.service.ShopService;
import co.shop.vo.ShopVO;

public class updateControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String jumin = request.getParameter("jumin");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");

		if (email.isEmpty() || pw.isBlank() || gender.isBlank() || jumin.isBlank()
				|| address.isBlank() ||  phone.isBlank()) {
			request.setAttribute("error", "모든 항목을 입력하세요 !");
			request.getRequestDispatcher("shopView/update.jsp").forward(request, response);
			return;
		}

		ShopVO vo = new ShopVO();
		vo.setEmail(email);
		vo.setPw(pw);
		vo.setGender(gender);
		vo.setJumin(jumin);
		vo.setAddress(address);
		vo.setPhone(phone);

		ShopService service = new ShopService();
		service.update(vo);
		
		
		
		request.setAttribute("email", email);
		
		request.getRequestDispatcher("shopView/update.jsp").forward(request, response);

	}

}
