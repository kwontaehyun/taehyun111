package com.work;

public class StringEx6 {

	public static void main(String[] args) {
		
		String tel1 = "  02";
		String tel2 = "123   ";
		String tel3 = "   1234    ";
		String tel4 = " 1 2 3 4 ";
		
		String tel = tel1.trim() + tel2.trim() + tel3.trim() + tel4.trim();
		System.out.println(tel);
		
	}

}
