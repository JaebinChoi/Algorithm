package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;

public class Main_11559_PuyoPuyo {
	static final int R = 12;
	static final int C = 6;
	static char[][] map = new char[R][C];
	static boolean[][] visited = new boolean[R][C];
	static ArrayDeque<int[]> stack = new ArrayDeque<>();
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int result;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/뿌요뿌요.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 데이터 입력
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		simulation(map, 0);

		System.out.println(result);
	}

	private static void simulation(char[][] map, int cnt) {
		// 순회하면서 터뜨릴 뿌요 찾아서 스택에 저장
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != '.' && !visited[i][j]) { // 뿌요가 있고, 방문 안한 뿌요
					int count = bfs(map, i, j, 1);
					if (count < 4) { // 연속된 뿌요가 4개보다 작을 경우
						while (count-- > 0) {
							stack.pop();
						}
					}
				}
			}
		}

		// 순회했는데 터질 뿌요가 없을 경우
		if (stack.isEmpty()) {
			result = cnt;
			return;
		}

		// 스택에서 꺼내면서 터뜨릴 뿌요 .으로 바꿔주기
		while (!stack.isEmpty()) {
			int[] temp = stack.pop();
			map[temp[0]][temp[1]] = '.';
		}

		// 뿌요 밑으로 내리기
		move(map);

		// 초기화
		stack.clear();
		for (int i = 0; i < R; i++)
			Arrays.fill(visited[i], false);

		simulation(map, cnt + 1);
	}

	private static void move(char[][] map) {
		ArrayDeque<Character> stackChar = new ArrayDeque<>();
		for (int c = 0; c < C; c++) {
			for (int r = 0; r < R; r++) {
				if (map[r][c] != '.') {
					stackChar.push(map[r][c]);
				}
			}
			int size = stackChar.size();
			for (int r = R - 1, s = 0; r > -1; r--, s++) {
				if (s < size) {
					map[r][c] = stackChar.pop();
				} else {
					map[r][c] = '.';
				}
			}
		}
	}

	private static int bfs(char[][] map, int r, int c, int cnt) {
		LinkedList<int[]> queue = new LinkedList<>();
		visited[r][c] = true;
		stack.push(new int[] { r, c });
		queue.offer(new int[] { r, c });
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			r = temp[0];
			c = temp[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || map[nr][nc] != map[r][c])
					continue;

				cnt++;
				visited[nr][nc] = true;
				stack.push(new int[] { nr, nc });
				queue.offer(new int[] { nr, nc });
			}
		}
		return cnt;
	}
}
