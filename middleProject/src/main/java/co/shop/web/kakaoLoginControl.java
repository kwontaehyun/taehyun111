package co.shop.web;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class kakaoLoginControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 'account_email, gender , birthday',

		String code = request.getParameter("code");
		System.out.println(code);

		// System.out.println("code :"+code);
		// Post요청, x-www-form-urlencoded

		String endpoint = "https://kauth.kakao.com/oauth/token";
		URL url = new URL(endpoint);

		String bodyData = "grant_type=authorization_code&";
		bodyData += "client_id=046c047958de0cd3b816a19cdd02fa4b&";
		bodyData += "http://localhost/middleProject/kakaologin.do&";
		bodyData += "code=" + code + "HTTP/1.1";

		// Stream 연결
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		// http header 값 넣기
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoOutput(true);
		// request 하기
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
		bw.write(bodyData);
		bw.flush();

		//BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String input = "";
		StringBuilder sb = new StringBuilder();
		
		System.out.println(sb.toString());
		// Gson으로 파싱
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(sb.toString()));

	}
}
