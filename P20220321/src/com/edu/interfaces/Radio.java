package com.edu.interfaces;

public class Radio implements RemoteControl {
	
	@Override
	public void PowerOn() {
		System.out.println("radio를 켭니다.");
		
	}
	@Override
	public void PowerOff() {
		System.out.println("radio를 끕니다.");
		
	}
}
