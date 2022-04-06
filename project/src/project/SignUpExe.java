package project;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;

import common.Coolsms;

public class SignUpExe {
	int num = 0;
	
	public static SignUp user = null;
	
	public void excute() {
		
		Scanner scn = new Scanner(System.in);
		SignUpService sign = new SignUpApp();
		int menu = 0;
		while (true) {
			System.out.println("1.로그인 2.회원 가입. 3.아이디찾기 4.비밀번호 찾기 5.손님으로 게시판 보기 6.종료");
			
			try {
				menu = scn.nextInt();
				scn.nextLine();
			}catch(InputMismatchException e) {
				System.out.println("숫자를 입력하세요.");
				scn.nextLine();
			}
			
			if (menu == 1) {
				System.out.println("아이디를 입력하세요 : ");
				String id = scn.next();
				System.out.println("비밀번호를 입력하세요 : ");
				String pwd = scn.next();
				
				user = sign.userLogin(id,pwd);
				
				if(user != null) {
					System.out.println("로그인 되었습니다.");
					LoginExe loginexe = new LoginExe();
					loginexe.execute();
				}
				else {
					System.out.println("아이디나 패스워드가 틀립니다.");
				}

			} else if (menu == 2) {

				System.out.println("이름을 입력하세요 : ");
				String name = scn.next();
				System.out.println("생일을 입력하세요 : ");
				String birth = scn.next();
				System.out.println("아이디를 입력하세요 : ");
				String id = scn.next();
				System.out.println("비밀번호를 입력하세요 : ");
				String pwd = scn.next();
				System.out.println("한번 더 비밀번호를 입력하세요 : ");
				String pwdequals = scn.next();
				System.out.println("이메일을 입력하세요 : ");
				String email = scn.next();
				scn.nextLine();
				System.out.println("휴대폰번호를 입력하세요 : ");
				String phoneNumber = scn.nextLine();
				phoneNumber = phoneNumber.replace(" ","");
				phoneNumber = phoneNumber.replace("-","");
				
				while (true) {
					if (pwd.equals(pwdequals)) {
						List<SignUp> list = sign.searchNumber();

						for (SignUp a : list) { // 9 +1 10.....
							if (num == a.getUserNum()) {
								num = a.getUserNum() + 1;
							}
						}

						SignUp signup = new SignUp(num, name, birth, id, pwd, email, phoneNumber);
						sign.userSignUp(signup);
						break;
					} else {
						System.out.println("비밀번호가 서로 다릅니다.");
						System.out.println("비밀번호를 입력하세요 : ");
						pwd = scn.next();
						System.out.println("한번 더 비밀번호를 입력하세요 : ");
						pwdequals = scn.next();
					}
				}
			} else if (menu == 3) {

				System.out.println("본인 이름을 입력하세요 : ");
				String name = scn.next();
				System.out.println("본인 생년월일을 입력하세요");
				String birth = scn.next();

				String id = sign.IDSerach(name, birth);
				System.out.println("가입하신 아이디 : " + id);
			} else if (menu == 4) {
				String api_key = "NCSPIGAE2RY8UCUQ";
				String api_secret = "NCKM4MSIEV91WW6I5JR0UXGJSPLXKQOJ";
				Coolsms coolsms = new Coolsms(api_key, api_secret);
				
				System.out.println("본인 이름을 입력하세요 : ");
				String name = scn.next();
				System.out.println("본인 생년월일을 입력하세요");
				String birth = scn.next();
				System.out.println("가입하신 아이디를 입력하세요");
				String id = scn.next();
				String pwd = sign.pwdSearch(name, birth, id);
				System.out.println("휴대폰 번호를 입력하세요.");
				scn.nextLine();
				String phoneNumber = scn.nextLine();
				phoneNumber = phoneNumber.replace(" ","");
				phoneNumber = phoneNumber.replace("-","");
				
				String ComparePhoneNumber = sign.userPhone(phoneNumber,name, id, birth);
				
				if(phoneNumber.equals(ComparePhoneNumber))
				{
					HashMap<String, String> set = new HashMap<String, String>();
					set.put("to", "01072213915");
					set.put("from", phoneNumber); // 발신번호
					set.put("text", pwd); // 문자내용
					set.put("type", "sms"); // 문자 타입
					JSONObject result = coolsms.send(set); // 보내기&전송결과받기
					if ((Boolean) result.get("status") == true) {
						System.out.println("가입하신 휴대폰으로 문자메시지가 발송되었습니다.");
					}
					else {
						System.out.println("없는 아이디입니다.");
					}
				}
				else
					System.out.println("가입하신 번호와 폰번호가 다릅니다.");
				
			
			} else if (menu == 5)
			{
				BoardExe bex = new BoardExe();
				bex.excute();
			}
			
			else if (menu == 6) {
				System.out.println("프로그램 종료");
				scn.close();
				break;
			}
		}

	}
}