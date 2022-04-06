package com.dev;

import java.util.Scanner;

public class ForExample6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 최대 공약수
		Scanner scn = new Scanner(System.in);
		int num1, num2;

		System.out.println("두 수를 입력하세요");

		num1 = scn.nextInt();
		num2 = scn.nextInt();

		int result = 0;
		int temp = 0;

		if (num1 < num2) 
		{
			temp = num1;
			num1 = num2;
			num2 = temp;
		} 

		for (int i = 1; i <= num1; i++) 
			if (num1 % i == 0 && num2 % i == 0) 
				result = i;
			
		System.out.println(result);
	}

}
