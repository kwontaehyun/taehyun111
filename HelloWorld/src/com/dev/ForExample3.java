package com.dev;

import java.util.Scanner;

public class ForExample3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int num1, num2;
		int sum = 0;
		System.out.println("두 수를 입력 하세요");
		num1 = scn.nextInt();
		num2 = scn.nextInt();
		
		for(int i = num1; i<=num2; i++)
			sum += i;
		
		System.out.println(num1 + "부터" + num2 + "까지의 합" + sum );
		{
			int num3 = 3;
		}
		scn.close();
		
	}

}
