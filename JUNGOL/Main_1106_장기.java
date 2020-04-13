package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 장기
public class Main_1106_장기 {
	static int N, M;
	static int hr, hc, er, ec;
	static int[][] map;
	static int count;
	static int[][] dir = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];

		st = new StringTokenizer(br.readLine());
		hr = Integer.parseInt(st.nextToken());
		hc = Integer.parseInt(st.nextToken());
		er = Integer.parseInt(st.nextToken());
		ec = Integer.parseInt(st.nextToken());

		bfs(hr, hc);
		System.out.println(count);

	}

	private static void bfs(int row, int col) {
		LinkedList<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] { row, col });
		map[row][col] = 1;
		int r, c, nr, nc, t;
		int[] temp;

		while (!queue.isEmpty()) {
			temp = queue.poll();
			r = temp[0];
			c = temp[1];
			t = map[r][c];

			for (int i = 0; i < 8; i++) {
				nr = r + dir[i][0];
				nc = c + dir[i][1];

				if (nr > 0 && nr < N + 1 && nc > 0 && nc < M + 1 && map[nr][nc] == 0) {
					if (nr == er && nc == ec) {
						count = t;
						return;
					} else {
						map[nr][nc] = t + 1;
						queue.offer(new int[] { nr, nc });
					}
				}
			}
		}

	}
}
