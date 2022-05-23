package co.kakao.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.service.payService;
import co.shop.vo.payVO;
import co.shop.web.Controller;

public class adminPayControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Calendar cal = Calendar.getInstance();
		String format = "yyyy-MM";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		String date = sdf.format(cal.getTime());
		System.out.println(date);
		cal.add(cal.MONTH, -1); //세달 전
		String prevdate = sdf.format(cal.getTime());
		System.out.println(prevdate);
		
		payService service = new payService();
		List<payVO> list = service.sumPaySelect();
		
		int prevSum = service.monthSum(prevdate);
		int currSum = service.monthSum(date);
		
		int money = service.sumPayMoney();
		
		request.setAttribute("list", list);
		request.setAttribute("money", money);
		request.setAttribute("date", date);
		request.setAttribute("prevdate", prevdate);
		request.setAttribute("prevSum", prevSum);
		request.setAttribute("currSum", currSum);
		request.getRequestDispatcher("/adminpay.jsp").forward(request, response);
	}

}
