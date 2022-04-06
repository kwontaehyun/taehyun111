package com.edu.lambda.consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args) {

		Consumer<String> consumer = (String t) -> {
			System.out.println(t + "출력합니다.");
		};

		consumer.accept("ABC를 ");

		BiConsumer<Integer, Integer> biCon = (Integer t, Integer u) -> {
			System.out.println("result => " + (t + u));

		};
		biCon.accept(20, 40);
	}
}
