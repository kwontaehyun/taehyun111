package com.edu.nested;

public class Outer {
	
	private String fieldString;
	private int fieldInt;
	
	class Inner { // 멤버클래스
		String field3;
		int field4;
		
		void method2()
		{
			System.out.println("Inner.method2()");
		}
	}
	
	public String getFieldString()
	{
		return fieldString;
	}
	
	public void method1()
	{
		System.out.println("Outer.method1()");
		Inner inner = new Inner();
		inner.method2();
		
	}
	//함수적 인터페이스: 구현해야 할 메소드가 하나인것.
	interface Runable{
		void run();
	}
	
	class Bus implements Runable{
		
		@Override
		public void run()
		{
			System.out.println("Runnable.run()");
		}
	}
	
	public void method3()
	{
		System.out.println("Outer.method3()");
		
		class Local { //로컬클래스
			void method4() {
				System.out.println("Local.method4()");
			}
		}
		Local local = new Local();
		local.method4();
	}
	
	public void method4() {
		Runable runable = new Bus();
		runable.run();
		
		//익명 구현 객체
//		
//		runable = new Runable() {
//			
//			@Override
//			public void run()
//			{
//				System.out.println("임의의 객체를 실행합니다.");
//			}
//		};
		//람다식
		runable = () -> System.out.println("임의의 객체를 실행합니다.");
		
		runable.run();
		
	}
	
}
