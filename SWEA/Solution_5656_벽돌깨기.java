package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 완전탐색(중복순열) + 시뮬레이션
public class Solution_5656_벽돌깨기 {
	static int N, R, C;
	static int[][] map;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	static int min;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/벽돌깨기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new int[R][C];

			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			min = Integer.MAX_VALUE;
			simulation(map, 0);

			System.out.println("#" + tc + " " + (min == Integer.MAX_VALUE ? 0 : min));
		}
	}

	private static void simulation(int[][] map, int cnt) {
		// 구슬 다 떨어뜨린 경우
		if (cnt == N) {
			min = Math.min(min, count(map));
			return;
		}

		// 구슬 떨어뜨리기 (중복순열)
		for (int c = 0; c < C; c++) {
			int r = 0;
			while (r < R) {
				if (map[r][c] != 0)
					break;
				r++;
			}

			// 열이 비어있을 경우 다음 열로 이동
			if (r == R)
				continue;

			int[][] copyMap = copy(map);
			// 벽돌 깨기
			crush(copyMap, r, c);
			// 벽돌 옮기기
			move(copyMap);
			// 다음 구슬 떨어뜨리기
			simulation(copyMap, cnt + 1);
		}
	}

	private static void move(int[][] copyMap) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int c = 0; c < C; c++) {
			for (int r = 0; r < R; r++) {
				if (copyMap[r][c] != 0) {
					stack.push(copyMap[r][c]);
				}
			}

			int size = stack.size();
			for (int r = R - 1, s = 0; r > -1; r--, s++) {
				if (s < size) {
					copyMap[r][c] = stack.pop();
				} else {
					copyMap[r][c] = 0;
				}
			}
		}
	}

	private static void crush(int[][] map, int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c, map[r][c] });
		map[r][c] = 0;

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			r = temp[0];
			c = temp[1];
			int num = temp[2];

			for (int i = 0; i < 4; i++) {
				int nr = r;
				int nc = c;

				for (int j = 0; j < num - 1; j++) {
					nr += dir[i][0];
					nc += dir[i][1];

					// 경계 벗어날 경우
					if (nr < 0 || nr >= R || nc < 0 || nc >= C)
						break;

					// 벽돌이 없을 경우
					if (map[nr][nc] == 0)
						continue;

					if (map[nr][nc] > 1)
						queue.offer(new int[] { nr, nc, map[nr][nc] });

					map[nr][nc] = 0;
				}
			}
		}
	}

	private static int count(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	private static int[][] copy(int[][] map) {
		int[][] copyMap = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		return copyMap;
	}
}
