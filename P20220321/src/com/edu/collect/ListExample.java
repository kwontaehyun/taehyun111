package com.edu.collect;

import java.util.ArrayList;

public class ListExample {

	public static void main(String[] args) {
		String[] strings = new String[10];
		
		for(int i=0; i<strings.length; i++)
		{
			if(strings[i] == null)
			{
				strings[i] = "hello";
				break;
			}
		}
		
		
		ArrayList<String> strAry = new ArrayList();
		strAry.add("Hello");
		strAry.add("World");

		strAry.set(1, "월드");
		strAry.remove("World");
		strAry.add(null);

		strAry.set(1, "월드");
		
		strAry.clear();
		System.out.println(strAry.size());
		for(int i=0; i<strAry.size(); i++)
		{
			String result = strAry.get(i);
			System.out.println(result);
		}
		
	//	System.out.println(strAry);
		
		

//		ArrayList<Integer> numAry = new ArrayList();
//		
//		for(int i=0; i<numAry.size(); i++)
//		{
//			int result = numAry.get(i);
//		}
		
		
	}

}
