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

import org.apache.tomcat.jni.Time;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class kakaoPayControl implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/json;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "KakaoAK 9711955edc29f723a1a4fd53c15ac3bd");
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
		map.put("partner_user_id", "kantaaaa"); // 가맹점 회원id String
		map.put("item_name", item_name); 
		map.put("item_code", item_code);
		map.put("quantity", quantity);
		map.put("total_amount", total_amount);
		map.put("tax_free_amount", tax_free_amount);
		map.put("approval_url", "http://localhost/middleProject/sucess.jsp");
		map.put("cancel_url", "http://localhost/middleProject/cancel.jsp");
		map.put("fail_url", "http://localhost/middleProject/fail.jsp");
		
		
		String stringParams = "";
		for(Map.Entry<String, String> elem : map.entrySet()) {
			stringParams += (elem.getKey() + "=" + elem.getValue() + "&");
		}
		System.out.println(stringParams);
		OutputStream out = conn.getOutputStream();
        out.write(stringParams.getBytes());
        out.flush();
        out.close(); // POST 호출
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        System.out.println(in.readLine());
		String successUrl = null;
//		String next_redirect_pc_url = "next_redirect_pc_url";
//		try {
//			JSONParser parser = new JSONParser();
//			Object object = parser.parse(in);
//			JSONObject obj = (JSONObject) object;
//			successUrl = (String)obj.get(next_redirect_pc_url);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		} finally {
//			in.close(); // 응답 스트림 닫기
//		}
//		System.out.println(successUrl);
//		
//		response.sendRedirect(successUrl);
	}

}
