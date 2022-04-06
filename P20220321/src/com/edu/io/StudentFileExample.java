package com.edu.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.edu.collect.Student;

public class StudentFileExample {
	static	Scanner scn = new Scanner(System.in);
	static List<Student> list = new ArrayList<Student>();
	
	public static void writeStudent() {
		try {
			FileWriter fw = new FileWriter("student.txt");
		
			BufferedWriter bw = new BufferedWriter(fw);
			
			while(true)
			{
				System.out.println("이름을 입력>> ");
				String name =scn.nextLine();
				if(name.equals("stop")) {
					bw.close();
					break;
				}
				bw.write(name + "\n");
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void readStudent() {
		try {
			FileReader fr = new FileReader("student.txt");
			BufferedReader br = new BufferedReader(fr);
			String readStr = null;
			while((readStr = br.readLine()) != null)
			{	
				String[] contents = readStr.split(" ");
				list.add( new Student(Integer.parseInt(contents[0])
				,contents[1],Integer.parseInt(contents[2])
				,Integer.parseInt(contents[3])));
				
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
//		writeStudent();
		readStudent();
		
		for(Student student : list)
		{
			System.out.println(student.toString());
		}
		
		System.out.println("end of prog");
	}
}
