package com.edu.except;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample {

	public static void main(String[] args) {
		// 오류 : Error, Exception
		// compile error, runtime error;
		try {
			double result = 13 / 0;
			System.out.println(result);
		} catch (ArithmeticException e) {
//			e.printStackTrace();
			e.printStackTrace();
			System.out.println("0으로 못나눔");
		}
		
		Scanner scn = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		try {
			int menu = scn.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("숫자를 입력안하셨네요..");
			
		}
		System.out.println("End of program");

	}

}
