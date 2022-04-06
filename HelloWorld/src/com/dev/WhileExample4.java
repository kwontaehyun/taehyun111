package com.dev;

import java.util.Scanner;

public class WhileExample4 {

	public static void main(String[] args) {
		// 은행 계좌 만들어서, 1: 입금, 2: 출금, 3: 종료
		// 입금일 경우: 입금액을 입력하세요.... account 값을 + 누적
		Scanner scn = new Scanner(System.in);
		int account = 0, deposit, withDraw;
		int menu;

		while (true) {
			System.out.println("값을 입력하세요 1:입금 2:출금 3:종료");
			menu = scn.nextInt();
			if (menu == 1) {
				System.out.println("입금액을 입력하세요...");
				deposit = scn.nextInt();
				account += deposit;
				System.out.println("현재 잔액은 " + account + "원 입니다.");
			} else if (menu == 2) {
				System.out.println("출금액을 입력하세요...");
				withDraw = scn.nextInt();
				if (account < withDraw) {
					System.out.println("잔액이 부족합니다.");
					System.out.println("현재 잔액은 " + account + "원 입니다.");
					continue;
				}
				account -= withDraw;
				System.out.println("현재 잔액은 " + account + "원 입니다.");
				
			} else if (menu == 3) {
				System.out.println("end of program");
				break;
			} else {
				System.out.println("숫자를 다시 입력하세요 (1~3)");
			}
		}
		scn.close();
	}
}
