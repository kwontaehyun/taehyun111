package com.edu;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("주사위 3개를 입력하세요");
		
		int num1 = scn.nextInt();
		int num2 = scn.nextInt();
		int num3 = scn.nextInt();
		
		int money = 0;
		
		if (num1 == num2 && num1 == num3 && num2 == num3)
		{
			money = 10000 + (num1*1000);
		}
		else if (num1 == num2 || num1 == num3)
		{
			money = 1000 + (num1 * 100);
		}
		else if(num2 == num3)
		{
			money = 1000 + (num2 * 100);
		}
		else
		{
			if(num1 > num2 && num1 > num3)
				money = num1*100;
			else if(num2 > num1 && num2 > num3)
				money = num2 * 100;
			else
				money = num3 * 100;
		}
		
		System.out.println(money);
		
	}
}
