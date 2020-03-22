package backjoon;

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main_9663_NQueen {
	static int N;
	static int[] rows;
	static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		rows = new int[N];

		position(0);
		System.out.println(count);
	}

	private static void position(int curRow) {
		boolean isPossible;
		if (curRow == N) {
			count++;
			return;
		}

		for (int col = 0; col < N; col++) {
			isPossible = true;
			for (int row = 0; row < curRow; row++) {
				if (col == rows[row] || col == rows[row] - (curRow - row) || col == rows[row] + (curRow - row)) {
					isPossible = false;
					break;
				}
			}
			if (isPossible) {
				rows[curRow] = col;
				position(curRow + 1);
			}
		}
	}
}
