package com.edu;

import java.util.Scanner;

public class MathExample {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int num1, num2;
		
		System.out.println("�� ���� �Է��ϼ���");
		num1 = scn.nextInt();
		num2 = scn.nextInt();
		
		System.out.println("�� ���� �� : " + (num1 + num2));
		System.out.println("�� ���� �� : " + (num1 - num2));
		System.out.println("�� ���� �� : " + (num1 * num2));
		System.out.println("�� ���� �� : " + (num1 / num2));
		System.out.println("�� ���� ������ : " + (num1 % num2));
		
	}

}
