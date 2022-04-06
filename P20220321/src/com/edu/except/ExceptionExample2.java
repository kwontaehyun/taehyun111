package com.edu.except;

import java.util.Calendar;
import java.util.Scanner;


//class String2 extends String{
//	//public final String{} // 상속불가능한 클래스
//}

public class ExceptionExample2 {
	public static void main(String[] args) {
		
		
		Object obj = new String();
		obj = new Scanner(System.in);
		obj = Calendar.getInstance();
		
		obj = new Object();
		System.out.println(obj.hashCode());
//		
//		//Object 제일 상위의 클래스
//		//Exception을 상속받아서 만들어진 클래스
//		try {
//			Class.forName("java.lang.String");
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//			System.out.println("해당클래스가 존재하지않습니다.");
//		}
//		
//		//RuntimeException
//		String str = null;
//
//		
//		try{
//			str.charAt(0); // CharSequence interface의 추상메소드.
//			System.out.println(str.toString());
//		}
//		catch(NullPointerException e) {
//			System.out.println("널포인트 예외발생");
//			e.printStackTrace();
//		}
//		
//		String nums1 = "100"; // 숫자 문자열
//		String nums2 = "200"; // 숫자 문자열
//		int num1,num2;
//		try {
//			num1 = Integer.parseInt(nums1);//int 변환
//			num2 = Integer.parseInt(nums2);//int 변환
//			
//			str.charAt(0);
//		}catch(Exception e2) {
//			num1 = 0;
//			num2 = 0;
//			System.out.println("상위의 예외발생");
//		}
//		
//		try {
//			showError();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
//		System.out.println("end of prog");
	}
	
	
	
	public static void showError1() throws ClassNotFoundException{
			Class.forName("java.lang.Strings");
		
	
		Object obj = new String();
		obj = new Scanner(System.in);
		obj = Calendar.getInstance();
		
		obj = new Object();
		System.out.println(obj.hashCode());
//		
//		//Object 제일 상위의 클래스
//		//Exception을 상속받아서 만들어진 클래스
//		try {
//			Class.forName("java.lang.String");
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//			System.out.println("해당클래스가 존재하지않습니다.");
//		}
//		
//		//RuntimeException
//		String str = null;
//
//		try{
//			str.charAt(0); // CharSequence interface의 추상메소드.
//			System.out.println(str.toString());
//		}
//		catch(NullPointerException e) {
//			System.out.println("널포인트 예외발생");
//			e.printStackTrace();
//		}
//		
//		String nums1 = "100"; // 숫자 문자열
//		String nums2 = "200"; // 숫자 문자열
//		int num1,num2;
//		try {
//			num1 = Integer.parseInt(nums1);//int 변환
//			num2 = Integer.parseInt(nums2);//int 변환
//			
//			str.charAt(0);
//		}catch(Exception e2) {
//			num1 = 0;
//			num2 = 0;
//			System.out.println("상위의 예외발생");
//		}
//		
//		try {
//			showError();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
//		System.out.println("end of prog");
	}
	
	public static void showError() throws ClassNotFoundException{
			Class.forName("java.lang.Strings");
	}
	
	
	
	
	
}
