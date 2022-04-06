package project;

import java.util.Scanner;

public class LoginExe {
	public void execute() {

		Scanner scn = new Scanner(System.in);
		LoginApp login = new LoginApp();
		// 1.게시판 화면 넘어가기 2.회원정보수정 3.회원탈퇴 4.로그아웃

		while (true) {
			System.out.println("1.게시판 2.회원정보수정 3.회원탈퇴 4.로그아웃");
			int menu = scn.nextInt();

			if (menu == 1) {

			} else if (menu == 2) {
				Login log = new Login();
				
				System.out.println("수정하실 회원 번호를 입력하세요 : ");
				int num = scn.nextInt();
				log.setUserNum(num);
				System.out.println("비밀번호를 입력하세요 : ");
				String pwd = scn.next();
				log.setUserPwd(pwd);
				System.out.println("이메일을 입력하세요 : ");
				String email = scn.next();
				log.setUserEmail(email);
								
				login.userModify(log);
				
			} else if (menu == 3) {
				
				System.out.println("삭제하실 회원 번호를 입력하세요 : ");
				int num = scn.nextInt();
				
				login.userDelete(num);
			} else if (menu == 4) {
				System.out.println("로그아웃 합니다.");
				break;
			}
		}
	}
}
