package com.dev;

import java.util.Scanner;

import com.edu.Student;

public class ObjectExample {

	public static void main(String[] args) {
		Student s1 = new Student(50, "dsad");
		Student s2 = new Student(100, "AAA", 75, 80, 95);
		
		Scanner scn = new Scanner(System.in);
		//scn.nextInt();
		System.out.println(s1.getStudNo());
		

		Student s3 = new Student(102, "서현일", 70, 80, 90);
		Student s4 = new Student(102, "최규완", 77, 82, 83);
		
		Student[] students = {s1, s2, s3, s4};
		
		while(true) 
		{
			System.out.println("조회하려는 학생의 이름(ex:홍길동):");
			String searchName = scn.next();
			
			if(searchName.equals("종료"))
				break;
			
			for(int i=0; i<students.length; i++)
			{
				if(students[i].getStuName().equals(searchName))
					System.out.println(students[i].getStudInfo());
			}
		}
	}

}
