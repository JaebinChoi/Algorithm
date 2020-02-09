package com.ssafy.swea;

import java.util.Scanner;

public class Solution_1926_간단한369게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			int cnt = 0;

			if (i < 10) { // 한 자리수
				if (i % 3 == 0) // 일의 자리수 => 3배수
					System.out.print("-");
				else
					System.out.print(i);

				System.out.print(" ");

			} else if (i < 100) { // 두 자리수
				if (i / 10 % 3 == 0) // 십의 자리수 => 3배수
					cnt++;

				if (i % 10 != 0 && i % 10 % 3 == 0) // 일의 자리수 => 3배수 / 일의 자리수 != 0
					cnt++;

				if (cnt > 0) {
					for (int j = 0; j < cnt; j++)
						System.out.print("-");
				} else
					System.out.print(i);

				System.out.print(" ");

			} else { // 세 자리수
				if (i / 100 % 3 == 0) // 백의 자리수 => 3배수
					cnt++;

				if (i / 10 % 10 != 0 && i / 10 % 10 % 3 == 0) // 십의 자리수 => 3배수
					cnt++;

				if (i % 10 != 0 && i % 10 % 3 == 0) // 일의 자리수 => 3배수
					cnt++;
				if (cnt > 0) {
					for (int j = 0; j < cnt; j++)
						System.out.print("-");
				} else
					System.out.print(i);

				System.out.print(" ");

			}

		}

	}
}
