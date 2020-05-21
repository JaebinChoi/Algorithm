import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1211_Ladder2 {
	static final int N = 100;
	static int[][] map;
	static boolean[][] visited;
	static int result, min;
	static int[][] dir = {{ 0, -1 }, { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			map = new int[N][N];
			result = Integer.MAX_VALUE;
			br.readLine();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int j = 0; j < N; j++) {
				if (map[0][j] == 1) {
					visited = new boolean[N][N];
					int distance = bfs(0, j);
					if (distance < result) {
						result = distance;
						min = j;
					}
				}
			}
			System.out.println("#" + tc + " " + min);
		}
	}

	private static int bfs(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		visited[r][c] = true;
		queue.offer(new int[] { r, c, 0 });
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			r = temp[0];
			c = temp[1];
			int distance = temp[2];

			if (r == N - 1) {
				return distance;
			}

			for (int i = 0; i < 3; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];

				if (!isIn(nr, nc) || visited[nr][nc] || map[nr][nc] == 0)
					continue;

				visited[nr][nc] = true;
				queue.offer(new int[] { nr, nc, distance + 1 });
				break;
			}
		}
		return -1;
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}

}
