package com.dev;

public class ArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 정수형 배열 선언 
		
		int[] intAry = {34, 25, 48, 12};
		
		int temp = 0;
		
		for(int i=0; i<intAry.length; i++)
		{
			for(int j=0; j<4; j++)
			{
				if(intAry[0] < intAry[j])
				{
					temp = intAry[i];
					intAry[i] = intAry[j];
					intAry[j] = temp;
				}
			}
		}
		for(int i=0; i<intAry.length; i++)
			System.out.print(" " + intAry[i]);
	}

}
