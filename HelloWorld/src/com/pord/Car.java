package com.pord;

public class Car {
	// 모델
	private String model; 
	private int speed;
	private int maxSpeed;
	
	public void addSpeed()
	{
		if(this.speed + 10 <= this.maxSpeed)
		{
			System.out.println("10km 가속");
			this.speed += 10;
		}
		else
		{
			System.out.println("최고속도를 초과할수 없습니다.");
		}
	}
	
	public void breakSpeed()
	{
		if(this.speed - 10 < 0)
			System.out.println("속도는 -가 될 수 없습니다.");
		else 
		{
			System.out.println("10km 감속");
			this.speed -= 10;
		}
	}
	
	public void setMaxSpeed(int maxSpeed)
	{
		this.maxSpeed = maxSpeed;
	}
	
	public int getSpeed()
	{
		return this.speed;
	}
	
	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
	public String setModel()
	{
		return this.model;
	}
	public void setModel(String model)
	{
		this.model = model;
	}
}


