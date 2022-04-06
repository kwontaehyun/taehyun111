package com.dev;

import com.edu.Student;

public class GugudanEx {
	

	public static void printGugudan()
	{
	// 메소드 실행하려면 new 클래스이름(); ex Student s1 = new Student(); 를 선언해야함
	// static는 new로 선언하지않아도 실행가능.
		int cnt = 0;		
		for(int i=1; i<=10; i++) 
		{
			
			for(int j=2; j<=10; j++) 
			{
				if(i==1)
					System.out.print("[" + j + "단]" + "		");
				else
					System.out.print(j + " * " + cnt + " = " + j*cnt + "	");
			}
			System.out.println();
			cnt++;
		}
	} // end of printGugudan()
	public static void printStar(int runCnt, String shape) 
	{
		for(int i = 0; i<runCnt; i++)
			System.out.print(shape);
	}
	
	public static void gududan(int dan)
	{
		for(int i=1; i<10; i++)
		{
			System.out.printf("%d * %d = %d\n", dan, i, dan*i);
		}
	}
	
	public static int sum(int n1, int n2)
	{
		return n1 + n2;
	}
	
	public static double divide(int n1, int n2)
	{
		if(n1 == 0 || n2 == 0)
			return 0;
		else
			return n1 / (double)n2;
	}
	
	public static int sum(int[] ary)
	{
		int sum = 0;
		for(int i=0; i<ary.length; i++)
			sum += ary[i];
		return sum;
	}
		
	public static void main(String[] args) {
		int result = sum(1,2);
		System.out.println(result);
		
		double result1 = divide(10,4);
		System.out.println(result1);
		
		int[] newAry = {10, 20, 30};
		System.out.println(sum(newAry));
	} // end of main()

}
