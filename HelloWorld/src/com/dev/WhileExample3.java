package com.dev;

import java.util.Scanner;

public class WhileExample3 {

	public static void main(String[] args) {
		// 입력
		Scanner scn = new Scanner(System.in);
		int inputVal, sum = 0;
		while(true)
		{
			System.out.println("숫자를 입력하세요");
			inputVal = scn.nextInt();
			if(inputVal == -1)
				break;
			
			sum += inputVal;
		}
		System.out.println(sum);
	}

}
