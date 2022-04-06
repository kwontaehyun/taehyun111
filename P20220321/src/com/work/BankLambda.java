package com.work;

import java.util.ArrayList;
import java.util.List;

import com.work.Bank;

public class BankLambda {

	public static void main(String[] args) {
		List<Bank> list = new ArrayList<Bank>();
		// 계좌번호, 이름, 예치금....
		list.add(new Bank(10, "abc", 20));
		list.stream().forEach(b -> System.out.print(b.toString()));
		
	}
}  