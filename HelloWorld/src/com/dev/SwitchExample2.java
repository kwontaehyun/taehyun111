package com.dev;

public class SwitchExample2 {

	public static void main(String[] args) {
		// 90점 이상 A 80점 이상 B
		
		int score = 75 / 10;
		
		switch(score)
		{
		case 10:
			System.out.println("A 학점");
		case 9:
			System.out.println("A 학점");
			break;
		case 8:
			System.out.println("B 학점");
			break;
		case 7:
			System.out.println("C 학점");
			break;
		case 6:
			System.out.println("D 학점");
			break;
		default:
			System.out.println("F 학점");
			break;
		}
		

	}

}
