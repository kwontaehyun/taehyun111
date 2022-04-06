package com.dev;

import java.util.Scanner;

// BankApp (main method), Account(계좌번호, 예금주, 잔액)
public class BankApp {
	static Account[] banks = new Account[100];
	static Scanner scn = new Scanner(System.in);
	static int mone;
	// 메뉴: 1. 계좌생성(계좌번호, 예금주, 예금액)
	// 2. 예금(번호, 예금액) -> 최고 예금액 10만원
	// 3. 출금(번호, 출금액) -> 잔액보다 큰 금액 출금 금지.
	// 4. 잔액조회
	// 5. 송금(송금번호, 금액, 입금번호)
	// 5. 프로그램 종료

	public static void main(String[] args) {
		while (true) {
			printMenu();
			int menu = scn.nextInt();
			if (menu == 1)
				createAccount();
			else if (menu == 2)
				deposit();
			else if (menu == 3)
				withdraw();
			else if (menu == 4)
				findAccountMoney();
			else if (menu == 5)
				transferAmount();
			else if (menu == 6) {
				System.out.println("종료");
				break;
			} else if (menu == 9) {
				System.out.println(banks[0].getAccName());
				showList();
			} else
				System.out.println("번호를 다시입력하세요");
		}
		System.out.println("=== End of prog ===");
	}

	// 메뉴출력 기능
	public static void printMenu() {
		String menu = "메뉴: 1. 계좌생성(계좌번호, 예금주, 예금액)\n" + "     2. 예금(번호, 예금액) -> 최고 예금액 10만원\n"
				+ "     3. 출금(번호, 출금액) -> 잔액보다 큰 금액 출금 금지.\n" + "     4. 잔액조회\n" + "		5. 5. 송금(송금번호, 금액, 입금번호)\n"
				+ "     6. 프로그램 종료\n" + "선택 > ";
		System.out.println(menu);
	}

	// 계좌생성 메소드
	public static void createAccount() {
		System.out.println("계좌생성기능.");
		String accNo;
		while (true) {
			System.out.println("계좌번호입력>> ");
			accNo = scn.next();
			if (addBanks(accNo) != null) {
				System.out.println("이미 있는 계좌입니다.");
				System.out.println("다시 계좌번호를 입력하세요.");
			} else
				break;
		}
		System.out.println("예금주입력>>");
		String accName = scn.next();
		System.out.println("예금액입력>>");
		int accMoney = scn.nextInt();
		Account accnt = new Account(accNo, accName, accMoney);
		int checkCnt = 0;
		for (int i = 0; i < banks.length; i++) {
			if (banks[i] == null && checkCnt != 1) {
				banks[i] = accnt;
				checkCnt = 1;
				break;
			}
		}
		System.out.println("계좌가 정상적으로 생성되었습니다.");
	}

	// 예금 메소드
	public static void deposit() {
		System.out.println("예금기능");
		String num;
		int No;
		int money = 0;
		int checkCnt = 0;
		for (int i = 0; i < banks.length; i++) {
			System.out.println("계좌번호입력>> ");
			num = scn.next();
			if (addBanks(num) == null) {
				System.out.println("없는 계좌입니다.");
				System.out.println("다시 입력은 1번, 계좌가 없으면 2번을 눌러주세요");
				No = scn.nextInt();
				if (No == 2) {
					break;
				}
			}
			if (banks[i] != null && banks[i].getAccNo().equals(num)) {
				System.out.println("입금할 금액을 입력하세요");
				money = scn.nextInt();
				int a = banks[i].getAccMoney();
				checkCnt = 1;
				if (a + money > 100000) {
					checkCnt = 2;
				}
				banks[i].setAccMoney(a + money);
				System.out.println("입금이 완료되었습니다. 현재잔액 :" + banks[i].getAccMoney());
				break;
			}

			if (checkCnt == 1)
				System.out.println("정상적으로 처리되었습니다.");
			else if (checkCnt == 2)
				System.out.println("한도액을 초과했습니다.");
			else
				break;

		}
	}

	// 출금 메소드
	public static void withdraw() {
		System.out.println("출금기능");
		String num;
		int No;
		int money;
		int checkCnt = 0;
		for (int i = 0; i < banks.length; i++) {
			System.out.println("계좌번호입력>> ");
			num = scn.next();

			if (addBanks(num) == null) {
				System.out.println("없는 계좌입니다.");
				System.out.println("다시 입력은 1번, 계좌가 없으면 2번을 눌러주세요");
				No = scn.nextInt();
				if (No == 2) {
					break;
				}
			}
			if (banks[i] != null && banks[i].getAccNo().equals(num)) {
				System.out.println("출금할 금액을 입력하세요");
				money = scn.nextInt();
				int a = banks[i].getAccMoney();
				banks[i].setAccMoney(a - money);
				System.out.println("출금이 완료되었습니다. 현재잔액 : " + banks[i].getAccMoney());
				break;
			}

			if (checkCnt == 1)
				System.out.println("정상적으로 처리되었습니다.");
			else if (checkCnt == 2)
				System.out.println("한도액을 초과했습니다.");
			else
				System.out.println("계좌번호가 틀립니다.");
		}

	}

	// 잔액조회 메소드
	public static void findAccountMoney() {
		System.out.println("조회기능");
		String num;
		int No;
		while (true) {
			System.out.println("계좌번호입력>> ");
			num = scn.next();
			if (addBanks(num) == null) {
				System.out.println("없는 계좌입니다.");
				System.out.println("다시 입력은 1번, 계좌가 없으면 2번을 눌러주세요");
				No = scn.nextInt();
				if (No == 2) {
					break;
				}
			} else {
				break;
			}
		}

		int checkCnt = 0;
		for (int i = 0; i < banks.length; i++) {
			if (banks[i] != null && banks[i].getAccNo().equals(num)) {
				System.out.println(banks[i].toString());
				checkCnt++;
				break;
			} else {
				if (checkCnt == 1)
					System.out.println("정상적으로 처리되었습니다.");
				else
					System.out.println("계좌번호가 틀립니다.");
				break;
			}
		}

	}

	// 전체 리스트 출력
	public static void showList() {
		for (int i = 0; i < banks.length; i++) {
			if (banks[i] != null) {
				System.out.println(banks[i].toString());
			}
		}
	}

	// 계좌번호를 입력하면 배열(banks)에서 그 계좌번호를 반환, 없으면 null

	public static Account addBanks(String acc) {

		for (int i = 0; i < banks.length; i++) {
			if (banks[i] != null && banks[i].getAccNo().equals(acc)) {
				return banks[i];
			}

		}
		return null; // 클래스 -> 초기값 null ( Student , Car, )
	}

	public static void transferAmount() {
		String number;
		int i = 0;
		while (true) {
			System.out.println("본인 계좌번호를 입력하세요");
			number = scn.next();
		}
	}
}
