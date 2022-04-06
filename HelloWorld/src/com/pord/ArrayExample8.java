package com.pord;

import java.util.Scanner;

public class ArrayExample8 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] numbers = new int[2];
		int temp;
		for(int i=0; i<numbers.length; i++)
		{
			System.out.println(i+1 + "번째 값을 입력");
			numbers[i] = scn.nextInt();
		}
		if(numbers[0] > numbers[1])
		{
			temp = numbers[0];
			numbers[0] = numbers[1];
			numbers[1] = temp;
		}
		
		for(int i=0; i<numbers.length; i++)
			System.out.println(i+1+"번째 값 :" + numbers[i]);
	}

}
