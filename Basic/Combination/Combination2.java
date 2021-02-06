package com.ssafy.combination;

import java.util.Arrays;
import java.util.Scanner;

public class Combination2 {
	// static int[] arr = { 3, 6, 7, 1, 5 };
	static int[] arr = { 1, 2, 3, 4, 5 };
	static int r;
	static int[] combi;
	/*
	 * subset의 개수는 2의 n승 개이므로 size : 1 << n 0 : 원소를 선택 안함 1 : 원소를 선택함 0 0000 : 원소를
	 * 하나도 선택안한 서브셋 1 0001 : 맨 끝의 원소 하나를 선택한 서브셋 ... size-1 1111 : 모든 원소를 선택한 서브셋
	 * 
	 * O(1<<n)
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		int n = arr.length;
		combi = new int[n]; // subset을 만들기 때문에

		int k; // 배열의 index => 조합의 수

		for (int i = 0, size = 1 << n; i < size; i++) {
			k = 0;
			for (int j = 0; j < n; j++) {
				if ((i & 1 << j) != 0) {
					combi[k++] = j;
				}
			}
			if (k == r) {
				print();
			}
		}
	}

	private static void print() {
		for (int i = 0; i < r; i++) {
			System.out.print(arr[combi[i]] + " ");
		}
		System.out.println();

	}

}
