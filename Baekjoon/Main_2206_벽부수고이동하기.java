package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// BFS
public class Main_2206_벽부수고이동하기 {
	static int N, M;
	static int[][] map;
	static int[][] destroy; // 공사횟수
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int result;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/벽부수고이동하기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		destroy = new int[N][M];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
				destroy[i][j] = 2; // 배열을 공사 횟수의 최대보다 크게!
			}
		}

		move(0, 0);
		if (result == 0) {
			result = -1;
		}
		System.out.println(result);

	}

	private static void move(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		int nr, nc, t = 1;
		int[] temp;
		int chance = 0; // 벽 부술 기회

		queue.offer(new int[] { r, c, t, chance });
		while (!queue.isEmpty()) {
			temp = queue.poll();
			r = temp[0];
			c = temp[1];
			t = temp[2];
			chance = temp[3];

			if (r == N - 1 && c == M - 1) { // 도착했을 경우
				result = t;
				break;
			}

			for (int i = 0; i < 4; i++) {
				nr = r + dir[i][0];
				nc = c + dir[i][1];

				if (nr > -1 && nr < N && nc > -1 && nc < M) { // 경계 안에 존재
					if (destroy[nr][nc] <= chance) // 길이 곂칠경우 공사 횟수가 적은걸로!
						continue;

					if (map[nr][nc] == 0) { // 이동 가능할 경우
						destroy[nr][nc] = chance;
						queue.offer(new int[] { nr, nc, t + 1, chance });
					} else { // 벽을 만날 경우
						if (chance == 0) {
							destroy[nr][nc] = chance + 1;
							queue.offer(new int[] { nr, nc, t + 1, chance + 1 });
						}
					}
				} // 경계조건 true
			} // 경계검사
		} // 큐
	} // move 메소드
} // main
