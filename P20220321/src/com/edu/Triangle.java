package com.edu;

public class Triangle extends Shape{
	
	private double base;
	private double height;
	
	
	
	public double getBase() {
		return base;
	}



	public void setBase(double base) {
		this.base = base;
	}



	public double getHeight() {
		return height;
	}



	public void setHeight(double height) {
		this.height = height;
	}



	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return base * height / 2;
	}
	

}
