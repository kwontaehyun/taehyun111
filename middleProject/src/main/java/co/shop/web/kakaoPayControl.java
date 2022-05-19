package co.shop.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class kakaoPayControl implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		URL url = new URL("http://kapi.kakao.com/v1/payment/ready");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "KakaoAK ba7b6d9c3b2092af69285bb67e2dfcb4");
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoInput(true);
		conn.setDoOutput(true);
		
		String item_name = request.getParameter("item_name");
		String item_code = request.getParameter("item_code");
		String quantity = request.getParameter("quantity");
		String total_amount = request.getParameter("total_amount");
		String tax_free_amount = request.getParameter("tax_free_amount");
		
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("cid", "TC0ONETIME"); //가맹점 코드
		map.put("partner_order_id", "00000000001"); //가맹점 주문번호 String
		map.put("partner_user_id", "kk@naver.com"); // 가맹점 회원id String
		map.put("item_name", item_name); 
		map.put("item_code", item_code);
		map.put("quantity", quantity);
		map.put("total_amount", total_amount);
		map.put("tax_free_amount", tax_free_amount);
		map.put("approval_url", "http://localhost/middleProject/sucess.jsp");
		map.put("cancel_url", "http://localhost/middleProject/cancel.jsp");
		map.put("fail_url", "http://localhost/middleProject/fail.jsp");
		
		String string_params = "?";
		for(Map.Entry<String, String> elem : map.entrySet()) {
			string_params += (elem.getKey() + "=" + elem.getValue() + "&");
		}
		
		OutputStream out = conn.getOutputStream();
        out.write(string_params.getBytes());
        out.flush();
        out.close(); // POST 호출
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        System.out.println(in);
        System.out.println(string_params);
		String successUrl = null;
		
		try {
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject)parser.parse(in);
			successUrl = (String)obj.get("next_redirect_pc_url");
			session.setAttribute("tid", (String)obj.get("tid"));
			session.setAttribute("partner_order_id", "으아아아");
			session.setAttribute("partner_user_id", "kk@naver.com");
			session.setAttribute("item_name", item_name);
			session.setAttribute("item_code", item_code);
		} catch (ParseException e) {
			e.printStackTrace();
		}finally {
			in.close();
		}
		System.out.println(successUrl);
		
		//response.sendRedirect(successUrl);
	}

}
