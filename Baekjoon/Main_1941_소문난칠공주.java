import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/** Combination + BFS */
public class Main_1941_소문난칠공주 {
	static final int N = 5;
	static int result;
	static char[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] pick;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < 25; i++) {
			pick = new boolean[N][N];
			combination(i, 1, 0);
		}

		System.out.println(result);
	}

	private static void combination(int cur, int cnt, int som) {
		int row = cur / N;
		int col = cur % N;
		if (map[row][col] == 'S')
			som++;

		pick[row][col] = true;

		// 탈출조건
		if (cnt == 7) {
			if (som >= 4)
				if (bfs(row, col))
					result += 1;
			pick[row][col] = false;
			return;
		}

		// Combination
		for (int i = cur + 1; i < 25; i++)
			combination(i, cnt + 1, som);

		pick[row][col] = false;
	}

	private static boolean bfs(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		visited[r][c] = true;
		queue.offer(new int[] { r, c });
		int cnt = 1;

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			r = temp[0];
			c = temp[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];

				if (!isIn(nr, nc) || visited[nr][nc] || !pick[nr][nc])
					continue;

				cnt++;
				visited[nr][nc] = true;
				queue.offer(new int[] { nr, nc });
			}
		}

		return cnt == 7 ? true : false;
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}
}