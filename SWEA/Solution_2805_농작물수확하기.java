package swea;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_2805_농작물수확하기 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/농작물수확하기.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testcase = 1; testcase <= T; testcase++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			String str;

			for (int i = 0; i < N; i++) {
				str = sc.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(str.substring(j, j + 1));
				}
			}

			int flag = N / 2;
			int sum = 0;

			for (int i = 0; i < flag; i++) {
				for (int j = flag - i; j <= flag + i; j++) {
					sum += arr[i][j];
				}
			}

			for (int i = flag, k = 0; i < N; i++, k++) {
				for (int j = 0 + k; j < (N - k); j++) {
					sum += arr[i][j];
				}
			}

			// for (int i = 0; i < N; i++) {
			// for (int j = 0; j < N; j++) {
			// System.out.print(arr[i][j]);
			// }
			// System.out.println();
			// }
			System.out.println("#" + testcase + " " + sum);

		}

	}
}
