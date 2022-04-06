package com.edu;
import java.util.Scanner; 


public class TemperatureExample 
{

	public static void main(String[] args) 
	{
		//C = 5/9(F-32) 화씨온도를 섭씨온도로 변경
		Scanner scn = new Scanner(System.in);
		double fDeg, cDeg;
		//섭씨 온도가 30.0 보다 크면 "오늘은 더운 날씨네요" else "살만하네요"
		System.out.println("화씨온도 입력: ");
		fDeg = scn.nextDouble();
		cDeg = 5.0 / 9.0 * (fDeg - 32);
		System.out.println(cDeg);
		
		if (cDeg > 30.0)
			System.out.println("오늘은 더운 날씨네요");
		else
			System.out.println("살만하네요");
		
		scn.close();
	}

}
