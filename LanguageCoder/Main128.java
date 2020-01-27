package jungol;

import java.util.Scanner;

/**
 * 
 * 0 이 입력될 때까지 정수를 계속 입력받아 3의 배수와 5의 배수를 제외한 수들의 개수를 출력하는 프로그램을 작성하시오.
 *
 */
public class Main128 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int count = 0;

		while (true) {
			int num = sc.nextInt();

			if (num == 0)
				break;

			if (num % 3 != 0 && num % 5 != 0)
				count++;
		}

		System.out.println(count);

	}
}
