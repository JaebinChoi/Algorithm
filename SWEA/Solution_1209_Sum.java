package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1209_Sum {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/sum.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 100;
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			int[][] arr = new int[N][N];
			int rmax = 0;
			int cmax = 0;
			int rowsum = 0;
			int colsum = 0;
			br.readLine();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int leftsum = 0; // 왼쪽 대각선 합
			for (int i = 0; i < N; i++) {
				for (int j = i; j <= i; j++) {
					leftsum += arr[i][j];
				}
			}

			int rightsum = 0; // 오른쪽 대각선 합
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j <= N - 1; j++) {
					rightsum += arr[i][j];
				}
			}

			for (int i = 0; i < N; i++) {
				rowsum = 0; // 행 합
				for (int j = 0; j < N; j++) {
					rowsum += arr[i][j];
				}
				if (rmax < rowsum) {
					rmax = rowsum;
				}
			}

			for (int i = 0; i < N; i++) {
				colsum = 0;
				for (int j = 0; j < N; j++) {
					colsum += arr[j][i];
				}
				if (cmax < colsum) {
					cmax = colsum;
				}
			}

			System.out.println("#" + tc + " " + Math.max(Math.max(leftsum, rightsum), Math.max(rmax, cmax)));

		}

	}
}
