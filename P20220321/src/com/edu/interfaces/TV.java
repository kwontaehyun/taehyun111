package com.edu.interfaces;

public class TV implements RemoteControl{
	
	
	public void PowerOn()
	{
		System.out.println("tv를 켭니다." + (MAX_VOLUME + 10));
	}
	public void PowerOff()
	{
		System.out.println("tv를 끕니다.");
	}
	
}
