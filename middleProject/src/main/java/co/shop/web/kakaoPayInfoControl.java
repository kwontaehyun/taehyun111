package co.shop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class kakaoPayInfoControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//상품번호, 회원아이디, 상품명, 상품가격, 수량
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String item_code = (String) session.getAttribute("item_code");
		String proDuctNumAry = (String) session.getAttribute("proDuctNumAry");
		
		if(item_code != null) {
			
		}else if(proDuctNumAry != null) {
			String[] proDuctNum = proDuctNumAry.split(",");
			for(int i =0; i<proDuctNum.length; i++) {
				System.out.println(proDuctNum[i]);
			}
		}
		
	}
}
