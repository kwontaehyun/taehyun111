package com.work;

import java.util.List;

//인터페이스는 -> 선언만해놔여 -> 

public interface BankInterface {
	//계좌번호, 이름, 예치금
	//계좌생성, 입금, 출금 계좌삭제, 조회
	public void insert(Bank b1);
	public void deposit(int sno, int money);
	public void withDraw(int sno, int money);
	public void delete(int sno);
	public List<Bank> check();
}