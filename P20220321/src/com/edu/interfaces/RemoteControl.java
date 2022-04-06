package com.edu.interfaces;

public interface RemoteControl {
	
	public static final int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	//되는건 메소드!와 상수.!
	//필드 생성 불가능
	//생성자 생성 불가능
	public void PowerOn(); //추상메소드.
	public void PowerOff();
}
