package com.dev;

public class forExample4 {

	public static void main(String[] args) {
		// 1 ~ 10 까지 수중에서 짝수의 값은 => evenSum , 홀수는 => oddSum
		
		int evenSum = 0, oddSum = 0;
		
		for(int i = 1; i<=10; i++)
		{
			if(i % 2 == 0)
				evenSum += i;
			else
				oddSum += i;
		}
		
		System.out.println("홀수의 합 : " + oddSum + " 짝수의 합 : " + evenSum + "입니다");
		
	}

}
