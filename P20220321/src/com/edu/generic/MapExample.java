package com.edu.generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {
		// Map : {key, value}
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		map.put("전민욱", 80);
		map.put("김형민", 82);
		map.put("김영민", 85);
		//컬렉션: 여러값을 저장해놓고, 불러오는용도로 사용..... => 여러요소 접근
		
		Integer val = map.get("김형민"); //키값을 주면, 밸류값을 가지고옴
		System.out.println(val);
		
		Set<String> keySet = map.keySet(); //map컬렉션에 저장된 요소들의 키에 해당값을 Set컬렉션에 담아준 값
		Iterator<String> iter = keySet.iterator();
		
		while(iter.hasNext())
		{
			String key = iter.next();
			Integer value = map.get(key);
			System.out.println(key + " " + value);
		}
		// 2) for( : ) 문
		for(String key : keySet) {
			Integer value = map.get(key);
			System.out.println(key + " " + value);
		}
	}
	
}
