package algo0423DP;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

// DP : 배낭문제
public class Solution_5215_햄버거다이어트 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			int[] taste = new int[N + 1];
			int[] calory = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				taste[i] = Integer.parseInt(st.nextToken());
				calory[i] = Integer.parseInt(st.nextToken());
			}

			int[][] max = new int[N + 1][L + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= L; j++) {
					if (calory[i] > j)
						max[i][j] = max[i - 1][j];
					else {
						// 이전 차수의 값 vs 이전 차수의 현재 칼로리 - 현재 칼로리
						max[i][j] = max[i - 1][j] < max[i - 1][j - calory[i]] + taste[i]
								? max[i - 1][j - calory[i]] + taste[i]
								: max[i - 1][j];
					}
				}
			}
			System.out.println("#" + tc + " " + max[N][L]);
		}
	}
}
