package jungol;

import java.util.Scanner;

public class Main1338 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char ch = 'A';
		char[][] arr = new char[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = ' ';
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = i, k = N; j <= N; j++, k--) {
				arr[j][k] = ch++;
				if(ch > 'Z') {
					ch = 'A';
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}
}
