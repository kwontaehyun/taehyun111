package com.pord;

import java.util.Scanner;

public class ArrayExample {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int i1 = 100;
		byte b1 = 127; // -128 ~ 127
		short s1 = 100; // -32768 ~32787
		b1++;
		b1++;
		System.out.println(b1);
		
		int score1 = 80;
		int score2 = 90;
		int score3 = 85;
		int score4 = 95;
		int score5 = 88;
		
		int sum = 0;
		
		sum = score1 + score2 + score3 + score4 + score5;
		
		double avg = sum / (double) 5;
		System.out.println(avg);
		int[] scores = new int[5];
		
		scores[0] = 80;
		scores[1] = 90;
		scores[2] = 85;
		scores[3] = 95;
		scores[4] = 88;
		sum = 0;
		for(int i=0 ; i<5; i++)
			sum += scores[i];
			//System.out.println(scores[i]);
		avg = sum / (double) 5;
		System.out.println(avg);
	}

}
