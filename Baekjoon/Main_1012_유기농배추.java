package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
	static int N, M, num;
	static boolean[][] cabbage;
	static int count;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/유기농배추.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			cabbage = new boolean[N][M];
			count = 0;

			for (int i = 0; i < num; i++) {
				st = new StringTokenizer(br.readLine());
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());
				cabbage[row][col] = true;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cabbage[i][j]) {
						count++;
						dfs(i, j);
					}
				}
			}
			System.out.println(count);
		}
	}

	private static void dfs(int row, int col) {
		int nr, nc;
		cabbage[row][col] = false;

		for (int i = 0; i < 4; i++) {
			nr = row + dir[i][0];
			nc = col + dir[i][1];

			if (nr > -1 && nr < N && nc > -1 && nc < M && cabbage[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}

}
