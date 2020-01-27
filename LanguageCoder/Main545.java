package jungol;

import java.util.Scanner;

/**
 * 
 * 10개의 정수를 입력받아 3의 배수의 개수와 5의 배수의 개수를 각각 출력하는 프로그램을 작성하시오.
 *
 */
public class Main545 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int sum = 0;
		int multiples_of_3 = 0;
		int multiples_of_5 = 0;

		for (int i = 0; i < 10; i++) {
			int num = sc.nextInt();

			if (num % 3 == 0)
				multiples_of_3++;
			if (num % 5 == 0)
				multiples_of_5++;
		}
		System.out.println("Multiples of 3 : " + multiples_of_3);
		System.out.println("Multiples of 5 : " + multiples_of_5);

	}
}
