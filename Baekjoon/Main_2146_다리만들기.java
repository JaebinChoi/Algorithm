package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2146_다리만들기 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/다리만들기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬을 나눈다.
		int idx = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					island(i, j, idx++);
				}
			}
		}

		// 섬을 연결
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					visited = new boolean[N][N];
					connect(i, j);
				}
			}
		}
		
		System.out.println(result);
	} // main

	private static void connect(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		visited[r][c] = true;
		queue.offer(new int[] { r, c, -1 });
		int islandIdx = map[r][c];

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			r = temp[0];
			c = temp[1];
			int len = temp[2];

			// 다른 섬에 도착했을 경우
			if (map[r][c] != islandIdx && map[r][c] != 0) {
				result = Math.min(result, len);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == islandIdx || visited[nr][nc])
					continue;

				visited[nr][nc] = true;
				queue.offer(new int[] { nr, nc, len + 1 });
			}
		}
	}

	private static void island(int r, int c, int idx) {
		LinkedList<int[]> queue = new LinkedList<>();
		map[r][c] = idx;
		visited[r][c] = true;
		queue.offer(new int[] { r, c });

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			r = temp[0];
			c = temp[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 0 || visited[nr][nc])
					continue;

				map[nr][nc] = idx;
				visited[nr][nc] = true;
				queue.offer(new int[] { nr, nc });
			}
		}
	}

}