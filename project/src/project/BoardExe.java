package project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BoardExe {
	int num = 0;
	int comMentNum = 0;
	int commentHits;
	SignUpExe sux = new SignUpExe();

	public void excute() {
		Scanner scn = new Scanner(System.in);
		BoardService bs = new BoardApp();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");

		while (true) {
			System.out.println("1. 게시판 글 목록보기 2.게시글 보기 3. 게시글 등록 4.게시글 수정 5.게시글 삭제 9.종료");
			int menu = scn.nextInt();

			if (menu == 1) {
				System.out.println("NO			제목			작성자		작성시간				댓글 수		조회 수");
				System.out.println("-------------------------------------------------------------------"
									+ "-------------------------------------------------------");
				int commentNumber = 0;
				List<Board> list = bs.BoardList();
				for (Board brd : list) {
					commentNumber = bs.ToComment(brd.getBoardNum());
					commentHits = bs.getCommentHits(brd.getBoardNum());
					System.out.print(brd.toString() + "		" + commentNumber + "		"+ commentHits);
					System.out.println();
				}

			} else if (menu == 2) {
				System.out.println("보고자 하는 게시글의 번호를 입력해주세요");
				int boardNum = scn.nextInt();

				Board trueFalse = bs.boardView(boardNum);
				if (trueFalse == null)
					System.out.println("게시글 번호가 틀립니다.");
				else {
					
					
					
					List<Board> list = bs.boardComment(boardNum);
						
					System.out.println(trueFalse.writeToString());
					for (Board board : list) {
						try {
						System.out.println("작성자 : " + sux.user.getUserName());
						}catch(NullPointerException e)
						{
							System.out.println("로그인 사용자가아니라면 작성자를 확인할 수 없습니다.");
						}
						System.out.println("댓글 : " + board.comMent());
						System.out.println();
					}
					if (sux.user != null) {
						System.out.println("댓글 : 1번, 종료 : 2번");
						int comment = scn.nextInt();
						if (comment == 1) {
							System.out.println("댓글을 작성해주세요.");
							String commet = scn.next();

							comMentNum = bs.CommentNum();
							comMentNum += 1;

							Board cmd = new Board(boardNum, comMentNum, commet);
							bs.boardCommentInsert(cmd);
						} else if (comment == 2) {
							System.out.println("기존 화면으로 돌아갑니다.");
							commentHits = bs.getCommentHits(boardNum);
							commentHits += 1;
							Board hits = new Board(boardNum, commentHits);
							bs.CommentHits(hits);
						} else
							System.out.println("잘못된 번호입니다.");
					}
				}

			} else if (menu == 3) {
				if (sux.user != null) {
					num = bs.writeNum();
					num += 1;
					System.out.println("글제목을 입력하세요");
					String title = scn.next();
					System.out.println("글내용을 입력하세요");
					String writer = scn.next();

					System.out.println("게시판 비밀번호를 입력하세요");
					String pwd = scn.next();
					String date = sdf.format(now);
					Board b1 = new Board(num, pwd, sux.user.getUserName(), title, writer, date, sux.user.getUserNum());
					bs.insertBoard(b1);
				} else {
					System.out.println("게시글을 등록하려면 회원가입을 해야합니다.");
				}
			}

			else if (menu == 4) {
				if (sux.user != null) {
					List<Board> list = bs.refercence();
					for (Board board : list) {
						System.out.println(board.boardReference());
					}
					boolean checkNum = bs.CheckNum();
					if (checkNum == false)
						System.out.println("조회된 게시글이 없습니다.");
					else {
						// 리스트받아서 내가쓴글만 조회.
						System.out.println("수정하고자 하는 게시글의 번호를 입력하세요 : ");
						int writeNum = scn.nextInt();

						checkNum = bs.CheckPwd(writeNum);
						if (checkNum == false)
							System.out.println("게시글 번호를 똑바로 입력해주세요.");
						else {
							System.out.println("게시글 제목 : ");
							String title = scn.next();
							System.out.println("게시글 내용 : ");
							String write = scn.next();
							String date = sdf.format(now);

							Board board = new Board(writeNum, null, null, title, write, date, sux.user.getUserNum());
							bs.modifyBoard(board);
							System.out.println("수정이 완료되었습니다.");
						}
					}
				} else {
					System.out.println("글 수정을 위해서라면 로그인을 하셔야 합니다.");
				}

			} else if (menu == 5) {
				if (sux.user != null) {
					List<Board> list = bs.refercence();
					for (Board board : list) {
						System.out.println(board.boardReference());
					}
					boolean checkNum = bs.CheckNum();
					if (checkNum == false) {
						System.out.println("조회된 게시글이 없습니다.");
					} else {
						System.out.println("삭제하고자 하는 게시글의 번호를 입력하세요 : ");
						int writeNum = scn.nextInt();
						checkNum = bs.CheckPwd(writeNum);
						if (checkNum == true) {
							System.out.println("삭제할 게시글의 비밀번호를 입력하세요");
							String pwd = scn.next();
							boolean checkDelete = bs.BoardDelete(pwd);
							if (checkDelete == true)
								System.out.println("삭제가 완료되었습니다.");
							else {
								System.out.println("비밀번호가 틀립니다.");
							}
						} else
							System.out.println("게시글 번호를 다시한번 확인하세요.");
					}
				} else {
					System.out.println("글을 삭제하시려면 로그인을 해야합니다.");
				}

			} else if (menu == 9) {
				System.out.println("프로그램 종료.");
				break;
			} else {
				System.out.println("잘못된 번호입니다. 다시입력하세요");
			}
		}

	}

}