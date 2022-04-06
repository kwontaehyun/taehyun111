package com.edu;

import java.util.Scanner;

public class MathExample {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int num1, num2;
		
		System.out.println("두 수를 입력하세요");
		num1 = scn.nextInt();
		num2 = scn.nextInt();
		
		System.out.println("두 수의 합 : " + (num1 + num2));
		System.out.println("두 수의 차 : " + (num1 - num2));
		System.out.println("두 수의 곱 : " + (num1 * num2));
		System.out.println("두 수의 몫 : " + (num1 / num2));
		System.out.println("두 수의 나머지 : " + (num1 % num2));
		
	}

}
