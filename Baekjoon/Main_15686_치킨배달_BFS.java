package staging;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달_BFS {
	static int N, M, sum;
	static int[][] map, dis;
	static boolean[][] visited;
	static ArrayList<int[]> list, pick;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		dis = new int[N][N];

		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2)
					list.add(new int[] { i, j });
			}
		}

		pick = new ArrayList<>();
		combination(0, 0);
		System.out.println(result);
	}

	private static void combination(int cnt, int cur) {
		if (cnt == M) {
			for (int i = 0; i < N; i++)
				Arrays.fill(dis[i], Integer.MAX_VALUE);

			sum = 0;
			for (int i = 0, size = pick.size(); i < size; i++) {
				visited = new boolean[N][N];
				bfs(pick.get(i)[0], pick.get(i)[1], 0);
				result = sum < result ? sum : result;
			}
		}

		for (int i = cur, size = list.size(); i < size; i++) {
			pick.add(list.get(i));
			combination(cnt + 1, i + 1);
			pick.remove(list.get(i));
		}
	}

	private static void bfs(int r, int c, int cnt) {
		LinkedList<int[]> queue = new LinkedList<>();
		visited[r][c] = true;
		queue.offer(new int[] { r, c, cnt });

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			r = temp[0];
			c = temp[1];
			cnt = temp[2];

			if (map[r][c] == 1) { // 집
				if (cnt < dis[r][c]) { // 거리가 더 짧을 경우
					sum += cnt;

					if (dis[r][c] != Integer.MAX_VALUE)
						sum -= dis[r][c];

					dis[r][c] = cnt;
				}
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dir[i][0];
				int nc = c + dir[i][1];

				if (!isIn(nr, nc) || visited[nr][nc])
					continue;

				visited[nr][nc] = true;
				queue.offer(new int[] { nr, nc, cnt + 1 });
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < N && nc < N;
	}
} // class