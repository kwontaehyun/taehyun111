package com.edu;

public class Ractangle extends Shape{
	
	private double width;
	private double height;
	
	
	
	
	public double getWidth() {
		return width;
	}




	public void setWidth(double width) {
		this.width = width;
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
		return width * height;
	}

}
