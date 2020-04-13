package jungol;

import java.util.Scanner;

public class Main_1889_NQueen {
	static int N;
	static int[] row;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		row = new int[N];

		position(N, 0);
		System.out.println(count);
	}

	private static void position(int n, int cur) {
		boolean isPossible;
		if (cur == N) {
			count++;
			return;
		}
		for (int c = 0; c < N; c++) {
			isPossible = true;
			for (int r = 0; r < cur; r++) {
				if (row[r] == c || c == row[r] - (cur - r) || c == row[r] + (cur - r)) {
					isPossible = false;
					break;
				}
			}
			if (isPossible) {
				row[cur] = c;
				position(n, cur + 1);
			}
		}
	}
}
