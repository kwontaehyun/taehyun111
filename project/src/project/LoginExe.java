package project;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LoginExe {
	public void execute() {

		SignUpExe sux = new SignUpExe();
		Scanner scn = new Scanner(System.in);
		LoginService login = new LoginApp();
		// 1.게시판 화면 넘어가기 2.회원정보수정 3.회원탈퇴 4.로그아웃
		
		while (true) {
			int menu = 0;
			int option = 0;
			int ModefyOrDelete = 0;
			System.out.println("\n	-------------------------------------------------------------------------");
			System.out.println("	1.게시판　　2.회원정보수정　　3.회원탈퇴　　4.회원정보보기　　5.내가 쓴 게시글 보기\n	6. 내가 쓴 댓글 보기　　7. 댓글 삭제 or 수정　　8.로그아웃");
			System.out.println("	-------------------------------------------------------------------------");
			try {
				System.out.print("	입력 >>");
				menu = scn.nextInt();
				scn.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("	숫자를 입력하세요.");
				scn.nextLine();
			}

			if (menu == 1) {
				BoardExe bex = new BoardExe();
				bex.excute();
			} else if (menu == 2) {

				System.out.print("	비밀번호를 입력하세요 : ");
				String pwd = scn.next();

				boolean check = login.userPwdCheck(pwd);

				if (check == true) {

					while (true) {
						System.out.println("	-----------------------------------");
						System.out.println("	1. 비밀번호변경 2. 이메일 변경. 3 돌아가기");
						System.out.println("	-----------------------------------");
						try {
							System.out.print("	입력 >>");
							option = scn.nextInt();
							scn.nextLine();
							if (option == 1) {
								System.out.print("	수정하실 비밀번호를 입력해주세요 : ");
								String pwde = scn.next();
								login.userModify(pwde);
								System.out.println("	비밀번호 수정이 완료되었습니다.");
								break;
							} else if (option == 2) {
								System.out.print("	수정하실 이메일을 입력해주세요 : ");
								String email = scn.nextLine();
								login.emailModify(email, pwd);
								System.out.println("	이메일 수정이 완료되었습니다.");
								break;
							} else if (option == 3) {
								System.out.println("	돌아갑니다.");
								break;
							} else {
								System.out.println("	잘못된 번호입니다. 다시 입력해주세요.");
							}
						} catch (InputMismatchException e) {
							System.out.println("	숫자를 입력하세요.");
							scn.nextLine();
						}
					}
				} else {
					System.out.println("	비밀번호가 틀립니다.");
				}

			} else if (menu == 3) {

				System.out.print("	삭제하실 회원 비밀번호를 입력하세요 : ");
				String pwd = scn.next();

				boolean check = login.userPwdCheck(pwd);
				if (check == true) {
					login.userDelete(pwd);
					System.out.println("	회원 탈퇴가 완료되었습니다.");
					break;
				} else {
					System.out.println("	비밀번호가 틀립니다.");
				}

			} else if (menu == 4) {
				System.out.println(sux.user.toString());
			} else if (menu == 5) {
				List<Board> list = login.boardInfo(sux.user.getUserNum());
				if (list.isEmpty()) {
					System.out.println("	작성하신 게시글이 없습니다.");

				} else {
					for (Board board : list) {
						System.out.println(board.boardReference());
					}
				}

			} else if (menu == 6) {
				List<Board> list = login.comMentInfo(sux.user.getUserNum());
				if (list.isEmpty()) {
					System.out.println("	작성하신 댓글이 없습니다.");
				} else {
					for (Board board : list) {
						System.out.println(board.userCommentInfo());
					}
				}

			} else if (menu == 7) {
				List<Board> list = login.comMentInfo(sux.user.getUserNum());
				if (list.isEmpty()) {
					System.out.println("	작성하신 댓글이 없습니다.");
				} else {
					while (true) {
						System.out.println("	------------------------------");
						System.out.println("	1.댓글 수정 2.댓글 삭제 3.돌아가기");
						System.out.println("	------------------------------");
						try {
							System.out.print("	입력 >>");
							ModefyOrDelete = scn.nextInt();
							scn.nextLine();
						} catch (InputMismatchException e) {
							scn.nextLine();
						}
						if (ModefyOrDelete == 1) {
							int modefy = -1;
							System.out.print("	수정하실 댓글의 번호를 입력하세요 : ");
							try {
								modefy = scn.nextInt();
							} catch (InputMismatchException e) {
								scn.nextLine();
							}
							boolean trueFalse = login.selectComment(modefy);
							if (trueFalse == true) {
								scn.nextLine();
								System.out.print("	수정하실 글을 작성해주세요 : ");
								String modefyComment = scn.nextLine();
								login.commentModefy(modefyComment, modefy);
								System.out.println("	수정이 완료되었습니다.");
								break;
							} else {
								System.out.println("	댓글을 찾을 수가 없습니다.");
								break;
							}
						} else if (ModefyOrDelete == 2) {
							System.out.print("	삭제하실 댓글의 번호를 입력하세요 : ");
							int delete = scn.nextInt();
							boolean trueFalse = login.selectComment(delete);
							if (trueFalse == true) {
								login.commentDelete(delete);
								System.out.println("	삭제가 완료되었습니다.");
								break;
							} else {
								System.out.println("	댓글을 찾을 수가 없습니다.");
								break;
							}
						} else if (ModefyOrDelete == 3) {
							System.out.println("	회원화면으로 돌아갑니다.");
							break;
						} else {
							System.out.println("	잘못된 번호 입니다. 다시 입력하세요.");
						}
					}
				}

			}

			else if (menu == 8) {
				System.out.println("	로그아웃 합니다.");
				sux.user = null;
				break;
			}
		}
	}
}