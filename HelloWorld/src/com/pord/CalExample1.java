package com.pord;

public class CalExample1 {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		System.out.println(cal.PI);
		
		int number1 = 10;
		int number2 = 20;
		//호출 하는 부분. => 매개 값, 매개 값 
		int sum = cal.add(number1, number2);

		System.out.println(sum);
		
		int minus = cal.minus(number2, number1);
		System.out.println(minus);
		
		double rect = cal.getRectArea(number1,number2);
		System.out.println(rect);
		
		double r = 4.5;
		rect = cal.getCircleArea(r);
		System.out.println(rect);
	}

}
