package work.edu;

import java.util.Scanner;

public class work2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("������ ���ڸ� �Է��ϼ���");

		int num1 = scn.nextInt();
		int num2 = scn.nextInt();
		int num3 = scn.nextInt();
		
		int temp = 0;

		System.out.println("���� �� ���� ū ���� �����ϴ� ���α׷�");
		
		
		if(num2 < num1 && num2 < num3)
		{
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		else if (num3 < num1 && num3 < num2)
		{
			temp = num1;
			num1 = num3;
			num3 = temp;
		}
		
		if(num2 > num3)
		{
			temp = num2;
			num2 = num3;
			num3 = temp;
		}
		
		System.out.print(num1 + " " + num2 + " " + num3);

				
//		if (num1 < num2 && num1 < num3) {
//			System.out.println(num1);
//			if (num2 < num3) {
//				System.out.println(num2);
//				System.out.println(num3);
//			} else {
//				System.out.println(num3);
//				System.out.println(num2);
//			}
//		} else if (num2 < num1 && num2 < num3) {
//			System.out.println(num2);
//			if (num1 < num3) {
//				System.out.println(num1);
//				System.out.println(num3);
//			} else {
//				System.out.println(num3);
//				System.out.println(num1);
//			}
//		} else {
//			System.out.println(num3);
//			if (num2 < num1) {
//				System.out.println(num2);
//				System.out.println(num1);
//			} else {
//				System.out.println(num1);
//				System.out.println(num2);
//			}
//		}

	}

}
