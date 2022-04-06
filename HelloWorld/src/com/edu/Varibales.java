package com.edu;

public class Varibales {
	public static void main(String[] args) {
//		변수 : 메모리공간 이름지정 값을 할당.
		int age = 20;
		System.out.println("age 변수: " + age);
		int num1 = 60;
		int num2= 50;
		int result = num1 + num2;
		System.out.println("20 + 10 = 30");
		System.out.println(num1 + " + " + num2 + " = " + result);
	
	
		String name = "홍길동"; // 문자열
		name = "최민규";
		System.out.println(name + "의 나이는" + age +"입니다");
	
		final String myName ="권태현"; // 상수
//		myName = "ABC";
		
		String phoneNum = "010-7221-3915";
		String eMail = "deletein@naver.com";
		
		System.out.println("권태현의 전화번호는 " + phoneNum + "이고, 이메일은 " + eMail + "입니다");
		
		
		
		
	}

}
