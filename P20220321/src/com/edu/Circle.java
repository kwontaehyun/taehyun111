package com.edu;

public class Circle extends Shape{
	
	private final double PI = 3.14;
	private double radius;
	
	
	
	public double getRadius() {
		return radius;
	}



	public void setRadius(double radius) {
		this.radius = radius;
	}



	public double getPI() {
		return PI;
	}



	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return radius * radius * PI;
	}
	
	

}
