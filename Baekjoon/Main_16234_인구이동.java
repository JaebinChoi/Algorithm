

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_16234_인구이동 {
	static int[][] map, copyMap;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, L, R, cnt, sum;
	static boolean[][] visited;
	static ArrayList<int[]> list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		int result = 0;
		while (true) {
			copyMap = new int[N][N];
			visited = new boolean[N][N];

			int condition = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						list = new ArrayList<>();
						list.add(new int[] { i, j });

						cnt = 1;
						sum = map[i][j];
						condition++;

						bfs(i, j);

						int avg = sum / cnt;

						for (int k = 0, size = list.size(); k < size; k++)
							map[list.get(k)[0]][list.get(k)[1]] = avg;

					}
				}
			}
			if (condition == N * N)
				break;

			result++;
		}
		System.out.println(result);
	}

	private static void bfs(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		visited[r][c] = true;
		queue.offer(new int[] { r, c });

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			r = temp[0];
			c = temp[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];

				if (!isIn(nr, nc) || visited[nr][nc])
					continue;

				if (isRange(r, c, nr, nc)) {
					cnt++;
					sum += map[nr][nc];
					list.add(new int[] { nr, nc });
					visited[nr][nc] = true;
					queue.offer(new int[] { nr, nc });
				}
			}
		}
	}

	private static boolean isRange(int r, int c, int nr, int nc) {
		return Math.abs(map[r][c] - map[nr][nc]) >= L && Math.abs(map[r][c] - map[nr][nc]) <= R;
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}
}
