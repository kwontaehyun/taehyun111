package co.shop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.service.ShopService;

public class phoneKeyCheck implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String numCode = (String) session.getAttribute("numCode");
		String phoneNum = (String) session.getAttribute("phoneNum");
		String code = request.getParameter("code");
		
		if(numCode.equals(code)) {
			
			ShopService service = new ShopService();
			String email = service.findId(phoneNum);
			
			if(email == null) {
				request.setAttribute("error", "없는 아이디 입니다.");
				request.getRequestDispatcher("/findId.jsp").forward(request, response);
			}else {
				session.removeAttribute("numCode");
				session.removeAttribute("phoneNum");
				request.setAttribute("success", "휴대폰 인증에 성공하셨습니다.");
				request.setAttribute("emailFind", email);
				request.getRequestDispatcher("/findId.jsp").forward(request, response);
			}
			
		}else {
			request.setAttribute("error", "인증번호를 제대로 입력해주세요");
			request.getRequestDispatcher("/findId.jsp").forward(request, response);
		}
	}

}
