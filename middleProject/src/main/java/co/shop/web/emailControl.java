package co.shop.web;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.shop.service.loginService;

public class emailControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");

		loginService service = new loginService();
		boolean IdCheck = service.loginIderror(email);
		if (IdCheck == true) {

			// 인증코드 생성
			String AuthenticationKey = authCodeMaker();

			// mail server 설정
			String host = "smtp.gmail.com";
			String user = "lnsertgood123@gmail.com"; // 자신의 구글 계정
			String password = "jpinpsjmnekvsbho";// 자신의 구글 패스워드

			// 메일 받을 주소
			String to_email = email;
			System.out.println("inputedEmail : " + email);

			// SMTP 서버 정보를 설정한다.
			Properties prop = System.getProperties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "465");
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.auth", "true");


	        //p.put("mail.smtp.starttls.required", "true");

			prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
			
			prop.put("mail.smtp.debug", "true");
			prop.put("mail.smtp.socketFactory.port", "465");
			prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			prop.put("mail.smtp.socketFactory.fallback", "false");

			Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});
			MimeMessage msg = new MimeMessage(session);

			// email 전송
			try {
				msg.setFrom(new InternetAddress(user));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));

				// 메일 제목
				msg.setSubject("안녕하세요. YedamShop 이메일 인증절차입니다.", "UTF-8");
				// 메일 내용
				msg.setText("인증 번호 :" + AuthenticationKey);
				HttpSession setion = request.getSession();
				setion.setAttribute("AuthenticationKey", AuthenticationKey);
				setion.setAttribute("email", email);
				Transport.send(msg);
				
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("meg", "meg");
			request.setAttribute("email", email);
			request.getRequestDispatcher("/findID.jsp").forward(request, response);
		}
		else {
			String error = "아이디가 틀립니다.";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/findID.jsp").forward(request, response);
		}

	}

	public String authCodeMaker() {
		String authCode = null;

		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();
		for (int i = 0; i < 10; i++) {
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0:
				// a-z
				temp.append((char) ((int) (rnd.nextInt(26)) + 97));
				break;
			case 1:
				// A-Z
				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 2:
				// 0-9
				temp.append((rnd.nextInt(10)));
				break;
			}
		}

		authCode = temp.toString();
		System.out.println(authCode);

		return authCode;
	}

}
