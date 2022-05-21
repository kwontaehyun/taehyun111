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

		if (email == null) {
			String error = "로그인을 하셔야 이용이 가능합니다.";
			request.setAttribute("error", error);
			request.getRequestDispatcher("shopView/login.jsp").forward(request, response);
		} else {
			String proDuctNum = request.getParameter("proDuctNum");
			basketService service = new basketService();

			if (proDuctNum == null) {
				List<basketVO> list = service.basketList(email);
				int moneySum = 0;
				for (int i = 0; i < list.size(); i++) {
					moneySum += list.get(i).getProDuctPrice();
				}
				request.setAttribute("moneySum", moneySum);
				request.setAttribute("list", list);
				request.getRequestDispatcher("shoppingpage.jsp").forward(request, response);
			} else {
				boolean tf = service.repeatedCheck(proDuctNum, email);

				if (tf == true) {
					request.setAttribute("error", "이미 추가된 상품입니다.");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} else {
					basketVO vo = service.productList(proDuctNum);
					vo.setEmail(email);
					service.insertbasket(vo);
					response.sendRedirect("index.jsp");
				}
			}
		}
	}
}
