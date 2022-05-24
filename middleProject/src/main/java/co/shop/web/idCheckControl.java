package co.shop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class idCheckControl implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String key = request.getParameter("key");
		HttpSession session = request.getSession();
		
		if(key != null) {
			String AuthenticationKey = (String) session.getAttribute("AuthenticationKey");
			if(AuthenticationKey.equals(key)) {
				session.removeAttribute("AuthenticationKey");
				session.removeAttribute("meg");
				request.setAttribute("success", "이메일 인증에 성공하셨습니다.");
				request.getRequestDispatcher("/shopView/insert.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("error", "인증번호를 제대로 입력해주세요");
			request.getRequestDispatcher("/shopView/insert.jsp").forward(request, response);
		}
		
	}
	
}
