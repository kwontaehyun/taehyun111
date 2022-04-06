package com.pord;

public class MemberExample {

	public static void main(String[] args) {
		// int num1= 10; String name = "ABC"; 
		// ?? member = "ABC", 10;
		Member mem1 = new Member();
		
		mem1.name = "홍길동";
		mem1.age= 20;
		
		Member mem2 = new Member();
		
		mem2.name = "길동";
		mem2.age = 19;
		
		Student st1 = new Student();
		
		st1.studentName = "동";
		st1.studentNo = "18";
		st1.engScore = 55;
		st1.korScore = 95;
		
		System.out.println(mem1.name);
		System.out.println(mem1.age);
		System.out.println(mem2.name);
		System.out.println(mem2.age);
		
		System.out.println(st1.studentName);
		System.out.println(st1.studentNo);
		System.out.println(st1.engScore);
		System.out.println(st1.korScore);
	}

}
