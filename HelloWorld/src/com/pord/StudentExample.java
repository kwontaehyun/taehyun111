package com.pord;

public class StudentExample {

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.studentName = "홍길동";
		s1.korScore = 80;
		s1.engScore = 85;
		s1.study("공부");
		s1.study("자바");

		s1.eat("햄버거");
		s1.eat("맥도날드");
		
		int v1 = s1.getKorScore();
		int v2 = s1.getEngScore();
		System.out.println(v1 + " " + v2);
	}

}
