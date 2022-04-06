package com.edu.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamExample2 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("홍길동", "남자", 70, 100));
		list.add(new Student("김순희", "여자", 80, 120));
		list.add(new Student("김부식", "남자", 85, 95));
		list.add(new Student("박한나", "여자", 88, 99));
		
		//남자,여자 스코어+포인트를 더했을 때, 값이 180이상인 학생들만 출력
		
//		list.stream().filter(student -> student.score >= 80).filter(student -> student.gender.equals("여자")).forEach(student -> System.out.println(student));
		
//		list.stream().filter(s -> s.score + s.point >= 180).sorted() // Comparable구현하는 클래스.
//		.forEach(s -> System.out.println(s));
//	
		list.stream().sorted().forEach(s -> System.out.println());
		//두개더해서 정렬.
		
		list.stream().sorted().forEach(s -> System.out.println(s));
		//두개더해서 정렬.
	}

}
