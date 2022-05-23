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
				session.removeAttribute("AuthenticationKey");
				response.sendRedirect("/middleProject/shopView/insert.jsp");
			}
		}
		else if(phonekey != null) {
			String numCode = (String) session.getAttribute("numCode");
			if(numCode.equals(numCode)) {
				session.removeAttribute("numCode");
				response.sendRedirect("/middleProject/shopView/insert.jsp");
			}
		}
		
	}
	
}
