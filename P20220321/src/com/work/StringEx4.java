package com.work;

public class StringEx4 {
	public static void main(String[] args) {
	
		String strVar1 = new String("신민철");
		String strVar2 = "신민철";
		
		if(strVar1 == strVar2)
		{
			System.out.println("같은 String");
		}
		else
		{
			System.out.println("다른 String");
		}
		
		if(strVar1.equals(strVar2))
		{
			System.out.println("같은 String");
		}
		else
		{
			System.out.println("다른 String");
		}
	}

}
