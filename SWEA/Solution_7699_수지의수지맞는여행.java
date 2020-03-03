package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// DFS
public class Solution_7699_수지의수지맞는여행 {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int result;
	static Set<Character> set = new HashSet();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/수지.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			visited = new boolean[R][C];
			set.clear();

			// 데이터 입력
			for (int i = 0; i < R; i++) {
				String line = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = line.charAt(j);
				}
			}

			dfs(0, 0, 1);

			System.out.println("#" + tc + " " + result);
		} // testcase
	} // main

	private static void dfs(int r, int c, int cnt) {
		visited[r][c] = true;
		set.add(map[r][c]);
		result = Math.max(result, cnt);
		// 종료
		// 실행
		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];

			if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc])
				continue;

			// 알파벳 중복 여부
			if (set.contains(map[nr][nc]))
				continue;

			// 재귀
			dfs(nr, nc, cnt + 1);
			visited[nr][nc] = false;
			set.remove(map[nr][nc]);
		}

	} // method
}
