package co.shop.web;

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

public class basketPay implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String proDuctNumAry = (String) session.getAttribute("proDuctNumAry");
		
		productService service = new productService();
		productVO vo = new productVO();

		basketService baskService = new basketService();

		payVO payVo = new payVO();
		payService payService = new payService();

		String[] proDuctNum = proDuctNumAry.split(",");
		for (int i = 0; i < proDuctNum.length; i++) {
			vo = service.detailSearch(proDuctNum[i]);
			payVo.setEmail(email);
			payVo.setpImg(vo.getpImg());
			int salePrice = vo.getProDuctPrice();
			if(vo.getSale() > 0) {
				salePrice = salePrice - (salePrice * vo.getSale())/100;
			}
			payVo.setPayPrice(vo.getProDuctPrice());
			payVo.setProDuctName(vo.getProDuctName());
			payService.kakaoPay(payVo);
			baskService.deletebasket(Integer.parseInt(proDuctNum[i]));
			service.deleteMember(Integer.parseInt(proDuctNum[i]));
			
		}
		session.removeAttribute("proDuctNumAry");
		
		response.sendRedirect("/middleProject/index.jsp");
	}

}
