package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// BFS
public class Main_2573_빙산 {
	static int R, C;
	static int[][] map, meltMap;
	static boolean[][] visited;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/빙산.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		meltMap = new int[R][C];
		visited = new boolean[R][C];

		// 데이터 입력
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int year = 0;
		while (true) {
			// 빙산 덩어리 개수 확인
			// 1년 후 녹을 빙산 계산
			int chunk = 0;
			for (int i = 1; i < R - 1; i++) {
				for (int j = 1; j < C - 1; j++) {
					if (map[i][j] != 0 && !visited[i][j]) {
						search(i, j);
						chunk++;
					}
				}
			}

			// 빙산 덩어리 확인
			if (chunk == 0) {
				System.out.println(0);
				break;
			} else if (chunk >= 2) {
				System.out.println(year);
				break;
			}

			// 빙산이 녹는 작업
			melt();

			// 두 배열 초기화
			visited = new boolean[R][C];
			meltMap = new int[R][C];

			year++;
		} // while
	} // main

	private static void melt() {
		for (int i = 1; i < R - 1; i++) {
			for (int j = 1; j < C - 1; j++) {
				// 빙산 녹이기
				map[i][j] -= meltMap[i][j];

				// 높이가 0 이하일 경우
				if (map[i][j] < 1)
					map[i][j] = 0;
			}
		}

	}

	private static void search(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		visited[r][c] = true;
		queue.offer(new int[] { r, c });
		int nr, nc;

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			r = temp[0];
			c = temp[1];

			for (int i = 0; i < 4; i++) {
				nr = r + dir[i][0];
				nc = c + dir[i][1];

				// 1년 후 녹는 빙산의 양
				if (map[nr][nc] == 0)
					meltMap[r][c]++;

				if (!visited[nr][nc] && map[nr][nc] != 0) {
					visited[nr][nc] = true;
					queue.offer(new int[] { nr, nc });
				}
			} // direction search
		} // while
	}
}
