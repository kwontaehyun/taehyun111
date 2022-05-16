package co.shop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.service.ShopService;
import co.shop.vo.ShopVO;

public class InsertControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("회원가입");

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String pwcheck = request.getParameter("pwcheck");
		String gender = request.getParameter("gender");
		String jumin = request.getParameter("jumin");
		String address = request.getParameter("address");
		String acces = request.getParameter("acces");
		String phone = request.getParameter("phone");

		ShopVO vo = new ShopVO();
		vo.setEmail(email);
		vo.setPw(pw);
		vo.setGender(gender);
		vo.setJumin(jumin);
		vo.setAddress(address);
		vo.setAcces(acces);
		vo.setPhone(phone);

		ShopService service = new ShopService();
		service.insertMember(vo);
		
		boolean id = service.idcheck(email);
		
	
		if(id == true) {
			response.sendRedirect("shopView/login.jsp");
		} else if (id == false) {
			String error = "중복된 아이디입니다.";
			request.setAttribute("error", error);
			request.getRequestDispatcher("shopView/insert.jsp").forward(request, response);
			
		}
		

		if (pw.equals(pwcheck)) {
			response.sendRedirect("shopView/login.jsp");

		} else if (!pw.equals(pwcheck)) {
			String error = "비밀번호가 일치하지 않습니다.";

			request.setAttribute("error", error);
			request.getRequestDispatcher("shopView/insert.jsp").forward(request, response);

		}

		if (phone.length() == 11) {
			response.sendRedirect("shopView/login.jsp");
		} else {
			String error = "전화번호를 다시 입력해주세요.";
			request.setAttribute("error", error);
			request.getRequestDispatcher("shopView/insert.jsp").forward(request, response);
		}

		if (jumin.length() == 13) {
			response.sendRedirect("shopView/login.jsp");
		} else {
			String error = "주민번호를 다시 입력해주세요.";
			request.setAttribute("error", error);
			request.getRequestDispatcher("shopView/insert.jsp").forward(request, response);
		}

	}
}