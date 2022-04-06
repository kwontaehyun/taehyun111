package com.edu.generic;

import java.util.ArrayList;

public class BoxExample {

	public static void main(String[] args) {
//		Box box = new Box();
//		box.setObj("1234");
//		
//		String result = (String) box.getObj();
//		System.out.println(result);
//		
//		Integer result1 = (Integer) box.getObj();
//		System.out.println(result);
		
		Box<String> stringBox = new Box<String>();
		stringBox.setObj("Hello");
		String result = stringBox.getObj();
		
		Box<Integer> intBox = new Box<Integer>();
		intBox.setObj(100);
		Integer result1 = intBox.getObj();
		
		ArrayList<Integer> intAry = new ArrayList<Integer>();
		
		
		
	}

}
