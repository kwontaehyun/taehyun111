package co.basket.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.remoting.httpinvoker.AbstractHttpInvokerRequestExecutor;

import co.shop.service.basketService;
import co.shop.vo.basketVO;
import co.shop.web.Controller;

public class shoppingBasketControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String firstPageCheck = request.getParameter("firstPage");
		String lastPageCheck = request.getParameter("lastPage");
		int firstPage = 0;
		int lastPage = 5;
		
		if (firstPageCheck != null || lastPageCheck != null) {
			firstPage = Integer.parseInt(request.getParameter("firstPage"));
			lastPage = Integer.parseInt(request.getParameter("lastPage"));
		}
		if (email == null) {
			String error = "로그인을 하셔야 이용이 가능합니다.";
			request.setAttribute("error", error);
			request.getRequestDispatcher("shopView/login.jsp").forward(request, response);
		} else {
			String proDuctNumCheck = request.getParameter("proDuctNum");
			basketService service = new basketService();

			if (proDuctNumCheck == null) {
				List<basketVO> list = service.basketList(email, firstPage, lastPage);
				request.setAttribute("list", list);
				int count = service.count(email);
				request.setAttribute("count", count);
				request.getRequestDispatcher("shoppingpage.jsp").forward(request, response);
			} else {
				String proDuctNum = request.getParameter("proDuctNum");
				boolean tf = service.repeatedCheck(Integer.parseInt(proDuctNum), email);

				if (tf == true) {
					request.setAttribute("error", "이미 추가된 상품입니다.");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} else {
					basketVO vo = service.productList(proDuctNum);
					vo.setEmail(email);
					vo.setProDuctNum(Integer.parseInt(proDuctNum));
					service.insertbasket(vo);
					response.sendRedirect("index.jsp");
				}
			}
		}
	}
}
