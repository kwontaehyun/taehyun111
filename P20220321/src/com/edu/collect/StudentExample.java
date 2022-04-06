package com.edu.collect;

import java.util.ArrayList;
import java.util.List;

public class StudentExample {

	public static void main(String[] args) {
		
		List<Student> list = new ArrayList();
		
		Student s1 = new Student(101, "홍길동", 70, 73);
		Student s2 = new Student(102, "장길산", 80, 85);
		Student s3 = new Student(103, "도둑놈", 84, 88);
		
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		list.get(0).setKorScore(100);
		list.get(0).setEngScore(100);
		Student result = list.get(0); // 첫번째 학생정보 저장.
		System.out.println("첫번째 학생: " + result);
		
		list.set(0, new Student(201,"서현일",90,92));
		result =list.get(0);
		System.out.println("첫번째 학생: " + result);
		
		list.get(0).setKorScore(100);
		list.get(0).setEngScore(100);
		System.out.println("첫번째 학생: " + result);
		list.remove(0);
		System.out.println("첫번째 학생: " + list);
	}
	
	
}
