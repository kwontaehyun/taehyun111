package com.edu.generic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class setExample {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>(); // set : 중복값 허용 X
		
		set.add("Hello");
		set.add("World");
		set.add("Good");
		
		set.remove("Good");
		
		System.out.println("set 크기 : " + set.size());
		
		
		set.iterator(); // 반복자
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext())
		{
			String result = iter.next();
			System.out.println(result);
		}
	}
	
}
