package com.edu;

import java.util.Scanner;

public class CashExample {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int price, cash;
		int change = 0;
		double surtax;
		System.out.print("가격을 입력하세요 : ");
		price = scn.nextInt();
		
		System.out.print("손님이 낸 금액 : ");
		cash = scn.nextInt();
		
		surtax = ((double)price / 110) * 10;
		change = cash - price; 
		
		System.out.println("부가세 : " + surtax + "\n거스름돈 : " + change);
	}
}
