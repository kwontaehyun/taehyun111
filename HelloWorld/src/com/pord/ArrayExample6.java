package com.pord;

public class ArrayExample6 {

	public static void main(String[] args) {
		int[] numbers = {35, 22 , 17, 40, 28, 33, 36};
		int sum = 0, cnt = 0;
		double avg;
		for(int i=0; i<numbers.length; i++)
		{
			if(numbers[i] > 30 && numbers[i] < 40)
			{
				cnt++;
				sum += numbers[i];
				System.out.println(numbers[i]);
			}
			
		}
		avg = sum / (double)cnt;
		System.out.printf("%.2f", avg);
	}

}
