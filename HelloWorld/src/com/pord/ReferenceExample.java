package com.pord;

import java.util.Scanner;


public class ReferenceExample {

	public static void main(String[] args) {
		//참조 타입 vs 기본 타입
		int num1 = 10;// 리터럴
		int num2 = 10; 
		Scanner scn = new Scanner(System.in);
		
		System.out.println(num1);
		System.out.println(num2);
		String str1 = new String("hello");
		String str2 = new String("hello");
		String str3 = "new";
		String str4 = "new";
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3 == str4);
		System.out.println(str1.equals(str2));
		System.out.println(str1 == str2);
		
	}

}
