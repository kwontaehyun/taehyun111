package work.edu;

import java.util.Scanner;

public class work1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("�� ���� �Է��ϼ���");
		
		int num1 = scn.nextInt();
		int num2 = scn.nextInt();
		int result = 0;
		if(num1 > num2)
			result = num1 - num2;
		else
			result = num2 - num1;
		
		System.out.println("ū ������ ���� ���� �� �� : " + result);

	}

}
