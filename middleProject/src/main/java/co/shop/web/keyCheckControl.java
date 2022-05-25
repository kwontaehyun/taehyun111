package co.shop.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import co.shop.service.ShopService;
import co.shop.vo.ShopVO;
import common.Coolsms;

public class keyCheckControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String AuthenticationKey = (String) session.getAttribute("AuthenticationKey");
		String email = (String) session.getAttribute("email");
		String key = request.getParameter("key");
		
		String api_key = "NCSPIGAE2RY8UCUQ";
		String api_secret = "NCKM4MSIEV91WW6I5JR0UXGJSPLXKQOJ";
		Coolsms coolsms = new Coolsms(api_key, api_secret);
		
		ShopService service = new ShopService();
		
		if(AuthenticationKey.equals(key)) {
			
			ShopVO vo = new ShopVO();
			vo = service.search(email);
			
			//가입하신 핸드폰으로 아이디가 전송되었습니다.
			HashMap<String, String> set = new HashMap<String, String>();
			set.put("to", "01072213915");
			set.put("from", vo.getPhone()); // 발신번호
			set.put("text", "회원님의 Yedam Shop 계정의 비밀번호는 " + vo.getPw() + " 입니다."); // 문자내용
			set.put("type", "sms"); // 문자 타입
			JSONObject result = coolsms.send(set); // 보내기&전송결과받기
			session.removeAttribute("email");
			session.removeAttribute("AuthenticationKey");
			String checkMeg = "가입하신 휴대폰으로 비밀번호가 발송되었습니다.\n 로그인화면으로 돌아갑니다.";
			request.setAttribute("checkMeg", checkMeg);
			request.getRequestDispatcher("/findPW.jsp").forward(request, response);
		}
		
	}

}
