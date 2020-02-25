package backjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 최대 안전영역을 얻기 위해서 물의 높이 1 ~ max - 1까지의 모든 안전영역을 구한 후 그 중 max 값을 찾는다. 1. map과
 * visited 배열을 크기만큼 선언 후 데이터 입력받기 2. 영역의 max값을 찾는다. 3. 물의 높이 1 ~ max-1까지
 * 반복해서안전영역을 dfs 또는 bfs로 찾는다. 3-1. 배열의 행, 열을 반복해서 물보다 높고, 방문하지 않은 영역을 검사 3-1-1.
 * 안전영역개수 늘리고 3-1-2. dfs 또는 bfs 3-2. visit 배열 초기화 3-3. 안전영역 max값 초기화 4. 안전영역
 * max값 출력
 *
 */

public class Main_2468_안전영역 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int max;
	static int maxBoundary;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/안전영역.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}

		for (int height = 0; height < max; height++) {
			int count = 0;
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] <= height)
						visited[i][j] = true;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						count++;
						bfs(i, j);
					}
				}
			}
			maxBoundary = Math.max(maxBoundary, count);
		}
		System.out.println(maxBoundary);
	}

	private static void bfs(int row, int col) {
		LinkedList<int[]> queue = new LinkedList<>();
		visited[row][col] = true;
		queue.offer(new int[] { row, col });
		int r, c, nr, nc;
		int[] temp;

		while (!queue.isEmpty()) {
			temp = queue.poll();
			r = temp[0];
			c = temp[1];

			for (int i = 0; i < 4; i++) {
				nr = r + dir[i][0];
				nc = c + dir[i][1];

				if (nr > -1 && nr < N && nc > -1 && nc < N && !visited[nr][nc]) {
					visited[nr][nc] = true;
					queue.offer(new int[] { nr, nc });
				}
			}
		}
	}

}