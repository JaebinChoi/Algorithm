package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution_1868_파핑파핑지뢰찾기 {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[][] dir = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
	static int result;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/지뢰찾기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visited = new boolean[N][N];
			result = 0;

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == '*')
						visited[i][j] = true;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j])
						continue;
					bfs(i, j);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						result++;
					}
				}
			}

			System.out.println("#" + tc + " " + result);
		}
	}

	private static void bfs(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		visited[r][c] = true;
		queue.add(new int[] { r, c, 1 });
		result++;

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			r = temp[0];
			c = temp[1];
			int isFirst = temp[2];

			int count = 0;
			for (int i = 0; i < 8; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];

				if (isIn(nr, nc) && map[nr][nc] == '*') { // 경계 안
					if (isFirst == 1) {
						visited[r][c] = false;
						result--;
						return;
					} else
						count++;
				}
			}

			if (count == 0) {
				for (int i = 0; i < 8; i++) {
					int nr = r + dir[i][0];
					int nc = c + dir[i][1];

					if (isIn(nr, nc) && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.add(new int[] { nr, nc, -1 });
					}
				}
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr > -1 && nr < N && nc > -1 && nc < N;
	}
}
