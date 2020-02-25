package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_7562_나이트의이동 {
	static int[][] map;
	static int N;
	static int er, ec;
	static int[][] dir = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/나이트의이동.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			st = new StringTokenizer(br.readLine(), " ");
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());

			move(sr, sc);
		}
	}

	private static void move(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		map[r][c] = 1;
		queue.offer(new int[] { r, c, 0 });
		int nr, nc;
		int temp[];

		while (!queue.isEmpty()) {
			temp = queue.poll();
			r = temp[0];
			c = temp[1];
			int time = temp[2];

			// 도착했을 경우
			if (r == er && c == ec) {
				System.out.println(time);
				return;
			}

			for (int i = 0; i < 8; i++) {
				nr = r + dir[i][0];
				nc = c + dir[i][1];

				// 영역 밖이거나 방문했을 경우 pass
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != 0)
					continue;

				map[nr][nc] = time + 1;
				queue.offer(new int[] { nr, nc, time + 1 });
			}
		}
	}
}
