package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {
	static int R, C;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/섬의개수.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			if (R == 0 && C == 0)
				break;
			map = new int[R][C];
			visited = new boolean[R][C];

			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int result = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						result++;
						bfs(i, j);
					}
				}
			}

			System.out.println(result);

		} // while

	}

	private static void bfs(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		visited[r][c] = true;
		queue.offer(new int[] { r, c });

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			r = temp[0];
			c = temp[1];

			for (int i = 0; i < 8; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || map[nr][nc] == 0)
					continue;

				visited[nr][nc] = true;
				queue.offer(new int[] { nr, nc });
			}
		}
	}
}
