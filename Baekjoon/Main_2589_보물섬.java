package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2589_보물섬 {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int result;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/보물섬.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		// 입력
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		// 탐색 후 BFS
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'L') {
					visited = new boolean[R][C];
					result = Math.max(result, move(i, j));
				}
			}
		}

		// 출력
		System.out.println(result);

	}

	private static int move(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		visited[r][c] = true;
		queue.offer(new int[] { r, c, 0 });
		int nr, nc, distance = 0;
		int[] temp;

		while (!queue.isEmpty()) {
			temp = queue.poll();
			r = temp[0];
			c = temp[1];
			distance = temp[2];

			for (int i = 0; i < 4; i++) {
				nr = r + dir[i][0];
				nc = c + dir[i][1];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == 'W' || visited[nr][nc])
					continue;

				visited[nr][nc] = true;
				queue.offer(new int[] { nr, nc, distance + 1 });
			} // 사방탐색
		} // while
		return distance;
	} // method
} // main
