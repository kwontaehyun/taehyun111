package com.edu;

import java.util.Scanner;
public class RactangleExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int xLength, yLength, area;
				
		System.out.print("가로 길이: ");
		xLength = scn.nextInt();
		System.out.print("세로 길이: ");
		yLength = scn.nextInt();
		
		area = xLength * yLength;
		System.out.println("계산(너비) 결과: " + area);
	}
	

}
