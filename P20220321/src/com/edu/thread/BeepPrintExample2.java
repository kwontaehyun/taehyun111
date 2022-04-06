package com.edu.thread;

import java.awt.Toolkit;

class BeepThread extends Thread{
	
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class BeepPrintExample2 {
	public static void main(String[] args)
	{
		//Thread클래스를 상속받는 클래스를 선언. run메소드 오버라이딩
		Thread thread = new BeepThread();
		thread.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("beep");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("end of prog");
		//비프음.. 생성
		
		//비프 출력.
	}
}
