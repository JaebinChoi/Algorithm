package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_모의SW역량_디저트카페 {
	static int N, sr, sc;
	static int[][] cafe;
	static boolean[][] visited;
	static int[][] dir = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } }; // 우하 -> 좌하> 좌상 -> 우상
	static HashSet<Integer> list = new HashSet<Integer>();
	static int max;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/디저트카페.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			cafe = new int[N][N];
			visited = new boolean[N][N];
			max = 0;

			// 데이터 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					cafe[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					sr = i;
					sc = j;

					dfs(i, j, 0);

					// 초기화 작업
					for (int k = 0; k < N; k++)
						Arrays.fill(visited[k], false);
					
					list.clear();
				}
			}

			System.out.println("#" + tc + " " + (max == 0 ? -1 : max));
		} // testcase
	} // main

	private static void dfs(int r, int c, int d) {
		visited[r][c] = true;
		list.add(cafe[r][c]);

		for (int i = d; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			int cnt = list.size();

			if (nr == sr && nc == sc && cnt >= 4) {
				max = Math.max(max, cnt);
				return;
			}

			if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || list.contains(cafe[nr][nc]))
				continue;

			dfs(nr, nc, i);
		}

		visited[r][c] = false;
		list.remove(cafe[r][c]);
	}
}
