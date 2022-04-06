package com.edu.api;

import com.edu.IDCheck;

public class IDcheckEx {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IDCheck idcheck = new IDCheck();
		String result = idcheck.getGender("950304-1234567");

		System.out.println(result);
		String result1 = idcheck.getGender("9503042234567");

		System.out.println(result1);
		String result2 = idcheck.getGender("950304 1234567");

		System.out.println(result2);
		
	}
}
