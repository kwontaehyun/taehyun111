package project;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
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
			int menu = 0;
			int boardNum = 0;
			int writeNum = 0, comment = 0;
		 	int commentNumber = 0;
		 	System.out.println("\n	----------------------------------------------------------------------------");
			System.out.println("	1. 게시판 글 목록보기　2.게시글 보기　3. 게시글 등록　4.게시글 수정　5.게시글 삭제　9.종료");
			try {
				System.out.print("	메뉴 선택 ▶");
				menu = scn.nextInt();
				scn.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("	숫자를 입력하세요.");
				scn.nextLine();
			}
			System.out.println("	----------------------------------------------------------------------------\n");
			
			if (menu == 1) {
				System.out.println("	NO	작성자		댓글 수	조회 수		제목");
				System.out.println("	-------------------------------------------------------------------------");
				
				List<Board> list = bs.BoardList();
				for (Board brd : list) {
					commentNumber = bs.ToComment(brd.getBoardNum());
					commentHits = bs.getCommentHits(brd.getBoardNum());
					brd.setCommentNum(commentNumber);
					brd.setCommentHits(commentHits);
					System.out.print(brd.toString());
					System.out.println();
					System.out.println("	-------------------------------------------------------------------------");
				}
			} else if (menu == 2) {
				System.out.println("	-------------------------------");
				System.out.println("	보고자 하는 게시글의 번호를 입력해주세요");
				System.out.println("	-------------------------------");
				try {
					System.out.print("	입력 >>");
					boardNum = scn.nextInt();
					scn.nextLine();
				} catch (InputMismatchException e) {
					scn.nextLine();
				}
				Board trueFalse = bs.boardView(boardNum);
				if (trueFalse == null)
					System.out.println("	게시글 번호가 틀립니다.");
				else {
					List<Board> list = bs.boardComment(boardNum);

					System.out.println(trueFalse.writeToString());
					for (Board board : list) {
						try {
							System.out.println("	작성자 : " + sux.user.getUserName());
						} catch (NullPointerException e) {
							System.out.println("	로그인 사용자가아니라면 작성자를 확인할 수 없습니다.");
						}
						System.out.println(board.comMent());
						System.out.println();
					}
					
					commentHits = bs.getCommentHits(boardNum);
					commentHits += 1;
					Board hits = new Board(boardNum, commentHits);
					bs.CommentHits(hits);
					
					if (sux.user != null) {
						while (true) {
							System.out.println("\t---------------------------------------");
							System.out.println("\t댓글 : 1번, 삭제 : 2번 수정 : 3번 종료 : 4번");
							System.out.println("\t---------------------------------------");
							try {
								System.out.print("	입력 >>");
								comment = scn.nextInt();
								scn.nextLine();
							} catch (InputMismatchException e) {
								scn.nextLine();
							}
							if (comment == 1) {
								System.out.print("	댓글을 작성해주세요 : ");
								String commet = scn.nextLine();

								comMentNum = bs.CommentNum();
								comMentNum += 1;

								Board cmd = new Board(boardNum, comMentNum, commet);
								bs.boardCommentInsert(cmd);
								break;
							}else if( comment == 2) {
								System.out.print("	삭제할 댓글의 번호를 입력하세요 : ");
								int delete = 0;
								try {
									delete = scn.nextInt();
									scn.nextLine();
									
									boolean truefalse = bs.selectComment(delete);
									if(truefalse == true)
									{
										bs.commentDelete(delete, boardNum);
										System.out.println("	삭제가 완료되었습니다.");
										break;
									}
									else
									{
										System.out.println("	삭제할 댓글이 없습니다.");
										break;
									}
									
									
								} catch (InputMismatchException e) {
									System.out.println("	숫자를 입력하세요.");
									scn.nextLine();
								}
								
							}
							else if(comment ==3) {
								System.out.print("	수정할 댓글의 번호를 입력하세요 : ");
								int modefy = 0;
								try {
									modefy = scn.nextInt();
									scn.nextLine();
									
									boolean truefalse = bs.selectComment(modefy);
									if(truefalse == true)
									{
										System.out.print("	수정할 댓글을 작성해주세요 : ");
										String comModefy = scn.nextLine(); 
										bs.commentModefy(comModefy, modefy, boardNum);
										System.out.println("	수정이 완료되었습니다.");
										break;
									}
									else
									{
										System.out.println("	수정할 댓글이 없습니다.");
										break;
									}
									
									
								} catch (InputMismatchException e) {
									System.out.println("	숫자를 입력하세요.");
									scn.nextLine();
								}
							}
							else if (comment == 4) {
								System.out.println("	기존 화면으로 돌아갑니다.");
								break;
							} else
								System.out.println("	잘못된 번호입니다. 다시 입력하세요.");
						}
					}
				}

			} else if (menu == 3) {
				if (sux.user != null) {
					num = bs.writeNum();
					num += 1;
					System.out.print("	글제목을 입력하세요 : ");
					String title = scn.nextLine();
					System.out.print("	글내용을 입력하세요 : ");
					String writer = scn.nextLine();

					System.out.print("	게시판 비밀번호를 입력하세요 : ");
					String pwd = scn.next();
					String date = sdf.format(now);
					Board b1 = new Board(num, pwd, sux.user.getUserName(), title, writer, date, sux.user.getUserNum());
					bs.insertBoard(b1);
				} else {
					System.out.println("	게시글을 등록하려면 회원가입을 해야합니다.");
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
						System.out.println("	조회된 게시글이 없습니다.");
					else {
						// 리스트받아서 내가쓴글만 조회.
						System.out.print("	수정하고자 하는 게시글의 번호를 입력하세요 : ");

						try {
							writeNum = scn.nextInt();
							scn.nextLine();
							checkNum = bs.CheckPwd(writeNum);
							if (checkNum == false)
								System.out.println("	게시글 번호를 똑바로 입력해주세요.");
							else {
								System.out.print("	게시글 제목 : ");
								String title = scn.nextLine();
								System.out.print("	게시글 내용 : ");
								String write = scn.nextLine();
								String date = sdf.format(now);

								Board board = new Board(writeNum, null, null, title, write, date,
										sux.user.getUserNum());
								bs.modifyBoard(board);
								System.out.println("	수정이 완료되었습니다.");
							}
						} catch (InputMismatchException e) {
							System.out.println("	잘못 입력하셨습니다.");
							scn.nextLine();
						}

					}
				} else {
					System.out.println("	글 수정을 위해서라면 로그인을 하셔야 합니다.");
				}

			} else if (menu == 5) {
				if (sux.user != null) {
					List<Board> list = bs.refercence();
					for (Board board : list) {
						System.out.println(board.boardReference());
					}
					boolean checkNum = bs.CheckNum();
					if (checkNum == false) {
						System.out.println("	조회된 게시글이 없습니다.");
					} else {
						System.out.print("	삭제하고자 하는 게시글의 번호를 입력하세요 : ");
						try {
							writeNum = scn.nextInt();
							scn.nextLine();
							checkNum = bs.CheckPwd(writeNum);
							if (checkNum == true) {
								System.out.print("	삭제할 게시글의 비밀번호를 입력하세요 : ");
								String pwd = scn.next();
								boolean checkDelete = bs.BoardDelete(pwd,writeNum);
								if (checkDelete == true)
									System.out.println("	삭제가 완료되었습니다.");
								else {
									System.out.println("	비밀번호가 틀립니다.");
								}
							}
						} catch (InputMismatchException e) {
							System.out.println("	게시글 번호를 다시한번 확인하세요.");
							scn.nextLine();
						}

					}
				} else {
					System.out.println("	글을 삭제하시려면 로그인을 해야합니다.");

				}
			} else if (menu == 9) {
				System.out.println("	프로그램 종료.");
				break;
			} else {
				System.out.println("	잘못된 번호입니다. 다시입력하세요");
			}
		}

	}

}