package com.dev;

import java.util.Scanner;

import com.edu.Student;

public class StudentEx {

	public static void main(String[] args) {
		//배열 선언5개, 입력, 리스트출력.
		Scanner scn = new Scanner(System.in);
		Student[] students = new Student[5];
		int select;
		while(true)
		{
			System.out.println("1.입력 2.리스트 3. 종료");
			System.out.print("선택 >");
			select = scn.nextInt();
			
			if(select == 1)
			{
				System.out.println("학생정보를 입력해주세요");
				System.out.println("학번을 입력하세요...");
				int sno = scn.nextInt(); 
				System.out.println("이름을 입력하세요...");
				String name = scn.next();
				System.out.println("국어점수를 입력하세요...");
				int kor = scn.nextInt();
				System.out.println("영어점수를 입력하세요...");
				int eng = scn.nextInt();
				System.out.println("수학점수를 입력하세요...");
				int math = scn.nextInt();
				
				Student s1 = new Student(sno, name, kor, eng, math);
				for(int i=0; i<students.length; i++)
				{
					if(students[i] == null)
					{
						students[i] = s1;
						break;
					}
				}
				System.out.println("저장을 완료 했습니다.");
			}
			else if(select == 2)
			{
				System.out.println("리스트기능구현");
				for(int i=0; i<students.length; i++)
				{
					if(students[i] != null)
						System.out.println(students[i].getStudInfo());
					else
						break;
				}
				System.out.println("조회 완료.");
			}
			else if(select == 3)
			{
				System.out.println("프로그램 종료합니다.");
				break;
				
			}
			else
			{
				System.out.println("메뉴를 잘못선택했습니다. 다시 눌러주세요.");
			}
			
		}
	}

}
