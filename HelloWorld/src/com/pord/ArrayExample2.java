package com.pord;

import java.util.Scanner;

public class ArrayExample2 {

	public static void main(String[] args) {
		//
		Scanner scn = new Scanner(System.in);
		int[] ages = new int[3];
		ages[0] = 20;
		ages[1] = 23;
		ages[2] = 27;
		
		ages[0] = 30;
		ages[1] = 32;
		ages[2] = 35;
		int sumAge = 0;
		double avgAge = 0;
		for (int i = 0; i < 3; i++) {
			System.out.println(ages[i] + "살 입니다.");
			sumAge += ages[i];
		}
		avgAge = sumAge / (double) 3;
		System.out.println("평균나이는 " + avgAge + "살 입니다.");
	}

}
