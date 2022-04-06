package com.edu.interfaces;

public class Computer implements RemoteControl{
	private String cpu;
	private String memory;
	
	@Override
	public void PowerOn() {
		System.out.println("컴퓨터를 켭니다.");
		
	}
	@Override
	public void PowerOff() {
		System.out.println("컴퓨터를 끕니다.");		
	}
	
}
