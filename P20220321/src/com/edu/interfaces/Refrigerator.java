package com.edu.interfaces;

public class Refrigerator implements RemoteControl {
	
	@Override
	public void PowerOn() {
		System.out.println("냉장고를 켭니다.");
		
	}
	@Override
	public void PowerOff() {
		System.out.println("냉장고를 끕니다.");
		
	}
}
