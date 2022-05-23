package co.shop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class idphoneCheckControl implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String key = request.getParameter("key");
		HttpSession session = request.getSession();
		String phonekey = request.getParameter("phonekey");
		
		if(key != null) {
			String AuthenticationKey = (String) session.getAttribute("AuthenticationKey");
			if(AuthenticationKey.equals(key)) {
				String success = "이메일인증이 성공했습니다.";
				request.setAttribute("success", success);
				session.removeAttribute("AuthenticationKey");
				session.setAttribute("email", "email");
				request.getRequestDispatcher("shopView/insert.jsp").forward(request, response);
			}
		}
		else if(phonekey != null) {
			String numCode = (String) session.getAttribute("numCode");
			if(numCode.equals(numCode)) {
				String success = "휴대폰인증이 성공했습니다.";
				request.setAttribute("success", success);
				session.removeAttribute("numCode");
				session.setAttribute("phone", "phone");
				request.getRequestDispatcher("shopView/insert.jsp").forward(request, response);
			}
		}
		
	}
	
}
