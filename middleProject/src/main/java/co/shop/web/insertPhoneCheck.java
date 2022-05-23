package co.shop.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import common.Coolsms;

public class insertPhoneCheck implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String phoneNum = request.getParameter("phoneNum");
		String api_key = "NCSPIGAE2RY8UCUQ";
		String api_secret = "NCKM4MSIEV91WW6I5JR0UXGJSPLXKQOJ";
		Coolsms coolsms = new Coolsms(api_key, api_secret);
		
		String numCode = numCode();
		
		HashMap<String, String> set = new HashMap<String, String>();
		set.put("to", "01072213915");
		set.put("from", phoneNum); // 발신번호
		set.put("text", "인증번호는 " + numCode + " 입니다."); // 문자내용
		set.put("type", "sms"); // 문자 타입
		JSONObject result = coolsms.send(set); // 보내기&전송결과받기
		session.setAttribute("numCode", numCode);
		request.setAttribute("msg", "msg");
		request.setAttribute("msg2", "msg2");
		request.getRequestDispatcher("shopView/insert.jsp").forward(request, response);
	}
	public String numCode() {
		
		String num = null;
		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();
		for (int i = 0; i < 10; i++) {
			temp.append((rnd.nextInt(10)));
		}
		return num;
	}
}


