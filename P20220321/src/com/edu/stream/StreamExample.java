package com.edu.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

class Student implements Comparable<Student> {
	String name;
	String gender;
	int score;
	int point;

	public Student(String name, String gender, int score) {
		this.name = name;
		this.gender = gender;
		this.score = score;
	}

	public Student(String name, String gender, int score, int point) {
		super();
		this.name = name;
		this.gender = gender;
		this.score = score;
		this.point = point;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", score=" + score + ", point=" + point + "]";
	}

	@Override
	public int compareTo(Student student) {
		// this 와 student 비교: this, student -> 오름차순 // 반대는 내림차순

//		if (this.point < student.point) {
//			return 1;
//		} else {
//			return -1;
//		}
		return (this.score + this.point) - (student.point + student.score);
	}

}

public class StreamExample {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("홍길동", "남자", 70));
		list.add(new Student("김순희", "여자", 80));
		list.add(new Student("김부식", "남자", 85));
		list.add(new Student("박한나", "여자", 88));

		// 평균구하기.

		int cnt = 0;
		int sum = 0;
		double avg = 0;

		for (Student student : list) {
			if (student.gender.equals("남자")) {
				cnt++;
				sum += student.score;
			}
		}

		avg = sum / (double) cnt;

		Stream<Student> stream = list.stream(); // 스트림 생성.
		OptionalDouble od = stream.filter(s -> s.gender.equals("남자")).mapToInt(s -> s.score).average();

		avg = od.getAsDouble();
		System.out.println("스트림 평균: " + avg);

		// stream.forEach((Student t) -> {
//			System.out.println("이름은 : " + t.name + "성별은 : " + t.gender + "점수는 : " + t.score);
//		});

	}

}
