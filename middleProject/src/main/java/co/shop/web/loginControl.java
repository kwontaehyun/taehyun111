package co.shop.web;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.dao.loginDAO;
import co.shop.service.ShopService;
import co.shop.vo.loginVO;

@WebServlet("/loginControl")
public class loginControl extends HttpServlet implements Controller {
	private static final long serialVersionUID = 1L;

	public loginControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("로그인 ");
//		HttpSession login = null;

//		String email = request.getParameter("email");
//		String pw = request.getParameter("pw");

//		if (email.isEmpty() || pw.isBlank()) {
//			request.setAttribute("error", "모든항목을 입력하세요");
//			request.getRequestDispatcher("view/login.do").forward(request, response);
//			return;
//		}
//
//		ShopService service = new ShopService();
//		service.login(email, pw);
//
//		loginDAO dao = new loginDAO();
//		loginVO vo = dao.login(email, pw);
//		vo.setEmail(email);
//		
//		vo.setPw(pw);

//		if (vo != null) {
//		request.setAttribute("email", email);
//		request.setAttribute("pw", pw);
//		request.getRequestDispatcher("/index.jsp").forward(request, response);
//		}

//		loginVO vo=new loginVO();
//		vo.setEmail(email);
//		vo.setPw(pw);

		// response.getWriter().print("<h3>로그인성공</h3>");

	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인 화면");
//		HttpSession login = null;

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

//		if (email.isEmpty() || pw.isBlank()) {
//			request.setAttribute("error", "모든항목을 입력하세요");
//			request.getRequestDispatcher("shopView/login.do").forward(request, response);
//			return;
//		}

		loginDAO dao = new loginDAO();
		loginVO vo = dao.login(email, pw);
//		System.out.println("fefef");
		vo.setEmail(email);
		vo.setPw(pw);
//		System.out.println("fefef");
//		ShopService service = new ShopService();
//		service.login(email, pw);
//		System.out.println("fefef");

		if (vo != null) {
			request.setAttribute("email", email);
			request.setAttribute("pw", pw);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
//			response.sendRedirect("index.jsp");
//		}else if() {
//			
//		}
//		response.getWriter().print("<script>alert('로그인 성공')</script>");
//			response.sendRedirect("session2.jsp");
//		request.getRequestDispatcher("/index.jsp").forward(request, response);

//		loginVO vo = new loginVO();
//		vo.setEmail(email);

//		vo.setPw(pw);

//		response.getWriter().print("<h3>로그인성공</h3>");

		}

	}
}
