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


		// 아이디중복
		boolean id = service.idcheck(email);

		if (id == true) {
			//비밀번호 확인
			if (pw.equals(pwcheck)) {
				//전화번호길이
				if (phone.length() == 11) {
					//주민번호길이
					if (jumin.length() == 12) {
						HttpSession session = request.getSession();
						session.setAttribute("email", email);
						session.setAttribute("pw", pw);
						response.sendRedirect("index.jsp");
					} else {
						String error = "주민번호를 다시 입력해주세요.";
						request.setAttribute("error", error);
						request.getRequestDispatcher("shopView/insert.jsp").forward(request, response);
					}
				} else {
					String error = "전화번호를 다시 입력해주세요.";
					request.setAttribute("error", error);
					request.getRequestDispatcher("shopView/insert.jsp").forward(request, response);
				}
			} else if (!pw.equals(pwcheck)) {
				String error = "비밀번호가 일치하지 않습니다.";

				request.setAttribute("error", error);
				request.getRequestDispatcher("shopView/insert.jsp").forward(request, response);

			}
		} else if (id == false) {
			String error = "중복된 아이디입니다.";
			request.setAttribute("error", error);
			request.getRequestDispatcher("shopView/insert.jsp").forward(request, response);

		}

	}
}