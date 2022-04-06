package com.edu.lambda.consumer;

import java.util.function.IntBinaryOperator;

public class OperatorExample {

	public static void main(String[] args) {
		

		IntBinaryOperator intBin = (left,right) -> left +right;
		int result1 = intBin.applyAsInt(10, 20);
		System.out.println(result1);

		intBin = (num1, num2) -> num1<num2?num1:num2;
		int result = maxOrMin(intBin);
		System.out.println(result);
	}
	
	public static int maxOrMin(IntBinaryOperator intBin) {
		//IntBinaryOperator <- 매개변수로 기능을 넣어줌.
		//제일 큰값을 골라내는 기능을 넣으면 큰값 아니라면 작은값.
		//
		int[] intAry = {85,47,92};
		
		int result = intAry[0];
		for(int num : intAry)
		{
			result = intBin.applyAsInt(result,num);
		}
		
		return result;
	}

}
