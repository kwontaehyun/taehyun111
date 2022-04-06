package com.work;

import java.io.IOException;

public class StringEx2 {

	public static void main(String[] args) {
		byte[] bytes = new byte[100];
		
		System.out.println("입력 : ");
		int readByteNo = 0;
		try {
			readByteNo = System.in.read(bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String str = new String(bytes, 0, readByteNo-2);
		System.out.println(str);

	}

}
