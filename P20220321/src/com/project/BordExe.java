package com.project;

import java.util.List;
import java.util.Scanner;

public class BordExe {
	
	public void excute() {
		Scanner scn = new Scanner(System.in);
		Board board = new Board();
		BoardService bs = new BoardApp();
		while(true) {
			
			System.out.println("1. 게시판 글 목록보기 2. 게시글 등록 3.게시글 수정 4.게시글 삭제 9.종료");
			int menu = scn.nextInt();
			
			if(menu == 1)
			{
				List<Board> list = bs.BoardList();
				for(Board brd : list)
					System.out.println(brd.toString());
			}
			else if(menu == 2)
			{
				System.out.println("게시판 작성번호를 입력하세요");
				int num = scn.nextInt();
				System.out.println("게시판 비밀번호를 입력하세요");
				String pwd = scn.next();
				System.out.println("작성자를 입력하세요");
				String name = scn.next();
				System.out.println("글제목을 입력하세요");
				String title = scn.next();
				System.out.println("글내용을 입력하세요");
				String writer = scn.next();
				System.out.println("작성 날짜를 입력하세요");
				String date = scn.next();
				
				Board b1 = new Board(num, pwd, name, title, writer, date);
				
				bs.insertBoard(b1);
			}
			else if(menu == 3)
			{
				System.out.println("수정 할 게시글의 게시번호를 입력하세요");
				int num = scn.nextInt();
				System.out.println("수정하고자 하는 게시글의 비밀번호를 입력하세요 : ");
				String pwd = scn.next();
				System.out.println("게시글 제목 : ");
				String title = scn.next();
				System.out.println("게시글 내용 : ");
				String write = scn.next();
				
				Board b1 = new Board(num, pwd, null, title, write, null);
				bs.modifyBoard(b1);
			}
			else if(menu == 4)
			{
				System.out.println("삭제할 게시글의 게시번호를 입력하세요");
				int num = scn.nextInt();
				System.out.println("삭제할 게시글의 비밀번호를 입력하세요");
				String pwd = scn.next();
				bs.BoardDelete(pwd);
			}
			else if(menu == 9)
			{
				System.out.println("프로그램 종료.");
				break;
			}
			else
			{
				System.out.println("잘못된 번호입니다. 다시입력하세요");
			}
		}
		
	}
	
	
}
