package com.edu;

public class Taxi extends Vehicle {

	public Taxi()
	{
		super.setMaxSpeed(120);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "택시의 최고속도는 [" + super.getMaxSpeed() + "]";
	}

	@Override
	public void run() {
		System.out.println("택시가 달립니다.");
	}

	@Override
	public void stop() {
		System.out.println("택시가 멈춥니다.");
	}

	
	
}
