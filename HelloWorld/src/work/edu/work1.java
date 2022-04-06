package work.edu;

import java.util.Scanner;

public class work1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("두 수를 입력하세요");
		
		int num1 = scn.nextInt();
		int num2 = scn.nextInt();
		int result = 0;
		if(num1 > num2)
			result = num1 - num2;
		else
			result = num2 - num1;
		
		System.out.println("큰 값에서 작은 값을 뺀 값 : " + result);

	}

}
