package jungol;

import java.util.Scanner;

/**
 * 
 * 문자를 입력받아서 입력받은 문자를 20번 반복하여 출력하는 프로그램을 작성하시오.
 *
 */
public class Main541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char a = sc.next().charAt(0);

		for (int i = 0; i < 20; i++) {
			System.out.print(a);
		}

	}
}
