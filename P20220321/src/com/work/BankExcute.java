package com.work;

import java.util.Scanner;

public class BankExcute {
	public void excute() {
		
		BankInterface bank = new BankImpl();
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("1.계좌생성 2.입금 3.출금 4.계좌삭제 5.조회 6.종료");
			int menu = scn.nextInt();
			
			if(menu == 1)
			{
				System.out.println("계좌번호 입력 : ");
				int no = scn.nextInt();
				System.out.println("이름 입력 : ");
				String name = scn.next();
				System.out.println("예치금 입력 : ");
				int money = scn.nextInt();
				
				Bank bk = new Bank(no,name,money);
				bank.insert(bk);
			}
			else if(menu == 2)
			{
				System.out.println("입금할 계좌번호 입력 : "); //저잠만여 청소기때문에 시끄러워서 !! 그냥짜는중
				int no = scn.nextInt();
				System.out.println("입금할 금액 입력 : ");
				int money = scn.nextInt();
				
				bank.deposit(no, money);
			}
			else if(menu == 3)
			{
				System.out.println("출금할 계좌번호 입력 : ");
				int no = scn.nextInt();
				System.out.println("출금할 금액 입력 : ");
				int money = scn.nextInt();
				
				bank.withDraw(no,money);
			}
			else if(menu == 4)
			{
				System.out.println("삭제할 계좌번호 입력 : ");
				int no = scn.nextInt();
				bank.delete(no);
			}
			else if(menu == 5)
			{
				System.out.println(bank.check());
			}
			else if(menu == 6)
			{
				System.out.println("프로그램종료");
				break;
			}
			else
			{
				System.out.println("잘못된 번호.");
			}
			
		}
	}

}
