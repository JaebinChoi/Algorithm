package jungol;

import java.util.Scanner;

public class Main1339 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int s = N / 2;
		char[][] arr = new char[N][N];
		char ch = 'A';

		if (N % 2 != 1 || N < 1 || N > 100) {
			System.out.println("INPUT ERROR");
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = ' ';
				}
			}

			for (int i = s, k = 0; i >= 0; i--, k++) {
				for (int j = i; j <= s + k; j++) {
					arr[j][i] = ch++;
					if (ch > 'Z') {
						ch = 'A';
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}

	}
}
