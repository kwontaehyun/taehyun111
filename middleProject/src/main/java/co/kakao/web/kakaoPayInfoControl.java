package co.kakao.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.service.basketService;
import co.shop.service.payService;
import co.shop.service.productService;
import co.shop.vo.payVO;
import co.shop.vo.productVO;
import co.shop.web.Controller;

public class kakaoPayInfoControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상품번호, 회원아이디, 상품명, 상품가격, 수량
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String item_code = (String) session.getAttribute("item_code");

		productService service = new productService();
		productVO vo = new productVO();

		basketService baskService = new basketService();

		payVO payVo = new payVO();
		payService payService = new payService();
		vo = service.detailSearch(item_code);
		payVo.setEmail(email);
		payVo.setpImg(vo.getpImg());
		int salePrice = vo.getProDuctPrice();
		if(vo.getSale() > 0) {
			salePrice = salePrice - (salePrice * vo.getSale())/100;
		}
		payVo.setPayPrice(salePrice);
		payVo.setProDuctName(vo.getProDuctName());
		payService.kakaoPay(payVo);
		baskService.deletebasket(Integer.parseInt(item_code));
		session.removeAttribute("item_code");
		
		response.sendRedirect("/middleProject/index.jsp");

	}
}
