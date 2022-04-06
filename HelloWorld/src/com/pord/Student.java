package com.pord;

public class Student {
	String studentNo;
	String studentName;
	int korScore;
	int engScore;
	
	// method : 기능.. 함수
	void study(String subject)
	{
		System.out.println(subject + "를 합시다.");
	}
	
	void eat(String food)
	{
		System.out.println(food +"를 먹었습니다.");
	}
	
	int getKorScore()
	{
		return korScore;
	}
	int getEngScore()
	{
		return engScore;
	}
}
