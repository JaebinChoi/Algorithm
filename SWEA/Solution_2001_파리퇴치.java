package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001_파리퇴치 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/파리퇴치.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];

			// 파리수 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int max = 0;
			for (int i = 0; i <= N - M; i++) { // 순회
				for (int j = 0; j <= N - M; j++) {

					int sum = 0;
					for (int a = i; a < i + M; a++) { // M 개수만큼 순회
						for (int b = j; b < j + M; b++) {
							sum += map[a][b];
						}
					}

					if (max < sum) {
						max = sum;
					}
				}
			}

			System.out.println("#" + tc + " " + max);

		} // tc

	}
}
