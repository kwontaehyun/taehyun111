package com.edu;
//Object(객체) -> Class(도면, 틀) -> 인스턴스생성(초기화)
//학생(객체:Object) -> Class Student -> instance (new Stadent())
//객체지향프로그램언어.
//절차프로그램(데이터, 함수) -> 객체(데이터, 기능(함수))
//학생(객체:Object) -> Class Student -> 필드선언, 메소드,인스턴스 초기화
public class ObjectExample {

	public static void main(String[] args) {
		int num1 = 01;
		double num2 = 12.34;
		double num3 = 20; //자동 형변환
		int num4 = (int)23.4; // 강제 형변환
		
		String str1 = "Hello"; //heap(인스턴스)
		String str2 = new String(""); //초기화
		str1.equals("Hello");
		
		Car car1 = new Car(); // 초기화(인스턴스 생성)
		car1.setModel("Sonata");
		car1.setPrice(1000000);
		
		Student s1 = new Student();
		System.out.println("영어점수 초기값: " + s1.getEngScore());
		System.out.println("이름의 초기값: " + s1.getStuName());
		System.out.println(s1.getStuName() + "의 합계점수 : " + s1.getSumScore());
		System.out.println(s1.getStuName() + "의 평균 : " + s1.getAvgScore());
	}

}

