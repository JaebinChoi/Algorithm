package staging;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution_6109_추억의2048게임 {
	static int N, size;
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static ArrayDeque<Integer> queue;
	static boolean merge;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if (dir.equals("up")) {
				queue = new ArrayDeque<>();
				for (int j = 0; j < N; j++) {
					merge = false;
					for (int i = 0; i < N; i++) {
						action(i, j);
					}

					// 테이블 수정
					size = queue.size();
					for (int i = 0; i < size; i++)
						move(i, j);

					for (int i = size; i < N; i++)
						fillZero(i, j);

				}
			} else if (dir.equals("down")) {
				queue = new ArrayDeque<>();
				for (int j = 0; j < N; j++) {
					merge = false;
					for (int i = N - 1; i >= 0; i--) {
						action(i, j);
					}

					size = queue.size();
					for (int i = 0; i < size; i++)
						move((N - 1) - i, j);

					for (int i = N - 1 - size; i >= 0; i--)
						fillZero(i, j);
				}
			} else if (dir.equals("left")) {
				queue = new ArrayDeque<>();
				for (int i = 0; i < N; i++) {
					merge = false;
					for (int j = 0; j < N; j++) {
						action(i, j);
					}

					size = queue.size();
					for (int j = 0; j < size; j++)
						move(i, j);

					for (int j = size; j < N; j++)
						fillZero(i, j);
				}
			} else {
				queue = new ArrayDeque<>();
				for (int i = 0; i < N; i++) {
					merge = false;
					for (int j = N - 1; j >= 0; j--) {
						action(i, j);
					}

					size = queue.size();
					for (int j = 0; j < size; j++)
						move(i, (N - 1) - j);

					for (int j = N - 1 - size; j >= 0; j--)
						fillZero(i, j);
				}
			}

			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	private static void fillZero(int i, int j) {
		map[i][j] = 0;
	}

	private static void move(int i, int j) {
		map[i][j] = queue.pollLast();
	}

	private static void action(int i, int j) {
		if (map[i][j] == 0)
			return;

		if (queue.size() == 0 || merge) {
			queue.push(map[i][j]);
			merge = false;
			return;
		}

		int n = queue.peek();
		if (n == map[i][j]) {
			queue.pop();
			queue.push(n * 2);
			merge = true;
		} else {
			queue.push(map[i][j]);
			merge = false;
		}
	}
}
