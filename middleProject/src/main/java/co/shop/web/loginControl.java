package co.shop.web;

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
		System.out.println("로그인 ");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		
		loginDAO dao=new loginDAO();
		
	
		loginVO vo=new loginVO();
		vo.setEmail(email);
		vo.setPw(pw);
		
		
		ShopService service= new ShopService();
		service.login(email, pw);
		
		
	
		
		

		if (email.isEmpty() || pw.isBlank()) {
			request.setAttribute("error", "모든항목을 입력하세요");
			request.getRequestDispatcher("view/login.do").forward(request, response);
			return;
		}
		HttpSession login = null;
		
		int result=dao.login(vo.getEmail(),vo.getPw());
		login = request.getSession();
		PrintWriter out = response.getWriter();
		if(result==1) {
			out.print("<h3>로그인성공</h3>");
		}else if(result==0) {
			out.print("<h3>계정미일치</h3>");
		}else if(result==-1) {
			out.print("<h3>아이디없음</h3>");
		}else if(result==-2) {
			out.print("<h3>오류</h3>");
		}
		

		login.setAttribute("email", email);
		login.setAttribute("pw", pw);
		
		
	//	response.getWriter().print("<h3>로그인성공</h3>");
		
		request.getRequestDispatcher("../index.jsp").forward(request, response);
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
