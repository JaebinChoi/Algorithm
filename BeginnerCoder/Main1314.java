package jungol;

import java.util.Scanner;

public class Main1314 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[][] arr = new char[n][n];
		char ch = 'A';

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[j + (n - 1 - 2 * j) * (i % 2)][i] = ch++;
				if (ch > 'Z')
					ch = 'A';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}
}
