package com.edu.except;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryExe {
	
	private static LibraryExe singleton = new LibraryExe();
	
	private LibraryExe() {
		
	}
	
	public static LibraryExe getInstance()
	{
		return singleton;
	}
	
//	public static void main(String[] args) {
	public void run() {
	// 책제목, 저자, 가격 -> 저장.
		// 리스트 보여주기.
		Scanner scn = new Scanner(System.in);

		Book[] library = new Book[5];

		while (true) {
			
			int menu;
			while (true) {
				try {
					showMessage("메뉴선택: 1.책정보입력, 2.리스트보기, 3.종료");
					menu = scn.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("숫자를 입력하세요.");
					scn.nextLine();
				}
			}
			if (menu == 1) {
				System.out.println("책제목을 입력하세요");
				String name = scn.next();
				System.out.println("저자를 입력하세요");
				String author = scn.next();
				int price;
				
				while(true) {
					try {
						System.out.println("가격을 입력하세요");
						price = scn.nextInt();
						break;
					}
					catch(InputMismatchException e)
					{
						System.out.println("숫자를 입력하세요.");
						scn.next();
					}
				}

				Book b1 = new Book(name, author, price);

				for (int i = 0; i < library.length; i++) {
					if (library[i] == null) {
						library[i] = b1;
						break;
					}
				}
				System.out.println("정보가 등록되었습니다.");
			} else if (menu == 2) {
				for (int i = 0; i < library.length; i++) {
					if (library != null) {
						library[i].showInfo();
						break;
					}
				}
			} else if (menu == 3) {
				showMessage("프로그램 종료");
				break;
			} else {
				System.out.println("잘못입력하였습니다.");
			}
		}
		showMessage("=== end of program ===");
	}

	public void showMessage(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}
