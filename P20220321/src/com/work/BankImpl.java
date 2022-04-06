package com.work;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankImpl implements BankInterface{

	Scanner scn = new Scanner(System.in);
	List<Bank> list = new ArrayList<Bank>();
	
	@Override
	public void insert(Bank b1) { //계좌생성
		list.add(b1);
	}

	@Override
	public void deposit(int sno, int money) { // 입금
		
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).getBankNo() == sno)
			{
				int mon = list.get(i).getBankMoney(); //네
				mon += money;
				list.get(i).setBankMoney(mon);
			}
		}
		System.out.println("계좌번호가 틀립니다.");
	}

	@Override
	public void withDraw(int sno, int money) { //출금
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).getBankNo() == sno)
			{
				int mon = list.get(i).getBankMoney(); //네
				mon -= money;
				list.get(i).setBankMoney(mon);
				break;
			}
		}
		System.out.println("계좌번호가 틀립니다.");
	}

	@Override
	public void delete(int sno) { //삭제
		
		for(int i=0; i<list.size(); i++)
			if(list.get(i).getBankNo() == sno)
				list.remove(i);
		System.out.println("계좌번호가 틀립니다.");
	}

	@Override
	public List<Bank> check() { //조회
		return list;
	}


}
