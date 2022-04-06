package com.edu.lambda.consumer;

import java.util.function.IntSupplier;
// Supplier 인터페이스 : 매개값(X) -> 반환값(O)
public class SupplierExample {

	public static void main(String[] args) {
		IntSupplier intSup = () -> (int)(Math.random() * 10);
		
		int result = intSup.getAsInt();
		System.out.println("결과값은 " + result);
	}

}
