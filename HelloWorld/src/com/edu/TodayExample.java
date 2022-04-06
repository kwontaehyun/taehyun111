package com.edu;
import java.util.Scanner;

public class TodayExample {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		String myName, myPhone;
		int myAge;
		double myTall; 
		double myWeight, avgWeight;
		
		System.out.println("이름 : ");
		myName = scn.nextLine();
		scn.nextLine();
		System.out.print("연락처 : ");
		myPhone = scn.nextLine();
		System.out.print("나이 : ");
		myAge = scn.nextInt();
		System.out.print("키 : ");
		myTall = scn.nextDouble();
		System.out.print("몸무게 : ");
		myWeight = scn.nextDouble();
		
		avgWeight = (myTall - 100) * 0.9;
		System.out.println("이름 : " + myName + "\n연락처 : " + myPhone + "\n나이 : " + myAge + "\n키 : " + myTall);
		System.out.println("몸무게 : " + myWeight);
		
		if(myWeight+5 > avgWeight && myWeight -5 < avgWeight)
			System.out.println("적정몸무게입니다.");
		else
			System.out.println("비정상입니다.");
	}

}
