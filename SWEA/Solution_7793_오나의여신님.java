package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_7793_오나의여신님 {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	static int result;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/오나의여신님.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			visited = new boolean[R][C];
			result = 0;

			LinkedList<int[]> queue = new LinkedList<>();
			for (int i = 0; i < R; i++) {
				String line = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == 'S') {
						visited[i][j] = true;
						queue.offerFirst(new int[] { i, j, 0, 1 });
					} else if (map[i][j] == '*') {
						queue.offer(new int[] { i, j, 0, -1 });
					}
				}
			}

			bfs(queue);

			System.out.println("#" + tc + " " + (result == 0 ? "GAME OVER" : result));
		}
	}

	private static void bfs(LinkedList<int[]> queue) {
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int r = temp[0];
			int c = temp[1];
			int time = temp[2];
			int isGoddess = temp[3];

			// 여신 이동할 차례인데 악마가 덮친 곳
			if (map[r][c] == '*' && isGoddess == 1)
				continue;

			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];

				// 영역 밖, 여신이 방문한 곳
				if (nr < 0 || nr >= R || nc < 0 || nc >= C || (isGoddess == 1 && visited[nr][nc]))
					continue;

				// 여신이 여신의 공간에 도착했을 경우
				if (map[nr][nc] == 'D' && isGoddess == 1) {
					result = time + 1;
					return;
				}

				// 악마 또는 돌 또는 여신의 공간
				if (map[nr][nc] == '*' || map[nr][nc] == 'X' || map[nr][nc] == 'D')
					continue;

				if (isGoddess == 1)
					visited[nr][nc] = true;
				
				map[nr][nc] = map[r][c];
				queue.offer(new int[] { nr, nc, time + 1, isGoddess });
			}
		}
	}
}
