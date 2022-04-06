package com.dev;

import java.util.Scanner;

public class WhileExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int i = 1;
			while (i <= 5)
			{
				System.out.println("i의 값 => " + i);
				i++;
			}
			
			int num = 0;
			while (true)
			{
				num++;
				if ( num > 5)
					break;
			}
			
			while(true)
			{
				int rand = (int)(Math.random() * 10) + 1;
				
				System.out.println("임의의 생성된 값 : " + rand);
				if(rand == 8)
					break;
				
			}
			Scanner scn = new Scanner(System.in);
			int randomVal, userVal;
			while(true)
			{
				randomVal = (int)(Math.random() * 5) + 1;
				System.out.println("임의의 값을 입력하세요(1~5)");
				userVal = scn.nextInt();
				
				if(randomVal == userVal)
				{
					System.out.println(" = ");
					break;
				}
			}
	}
}
