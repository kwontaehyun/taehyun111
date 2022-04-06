package com.edu;

public class VaribaleExample {
	public static void main(String[] agrs)
	{
		int num1 = 100;
		double num2 = 100.5;
		double result = num1 * num2;
		//자동형변환: 작은범위 -> 큰범위.
		System.out.println("결과: " + result);
		//강제형변환: 큰범위 -> 작은범위.
	
		int val1 = 100;
		double val2 = 20.5;
		int sum = val1 + (int)val2;
		System.out.println(sum);
		
		int n1 = 10;
		int n2 = 4;
		
		double n3 = (double)n1 / n2; // 10/4 = 2.5
		System.out.println("나눈 결과: " + n3);
		
		// 10을 3으로 나눈 나머지 -> 1
		
		int n4 = n1 % n2;
		System.out.println("나머지 : " + n4);
		
		//짝수, 홀수
		
		if(n1 % 2 == 0)
		{
			System.out.println(n1 +"의 값은 짝수입니다.");
		}
			
	}
}
