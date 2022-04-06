package com.pord;

public class ArrayExample4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {35, 22 , 17, 40, 28, 33, 36};
		int sum = 0 , cnt = 0;
		double avg;
		for(int i=0; i< numbers.length; i++)
		{
			if(numbers[i] % 2 == 0) {
				sum += numbers[i];
				cnt++;
			}
		}
		avg = sum / (double) cnt;
		System.out.println(sum);
		System.out.println(avg);
	}

}
