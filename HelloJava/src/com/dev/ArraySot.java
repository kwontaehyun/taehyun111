package com.dev;

public class ArraySot {

	public static void Arr(int[] Ary)
	{
		int temp = 0;
		
		for(int i=0; i<Ary.length; i++)
		{
			for(int j=0; j<Ary.length; j++)
			{
				if(Ary[i] < Ary[j])
				{
					temp = Ary[i];
					Ary[i] = Ary[j];
					Ary[j] = temp;
				}
			}
		}
		
	}
	
	public static void printAry(int[] Ary)
	{
		for(int i=0; i<Ary.length; i++)
		{
			System.out.print(" " + Ary[i]);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] intAry = {34,25,48,12};
		
		Arr(intAry);
		printAry(intAry);
	}

}
