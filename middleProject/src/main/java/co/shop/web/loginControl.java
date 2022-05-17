package co.shop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.service.loginService;

public class loginControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		loginService service = new loginService();
		boolean trueFalse = service.login(email, pw);


		if (trueFalse == true) {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			session.setAttribute("pw", pw);
			
			int role = service.selectClass(email, pw);
			session.setAttribute("role", role);
			
			response.sendRedirect("index.jsp");
		} else if (trueFalse == false) {
			String error = "";
			boolean IdCheck = service.loginIderror(email);
			boolean pwCheck = service.loginPwerror(pw);
			
			if(IdCheck == false && pwCheck == true) {
				error = "아이디가 틀립니다.";
			}
			else if(IdCheck == true && pwCheck == false) {
				error = "비밀번호가 틀립니다.";
			}else if(IdCheck == false && pwCheck == false){
				error = "없는 아이디 입니다.";
			}
			
			request.setAttribute("error", error);
			request.getRequestDispatcher("shopView/login.jsp").forward(request, response);
		}

	}

}
