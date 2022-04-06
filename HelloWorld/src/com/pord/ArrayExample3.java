package com.pord;

public class ArrayExample3 {

	public static void main(String[] args) {
		String[] names = new String[5];
		
		names[0] = "홍길동";
		names[1] = "234";
		names[2] = "권태현";
		names[3] = "배고픔";
		
		names[1] = "이삼사";
		names[4]= "tae hyun";
		String searchName = "권태현";
		
		
		for(int i=0; i<names.length; i++) {
			if(names[i].equals(searchName))
				System.out.println( i+1 + "에 있습니다.");
		}
	}

}
