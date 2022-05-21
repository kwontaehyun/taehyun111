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

import co.shop.service.basketService;
import co.shop.vo.basketVO;

public class kakaoPayControl implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Map<String, String> map = new HashMap<String, String>();
		HttpSession session = request.getSession();
		URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "KakaoAK 9711955edc29f723a1a4fd53c15ac3bd");
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoInput(true);
		conn.setDoOutput(true);
		
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		String check = request.getParameter("check");
		basketService service = new basketService();
		String proDuctName = "";
		String proDuctNumAry = "";
		int sumMoney = 0;
		
		if(check == null) {
			String item_name = request.getParameter("item_name");
			String item_code = request.getParameter("item_code");
			String quantity = request.getParameter("quantity");
			String total_amount = request.getParameter("total_amount");
			String tax_free_amount = request.getParameter("tax_free_amount");
			
			
			map.put("cid", "TC0ONETIME"); //가맹점 코드
			map.put("partner_order_id", "00000000001"); //가맹점 주문번호 String
			map.put("partner_user_id", "kantaaaa"); // 가맹점 회원id String
			map.put("item_name", item_name); //상품명
			map.put("item_code", item_code); //상품코드
			map.put("quantity", quantity); // 상품수량
			map.put("total_amount", total_amount); // 가격
			map.put("tax_free_amount", tax_free_amount); // 비과세
			
			session.setAttribute("item_code", item_code);
			
		}else{
			for(int i=0; i<cnt; i++) {
				String proDuctNum = request.getParameter("proDuctNum"+i);
				basketVO vo = new basketVO();
				vo = service.productList(proDuctNum);
				sumMoney+= vo.getProDuctPrice();
				if(i == 0) {
					proDuctName += vo.getProDuctName();
					proDuctNumAry += proDuctNum;
				}else {
					proDuctName += ",";
					proDuctNumAry += ",";
					proDuctName += vo.getProDuctName();
					proDuctNumAry += proDuctNum;
				}
				
			}
			session.setAttribute("proDuctNumAry", proDuctNumAry);
			
		}
		
		map.put("cid", "TC0ONETIME"); //가맹점 코드
		map.put("partner_order_id", "00000000001"); //가맹점 주문번호 String
		map.put("partner_user_id", "kantaaaa"); // 가맹점 회원id String
		map.put("item_name", proDuctName); //상품명
		map.put("item_code", "104"); //상품코드
		map.put("quantity", "1"); // 상품수량
		map.put("total_amount", Integer.toString(sumMoney)); // 가격
		map.put("tax_free_amount", "0"); // 비과세
	
		map.put("approval_url", "http://localhost/middleProject/payInfo.do");
		map.put("cancel_url", "http://localhost/middleProject/cancel.jsp");
		map.put("fail_url", "http://localhost/middleProject/fail.jsp");
		
		String stringParams = "";
		for(Map.Entry<String, String> elem : map.entrySet()) {
			stringParams += (elem.getKey() + "=" + elem.getValue() + "&");
		}
		OutputStream out = conn.getOutputStream();
        out.write(stringParams.getBytes());
        out.flush();
        out.close(); // POST 호출
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String successUrl = null;
		String next_redirect_pc_url = "next_redirect_pc_url";
		try {
			JSONParser parser = new JSONParser();
			Object object = parser.parse(in.readLine());
			JSONObject obj = (JSONObject) object;
			successUrl = (String)obj.get(next_redirect_pc_url);
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			in.close(); // 응답 스트림 닫기
		}
		
		response.sendRedirect(successUrl);
	}

}
