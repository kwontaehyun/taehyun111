package project;

import java.util.Scanner;

public class SignUpExe {

	static int signUpNumCnt = 0;
	public void excute() {
		Scanner scn = new Scanner(System.in);
		SignUpApp sign = new SignUpApp();
		while (true) {
			System.out.println("1.로그인 2.회원 가입. 3.아이디찾기 4.비밀번호 찾기 5.종료");
			int menu = scn.nextInt();

			if (menu == 1) {
				System.out.println("아이디를 입력하세요 : ");
				String id = scn.next();
				System.out.println("비밀번호를 입력하세요 : ");
				String pwd = scn.next();
				
				boolean login = sign.userLogin(id, pwd);
				if(login == true)
				{
					System.out.println("로그인 되었습니다.");
					signUpNumCnt = 1;
					LoginExe loginexe = new LoginExe();
					
					loginexe.execute();
				}
				else
					System.out.println("아이디나 패스워드가 틀립니다.");
				
			} else if (menu == 2) {
				System.out.println("회원 번호를 입력하세요 : ");
				int num = scn.nextInt();
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
				while(true) {
					if(pwd.equals(pwdequals))
					{
						
						SignUp signup = new SignUp(num, name, birth, id, pwd, email);
						sign.userSignUp(signup);
						break;
					}
					else
					{
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
				
				String id = sign.IDSerach(name , birth);
				System.out.println("가입하신 아이디 : " + id);
			} else if (menu == 4) {
				
				System.out.println("본인 이름을 입력하세요 : ");
				String name = scn.next();
				System.out.println("본인 생년월일을 입력하세요");
				String birth = scn.next();
				System.out.println("가입하신 아이디를 입력하세요");
				String id = scn.next();
				
				String pwd = sign.pwdSearch(name, birth, id);
				System.out.println("가입하신 비밀번호 : " + pwd);
			} else if (menu == 5) {
				System.out.println("프로그램 종료");
				scn.close();
				break;
			}
		}

	}
}
