package bj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_7576_토마토 {
	static int[][] box;
	static int N, M;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visit;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/토마토.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 열
		N = Integer.parseInt(st.nextToken()); // 행
		box = new int[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ArrayDeque<int[]> queue = new ArrayDeque<int[]>();

		// 1 찾은것을 큐에 넣기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 1) {
					visit[i][j] = true;
					queue.offer(new int[] { i, j });
				}
			}
		}

		// 큐에 넣은 1을 bfs
		int max = bfs(queue);

		boolean flag = false;
		for (int i = 0; i < N; i++) { // 박스 순회
			for (int j = 0; j < M; j++) {
				if (visit[i][j]) { // 방문했으면 익은 토마토
					box[i][j] = 1;
				}
				if (box[i][j] == 0) { // 방문 안했으면
					flag = true;
				}
			}
		}
		if (flag) {
			System.out.println(-1);
		} else {
			System.out.println(max - 1);
		}

	}

	private static int bfs(ArrayDeque<int[]> queue) {
		int r, c, nr, nc, t;
		int[] temp;
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				temp = queue.poll();
				r = temp[0];
				c = temp[1];

				for (int i = 0; i < 4; i++) {
					nr = r + dir[i][0];
					nc = c + dir[i][1];

					if (nr > -1 && nr < N && nc > -1 && nc < M && box[nr][nc] == 0 && !visit[nr][nc]) {
						visit[nr][nc] = true;
						queue.offer(new int[] { nr, nc });
					}

				}
			}
			level++; // 큐가 한바퀴 돌면 하루 지남
		}
		return level;

	}

}
