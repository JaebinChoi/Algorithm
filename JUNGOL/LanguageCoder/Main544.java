package jungol;

import java.util.Scanner;

/**
 * 
 * 100 이하의 정수를 입력받아서 입력받은 정수부터 100까지의 합을 출력하는 프로그램을 작성하시오.
 *
 */
public class Main544 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int sum = 0;

		for (int i = num; i < 101; i++)
			sum += i;

		System.out.println(sum);

	}
}
