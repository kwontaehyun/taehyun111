package com.pord;
//클래스 정의
public class Calculator {
	//field
	final double PI = 3.14;
	
	//method 매개변수  매개변수 
	int add(int n1, int n2)
	{
		return n1+n2;
	}
	// 반환 : int, 
	int minus(int v1, int v2)
	{
		return v1-v2;
	}
	
	double getRectArea(double x, double y)
	{
		return x * y;
	}
	
	double getCircleArea(double radius)
	{
		return radius * radius * PI;
	}
}
