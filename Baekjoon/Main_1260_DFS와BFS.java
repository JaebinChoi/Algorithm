import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
	static int N, M, V;
	static boolean[][] map;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/AdjMatrix.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new boolean[N + 1][N + 1];
		visit = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			map[r][c] = true;
			map[c][r] = true;

		}

		dfs(V);
		System.out.println();

		Arrays.fill(visit, false);

		bfs(V);

	}

	private static void dfs(int v) {
		visit[v] = true;
		System.out.print(v + " ");
		for (int i = 1; i <= N; i++) {
			if (map[v][i] && !visit[i]) {
				dfs(i);
			}
		}
	}

	private static void bfs(int v) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visit[v] = true;
		queue.offer(v);
		System.out.print(v + " ");
		while (!queue.isEmpty()) {
			v = queue.poll();

			for (int i = 1; i <= N; i++) {
				if (map[v][i] && !visit[i]) {
					visit[i] = true;
					System.out.print(i + " ");
					queue.offer(i);
				}
			}
		}

	}
}
