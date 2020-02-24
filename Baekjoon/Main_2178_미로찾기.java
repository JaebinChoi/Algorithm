package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// BFS
public class Main_2178_미로찾기 {
	static int N, M;
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		escape(0, 0);
		System.out.println(result);
	}

	private static void escape(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		int nr, nc, t = 1;
		int temp[];

		map[r][c] = 0; // 방문표시
		queue.offer(new int[] { r, c, t });

		while (!queue.isEmpty()) {
			temp = queue.poll();
			r = temp[0];
			c = temp[1];
			t = temp[2];

			for (int i = 0; i < 4; i++) {
				nr = r + dir[i][0];
				nc = c + dir[i][1];

				if (nr > -1 && nr < N && nc > -1 && nc < M && map[nr][nc] == 1) {
					if (nr == N - 1 && nc == M - 1) { // 도착했으면 끝
						result = t + 1;
						return;
					}
					map[nr][nc] = 0; // 방문표시
					queue.offer(new int[] { nr, nc, t + 1 });
				}
			}
		}
	}
}
