package com.ssafy.combination;

import java.util.Arrays;
import java.util.Scanner;

public class Combination1 {
	static int testcase;
	static int n;
	static int r;
	static int[] numbers; // 조합을 담을 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		numbers = new int[r];

		combination(0, 1);
		System.out.printf("%dC%d 조합의 수 : %d", n, r, testcase);
	}

	/**
	 * 조합을 구하는 함수
	 * 
	 * @param cnt   배열의 index
	 * @param start 조합을 시작할 수
	 */
	private static void combination(int cnt, int start) {
		if (cnt == r) {
			testcase++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i <= n; i++) {
			numbers[cnt] = i;
			combination(cnt + 1, i + 1);
		}

	}

}
